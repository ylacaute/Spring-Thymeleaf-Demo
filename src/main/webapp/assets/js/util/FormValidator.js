
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// FORM VALIDATOR
// Nice article : http://www.html5rocks.com/en/tutorials/forms/constraintvalidation
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var FormValidator = (function () {
	"use strict";
	
	// PRIVATE ------------------------------------------------------------------------------------

	return {
		
		// PUBLIC ---------------------------------------------------------------------------------
		
		resetValidation : function(input) {
			input.setCustomValidity("");
		},
		
		onInvalid : function(input, emptyMsg, patternMsg, sizeMsg) {
			if (input.validity.valueMissing) {
				input.setCustomValidity(emptyMsg);
			} else if (input.validity.patternMismatch) {
				input.setCustomValidity(patternMsg);
			} else if (input.validity.rangeOverflow || input.validity.rangeUnderflow || input.validity.tooLong) {
				input.setCustomValidity(sizeMsg);
			}
			// We user default message for typeMismatch
		},
		
		validate : function(event) {
			/*
			If we want size validation of an input text, we have to do it manually and hack
			the submit event.
		 	var minLength = $(input).attr("minlength") || 0;
			var maxLength = $(input).attr("maxlength") || 64000;
			var inputValue = $(input).val();
			console.log("InputValue:" + inputValue + ", min:" + minLength + ", max:" + maxLength);
			if (inputValue < minLength || inputVale > maxLength) {
				input.setCustomValidity(sizeMsg);
				event.preventDefault();
			}
		 */
		}
		
		
		
	}

})();
