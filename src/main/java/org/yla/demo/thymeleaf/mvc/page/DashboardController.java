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

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
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
	public @ResponseBody DashboardConfiguration getDashBoardConfigPage(Model model, @PathVariable int configId) throws Exception {
		ClassPathResource rsc;
		if (configId == 2) {
			rsc = new ClassPathResource("dashboardConfig2.json");
		} else {
			rsc = new ClassPathResource("defaultDashboardConfig.json");
		}
		ObjectMapper mapper = new ObjectMapper();
		DashboardConfiguration config = mapper.readValue(rsc.getFile(), DashboardConfiguration.class);
		LOG.info("Loading dashbord configuration id={} : {}", configId, config);
		return config;
	}
	
}
