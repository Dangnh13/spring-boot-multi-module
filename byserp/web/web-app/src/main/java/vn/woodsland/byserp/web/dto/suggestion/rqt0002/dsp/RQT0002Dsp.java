package vn.woodsland.byserp.web.dto.suggestion.rqt0002.dsp;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.rst.RQT0002Rst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RQT0002Dsp {

    private List<ItemData> rows = new ArrayList<>();

    private long total = 0;

    public RQT0002Dsp(RQT0002Rst rst) {
        if (CollectionUtils.isNotEmpty(rst.getRows())) {
            this.total = rst.getTotal();
            this.setRows(rst.getRows().stream().map(e -> {
                ItemData itemData = BeanUtil.createAndCopyProperties(e, ItemData.class);
                itemData.setStepProcess(String.format("%d/%d", e.getStep(), e.getTotalStep()));
                itemData.setRequestStatusLabel(ERequestStatus.atCode(e.getRequestStatus()).label);
                return itemData;
            }).collect(Collectors.toList()));
        }

    }

    @Data
    public static class ItemData {
        private Integer id;
        private String subject;
        private String stepProcess;
        private float amount;
        private String requestStatusLabel;
        private String requestStatus;
        private String assignedUser;
        private String step;
    }

}
