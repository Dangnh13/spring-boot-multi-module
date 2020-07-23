package vn.woodsland.byserp.web.dto.suggestion.rqt00021.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import vn.woodsland.byserp.framework.enums.EPriority;
import vn.woodsland.byserp.framework.enums.ERequestTypeMasterData;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.validation.annotation.RequiredNotBlank;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo.RQT00021Dxo;

import java.io.Serializable;
import java.security.Principal;
import java.util.List;

@Data
public class RQT00021Form implements Serializable {

    private static final long serialVersionUID = -69739271719503753L;

    @RequiredNotBlank(name = "Tiêu đề")
    private String subject;

    @RequiredNotBlank(name = "Ngày thanh toán")
    private String paymentDate;

    @RequiredNotBlank(name = "Số tiền")
    private String amount;

    @RequiredNotBlank(name = "Độ ưu tiên")
    private String priority;

    @RequiredNotBlank(name = "Nội dung thanh toán")
    private String description;

    private List<MultipartFile> documents;

    @RequiredNotBlank(name = "Người duyệt")
    private String assignedUser;

    @RequiredNotBlank(name = "Thời gian mong muốn")
    private String deadline;

    private String email;

    private String fullname;

    private String position;

    public RQT00021Dxo toDxo(Principal principal) {
        RQT00021Dxo dxo = BeanUtil.createAndCopyProperties(this, RQT00021Dxo.class);
        dxo.setRequestTypeId(ERequestTypeMasterData.PMOD0001.code);
        dxo.setPriority(EPriority.atCode(priority).code);
        dxo.setCreator(principal.getName());
        dxo.setUserApprovedPrev(principal.getName());
        return dxo;
    }
}
