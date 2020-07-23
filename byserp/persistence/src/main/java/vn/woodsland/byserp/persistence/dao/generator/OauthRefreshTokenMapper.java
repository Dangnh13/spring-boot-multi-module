package vn.woodsland.byserp.persistence.dao.generator;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import vn.woodsland.byserp.domain.entity.generator.OauthRefreshToken;
import vn.woodsland.byserp.domain.entity.generator.OauthRefreshTokenCriteria;

@Mapper
public interface OauthRefreshTokenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    long countByExample(OauthRefreshTokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    int deleteByExample(OauthRefreshTokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    int insert(OauthRefreshToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    int insertSelective(OauthRefreshToken record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExampleWithBLOBsWithRowbounds(OauthRefreshTokenCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExampleWithBLOBs(OauthRefreshTokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExampleWithRowbounds(OauthRefreshTokenCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    List<OauthRefreshToken> selectByExample(OauthRefreshTokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") OauthRefreshToken record, @Param("example") OauthRefreshTokenCriteria example);
}