package vn.woodsland.byserp.web.dto.common.form;

import lombok.Data;
import vn.woodsland.byserp.dto.common.branch.request.SearchRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;

@Data
public class CMN0002Form {

    @RequiredNotBlank
    private String id;

    private String branchName;

    public SearchRequest toSearchBranchRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchRequest.class);
    }
}
