
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// FORM CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var FormController = (function () {
	"use strict";
	

	// PRIVATE
	
	var URL = {
		modal : "/modal/",
		widget : "/widget/"
	};

	var modalReceiverId = "modalReceiver";
	
	return {
		
		// PUBLIC
		
		onLoad : function() {
			// Do anything here which required the full page load
	    	console.log("Demos form page fully loaded.");
		},
		
		onReady : function() {
	    	// Do load stuff here (page not fully loaded)
	    	console.log("Demos form page ready.");
		},
		
		submit : function(event, submitUrl) {
			var $form = $('#contact-us-form');
			
			// Nothing to do, the broswer will display the invalid messages. 
			if (!$form[0].checkValidity()) return;
			
			// Avoid the browser submit in order to do it in Ajax. 
			event.preventDefault();
		    var request = $.ajax({
		        url: submitUrl,
		        type: "post",
		        data: $form.serialize()
		    });
		    request.done(function (response, textStatus, jqXHR){
		        // Log a message to the console
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