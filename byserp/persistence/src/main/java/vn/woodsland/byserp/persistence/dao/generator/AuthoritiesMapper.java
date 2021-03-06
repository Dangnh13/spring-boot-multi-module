package vn.woodsland.byserp.persistence.dao.generator;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import vn.woodsland.byserp.domain.entity.generator.Authorities;
import vn.woodsland.byserp.domain.entity.generator.AuthoritiesCriteria;

@Mapper
public interface AuthoritiesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    long countByExample(AuthoritiesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    int deleteByExample(AuthoritiesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    int insert(Authorities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    int insertSelective(Authorities record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    List<Authorities> selectByExampleWithRowbounds(AuthoritiesCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    List<Authorities> selectByExample(AuthoritiesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Authorities record, @Param("example") AuthoritiesCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.authorities
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Authorities record, @Param("example") AuthoritiesCriteria example);
}