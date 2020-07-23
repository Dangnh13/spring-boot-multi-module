package jp.cyberware.reservation.business.service.suggestion;

import vn.woodsland.byserp.domain.entity.generator.RequestComment;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchRequestCommentDxo;

import java.util.List;

public interface IRequestCommentService {

    List<RequestComment> search(SearchRequestCommentDxo dxo);
}
