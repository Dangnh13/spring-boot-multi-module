package vn.woodsland.byserp.web.dto.suggestion.rqt0002.form;

import lombok.Data;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo.RQT0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo.UpdateRequestStatusRQT0002Dxo;

import java.security.Principal;

@Data
public class RQT0002Form {

    private String offset;

    private String requestId;

    // Add to use for update request status
    private String updater;

    private String requestStatus;

    private String assignedUser;

    private String success;

    public RQT0002Dxo toDxo(String username) {
        RQT0002Dxo dxo = BeanUtil.createAndCopyProperties(this, RQT0002Dxo.class);
        dxo.setUsername(username);
        return dxo;
    }

    public UpdateRequestStatusRQT0002Dxo toUpdateRequestStatus(Principal principal) {
        UpdateRequestStatusRQT0002Dxo dxo = BeanUtil.createAndCopyProperties(this, UpdateRequestStatusRQT0002Dxo.class);
        dxo.setRequestStatus(ERequestStatus.CANCEL.code);
        dxo.setAssignedUser(principal.getName());
        return dxo;
    }
}
