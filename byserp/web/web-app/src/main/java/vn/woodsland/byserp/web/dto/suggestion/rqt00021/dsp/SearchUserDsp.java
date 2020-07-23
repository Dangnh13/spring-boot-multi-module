package vn.woodsland.byserp.web.dto.suggestion.rqt00021.dsp;

import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import vn.woodsland.byserp.domain.modal.common.SearchUserModal;
import vn.woodsland.byserp.framework.enums.EPosition;
import vn.woodsland.byserp.framework.util.BeanUtil;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.rst.SearchUserRst;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SearchUserDsp {

    private List<ItemData> data = new ArrayList<>();

    public SearchUserDsp(SearchUserRst rst) {
        if (CollectionUtils.isNotEmpty(rst.getRows())) {
            data = rst.getRows().stream()
                    .map(e -> {
                        ItemData item = BeanUtil.createAndCopyProperties(e, ItemData.class);
                        item.setPosition(EPosition.atCode(Integer.parseInt(e.getPosition())).label);
                        return item;
                    })
                    .collect(Collectors.toList());

        }
    }

    @Data
    public static class ItemData extends SearchUserModal {

    }
}
