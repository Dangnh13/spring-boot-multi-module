package vn.woodsland.byserp.web.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.web.handler.UnknownExceptionHandler;
import vn.woodsland.byserp.framework.exception.web.handler.WebClientExceptionHandler;

@Configuration
public class BeanConfig {

    @Bean
    public IExceptionHandler unknownExceptionHandler() {
        return new UnknownExceptionHandler();
    }

    @Bean
    public IExceptionHandler<WebClientResponseException> webClientExceptionHandler() {
        return new WebClientExceptionHandler();
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
}
