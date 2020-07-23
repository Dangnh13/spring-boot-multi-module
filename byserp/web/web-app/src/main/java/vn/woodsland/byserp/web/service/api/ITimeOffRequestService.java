package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.suggestion.request.SearchTimeOffRequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchTimeOffRequestResponse;

public interface ITimeOffRequestService {

    SearchTimeOffRequestResponse searchTimeOffRequest(SearchTimeOffRequest request);

}
