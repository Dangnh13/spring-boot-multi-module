package vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.UpdatePORequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class APR00021UpdateDxo {

    private String requestId;

    private String priority;

    private String description;

    private String requestStatus;

    private Short step;

    private String assignedUser;

    private String updater;

    private String comment;

    private String userApprovedPrev;

    public UpdatePORequest toUpdatePORequest() {
        return BeanUtil.createAndCopyProperties(this, UpdatePORequest.class);
    }
}
