package jp.cyberware.reservation.business.service.common;

import com.github.pagehelper.Page;
import vn.woodsland.byserp.domain.modal.common.SearchUserModal;
import vn.woodsland.byserp.dto.common.user.dxo.SearchUserDxo;
import vn.woodsland.byserp.framework.business.service.IBaseService;

public interface IUserService extends IBaseService {

    Page<SearchUserModal> searchUser(SearchUserDxo dxo);

}
