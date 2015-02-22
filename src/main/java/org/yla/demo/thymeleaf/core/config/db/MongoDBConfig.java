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

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.PlatformTransactionManager;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

/**
 * Spring JavaConfig configuration class to setup a Spring container and infrastructure components like a
 * {@link DataSource}, a {@link EntityManagerFactory} and a {@link PlatformTransactionManager}.
 * 
 * @author Oliver Gierke
 */
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

	
	
	
	//@Autowired
	//private List<Converter<?, ?>> converters;

	/* 
	 * (non-Javadoc)
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#customConversions()
	 */
	/*
	@Override
	public CustomConversions customConversions() {
		return new CustomConversions(converters);
	}
	 */

	/*
	@Override
	protected String getMappingBasePackage() {
		return "org.yla.demo.thymeleaf.feature";
	}
	*/






	/*
	 * public MongoTemplate mongo() {
    if (null != m_) return m_;
    MongoCredential mc = null;
    if (!S.empty(password)) {
        mc = MongoCredential.createMongoCRCredential(username, db, password.toCharArray());
    }
    try {
        ServerAddress svr = new ServerAddress(host, port);
        List<MongoCredential> credentials = null == mc ? null : C.list(mc);
        MongoClient client = new MongoClient(svr, credentials);
        m_ = new MongoTemplate(client, db);
        Converter[] ca = new Converter[]{new ObCriteria.TypeWriteConverter(), new ObCriteria.TypeReadConverter()};
        CustomConversions cc = new CustomConversions(Arrays.asList(ca));
        MappingMongoConverter mmc = (MappingMongoConverter)m_.getConverter();
        mmc.setCustomConversions(cc);
        mmc.afterPropertiesSet();
        new MongoTemplateHolder().setMongoTemplate(m_);
    } catch (Exception e) {
        throw E.invalidConfiguration(e, "Error creating mongo client");
    }
    return m_;
}
	 */






	/*<!-- Activate Spring Data MongoDB repository support -->
  	<mongo:repositories base-package="org.krams.repository" />

  	<!-- MongoDB host -->
	<mongo:mongo host="${mongo.host.name}" port="${mongo.host.port}"/>

	<!-- Template for performing MongoDB operations -->
  	<bean id="mongoTemplate" class="org.springframework.data.mongodb.core.MongoTemplate" 
  			c:mongo-ref="mongo" c:databaseName="${mongo.db.name}"/>

	<!-- Service for initializing MongoDB with sample data using MongoTemplate -->
	<bean id="initMongoService" class="org.krams.service.InitMongoService" init-method="init"/>	

	 */
}
