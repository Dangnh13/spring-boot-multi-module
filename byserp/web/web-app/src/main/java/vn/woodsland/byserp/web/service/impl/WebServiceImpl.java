package vn.woodsland.byserp.web.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import vn.woodsland.byserp.web.service.IWebService;

@Service
public class WebServiceImpl implements IWebService {

    private final WebClient webClient;

    public WebServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public String getData() {
        Mono<String> retrievedResource = webClient.get()
                .uri("/auth/sql")
                .retrieve()
                .bodyToMono(String.class);
        return retrievedResource.block();
    }
}
