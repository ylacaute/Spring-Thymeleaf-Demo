
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// FUNCTON UTILS
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var FunctionUtils = (function () {
	"use strict";

	
	// PRIVATE
	
	
	return {

		// Get function from string, with or without scopes
		getFromString : function(functionName) {
			if (functionName == null) return null;
		    var scope = window;
		    var scopeSplit = functionName.replace("()", "").replace(";", "").split('.');
		    for (var i = 0; i < scopeSplit.length - 1; i++) {
		        scope = scope[scopeSplit[i]];
		        if (scope == undefined) return;
		    }
		    return scope[scopeSplit[scopeSplit.length - 1]];
		},
		
		// Call function from string, with or without scopes
		callFromString : function(functionName) {
			var fn = this.getFromString(functionName);
			if (fn != null && typeof fn === 'function') {
			    fn();
			}
		}
		
	}
	
})();

