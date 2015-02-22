package org.yla.demo.thymeleaf.feature.login;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BaseFormController;

//http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-annotation-example/
//http://stackoverflow.com/questions/2543797/spring-redirect-after-post-even-with-validation-errors
@Controller
public class LoginFormController extends BaseFormController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginFormController.class);
	
	public LoginFormController() {
	}
	
   
	/**
	 * 
	 * 
	 * @param loginModel
	 * @param model
	 * @param binding
	 * @param attr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = RequestMappingConstants.SUBMIT_LOGIN_FORM, method = RequestMethod.POST)
	public String submitLoginForm(
			@ModelAttribute("loginModel") @Valid LoginModel loginModel,
			BindingResult binding,
			Model model,
			RedirectAttributes attr) throws Exception {
		LOG.info("Submit the login form : {}", loginModel);

		if (binding.hasErrors()) {
			return fail(loginModel, binding, attr);
		} 
		if (true) { // test connexion here
			binding.reject("login-form.login.failed", UNDEFINED_KEY);
			return fail(loginModel, binding, attr);
		}
		return success(loginModel);
	}

}
