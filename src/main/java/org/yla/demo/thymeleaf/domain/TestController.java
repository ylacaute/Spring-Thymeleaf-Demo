package org.yla.demo.thymeleaf.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	public TestController() {
		LOG.info("Creating TestController bean...");		
	}
	
}
