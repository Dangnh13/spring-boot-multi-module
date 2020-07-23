package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ERequestTypeMasterData {

    LOAF0001("LOAF0001", "Đơn xin nghỉ phép"),
    PMOD0001("PMOD0001", "Đề nghị thanh toán");

    public final String code;

    public final String label;

    // Constructor
    ERequestTypeMasterData(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static ERequestTypeMasterData atCode(final String code) {
        return EnumSet.allOf(ERequestTypeMasterData.class).stream()
                .filter(category -> category.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
