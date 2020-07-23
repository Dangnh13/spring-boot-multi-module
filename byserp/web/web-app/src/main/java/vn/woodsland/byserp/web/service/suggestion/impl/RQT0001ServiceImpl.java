package vn.woodsland.byserp.web.service.suggestion.impl;

import org.springframework.stereotype.Service;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.dxo.RQT0001Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0001.rst.RQT0001Rst;
import vn.woodsland.byserp.web.service.api.ITimeOffRequestService;
import vn.woodsland.byserp.web.service.suggestion.IRQT0001Service;

@Service
public class RQT0001ServiceImpl implements IRQT0001Service {

    private final ITimeOffRequestService timeOffRequestService;

    public RQT0001ServiceImpl(ITimeOffRequestService timeOffRequestService) {
        this.timeOffRequestService = timeOffRequestService;
    }

    @Override
    public RQT0001Rst loadData(RQT0001Dxo dxo) {
        return new RQT0001Rst(timeOffRequestService.searchTimeOffRequest(dxo.toSearchTimeOffRequest()));
    }
}
