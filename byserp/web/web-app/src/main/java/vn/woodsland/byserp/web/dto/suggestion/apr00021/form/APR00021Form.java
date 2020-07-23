package vn.woodsland.byserp.web.dto.suggestion.apr00021.form;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.enums.EPosition;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.util.Dates;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021SearchDxo;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.rst.APR00021SearchRst;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class APR00021Form {

    /**
     * Using for update request status
     */
    @RequiredNotBlank
    private String requestId;

    @RequiredNotBlank
    private String requestStatus;

    @Valid
    private UpdateData data = new UpdateData();

    public APR00021SearchDxo toDxo() {
        APR00021SearchDxo dxo = BeanUtil.createAndCopyProperties(this, APR00021SearchDxo.class);
        return dxo;
    }

    public APR00021UpdateDxo toUpdateRequestDxo(Principal principal) {
        APR00021UpdateDxo dxo = new APR00021UpdateDxo();
        dxo.setRequestId(this.requestId);
        dxo.setPriority(this.data.paymentOrderData.priority);
        dxo.setDescription(this.data.paymentOrderData.description);
        dxo.setAssignedUser(this.data.assignedUser);
        dxo.setUpdater(principal.getName());
        dxo.setComment(this.data.newComment);

        ERequestStatus currentAction = ERequestStatus.atCode(this.requestStatus);
        short currentStep = Short.parseShort(this.data.getPaymentOrderData().getStep());
        short totalStep = Short.parseShort(this.data.getPaymentOrderData().getTotalStep());
        processNextStepOfRequestStatus(dxo, currentAction, currentStep, totalStep, principal);
        return dxo;
    }

    public void setUpdateData(APR00021SearchRst apr00021SearchRst) {
        this.data.setPaymentOrderData(BeanUtil.createAndCopyProperties(apr00021SearchRst.getPaymentOrderData(), UpdateData.PaymentData.class));
        this.data.getPaymentOrderData().setPosition(EPosition.atCode(Integer.parseInt(this.data.getPaymentOrderData().getPosition())).label);
        this.data.getPaymentOrderData().setCreatorPosition(EPosition.atCode(Integer.parseInt(this.data.getPaymentOrderData().getCreatorPosition())).label);

        this.data.getPaymentOrderData().setUapPosition(EPosition.atCode(Integer.parseInt(this.data.getPaymentOrderData().getUapPosition())).label);

        if (CollectionUtils.isNotEmpty(apr00021SearchRst.getComments())) {
            this.data.setComments(apr00021SearchRst.getComments()
                    .stream()
                    .map(e -> BeanUtil.createAndCopyProperties(e, UpdateData.Comment.class))
                    .collect(Collectors.toList()));
        }
    }

    private void processNextStepOfRequestStatus(APR00021UpdateDxo dxo,
                                                ERequestStatus currentAction,
                                                short currentStep,
                                                short totalStep,
                                                Principal principal) {
        short incrementOfNextStep = 1;
        ERequestStatus nextStatus = null;
        short nextStep = 1;
        dxo.setUserApprovedPrev(principal.getName());
        switch (currentAction) {
            case APPROVED:
            case REOPEN:
                if (currentStep == totalStep) {
                    nextStep = currentStep;
                    nextStatus = ERequestStatus.APPROVED;
                } else {
                    nextStep = (short) (currentStep + incrementOfNextStep);
                    nextStatus = ERequestStatus.OPENED;
                }
                break;
            case REJECT:
                nextStatus = ERequestStatus.REJECT;
                nextStep = (currentStep == 1) ? currentStep : (short) (currentStep - 1);
                break;
            case CANCEL:
                nextStatus = ERequestStatus.CANCEL;
                nextStep = 1;
                dxo.setAssignedUser(this.data.paymentOrderData.creator);
                break;
        }
        dxo.setStep(nextStep);
        dxo.setRequestStatus(nextStatus.code);
    }

    @Data
    public static class UpdateData {

        @Valid
        private PaymentData paymentOrderData;

        private List<Comment> comments = new ArrayList<>();

        private String newComment;

        @RequiredNotBlank
        private String assignedUser;
        private String position;
        private String email;
        private String fullname;

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

            private String subject;

            private Date deadline;

            private String deadlineFormat;

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

            private Date paymentDate;

            private String paymentDateFormat;

            private String assignedUser;
            private String fullname;
            private String position;
            private String email;

            private String creatorFullname;
            private String creatorEmail;
            private String creatorPosition;

            private String uap;
            private String uapFullname;
            private String uapEmail;
            private String uapPosition;

            public String getPaymentDateFormat() {
                return Dates.format(this.paymentDate, CommonConstant.DATE_FORMAT.DD_MM_YYYY);
            }

            public String getDeadlineFormat() {
                return Dates.format(this.deadline, CommonConstant.DATE_FORMAT.DD_MM_YYYY_HH_MM_SLASH);
            }
        }
    }

}
