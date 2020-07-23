package vn.woodsland.byserp.web.dto.suggestion.apr0002.form;

import lombok.Data;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo.APR0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo.UpdateRequestStatusAPR0002Dxo;

import java.security.Principal;

@Data
public class APR0002Form {

    private String offset;

    /** Using for update request status */
    private String requestId;

    /** Using for update request status */
    private String requestStatus;

    private String success;

    public UpdateRequestStatusAPR0002Dxo toUpdateRequestStatusAPR0002Dxo(Principal principal) {
        UpdateRequestStatusAPR0002Dxo dxo = BeanUtil.createAndCopyProperties(this, UpdateRequestStatusAPR0002Dxo.class);
        dxo.setUpdater(principal.getName());
        return dxo;
    }

    public APR0002Dxo toDxo(String assignedUser) {
        APR0002Dxo dxo = BeanUtil.createAndCopyProperties(this, APR0002Dxo.class);
        dxo.setAssignedUser(assignedUser);
        return dxo;
    }

}
