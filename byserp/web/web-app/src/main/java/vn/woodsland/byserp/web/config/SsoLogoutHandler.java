package vn.woodsland.byserp.web.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
@Qualifier("ssoLogoutHandler")
public class SsoLogoutHandler implements LogoutHandler {

    @Autowired
    private OAuth2AuthorizedClientService clientService;

    @Autowired
    private WebClient webClient;

    @Override
    public void logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) {

        if (authentication.getClass().isAssignableFrom(OAuth2AuthenticationToken.class)) {
            OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;
            String clientRegistrationId = oauthToken.getAuthorizedClientRegistrationId();
            OAuth2AuthorizedClient client = clientService.loadAuthorizedClient(clientRegistrationId,
                    oauthToken.getName());
            String accessToken = client.getAccessToken().getTokenValue();
            boolean result = webClient.get()
                    .uri("/auth/revoke/" + accessToken)
                    .retrieve()
                    .bodyToMono(Boolean.class).block();
            if (result) {
                log.info("Revoke success token: {}", accessToken);
            }
        }
    }
}
