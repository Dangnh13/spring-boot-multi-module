package vn.woodsland.byserp.dto.inventory.dxo;

import vn.woodsland.byserp.dto.base.dxo.DXO;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import vn.woodsland.byserp.dto.base.prm.PRM;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class MailDxo extends DXO {

	@NonNull
	private String id;

	private String from;

	private String to;

	private String cc;

	private String bcc;

	private String subject;

	private String content;

	private String contentType;

	private List<Object> attachments;

	private Map<String, Object> model;

	@Override
	public <T extends PRM> T toPrm() {
		return null;
	}
}
