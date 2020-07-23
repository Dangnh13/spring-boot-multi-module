package vn.woodsland.byserp.web.dto.suggestion.rqt0001.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.suggestion.request.SearchTimeOffRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class RQT0001Dxo {
    private String offset;
    private String username;

    public SearchTimeOffRequest toSearchTimeOffRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchTimeOffRequest.class);
    }
}
