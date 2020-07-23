package vn.woodsland.byserp.dto.common.user.request;

import lombok.Data;
import vn.woodsland.byserp.dto.common.user.dxo.SearchUserDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchUserRequest extends SearchUserDxo {

    public SearchUserDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SearchUserDxo.class);
    }
}
