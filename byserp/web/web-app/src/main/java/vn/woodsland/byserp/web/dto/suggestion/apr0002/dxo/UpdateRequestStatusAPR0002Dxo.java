package vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.UpdateRequestStatusRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class UpdateRequestStatusAPR0002Dxo {

    private String requestId;

    private String requestStatus;

    private String updater;

    public UpdateRequestStatusRequest toUpdateRequestStatusRequest() {
        return BeanUtil.createAndCopyProperties(this, UpdateRequestStatusRequest.class);
    }
}
