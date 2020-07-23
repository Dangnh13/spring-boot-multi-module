package vn.woodsland.byserp.api.exception;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.DefaultRestExceptionControllerAdvice;
import vn.woodsland.byserp.framework.exception.rest.type.ServiceException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionControllerAdvice extends DefaultRestExceptionControllerAdvice {


    public ExceptionControllerAdvice(IExceptionHandler<ServiceException> serviceExceptionHandler,
                                     IExceptionHandler<BindException> bindExceptionHandler) {
        super(serviceExceptionHandler, bindExceptionHandler);
    }
}
