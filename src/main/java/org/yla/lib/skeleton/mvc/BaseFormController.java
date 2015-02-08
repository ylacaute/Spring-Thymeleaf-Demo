package org.yla.lib.skeleton.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public abstract class BaseFormController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseFormController.class);
	
	public BaseFormController() {
	}
	
	public String follow(FormModel formModel) throws Exception {
		if (!StringUtils.isEmpty(formModel.getRedirect())) {
			return "redirect:" + formModel.getRedirect();
		} else if (!StringUtils.isEmpty(formModel.getForward())) {
			return "forward:" + formModel.getForward();
		}
		throw new Exception("No forward and no redirect has been defined in the formModel !");
	}
	
}
