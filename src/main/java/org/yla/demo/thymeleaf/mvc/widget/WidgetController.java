package org.yla.demo.thymeleaf.mvc.widget;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.domain.widget.Widget;
import org.yla.demo.thymeleaf.domain.widget.WidgetType;
import org.yla.demo.thymeleaf.mvc.RequestMappingConstants;
import org.yla.demo.thymeleaf.service.widget.WidgetService;
import org.yla.lib.skeleton.mvc.BaseController;

@Controller
public class WidgetController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(WidgetController.class);
	private HashMap<String, String> widgetFragmentMapping = new HashMap<String, String> ();
	
	private WidgetService widgetService;
	
	@Autowired
	public WidgetController(WidgetService widgetService) {
		this.widgetService = widgetService;
		widgetFragmentMapping.put("1", "helloWorldWidget");
		widgetFragmentMapping.put("2", "textWidget");
	}
	
	// Will Change
	@ModelAttribute("allWidgetTypes")
    public List<WidgetType> getAllWidgetTypes() {
        return widgetService.getAllWidgetTypes();
    }

	// Will Change
	@ModelAttribute("allWidgets")
    public List<Widget> getAllWidgets() {
        return widgetService.getAllWidgets();
    }
	
	@RequestMapping(value = RequestMappingConstants.GET_WIDGET_FRAG, method = RequestMethod.GET)
	public String loadWidget(Model model, @PathVariable String widgetId) throws Exception {
		LOG.info("[AJAX] Loading widget id={}", widgetId);
		Widget widget = widgetService.getWidget(widgetId);
		model.addAttribute("widget", widget);
		
		LOG.debug("Simulate long loading...");
		if (widgetId.equals("1")) {
			Thread.sleep(2000);
		} else if (widgetId.equals("2")) {
			Thread.sleep(1000);
		} else {
			Thread.sleep(300);
		}
		
		return RequestMappingConstants.WIDGET_FRAG_DIR + widget.getFragmentName();
	}
	
}
