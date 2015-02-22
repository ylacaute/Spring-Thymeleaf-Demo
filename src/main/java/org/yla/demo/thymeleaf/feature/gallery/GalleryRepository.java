package org.yla.demo.thymeleaf.feature.gallery;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

//http://docs.spring.io/spring-data/data-mongo/docs/1.4.0.RC1/reference/html/mongo.repositories.html


public interface GalleryRepository extends MongoRepository<Gallery, Long> {

	List<Gallery> findByName(String name);
	
}
