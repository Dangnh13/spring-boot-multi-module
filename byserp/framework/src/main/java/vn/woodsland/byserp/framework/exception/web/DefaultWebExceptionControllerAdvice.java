package vn.woodsland.byserp.framework.exception.web;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handle exceptions across the whole application
 */
public class DefaultWebExceptionControllerAdvice {

	protected final IExceptionHandler unknownExceptionHandler;

	public DefaultWebExceptionControllerAdvice(IExceptionHandler unknownExceptionHandler) {
		this.unknownExceptionHandler = unknownExceptionHandler;
	}

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req,
	                                        HttpServletResponse res,
	                                        Exception e) {
		return unknownExceptionHandler.handle(req, res, e);
	}

}
