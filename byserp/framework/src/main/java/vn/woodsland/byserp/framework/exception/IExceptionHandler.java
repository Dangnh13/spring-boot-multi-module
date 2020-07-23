package vn.woodsland.byserp.framework.exception;

import vn.woodsland.byserp.framework.exception.rest.model.ErrorResponse;
import vn.woodsland.byserp.framework.exception.web.core.AbstractExceptionHandlerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Interface for system;s exceptions
 *
 * @param <T> which extends Exception
 */
public interface IExceptionHandler<T extends Exception> {

	Log log = LogFactory.getLog(IExceptionHandler.class);

	String AJAX_REQUEST_HEADER_KEY = "X-Requested-With";
	String AJAX_REQUEST_HEADER_VALUE = "XMLHttpRequest";

	/**
	 * Handle exception behavior
	 *
	 * @param exception which extends Exception
	 * @return error response {@link ErrorResponse}
	 */
	default ErrorResponse handle(T exception) {
		return ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), null);
	}

	default ModelAndView handle(HttpServletRequest request,
	                            HttpServletResponse response,
	                            T ex) {
		String requestedWithHeader = request.getHeader(AJAX_REQUEST_HEADER_KEY);
		AbstractExceptionHandlerFactory factory = ExceptionHandlerFactory.getFactory(ex);
		if (!AJAX_REQUEST_HEADER_VALUE.equals(requestedWithHeader)) {
			return factory.submitRequestTypeHandler().dispatcher(ex, request, response);
		}
		factory.ajaxRequestTypeHandler().dispatcher(ex, request, response);
		return null;
	}

}