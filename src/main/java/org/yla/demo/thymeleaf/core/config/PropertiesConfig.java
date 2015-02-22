package org.yla.demo.thymeleaf.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertiesConfig {
	
	private static final Logger LOG = LoggerFactory.getLogger(PropertiesConfig.class);
	
	public PropertiesConfig() {
		LOG.info("Constructing PropertiesConfig bean...");
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("/app.properties"));
		return ppc;
	}
}
