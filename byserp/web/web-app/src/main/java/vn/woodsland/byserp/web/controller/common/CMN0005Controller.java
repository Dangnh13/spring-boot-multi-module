package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.common.form.CMN00051Form;
import vn.woodsland.byserp.web.dto.common.form.CMN0005Form;
import vn.woodsland.byserp.web.service.api.IRequestTypeService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class CMN0005Controller extends BaseController {

    private final IRequestTypeService requestTypeService;

    public CMN0005Controller(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }

    @RequestMapping(Router.COMMON.CMN0005.URI.INIT)
    public String init(Model model, Principal principal) {
        return Router.COMMON.CMN0005.VIEW.INIT;
    }

    @GetMapping(value = Router.COMMON.CMN0005.URI.LOAD_DATA)
    @ResponseBody
    public SearchResponse loadData(@Valid CMN0005Form form,
                                   BindingResult bindingResult) {

        return requestTypeService.search(form.toSearchCreateType());
    }

    @GetMapping(value = Router.COMMON.CMN0005.URI.UPDATE_REQUEST_TYPE)
    public String update(@Valid CMN0005Form form,
                         BindingResult bindingResult,
                         HttpServletRequest request) {
        saveRequestData(request, BeanUtil.createAndCopyProperties(form, CMN00051Form.class));
        return redirect(Router.COMMON.CMN00051.URI.INIT);
    }
}
