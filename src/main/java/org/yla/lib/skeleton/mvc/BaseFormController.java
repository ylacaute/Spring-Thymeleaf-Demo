package org.yla.lib.skeleton.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

public abstract class BaseFormController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(BaseFormController.class);
	
	public BaseFormController() {
	}
	
	public String follow(FormModelSupport formModel) throws Exception {
		String redirect = formModel.getRedirect();
		String forward = formModel.getForward();
		if (!StringUtils.isEmpty(redirect)) {
			LOG.debug("redirect to {}", redirect);
			return "redirect:" + formModel.getRedirect();
		} else if (!StringUtils.isEmpty(forward)) {
			LOG.debug("forward to {}", forward);
			return "forward:" + forward;
		}
		throw new Exception("No forward and no redirect has been defined in the formModel !");
	}
	
}
