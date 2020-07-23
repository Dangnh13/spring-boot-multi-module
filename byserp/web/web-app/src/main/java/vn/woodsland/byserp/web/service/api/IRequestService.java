package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.suggestion.request.UpdateRequestStatusRequest;

public interface IRequestService {

    void updateRequestStatus(UpdateRequestStatusRequest request);
}
