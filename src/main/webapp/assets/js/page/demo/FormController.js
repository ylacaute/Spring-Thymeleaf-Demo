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
	    	console.log("demo form page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("demo form page ready.");
		},
		
		submit : function(event, submitUrl, formId) {
			var $form = $('#' + formId);
			// Force the HTML5 validation, if invalid nothing to do (and the browser will display the invalid messages) 
			if (!$form[0].checkValidity()) return;
			// Avoid the browser submit in order to do it in AJAX. 
			event.preventDefault();
		    var request = $.ajax({
		        url: submitUrl,
		        type: "post",
		        data: $form.serialize()
		    });
		    request.done(function (response, textStatus, jqXHR){
		    	$('#' + formId).replaceWith(response);
		    	if (!$('#' + formId).find(".has-error").length) {
		    		var redirect = Constants.CONTEXT_PATH + $('#' + formId + " .successRedirect").val();
		    		console.log("Form validated : redirect to " + redirect);
		    		window.location = redirect;
		    	}
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