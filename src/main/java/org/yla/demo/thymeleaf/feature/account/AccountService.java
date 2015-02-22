package org.yla.demo.thymeleaf.feature.account;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yla.lib.skeleton.service.BaseService;

@Service
public class AccountService extends BaseService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
	private AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public List<Account> getAllAccounts() {
		LOG.debug("getAllAccounts...");
		return accountRepository.findAll();
	}

	public Account saveAccount(Account account) {
		LOG.debug("saveAccount...");
		return accountRepository.save(account);
	}
	
	//private static final Logger LOG = LoggerFactory.getLogger(AccountService.class);
	
}
