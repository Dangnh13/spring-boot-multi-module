package jp.cyberware.reservation.business.service.common;

import com.github.pagehelper.Page;
import vn.woodsland.byserp.domain.entity.generator.Branch;
import vn.woodsland.byserp.dto.common.branch.dxo.CreateDxo;
import vn.woodsland.byserp.dto.common.branch.dxo.SearchDxo;
import vn.woodsland.byserp.dto.common.branch.dxo.UpdateDxo;
import vn.woodsland.byserp.framework.business.service.IBaseService;

public interface IBranchService extends IBaseService {

    Page<Branch> search(SearchDxo dxo);

    void create(CreateDxo dxo);

    void update(UpdateDxo dxo);
}
