package vn.woodsland.byserp.oauth2.controller;


import vn.woodsland.byserp.framework.constant.Router;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserInfoController {

	@GetMapping(Router.OAUTH2.URI.USER_INFO)
	public Map<String, Object> user(Principal principal) {
		Map<String, Object> map = new LinkedHashMap<>();
		if (principal != null) {
			map.put("name", principal.getName());
			if (principal instanceof OAuth2Authentication) {
				OAuth2Authentication oauth = (OAuth2Authentication) principal;
				map.put("authorities", oauth.getUserAuthentication().getAuthorities()
						.stream()
						.map(GrantedAuthority::getAuthority)
						.collect(Collectors.toList()));
			}
		}
		return map;
	}

}
