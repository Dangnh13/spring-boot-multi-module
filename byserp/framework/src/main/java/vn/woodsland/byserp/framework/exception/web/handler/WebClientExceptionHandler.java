package vn.woodsland.byserp.framework.exception.web.handler;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
public class WebClientExceptionHandler implements IExceptionHandler<WebClientResponseException> {

}
