// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// TIMER CLASS
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------

var Timer = function(tickFrequencyMS, seconds, userTickFunction) {        
	"use strict";
	
	// PRIVATE ------------------------------------------------------------------------------------
	
    // Frequency of elapse event of the timer in millisecond
	var tickFrequency = tickFrequencyMS;

	// Whether the timer is enable or not
	var enable = false;

	// Each tick this function is called
	var tickFunction = userTickFunction;
	
	// Hold interval id of the timer
	var timerId = 0;

	// Elapsed time
	var totalSeconds = seconds;
	
	var pad = function(val) {
		var valString = val + "";
		if (valString.length < 2) {
			return "0" + valString;
		} else {
			return valString;
		}
	};
		
	return {

		// PUBLIC ---------------------------------------------------------------------------------
		
		start : function() {
			enable = true;
		    if (enable) {
			    timerId = setInterval(function() {
			    	totalSeconds++;
			    	var hours   = Math.floor(totalSeconds / 3600);
			    	var minutes = Math.floor((totalSeconds - (hours * 3600)) / 60);
			    	var seconds = totalSeconds - (hours * 3600) - (minutes * 60);
			    	tickFunction(pad(hours), pad(seconds), pad(minutes)); 
			    }, tickFrequency);
		    }
	    },
	
		stop : function() {            
		  	enable = false;
		  	clearInterval(timerId);
		},
    
	    isRunning : function() {
	    	return enable;
	    },
	  
	    setTickFunction : function(newTickFunction) {
	    	tickFunction = newTickFunction;
	    }
	
	};
	
  };
  
  
  
 