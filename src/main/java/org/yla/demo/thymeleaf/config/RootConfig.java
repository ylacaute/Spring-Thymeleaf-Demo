package org.yla.demo.thymeleaf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
@ComponentScan("org.yla.demo.thymeleaf")
public class RootConfig {

	private static final Logger LOG = LoggerFactory.getLogger(RootConfig.class);
	
	public RootConfig() {
		LOG.info("Constructing RootConfig bean...");
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/app.properties"));
		return ppc;
	}
	
}