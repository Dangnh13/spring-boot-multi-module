package vn.woodsland.byserp.dto.suggestion.prm;

import lombok.Data;
import vn.woodsland.byserp.dto.base.prm.PRM;
import vn.woodsland.byserp.framework.enums.ERequestTypeMasterData;
import vn.woodsland.byserp.framework.enums.ETableId;

@Data
public class SearchPaymentOrderPrm extends PRM {

    private String username;

    private String requestId;

    private String assignedUser;

    private String tableId = ETableId.PAYMENT_ORDER.code;

    private String requestType = ERequestTypeMasterData.PMOD0001.code;
}
