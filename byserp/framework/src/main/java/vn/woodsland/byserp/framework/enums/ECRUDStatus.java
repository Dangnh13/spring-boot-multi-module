package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ECRUDStatus {

    ERROR("error", "save failed"),
    SUCCESS("success", "save success");

    public final String code;

    public final String label;

    // Constructor
    ECRUDStatus(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static ECRUDStatus atCode(final String code) {
        return EnumSet.allOf(ECRUDStatus.class).stream()
                .filter(category -> category.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
