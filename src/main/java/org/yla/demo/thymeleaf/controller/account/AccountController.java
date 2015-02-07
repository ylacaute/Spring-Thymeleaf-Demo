package org.yla.demo.thymeleaf.controller.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.controller.PageModelConstants;
import org.yla.demo.thymeleaf.controller.RequestMappingConstants;
import org.yla.lib.skeleton.controller.PageController;

@Controller
public class AccountController extends PageController {

	public AccountController() {
		super(PageModelConstants.ACCOUNT);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_ACCOUNT_PAGE, method = RequestMethod.GET)
	public String getAccountPage(Model model) {
		return RequestMappingConstants.ACCOUNT_PAGE;
	}

}
