package vn.woodsland.byserp.api.config;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getApiInfo())
				.tags(new Tag("ClientController", "List of apis electronic passport registration by client"))
				.tags(new Tag("PersonnelController", "List of apis electronic passport in personnel side"))
				.select()
				.apis(apis())
				.build();
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo("電子申請予約システムAPI仕様書", "API Documentations for the Rest API", "0.0.1-SNAPSHOT",
				"urn:tos", new Contact("Ominext", "Not Available", "Not Available"), "Apache 2.0",
				"http://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}

	private Predicate<RequestHandler> apis() {
		return Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"));
	}
}
