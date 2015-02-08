package org.yla.demo.thymeleaf.mvc;

public class RequestMappingConstants {

	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* COMMON
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  	public static final String FRAG_STATUS_MESSAGE = "/fragment/misc/statusMessage :: message";

  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* PAGES
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static final String GET_HOME_PAGE = "/home";
	public static final String HOME_PAGE = "/page/home/home";
	
	public static final String GET_ACCOUNT_PAGE = "/account";
	public static final String ACCOUNT_PAGE = "/page/account/account";
	
	public static final String GET_WIDGET_FRAG = "/widget/{widgetId}";
	public static final String WIDGET_FRAG_DIR = "/fragment/widget/";
	
	public static final String GET_MODAL_FRAG = "/modal/{modalFramentName}";
	public static final String MODAL_FRAG_DIR = "/fragment/modal/";

  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* DEMO PAGES
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static final String GET_LAYOUT_PAGE = "/demos/layout";
	public static final String LAYOUT_PAGE = "/page/demos/layout";
	
	public static final String GET_LARGE_LAYOUT_PAGE = "/demos/layout-large";
	public static final String LARGE_LAYOUT_PAGE = "/page/demos/layout-large";
	
	public static final String GET_CUSTOM_LAYOUT_PAGE = "/demos/layout-custom";
	public static final String CUSTOM_LAYOUT_PAGE = "/page/demos/layout-custom";

	public static final String GET_FORM_PAGE = "/demos/form";
	public static final String FORM_PAGE = "/page/demos/form";
	
	public static final String GET_AJAXFORM_PAGE = "/demos/form-ajax";
	public static final String AJAXFORM_PAGE = "/page/demos/form-ajax";
	
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	/* FORMS
  	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
	public static final String SUBMIT_CONTACTUS_FORM = "/form/contactUs";
	public static final String SUBMIT_LOGIN_FORM = "/form/login";
}
