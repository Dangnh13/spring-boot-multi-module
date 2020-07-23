package vn.woodsland.byserp.web.dto.suggestion.rqt0001.rst;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.dto.suggestion.response.SearchTimeOffRequestResponse;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class RQT0001Rst {

    private List<ItemData> rows;

    private Long total;

    public RQT0001Rst(SearchTimeOffRequestResponse response) {
        if (CollectionUtils.isNotEmpty(response.getRows())) {
            this.total = response.getTotal();
            this.setRows(response.getRows().stream().map(e ->
                    BeanUtil.createAndCopyProperties(e, ItemData.class)
            ).collect(Collectors.toList()));
        }
    }

    @Data
    public static class ItemData extends SearchTimeOffRequestResponse.ItemData {

    }
}
