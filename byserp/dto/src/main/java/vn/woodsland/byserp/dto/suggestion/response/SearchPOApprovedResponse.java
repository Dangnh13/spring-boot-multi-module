package vn.woodsland.byserp.dto.suggestion.response;

import com.github.pagehelper.Page;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPOApprovedModal;
import vn.woodsland.byserp.dto.base.response.RESPONSE;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SearchPOApprovedResponse extends RESPONSE {

    private List<ItemData> rows = new ArrayList<>();

    private Long total;

    public SearchPOApprovedResponse(Page<SearchPOApprovedModal> page) {
        if (CollectionUtils.isNotEmpty(page.getResult())) {
            this.total = page.getTotal();
            this.rows = page.stream()
                    .map(e -> BeanUtil.createAndCopyProperties(e, ItemData.class))
                    .collect(Collectors.toList());
        }
    }

    @Data
    public static class ItemData extends SearchPOApprovedModal {
    }
}
