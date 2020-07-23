package vn.woodsland.byserp.api.controller.common;

import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.eoffice.IRequestTypeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.common.requesttype.request.CreateRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.UpdateRequest;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Request type controller")
public class RequestTypeController extends AbstractBaseController {

    private final IRequestTypeService requestTypeService;

    @PostMapping(value = Router.API.REQUEST_TYPE.CREATE)
    public ResponseEntity<Void> create(@RequestBody @Valid CreateRequest request) {
        requestTypeService.create(request.toDxo());
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = Router.API.REQUEST_TYPE.SEARCH)
    public ResponseEntity<SearchResponse> search(@RequestBody @Valid SearchRequest request) {
        return ResponseEntity.ok(new SearchResponse(requestTypeService.search(request.toDxo())));
    }

    @PostMapping(value = Router.API.REQUEST_TYPE.UPDATE)
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateRequest request) {
        requestTypeService.update(request.toDxo());
        return ResponseEntity.ok().build();
    }
}

