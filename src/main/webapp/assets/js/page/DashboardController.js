// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
// DASHBOARD CONTROLLER
// ------------------------------------------------------------------------------------------------
// ------------------------------------------------------------------------------------------------
var DashboardController = (function () {
	"use strict";

	// PRIVATE ------------------------------------------------------------------------------------
	
	var MODE = { VIEW : "view", EDIT : "edit", FLY : "fly" };
	var URLS = {
			config : "/dashboard/config/"
	};
	var SORTABLE_DOM = {
			sortable : "div.droptrue",
			line : '<div class="row sortable-row"></div>',
			containerWrapper : '<div class="sortable-container-wrapper"></div>',
			container : '<div class="droptrue sortable-container"></div>',
			closeBtn : '<button class="close sortable-close" aria-label="Close" type="button"><span aria-hidden="true">×</span></button>',
			widgetWrapper : '<div class="widget-wrapper"></div>'
	};
	
	var dragStartCssClass = "drag-start";
	var currentMode;
	var firstContainerClass = "sortable-first-container";
	
	function reloadMode() {
		if (currentMode == null) {
			currentMode = MODE.VIEW;
		}
		setMode(currentMode);
	}
	
	function setMode(mode) {
		switch(mode) {
		case MODE.VIEW:
			$(".sortable-section").removeClass("sortable-edit-mode");
			$(".sortable-section").removeClass("sortable-fly-mode");
			$(".sortable-section").addClass("sortable-view-mode");
			$(".sortable-container").enableSelection();
			$(".sortable-toolbar").hide();
			$(".sortable-container").sortable("disable");
			break;
		case MODE.EDIT:
			$(".sortable-section").removeClass("sortable-view-mode");
			$(".sortable-section").removeClass("sortable-fly-mode");
			$(".sortable-section").addClass("sortable-edit-mode");
			$(".sortable-container").disableSelection();
			$(".sortable-toolbar").show();
			$(".sortable-container").sortable("enable");
			break;
		case MODE.FLY:
			$(".sortable-section").removeClass("sortable-edit-mode");
			$(".sortable-section").removeClass("sortable-view-mode");
			$(".sortable-section").addClass("sortable-fly-mode");
			$(".sortable-container").disableSelection();
			$(".sortable-toolbar").show();
			$(".sortable-container").sortable("enable");
			break;
		}
		currentMode = mode;
	};
	
	function generateConfiguration() {
		var config = new Object();
		config.lines = [];
		var $lines = $(".sortable-section").children();
		for (var i = 0; i < $lines.length; i++) {
			var $line = $lines.eq(i);
			var $containerWrappers = $line.children();
			var line = new Object();
			config.lines.push(line);
			line.containers = [];
			for (var j = 0; j < $containerWrappers.length; j++) {
				var $containerWrapper = $containerWrappers.eq(j);
				for (var k = 0; k < $containerWrapper.length; k++) {
					var $container = $containerWrapper.find(".sortable-container");
					var $widgetWrappers = $container.children();
					var container = new Object();
					container.cssClass = $containerWrapper.data("cssClass");
					container.widgets = [];
					line.containers.push(container);
					for (var w = 0; w < $widgetWrappers.length; w++) {
						var $widgetWrapper = $widgetWrappers.eq(w);
						console.log(" Widget : " + $widgetWrapper.data("widgetUri"));
						var widget = new Object();
						widget.fragmentUrl = $widgetWrapper.data("widgetUri");
						container.widgets.push(widget);
					}
				}
			}
		}
		return config;
	};
	
	function loadWidget(widgetUri, $container) {
		var url = Constants.CONTEXT_PATH + widgetUri;
		var loaderImgSrc = Constants.CONTEXT_PATH + "/assets/img/loader/ajax-loader-small.gif";
		$container.append('<div class="loader"><img src="' + loaderImgSrc + '" alt="loading"></img><p>Please wait...</p></div>');
		$.ajax({
			type: "GET",
			url: url,
		    success: function(responseText, textStatus, xhr) {
		    	$container.find(">:first-child").remove();
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
		$widgetWrapper.append(widgetHtml);
		$widgetWrapper.find(">:first-child").addClass(dragStartCssClass);
		$widgetWrapper.prepend($widgetWrapperCloseBtn);
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
			$containerWrapper.data("cssClass", containers[i].cssClass);
			var widgets = containers[i].widgets;
			if (widgets != null) {
				for (var j = 0; j < widgets.length; j++) {
					loadWidget(widgets[j].fragmentUrl, $container);
				}
			}
			$line.append($containerWrapper);
		}
		$(".sortable-section").append($line);
	};

	function buildConfiguration(dashboardConfig) {
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
			reloadMode();
			console.log(">> " + currentMode);
		});
	};
	
	function initConfiguration() {
		$(SORTABLE_DOM.sortable).sortable({
			connectWith: ".sortable-container",
			cursor: "move",
			handle: "." + dragStartCssClass,
			//revert: true, Nice to have animation but not beautiful if column width aren't the same
			tolerance: "pointer",
			update: onUpdate,
			start: onDragStart,
			stop: onDragStop
		});
	};
	
	function saveConfiguration() {
		var jsonConfig = generateConfiguration();
		var request = $.ajax({
			type: "POST",
			data: JSON.stringify(jsonConfig),
			dataType: "json",
			contentType: 'application/json; charset=utf-8',
			url: Constants.CONTEXT_PATH + URLS.config + 3
		});
		request.done(function(responseText, textStatus, xhr) {
			log.consoled("Configuration successfully saved.");
		});
	};

	function clearLayout() {
		$(".sortable-section").empty();
	};
	
	function clearWidgets() {
		$(".sortable-container").empty();
	};
	
	function onDragStart(event, ui) {
		switch(currentMode) {
		case MODE.FLY:
			$(".sortable-section").addClass("sortable-edit-mode");
			break;
		}
	};

	function onDragStop(event, ui) {
		switch(currentMode) {
		case MODE.FLY:
			$(".sortable-section").removeClass("sortable-edit-mode");
			break;
		}
	};
	
	function onUpdate(event, ui) {
		switch(currentMode) {
		case MODE.FLY:
			$(".sortable-section").removeClass("sortable-edit-mode");
			break;
		}
	};
	
	return {

		// PUBLIC ---------------------------------------------------------------------------------
		
		onLoad : function() {
	    	console.log("Dashboard page fully loaded.");
		},
		
		onReady : function() {
	    	console.log("Dashboard page ready.");
			$("#editModeBtn").click(function() { setMode(MODE.EDIT); });
			$("#viewModeBtn").click(function() { setMode(MODE.VIEW); });
			$("#flyModeBtn").click(function() { setMode(MODE.FLY); });
			
			$("#saveBtn").click(function() { saveConfiguration(); });
			$("#clearBtn").click(function() { clearWidgets(); });
			
			$("#layout1Btn").click(function() { loadConfiguration(1); });
			$("#layout2Btn").click(function() { loadConfiguration(2); });

			$("#config1Btn").click(function() { loadConfiguration(10); });
			$("#config2Btn").click(function() { loadConfiguration(11); });
			$("#userConfigBtn").click(function() { loadConfiguration(-1); });
			
			$("button").click(function() { $(this).blur(); });
			
			loadConfiguration(-1);
		},
		
		addWidget : function(widgetUri) {
			loadWidget(widgetUri, $("." + firstContainerClass));
		},
		
		logTree : function() {
			var jsonConfig = generateConfiguration();
			var jsonAsString = JSON.stringify(jsonConfig);
			console.log(jsonAsString);
		}
	}
	
})();

