package vn.woodsland.byserp.web.service.suggestion;

import vn.woodsland.byserp.web.dto.suggestion.rqt0001.dxo.RQT0001Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.rst.RQT0001Rst;

public interface IRQT0001Service {
    RQT0001Rst loadData(RQT0001Dxo dxo);
}
