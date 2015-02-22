package org.yla.demo.thymeleaf.feature.gallery;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.yla.lib.skeleton.service.BaseService;

@Service
public class GalleryService extends BaseService {

	private static final Logger LOG = LoggerFactory.getLogger(GalleryService.class);
	
	@Autowired
	private GalleryRepository galleryRepository; 
	
	@Autowired
	private MongoOperations mongoOperation;
	
	public Gallery saveGallery(Gallery gallery) {
		LOG.debug("Saving {}", gallery);
		gallery = galleryRepository.save(gallery);
		return gallery;
	}
	
	public Gallery getGallery() {
		//galleryRepository.count();
		Gallery gallery = new Gallery();
		List<String> imagesPaths = new ArrayList<>();
		String path = "/assets/img/picture/connected-objects/";
		imagesPaths.add(path + "pic01.jpg");
		imagesPaths.add(path + "pic02.jpg");
		imagesPaths.add(path + "pic03.jpg");
		imagesPaths.add(path + "pic04.jpg");
		imagesPaths.add(path + "pic05.jpg");
		imagesPaths.add(path + "pic06.jpg");
		imagesPaths.add(path + "pic07.jpg");
		imagesPaths.add(path + "pic08.jpg");
		imagesPaths.add(path + "pic01.jpg");
		imagesPaths.add(path + "pic02.jpg");
		imagesPaths.add(path + "pic03.jpg");
		imagesPaths.add(path + "pic04.jpg");
		imagesPaths.add(path + "pic05.jpg");
		imagesPaths.add(path + "pic06.jpg");
		imagesPaths.add(path + "pic07.jpg");
		imagesPaths.add(path + "pic08.jpg");
		gallery.setName("SampleImageGallery");
		gallery.setImagesPaths(imagesPaths);
		gallery.setImagesPerLines(3);
		return gallery;
	}
	
}
