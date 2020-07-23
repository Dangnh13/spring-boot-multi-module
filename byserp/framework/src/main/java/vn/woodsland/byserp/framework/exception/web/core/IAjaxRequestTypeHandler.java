package vn.woodsland.byserp.framework.exception.web.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IAjaxRequestTypeHandler<T extends Exception> {
	void dispatcher(T ex, HttpServletRequest request, HttpServletResponse response);
}
