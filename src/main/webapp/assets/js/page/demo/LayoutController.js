// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// LAYOUT CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var LayoutController = (function () {
	"use strict";
	
	// PRIVATE ------------------------------------------------------------------------------------
	
	var URL = {
		modal : "/modal/"
	};

	var modalReceiverId = "modalReceiver";
	
	return {
		
		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Demos Layout page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Demos Layout page ready.");
		},
		
		loadWidget : function(domReceiverId, widgetId) {
			var url = Constants.CONTEXT_PATH + Constants.WIDGET_FRAG_URL + widgetId;
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