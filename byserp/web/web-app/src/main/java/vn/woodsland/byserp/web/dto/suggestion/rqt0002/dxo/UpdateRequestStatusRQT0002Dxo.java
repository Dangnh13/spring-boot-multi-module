package vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.UpdateRequestStatusRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class UpdateRequestStatusRQT0002Dxo {

    private String requestId;

    private String updater;

    private String requestStatus;

    private String assignedUser;

    public UpdateRequestStatusRequest toUpdateRequestStatusRequest() {
        return BeanUtil.createAndCopyProperties(this, UpdateRequestStatusRequest.class);
    }
}
