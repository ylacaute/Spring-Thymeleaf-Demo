package org.yla.lib.skeleton.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class PageController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(PageController.class);
	
	private String pageName;
	
	public PageController(String pageName) {
		this.pageName = pageName;
	}
	
	@ModelAttribute("page")
    public String getPageName() {
        return pageName;
    }
	
}
