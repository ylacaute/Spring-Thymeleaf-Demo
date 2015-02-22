package org.yla.demo.thymeleaf.feature.login;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.yla.lib.skeleton.mvc.FormModelSupport;

public class LoginModel extends FormModelSupport {
	
	@Pattern(regexp="([0-9|a-z|A-Z|\\_|\\$|\\.])*", message="{login-form.login.invalid.regexp}")
	@Size(min=3, max=20, message="{login-form.login.invalid.size}")
	@NotEmpty(message="{login-form.login.invalid.empty}")
	private String login;
	
	@NotBlank(message = "{login-form.password.invalid.empty}")
	private String password;

	@Override
	public String getModelName() {
		return "loginModel";
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append(this.getClass().getSimpleName())
			.append(" { login:").append(login)
			.append(", password:").append(password)
			.append(super.toString())
			.append(" }")
			.toString();
	}

}
