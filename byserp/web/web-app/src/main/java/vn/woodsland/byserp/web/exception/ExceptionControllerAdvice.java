package vn.woodsland.byserp.web.exception;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.web.DefaultWebExceptionControllerAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.core.OAuth2AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class ExceptionControllerAdvice extends DefaultWebExceptionControllerAdvice {

	private final IExceptionHandler<WebClientResponseException> webClientExceptionHandler;

	public ExceptionControllerAdvice(
			@Qualifier("unknownExceptionHandler") IExceptionHandler unknownExceptionHandler,
			@Qualifier("webClientExceptionHandler") IExceptionHandler<WebClientResponseException> webClientExceptionHandler) {
		super(unknownExceptionHandler);
		this.webClientExceptionHandler = webClientExceptionHandler;
	}

	@ExceptionHandler(WebClientResponseException.class)
	public ModelAndView handleWebClientResponseException(WebClientResponseException ex,
	                                                     HttpServletRequest request,
	                                                     HttpServletResponse response) {
		return webClientExceptionHandler.handle(request, response, ex);
	}

	@ExceptionHandler(value = OAuth2AuthorizationException.class)
	public ModelAndView oAuth2ExceptionHandler(HttpServletRequest req,
	                                           OAuth2AuthorizationException e,
	                                           HttpServletResponse response) {
		return unknownExceptionHandler.handle(req, response, e);
	}
}
