package vn.woodsland.byserp.business.service.impl.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import jp.cyberware.reservation.business.service.common.IBranchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import vn.woodsland.byserp.domain.entity.generator.Branch;
import vn.woodsland.byserp.domain.entity.generator.BranchCriteria;
import vn.woodsland.byserp.dto.common.branch.dxo.CreateDxo;
import vn.woodsland.byserp.dto.common.branch.dxo.SearchDxo;
import vn.woodsland.byserp.dto.common.branch.dxo.UpdateDxo;
import vn.woodsland.byserp.framework.constant.CommonConstant;
import vn.woodsland.byserp.persistence.dao.generator.BranchMapper;

@Service
public class BranchServiceImpl implements IBranchService {

    private final BranchMapper branchMapper;

    public BranchServiceImpl(BranchMapper branchMapper) {
        this.branchMapper = branchMapper;
    }

    @Override
    public Page<Branch> search(SearchDxo dxo) {
        BranchCriteria crit = new BranchCriteria();
        BranchCriteria.Criteria criteria = crit.createCriteria();
        if (dxo != null) {
            if (StringUtils.isNotBlank(dxo.getId())) {
                criteria.andIdEqualTo(dxo.getId());
            }
            if (StringUtils.isNotBlank(dxo.getBranchName())) {
                criteria.andBranchNameLike('%' + dxo.getBranchName() + '%');
            }
        }
        Page<Branch> page = PageHelper.startPage(CommonConstant.PAGING.GET_ALL, CommonConstant.PAGING.GET_ALL)
                .doSelectPage(() -> branchMapper.selectByExample(crit));
        return page;
    }

    @Override
    public void create(CreateDxo dxo) {
        branchMapper.insert(dxo.toEntity());
    }

    @Override
    public void update(UpdateDxo dxo) {
        branchMapper.updateByPrimaryKey(dxo.toEntity());
    }

}
