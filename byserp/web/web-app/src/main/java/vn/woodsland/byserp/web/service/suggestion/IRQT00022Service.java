package vn.woodsland.byserp.web.service.suggestion;

import vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo.RQT00022SearchForUpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo.RQT00022UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.rst.RQT00022SearchForUpdateRst;

public interface IRQT00022Service {

    RQT00022SearchForUpdateRst searchForUpdate(RQT00022SearchForUpdateDxo dxo);

    void update(RQT00022UpdateDxo dxo);
}
