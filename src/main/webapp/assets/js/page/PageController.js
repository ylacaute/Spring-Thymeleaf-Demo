// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// PAGE CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var PageController = (function () {
	"use strict";

	// PRIVATE ------------------------------------------------------------------------------------
	
	return {

		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Generic page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Generic page ready.");
			$('#showModalBtn').click(function() {
 				$('#sampleModal').modal();
 			});
		}
		
	}
	
})();