package org.yla.demo.thymeleaf.feature.gallery;

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
public class GalleryController extends BasePageController {

	private static final Logger LOG = LoggerFactory.getLogger(GalleryController.class);
	
	@Autowired
	private GalleryService galleryService;
	
	public GalleryController() {
		super(PageModelConstants.GALLERY);
	}
	
	@RequestMapping(value = RequestMappingConstants.GET_GALLERY_PAGE, method = RequestMethod.GET)
	public String getGalleryPage(Model model) {
		LOG.info("Display the gallery page");
		
		Gallery gallery = galleryService.getGallery();
		model.addAttribute("gallery", gallery);
		
		return RequestMappingConstants.GALLERY_PAGE;
	}

}
