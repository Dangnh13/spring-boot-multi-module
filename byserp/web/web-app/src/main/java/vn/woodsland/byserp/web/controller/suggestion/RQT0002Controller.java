package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dsp.RQT0002Dsp;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.form.RQT0002Form;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.form.RQT00022Form;
import vn.woodsland.byserp.web.service.suggestion.IRQT0002Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class RQT0002Controller extends BaseController {

    private final IRQT0002Service rqt0002Service;

    public RQT0002Controller(IRQT0002Service rqt0002Service) {
        this.rqt0002Service = rqt0002Service;
    }

    @RequestMapping(Router.SUGGESTION.REQUEST.RQT0002.URI.INIT)
    public String product(@ModelAttribute("rqt0002Form") RQT0002Form form, Model model, Principal principal) {
        return Router.SUGGESTION.REQUEST.RQT0002.VIEW.INIT;
    }

    @GetMapping(value = Router.SUGGESTION.REQUEST.RQT0002.URI.LOAD_DATA)
    @ResponseBody
    public RQT0002Dsp loadData(RQT0002Form form, Principal principal) {
        return new RQT0002Dsp(rqt0002Service.loadData(form.toDxo(principal.getName())));
    }

    @PostMapping(Router.SUGGESTION.REQUEST.RQT0002.URI.UPDATE)
    public String update(@Valid RQT0002Form form,
                         BindingResult bindingResult,
                         HttpServletRequest request) {
        saveRequestData(request, BeanUtil.createAndCopyProperties(form, RQT00022Form.class));
        return redirect(Router.SUGGESTION.REQUEST.RQT00022.URI.INIT);
    }

    @PostMapping(Router.SUGGESTION.REQUEST.RQT0002.URI.DELETE)
    public String delete(@Valid RQT0002Form form,
                         BindingResult bindingResult,
                         HttpServletRequest request,
                         Principal principal) {
        rqt0002Service.delete(form.toUpdateRequestStatus(principal));
        return Router.SUGGESTION.REQUEST.RQT0002.VIEW.INIT;
    }

    @ModelAttribute("rqt0002Form")
    public RQT0002Form setUpForm() {
        RQT0002Form rqt0002Form = new RQT0002Form();
        return rqt0002Form;
    }
}
