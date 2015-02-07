package org.yla.demo.thymeleaf.controller;

public class RequestMappingConstants {

	public static final String REDIRECT = "redirect:";
	public static final String FORWARD = "forward:";
	
	public static final String GET_HOME_PAGE = "/home";
	public static final String HOME_PAGE = "/pages/home/home";
	
	public static final String GET_LAYOUT_PAGE = "/demos/layout";
	public static final String LAYOUT_PAGE = "/pages/demos/layout";
	
	public static final String GET_LARGE_LAYOUT_PAGE = "/demos/layout-large";
	public static final String LARGE_LAYOUT_PAGE = "/pages/demos/layout-large";
	
	public static final String GET_ACCOUNT_PAGE = "/account";
	public static final String ACCOUNT_PAGE = "/pages/account/account";
	
	public static final String GET_WIDGET_FRAG = "/widget/{widgetId}";
	public static final String WIDGET_FRAG_DIR = "/fragments/widget/";
	
	public static final String GET_MODAL_FRAG = "/modal/{modalFramentName}";
	public static final String MODAL_FRAG_DIR = "/fragments/modal/";

}
