package vn.woodsland.byserp.dto.suggestion.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchRequestCommentDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchRequestCommentRequest extends REQUEST {

    private String requestId;

    @Override
    public SearchRequestCommentDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SearchRequestCommentDxo.class);
    }
}
