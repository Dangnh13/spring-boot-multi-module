package vn.woodsland.byserp.web.dto.suggestion.apr0002.rst;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.dto.suggestion.response.SearchPOApprovedResponse;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class APR0002Rst {

    private List<ItemData> rows;

    private Long total;

    public APR0002Rst(SearchPOApprovedResponse response) {
        if (CollectionUtils.isNotEmpty(response.getRows())) {
            this.total = response.getTotal();
            this.setRows(response.getRows().stream().map(e ->
                    BeanUtil.createAndCopyProperties(e, ItemData.class)
            ).collect(Collectors.toList()));
        }
    }

    @Data
    public static class ItemData extends SearchPOApprovedResponse.ItemData {

    }
}
