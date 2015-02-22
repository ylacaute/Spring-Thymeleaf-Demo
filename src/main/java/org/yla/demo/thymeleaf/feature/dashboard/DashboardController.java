package org.yla.demo.thymeleaf.feature.dashboard;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yla.demo.thymeleaf.core.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.demo.thymeleaf.core.mvc.Session;
import org.yla.demo.thymeleaf.feature.gallery.Gallery;
import org.yla.demo.thymeleaf.feature.gallery.GalleryService;
import org.yla.lib.skeleton.mvc.BasePageController;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class DashboardController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	private Session session;
	
	@Autowired
	private GalleryService galleryService;
	
	public DashboardController() {
		super(PageModelConstants.DASHBOARD);
	}
	
	/**
	 * Get the Dashboard page
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = RequestMappingConstants.GET_DASHBOARD_PAGE, method = RequestMethod.GET)
	public String getDashboardPage(Model model) {
		LOG.info("Display the dashboard page");
		return RequestMappingConstants.DASHBOARD_PAGE;
	}

	/**
	 * Save the dashboard configuration in session.
	 * 
	 * @param model
	 * @param config
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = RequestMappingConstants.DASHBORD_CONFIG, method = RequestMethod.POST)
	public @ResponseBody String saveConfig(Model model, @RequestBody DashboardConfiguration config) throws Exception {
		LOG.info("Saving dashboard configuration : {}", config);
		session.setDashboardConfig(config);
		return "";
	}
	
	/**
	 * Get a specific Dashboard config in JSON. If the configId is equal to -1, then the user
	 * configuration will be loaded and it there is no user configuration yet, a default config
	 * is used.
	 * 
	 * 
	 * @param model
	 * @param configId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = RequestMappingConstants.DASHBORD_CONFIG, method = RequestMethod.GET)
	public @ResponseBody DashboardConfiguration getDashBoardLayoutConfig(Model model, @PathVariable int configId) throws Exception {
		DashboardConfiguration config;
		if (configId == -1) {
			config = getDefaultConfig();
		} else {
			config = getConfigFromFile(configId);
		}
		LOG.info("Loading dashbord layout configuration id={} : {}", configId, config);
		return config;
	}
	
	
	private DashboardConfiguration getDefaultConfig() throws Exception {
		if (session.getDashboardConfig() != null) {
			return session.getDashboardConfig();
		} else {
			return getConfigFromFile(1);
		}
	}
	
	private DashboardConfiguration getConfigFromFile(int configId) throws Exception {
		ClassPathResource rsc;
		switch (configId) {
		case 1: rsc = new ClassPathResource("dashboard/layoutConfig1.json"); break;
		case 2: rsc = new ClassPathResource("dashboard/layoutConfig2.json"); break;
		case 10: rsc = new ClassPathResource("dashboard/userConfig1.json"); break;
		case 42: return buildGalleryConfig();
		default: rsc = new ClassPathResource("dashboard/userConfig2.json"); break;
		}
		ObjectMapper mapper = new ObjectMapper();
		DashboardConfiguration config = mapper.readValue(rsc.getFile(), DashboardConfiguration.class);
		return config;
	}
	
	private DashboardConfiguration buildGalleryConfig() {
		Gallery gallery = galleryService.getGallery();
		gallery = galleryService.saveGallery(gallery);
		return new DashboardConfigurationBuilder().build(gallery);
	}
	

}
