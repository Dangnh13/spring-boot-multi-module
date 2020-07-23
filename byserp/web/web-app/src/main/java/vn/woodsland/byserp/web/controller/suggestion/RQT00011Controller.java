package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.dto.suggestion.rqt00011.form.RQT00011Form;
import vn.woodsland.byserp.web.service.suggestion.IRQT0001Service;

import java.security.Principal;

@Controller
@Slf4j
public class RQT00011Controller {

    private final IRQT0001Service rqt0001Service;

    public RQT00011Controller(IRQT0001Service rqt0001Service) {
        this.rqt0001Service = rqt0001Service;
    }

    @RequestMapping(Router.SUGGESTION.REQUEST.RQT00011.URI.INIT)
    public String product(Model model, Principal principal) {
        return Router.SUGGESTION.REQUEST.RQT00011.VIEW.INIT;
    }

    @ModelAttribute
    public RQT00011Form setUpForm() {
        RQT00011Form form = new RQT00011Form();
        return form;
    }

}
