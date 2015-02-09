package org.yla.demo.thymeleaf.mvc.page.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BasePageController;

/**
 *
 * @author Yannick Lacaute
 *
 */
@Controller
public class LayoutController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(LayoutController.class);
	
	public LayoutController() {
		super(PageModelConstants.DEMO_LAYOUT);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_LAYOUT_PAGE, method = RequestMethod.GET)
	public String getDemoLayoutPage(Model model) {
		LOG.info("Display the demos layout page");
		return RequestMappingConstants.LAYOUT_PAGE;
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_LARGE_LAYOUT_PAGE, method = RequestMethod.GET)
	public String getDemoLargeLayoutPage(Model model) {
		LOG.info("Display the demos large layout page");
		return RequestMappingConstants.LARGE_LAYOUT_PAGE;
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_CUSTOM_LAYOUT_PAGE, method = RequestMethod.GET)
	public String getDemoCustomLayoutPage(Model model) {
		LOG.info("Display the demos custom layout page");
		return RequestMappingConstants.CUSTOM_LAYOUT_PAGE;
	}
	
}
