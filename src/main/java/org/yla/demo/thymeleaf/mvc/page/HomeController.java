package org.yla.demo.thymeleaf.mvc.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.demo.thymeleaf.mvc.form.ContactUsModel;
import org.yla.demo.thymeleaf.mvc.form.LoginModel;
import org.yla.lib.skeleton.controller.PageController;

/**
 * The HomeController handle main requests to display the home page.
 * Note that maybe the home page could be displayed with fragment managed
 * by other controllers.
 * 
 * @author Yannick Lacaute
 *
 */
@Controller
public class HomeController extends PageController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController() {
		super(PageModelConstants.HOME);
	}
	
	/**
	 * Routing all classic base requests to the home page. We use
	 * forward here because we don't care about the URL inside the browser.
	 * So a forward is lighter than a redirect.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"", "/", "index*"}, method = RequestMethod.GET)
	public String getRootPage(Model model) {
		return RequestMappingConstants.FORWARD + RequestMappingConstants.GET_HOME_PAGE;
	}
	
	/**
	 * This method can be called as GET or POST if we come from a forwarded form submit.
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = RequestMappingConstants.GET_HOME_PAGE)
	public String getHomePage(Model model) {
		LOG.info("Display the home page");
		model.addAttribute("contactUsModel", new ContactUsModel());
		model.addAttribute("loginModel", new LoginModel());
		return RequestMappingConstants.HOME_PAGE;
	}

	@RequestMapping(value = "/page/blank", method = RequestMethod.GET)
	public String getBlankPage(Model model) {
		LOG.info("Display the blank page");
		return "/page/blank";
	}
	
}
