package vn.woodsland.byserp.business.service.impl.suggestion;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jp.cyberware.reservation.business.service.suggestion.ITimeOffRequestService;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.domain.modal.suggestion.SearchTimeOffRequestModal;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchTimeOffRequestDxo;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.util.PageUtil;
import vn.woodsland.byserp.persistence.dao.custom.suggestion.CustomTimeOffRequestMapper;

@Service
public class TimeOffRequestServiceImpl implements ITimeOffRequestService {

    private final CustomTimeOffRequestMapper customTimeOffRequestMapper;

    public TimeOffRequestServiceImpl(CustomTimeOffRequestMapper customTimeOffRequestMapper) {
        this.customTimeOffRequestMapper = customTimeOffRequestMapper;
    }

    @Override
    public Page<SearchTimeOffRequestModal> searchTimeOffRequest(SearchTimeOffRequestDxo timeOffRequestDxo) {
        Page<SearchTimeOffRequestModal> result = PageHelper.offsetPage(PageUtil.getOffsetPage(timeOffRequestDxo.getOffset()), CommonConstant.PAGING.PAGE_SIZE)
                .doSelectPage(() ->
                        customTimeOffRequestMapper.searchTimeOffRequest(timeOffRequestDxo.toSearchTimeOffRequestPrm()));
        return result;
    }
}
