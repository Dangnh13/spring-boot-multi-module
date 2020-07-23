package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.dsp.RQT0001Dsp;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.form.RQT0001Form;
import vn.woodsland.byserp.web.service.suggestion.IRQT0001Service;

import java.security.Principal;

@Controller
@Slf4j
public class RQT0001Controller {

    private final IRQT0001Service rqt0001Service;

    public RQT0001Controller(IRQT0001Service rqt0001Service) {
        this.rqt0001Service = rqt0001Service;
    }

    @RequestMapping(Router.SUGGESTION.REQUEST.RQT0001.URI.INIT)
    public String product(Model model, Principal principal) {
        return Router.SUGGESTION.REQUEST.RQT0001.VIEW.INIT;
    }

    @GetMapping(value = Router.SUGGESTION.REQUEST.RQT0001.URI.LOAD_DATA)
    @ResponseBody
    public RQT0001Dsp loadData(RQT0001Form form, Principal principal) {
        return new RQT0001Dsp(rqt0001Service.loadData(form.toRQT0001RequestDxo(principal.getName())));
    }
}
