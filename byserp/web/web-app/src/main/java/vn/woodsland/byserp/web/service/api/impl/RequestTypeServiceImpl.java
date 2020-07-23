package vn.woodsland.byserp.web.service.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.dto.common.requesttype.request.CreateRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.UpdateRequest;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.util.RequestUtil;
import vn.woodsland.byserp.web.service.api.IRequestTypeService;

@Service
public class RequestTypeServiceImpl implements IRequestTypeService {

    private final WebClient webClient;

    public RequestTypeServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public SearchResponse search(SearchRequest request) {
        Mono<SearchResponse> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.REQUEST_TYPE.SEARCH))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SearchResponse.class);
        return retrievedResource.block();
    }

    @Override
    public void update(UpdateRequest request) {
        Mono<Void> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.REQUEST_TYPE.UPDATE))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class);
        retrievedResource.block();
    }

    @Override
    public void create(CreateRequest request) {
        Mono<Void> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.REQUEST_TYPE.CREATE))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class);
        retrievedResource.block();
    }
}
