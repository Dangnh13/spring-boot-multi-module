package vn.woodsland.byserp.web.service.suggestion;

import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo.RQT00021Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo.SearchUserDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.rst.SearchUserRst;

public interface IRQT00021Service {
    SearchUserRst searchUser(SearchUserDxo dxo);
    void save(RQT00021Dxo dxo);
}
