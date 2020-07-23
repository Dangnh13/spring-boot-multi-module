package vn.woodsland.byserp.dto.base.rst;

import vn.woodsland.byserp.dto.base.response.RESPONSE;

public abstract class RST {

    public abstract <T extends RESPONSE> T toResponse();
}
