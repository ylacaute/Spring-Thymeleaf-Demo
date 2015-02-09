package org.yla.demo.thymeleaf.mvc.form;

import javax.validation.constraints.NotNull;

import org.yla.lib.skeleton.mvc.BaseFormModel;

public class ContactUsModel extends BaseFormModel {

	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String subject;
	
	@NotNull
	private String message;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append(this.getClass().getSimpleName())
			.append(" { name:").append(name)
			.append(", email:").append(email)
			.append(", subject:").append(subject)
			.append(", message:").append(message)
			.append(super.toString())
			.append(" }")
			.toString();
	}
	
}
