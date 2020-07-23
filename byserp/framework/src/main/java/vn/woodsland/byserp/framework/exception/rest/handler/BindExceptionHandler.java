package vn.woodsland.byserp.framework.exception.rest.handler;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorCode;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Handling of BindException
 */
@Slf4j
public class BindExceptionHandler implements IExceptionHandler<BindException> {

    @Override
    public ErrorResponse handle(BindException exception) {
        log.error(exception.getMessage(), exception);
        Map<String, Object> validationErrors = new LinkedHashMap<>();

        exception.getBindingResult().getFieldErrors()
                .forEach(error -> {
                    Object rejectValue = !(error.getRejectedValue() instanceof MultipartFile) ? error.getRejectedValue() : StringUtils.EMPTY;
                    validationErrors.put(error.getField(), new ErrorResponse.ItemError(rejectValue, error.getDefaultMessage()));
                });

        return ErrorResponse.of(HttpStatus.BAD_REQUEST, "Validate error", Arrays.asList(ErrorCode.EINVAL.getErrorCode()), validationErrors);
    }

}
