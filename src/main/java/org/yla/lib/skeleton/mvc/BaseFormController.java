package org.yla.lib.skeleton.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public abstract class BaseFormController extends BaseController {

	protected static final String UNDEFINED_KEY = "[UNDEFINED MESSAGE KEY]";
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseFormController.class);
	
	public BaseFormController() {
	}
	
	public String fail(FormModel formModel, BindingResult binding, RedirectAttributes attr) throws Exception {
		for (ObjectError error : binding.getAllErrors()) {
			LOG.warn(" Form error : {}", error);
		}
		attr.addFlashAttribute("org.springframework.validation.BindingResult." + formModel.getModelName(), binding);
		attr.addFlashAttribute(formModel.getModelName(), formModel);
		return doFailRedirect(formModel);
	}
	
	public String success(FormModel formModel) throws Exception {
		return doSuccessRedirect(formModel);
	}
	
	private String doSuccessRedirect(FormModel formModel) throws Exception {
		String redirect = formModel.getSuccessRedirect();
		if (!StringUtils.isEmpty(redirect)) {
			redirect = "redirect:" + redirect;
			LOG.debug("redirect to {}", redirect);
			return redirect;
		}
		throw new Exception("No success redirect has been defined in the formModel !");
	}
	
	private String doFailRedirect(FormModel formModel) throws Exception {
		String redirect = formModel.getFailRedirect();
		if (!StringUtils.isEmpty(redirect)) {
			redirect = "redirect:" + redirect;
			LOG.debug("redirect to {}", redirect);
			return redirect;
		}
		throw new Exception("No fail redirect has been defined in the formModel !");
	}
	
}
