package org.yla.demo.thymeleaf.feature.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.core.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BasePageController;

@Controller
public class LoginController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	public LoginController() {
		super(PageModelConstants.LOGIN);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_LOGIN_PAGE, method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		LOG.info("Display the login page");
		
		if (!model.containsAttribute("loginModel")) {
			LoginModel loginModel = new LoginModel();
			loginModel.setSuccessRedirect(RequestMappingConstants.GET_HOME_PAGE);
			loginModel.setFailRedirect(RequestMappingConstants.GET_LOGIN_PAGE);
			model.addAttribute("loginModel", loginModel);
		}
		
		return RequestMappingConstants.LOGIN_PAGE;
	}

}
