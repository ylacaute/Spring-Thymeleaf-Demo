package org.yla.demo.thymeleaf.feature.gallery;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Gallery {

	@Id
	private String id;
	
	private String name;
	private List<String> imagesPaths;
	private int imagesPerLines;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getImagesPaths() {
		return imagesPaths;
	}
	
	public void setImagesPaths(List<String> imagesPaths) {
		this.imagesPaths = imagesPaths;
	}

	public int getImagesPerLines() {
		return imagesPerLines;
	}

	public void setImagesPerLines(int imagesPerLines) {
		this.imagesPerLines = imagesPerLines;
	}
	
}
