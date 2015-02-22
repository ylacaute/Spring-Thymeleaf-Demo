package org.yla.demo.thymeleaf.feature.plugin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.core.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BasePageController;


@Controller
public class PluginController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(PluginController.class);
	
	public PluginController() {
		super(PageModelConstants.ACCOUNT);
	}
	
	//@Autowired
	//private PluginService pluginService;
	
	@RequestMapping(value = RequestMappingConstants.GET_PLUGIN_PAGE, method = RequestMethod.GET)
	public String getPluginPage(Model model) throws Exception {
		LOG.info("Display the plugin page");
		/*
		PluginSingeton mgr = new PluginSingeton();
		
		mgr.loadAvailablePlugins("C:/Prog/GitHub/SpringThymeleafDemo/plugins");
		
		Plugin testPlugin = mgr.getPlugin("widgetPlugin");
		System.out.println("testPlugin GetName() : " + testPlugin.getName());
		
		String userName = mgr.call2("widgetPlugin", "plugin.WidgetHello", "sayHello").toString();
		
		System.out.println("userName : " + userName);
		*/
		
	
		return RequestMappingConstants.PLUGIN_PAGE;
	}

}
