package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchTimeOffRequestDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchTimeOffRequest extends REQUEST {

    private String username;

    protected Integer offset;

    @Override
    public SearchTimeOffRequestDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SearchTimeOffRequestDxo.class);
    }
}
