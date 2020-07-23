package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.suggestion.request.SearchRequestCommentRequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;

public interface IRequestCommentService {

    SearchRequestCommentResponse search(SearchRequestCommentRequest request);
}
