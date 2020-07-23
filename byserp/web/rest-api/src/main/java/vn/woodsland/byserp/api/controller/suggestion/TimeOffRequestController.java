package vn.woodsland.byserp.api.controller.suggestion;

import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.suggestion.ITimeOffRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.suggestion.request.SearchTimeOffRequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchTimeOffRequestResponse;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Time off request controller")
public class TimeOffRequestController extends AbstractBaseController {

    private final ITimeOffRequestService timeOffRequestService;

    @PostMapping(value = Router.API.TIME_OFF_REQUEST.SEARCH)
    public ResponseEntity<SearchTimeOffRequestResponse> searchTimeOffRequest(@RequestBody @Valid SearchTimeOffRequest request) {
        SearchTimeOffRequestResponse response = new SearchTimeOffRequestResponse(timeOffRequestService.searchTimeOffRequest(request.toDxo()));
        return ResponseEntity.ok(response);
    }
}

