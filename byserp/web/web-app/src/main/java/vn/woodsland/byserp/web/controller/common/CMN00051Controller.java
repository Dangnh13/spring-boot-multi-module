package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;
import vn.woodsland.byserp.framework.enums.ECRUDStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.dto.common.form.CMN00051Form;
import vn.woodsland.byserp.web.service.api.IRequestTypeService;
import vn.woodsland.byserp.web.service.common.ICMN00051Service;

import javax.validation.Valid;

@Controller
@Slf4j
public class CMN00051Controller {

    private final ICMN00051Service icmn00051Service;

    private final IRequestTypeService requestTypeService;

    public CMN00051Controller(ICMN00051Service icmn00051Service, IRequestTypeService requestTypeService) {
        this.icmn00051Service = icmn00051Service;
        this.requestTypeService = requestTypeService;
    }

    @RequestMapping(Router.COMMON.CMN00051.URI.INIT)
    public String init(@ModelAttribute("cmn00051Form") CMN00051Form form, BindingResult bindingResult) {
        SearchResponse.ItemData res = icmn00051Service.findByRequestTypeId(form.toSearchRequestTypeRequest());
        if (res != null) {
            BeanUtil.copyProperties(res, form);
        }
        return Router.COMMON.CMN00051.VIEW.INIT;
    }

    @PostMapping(Router.COMMON.CMN00051.URI.UPDATE)
    public String update(@Valid @ModelAttribute("cmn00051Form") CMN00051Form form,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors())
            return Router.COMMON.CMN00051.VIEW.INIT;
        requestTypeService.update(form.toUpdateRequestTypeRequest());
        model.addAttribute(ECRUDStatus.SUCCESS.getCode(), ECRUDStatus.SUCCESS.getLabel());
        return Router.COMMON.CMN00051.VIEW.INIT;
    }

}
