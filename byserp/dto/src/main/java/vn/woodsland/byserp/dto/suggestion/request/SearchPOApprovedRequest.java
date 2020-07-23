package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchPOApprovedDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchPOApprovedRequest extends REQUEST {

    private String assignedUser;

    protected Integer offset;

    @Override
    public SearchPOApprovedDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SearchPOApprovedDxo.class);
    }
}
