package vn.woodsland.byserp.dto.common.branch.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;

@Data
public class SearchDxo extends DXO {

    private String id;

    private String branchName;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }
}
