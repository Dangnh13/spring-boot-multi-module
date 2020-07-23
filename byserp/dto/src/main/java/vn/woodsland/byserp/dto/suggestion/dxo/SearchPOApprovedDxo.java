package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.suggestion.prm.SearchPOApprovedPrm;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchPOApprovedDxo extends DXO {

    private String assignedUser;

    private Integer offset;

    @Override
    public SearchPOApprovedPrm toPrm() {
        return BeanUtil.createAndCopyProperties(this, SearchPOApprovedPrm.class);
    }
}
