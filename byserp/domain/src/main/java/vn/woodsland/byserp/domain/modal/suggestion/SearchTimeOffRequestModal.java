package vn.woodsland.byserp.domain.modal.suggestion;

import lombok.Data;

import java.util.Date;

@Data
public class SearchTimeOffRequestModal {
    private Integer id;
    private String typeOff;
    private String requestStatus;
    private Short totalStep;
    private Short step;
    private String assignedUser;
    private Date startTime;
    private Date endTime;
    private Date created;
}