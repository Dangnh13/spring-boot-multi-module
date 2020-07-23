package vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.SearchPaymentOrderRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class RQT0002Dxo {
    private String offset;
    private String username;

    public SearchPaymentOrderRequest toPaymentOrderRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchPaymentOrderRequest.class);
    }
}
