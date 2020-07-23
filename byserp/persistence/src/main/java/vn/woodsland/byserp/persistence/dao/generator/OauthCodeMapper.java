package vn.woodsland.byserp.persistence.dao.generator;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import vn.woodsland.byserp.domain.entity.generator.OauthCode;
import vn.woodsland.byserp.domain.entity.generator.OauthCodeCriteria;

@Mapper
public interface OauthCodeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    long countByExample(OauthCodeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    int deleteByExample(OauthCodeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    int insert(OauthCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    int insertSelective(OauthCode record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    List<OauthCode> selectByExampleWithBLOBsWithRowbounds(OauthCodeCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    List<OauthCode> selectByExampleWithBLOBs(OauthCodeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    List<OauthCode> selectByExampleWithRowbounds(OauthCodeCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    List<OauthCode> selectByExample(OauthCodeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OauthCode record, @Param("example") OauthCodeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") OauthCode record, @Param("example") OauthCodeCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_code
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OauthCode record, @Param("example") OauthCodeCriteria example);
}