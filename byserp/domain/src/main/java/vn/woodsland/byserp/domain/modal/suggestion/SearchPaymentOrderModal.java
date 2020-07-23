package vn.woodsland.byserp.domain.modal.suggestion;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SearchPaymentOrderModal {
    private Integer id;
    private String subject;
    private Date deadline;
    private BigDecimal amount;
    private String priority;
    private String description;
    private Short step;
    private Short totalStep;
    private String requestStatus;
    private String assignedUser;
    private Date paymentDate;

    private String fullname;
    private String email;
    private Short position;

    private String creator;
    private String creatorFullname;
    private String creatorEmail;
    private Short creatorPosition;

    private String uap;
    private String uapFullname;
    private String uapEmail;
    private Short uapPosition;
}