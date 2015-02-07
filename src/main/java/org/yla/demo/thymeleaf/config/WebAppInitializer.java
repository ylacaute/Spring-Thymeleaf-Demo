package org.yla.demo.thymeleaf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yla.lib.skeleton.config.BaseWebAppInitializer;


public class WebAppInitializer extends BaseWebAppInitializer {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebAppInitializer.class);
	
	public WebAppInitializer() {
		LOG.info("Constructing WebAppInitializer...");
	}
	
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }
    
    
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[0];
    }
    
}
