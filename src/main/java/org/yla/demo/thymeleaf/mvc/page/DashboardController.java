package org.yla.demo.thymeleaf.mvc.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yla.demo.thymeleaf.domain.dashboard.DashboardConfiguration;
import org.yla.demo.thymeleaf.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BasePageController;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DashboardController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(DashboardController.class);
	
	public DashboardController() {
		super(PageModelConstants.DASHBOARD);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_DASHBOARD_PAGE, method = RequestMethod.GET)
	public String getAccountPage(Model model) {
		LOG.info("Display the dashboard page");
		return RequestMappingConstants.DASHBOARD_PAGE;
	}

	@RequestMapping(value = RequestMappingConstants.DASHBORD_CONFIG)
	public @ResponseBody DashboardConfiguration getDashBoardLayoutConfig(Model model, @PathVariable int configId) throws Exception {
		ClassPathResource rsc;
		switch (configId) {
		case 1: 
			rsc = new ClassPathResource("dashboard/layoutConfig1.json");
			break;
		case 2: 
			rsc = new ClassPathResource("dashboard/layoutConfig2.json");
			break;
		case 10: 
			rsc = new ClassPathResource("dashboard/userConfig1.json");
			break;
		default:
			rsc = new ClassPathResource("dashboard/userConfig2.json");
			break;
		}
		ObjectMapper mapper = new ObjectMapper();
		DashboardConfiguration config = mapper.readValue(rsc.getFile(), DashboardConfiguration.class);
		LOG.info("Loading dashbord layout configuration id={} : {}", configId, config);
		return config;
	}
	
}
