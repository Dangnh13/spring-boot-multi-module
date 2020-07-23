package vn.woodsland.byserp.web.service.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.dto.common.user.request.SearchUserRequest;
import vn.woodsland.byserp.dto.common.user.response.SearchUserResponse;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.util.RequestUtil;
import vn.woodsland.byserp.web.service.api.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private final WebClient webClient;

    public UserServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public SearchUserResponse searchUser(SearchUserRequest request) {
        Mono<SearchUserResponse> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.USER.SEARCH))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SearchUserResponse.class);
        return retrievedResource.block();
    }


}
