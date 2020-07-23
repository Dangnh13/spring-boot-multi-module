package vn.woodsland.byserp.business.service.impl.suggestion;

import jp.cyberware.reservation.business.service.suggestion.IRequestService;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.dto.suggestion.dxo.UpdateRequestStatusDxo;
import vn.woodsland.byserp.persistence.dao.generator.RequestMapper;

@Service
public class RequestServiceImpl implements IRequestService {

    private final RequestMapper requestMapper;

    public RequestServiceImpl(RequestMapper requestMapper) {
        this.requestMapper = requestMapper;
    }

    @Override
    public void updateRequestStatus(UpdateRequestStatusDxo dxo) {
        requestMapper.updateByPrimaryKeySelective(dxo.toRequest());
    }
}
