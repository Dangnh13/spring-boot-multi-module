package vn.woodsland.byserp.web.service.suggestion;


import vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo.APR0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo.UpdateRequestStatusAPR0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.rst.APR0002Rst;

public interface IAPR0002Service {

    APR0002Rst search(APR0002Dxo dxo);

    void updateRequestStatus(UpdateRequestStatusAPR0002Dxo dxo);
}
