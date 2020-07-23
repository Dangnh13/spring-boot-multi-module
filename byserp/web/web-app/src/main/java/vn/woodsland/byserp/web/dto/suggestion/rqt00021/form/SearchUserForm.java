package vn.woodsland.byserp.web.dto.suggestion.rqt00021.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo.SearchUserDxo;

import java.security.Principal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchUserForm {

    private String avoidUsername;
    private String departmentId;
    private String username;
    private String email;

    public SearchUserDxo toDxo(Principal principal) {
        this.avoidUsername = principal.getName();
        return BeanUtil.createAndCopyProperties(this, SearchUserDxo.class);
    }
}
