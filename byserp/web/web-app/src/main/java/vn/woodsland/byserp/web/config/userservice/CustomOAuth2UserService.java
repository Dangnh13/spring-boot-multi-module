package vn.woodsland.byserp.web.config.userservice;

import vn.woodsland.byserp.framework.constant.CommonConstant;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.List;
import java.util.Map;

public class CustomOAuth2UserService extends DefaultOAuth2UserService {

	private static final String KEY_MAP_AUTHORITIES = "authorities";

	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		OAuth2User oAuth2User = super.loadUser(userRequest);
		List<GrantedAuthority> grantedAuthorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(asAuthorities(oAuth2User.getAttributes(), userRequest));
		CustomOAuth2User customOAuth2User = new CustomOAuth2User(grantedAuthorityList, oAuth2User.getAttributes());
		customOAuth2User.setName(oAuth2User.getName());
		return customOAuth2User;
	}

	private String asAuthorities(Map<String, Object> map, OAuth2UserRequest userRequest) {
		List<String> authorities = (List<String>) map.get(KEY_MAP_AUTHORITIES);
		OAuth2AccessToken token = userRequest.getAccessToken();
		for (String authority : token.getScopes()) {
			authorities.add("SCOPE_" + authority.toUpperCase());
		}
		return String.join(CommonConstant.SYMBOL.COMMA_SYMBOL, authorities);
	}
}
