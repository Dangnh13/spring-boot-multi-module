package vn.woodsland.byserp.business.service;

import com.github.pagehelper.Page;
import vn.woodsland.byserp.domain.entity.generator.Users;
import vn.woodsland.byserp.framework.business.service.IBaseService;

public interface IUserService extends IBaseService {
	Page<Users> findUser();
}
