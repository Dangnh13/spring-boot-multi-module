package vn.woodsland.byserp.web.dto.common.form;

import lombok.Data;
import vn.woodsland.byserp.dto.common.branch.request.SearchRequest;
import vn.woodsland.byserp.dto.common.branch.request.UpdateRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class CMN00021Form {
    private String id;
    private String branchName;

    public SearchRequest toSearchBranchRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchRequest.class);
    }

    public UpdateRequest toUpdateRequest() {
        return BeanUtil.createAndCopyProperties(this, UpdateRequest.class);
    }

}
