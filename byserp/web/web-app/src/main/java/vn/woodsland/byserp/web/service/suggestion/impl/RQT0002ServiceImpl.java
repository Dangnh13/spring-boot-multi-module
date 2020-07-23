package vn.woodsland.byserp.web.service.suggestion.impl;

import org.springframework.stereotype.Service;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo.RQT0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.dxo.UpdateRequestStatusRQT0002Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt0002.rst.RQT0002Rst;
import vn.woodsland.byserp.web.service.api.IPaymentOrderService;
import vn.woodsland.byserp.web.service.api.IRequestCommentService;
import vn.woodsland.byserp.web.service.api.IRequestService;
import vn.woodsland.byserp.web.service.suggestion.IRQT0002Service;

@Service
public class RQT0002ServiceImpl implements IRQT0002Service {

    private final IPaymentOrderService paymentOrderService;

    private final IRequestService requestService;

    private final IRequestCommentService requestCommentService;

    public RQT0002ServiceImpl(IPaymentOrderService paymentOrderService,
                              IRequestService requestService,
                              IRequestCommentService requestCommentService) {
        this.paymentOrderService = paymentOrderService;
        this.requestService = requestService;
        this.requestCommentService = requestCommentService;
    }

    @Override
    public RQT0002Rst loadData(RQT0002Dxo dxo) {
        return new RQT0002Rst(paymentOrderService.searchPaymentOrder(dxo.toPaymentOrderRequest()));
    }

    @Override
    public void delete(UpdateRequestStatusRQT0002Dxo dxo) {
        requestService.updateRequestStatus(dxo.toUpdateRequestStatusRequest());
    }

}
