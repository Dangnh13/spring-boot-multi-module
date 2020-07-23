package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.common.branch.request.CreateRequest;
import vn.woodsland.byserp.dto.common.branch.request.SearchRequest;
import vn.woodsland.byserp.dto.common.branch.request.UpdateRequest;
import vn.woodsland.byserp.dto.common.branch.response.SearchResponse;

public interface IBranchService {
    
    SearchResponse search(SearchRequest request);

    void create(CreateRequest request);

    void update(UpdateRequest request);
}
