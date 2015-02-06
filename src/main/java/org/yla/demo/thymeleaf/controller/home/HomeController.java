package org.yla.demo.thymeleaf.controller.home;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.controller.PageModelConstants;
import org.yla.demo.thymeleaf.controller.RequestMappingConstants;
import org.yla.demo.thymeleaf.domain.Peripherique;
import org.yla.lib.skeleton.controller.BaseController;

@Controller
public class HomeController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController() {
		super(PageModelConstants.HOME);
	}
	
	@RequestMapping(value = {"", "/", "index*"}, method = RequestMethod.GET)
	public String getRootPage(Model model) {
		return RequestMappingConstants.REDIRECT + RequestMappingConstants.GET_HOME_PAGE;
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_HOME_PAGE, method = RequestMethod.GET)
	public String getHomePage(Model model) {
		/*Peripherique p = new Peripherique();
		p.setNomModele("Samsung");
		model.addAttribute("peripherique", p);
		LOG.debug(">>>> Peripherique modele = " + p.getNomModele());
		return "/pages/sample-form";
		*/
		return RequestMappingConstants.HOME_PAGE;
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.POST)
	public String example1(Model model, @ModelAttribute Peripherique p) {
		LOG.debug("<<<< Peripherique modele = " + p.getNomModele());
		return "/pages/sample-form";
	}
	
}
