package vn.woodsland.byserp.business.service.impl.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jp.cyberware.reservation.business.service.common.IUserService;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.domain.modal.common.SearchUserModal;
import vn.woodsland.byserp.dto.common.user.dxo.SearchUserDxo;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.util.PageUtil;
import vn.woodsland.byserp.persistence.dao.custom.common.CustomUserMapper;

@Service
public class UserServiceImpl implements IUserService {

    private final CustomUserMapper customUserMapper;

    public UserServiceImpl(CustomUserMapper customUserMapper) {
        this.customUserMapper = customUserMapper;
    }

    @Override
    public Page<SearchUserModal> searchUser(SearchUserDxo dxo) {
        int offset = PageUtil.getOffsetPage(dxo.getOffset());
        int pageSize = (dxo.getOffset() == null) ? offset : CommonConstant.PAGING.PAGE_SIZE;
        Page<SearchUserModal> result = PageHelper.offsetPage(offset, pageSize)
                .doSelectPage(() ->
                        customUserMapper.searchUser(dxo.toPrm()));
        return result;
    }
}
