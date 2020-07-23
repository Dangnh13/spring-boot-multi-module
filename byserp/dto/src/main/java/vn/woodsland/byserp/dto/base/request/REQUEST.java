package vn.woodsland.byserp.dto.base.request;

import vn.woodsland.byserp.dto.base.dxo.DXO;

public abstract class REQUEST {

    public abstract <T extends DXO> T toDxo();
}
