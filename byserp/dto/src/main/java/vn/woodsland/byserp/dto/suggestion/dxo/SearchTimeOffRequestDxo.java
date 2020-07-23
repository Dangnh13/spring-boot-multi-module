package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.dto.suggestion.prm.SearchTimeOffRequestPrm;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class SearchTimeOffRequestDxo extends DXO {

    private String username;

    private Integer offset;

    public SearchTimeOffRequestPrm toSearchTimeOffRequestPrm() {
        return BeanUtil.createAndCopyProperties(this, SearchTimeOffRequestPrm.class);
    }

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }
}
