package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.suggestion.prm.SearchPaymentOrderPrm;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchPaymentOrderDxo extends DXO {

    private String username;

    private String requestId;

    private String assignedUser;

    private Integer offset;

    @Override
    public SearchPaymentOrderPrm toPrm() {
        return BeanUtil.createAndCopyProperties(this, SearchPaymentOrderPrm.class);
    }
}
