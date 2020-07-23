package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchPaymentOrderDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchPaymentOrderRequest extends REQUEST {

    /** Creator - The people create request record */
    private String username;

    private String requestId;

    private String assignedUser;

    protected Integer offset;

    @Override
    public SearchPaymentOrderDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SearchPaymentOrderDxo.class);
    }
}
