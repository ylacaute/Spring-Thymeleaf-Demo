package org.yla.demo.thymeleaf.feature.contact;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.yla.lib.skeleton.mvc.FormModelSupport;

public class ContactUsModel extends FormModelSupport {

	@Pattern(regexp="([0-9|a-z|A-Z|\\_|\\$|\\.|\\s])*", message="{contact-us-form.name.invalid.regexp}")
	@Size(min=3, max=20, message="{contact-us-form.name.invalid.size}")
	@NotEmpty(message="{contact-us-form.name.invalid.empty}")
	private String name;
	
	@Email(message="{contact-us-form.email.invalid.regexp}")
	@Size(min=3, max=20, message="{contact-us-form.email.invalid.size}")
	@NotEmpty(message="{contact-us-form.email.invalid.empty}")
	private String email;
	
	@Pattern(regexp="([0-9|a-z|A-Z|\\_|\\$|\\.|\\s])*", message="{contact-us-form.subject.invalid.regexp}")
	@NotEmpty(message="{contact-us-form.subject.invalid.empty}")
	@Size(min=3, max=20, message="{contact-us-form.subject.invalid.size}")
	private String subject;
	
	@NotEmpty(message="{contact-us-form.message.invalid.empty}")
	@Size(min=20, max=200, message="{contact-us-form.message.invalid.size}")
	private String message;

	@Override
	public String getModelName() {
		return "contactUsModel";
	}
	
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
