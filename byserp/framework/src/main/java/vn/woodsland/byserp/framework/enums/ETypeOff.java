package vn.woodsland.byserp.framework.enums;

import java.util.EnumSet;

public enum ETypeOff {

    SABBATICAL("SABB", "Nghỉ phép"),
    SICK("SICK", "Nghỉ ốm"),
    PAID_LEAVE("PAID", "Nghỉ việc riêng có hưởng lương");

    public final String code;

    public final String label;

    // Constructor
    ETypeOff(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static ETypeOff atCode(final String code) {
        return EnumSet.allOf(ETypeOff.class).stream()
                .filter(category -> category.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
