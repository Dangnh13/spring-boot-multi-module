package vn.woodsland.byserp.persistence.dao.custom.suggestion;

import org.apache.ibatis.annotations.Mapper;
import vn.woodsland.byserp.domain.entity.generator.Request;

@Mapper
public interface CustomRequestMapper {
    Integer insertReturnId(Request entity);
}