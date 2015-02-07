package org.yla.lib.skeleton.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);
	
	public BaseController() {
		LOG.info("Construct {} bean...", getClass().getSimpleName());
	}
	
}
