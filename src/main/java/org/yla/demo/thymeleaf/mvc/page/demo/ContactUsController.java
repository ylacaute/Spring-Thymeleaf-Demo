package org.yla.demo.thymeleaf.mvc.page.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.demo.thymeleaf.mvc.form.ContactUsModel;
import org.yla.lib.skeleton.controller.PageController;

/**
 *
 * @author Yannick Lacaute
 *
 */
@Controller
public class ContactUsController extends PageController {

	private static final Logger LOG = LoggerFactory.getLogger(ContactUsController.class);
	
	public ContactUsController() {
		super(PageModelConstants.DEMOS_FORM);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_CONTACTUS_PAGE)
	public String getContactUsPage(Model model) {
		LOG.info("Display the demos contact us page");
		model.addAttribute("contactUsModel", new ContactUsModel());
		return RequestMappingConstants.CONTACTUS_PAGE;
	}

}
