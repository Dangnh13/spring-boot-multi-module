package vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo;

import lombok.Data;
import vn.woodsland.byserp.dto.common.user.request.SearchUserRequest;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.form.SearchUserForm;

@Data
public class SearchUserDxo extends SearchUserForm {

    public SearchUserRequest toSearchUserRequest() {
        return BeanUtil.createAndCopyProperties(this, SearchUserRequest.class);
    }

}
