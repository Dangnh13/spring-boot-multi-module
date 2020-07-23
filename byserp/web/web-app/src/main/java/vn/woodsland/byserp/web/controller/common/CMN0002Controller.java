package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vn.woodsland.byserp.dto.common.branch.response.SearchResponse;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.dto.common.form.CMN00021Form;
import vn.woodsland.byserp.web.dto.common.form.CMN0002Form;
import vn.woodsland.byserp.web.service.api.IBranchService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
@Slf4j
public class CMN0002Controller extends BaseController {

    private final IBranchService branchService;

    public CMN0002Controller(IBranchService branchService) {
        this.branchService = branchService;
    }

    @RequestMapping(Router.COMMON.CMN0002.URI.INIT)
    public String init(Model model, Principal principal) {
        return Router.COMMON.CMN0002.VIEW.INIT;
    }

    @GetMapping(value = Router.COMMON.CMN0002.URI.LOAD_DATA)
    @ResponseBody
    public SearchResponse loadData(@Valid CMN0002Form form,
                                   BindingResult bindingResult) {

        return branchService.search(form.toSearchBranchRequest());
    }

    @GetMapping(value = Router.COMMON.CMN0002.URI.UPDATE_BRANCH)
    public String updateBranch(@Valid CMN0002Form form,
                               BindingResult bindingResult,
                               HttpServletRequest request) {
        saveRequestData(request, BeanUtil.createAndCopyProperties(form, CMN00021Form.class));
        return redirect(Router.COMMON.CMN00021.URI.INIT);
    }
}
