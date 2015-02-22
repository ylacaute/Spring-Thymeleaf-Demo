package org.yla.demo.thymeleaf.feature.account;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.yla.demo.thymeleaf.core.mvc.PageModelConstants;
import org.yla.demo.thymeleaf.core.mvc.RequestMappingConstants;
import org.yla.lib.skeleton.mvc.BasePageController;

@Controller
public class AccountController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);
	
	private AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		super(PageModelConstants.ACCOUNT);
		this.accountService = accountService;
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_ACCOUNT_PAGE, method = RequestMethod.GET)
	public String getAccountPage(Model model) {
		LOG.info("Display the account page");
		
		List<Account> accounts = accountService.getAllAccounts();
		model.addAttribute("accounts", accounts);
		LOG.info("{} acounts found", accounts.size());
		
		return RequestMappingConstants.ACCOUNT_PAGE;
	}

}
