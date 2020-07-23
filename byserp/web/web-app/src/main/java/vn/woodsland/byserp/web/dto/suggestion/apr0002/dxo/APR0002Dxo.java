package vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.SearchPOApprovedRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class APR0002Dxo {
    private String offset;
    private String assignedUser;

    public SearchPOApprovedRequest toSearchPOApprovedRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchPOApprovedRequest.class);
    }
}
