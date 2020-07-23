package vn.woodsland.byserp.api.controller.suggestion;

import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.suggestion.IRequestCommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.suggestion.request.SearchPaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchRequestCommentRequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Request comment controller")
public class RequestCommentController extends AbstractBaseController {

    private final IRequestCommentService requestCommentService;

    @PostMapping(value = Router.API.REQUEST_COMMENT.SEARCH)
    public ResponseEntity<SearchRequestCommentResponse> searchPaymentOrder(@RequestBody @Valid SearchRequestCommentRequest request) {
        SearchRequestCommentResponse response = new SearchRequestCommentResponse(requestCommentService.search(request.toDxo()));
        return ResponseEntity.ok(response);
    }
}