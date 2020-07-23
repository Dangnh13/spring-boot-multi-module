package vn.woodsland.byserp.dto.base.response;

import lombok.Data;

import java.io.Serializable;

/**
 * No data return
 *
 * @author Ominext's memner
 */
@Data
public class Void extends RESPONSE implements Serializable {

	private static final long serialVersionUID = 8528621976947941744L;

	private static final transient Void DEFAULT_INSTANCE = new Void();

	public static Void getDefaultInstance() {
		return DEFAULT_INSTANCE;
	}

}
