package vn.woodsland.byserp.web.controller.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import vn.woodsland.byserp.web.controller.BaseController;
import vn.woodsland.byserp.web.service.api.IBranchService;

@Controller
@Slf4j
public class CMN0004Controller extends BaseController {

    private final IBranchService branchService;

    public CMN0004Controller(IBranchService branchService) {
        this.branchService = branchService;
    }
}
