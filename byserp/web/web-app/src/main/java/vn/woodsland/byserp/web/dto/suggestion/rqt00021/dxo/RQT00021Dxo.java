package vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.SavePaymentOrderRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class RQT00021Dxo {

    private String requestTypeId;
    private String priority;
    private String description;
    private String deadline;
    private String subject;
    private String requestStatus;
    private String step;
    private String assignedUser;
    private String creator;
    private String updated;
    private String amount;
    private String paymentDate;
    private String userApprovedPrev;

    public SavePaymentOrderRequest toSavePaymentOrderRequest() {
        return BeanUtil.createAndCopyProperties(this, SavePaymentOrderRequest.class);
    }
}
