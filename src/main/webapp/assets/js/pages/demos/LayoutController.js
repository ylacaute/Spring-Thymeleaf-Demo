
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// HOME CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var LayoutController = (function () {
	"use strict";

	var URL = {
		modal : "/modal/",
		widget : "/widget/"
	};

	var modalReceiverId = "modalReceiver";
	
	// PRIVATE
	
	
	
	return {

		// PUBLIC
		
		onLoad : function() {
			// Do anything here which required the full page load
	    	console.log("Demos Layout page fully loaded.");
		},
		
		onReady : function() {
	    	// Do load stuff here (page not fully loaded)
	    	console.log("Demos Layout page ready.");
		},
		
		loadWidget : function(domReceiverId, widgetId) {
			var url = Constants.CONTEXT_PATH + URL.widget + widgetId;
			console.log("Url : " + url);
			$("#" + domReceiverId).load(url);
		},
		
		loadModal : function(modalFragmentName) {
			var url = Constants.CONTEXT_PATH + URL.modal + modalFragmentName;
			$("#" + modalReceiverId).load(url, function() {
				LayoutController.showModal(modalFragmentName);
			});
		},
		
		showModal : function(modalId) {
			$("#" + modalId).modal();
		}
		
	}
	
})();