package org.yla.demo.thymeleaf.core.mvc;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.yla.demo.thymeleaf.feature.dashboard.DashboardConfiguration;

/**
 * Session bean
 * Since the scope is session, there is only one instance per user session.
 * The proxyMode is necessary since this session bean is referenced inside
 * some Singleton bean (like controllers).
 * 
 * @author Yannick Lacaute
 *
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Session implements Serializable {

	private static final long serialVersionUID = -8834253202285058214L;

	private static final Logger LOG = LoggerFactory.getLogger(Session.class);
	
	private DashboardConfiguration dashboardConfig;

	public Session() {
		LOG.info("Creating Session bean...");
	}
	
	public DashboardConfiguration getDashboardConfig() {
		return dashboardConfig;
	}

	public void setDashboardConfig(DashboardConfiguration dashboardConfig) {
		this.dashboardConfig = dashboardConfig;
	}
	
	
}
