package vn.woodsland.byserp.dto.common.user.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.common.user.prm.SearchUserPrm;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchUserDxo extends DXO {
    private Integer offset;
    private String avoidUsername;
    private Integer departmentId;
    private String username;
    private String email;

    @Override
    public SearchUserPrm toPrm() {
        return BeanUtil.createAndCopyProperties(this, SearchUserPrm.class);
    }
}
