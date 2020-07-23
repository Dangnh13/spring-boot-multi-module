package vn.woodsland.byserp.web.dto.suggestion.rqt00021.rst;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.dto.common.user.response.SearchUserResponse;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class SearchUserRst {

    private List<ItemData> rows;

    private Long total;

    public SearchUserRst(SearchUserResponse response) {
        if (CollectionUtils.isNotEmpty(response.getRows())) {
            this.total = response.getTotal();
            this.setRows(response.getRows().stream().map(e ->
                    BeanUtil.createAndCopyProperties(e, ItemData.class)
            ).collect(Collectors.toList()));
        }
    }

    @Data
    public static class ItemData extends SearchUserResponse.ItemData {

    }
}
