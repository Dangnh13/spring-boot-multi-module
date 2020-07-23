package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.dsp.APR0002Dsp;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.form.APR0002Form;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.form.APR00021Form;
import vn.woodsland.byserp.web.service.suggestion.IAPR0002Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@Slf4j
public class APR0002Controller extends BaseController {

    private final IAPR0002Service apr0002Service;

    public APR0002Controller(IAPR0002Service apr0002Service) {
        this.apr0002Service = apr0002Service;
    }

    @RequestMapping(Router.SUGGESTION.APPROVED.APR0002.URI.INIT)
    public String product(Model model, Principal principal) {
        return Router.SUGGESTION.APPROVED.APR0002.VIEW.INIT;
    }

    @GetMapping(value = Router.SUGGESTION.APPROVED.APR0002.URI.LOAD_DATA)
    @ResponseBody
    public APR0002Dsp loadData(@ModelAttribute("apr0002Form") APR0002Form form, Principal principal) {
        return new APR0002Dsp(apr0002Service.search(form.toDxo(principal.getName())));
    }

    @PostMapping(value = Router.SUGGESTION.APPROVED.APR0002.URI.UPDATE_REQUEST_STATUS)
    public String updateRequestStatus(@ModelAttribute("apr0002Form") APR0002Form form, Principal principal) {
        apr0002Service.updateRequestStatus(form.toUpdateRequestStatusAPR0002Dxo(principal));
        return Router.SUGGESTION.APPROVED.APR0002.VIEW.INIT;
    }

    @PostMapping(value = Router.SUGGESTION.APPROVED.APR0002.URI.UPDATE)
    public String update(@ModelAttribute("apr0002Form") APR0002Form form, HttpServletRequest request, Principal principal) {
        saveRequestData(request, BeanUtil.createAndCopyProperties(form, APR00021Form.class));
        return redirect(Router.SUGGESTION.APPROVED.APR00021.URI.INIT);
    }

    @ModelAttribute("apr0002Form")
    public APR0002Form setUpForm() {
        APR0002Form apr0002Form = new APR0002Form();
        return apr0002Form;
    }

}
