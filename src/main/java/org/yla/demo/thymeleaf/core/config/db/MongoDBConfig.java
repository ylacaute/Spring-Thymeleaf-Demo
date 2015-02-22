/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.yla.demo.thymeleaf.core.config.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Configuration
@EnableMongoRepositories("org.yla.demo.thymeleaf.feature")
class MongoDBConfig extends AbstractMongoConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(MongoDBConfig.class);

	public MongoDBConfig() {
		LOG.info("Creating MongoDBConfig bean...");
	}

	@Override
	protected String getDatabaseName() {
		return "test-db";
	}

	//http://blog.mongodirector.com/understanding-durability-write-safety-in-mongodb/
	@Bean
	@Override
	public Mongo mongo() throws Exception {

		Mongo mongo = new MongoClient("127.0.0.1", 27017);
		mongo.setWriteConcern(WriteConcern.SAFE);

		return mongo;
	}

}
