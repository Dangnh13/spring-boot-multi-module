package vn.woodsland.byserp.web.dto.suggestion.rqt00011.form;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.form.DemoForm;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.dxo.RQT0001Dxo;

@Data
public class RQT00011Form {

    private String subject;
    private String typeOff;
    private String priority;
    private String startTime;
    private String endTime;
    private String backupUser;
    private String description;
    private String assignedUser;
    private String deadline;

}
