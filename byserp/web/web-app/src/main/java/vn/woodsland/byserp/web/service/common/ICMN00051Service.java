package vn.woodsland.byserp.web.service.common;

import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;

public interface ICMN00051Service {
    SearchResponse.ItemData findByRequestTypeId(SearchRequest request);
}
