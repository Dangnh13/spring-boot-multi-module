package vn.woodsland.byserp.web.service.suggestion.impl;

import org.springframework.stereotype.Service;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchRequestCommentResponse;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021SearchDxo;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.dxo.APR00021UpdateDxo;
import vn.woodsland.byserp.web.dto.suggestion.apr00021.rst.APR00021SearchRst;
import vn.woodsland.byserp.web.service.api.IPaymentOrderService;
import vn.woodsland.byserp.web.service.api.IRequestCommentService;
import vn.woodsland.byserp.web.service.suggestion.IAPR00021Service;

@Service
public class APR00021ServiceImpl implements IAPR00021Service {

    private final IPaymentOrderService paymentOrderService;

    private final IRequestCommentService requestCommentService;

    public APR00021ServiceImpl(IPaymentOrderService paymentOrderService,
                               IRequestCommentService requestCommentService) {
        this.paymentOrderService = paymentOrderService;
        this.requestCommentService = requestCommentService;
    }

    @Override
    public APR00021SearchRst search(APR00021SearchDxo dxo) {
        SearchPaymentOrderResponse searchPaymentOrderResponse = paymentOrderService.searchPaymentOrder(dxo.toSearchPaymentOrderRequest());
        SearchRequestCommentResponse requestCommentResponse = requestCommentService.search(dxo.toSearchRequestCommentRequest());
        return new APR00021SearchRst(searchPaymentOrderResponse, requestCommentResponse);
    }

    @Override
    public void update(APR00021UpdateDxo dxo) {
        paymentOrderService.updatePO(dxo.toUpdatePORequest());
    }
}
