package vn.woodsland.byserp.business.service.impl.suggestion;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jp.cyberware.reservation.business.service.suggestion.IPaymentOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.woodsland.byserp.domain.entity.generator.PaymentOrder;
import vn.woodsland.byserp.domain.entity.generator.Request;
import vn.woodsland.byserp.domain.entity.generator.RequestComment;
import vn.woodsland.byserp.domain.entity.generator.RequestHistory;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPOApprovedModal;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPaymentOrderModal;
import vn.woodsland.byserp.dto.suggestion.dxo.SavePaymentOrderDxo;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchPOApprovedDxo;
import vn.woodsland.byserp.dto.suggestion.dxo.SearchPaymentOrderDxo;
import vn.woodsland.byserp.dto.suggestion.dxo.UpdatePODxo;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.framework.util.PageUtil;
import vn.woodsland.byserp.persistence.dao.custom.suggestion.CustomPaymentOrderMapper;
import vn.woodsland.byserp.persistence.dao.custom.suggestion.CustomRequestMapper;
import vn.woodsland.byserp.persistence.dao.generator.PaymentOrderMapper;
import vn.woodsland.byserp.persistence.dao.generator.RequestCommentMapper;
import vn.woodsland.byserp.persistence.dao.generator.RequestHistoryMapper;
import vn.woodsland.byserp.persistence.dao.generator.RequestMapper;

@Service
@Slf4j
public class PaymentOrderServiceImpl implements IPaymentOrderService {

    private final CustomPaymentOrderMapper customPaymentOrderMapper;
    private final CustomRequestMapper customRequestMapper;
    private final RequestMapper requestMapper;
    private final RequestCommentMapper requestCommentMapper;
    private final RequestHistoryMapper requestHistoryMapper;
    private final PaymentOrderMapper paymentOrderMapper;

    public PaymentOrderServiceImpl(CustomPaymentOrderMapper customPaymentOrderMapper,
                                   CustomRequestMapper customRequestMapper,
                                   RequestMapper requestMapper,
                                   RequestCommentMapper requestCommentMapper,
                                   RequestHistoryMapper requestHistoryMapper,
                                   PaymentOrderMapper paymentOrderMapper) {
        this.customPaymentOrderMapper = customPaymentOrderMapper;
        this.customRequestMapper = customRequestMapper;
        this.requestMapper = requestMapper;
        this.requestCommentMapper = requestCommentMapper;
        this.requestHistoryMapper = requestHistoryMapper;
        this.paymentOrderMapper = paymentOrderMapper;
    }

    @Override
    public Page<SearchPaymentOrderModal> searchPaymentOrder(SearchPaymentOrderDxo dxo) {
        Page<SearchPaymentOrderModal> result = PageHelper.offsetPage(PageUtil.getOffsetPage(dxo.getOffset()), CommonConstant.PAGING.PAGE_SIZE)
                .doSelectPage(() ->
                        customPaymentOrderMapper.searchPaymentOrder(dxo.toPrm()));
        return result;
    }

    @Override
    public Page<SearchPOApprovedModal> searchPaymentOrderApproved(SearchPOApprovedDxo dxo) {
        Page<SearchPOApprovedModal> result = PageHelper.offsetPage(PageUtil.getOffsetPage(dxo.getOffset()), CommonConstant.PAGING.PAGE_SIZE)
                .doSelectPage(() ->
                        customPaymentOrderMapper.searchPOApproved(dxo.toPrm()));
        return result;
    }

    @Override
    @Transactional
    public void saveNew(SavePaymentOrderDxo dxo) {
        Request request = dxo.toRequest();
        int idGenerate = customRequestMapper.insertReturnId(request);
        paymentOrderMapper.insertSelective(dxo.toPaymentOrder(idGenerate));

    }

    @Override
    @Transactional
    public void update(UpdatePODxo dxo) {
        Request request = dxo.toRequest();
        requestMapper.updateByPrimaryKeySelective(request);

        if (StringUtils.isNotBlank(dxo.getComment())) {
            RequestComment requestComment = dxo.toRequestComment();
            requestCommentMapper.insertSelective(requestComment);
        }
        PaymentOrder paymentOrder = dxo.toPaymentOrder();
        if(paymentOrder != null) {
            paymentOrderMapper.updateByPrimaryKeySelective(paymentOrder);
        }

       /* TODO
       RequestHistory requestHistory = dxo.toRequestHistory();
        requestHistoryMapper.insertSelective(requestHistory);
        */
    }
}
