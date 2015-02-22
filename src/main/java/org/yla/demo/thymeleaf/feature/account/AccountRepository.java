package org.yla.demo.thymeleaf.feature.account;

import org.springframework.data.mongodb.repository.MongoRepository;

//http://docs.spring.io/spring-data/data-mongo/docs/1.4.0.RC1/reference/html/mongo.repositories.html


public interface AccountRepository extends MongoRepository<Account, String> {

}
