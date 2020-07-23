package vn.woodsland.byserp.web.service.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.dto.suggestion.request.SearchTimeOffRequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchTimeOffRequestResponse;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.util.RequestUtil;
import vn.woodsland.byserp.web.service.api.ITimeOffRequestService;

@Service
public class TimeOffRequestServiceImpl implements ITimeOffRequestService {

    private final WebClient webClient;

    public TimeOffRequestServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public SearchTimeOffRequestResponse searchTimeOffRequest(SearchTimeOffRequest request) {
        Mono<SearchTimeOffRequestResponse> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.TIME_OFF_REQUEST.SEARCH))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SearchTimeOffRequestResponse.class);
        return retrievedResource.block();
    }
}
