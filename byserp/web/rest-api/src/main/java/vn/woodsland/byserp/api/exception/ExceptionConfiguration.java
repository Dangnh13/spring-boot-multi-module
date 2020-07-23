package vn.woodsland.byserp.api.exception;

import vn.woodsland.byserp.framework.exception.IExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.handler.BindExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.handler.ServiceExceptionHandler;
import vn.woodsland.byserp.framework.exception.rest.type.ServiceException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindException;

@Configuration
public class ExceptionConfiguration {
    @Bean
    public IExceptionHandler<ServiceException> serviceExceptionHandler() {
        return new ServiceExceptionHandler();
    }

    @Bean
    public IExceptionHandler<BindException> bindExceptionHandler() {
        return new BindExceptionHandler();
    }
}
