
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
		
		submit : function(event) {
			// We must cancel the submit action by the browser but still want the validation
			//event.preventDefault();
			
			var $myForm = $('#contact-us-form');
			if (!$myForm[0].checkValidity()) {
			  // If the form is invalid, submit it. The form won't actually submit;
			  // this will just cause the browser to display the native HTML5 error messages.
			  //$myForm.find(':submit').click();
				//$('<input type="submit">').hide().appendTo($myForm).click().remove();
				//alert("form ready to submit in ajax");
			} else {
				//alert("what 2 ? :)");
				event.stopPropagation();
				event.preventDefault();
			}
		}
		
	}
	
})();