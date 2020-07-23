package vn.woodsland.byserp.oauth2.config;

import com.google.common.collect.Lists;
import vn.woodsland.byserp.oauth2.provider.CustomPasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.ApprovalStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

@Configuration
public class OAuth2ServerConfiguration {

	@Autowired
	private DataSource dataSource;

	@Bean
	public TokenStore tokenStore() {
		return new JdbcTokenStore(dataSource);
	}

	@Configuration
	@EnableResourceServer
	@Order(2)
	protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

		@Autowired
		private TokenStore tokenStore;

		@Bean
		@Primary
		public DefaultTokenServices tokenServices() {
			DefaultTokenServices services = new DefaultTokenServices();
			services.setTokenStore(tokenStore);
			return services;
		}

		@Override
		public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
			resources.tokenServices(tokenServices());
		}

	}

	@Configuration
	@EnableAuthorizationServer
	protected static class AuthorizationServerConfiguration implements AuthorizationServerConfigurer {

		@Autowired
		private DataSource dataSource;

		@Autowired
		private TokenStore tokenStore;

		@Autowired
		private ClientDetailsService clientDetailsService;

		@Autowired
		private CustomPasswordAuthenticationProvider customPasswordAuthenticationProvider;

		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}

		@Bean
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return new ProviderManager(Lists.newArrayList(
					customPasswordAuthenticationProvider
			));
		}

		@Bean
		public ApprovalStore approvalStore() {
			ApprovalStore approvalStore = new JdbcApprovalStore(dataSource);
			return approvalStore;
		}

		public OAuth2RequestFactory oAuth2RequestFactory() {
			OAuth2RequestFactory oAuth2RequestFactory = new DefaultOAuth2RequestFactory(clientDetailsService);
			return oAuth2RequestFactory;
		}

		@Bean
		public UserApprovalHandler userApprovalHandler() {
			ApprovalStoreUserApprovalHandler handler = new ApprovalStoreUserApprovalHandler();
			handler.setApprovalStore(approvalStore());
			handler.setClientDetailsService(clientDetailsService);
			handler.setRequestFactory(oAuth2RequestFactory());
			return handler;
		}

		@Bean
		public AuthorizationCodeServices authorizationCodeServices() {
			AuthorizationCodeServices authorizationCodeServices = new JdbcAuthorizationCodeServices(dataSource);
			return authorizationCodeServices;
		}

		@Override
		public void configure(AuthorizationServerSecurityConfigurer authorizationServerSecurityConfigurer) throws Exception {
			authorizationServerSecurityConfigurer
					.tokenKeyAccess("permitAll()")
					.checkTokenAccess("isAuthenticated()")
					.allowFormAuthenticationForClients();
		}

		@Override
		public void configure(ClientDetailsServiceConfigurer clientDetailsServiceConfigurer) throws Exception {
			clientDetailsServiceConfigurer.jdbc(dataSource).passwordEncoder(passwordEncoder());
		}

		@Override
		public void configure(AuthorizationServerEndpointsConfigurer authorizationServerEndpointsConfigurer) throws
				Exception {
			authorizationServerEndpointsConfigurer
					.tokenStore(tokenStore)
					.reuseRefreshTokens(false)
					.userApprovalHandler(userApprovalHandler())
					.authorizationCodeServices(authorizationCodeServices())
					.authenticationManager(authenticationManagerBean());
		}
	}
}
