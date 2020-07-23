package vn.woodsland.byserp.web.service.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.dto.suggestion.request.SavePaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchPOApprovedRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchPaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.UpdatePORequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchPOApprovedResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.util.RequestUtil;
import vn.woodsland.byserp.web.service.api.IPaymentOrderService;

@Service
public class PaymentOrderServiceImpl implements IPaymentOrderService {

    private final WebClient webClient;

    public PaymentOrderServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public SearchPaymentOrderResponse searchPaymentOrder(SearchPaymentOrderRequest request) {
        Mono<SearchPaymentOrderResponse> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.PAYMENT_ORDER.SEARCH))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SearchPaymentOrderResponse.class);
        return retrievedResource.block();
    }

    @Override
    public SearchPOApprovedResponse searchPOApproved(SearchPOApprovedRequest request) {
        Mono<SearchPOApprovedResponse> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.PAYMENT_ORDER.SEARCH_APPROVED))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(SearchPOApprovedResponse.class);
        return retrievedResource.block();
    }

    @Override
    public void save(SavePaymentOrderRequest request) {
        Mono<Void> retrievedResource = webClient.post()
                .uri(RequestUtil.getStandardUriOf(Router.API.PAYMENT_ORDER.SAVE))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class);
        retrievedResource.block();
    }

    @Override
    public void updatePO(UpdatePORequest request) {
        Mono<Void> retrievedResource = webClient.put()
                .uri(RequestUtil.getStandardUriOf(Router.API.PAYMENT_ORDER.UPDATE))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(Void.class);
        retrievedResource.block();
    }
}
