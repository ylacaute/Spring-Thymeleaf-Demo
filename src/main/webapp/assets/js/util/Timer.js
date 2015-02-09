  
  var Timer = function(intervalMS, seconds, tickFunction) {        
  	
    // Frequency of elapse event of the timer in millisecond
  	var Interval = intervalMS;
  	
    // Whether the timer is enable or not
    var Enable = new Boolean(false);
    
 		// Each tick this function is called
    var Tick = tickFunction;
 		
    // Hold interval id of the timer
    var timerId = 0;
    
    // Hold instance of this class
   // var thisObject;
    
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

			start : function() {
	    	Enable = new Boolean(true);
		    if (Enable) {
			    timerId = setInterval(function() {
			    	totalSeconds++;
		        var hours   = Math.floor(totalSeconds / 3600);
			      var minutes = Math.floor((totalSeconds - (hours * 3600)) / 60);
			      var seconds = totalSeconds - (hours * 3600) - (minutes * 60);
			      Tick(pad(hours), pad(seconds), pad(minutes)); 
			    }, Interval);
		    }
	    },
		
		  stop : function() {            
		  	Enable = new Boolean(false);
		  	clearInterval(timerId);
		  },
	    
	    isRunning : function() {
	    	return Enable == true;
	    },
		  
		  setTickFunction : function(newTickFunction) {
		  	Tick = newTickFunction;
		  }
		
		};
  };
  
  
  
 