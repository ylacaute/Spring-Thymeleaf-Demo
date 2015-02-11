// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// GLOBAL CONSTANTS
// The context path is initialized by Thymeleaf with the site layout
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var Constants = {
	//"use strict";
	
	// If you can use thymeleaf to construct your URLs, you will not need this.
	// But if you want do a call in JS file, you have to add the context path.
	CONTEXT_PATH : "",

	// This URL part can be used to load any widget
	// Usage : 
	//   var url = Constants.CONTEXT_PATH + Constants.WIDGET_FRAG_URL + widgetId;
	//   $.ajax ... or directly with JQuery load function
	WIDGET_FRAG_URL : "/widget/",

	// This URL part can be used to load any modal window
	// Usage : 
	//   var url = Constants.CONTEXT_PATH + Constants.MODAL_FRAG_URL + modalFragmentName;
	MODAL_FRAG_URL : "/modal/"
		
};