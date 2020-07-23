package vn.woodsland.byserp.persistence.dao.generator;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import vn.woodsland.byserp.domain.entity.generator.Attachment;
import vn.woodsland.byserp.domain.entity.generator.AttachmentCriteria;

@Mapper
public interface AttachmentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    long countByExample(AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int deleteByExample(AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int insert(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int insertSelective(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    List<Attachment> selectByExampleWithBLOBsWithRowbounds(AttachmentCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    List<Attachment> selectByExampleWithBLOBs(AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    List<Attachment> selectByExampleWithRowbounds(AttachmentCriteria example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    List<Attachment> selectByExample(AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    Attachment selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int updateByExampleWithBLOBs(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Attachment record, @Param("example") AttachmentCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(Attachment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.attachment
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Attachment record);
}