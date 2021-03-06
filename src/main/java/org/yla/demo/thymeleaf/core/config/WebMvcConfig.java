package org.yla.demo.thymeleaf.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.annotation.Order;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.yla.demo.thymeleaf.core.interceptor.RequestCacheInterceptor;
import org.yla.demo.thymeleaf.core.mvc.DateFormatter;
import org.yla.demo.thymeleaf.core.mvc.EnumToStringConverter;

/**
 * All servlet context beans are define here.
 * 
 * @author Yannick Lacaute
 *
 */
@Order(2)
@Configuration
/*@ComponentScan(basePackages = {
		"org.yla.demo.thymeleaf.mvc", 
		"org.yla.demo.thymeleaf.config.web" })*/
@ComponentScan(basePackages = "org.yla.demo.thymeleaf", useDefaultFilters = false, includeFilters = { 
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebMvcConfig.class),
		@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*web.*"),
		@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
public class WebMvcConfig extends WebMvcConfigurationSupport {

	private static final Logger LOG = LoggerFactory.getLogger(WebMvcConfig.class);
	
	private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages";

	@Value("${messages.cacheReloading}")
	private int messagesCacheReloading;

	@Value("${requestCacheEnabled}")
	private boolean requestCacheEnabled;
	
	
	public WebMvcConfig() {
		LOG.info("Constructing WebMvcConfig bean...");
	}
	
	@Override
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
		requestMappingHandlerMapping.setUseSuffixPatternMatch(false);
		requestMappingHandlerMapping.setUseTrailingSlashMatch(false);
		requestMappingHandlerMapping.setInterceptors(getInterceptors());
		requestMappingHandlerMapping.setContentNegotiationManager(mvcContentNegotiationManager());
		return requestMappingHandlerMapping;
	}
	
	@Override
    protected void addInterceptors(InterceptorRegistry registry) {
		LOG.info("[CONFIG] requestCacheEnabled : {}", requestCacheEnabled);
		if (requestCacheEnabled) {
			registry.addInterceptor(new RequestCacheInterceptor());
		}
    }
	
	@Bean
	public DateFormatter<?> dateFormatter() {
		return new DateFormatter<FormattingConversionService>(mvcConversionService());
	}

	@Bean
	public EnumToStringConverter<?> enumToStringConverter() {
		return new EnumToStringConverter<FormattingConversionService>(mvcConversionService());
	}

	@Bean(name = "messageSource")
	public MessageSource configureMessageSource() {
		LOG.info("[CONFIG] messagesCacheReloading : {}", messagesCacheReloading);
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename(MESSAGE_SOURCE);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(messagesCacheReloading);
		return messageSource;
	}

	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(configureMessageSource());
		return validator;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
