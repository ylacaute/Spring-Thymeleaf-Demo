
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// PAGE CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var PageController = (function () {
	"use strict";

	// PRIVATE
	
	
	
	
	return {

		// PUBLIC
		
		onLoad : function() {
			// Do anything here which required the full page load
	    	console.log("Generic page fully loaded.");
		},
		
		onReady : function() {
	    	// Do load stuff here (page not fully loaded)
	    	console.log("Generic page ready.");
			$('#showModalBtn').click(function() {
 				$('#sampleModal').modal();
 			});
		}
		
	}
	
})();