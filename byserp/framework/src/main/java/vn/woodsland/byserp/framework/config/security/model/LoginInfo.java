package vn.woodsland.byserp.framework.config.security.model;

import vn.woodsland.byserp.domain.entity.generator.Authorities;
import vn.woodsland.byserp.domain.entity.generator.Users;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
public class LoginInfo implements UserDetails {

	private Users users;
	private List<Authorities> authorities;

	public LoginInfo(Users user, List<Authorities> authorities) {
		this.users = user;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(this.authorities)) {
			this.authorities.stream().map(Authorities::getAuthority).forEach(auth -> grantedAuthorities.add(() -> auth));
		}
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return this.users.getPassword();
	}

	@Override
	public String getUsername() {
		return this.users.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
