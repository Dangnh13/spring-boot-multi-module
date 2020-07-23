package vn.woodsland.byserp.web.controller.suggestion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.framework.enums.ECRUDStatus;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.form.RQT0002Form;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.form.RQT00022Form;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.rst.RQT00022SearchForUpdateRst;
import vn.woodsland.byserp.web.service.suggestion.IRQT00022Service;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class RQT00022Controller extends BaseController {

    private final IRQT00022Service rqt00022Service;

    public RQT00022Controller(IRQT00022Service rqt00022Service) {
        this.rqt00022Service = rqt00022Service;
    }

    @RequestMapping(Router.SUGGESTION.REQUEST.RQT00022.URI.INIT)
    public String init(@ModelAttribute("rqt00022Form") RQT00022Form form, Model model, Principal principal) {
        RQT00022SearchForUpdateRst rst = rqt00022Service.searchForUpdate(form.toDxo());
        form.setUpdateData(rst);
        return Router.SUGGESTION.REQUEST.RQT00022.VIEW.INIT;
    }

    @RequestMapping(Router.SUGGESTION.REQUEST.RQT00022.URI.UPDATE)
    public String update(@Valid @ModelAttribute("rqt00022Form") RQT00022Form form,
                         BindingResult bindingResult,
                         HttpServletRequest request,
                         Model model,
                         Principal principal) {
        if (bindingResult.hasErrors()) {
            RQT00022SearchForUpdateRst rst = rqt00022Service.searchForUpdate(form.toDxo());
            RQT00022Form tempForm = new RQT00022Form();
            tempForm.setUpdateData(rst);

            // Keep data
            RQT00022Form formState = BeanUtil.createAndCopyProperties(form, RQT00022Form.class);
            form.setData(BeanUtil.createAndCopyProperties(tempForm.getData(), RQT00022Form.UpdateData.class));
            BeanUtil.copyProperties(formState.getData(), form.getData());

            return Router.SUGGESTION.REQUEST.RQT00022.VIEW.INIT;
        }
        rqt00022Service.update(form.toUpdateRequestDxo(principal));
        RQT0002Form rqt0002Form = new RQT0002Form();
        rqt0002Form.setSuccess(ECRUDStatus.SUCCESS.label);

        saveRequestData(request, rqt0002Form);
        return redirect(Router.SUGGESTION.REQUEST.RQT0002.URI.INIT);
    }

    @ModelAttribute("rqt00022Form")
    public RQT00022Form setUpForm() {
        RQT00022Form form = new RQT00022Form();
        return form;
    }
}
