package vn.woodsland.byserp.dto.common.branch.request;

import lombok.Data;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.common.branch.dxo.CreateDxo;
import vn.woodsland.byserp.framework.util.BeanUtil;

import javax.validation.constraints.NotBlank;

@Data
public class CreateRequest extends REQUEST {

    @NotBlank
    private String branchName;

    @Override
    public CreateDxo toDxo() {
        return BeanUtil.createAndCopyProperties(this, CreateDxo.class);
    }
}
