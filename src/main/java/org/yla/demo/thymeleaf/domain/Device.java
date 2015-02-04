package org.yla.demo.thymeleaf.domain;

import java.util.ArrayList;

public class Device extends ArrayList<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Device(String displayedValue, String code) {
		add(displayedValue);
		add(code);
	}
	
}
