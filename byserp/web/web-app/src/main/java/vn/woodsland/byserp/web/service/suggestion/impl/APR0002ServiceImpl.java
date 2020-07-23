package vn.woodsland.byserp.web.service.suggestion.impl;

import org.springframework.stereotype.Service;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo.APR0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.dxo.UpdateRequestStatusAPR0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.apr0002.rst.APR0002Rst;
import vn.woodsland.byserp.web.service.api.IPaymentOrderService;
import vn.woodsland.byserp.web.service.api.IRequestService;
import vn.woodsland.byserp.web.service.suggestion.IAPR0002Service;

@Service
public class APR0002ServiceImpl implements IAPR0002Service {

    private final IPaymentOrderService paymentOrderService;

    private final IRequestService requestService;

    public APR0002ServiceImpl(IPaymentOrderService paymentOrderService, IRequestService requestService) {
        this.paymentOrderService = paymentOrderService;
        this.requestService = requestService;
    }

    @Override
    public APR0002Rst search(APR0002Dxo dxo) {
        return new APR0002Rst(paymentOrderService.searchPOApproved(dxo.toSearchPOApprovedRequest()));
    }

    @Override
    public void updateRequestStatus(UpdateRequestStatusAPR0002Dxo dxo) {
        requestService.updateRequestStatus(dxo.toUpdateRequestStatusRequest());
    }
}
