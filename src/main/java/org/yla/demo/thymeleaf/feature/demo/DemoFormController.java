package org.yla.demo.thymeleaf.feature.demo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.yla.demo.thymeleaf.core.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.demo.thymeleaf.feature.contact.ContactUsModel;
import org.yla.lib.skeleton.mvc.BasePageController;

/**
 *
 * @author Yannick Lacaute
 *
 */
@Controller
public class DemoFormController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(DemoFormController.class);
	
	private enum DemoForm {
		CLASSIC, HTML5, AJAX, LAYOUT
	};
	
	public DemoFormController() {
		super(PageModelConstants.DEMO_FORM);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_DEMO_FORM_PAGE, method = RequestMethod.GET)
	public String getDemoFormPage(Model model, @PathVariable String formPageName, HttpServletRequest request) {
		LOG.info("Display the demo form page");
		String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
		addContactUsIfNotExist(model, path, formPageName);
		return RequestMappingConstants.DEMO_FORM_PAGE + formPageName + "-page";
	}
	
	private void addContactUsIfNotExist(Model model, String path, String formPageName) {
		if (!model.containsAttribute("contactUsModel")) {
			ContactUsModel contactUsModel = new ContactUsModel();
			contactUsModel.setSuccessRedirect(path);
			contactUsModel.setFailRedirect(path);
			model.addAttribute("contactUsModel", contactUsModel);
			switch (DemoForm.valueOf(formPageName.toUpperCase())) {
			case CLASSIC:
				break;
			case HTML5:
				break;
			case AJAX:
				contactUsModel.setAjaxSubmit(true);
				break;
			default:
				break;
			}
		}
	}

}
