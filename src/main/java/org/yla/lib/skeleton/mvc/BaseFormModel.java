package org.yla.lib.skeleton.mvc;

public abstract class BaseFormModel {

	private String forward;
	
	private String redirect;

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public String getRedirect() {
		return redirect;
	}

	public void setRedirect(String redirect) {
		this.redirect = redirect;
	}
	
	@Override
	public String toString() {
		return new StringBuilder()
			.append(", forward:").append(forward)
			.append(", redirect:").append(redirect)
			.toString();
	}
}
