package vn.woodsland.byserp.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.service.IWebService;

import java.security.Principal;

@Controller
@Slf4j
public class LoginController {

    private final IWebService webService;

    public LoginController(IWebService webService) {
        this.webService = webService;
    }

    @RequestMapping(Router.CONTEXT_ROOT)
    public String index(Model model, Principal principal) {
        if (principal != null) {
            return "redirect:" + Router.COMMON.CMN0001.URI.INIT;
        }
        return "redirect:" + "/oauth2/authorization/web-client";
    }
    
    @RequestMapping(vn.woodsland.byserp.framework.constant.Router.OAUTH2.URI.LOGIN)
    public String login(Principal principal) {
        if (principal != null) {
            return "redirect:" + Router.COMMON.CMN0001.URI.INIT;
        }
        return "redirect:" + "/oauth2/authorization/web-client";
    }


}
