package org.yla.demo.thymeleaf.core.mvc;

public class RequestMappingConstants {

	// CORE
  	public static final String FRAG_STATUS_MESSAGE = "/core/misc/statusMessage :: message";

  	
  	// HOME
	public static final String GET_HOME_PAGE = "/home";
	public static final String HOME_PAGE = "/feature/home/home-page";

  	// LOGIN
	public static final String GET_LOGIN_PAGE = "/login";
	public static final String LOGIN_PAGE = "/feature/login/login-page";
	public static final String SUBMIT_LOGIN_FORM = "/form/login";

  	// ACCOUNT
	public static final String GET_ACCOUNT_PAGE = "/account";
	public static final String ACCOUNT_PAGE = "/feature/account/account-page";

  	// PLUGIN
	public static final String GET_PLUGIN_PAGE = "/plugin";
	public static final String PLUGIN_PAGE = "/feature/plugin/plugin-page";

  	// GALLERY
	public static final String GET_GALLERY_PAGE = "/gallery";
	public static final String GALLERY_PAGE = "/feature/gallery/gallery-page";
	
  	// DASHBOARD
	public static final String GET_DASHBOARD_PAGE = "/dashboard";
	public static final String DASHBOARD_PAGE = "/feature/dashboard/dashboard-page";
	public static final String DASHBORD_CONFIG = "/dashboard/config/{configId}";
	
	public static final String GET_WIDGET_FRAG = "/widget/{widgetId}";
	public static final String WIDGET_FRAG_DIR = "/feature/dashboard/widget/";
	
	// CONTACT (USED IN DEMO)
	public static final String GET_CONTACTUS_FORM_FRAG = "/form/contactUs";
	public static final String CONTACTUS_FORM_FRAG = "/feature/demo/form/contact-us";
	
	// DEMO
	public static final String GET_DEMO_FORM_PAGE = "/demo/form/{formPageName}";
	public static final String DEMO_FORM_PAGE = "/feature/demo/form-";
	public static final String SUBMIT_CONTACTUS_FORM = "/form/contactUs";

	public static final String GET_LAYOUT_PAGE = "/demo/layout";
	public static final String LAYOUT_PAGE = "/feature/demo/layout-page";
	public static final String GET_LARGE_LAYOUT_PAGE = "/demo/layout-large";
	public static final String LARGE_LAYOUT_PAGE = "/feature/demo/layout-large-page";
	public static final String GET_CUSTOM_LAYOUT_PAGE = "/demo/layout-custom";
	public static final String CUSTOM_LAYOUT_PAGE = "/feature/demo/layout-custom-page";

	public static final String GET_MODAL_FRAG = "/modal/{modalFramentName}";
	public static final String MODAL_FRAG_DIR = "/feature/demo/modal/";

}
