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
public class OauthRefreshToken implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_refresh_token.token_id
     *
     * @mbg.generated
     */
    private String tokenId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_refresh_token.token
     *
     * @mbg.generated
     */
    private byte[] token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_refresh_token.authentication
     *
     * @mbg.generated
     */
    private byte[] authentication;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.oauth_refresh_token
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}