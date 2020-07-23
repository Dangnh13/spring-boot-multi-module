package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

/**
 * The type of status check data verification data
 * <p>if data verification exist then return OK else return NG</p>
 */
@Getter
public enum EDeleteFlag {

    DELETED(true),
    NOT_DELETED(false);

    public final boolean code;

    // Constructor
    EDeleteFlag(boolean code) {
        this.code = code;
    }

    // Class Methods
    public static EDeleteFlag atCode(final boolean code) {
        return EnumSet.allOf(EDeleteFlag.class).stream()
                .filter(category -> category.code == code)
                .findFirst()
                .orElse(null);
    }
}
