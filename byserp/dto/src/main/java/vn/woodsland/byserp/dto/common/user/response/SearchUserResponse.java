package vn.woodsland.byserp.dto.common.user.response;

import com.github.pagehelper.Page;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.domain.modal.common.SearchUserModal;
import vn.woodsland.byserp.dto.base.response.RESPONSE;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SearchUserResponse extends RESPONSE {

    private List<ItemData> rows = new ArrayList<>();

    private long total;

    public SearchUserResponse(Page<SearchUserModal> page) {
        if (CollectionUtils.isNotEmpty(page.getResult())) {
            this.setTotal(page.getTotal());
            this.setRows(page.getResult().stream().map(e ->
                    BeanUtil.createAndCopyProperties(e, ItemData.class)
            ).collect(Collectors.toList()));
        }

    }

    @Data
    public static class ItemData extends SearchUserModal {
    }
}
