package vn.woodsland.byserp.web.dto.common.form;

import lombok.Data;
import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.UpdateRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;

@Data
public class CMN00051Form {

    @RequiredNotBlank
    private String id;

    @RequiredNotBlank
    private String title;

    public SearchRequest toSearchRequestTypeRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchRequest.class);
    }

    public UpdateRequest toUpdateRequestTypeRequest() {
        return BeanUtil.createAndCopyProperties(this, UpdateRequest.class);
    }
}
