package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.common.user.request.SearchUserRequest;
import vn.woodsland.byserp.dto.common.user.response.SearchUserResponse;

public interface IUserService {

    SearchUserResponse searchUser(SearchUserRequest request);

}
