package org.yla.demo.thymeleaf.domain.account;

import java.io.Serializable;

import org.springframework.util.StringUtils;

public class Name implements Serializable {

	private static final long serialVersionUID = 1L;

	protected Title title;

	protected String firstName;

	protected String lastName;

	public Name() {
	}

	public Name(Title title, String firstName, String lastName) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return new StringBuilder()
			.append(title == null ? "" : title + " ")
			.append(lastName == null ? "" : lastName.toUpperCase() + " ")
			.append(firstName == null ? "" : StringUtils.capitalize(firstName))
			.toString();
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public String getFirstName() {
		if (firstName != null)
			return StringUtils.capitalize(firstName);
		return null;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		if (lastName != null)
			return lastName.toUpperCase();
		return null;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return getFullName();
	}

}
