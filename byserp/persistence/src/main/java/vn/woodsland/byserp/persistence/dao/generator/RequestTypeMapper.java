package vn.woodsland.byserp.persistence.dao.generator;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import vn.woodsland.byserp.domain.entity.generator.RequestType;
import vn.woodsland.byserp.domain.entity.generator.RequestTypeCriteria;

@Mapper
public interface RequestTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    long countByExample(RequestTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int deleteByExample(RequestTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int insert(RequestType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int insertSelective(RequestType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    List<RequestType> selectByExampleWithRowbounds(RequestTypeCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    List<RequestType> selectByExample(RequestTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    RequestType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RequestType record, @Param("example") RequestTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RequestType record, @Param("example") RequestTypeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RequestType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RequestType record);
}