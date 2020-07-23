package vn.woodsland.byserp.business.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import vn.woodsland.byserp.business.service.IUserService;
import vn.woodsland.byserp.domain.entity.generator.Users;
import vn.woodsland.byserp.domain.entity.generator.UsersCriteria;
import vn.woodsland.byserp.persistence.dao.generator.UsersMapper;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements IUserService {

	private final UsersMapper usersMapper;

	public UserServiceImpl(UsersMapper usersMapper) {
		this.usersMapper = usersMapper;
	}

	@Override
	public Page<Users> findUser() {
		UsersCriteria criteria = new UsersCriteria();
		/*criteria.createCriteria().andUsernameEqualTo("admin");
		criteria.setOrderByClause("username");*/
		Page<Users> page = PageHelper.startPage(1, 2).doSelectPage(() -> usersMapper.selectByExample(criteria));
		return page;
	}
}
