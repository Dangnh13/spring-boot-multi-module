package vn.woodsland.byserp.dto.base.rst;

import vn.woodsland.byserp.dto.base.response.Void;

/**
 * Empty data.
 * The data returns the controller from the service layer
 *
 * @author Ominext's memner
 */
public class Empty extends RST {

	private static final Empty DEFAULT_INSTANCE = new Empty();

	public static Empty getDefaultInstance() {
		return DEFAULT_INSTANCE;
	}

	@Override
	public Void toResponse() {
		return Void.getDefaultInstance();
	}
}
