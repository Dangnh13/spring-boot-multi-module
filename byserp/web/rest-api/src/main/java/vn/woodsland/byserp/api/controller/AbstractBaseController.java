package vn.woodsland.byserp.api.controller;

import vn.woodsland.byserp.dto.base.Envelope;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.base.response.RESPONSE;
import vn.woodsland.byserp.dto.base.response.Void;
import vn.woodsland.byserp.dto.base.rst.RST;
import vn.woodsland.byserp.framework.controller.IBaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.util.function.Function;

@Slf4j
public abstract class AbstractBaseController implements IBaseController {

	private <REQ extends REQUEST, RES extends RESPONSE, XO extends DXO, RS extends RST> ResponseEntity<RES> bindingResult(REQ request, Function<XO, RS> method) {
		ResponseEntity<RES> responseEntity = new Envelope<RES>(method.apply(request.toDxo()).toResponse()).toResponseEntity();
		if (responseEntity.getBody() instanceof Void) {
			return new ResponseEntity(responseEntity.getStatusCode());
		}
		return responseEntity;
	}

	protected <REQ extends REQUEST, RES extends RESPONSE, XO extends DXO, RS extends RST> ResponseEntity<RES> resultOf(REQ request, Function<XO, RS> method) {
		return bindingResult(request, method);
	}

}
