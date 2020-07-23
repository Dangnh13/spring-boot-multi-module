package vn.woodsland.byserp.framework.exception.web.core.unknown;

import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.constant.Router;
import vn.woodsland.byserp.framework.exception.web.core.ISubmitRequestTypeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class Submit implements ISubmitRequestTypeHandler<Exception> {

	@Override
	public ModelAndView dispatcher(Exception ex,
	                               HttpServletRequest request,
	                               HttpServletResponse response) {
		log.error("Error from Unknown - detail: {}", ex);
		ModelAndView mav = new ModelAndView();
		mav.addObject(CommonConstant.MODEL_ATTRIBUTE.STACK_TRACE, ex);
		mav.setViewName(Router.EXCEPTION.URI.ERROR);
		return mav;
	}
}
