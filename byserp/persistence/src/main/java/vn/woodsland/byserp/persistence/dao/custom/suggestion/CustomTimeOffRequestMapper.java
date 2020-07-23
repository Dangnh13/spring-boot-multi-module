package vn.woodsland.byserp.persistence.dao.custom.suggestion;

import org.apache.ibatis.annotations.Mapper;
import vn.woodsland.byserp.domain.modal.suggestion.SearchTimeOffRequestModal;
import vn.woodsland.byserp.dto.suggestion.prm.SearchTimeOffRequestPrm;

import java.util.List;

@Mapper
public interface CustomTimeOffRequestMapper {
    List<SearchTimeOffRequestModal> searchTimeOffRequest(SearchTimeOffRequestPrm prm);
}