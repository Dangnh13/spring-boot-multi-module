package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EStep {

    FIRST((short) 1),
    SECOND((short) 2),
    THIRD((short) 3),
    FOURTH((short) 4);

    public final short code;

    // Constructor
    EStep(short code) {
        this.code = code;
    }

    // Class Methods
    public static EStep atCode(final short code) {
        return EnumSet.allOf(EStep.class).stream()
                .filter(category -> category.code == code)
                .findFirst()
                .orElse(null);
    }
}
