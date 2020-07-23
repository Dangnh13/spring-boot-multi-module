package vn.woodsland.byserp.dto.common.user.prm;

import lombok.Data;
import vn.woodsland.byserp.dto.base.prm.PRM;

@Data
public class SearchUserPrm extends PRM {
    private String avoidUsername;
    private Integer departmentId;
    private String username;
    private String email;
}
