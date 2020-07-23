package vn.woodsland.byserp.web.dto.suggestion.rqt0001.form;

import lombok.Data;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.dxo.RQT0001Dxo;

@Data
public class RQT0001Form {
    
    private String offset;

    public RQT0001Dxo toRQT0001RequestDxo(String username) {
        RQT0001Dxo dxo = BeanUtil.createAndCopyProperties(this, RQT0001Dxo.class);
        dxo.setUsername(username);
        return dxo;
    }
}
