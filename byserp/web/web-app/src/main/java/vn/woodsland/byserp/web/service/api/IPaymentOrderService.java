package vn.woodsland.byserp.web.service.api;

import vn.woodsland.byserp.dto.suggestion.request.SavePaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchPOApprovedRequest;
import vn.woodsland.byserp.dto.suggestion.request.SearchPaymentOrderRequest;
import vn.woodsland.byserp.dto.suggestion.request.UpdatePORequest;
import vn.woodsland.byserp.dto.suggestion.response.SearchPOApprovedResponse;
import vn.woodsland.byserp.dto.suggestion.response.SearchPaymentOrderResponse;

public interface IPaymentOrderService {

    SearchPaymentOrderResponse searchPaymentOrder(SearchPaymentOrderRequest request);

    SearchPOApprovedResponse searchPOApproved(SearchPOApprovedRequest request);

    void save(SavePaymentOrderRequest request);

    void updatePO(UpdatePORequest request);
}
