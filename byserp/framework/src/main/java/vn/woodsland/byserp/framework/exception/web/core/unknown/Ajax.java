package vn.woodsland.byserp.framework.exception.web.core.unknown;

import com.fasterxml.jackson.databind.ObjectMapper;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorCode;
import vn.woodsland.byserp.framework.exception.rest.model.ErrorResponse;
import vn.woodsland.byserp.framework.exception.web.core.IAjaxRequestTypeHandler;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Slf4j
public class Ajax implements IAjaxRequestTypeHandler<Exception> {

	@SneakyThrows
	@Override
	public void dispatcher(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		log.error("Error from Unknown - detail: {}", ex);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		PrintWriter writer = response.getWriter();
		writer.write((new ObjectMapper()).writeValueAsString(
				ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR,
						ex.getMessage(),
						Arrays.asList(ErrorCode.EUNKNOWN.getErrorCode()))));
		writer.flush();
		writer.close();
	}
}
