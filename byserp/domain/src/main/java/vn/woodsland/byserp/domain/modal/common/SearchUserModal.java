package vn.woodsland.byserp.domain.modal.common;

import lombok.Data;

@Data
public class SearchUserModal {
    private String username;
    private String fullname;
    private Integer departmentId;
    private String phoneNo;
    private String email;
    private String position;
    private String departmentName;
}
