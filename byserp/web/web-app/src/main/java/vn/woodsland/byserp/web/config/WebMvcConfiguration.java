package vn.woodsland.byserp.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

/*	@Autowired
	CheckTokenValidInterceptor checkTokenValidInterceptor;*/

	/*	@Override
		public void addViewControllers(ViewControllerRegistry registry) {
			registry.addViewController("/login").setViewName("login");
			registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		}
		*/
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*registry.addInterceptor(checkTokenValidInterceptor)
				.addPathPatterns("/**").excludePathPatterns("/logout");*/

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
