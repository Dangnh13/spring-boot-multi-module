package vn.woodsland.byserp.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import vn.woodsland.byserp.web.config.userservice.CustomOAuth2UserService;
import vn.woodsland.byserp.web.constant.Router;
import vn.woodsland.byserp.web.constant.SystemConfigProperties;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SystemConfigProperties systemConfigProperties;

    @Autowired
    @Qualifier("ssoLogoutHandler")
    private SsoLogoutHandler ssoLogoutHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        String authServerLogout = systemConfigProperties.getSecurity().getOauth2().getAuthServer() + "/auth/logout";
        String logoutReferer = "?referer=" + systemConfigProperties.getDomainServer() + "/login";
        String logoutSuccessUrl = authServerLogout + logoutReferer;
        http
                .antMatcher("/**").authorizeRequests()
                .antMatchers("/", "/login**").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .clearAuthentication(true)
                .logoutSuccessUrl(logoutSuccessUrl)
                .addLogoutHandler(ssoLogoutHandler)
                .and()
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl(Router.COMMON.CMN0001.URI.INIT, true)
                .userInfoEndpoint().userService(new CustomOAuth2UserService())
        ;
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/css/**", "/img/**", "/js/**", "/webfonts/**", "/webjars/**", "/resources/*");
    }


}
