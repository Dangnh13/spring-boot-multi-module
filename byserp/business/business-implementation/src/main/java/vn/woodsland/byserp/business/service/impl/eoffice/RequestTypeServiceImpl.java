package vn.woodsland.byserp.business.service.impl.eoffice;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jp.cyberware.reservation.business.service.eoffice.IRequestTypeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.domain.entity.generator.RequestType;
import vn.woodsland.byserp.domain.entity.generator.RequestTypeCriteria;
import vn.woodsland.byserp.dto.common.requesttype.dxo.CreateDxo;
import vn.woodsland.byserp.dto.common.requesttype.dxo.SearchDxo;
import vn.woodsland.byserp.dto.common.requesttype.dxo.UpdateDxo;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.persistence.dao.generator.RequestTypeMapper;

@Service
public class RequestTypeServiceImpl implements IRequestTypeService {

    @Autowired
    private RequestTypeMapper requestTypeMapper;

    @Override
    public void create(CreateDxo dxo) {
        requestTypeMapper.insert(dxo.toEntity());
    }

    @Override
    public Page<RequestType> search(SearchDxo dxo) {
        RequestTypeCriteria crit = new RequestTypeCriteria();
        RequestTypeCriteria.Criteria criteria = crit.createCriteria();
        if (dxo != null && StringUtils.isNotBlank(dxo.getTitle())) {
            criteria.andTitleLike(dxo.getTitle());
        }

        Page<RequestType> page = PageHelper.startPage(CommonConstant.PAGING.GET_ALL, CommonConstant.PAGING.GET_ALL)
                .doSelectPage(() -> requestTypeMapper.selectByExample(crit));
        return page;
    }

    @Override
    public void update(UpdateDxo dxo) {
        requestTypeMapper.updateByPrimaryKeySelective(dxo.toEntity());
    }
}
