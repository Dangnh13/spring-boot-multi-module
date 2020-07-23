package vn.woodsland.byserp.web.service.common.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;
import vn.woodsland.byserp.web.service.api.IRequestTypeService;
import vn.woodsland.byserp.web.service.common.ICMN00051Service;

@Service
public class CMN00051ServiceImpl implements ICMN00051Service {

    private final IRequestTypeService requestTypeService;

    public CMN00051ServiceImpl(IRequestTypeService requestTypeService) {
        this.requestTypeService = requestTypeService;
    }

    @Override
    public SearchResponse.ItemData findByRequestTypeId(SearchRequest request) {
        SearchResponse response = requestTypeService.search(request);
        if (CollectionUtils.isNotEmpty(response.getRows())) {
            return response.getRows().get(0);
        }
        return null;
    }
}
