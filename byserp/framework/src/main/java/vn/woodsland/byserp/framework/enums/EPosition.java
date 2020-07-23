package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum EPosition {

    WORKER(1, "Công nhân"),
    STAFF(2, "Nhân viên văn phòng"),
    LEADER(3, "Tổ trưởng"),
    MANAGER(4, "Trưởng phòng"),
    CEO(5, "Giám đốc");

    public int code;

    public final String label;

    // Constructor
    EPosition(int code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static EPosition atCode(final int code) {
        return EnumSet.allOf(EPosition.class).stream()
                .filter(category -> category.code == code)
                .findFirst()
                .orElse(null);
    }
}
