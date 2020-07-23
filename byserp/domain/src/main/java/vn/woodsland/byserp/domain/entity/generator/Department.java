package vn.woodsland.byserp.domain.entity.generator;

import java.io.Serializable;
import java.util.Date;
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
public class Department implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.department_name
     *
     * @mbg.generated
     */
    private String departmentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.branch_id
     *
     * @mbg.generated
     */
    private String branchId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.creator
     *
     * @mbg.generated
     */
    private String creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.created
     *
     * @mbg.generated
     */
    private Date created;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.updater
     *
     * @mbg.generated
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.department.updated
     *
     * @mbg.generated
     */
    private Date updated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.department
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}