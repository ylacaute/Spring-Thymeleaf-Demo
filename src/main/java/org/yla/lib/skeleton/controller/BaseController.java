package org.yla.lib.skeleton.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	private String pageName;
	
	public BaseController(String pageName) {
		LOG.info("Construct {} bean...", getClass().getSimpleName());
		this.pageName = pageName;
	}
	
	@ModelAttribute("page")
    public String getPageName() {
        return pageName;
    }
	
}
