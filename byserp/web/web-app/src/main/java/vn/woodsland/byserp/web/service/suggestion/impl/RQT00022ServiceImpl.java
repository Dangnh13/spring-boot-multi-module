package vn.woodsland.byserp.web.service.suggestion.impl;

import org.springframework.stereotype.Service;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo.RQT00022SearchForUpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.dxo.RQT00022UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00022.rst.RQT00022SearchForUpdateRst;
import vn.woodsland.byserp.web.service.api.IPaymentOrderService;
import vn.woodsland.byserp.web.service.api.IRequestCommentService;
import vn.woodsland.byserp.web.service.suggestion.IRQT00022Service;

@Service
public class RQT00022ServiceImpl implements IRQT00022Service {

    private final IPaymentOrderService paymentOrderService;

    private final IRequestCommentService requestCommentService;

    public RQT00022ServiceImpl(IPaymentOrderService paymentOrderService,
                               IRequestCommentService requestCommentService) {
        this.paymentOrderService = paymentOrderService;
        this.requestCommentService = requestCommentService;
    }

    @Override
    public RQT00022SearchForUpdateRst searchForUpdate(RQT00022SearchForUpdateDxo dxo) {
        SearchPaymentOrderResponse searchPaymentOrderResponse = paymentOrderService.searchPaymentOrder(dxo.toSearchPaymentOrderRequest());
        SearchRequestCommentResponse requestCommentResponse = requestCommentService.search(dxo.toSearchRequestCommentRequest());
        return new RQT00022SearchForUpdateRst(searchPaymentOrderResponse, requestCommentResponse);
    }

    @Override
    public void update(RQT00022UpdateDxo dxo) {
        paymentOrderService.updatePO(dxo.toUpdatePORequest());
    }
}
