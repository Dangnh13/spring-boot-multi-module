package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;

@Data
public class SearchRequestCommentDxo extends DXO {

    private Integer requestId;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }
}
