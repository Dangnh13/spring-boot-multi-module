package vn.woodsland.byserp.web.dto.suggestion.rqt00022.rst;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.util.Dates;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RQT00022SearchForUpdateRst {

    private PaymentOrderData paymentOrderData;

    private List<Comment> comments;

    public RQT00022SearchForUpdateRst(SearchPaymentOrderResponse response, SearchRequestCommentResponse requestCommentResponse) {
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

        private String deadlineFormat;

        private String paymentDateFormat;

        public String getPaymentDateFormat() {
            return Dates.format(this.getPaymentDate(), CommonConstant.DATE_FORMAT.DD_MM_YYYY);
        }

        public String getDeadlineFormat() {
            return Dates.format(this.getDeadline(), CommonConstant.DATE_FORMAT.DD_MM_YYYY_HH_MM_SLASH);
        }
    }

    @Data
    public static class Comment extends SearchRequestCommentResponse.ItemData {

    }
}
