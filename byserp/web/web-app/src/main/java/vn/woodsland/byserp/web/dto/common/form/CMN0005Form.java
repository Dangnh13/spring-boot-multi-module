package vn.woodsland.byserp.web.dto.common.form;

import lombok.Data;
import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class CMN0005Form {

    private String id;

    private String title;

    public SearchRequest toSearchCreateType() {
        return BeanUtil.createAndCopyProperties(this, SearchRequest.class);
    }
}
