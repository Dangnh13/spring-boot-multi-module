package vn.woodsland.byserp.dto.common.branch.dxo;

import lombok.Data;
import vn.woodsland.byserp.domain.entity.generator.Branch;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.framework.util.BeanUtil;

@Data
public class UpdateDxo extends DXO {

    private String id;

    private String branchName;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }

    public Branch toEntity() {
        return BeanUtil.createAndCopyProperties(this, Branch.class);
    }
}
