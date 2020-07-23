package jp.cyberware.reservation.business.service.suggestion;

import vn.woodsland.byserp.dto.suggestion.dxo.UpdateRequestStatusDxo;

public interface IRequestService {
    void updateRequestStatus(UpdateRequestStatusDxo dxo);
}
