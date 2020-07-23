package vn.woodsland.byserp.web.service.suggestion;

import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021SearchDxo;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.rst.APR00021SearchRst;

public interface IAPR00021Service {

    APR00021SearchRst search(APR00021SearchDxo dxo);

    void update(APR00021UpdateDxo dxo);

}
