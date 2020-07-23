package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.woodsland.byserp.dto.common.branch.response.SearchResponse;
import vn.woodsland.byserp.framework.enums.ECRUDStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.dto.common.form.CMN00021Form;
import vn.woodsland.byserp.web.service.api.IBranchService;

import javax.validation.Valid;

@Controller
@Slf4j
public class CMN00021Controller {

    private final IBranchService branchService;

    public CMN00021Controller(IBranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping(Router.COMMON.CMN00021.URI.INIT)
    public String init(@Valid @ModelAttribute("cmn00021Form") CMN00021Form form,
                       BindingResult bindingResult) {
        SearchResponse response = branchService.search(form.toSearchBranchRequest());
        if (CollectionUtils.isNotEmpty(response.getRows())) {
            BeanUtil.copyProperties(response.getRows().get(0), form);
        }
        return Router.COMMON.CMN00021.VIEW.INIT;
    }

    @PostMapping(Router.COMMON.CMN00021.URI.UPDATE)
    public String update(@Valid @ModelAttribute("cmn00021Form") CMN00021Form form,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors())
            return Router.COMMON.CMN00021.VIEW.INIT;
        branchService.update(form.toUpdateRequest());
        model.addAttribute(ECRUDStatus.SUCCESS.getCode(), ECRUDStatus.SUCCESS.getLabel());
        return Router.COMMON.CMN00021.VIEW.INIT;
    }
}
