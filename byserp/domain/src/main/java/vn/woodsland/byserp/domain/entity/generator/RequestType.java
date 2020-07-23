package vn.woodsland.byserp.domain.entity.generator;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestType implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.request_type.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.request_type.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.request_type.total_step
     *
     * @mbg.generated
     */
    private Short totalStep;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.request_type.delete_flg
     *
     * @mbg.generated
     */
    private Boolean deleteFlg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.request_type
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}