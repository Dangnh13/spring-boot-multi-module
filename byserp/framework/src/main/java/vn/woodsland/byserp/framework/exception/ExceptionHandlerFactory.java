package vn.woodsland.byserp.framework.exception;


import vn.woodsland.byserp.framework.exception.web.core.AbstractExceptionHandlerFactory;
import vn.woodsland.byserp.framework.exception.web.core.unknown.UnknownWebClientFactory;
import vn.woodsland.byserp.framework.exception.web.core.webclient.WebClientFactory;
import org.springframework.web.reactive.function.client.WebClientResponseException;

public class ExceptionHandlerFactory {

	private ExceptionHandlerFactory() {
	}

	public static AbstractExceptionHandlerFactory getFactory(Exception ex) {
		if (ex instanceof WebClientResponseException) {
			return new WebClientFactory();
		}
		return new UnknownWebClientFactory();
	}
}
