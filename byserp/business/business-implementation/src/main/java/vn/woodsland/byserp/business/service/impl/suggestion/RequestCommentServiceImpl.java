package vn.woodsland.byserp.business.service.impl.suggestion;

import jp.cyberware.reservation.business.service.suggestion.IRequestCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.domain.entity.generator.RequestComment;
import vn.woodsland.byserp.domain.entity.generator.RequestCommentCriteria;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchRequestCommentDxo;
import vn.woodsland.byserp.persistence.dao.generator.RequestCommentMapper;

import java.util.List;

@Service
@Slf4j
public class RequestCommentServiceImpl implements IRequestCommentService {

    private final RequestCommentMapper requestCommentMapper;

    public RequestCommentServiceImpl(RequestCommentMapper requestCommentMapper) {
        this.requestCommentMapper = requestCommentMapper;
    }

    @Override
    public List<RequestComment> search(SearchRequestCommentDxo dxo) {
        RequestCommentCriteria criteria = new RequestCommentCriteria();
        criteria.createCriteria().andRequestIdEqualTo(dxo.getRequestId());
        criteria.setOrderByClause("created desc");
        List<RequestComment> requestComments = requestCommentMapper.selectByExample(criteria);
        return requestComments;
    }
}
