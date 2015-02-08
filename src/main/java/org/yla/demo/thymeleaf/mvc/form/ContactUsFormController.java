package org.yla.demo.thymeleaf.mvc.form;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.controller.BaseController;

@Controller
public class ContactUsFormController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(ContactUsFormController.class);
	
	public ContactUsFormController() {
	}
	
	@RequestMapping(value = RequestMappingConstants.SUBMIT_CONTACTUS_FORM, method = RequestMethod.POST)
	public String submitContactUsForm(Model model, @Valid ContactUsModel contactUsModel, String forward) {
		LOG.info("Submit the contact us form : {}", contactUsModel);
		return RequestMappingConstants.FORWARD + forward;
	}
		
}
