package org.yla.demo.thymeleaf.mvc.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.controller.PageController;

@Controller
public class AccountController extends PageController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	public AccountController() {
		super(PageModelConstants.ACCOUNT);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_ACCOUNT_PAGE, method = RequestMethod.GET)
	public String getAccountPage(Model model) {
		LOG.info("Display the account page");
		return RequestMappingConstants.ACCOUNT_PAGE;
	}

}
