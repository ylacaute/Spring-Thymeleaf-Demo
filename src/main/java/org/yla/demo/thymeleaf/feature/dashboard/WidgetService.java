package org.yla.demo.thymeleaf.feature.dashboard;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yla.lib.skeleton.service.BaseService;

@Service
public class WidgetService extends BaseService {

	private static final Logger LOG = LoggerFactory.getLogger(WidgetService.class);
	
	
	public Widget getWidget(String widgetId) throws Exception {
		List<Widget> widgets = getAllWidgets();
		for (Widget widget : widgets) {
			if (widget.getId().equals(widgetId)) {
				return widget;
			}
		}
		String message = MessageFormat
				.format("Widget with id '{0}' has not been found.", widgetId);
		throw new Exception(message);
	}
	
	
	public List<Widget> getAllWidgets() {
		List<WidgetType> types = getAllWidgetTypes();
		List<Widget> widgets = new ArrayList<Widget>();
		
		// Add HelloWorld widget
		Widget widget = new Widget();
		widget.setId("1");
		widget.setName("Hello World Widget");
		widget.setType(types.get(1));
		widget.setFragmentName("helloWorldWidget");
		widgets.add(widget);

		// Add Text widget
		widget = new Widget();
		widget.setId("2");
		widget.setName("Text Widget");
		widget.setType(types.get(2));
		widget.setFragmentName("textWidget");
		widgets.add(widget);
		
		// Add Circle widget
		widget = new Widget();
		widget.setId("3");
		widget.setName("Circle Widget");
		widget.setType(types.get(3));
		widget.setFragmentName("circleWidget");
		widgets.add(widget);
		
		// Add Picture widget
		widget = new Widget();
		widget.setId("4");
		widget.setName("Picture Widget");
		widget.setType(types.get(3));
		widget.setFragmentName("pictureWidget");
		widget.getParams().put("imageSrc", "test.jpg");
		widgets.add(widget);
		
		LOG.info("getAllWidgets : {} returned.", widgets.size());
		return widgets;
	}
	
	public List<WidgetType> getAllWidgetTypes() {
		List<WidgetType> types = new ArrayList<WidgetType>();
		for (int i = 0; i < 5; i++) {
			WidgetType type = new WidgetType();
			type.setName("widget-type-" + i);
			types.add(type);
		}
		return types;
	}
	
	
}

