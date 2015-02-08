package org.yla.demo.thymeleaf.mvc;

public class RequestMappingConstants {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* COMMON
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  	public static final String REDIRECT = "redirect:";
  	public static final String FORWARD = "forward:";
  	public static final String FRAG_STATUS_MESSAGE = "/fragment/misc/statusMessage :: message";

  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* page
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static final String GET_HOME_PAGE = "/home";
	public static final String HOME_PAGE = "/page/home/home";
	
	public static final String GET_LAYOUT_PAGE = "/demos/layout";
	public static final String LAYOUT_PAGE = "/page/demos/layout";
	
	public static final String GET_LARGE_LAYOUT_PAGE = "/demos/layout-large";
	public static final String LARGE_LAYOUT_PAGE = "/page/demos/layout-large";
	
	public static final String GET_CUSTOM_LAYOUT_PAGE = "/demos/layout-custom";
	public static final String CUSTOM_LAYOUT_PAGE = "/page/demos/layout-custom";
	
	public static final String GET_ACCOUNT_PAGE = "/account";
	public static final String ACCOUNT_PAGE = "/page/account/account";
	
	public static final String GET_WIDGET_FRAG = "/widget/{widgetId}";
	public static final String WIDGET_FRAG_DIR = "/fragment/widget/";
	
	public static final String GET_MODAL_FRAG = "/modal/{modalFramentName}";
	public static final String MODAL_FRAG_DIR = "/fragment/modal/";

	
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* FRAGMENTS
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static final String SUBMIT_CONATCTUS_FORM = "/contactUs";
	
}
