package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

/**
 * The type of status check data verification data
 * <p>if data verification exist then return OK else return NG</p>
 */
@Getter
public enum EExistFlag {

	OK(true, 0),
	NG(false, 1);

	public final boolean code;

	public final int label;

	// Constructor
	EExistFlag(boolean code, int label) {
		this.code = code;
		this.label = label;
	}

	// Class Methods
	public static EExistFlag atCode(final boolean code) {
		return EnumSet.allOf(EExistFlag.class).stream()
				.filter(category -> category.code == code)
				.findFirst()
				.orElse(null);
	}
}
