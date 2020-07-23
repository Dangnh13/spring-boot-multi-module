package vn.woodsland.byserp.api.controller.inventory;

import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.business.service.IMailService;
import vn.woodsland.byserp.business.service.IUserService;
import vn.woodsland.byserp.domain.entity.generator.Users;
import vn.woodsland.byserp.dto.inventory.request.SendMailRequest;
import vn.woodsland.byserp.dto.inventory.response.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

/**
 * List of apis electronic passport registration
 *
 * NOTE: Một cách khác để check quyền truy cập: https://programmer.ink/think/spring-boot-spring-security-thymeleaf-simple-tutorial.html
 * @author Ominext's memner
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "PersonnelController")
public class PersonnelController extends AbstractBaseController {

	// =========================================================================
	//                                                                Constant
	//                                                                ==========

	// =========================================================================
	//                                                                DI
	//                                                                ==========

	/**
	 * Mail services
	 */
	private final IMailService mailService;

//	private final IUserService userService;

	// =========================================================================
	//                                                                Property
	//                                                                ==========

	// =========================================================================
	//                                                                Public method
	//                                                                ==========

	/**
	 * API 009
	 * Send mail
	 *
	 * @param  Mail request {@link SendMailRequest}
	 * @return the empty response data
	 */
/*	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Send mail", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Send mail success"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 500, message = "Server Error or send mail error(error code: ESENDMAIL)")
	})
	@PostMapping(value = "${endpoint.test.send_mail}")
	public ResponseEntity<Void> sendMail(@Valid SendMailRequest request) {

		return resultOf(request, mailService::sendEmail);
	}*/

//	// =========================================================================
//	//                                                                Private method
//	//                                                                ==========
//
//
//	// =========================================================================
//	//                                                                Inner class
//	//                                                                ==========

	@PreAuthorize("hasRole('ROLE_USER')")
	@ApiOperation(value = "Send mail", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Send mail success"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 500, message = "Server Error or send mail error(error code: ESENDMAIL)")
	})
	@GetMapping(value = "/test/user")
	public ResponseEntity<String> testUser() {
		return ResponseEntity.ok("oke user");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Send mail", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Send mail success"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 500, message = "Server Error or send mail error(error code: ESENDMAIL)")
	})
	@GetMapping(value = "/test/admin")
	public ResponseEntity<String> testAdmin() {
		return ResponseEntity.ok("oke admin");
	}

	@PreAuthorize("hasRole('ROLE_HAIDANG')")
	@ApiOperation(value = "Send mail", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Send mail success"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 500, message = "Server Error or send mail error(error code: ESENDMAIL)")
	})
	@GetMapping(value = "/test/haidang")
	public ResponseEntity<String> testHaiDang() {
		return ResponseEntity.ok("oke haidang");
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "Send mail", response = String.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Send mail success"),
			@ApiResponse(code = 400, message = "Bad request"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 500, message = "Server Error or send mail error(error code: ESENDMAIL)")
	})
	@GetMapping(value = "/sql")
	public ResponseEntity<UserResponse> sql(HttpServletRequest request) {
		/*Page<Users> list = userService.findUser();
		UserResponse response = new UserResponse();
		response.setTotal(list.getTotal());
		response.setRows(list.getResult().stream().map(u-> {
			UserResponse.ItemUser i = new UserResponse.ItemUser();
			i.setUsername(u.getUsername());
			i.setPassword(u.getPassword());
			i.setEnabled(u.getEnabled());
			return i;
		}).collect(Collectors.toList()));
		return ResponseEntity.ok(response);*/
		return null;
	}
}
