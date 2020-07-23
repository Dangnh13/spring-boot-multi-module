package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ETableId {

    PAYMENT_ORDER("PAYMENT_ORDER", "bảng đề nghị thanh toán");

    public final String code;

    public final String label;

    // Constructor
    ETableId(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static ETableId atCode(final String code) {
        return EnumSet.allOf(ETableId.class).stream()
                .filter(category -> category.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
