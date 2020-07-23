package vn.woodsland.byserp.api.controller.suggestion;

import io.swagger.annotations.Api;
import jp.cyberware.reservation.business.service.suggestion.IPaymentOrderService;
import jp.cyberware.reservation.business.service.suggestion.IRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vn.woodsland.byserp.api.controller.AbstractBaseController;
import vn.woodsland.byserp.dto.suggestion.request.SavePaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchPOApprovedRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchPaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.UpdatePORequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchPOApprovedResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;
import vn.woodsland.byserp.framework.constant.Router;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
@Api(tags = "Payment order controller")
public class PaymentOrderController extends AbstractBaseController {

    private final IPaymentOrderService paymentOrderService;

    private final IRequestService requestService;

    @PostMapping(value = Router.API.PAYMENT_ORDER.SEARCH)
    public ResponseEntity<SearchPaymentOrderResponse> searchPaymentOrder(@RequestBody @Valid SearchPaymentOrderRequest request) {
        SearchPaymentOrderResponse response = new SearchPaymentOrderResponse(paymentOrderService.searchPaymentOrder(request.toDxo()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = Router.API.PAYMENT_ORDER.SEARCH_APPROVED)
    public ResponseEntity<SearchPOApprovedResponse> searchPOApproved(@RequestBody @Valid SearchPOApprovedRequest request) {
        SearchPOApprovedResponse response = new SearchPOApprovedResponse(paymentOrderService.searchPaymentOrderApproved(request.toDxo()));
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = Router.API.PAYMENT_ORDER.SAVE)
    public ResponseEntity<Void> save(@RequestBody @Valid SavePaymentOrderRequest request) {
        paymentOrderService.saveNew(request.toDxo());
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = Router.API.PAYMENT_ORDER.UPDATE)
    public ResponseEntity<Void> update(@RequestBody @Valid UpdatePORequest request) {
        paymentOrderService.update(request.toDxo());
        return ResponseEntity.ok().build();
    }
}

