package vn.woodsland.byserp.dto.common.requesttype.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.common.requesttype.dxo.SearchDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchRequest extends REQUEST {

    private String id;

    private String title;

    @Override
    public SearchDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, SearchDxo.class);
    }
}
