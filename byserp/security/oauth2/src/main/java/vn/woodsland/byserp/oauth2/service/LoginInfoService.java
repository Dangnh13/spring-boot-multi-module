package vn.woodsland.byserp.oauth2.service;

import vn.woodsland.byserp.domain.entity.generator.Authorities;
import vn.woodsland.byserp.domain.entity.generator.AuthoritiesCriteria;
import vn.woodsland.byserp.domain.entity.generator.Users;
import vn.woodsland.byserp.framework.config.security.model.LoginInfo;
import vn.woodsland.byserp.persistence.dao.generator.AuthoritiesMapper;
import vn.woodsland.byserp.persistence.dao.generator.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LoginInfoService implements UserDetailsService {

	// Instance variables
	// ------------------------------------------------------------------------

	private final UsersMapper usersMapper;
	private final AuthoritiesMapper authoritiesMapper;

	// Constructors
	// ------------------------------------------------------------------------

	public LoginInfoService(UsersMapper usersMapper, AuthoritiesMapper authoritiesMapper) {
		this.usersMapper = usersMapper;
		this.authoritiesMapper = authoritiesMapper;
	}

	// Overrided methods
	// ------------------------------------------------------------------------
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersMapper.selectByPrimaryKey(username);
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Username {} not found", username));
		}
		AuthoritiesCriteria authoritiesCriteria = new AuthoritiesCriteria();
		authoritiesCriteria
				.createCriteria()
				.andUsernameEqualTo(username);

		List<Authorities> authorities = authoritiesMapper.selectByExample(authoritiesCriteria);
		return new LoginInfo(user, authorities);
	}
}