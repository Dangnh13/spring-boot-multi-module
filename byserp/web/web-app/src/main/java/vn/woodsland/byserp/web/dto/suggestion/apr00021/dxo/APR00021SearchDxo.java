package vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.SearchPaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchRequestCommentRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class APR00021SearchDxo {

    private String requestId;

    public SearchPaymentOrderRequest toSearchPaymentOrderRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchPaymentOrderRequest.class);
    }

    public SearchRequestCommentRequest toSearchRequestCommentRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchRequestCommentRequest.class);
    }
}
