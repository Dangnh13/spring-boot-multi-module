package vn.woodsland.byserp.web.service.suggestion;

import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo.RQT0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo.UpdateRequestStatusRQT0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.rst.RQT0002Rst;

public interface IRQT0002Service {
    RQT0002Rst loadData(RQT0002Dxo dxo);

    void delete(UpdateRequestStatusRQT0002Dxo dxo);
}
