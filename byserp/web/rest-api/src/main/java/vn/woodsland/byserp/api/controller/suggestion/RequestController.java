package vn.woodsland.byserp.api.controller.suggestion;

import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.suggestion.IRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.suggestion.request.UpdateRequestStatusRequest;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Request controller")
public class RequestController extends AbstractBaseController {

    private final IRequestService requestService;

    @PostMapping(value = Router.API.REQUEST.UPDATE_REQUEST_STATUS)
    public ResponseEntity<Void> updateRequestStatus(@RequestBody @Valid UpdateRequestStatusRequest request) {
        requestService.updateRequestStatus(request.toDxo());
        return ResponseEntity.ok().build();
    }
}

