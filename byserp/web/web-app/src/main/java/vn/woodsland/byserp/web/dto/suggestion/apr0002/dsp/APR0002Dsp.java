package vn.woodsland.byserp.web.dto.suggestion.apr0002.dsp;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.framework.enums.EPriority;
import vn.woodsland.byserp.framework.enums.ERequestStatus;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.rst.APR0002Rst;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class APR0002Dsp {

    private List<ItemData> rows = new ArrayList<>();

    private Long total;

    public APR0002Dsp(APR0002Rst rst) {
        if (CollectionUtils.isNotEmpty(rst.getRows())) {
            this.total = rst.getTotal();
            this.setRows(rst.getRows().stream().map(e -> {
                ItemData itemData = BeanUtil.createAndCopyProperties(e, ItemData.class);
                itemData.setStepProcess(String.format("%d/%d", e.getStep(), e.getTotalStep()));
                itemData.setPriorityLabel(EPriority.atCode(e.getPriority()).label);
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
        private short step;
        private short totalStep;
        private BigDecimal amount;
        private String requestStatus;
        private String requestStatusLabel;
        private String priorityLabel;
        private String priority;
        private String creator;
    }
}
