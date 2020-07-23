package vn.woodsland.byserp.persistence.dao.custom.suggestion;

import org.apache.ibatis.annotations.Mapper;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPOApprovedModal;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPaymentOrderModal;
import vn.woodsland.byserp.dto.suggestion.prm.SearchPOApprovedPrm;
import vn.woodsland.byserp.dto.suggestion.prm.SearchPaymentOrderPrm;

import java.util.List;

@Mapper
public interface CustomPaymentOrderMapper {
    
    List<SearchPaymentOrderModal> searchPaymentOrder(SearchPaymentOrderPrm prm);

    List<SearchPOApprovedModal> searchPOApproved(SearchPOApprovedPrm prm);
}