package org.yla.demo.thymeleaf.feature.contact;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.demo.thymeleaf.feature.login.LoginModel;
import org.yla.lib.skeleton.mvc.BaseFormController;

@Controller
public class ContactUsFormController extends BaseFormController implements Validator {

	private static final Logger LOG = LoggerFactory.getLogger(ContactUsFormController.class);
	
	public ContactUsFormController() {
	}
	
	/**
	 * Classic form submission. The BaseFormController will do a forward or a redirect depending
	 * the FormModel (here, the contactUsModel).
	 * 
	 * @param request
	 * @param model
	 * @param contactUsModel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = RequestMappingConstants.SUBMIT_CONTACTUS_FORM, method = RequestMethod.POST)
	public String submitContactUsForm(
			@ModelAttribute("contactUsModel") @Valid ContactUsModel contactUsModel,
			BindingResult binding,
			Model model,
			RedirectAttributes attr) throws Exception {
		LOG.info("Submit the contact us form : {}", contactUsModel);
		validate(contactUsModel, binding);
		if (binding.hasErrors()) {
			return fail(contactUsModel, binding, attr);
		}
		
		return success(contactUsModel);
	}
	
	/**
	 * Ajax form submission. The controller will answer a Thymeleaf fragment which represent the status
	 * of the action (success or fail). 
	 * 
	 * @param request
	 * @param model
	 * @param contactUsModel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = RequestMappingConstants.SUBMIT_CONTACTUS_FORM, method = RequestMethod.POST, 
			headers = "x-requested-with=XMLHttpRequest")
	public String ajaxSubmitContactUsForm(
			@ModelAttribute("contactUsModel") @Valid ContactUsModel contactUsModel,
			BindingResult binding,
			Model model,
			RedirectAttributes attr) throws Exception {
		
		LOG.info("[AJAX] Submit the contact us form : {}", contactUsModel);
		validate(contactUsModel, binding);
		return RequestMappingConstants.CONTACTUS_FORM_FRAG;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactUsModel model = (ContactUsModel) target;
		// More validation here if necessary
	}
		    
	

}
