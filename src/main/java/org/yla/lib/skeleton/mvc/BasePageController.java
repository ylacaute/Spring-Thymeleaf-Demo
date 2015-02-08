package org.yla.lib.skeleton.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BasePageController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BasePageController.class);
	
	private String pageName;
	
	public BasePageController(String pageName) {
		this.pageName = pageName;
	}
	
	/**
	 * All PageController defined a page identifier (or name). This allow to do dynamic stuff
	 * in an easy way inside thymeleaf views. 
	 * 
	 * (Not currently used)
	 *  
	 * @return
	 */
	@ModelAttribute("page")
    public String getPageName() {
        return pageName;
    }
	
}
