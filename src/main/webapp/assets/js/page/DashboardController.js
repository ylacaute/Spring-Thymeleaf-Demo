// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// DASHBOARD CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var DashboardController = (function () {
	"use strict";

	// PRIVATE ------------------------------------------------------------------------------------
	
	var MODE = {
			VIEW : false,
			EDIT : true
	};
	
	var currentMode = MODE.VIEW;
	
	var firstWidgetReceiver = ".sortable-first-container";
	
	function setMode(mode) {
		if (mode == MODE.VIEW) {
			$(".sortable-section").removeClass("sortable-edit-mode");
			$(".sortable-section").addClass("sortable-view-mode");
			$(".sortable-container").enableSelection();
		} else {
			$(".sortable-section").removeClass("sortable-view-mode");
			$(".sortable-section").addClass("sortable-edit-mode");
			$(".sortable-container").disableSelection();
		}
	};
	
	function configureLayout() {
		$("#col3layout").click(function() {
			$("#sortable-by-col div:nth-child(4)").hide();
			$("#sortable-by-col .col-sm-3").addClass("col-sm-4");
			$("#sortable-by-col .col-sm-4").removeClass("col-sm-3");
		});
		$("#col4layout").click(function() {
			$("#sortable-by-col div:nth-child(4)").show();
			$("#sortable-by-col .col-sm-4").addClass("col-sm-3");
			$("#sortable-by-col .col-sm-3").removeClass("col-sm-4");
		});
	}
	
	return {

		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Dashboard page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Dashboard page ready.");
			$("div.droptrue").sortable({
				connectWith: ".sortable-container",
				cancel: ".sortable-view-mode .sortable-container"
			});
			$("#editSortableBtn").click(function() { setMode(MODE.EDIT) });
			$("#viewSortableBtn").click(function() { setMode(MODE.VIEW) });
			setMode(MODE.VIEW);
			configureLayout();
		},
		
		addWidget : function(widgetId) {
			var url = Constants.CONTEXT_PATH + Constants.WIDGET_FRAG_URL + widgetId;
			$.ajax({
				type: "GET",
				url: url,
			    success: function (responseText, textStatus, xhr) {
			    	$(firstWidgetReceiver).append(responseText);
			    }
			});
		}
		
	}
	
})();
