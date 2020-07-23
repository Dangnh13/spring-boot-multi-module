package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.domain.entity.generator.Attachment;
import vn.woodsland.byserp.domain.entity.generator.PaymentOrder;
import vn.woodsland.byserp.domain.entity.generator.Request;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.enums.EPriority;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.enums.ERequestTypeMasterData;
import vn.woodsland.byserp.framework.enums.EStep;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.util.Dates;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SavePaymentOrderDxo extends DXO {

    private String requestTypeId;
    private String priority;
    private String description;
    private String deadline;
    private String subject;
    private String requestStatus;
    private Integer step;
    private String assignedUser;
    private String creator;
    private String updated;
    private BigDecimal amount;
    private String paymentDate;
    private String userApprovedPrev;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }

    public Request toRequest() {
        Request request = new Request();
        request.setRequestTypeId(ERequestTypeMasterData.atCode(this.requestTypeId).code);
        request.setPriority(EPriority.atCode(this.priority).code);
        request.setDescription(this.description);
        request.setDeadline(Dates.parseExact(this.deadline, CommonConstant.DATE_FORMAT.DD_MM_YYYY_HH_MM_SLASH));
        request.setSubject(this.subject);
        request.setRequestStatus(ERequestStatus.OPENED.code);
        request.setStep(EStep.FIRST.code);
        request.setAssignedUser(this.assignedUser);
        request.setCreator(creator);
        request.setUpdater(creator);
        request.setUserApprovedPrev(this.userApprovedPrev);
        Date now = Dates.now();
        request.setCreated(now);
        request.setUpdated(now);
        return request;
    }

    public PaymentOrder toPaymentOrder(int requestId) {
        PaymentOrder paymentOrder = new PaymentOrder();
        paymentOrder.setRequestId(requestId);
        paymentOrder.setAmount(this.amount);
        if (StringUtils.isNotBlank(this.paymentDate)) {
            paymentOrder.setPaymentDate(Dates.parseExact(this.deadline, CommonConstant.DATE_FORMAT.DD_MM_YYYY_HH_MM_SLASH));
        }
        return paymentOrder;
    }

    public Attachment toAttachment() {
        return BeanUtil.createAndCopyProperties(this, Attachment.class);
    }
}
