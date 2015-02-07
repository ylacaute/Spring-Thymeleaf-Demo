package org.yla.demo.thymeleaf.service.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.yla.lib.skeleton.service.BaseService;

@Service
public class AccountService extends BaseService {

	@Value("${messages.cacheReloading}")
	private int messagesCacheReloading;
	
	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
}
