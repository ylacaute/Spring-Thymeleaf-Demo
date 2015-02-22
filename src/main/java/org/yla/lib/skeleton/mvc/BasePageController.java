package org.yla.lib.skeleton.mvc;

import org.springframework.web.bind.annotation.ModelAttribute;

public abstract class BasePageController extends BaseController {

	private String pageName;
	
	public BasePageController(String pageName) {
		this.pageName = pageName;
	}
	
	/**
	 * All PageController defined a page identifier (or name). This allow to do dynamic stuff
	 * in an easy way inside thymeleaf views. 
	 * 
	 * Currently used for the header fragment (to active the current page)
	 *  
	 * @return
	 */
	@ModelAttribute("page")
    public String getPageName() {
        return pageName;
    }
	
}
