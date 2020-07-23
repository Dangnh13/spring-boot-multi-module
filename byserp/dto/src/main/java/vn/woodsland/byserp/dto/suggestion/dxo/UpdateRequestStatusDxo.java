package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.domain.entity.generator.Request;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.Dates;

@Data
public class UpdateRequestStatusDxo extends DXO {

    private String requestId;

    private String updater;

    private String requestStatus;

    private String assignedUser;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }

    public Request toRequest() {
        Request request = new Request();
        request.setId(Integer.parseInt(requestId));
        request.setRequestStatus(ERequestStatus.atCode(requestStatus).code);
        if(StringUtils.isNotBlank(this.assignedUser)) {
            request.setAssignedUser(this.assignedUser);
        }
        request.setUpdater(updater);
        request.setUpdated(Dates.now());
        return request;
    }
}
