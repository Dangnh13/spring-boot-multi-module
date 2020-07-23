package vn.woodsland.byserp.dto.inventory.request;

import io.swagger.annotations.ApiModelProperty;
import vn.woodsland.byserp.dto.base.request.REQUEST;
import vn.woodsland.byserp.dto.inventory.dxo.MailDxo;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;

/**
 * Mail's request data
 */
@Data
public class SendMailRequest extends REQUEST {

	private static final long serialVersionUID = -4275965645102117934L;

	private static final String MAIL_MESSAGE_KEY = "message";

	@ApiModelProperty(value = "Receiver")
	@NotBlank
	@Email
	private String to;

	@ApiModelProperty(value = "Mail title")
	@NotBlank
	private String title;

	@ApiModelProperty(value = "Mail content")
	@NotBlank
	private String content;

	@Override
	public MailDxo toDxo() {
		Map<String, Object> model = new HashMap<>();
		model.put(MAIL_MESSAGE_KEY, this.content);

		MailDxo dxo = MailDxo.builder()
				.id("simple_text_template.ftl")
				.to(this.to)
				.subject(this.title)
				.model(model)
				.build();
		return dxo;
	}
}
