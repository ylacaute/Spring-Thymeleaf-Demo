package org.yla.demo.thymeleaf.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class WebAppService implements ApplicationListener<ApplicationEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(WebAppService.class);
	
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
    	LOG.debug("Event : {}", event);
        /*
    	if (event instanceof ContextRefreshedEvent) {
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
        }
        */
    }
    
}
