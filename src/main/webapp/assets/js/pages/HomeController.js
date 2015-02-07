
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// HOME CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var HomeController = (function () {
	"use strict";

	var URL = {
		widget : "/widget/"
		
	};

	// PRIVATE
	
	
	
	return {

		// PUBLIC
		
		onLoad : function() {
			// Do anything here which required the full page load
	    	console.log("Home page fully loaded.");
		},
		
		onReady : function() {
	    	// Do load stuff here (page not fully loaded)
	    	console.log("Home page ready.");
			$('#showModalBtn').click(function() {
 				$('#sampleModal').modal();
 			});
		},
		
		loadWidget : function(domReceiverId, widgetId) {
			var url = Constants.CONTEXT_PATH + URL.widget + widgetId;
			console.log("Url : " + url);
			$("#" + domReceiverId).load(url);
			
		}
		
		
		
	}
	
})();