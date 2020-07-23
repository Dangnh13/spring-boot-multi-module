package jp.cyberware.reservation.business.service.suggestion;

import com.github.pagehelper.Page;
import vn.woodsland.byserp.domain.modal.suggestion.SearchTimeOffRequestModal;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchTimeOffRequestDxo;

public interface ITimeOffRequestService {

    Page<SearchTimeOffRequestModal> searchTimeOffRequest(SearchTimeOffRequestDxo timeOffRequestDxo);
}
