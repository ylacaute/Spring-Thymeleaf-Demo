// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// DASHBOARD CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var DashboardController = (function () {
	"use strict";

	// PRIVATE ------------------------------------------------------------------------------------
	
	var MODE = { VIEW : false, EDIT : true };
	var URLS = {
			config : "/dashboard/config"
	};
	var SORTABLE_DOM = {
			line : '<div class="row sortable-row"></div>',
			containerWrapper : '<div class="sortable-container-wrapper"></div>',
			container : '<div class="droptrue sortable-container"></div>',
	};
	
	var currentMode = MODE.VIEW;
	var firstContainerClass = "sortable-first-container";
	
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
	
	function addLine(containers, lineIndex) {
		var $line = $(SORTABLE_DOM.line);
		for (var i = 0; i < containers.length; i++) {
			console.log(" - building container [" + i + "]");
			var $container = $(SORTABLE_DOM.container);
			if (lineIndex == 0 && i == 0) {
				$container.addClass(firstContainerClass);
			}
			var $containerWrapper = $(SORTABLE_DOM.containerWrapper);
			$containerWrapper.addClass(containers[i].cssClass);
			$containerWrapper.append($container);
			$line.append($containerWrapper);
		}
		$(".sortable-section").append($line);
	};

	function buildConfiguration(dashboardConfig) {
		console.log("Loading dashboard configuration (nbLines=" + dashboardConfig.nbLines + ")");
		$(".sortable-section").empty();
		for (var i = 0; i < dashboardConfig.lines.length; i++) {
			var currentLine = dashboardConfig.lines[i];
			console.log("Building line [" + i + "] with " + currentLine.containers.length + " containers.");
			addLine(currentLine.containers, i);
		}
	};
	
	function loadConfiguration(configId) {
		var config;
		var request = $.ajax({
			type: "POST",
			dataType: "json",
			url: Constants.CONTEXT_PATH + URLS.config + "/" + configId,
			cache: false
		});
		request.done(function(responseText, textStatus, xhr) {
			buildConfiguration(responseText);
			initConfiguration();
		});
	};
	
	function initConfiguration() {
		$("div.droptrue").sortable({
			connectWith: ".sortable-container",
			cancel: ".sortable-view-mode .sortable-container"
		});
	}

	return {

		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Dashboard page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Dashboard page ready.");
			$("#editSortableBtn").click(function() { setMode(MODE.EDIT) });
			$("#viewSortableBtn").click(function() { setMode(MODE.VIEW) });
			setMode(MODE.VIEW);
			$("#layout1Btn").click(function() { loadConfiguration(1); });
			$("#layout2Btn").click(function() { loadConfiguration(2); });
			loadConfiguration(1);
		},
		
		addWidget : function(widgetId) {
			var url = Constants.CONTEXT_PATH + Constants.WIDGET_FRAG_URL + widgetId;
			$.ajax({
				type: "GET",
				url: url,
			    success: function (responseText, textStatus, xhr) {
			    	$("." + firstContainerClass).append(responseText);
			    }
			});
		}
		
		
		
	}
	
})();

