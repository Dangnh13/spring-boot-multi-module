package vn.woodsland.byserp.web.dto.suggestion.apr00021.rst;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class APR00021SearchRst {

    private PaymentOrderData paymentOrderData;

    private List<Comment> comments;

    public APR00021SearchRst(SearchPaymentOrderResponse response, SearchRequestCommentResponse requestCommentResponse) {
        if (CollectionUtils.isNotEmpty(response.getRows())) {
            paymentOrderData = BeanUtil.createAndCopyProperties(response.getRows().get(0), PaymentOrderData.class);
        }
        
        if (CollectionUtils.isNotEmpty(requestCommentResponse.getRows())) {
            comments = requestCommentResponse.getRows().stream()
                    .map(e -> BeanUtil.createAndCopyProperties(e, Comment.class))
                    .collect(Collectors.toList());
        }
    }

    @Data
    public static class PaymentOrderData extends SearchPaymentOrderResponse.ItemData {

    }

    @Data
    public static class Comment extends SearchRequestCommentResponse.ItemData {

    }
}
