package org.yla.demo.thymeleaf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class WebAppListener implements ApplicationListener<ApplicationEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(WebAppListener.class);
	
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
    	LOG.debug("Event : {}", event);
        if (event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
        }
    }
    
}
