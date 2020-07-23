package vn.woodsland.byserp.dto.suggestion.dxo;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import vn.woodsland.byserp.domain.entity.generator.PaymentOrder;
import vn.woodsland.byserp.domain.entity.generator.Request;
import vn.woodsland.byserp.domain.entity.generator.RequestComment;
import vn.woodsland.byserp.domain.entity.generator.RequestHistory;
import vn.woodsland.byserp.dto.base.dxo.DXO;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.enums.EPriority;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.Dates;

import java.math.BigDecimal;

@Data
public class UpdatePODxo extends DXO {

    private String requestId;
    private String paymentDate;
    private String amount;
    private String deadline;
    private String priority;
    private String description;
    private String requestStatus;
    private Short step;
    private String assignedUser;
    private String updater;
    private String comment;
    private String subject;
    private String userApprovedPrev;

    @Override
    public <T extends PRM> T toPrm() {
        return null;
    }

    public Request toRequest() {
        Request request = new Request();
        request.setId(Integer.parseInt(requestId));
        request.setPriority(EPriority.atCode(this.priority).code);
        request.setDescription(this.description);
        if (StringUtils.isNotBlank(this.requestStatus))
            request.setRequestStatus(ERequestStatus.atCode(requestStatus).code);
        request.setStep(this.step);
        request.setAssignedUser(this.assignedUser);
        request.setUpdater(updater);
        request.setUpdated(Dates.now());
        if (StringUtils.isNotBlank(this.paymentDate)) {
            request.setDeadline(Dates.parseExact(this.deadline, CommonConstant.DATE_FORMAT.DD_MM_YYYY_HH_MM_SLASH));
        }
        request.setUserApprovedPrev(this.userApprovedPrev);
        request.setSubject(this.subject);
        return request;
    }

    public RequestComment toRequestComment() {
        RequestComment request = new RequestComment();
        request.setComment(this.comment);
        request.setCreated(Dates.now());
        request.setCreator(this.updater);
        request.setRequestId(Integer.parseInt(this.requestId));
        request.setStep(Short.valueOf(step));
        return request;
    }

    public PaymentOrder toPaymentOrder() {
        PaymentOrder po = new PaymentOrder();
        po.setRequestId(Integer.parseInt(this.requestId));
        boolean hasUpdate = false;
        if (StringUtils.isNotBlank(this.paymentDate)) {
            po.setPaymentDate(Dates.parseExact(this.paymentDate, CommonConstant.DATE_FORMAT.DD_MM_YYYY));
            hasUpdate = true;
        }
        if (StringUtils.isNotBlank(this.amount)) {
            po.setAmount(new BigDecimal(this.amount));
            hasUpdate = true;
        }
        if (hasUpdate)
            return po;
        return null;
    }

    public RequestHistory toRequestHistory() {
        RequestHistory request = new RequestHistory();
        return request;
    }
}
