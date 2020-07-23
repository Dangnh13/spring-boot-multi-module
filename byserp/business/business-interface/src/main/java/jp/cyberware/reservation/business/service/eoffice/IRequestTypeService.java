package jp.cyberware.reservation.business.service.eoffice;

import com.github.pagehelper.Page;
import vn.woodsland.byserp.domain.entity.generator.RequestType;
import vn.woodsland.byserp.dto.common.requesttype.dxo.CreateDxo;
import vn.woodsland.byserp.dto.common.requesttype.dxo.SearchDxo;
import vn.woodsland.byserp.dto.common.requesttype.dxo.UpdateDxo;

public interface IRequestTypeService {
    void create(CreateDxo dxo);

    Page<RequestType> search(SearchDxo dxo);

    void update(UpdateDxo dxo);
}
