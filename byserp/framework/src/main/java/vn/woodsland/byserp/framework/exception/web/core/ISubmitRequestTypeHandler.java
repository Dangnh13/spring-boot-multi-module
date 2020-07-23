package vn.woodsland.byserp.framework.exception.web.core;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ISubmitRequestTypeHandler<T extends Exception> {
	ModelAndView dispatcher(T ex, HttpServletRequest request, HttpServletResponse response);
}
