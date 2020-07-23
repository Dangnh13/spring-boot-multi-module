package vn.woodsland.byserp.dto.base.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.base.prm.PRM;

@Data
public abstract class DXO {

    public abstract <T extends PRM> T toPrm();

}
