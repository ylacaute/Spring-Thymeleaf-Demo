// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// FORM CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var FormController = (function () {
	"use strict";

	// PRIVATE ------------------------------------------------------------------------------------

	return {
		
		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Demos form page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Demos form page ready.");
		},
		
		submit : function(event, submitUrl) {
			var $form = $('#contact-us-form');
			// Nothing to do, the browser will display the invalid messages. 
			if (!$form[0].checkValidity()) return;
			// Avoid the browser submit in order to do it in AJAX. 
			event.preventDefault();
		    var request = $.ajax({
		        url: submitUrl,
		        type: "post",
		        data: $form.serialize()
		    });
		    request.done(function (response, textStatus, jqXHR){
		        $("#messageReceiver").append(response);
		    });
		    request.fail(function (jqXHR, textStatus, errorThrown){
		        console.error( "The following error occurred: " + textStatus, errorThrown);
		    });
		}
		
	}
	
})();

/*

// Constructor
BasePage.call(this);


// Define inheritance
FormControllerClass.prototype = Object.create(BasePage.prototype);

// Make a global variable
var FormController = new FormControllerClass();

*/