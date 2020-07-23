package vn.woodsland.byserp.web.service.suggestion.impl;

import org.springframework.stereotype.Service;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo.RQT00021Dxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.dxo.SearchUserDxo;
import vn.woodsland.byserp.web.dto.suggestion.rqt00021.rst.SearchUserRst;
import vn.woodsland.byserp.web.service.api.IPaymentOrderService;
import vn.woodsland.byserp.web.service.api.IUserService;
import vn.woodsland.byserp.web.service.suggestion.IRQT00021Service;

@Service
public class RQT00021ServiceImpl implements IRQT00021Service {

    private final IPaymentOrderService paymentOrderService;

    private final IUserService userService;

    public RQT00021ServiceImpl(IPaymentOrderService paymentOrderService, IUserService userService) {
        this.paymentOrderService = paymentOrderService;
        this.userService = userService;
    }

    @Override
    public SearchUserRst searchUser(SearchUserDxo dxo) {
        return new SearchUserRst(userService.searchUser(dxo.toSearchUserRequest()));
    }

    @Override
    public void save(RQT00021Dxo dxo) {
        paymentOrderService.save(dxo.toSavePaymentOrderRequest());
    }
}
