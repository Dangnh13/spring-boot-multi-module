package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.UpdateRequestStatusDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class UpdateRequestStatusRequest extends REQUEST {

    private String requestId;

    private String updater;

    private String requestStatus;

    private String assignedUser;

    @Override
    public UpdateRequestStatusDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, UpdateRequestStatusDxo.class);
    }
}
