package vn.woodsland.byserp.framework.enums;

import lombok.Getter;

import java.util.EnumSet;

@Getter
public enum ERequestStatus {

    OPENED("OPENED", "Mới"),
    PROCESSING("PROCESSING", "Đang xử lý"),
    REJECT("REJECT", "Từ chối"),
    REOPEN("REOPEN", "Mở lại yêu cầu"),
    CANCEL("CANCEL", "Hủy bỏ"),
    APPROVED("APPROVED", "Đã duyệt");

    public final String code;

    public final String label;

    // Constructor
    ERequestStatus(String code, String label) {
        this.code = code;
        this.label = label;
    }

    // Class Methods
    public static ERequestStatus atCode(final String code) {
        return EnumSet.allOf(ERequestStatus.class).stream()
                .filter(category -> category.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
