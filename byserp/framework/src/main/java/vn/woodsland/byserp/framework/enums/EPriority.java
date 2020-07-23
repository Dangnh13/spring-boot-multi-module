package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EPriority {

    LOW("LOW", "Thấp"),
    MEDIUM("MEDIUM", "Trung bình"),
    HIGHT("HIGHT", "Cao");

    public final String code;

    public final String label;

    // Constructor
    EPriority(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static EPriority atCode(final String code) {
        return EnumSet.allOf(EPriority.class).stream()
                .filter(category -> category.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
