package vn.woodsland.byserp.web.dto.suggestion.rqt0001.dsp;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.enums.ETypeOff;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.framework.util.Dates;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.rst.RQT0001Rst;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class RQT0001Dsp {
    private List<ItemData> rows;

    private Long total;

    public RQT0001Dsp(RQT0001Rst rqt0001Rst) {
        if (CollectionUtils.isNotEmpty(rqt0001Rst.getRows())) {
            this.total = rqt0001Rst.getTotal();
            this.setRows(rqt0001Rst.getRows().stream().map(e -> {
                ItemData itemData = BeanUtil.createAndCopyProperties(e, ItemData.class);
                itemData.setTypeOff(ETypeOff.atCode(e.getTypeOff()).label);
                itemData.setStartTime(Dates.format(e.getStartTime(), CommonConstant.DATE_FORMAT.YYYY_MM_DD_HH_MM_SLASH));
                itemData.setEndTime(Dates.format(e.getEndTime(), CommonConstant.DATE_FORMAT.YYYY_MM_DD_HH_MM_SLASH));
                itemData.setStepProcess(String.format("%d/%d", e.getStep(), e.getTotalStep()));
                return itemData;
            }).collect(Collectors.toList()));
        }

    }

    @Data
    public static class ItemData {
        private Integer id;
        private String typeOff;
        private String startTime;
        private String endTime;
        private String requestStatus;
        private String stepProcess;
        private String assignedUser;
    }

}
