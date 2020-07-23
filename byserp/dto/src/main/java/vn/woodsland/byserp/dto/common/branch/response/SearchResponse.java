package vn.woodsland.byserp.dto.common.branch.response;

import com.github.pagehelper.Page;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.woodsland.byserp.domain.entity.generator.Branch;
import vn.woodsland.byserp.dto.base.response.RESPONSE;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SearchResponse extends RESPONSE implements Serializable {

    private static final long serialVersionUID = 2671532944748122177L;

    private List<ItemData> rows = new ArrayList<>();

    private long total;

    public SearchResponse(Page<Branch> page) {
        this.setTotal(page.getTotal());
        this.setRows(page.getResult().stream().map(e ->
                BeanUtil.createAndCopyProperties(e, ItemData.class)
        ).collect(Collectors.toList()));
    }

    @Data
    public static class ItemData extends Branch {
        private String name= "ngo hai dang";
    }
}
