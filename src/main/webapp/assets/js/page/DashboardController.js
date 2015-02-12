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
			config : "/dashboard/config/"
	};
	var SORTABLE_DOM = {
			line : '<div class="row sortable-row"></div>',
			containerWrapper : '<div class="sortable-container-wrapper"></div>',
			container : '<div class="droptrue sortable-container"></div>',
			closeBtn : '<button class="close sortable-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button>',
			widgetWrapper : '<div class="widget-wrapper"></div>'
	};
	
	var widgetCounter = 0;
	var currentMode;
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
	
	function loadWidget(widgetUri, $container) {
		var url = Constants.CONTEXT_PATH + widgetUri;
		$.ajax({
			type: "GET",
			url: url,
		    success: function(responseText, textStatus, xhr) {
		    	$container.append(createWidgetWrapper(responseText, widgetUri));
		    },
		    fail: function() {
		    	console.log("WARN : the widget '" + widgetUri + "' has not been loaded.");
		    }
		});
	};
	
	function createWidgetWrapper(widgetHtml, widgetUri) {
		var $widgetWrapper = $(SORTABLE_DOM.widgetWrapper);
		var $widgetWrapperCloseBtn = $(SORTABLE_DOM.closeBtn);
		$widgetWrapper.append($widgetWrapperCloseBtn);
		$widgetWrapper.append(widgetHtml);
		$widgetWrapper.data("widgetUri", widgetUri);
		$widgetWrapperCloseBtn.click(function(event) {
			$(this).parent().remove();
		});
		return $widgetWrapper;
	};
	
	function addLine(containers, lineIndex) {
		var $line = $(SORTABLE_DOM.line);
		for (var i = 0; i < containers.length; i++) {
			var $containerWrapper = $(SORTABLE_DOM.containerWrapper);
			var $container = $(SORTABLE_DOM.container);
			if (lineIndex == 0 && i == 0) {
				$container.addClass(firstContainerClass);
			}
			$containerWrapper.append($container);
			$containerWrapper.addClass(containers[i].cssClass);
			var widgets = containers[i].widgets;
			if (widgets != null) {
				for (var j = 0; j < widgets.length; j++) {
					loadWidget(widgets[j].fragmentUri, $container);
				}
			}
			$line.append($containerWrapper);
		}
		$(".sortable-section").append($line);
	};

	function buildConfiguration(dashboardConfig) {
		console.log("Loading dashboard configuration (nbLines=" + dashboardConfig.nbLines + ")");
		for (var i = 0; i < dashboardConfig.lines.length; i++) {
			var currentLine = dashboardConfig.lines[i];
			addLine(currentLine.containers, i);
		}
	};
	
	function loadConfiguration(configId) {
		var config;
		var request = $.ajax({
			type: "GET",
			dataType: "json",
			url: Constants.CONTEXT_PATH + URLS.config + configId,
			cache: false
		});
		request.done(function(responseText, textStatus, xhr) {
			clearLayout();
			buildConfiguration(responseText);
			initConfiguration();
		});
	};
	
	function initConfiguration() {
		$("div.droptrue").sortable({
			connectWith: ".sortable-container",
			cancel: ".sortable-view-mode .sortable-container"
		});
	};
	
	function saveConfiguration() {
		alert("TODO :)");
	};

	function clearLayout() {
		$(".sortable-section").empty();
	};
	
	function clearWidgets() {
		$(".sortable-container").empty();
	};
	
	return {

		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Dashboard page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Dashboard page ready.");
			$("#editSortableBtn").click(function() { setMode(MODE.EDIT); });
			$("#viewSortableBtn").click(function() { setMode(MODE.VIEW); });
			$("#saveBtn").click(function() { saveConfiguration(); });
			$("#clearBtn").click(function() { clearWidgets(); });
			
			$("#layout1Btn").click(function() { loadConfiguration(1); });
			$("#layout2Btn").click(function() { loadConfiguration(2); });

			$("#config1Btn").click(function() { loadConfiguration(10); });
			$("#config2Btn").click(function() { loadConfiguration(11); });
			
			$("button").click(function() { $(this).blur(); });
			
			setMode(MODE.VIEW);
			loadConfiguration(1);
		},
		
		addWidget : function(widgetUri) {
			loadWidget(widgetUri, $("." + firstContainerClass));
		},
		
		logTree : function(lineIndex, colIndex) {
			var $lines = $(".sortable-section").children();
			for (var i = 0; i < $lines.length; i++) {
				console.log("LINE " + i);
				var $line = $lines.eq(i);
				var $containerWrappers = $line.children();
				for (var j = 0; j < $containerWrappers.length; j++) {
					console.log("  CONTAINER WRAPPER " + j);
					var $containerWrapper = $containerWrappers.eq(j);
					for (var k = 0; k < $containerWrapper.length; k++) {
						console.log("    CONTAINER " + k);
						var $container = $containerWrapper.find(".sortable-container");
						var $widgetWrappers = $container.children();
						for (var w = 0; w < $widgetWrappers.length; w++) {
							console.log("      WIDGET WRAPPER " + w);
							var $widgetWrapper = $widgetWrappers.eq(w);
							console.log("        Widget : " + $widgetWrapper.data("widgetUri"));
						}
					}
				}
			}
		}
	}
	
})();

