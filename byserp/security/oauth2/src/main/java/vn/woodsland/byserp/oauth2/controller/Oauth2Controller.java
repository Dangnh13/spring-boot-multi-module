package vn.woodsland.byserp.oauth2.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.woodsland.byserp.framework.constant.Router;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@Slf4j
@Data
public class Oauth2Controller {

    private final ConsumerTokenServices consumerTokenServices;

    private final ResourceServerTokenServices resourceServerTokenServices;

    public Oauth2Controller(ConsumerTokenServices consumerTokenServices,
                            ResourceServerTokenServices resourceServerTokenServices) {
        this.consumerTokenServices = consumerTokenServices;
        this.resourceServerTokenServices = resourceServerTokenServices;
    }

    @GetMapping(Router.OAUTH2.URI.LOGIN)
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            Model model) {
        model.addAttribute("error", error);
        return Router.OAUTH2.VIEW.LOGIN;
    }

    @GetMapping(Router.OAUTH2.URI.LOGOUT)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        new SecurityContextLogoutHandler().logout(request, null, null);
        String referer = request.getParameter("referer");
        response.sendRedirect(referer);
    }

    @GetMapping("/revoke/{tokenId}")
    @ResponseBody
    public boolean revokeToken(HttpServletRequest request, @PathVariable String tokenId) {
        boolean result = false;
       /* String tokenValue = tokenId;
        if (StringUtils.isBlank(tokenId)) {
            String authHeader = request.getHeader("Authorization");
            tokenValue = authHeader.replace("Bearer", StringUtils.EMPTY).trim();
        }*/
        String authHeader = request.getHeader("Authorization");
        String tokenValue = authHeader.replace("Bearer", StringUtils.EMPTY).trim();
        if (StringUtils.isNotBlank(tokenValue)) {
            OAuth2AccessToken accessToken = resourceServerTokenServices.readAccessToken(tokenValue);
            log.info("revoke access token {} ", accessToken);
            result = consumerTokenServices.revokeToken(accessToken.getValue());
        }
        return result;
    }

    /**
     * Sử dụng khi yêu cầu là mỗi request web client cần check xem token hợp lệ hay không
     * PS: Nếu không call /ping api thì web client có thể thoải mái sử dụng web app vì thực sự
     * không có việc check token phía client đang nắm giữ
     *
     * @return trả về trạng thái ping
     */
    @GetMapping(Router.OAUTH2.URI.PING)
    @ResponseBody
    public String ping() {
        return "ok";
    }
}
