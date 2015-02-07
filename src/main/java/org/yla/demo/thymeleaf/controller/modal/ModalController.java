package org.yla.demo.thymeleaf.controller.modal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.controller.RequestMappingConstants;
import org.yla.lib.skeleton.controller.BaseController;

@Controller
public class ModalController extends BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ModalController.class);
	
	public ModalController() {
	}
	
	
	@RequestMapping(value = RequestMappingConstants.GET_MODAL_FRAG, method = RequestMethod.GET)
	public String getHomePage(Model model, @PathVariable String modalFramentName) throws Exception {
		LOG.debug("[AJAX] Loading window modal fragment {}", modalFramentName);
		return RequestMappingConstants.MODAL_FRAG_DIR + modalFramentName;
	}
	
	
	
}
