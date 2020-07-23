package vn.woodsland.byserp.web.service.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.dto.suggestion.request.SearchRequestCommentRequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.util.RequestUtil;
import vn.woodsland.byserp.web.service.api.IRequestCommentService;

@Service
public class RequestCommentServiceImpl implements IRequestCommentService {

    private final WebClient webClient;

    public RequestCommentServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public SearchRequestCommentResponse search(SearchRequestCommentRequest request) {
        Mono<SearchRequestCommentResponse> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.REQUEST_COMMENT.SEARCH))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SearchRequestCommentResponse.class);
        return retrievedResource.block();
    }
}
