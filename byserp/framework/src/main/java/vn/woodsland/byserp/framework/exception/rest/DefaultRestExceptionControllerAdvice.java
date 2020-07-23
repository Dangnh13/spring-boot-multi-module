package vn.woodsland.byserp.framework.exception.rest;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorCode;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorResponse;
import vn.woodsland.byserp.framework.exception.rest.type.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSendException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;

/**
 * Handle exceptions across the whole application
 */
public class DefaultRestExceptionControllerAdvice {

    private final IExceptionHandler<ServiceException> serviceExceptionHandler;

    private final IExceptionHandler<BindException> bindExceptionHandler;

    public DefaultRestExceptionControllerAdvice(IExceptionHandler<ServiceException> serviceExceptionHandler,
                                                IExceptionHandler<BindException> bindExceptionHandler) {
        this.serviceExceptionHandler = serviceExceptionHandler;
        this.bindExceptionHandler = bindExceptionHandler;
    }

    @ExceptionHandler({ServiceException.class})
    public ResponseEntity<ErrorResponse> handleServiceException(ServiceException ex) {
        ErrorResponse errorResponse = serviceExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler(MailSendException.class)
    public ResponseEntity<ErrorResponse> handleMailSendException(MailSendException ex) {
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                Arrays.asList(ErrorCode.ESENDMAIL.getErrorCode()));
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

    @ExceptionHandler({
            BindException.class,
    })
    public ResponseEntity<ErrorResponse> handleBindException(BindException ex) {
        ErrorResponse errorResponse = bindExceptionHandler.handle(ex);
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

}
