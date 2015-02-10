package org.yla.demo.thymeleaf.mvc.form;

import javax.validation.constraints.NotNull;

import org.yla.lib.skeleton.mvc.FormModelSupport;

public class LoginModel extends FormModelSupport {
	
	@NotNull
	private String login;
	
	@NotNull
	private String password;

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
