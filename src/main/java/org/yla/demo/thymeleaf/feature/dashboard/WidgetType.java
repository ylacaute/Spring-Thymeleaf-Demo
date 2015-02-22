package org.yla.demo.thymeleaf.feature.dashboard;

import org.yla.lib.skeleton.domain.BaseResource;

public class WidgetType extends BaseResource {

	private static final long serialVersionUID = 2934213572149914039L;
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
