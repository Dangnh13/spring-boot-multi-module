package vn.woodsland.byserp.dto.common.branch.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.common.branch.dxo.UpdateDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

import javax.validation.constraints.NotBlank;

@Data
public class UpdateRequest extends REQUEST {

    @NotBlank
    private String id;

    @NotBlank
    private String branchName;

    @Override
    public UpdateDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, UpdateDxo.class);
    }
}
