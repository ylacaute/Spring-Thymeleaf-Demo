package org.yla.demo.thymeleaf.feature.dashboard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DashboardConfiguration implements Serializable {

	private static final long serialVersionUID = -5674187250958220643L;
	
	private List<DashboardLine> lines = new ArrayList<>();

	public List<DashboardLine> getLines() {
		return lines;
	}

	public void setLines(List<DashboardLine> lines) {
		this.lines = lines;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.getClass().getSimpleName())
			.append("{ nbLines:").append(lines.size());
		for (DashboardLine dashboardLine : lines) {
			builder.append("[nbContainers:").append(dashboardLine.getContainers().size()).append("]");
		}
		return builder.append("}").toString();
	}
	
}

class DashboardLine {
	
	private List<DashboardLineContainer> containers = new ArrayList<>();

	public List<DashboardLineContainer> getContainers() {
		return containers;
	}

	public void setContainers(List<DashboardLineContainer> containers) {
		this.containers = containers;
	}

}

class DashboardLineContainer {
	
	private String cssClass;

	private List<DashboardWidget> widgets = new ArrayList<>();
	
	public String getCssClass() {
		return cssClass;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public List<DashboardWidget> getWidgets() {
		return widgets;
	}

	public void setWidgets(List<DashboardWidget> widgets) {
		this.widgets = widgets;
	}
	
}


class DashboardWidget {
	
	private String fragmentUrl;
	private String fragmentConfigurerUrl;
	private boolean handleDragStart = false;
	private HashMap<String, Object> params = new HashMap<>();
	
	public String getFragmentUrl() {
		return fragmentUrl;
	}

	public void setFragmentUrl(String fragmentUrl) {
		this.fragmentUrl = fragmentUrl;
	}

	public String getFragmentConfigurerUrl() {
		return fragmentConfigurerUrl;
	}

	public void setFragmentConfigurerUrl(String fragmentConfigurerUrl) {
		this.fragmentConfigurerUrl = fragmentConfigurerUrl;
	}

	public boolean isHandleDragStart() {
		return handleDragStart;
	}

	public void setHandleDragStart(boolean handleDragStart) {
		this.handleDragStart = handleDragStart;
	}

	public HashMap<String, Object> getParams() {
		return params;
	}

	public void setParams(HashMap<String, Object> params) {
		this.params = params;
	}
	
}



