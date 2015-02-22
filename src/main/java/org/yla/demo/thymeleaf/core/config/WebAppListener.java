package org.yla.demo.thymeleaf.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class WebAppListener implements ApplicationListener<ApplicationEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(WebAppListener.class);
	
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
    	LOG.debug("Event : {}", event);
    }
    
}
