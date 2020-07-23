package vn.woodsland.byserp.web.service.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.dto.suggestion.request.UpdateRequestStatusRequest;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.util.RequestUtil;
import vn.woodsland.byserp.web.service.api.IRequestService;

@Service
public class RequestServiceImpl implements IRequestService {

    private final WebClient webClient;

    public RequestServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public void updateRequestStatus(UpdateRequestStatusRequest request) {
        Mono<Void> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.REQUEST.UPDATE_REQUEST_STATUS))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class);
        retrievedResource.block();
    }
}
