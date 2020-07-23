package vn.woodsland.byserp.web.interceptor;

import vn.woodsland.byserp.web.config.userservice.CustomOAuth2User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Sử dụng để ping lên server check token phía web client có hợp lệ hay không
 * PS: Nếu có yêu cầu mới sử dụng
 */
@SuppressWarnings("unused")
//@Component
@Slf4j
public class CheckTokenValidInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private WebClient webClient;

	@Autowired
	private OAuth2AuthorizedClientService clientService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null
				&& authentication.getPrincipal() != null
				&& authentication.getPrincipal() instanceof CustomOAuth2User) {

			String clientId = ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId();
			OAuth2AuthorizedClient oAuth2AuthorizedClient = clientService.loadAuthorizedClient(clientId, authentication.getName());
			String accessToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
			Mono<String> retrievedResource = webClient.get()
					.uri("/auth/ping")
					.retrieve()
					.bodyToMono(String.class);
			log.info(retrievedResource.block());
		}

		return true;
	}
}
