package vn.woodsland.byserp.persistence.dao.custom.common;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import vn.woodsland.byserp.domain.modal.suggestion.SearchPaymentOrderModal;
import vn.woodsland.byserp.dto.common.user.prm.SearchUserPrm;

@Mapper
public interface CustomUserMapper {
    Page<SearchPaymentOrderModal> searchUser(SearchUserPrm prm);
}
