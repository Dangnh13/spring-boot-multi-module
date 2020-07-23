package vn.woodsland.byserp.api.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import vn.woodsland.byserp.framework.util.SpringServiceManager;

import java.util.Locale;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    // =========================================================================
    //                                                                Constant
    //                                                                ==========

    // =========================================================================
    //                                                                DI
    //                                                                ==========

    // =========================================================================
    //                                                                Property
    //                                                                ==========

	/*@Bean
	public MessageSource messageSource() {
		return new ReloadableResourceBundleMessageSource();
	}

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}*/

    @Bean
    public LocaleResolver localeResolver() {
        final CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
        cookieLocaleResolver.setDefaultLocale(new Locale("vi", "VN"));
        return cookieLocaleResolver;
    }

    @Bean
    public SpringServiceManager getSpringServiceManager() {
        return new SpringServiceManager();
    }

    // =========================================================================
    //                                                                Public method
    //                                                                ==========

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/", "classpath:/META-INF/resources/");
    }
}
