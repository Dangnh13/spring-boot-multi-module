package jp.cyberware.reservation.business.service.suggestion;

import com.github.pagehelper.Page;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPOApprovedModal;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPaymentOrderModal;
import vn.woodsland.byserp.dto.suggestion.dxo.SavePaymentOrderDxo;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchPOApprovedDxo;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchPaymentOrderDxo;
import vn.woodsland.byserp.dto.suggestion.dxo.UpdatePODxo;

public interface IPaymentOrderService {

    Page<SearchPaymentOrderModal> searchPaymentOrder(SearchPaymentOrderDxo dxo);

    Page<SearchPOApprovedModal> searchPaymentOrderApproved(SearchPOApprovedDxo dxo);

    void saveNew(SavePaymentOrderDxo dxo);

    void update(UpdatePODxo dxo);
}
