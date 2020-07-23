package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.common.requesttype.request.CreateRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.SearchRequest;
import vn.woodsland.byserp.dto.common.requesttype.request.UpdateRequest;
import vn.woodsland.byserp.dto.common.requesttype.response.SearchResponse;

public interface IRequestTypeService {

    SearchResponse search(SearchRequest request);

    void update(UpdateRequest request);

    void create(CreateRequest request);
}
