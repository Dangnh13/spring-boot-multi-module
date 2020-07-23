package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.SavePaymentOrderDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SavePaymentOrderRequest extends REQUEST {

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

    @Override
    public SavePaymentOrderDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SavePaymentOrderDxo.class);
    }
}
