package vn.woodsland.byserp.framework.exception.web.core.webclient;

import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.exception.web.core.ISubmitRequestTypeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class Submit implements ISubmitRequestTypeHandler<WebClientResponseException> {

	@Override
	public ModelAndView dispatcher(WebClientResponseException ex, HttpServletRequest request, HttpServletResponse response) {
		log.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(), ex.getResponseBodyAsString(), ex);
		ModelAndView mav = new ModelAndView();
		mav.setStatus(ex.getStatusCode());
		mav.addObject(CommonConstant.MODEL_ATTRIBUTE.STATUS_CODE, ex.getRawStatusCode());
		mav.addObject(CommonConstant.MODEL_ATTRIBUTE.STACK_TRACE, ex);
		switch (ex.getStatusCode()) {
			case UNAUTHORIZED:
				mav.setViewName(Router.EXCEPTION.URI.UNAUTHORIZED);
				break;
			case FORBIDDEN:
				mav.setViewName(Router.EXCEPTION.URI.FORBIDDEN);
				break;
			default:
				mav.setViewName(Router.EXCEPTION.URI.ERROR);
				break;
		}
		return mav;
	}
}
