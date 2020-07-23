package vn.woodsland.byserp.api.controller.common;


import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.common.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.common.user.request.SearchUserRequest;
import vn.woodsland.byserp.dto.common.user.response.SearchUserResponse;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "User controller")
public class UserController extends AbstractBaseController {

    private final IUserService userService;

    @PostMapping(value = Router.API.USER.SEARCH)
    public ResponseEntity<SearchUserResponse> search(@RequestBody @Valid SearchUserRequest request) {
        return ResponseEntity.ok(new SearchUserResponse(userService.searchUser(request.toDxo())));
    }
}

