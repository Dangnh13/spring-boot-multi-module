package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.framework.enums.ECRUDStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.form.APR0002Form;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.form.APR00021Form;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.rst.APR00021SearchRst;
import vn.woodsland.byserp.web.service.suggestion.IAPR00021Service;
import vn.woodsland.byserp.web.validator.APR00021Validator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class APR00021Controller extends BaseController {

    private final IAPR00021Service apr00021Service;

    private final APR00021Validator apr00021Validator;

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(apr00021Validator);
    }

    public APR00021Controller(IAPR00021Service apr00021Service, APR00021Validator apr00021Validator) {
        this.apr00021Service = apr00021Service;
        this.apr00021Validator = apr00021Validator;
    }

    @RequestMapping(Router.SUGGESTION.APPROVED.APR00021.URI.INIT)
    public String init(@ModelAttribute("apr00021Form") APR00021Form form, Model model, Principal principal) {
        APR00021SearchRst rst = apr00021Service.search(form.toDxo());
        form.setUpdateData(rst);
        return Router.SUGGESTION.APPROVED.APR00021.VIEW.INIT;
    }

    @PostMapping(Router.SUGGESTION.APPROVED.APR00021.URI.UPDATE)
    public String update(@Valid @ModelAttribute("apr00021Form") APR00021Form form,
                         BindingResult bindingResult,
                         HttpServletRequest request,
                         Model model,
                         Principal principal) {
        if (bindingResult.hasErrors()) {
            APR00021SearchRst rst = apr00021Service.search(form.toDxo());
            APR00021Form tempForm = new APR00021Form();
            tempForm.setUpdateData(rst);

            // Keep data
            form.setData(BeanUtil.createAndCopyProperties(tempForm.getData(), APR00021Form.UpdateData.class));

            return Router.SUGGESTION.APPROVED.APR00021.VIEW.INIT;
        }
        apr00021Service.update(form.toUpdateRequestDxo(principal));
        APR0002Form apr0002Form = new APR0002Form();
        apr0002Form.setSuccess(ECRUDStatus.SUCCESS.label);

        saveRequestData(request, apr0002Form);
        return redirect(Router.SUGGESTION.APPROVED.APR0002.URI.INIT);
    }

    @ModelAttribute("apr00021Form")
    public APR00021Form setUpForm() {
        APR00021Form apr00021Form = new APR00021Form();
        return apr00021Form;
    }

}
