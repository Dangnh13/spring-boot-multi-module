package vn.woodsland.byserp.domain.modal.suggestion;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SearchPOApprovedModal {
    private Integer id;
    private String subject;
    private Short step;
    private Short totalStep;
    private BigDecimal amount;
    private String requestStatus;
    private String priority;
    private String creator;
}