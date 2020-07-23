package vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.UpdatePORequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class RQT00022UpdateDxo {

    private String requestId;

    private String paymentDate;

    private String amount;

    private String priority;

    private String description;

    private String assignedUser;

    private String deadline;

    private String comment;

    private String updater;

    private String subject;

    private String step;

    private String requestStatus;

    private String userApprovedPrev;

    public UpdatePORequest toUpdatePORequest() {
        return BeanUtil.createAndCopyProperties(this, UpdatePORequest.class);
    }
}
