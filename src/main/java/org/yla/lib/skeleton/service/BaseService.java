package org.yla.lib.skeleton.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseService {

	private static final Logger LOG = LoggerFactory.getLogger(BaseService.class);
	
	public BaseService() {
		LOG.info("Construct {} bean...", getClass().getSimpleName());
	}
	
}
