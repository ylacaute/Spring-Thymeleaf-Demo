package org.yla.demo.thymeleaf.mvc.form;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BaseFormController;

@Controller
public class LoginFormController extends BaseFormController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginFormController.class);
	
	public LoginFormController() {
	}
	
	@RequestMapping(value = RequestMappingConstants.SUBMIT_LOGIN_FORM, method = RequestMethod.POST)
	public String submitLoginForm(Model model, @Valid LoginModel loginModel) throws Exception {
		LOG.info("Submit the login form : {}", loginModel);
		return super.follow(loginModel);
	}

}
