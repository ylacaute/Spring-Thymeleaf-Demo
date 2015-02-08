package org.yla.demo.thymeleaf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * All beans are constructed under the root application context by default,
 * only the WebMvcConfig, the ThymeleafConfig and all controllers which belong
 * to the servlet context (defined with WebMvcConfig).
 * 
 * @author Yannick Lacaute
 *
 */
@Configuration
@ComponentScan(basePackages = "org.yla.demo.thymeleaf", excludeFilters = { 
	@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebMvcConfig.class),
	@ComponentScan.Filter(type = FilterType.REGEX, pattern = ".*mvc.*"),
	@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class RootConfig {

	private static final Logger LOG = LoggerFactory.getLogger(RootConfig.class);
	
	public RootConfig() {
		LOG.info("Constructing RootConfig bean...");
	}

}