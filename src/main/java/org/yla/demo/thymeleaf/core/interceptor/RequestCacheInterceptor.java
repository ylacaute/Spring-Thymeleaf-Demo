package org.yla.demo.thymeleaf.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class RequestCacheInterceptor extends HandlerInterceptorAdapter {
 
	private static final Logger LOG = LoggerFactory.getLogger(RequestCacheInterceptor.class);
	
	public RequestCacheInterceptor() {
		LOG.info("Creating DisableBrowserCachingInterceptor bean...");
	}
	
    public void postHandle(HttpServletRequest request, HttpServletResponse response, 
    		Object handler, ModelAndView modelAndView) {
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0
        response.setDateHeader("Expires", 0); // Proxies
        LOG.debug("[INTERCEPTOR] : Disable cache");
    }
}
