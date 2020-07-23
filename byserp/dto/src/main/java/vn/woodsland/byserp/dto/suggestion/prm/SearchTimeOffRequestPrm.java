package vn.woodsland.byserp.dto.suggestion.prm;

import lombok.Data;
import vn.woodsland.byserp.dto.base.prm.PRM;

@Data
public class SearchTimeOffRequestPrm extends PRM {
    private String username;
}
