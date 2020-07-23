package vn.woodsland.byserp.framework.exception.rest.type;

import com.google.common.collect.Lists;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

/**
 * Throw ServiceException in Service layer
 */
@Data
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1570238093095848448L;

	private final HttpStatus httpStatus;

	private final List<String> errorCodes;

	public ServiceException(HttpStatus httpStatus) {
		this(httpStatus, StringUtils.EMPTY, Collections.emptyList());
	}

	public ServiceException(HttpStatus httpStatus, String message) {
		this(httpStatus, message, Collections.emptyList());
	}

	public ServiceException(HttpStatus httpStatus, String message, String errorCode) {
		this(httpStatus, message, Lists.newArrayList(errorCode));
	}

	public ServiceException(HttpStatus httpStatus, String message, List<String> errorCodes) {
		super(message);
		this.httpStatus = httpStatus;
		this.errorCodes = errorCodes;
	}
}
