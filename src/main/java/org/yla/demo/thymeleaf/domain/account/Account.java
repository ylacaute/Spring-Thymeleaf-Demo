package org.yla.demo.thymeleaf.domain.account;

import java.util.Date;

import org.yla.lib.skeleton.domain.BaseResource;

public class Account extends BaseResource {

	private static final long serialVersionUID = 1L;

	private Name name = new Name();

	private String login;
	
	private String password;

	private Date lastPwdModification = new Date();

	private String email;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
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

	public Date getLastPwdModification() {
		return lastPwdModification;
	}

	public void setLastPwdModification(Date lastPwdModification) {
		this.lastPwdModification = lastPwdModification;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	/** 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		return builder
			.append(this.getClass().getSimpleName())
			.append("{ id:").append(getId()).append(", ")
			.append(", version:").append(getVersion())
			.append(", name:").append(name)
			.append(", login:").append(login)
			.append(", password:").append(password)
			.append(", lastPwdModification:").append(lastPwdModification)
			.append(", email:").append(email)
			.append("}")
			.toString();
	}

}