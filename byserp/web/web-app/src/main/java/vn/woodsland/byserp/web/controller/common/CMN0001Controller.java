package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.web.constant.Router;

import java.security.Principal;

@Controller
@Slf4j
public class CMN0001Controller {

    @RequestMapping(Router.COMMON.CMN0001.URI.INIT)
    public String product(Model model, Principal principal) {
        return Router.COMMON.CMN0001.VIEW.INIT;
    }

}
