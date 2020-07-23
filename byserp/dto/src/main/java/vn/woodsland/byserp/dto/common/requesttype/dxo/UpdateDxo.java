package vn.woodsland.byserp.dto.common.requesttype.dxo;

import lombok.Data;
import vn.woodsland.byserp.domain.entity.generator.RequestType;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class UpdateDxo extends DXO {

    private String id;

    private String title;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }

    public RequestType toEntity() {
        return BeanUtil.createAndCopyProperties(this, RequestType.class);
    }
}
