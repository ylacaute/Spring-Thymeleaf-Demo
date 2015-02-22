package org.yla.demo.thymeleaf.feature.dashboard;

import java.util.HashMap;

import org.yla.lib.skeleton.domain.BaseResource;

public class Widget extends BaseResource {

	private static final long serialVersionUID = 984032563345508204L;
	
	private String name;
	private WidgetType type;
	private String fragmentName;
	private HashMap<String, Object> params = new HashMap<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WidgetType getType() {
		return type;
	}

	public void setType(WidgetType type) {
		this.type = type;
	}

	public String getFragmentName() {
		return fragmentName;
	}

	public void setFragmentName(String fragmentName) {
		this.fragmentName = fragmentName;
	}

	public HashMap<String, Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}
	
}
