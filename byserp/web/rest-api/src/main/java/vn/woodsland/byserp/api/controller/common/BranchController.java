package vn.woodsland.byserp.api.controller.common;


import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.common.IBranchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.common.branch.request.CreateRequest;
import vn.woodsland.byserp.dto.common.branch.request.SearchRequest;
import vn.woodsland.byserp.dto.common.branch.request.UpdateRequest;
import vn.woodsland.byserp.dto.common.branch.response.SearchResponse;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Branch controller")
public class BranchController extends AbstractBaseController {

    private final IBranchService branchService;

    @PostMapping(value = Router.API.BRANCH.SEARCH)
    public ResponseEntity<SearchResponse> search(@RequestBody @Valid SearchRequest request) {
        return ResponseEntity.ok(new SearchResponse(branchService.search(request.toDxo())));
    }

    @PostMapping(value = Router.API.BRANCH.CREATE)
    public ResponseEntity<Void> create(@RequestBody @Valid CreateRequest request) {
        branchService.create(request.toDxo());
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = Router.API.BRANCH.UPDATE)
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateRequest request) {
        branchService.update(request.toDxo());
        return ResponseEntity.ok().build();
    }
}

