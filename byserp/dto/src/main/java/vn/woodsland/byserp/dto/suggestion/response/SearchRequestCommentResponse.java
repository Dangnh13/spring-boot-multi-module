package vn.woodsland.byserp.dto.suggestion.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.domain.entity.generator.RequestComment;
import vn.woodsland.byserp.dto.base.response.RESPONSE;
import vn.woodsland.byserp.framework.util.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class SearchRequestCommentResponse extends RESPONSE {

    private List<ItemData> rows = new ArrayList<>();

    public SearchRequestCommentResponse(List<RequestComment> entities) {
        if (CollectionUtils.isNotEmpty(entities)) {
            this.rows = entities.stream()
                    .map(e -> BeanUtil.createAndCopyProperties(e, ItemData.class))
                    .collect(Collectors.toList());
        }
    }

    @Data
    public static class ItemData extends RequestComment {
    }
}
