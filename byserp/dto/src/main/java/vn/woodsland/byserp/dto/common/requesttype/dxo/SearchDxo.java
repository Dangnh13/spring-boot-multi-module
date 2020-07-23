package vn.woodsland.byserp.dto.common.requesttype.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;

@Data
public class SearchDxo extends DXO {

    private String title;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }
}
