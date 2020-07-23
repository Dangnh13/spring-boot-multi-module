package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.woodsland.byserp.framework.enums.ECRUDStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.form.RQT0002Form;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dsp.SearchUserDsp;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.form.RQT00021Form;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.form.SearchUserForm;
import vn.woodsland.byserp.web.service.suggestion.IRQT00021Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class RQT00021Controller extends BaseController {

    private final IRQT00021Service rqt00021Service;

    public RQT00021Controller(IRQT00021Service rqt00021Service) {
        this.rqt00021Service = rqt00021Service;
    }

    @RequestMapping(Router.SUGGESTION.REQUEST.RQT00021.URI.INIT)
    public String init(@ModelAttribute("rqt00021Form") RQT00021Form form, Model model, Principal principal) {
        return Router.SUGGESTION.REQUEST.RQT00021.VIEW.INIT;
    }

    @PostMapping(Router.SUGGESTION.REQUEST.RQT00021.URI.SAVE)
    public String save(@Valid @ModelAttribute("rqt00021Form") RQT00021Form form,
                       BindingResult bindingResult,
                       HttpServletRequest request,
                       Model model,
                       Principal principal) {
        if (bindingResult.hasErrors()) {
            return Router.SUGGESTION.REQUEST.RQT00021.VIEW.INIT;
        }
        rqt00021Service.save(form.toDxo(principal));
        RQT0002Form rqt0002Form = new RQT0002Form();
        rqt0002Form.setSuccess(ECRUDStatus.SUCCESS.label);
        saveRequestData(request, rqt0002Form);
        return redirect(Router.SUGGESTION.REQUEST.RQT0002.URI.INIT);
    }

    @PostMapping(Router.SUGGESTION.REQUEST.RQT00021.URI.SEARCH_USER)
    @ResponseBody
    public SearchUserDsp searchUser(SearchUserForm form, Principal principal) {

        return new SearchUserDsp(
                rqt00021Service.searchUser(form.toDxo(principal)));
    }

    @ModelAttribute("rqt00021Form")
    public RQT00021Form setUpForm() {
        RQT00021Form form = new RQT00021Form();
        return form;
    }
}
