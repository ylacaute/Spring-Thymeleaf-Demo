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
import org.yla.demo.thymeleaf.mvc.form.LoginModel;
import org.yla.lib.skeleton.mvc.BasePageController;

/**
 *
 * @author Yannick Lacaute
 *
 */
@Controller
public class FormController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(FormController.class);
	
	public FormController() {
		super(PageModelConstants.DEMO_FORM);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_FORM_PAGE)
	public String getDemoFormPage(Model model) {
		LOG.info("Display the demos form page");
		
		ContactUsModel contactUsModel = new ContactUsModel();
		contactUsModel.setForward(RequestMappingConstants.GET_FORM_PAGE);
		model.addAttribute("contactUsModel", contactUsModel);
		
		LoginModel loginModel = new LoginModel();
		loginModel.setRedirect(RequestMappingConstants.GET_FORM_PAGE);
		model.addAttribute("loginModel", loginModel);
		
		return RequestMappingConstants.FORM_PAGE;
	}

	@RequestMapping(value = RequestMappingConstants.GET_AJAXFORM_PAGE, method = RequestMethod.GET)
	public String getAjaxDemoFormPage(Model model) {
		LOG.info("Display the demos ajax form page");
		
		ContactUsModel contactUsModel = new ContactUsModel();
		model.addAttribute("contactUsModel", contactUsModel);
		
		return RequestMappingConstants.AJAXFORM_PAGE;
	}
}
