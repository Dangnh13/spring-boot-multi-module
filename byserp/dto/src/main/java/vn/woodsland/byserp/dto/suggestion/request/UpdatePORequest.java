package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.UpdatePODxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

import javax.validation.constraints.NotBlank;

@Data
public class UpdatePORequest extends REQUEST {

    @NotBlank
    private String requestId;

    private String paymentDate;

    private String amount;

    @NotBlank
    private String priority;

    @NotBlank
    private String description;

    private String requestStatus;

    @NotBlank
    private String assignedUser;

    private String step;

    private String deadline;

    @NotBlank
    private String updater;

    private String comment;

    private String subject;

    private String userApprovedPrev;

    @Override
    public UpdatePODxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, UpdatePODxo.class);
    }
}
