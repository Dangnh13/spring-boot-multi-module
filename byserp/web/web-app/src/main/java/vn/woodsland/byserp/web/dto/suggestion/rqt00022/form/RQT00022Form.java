package vn.woodsland.byserp.web.dto.suggestion.rqt00022.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.framework.enums.EPosition;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo.RQT00022SearchForUpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo.RQT00022UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.rst.RQT00022SearchForUpdateRst;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
public class RQT00022Form {

    /**
     * Using for update request status
     */
    @RequiredNotBlank
    private String requestId;

    private String requestStatus;

    @Valid
    private UpdateData data = new UpdateData();

    public RQT00022SearchForUpdateDxo toDxo() {
        RQT00022SearchForUpdateDxo dxo = BeanUtil.createAndCopyProperties(this, RQT00022SearchForUpdateDxo.class);
        return dxo;
    }

    public void setUpdateData(RQT00022SearchForUpdateRst rst) {
        this.data.setPaymentOrderData(BeanUtil.createAndCopyProperties(rst.getPaymentOrderData(), UpdateData.PaymentData.class));
        this.data.getPaymentOrderData().setDeadline(rst.getPaymentOrderData().getDeadlineFormat());
        this.data.getPaymentOrderData().setPaymentDate(rst.getPaymentOrderData().getPaymentDateFormat());
        this.data.getPaymentOrderData().setPosition(EPosition.atCode(Integer.parseInt(this.data.getPaymentOrderData().getPosition())).label);
        if (StringUtils.isNotBlank(this.data.getPaymentOrderData().getUap())) {
            this.data.getPaymentOrderData().setUapPosition(EPosition.atCode(Integer.parseInt(this.data.getPaymentOrderData().getUapPosition())).label);
        }
        if (CollectionUtils.isNotEmpty(rst.getComments())) {
            this.data.setComments(rst.getComments()
                    .stream()
                    .map(e -> BeanUtil.createAndCopyProperties(e, UpdateData.Comment.class))
                    .collect(Collectors.toList()));
        }
    }

    public RQT00022UpdateDxo toUpdateRequestDxo(Principal principal) {
        RQT00022UpdateDxo dxo = new RQT00022UpdateDxo();
        dxo.setRequestId(this.requestId);
        dxo.setPaymentDate(this.data.paymentOrderData.getPaymentDate());
        dxo.setAmount(this.data.paymentOrderData.getAmount());
        dxo.setPriority(this.data.paymentOrderData.priority);
        dxo.setDescription(this.data.paymentOrderData.description);
        dxo.setAssignedUser(this.data.paymentOrderData.assignedUser);
        dxo.setDeadline(this.data.paymentOrderData.deadline);
        dxo.setComment(this.data.newComment);
        dxo.setUpdater(principal.getName());
        dxo.setSubject(this.data.paymentOrderData.subject);
        dxo.setStep(this.data.paymentOrderData.step);

        if (StringUtils.isNotBlank(this.requestStatus) && ERequestStatus.REOPEN.code.equals(this.requestStatus)) {
            dxo.setRequestStatus(this.requestStatus);
            dxo.setAssignedUser(this.data.paymentOrderData.getUap());
            dxo.setUserApprovedPrev(principal.getName());
        }
        return dxo;
    }

    @Data
    public static class UpdateData {

        @Valid
        private PaymentData paymentOrderData;

        private List<Comment> comments = new ArrayList<>();

        private String newComment;

        @Data
        public static class Comment {
            private Integer id;
            private Integer requestId;
            private Short step;
            private String comment;
            private String creator;
            private Date created;
        }

        @Data
        public static class PaymentData {

            private String id;

            @RequiredNotBlank
            private String subject;

            private String deadline;

            private String amount;

            @RequiredNotBlank
            private String priority;

            @RequiredNotBlank
            private String description;

            @RequiredNotBlank
            private String step;

            @RequiredNotBlank
            private String totalStep;

            private String creator;

            private String requestStatus;

            private String paymentDate;

            private String assignedUser;
            private String fullname;
            private String position;
            private String email;

            private String uap;
            private String uapFullname;
            private String uapEmail;
            private String uapPosition;
        }
    }

}

