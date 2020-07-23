package vn.woodsland.byserp.framework.exception.web.core.webclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorCode;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorResponse;
import vn.woodsland.byserp.framework.exception.web.core.IAjaxRequestTypeHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Ajax implements IAjaxRequestTypeHandler<WebClientResponseException> {

	@SneakyThrows
	@Override
	public void dispatcher(WebClientResponseException ex, HttpServletRequest request, HttpServletResponse response) {
		log.error("Error from WebClient - Status {}, Body {}", ex.getRawStatusCode(), ex.getResponseBodyAsString(), ex);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(ex.getRawStatusCode());
		List<String> errorCodes = new ArrayList<>();
		switch (ex.getStatusCode()) {
			case UNAUTHORIZED:
				errorCodes.add(ErrorCode.EUNAUTHORIZED.getErrorCode());
				break;
			case FORBIDDEN:
				errorCodes.add(ErrorCode.EPERM.getErrorCode());
				break;
			default:
				errorCodes.add(ErrorCode.EUNKNOWN.getErrorCode());
				break;
		}
		PrintWriter writer = response.getWriter();
		writer.write((new ObjectMapper()).writeValueAsString(
				ErrorResponse.of(HttpStatus.valueOf(ex.getRawStatusCode()),
						ex.getMessage(),
						errorCodes)));
		writer.flush();
		writer.close();
	}
}
