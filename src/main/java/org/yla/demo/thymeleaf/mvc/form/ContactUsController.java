package org.yla.demo.thymeleaf.mvc.form;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.controller.BaseController;

@Controller
public class ContactUsController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(ContactUsController.class);
	
	public ContactUsController() {
	}
	
	
	@RequestMapping(value = RequestMappingConstants.SUBMIT_CONATCTUS_FORM, method = RequestMethod.POST)
	public String submitContactUsPage(Model model) {
		LOG.info("Submit the contact us form");
		return RequestMappingConstants.HOME_PAGE;
	}
	
}
