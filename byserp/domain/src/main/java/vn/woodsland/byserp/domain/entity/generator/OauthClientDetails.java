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
public class OauthClientDetails implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.client_id
     *
     * @mbg.generated
     */
    private String clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.resource_ids
     *
     * @mbg.generated
     */
    private String resourceIds;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.client_secret
     *
     * @mbg.generated
     */
    private String clientSecret;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.scope
     *
     * @mbg.generated
     */
    private String scope;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.authorized_grant_types
     *
     * @mbg.generated
     */
    private String authorizedGrantTypes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.web_server_redirect_uri
     *
     * @mbg.generated
     */
    private String webServerRedirectUri;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.authorities
     *
     * @mbg.generated
     */
    private String authorities;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.access_token_validity
     *
     * @mbg.generated
     */
    private Integer accessTokenValidity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.refresh_token_validity
     *
     * @mbg.generated
     */
    private Integer refreshTokenValidity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.additional_information
     *
     * @mbg.generated
     */
    private String additionalInformation;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.oauth_client_details.autoapprove
     *
     * @mbg.generated
     */
    private String autoapprove;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.oauth_client_details
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}