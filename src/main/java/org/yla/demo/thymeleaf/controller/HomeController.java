package org.yla.demo.thymeleaf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.config.WebAppInitializer;
import org.yla.demo.thymeleaf.model.Peripherique;

@Controller
public class HomeController {

	
	private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	public HomeController() {
		LOG.debug("Constrcut HomeController...");
	}
	
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String example1(Model model) {
		
		Peripherique p = new Peripherique();
		p.setNomModele("Samsung");
		model.addAttribute("peripherique", p);
		
		System.out.println(">>>> Peripherique modele = " + p.getNomModele());
		return "/pages/sample-form";
	}

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.POST)
	public String example1(Model model, @ModelAttribute Peripherique p) {
		
		System.out.println("<<<< Peripherique modele = " + p.getNomModele());
		return "/pages/sample-form";
	}
	
}
