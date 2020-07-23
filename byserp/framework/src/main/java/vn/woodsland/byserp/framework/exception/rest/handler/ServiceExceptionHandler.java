package vn.woodsland.byserp.framework.exception.rest.handler;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorResponse;
import vn.woodsland.byserp.framework.exception.rest.type.ServiceException;
import lombok.extern.slf4j.Slf4j;

/**
 * Handling service exception
 */
@Slf4j
public class ServiceExceptionHandler implements IExceptionHandler<ServiceException> {

    @Override
    public ErrorResponse handle(ServiceException exception) {
        log.error(exception.getMessage(), exception);
        return ErrorResponse.of(exception.getHttpStatus(), exception.getMessage(), exception.getErrorCodes());
    }
}
