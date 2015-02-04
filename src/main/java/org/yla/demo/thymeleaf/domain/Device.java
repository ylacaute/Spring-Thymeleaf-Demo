package org.yla.demo.thymeleaf.domain;

import java.util.ArrayList;

public class Device extends ArrayList<String> {

	public Device(String displayedValue, String code) {
		add(displayedValue);
		add(code);
	}
	
}
