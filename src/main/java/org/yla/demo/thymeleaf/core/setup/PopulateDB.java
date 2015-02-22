package org.yla.demo.thymeleaf.core.setup;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.yla.demo.thymeleaf.feature.account.Account;
import org.yla.demo.thymeleaf.feature.account.Name;
import org.yla.demo.thymeleaf.feature.account.Title;

@Component
public class PopulateDB {

	private static final Logger LOG = LoggerFactory.getLogger(PopulateDB.class);
	
	public PopulateDB() {
		LOG.info("Creating PopulateDB bean...");
	}
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@PostConstruct
	public void populate() {
		LOG.info("Populate database...");
		mongoTemplate.dropCollection("gallery");
		mongoTemplate.dropCollection("account");

		Account account = new Account();
		account.setId(UUID.randomUUID().toString());
		account.setEmail("a@a.com");
		account.setName(new Name(Title.MR, "John", "Doe"));
		
		mongoTemplate.insert(account, "account");
	}

}
