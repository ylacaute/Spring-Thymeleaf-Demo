package org.yla.lib.skeleton.mvc;

public abstract class FormModelSupport implements FormModel {

	private String forward;
	
	private String redirect;

	@Override
	public String getForward() {
		return forward;
	}

	@Override
	public void setForward(String forward) {
		this.forward = forward;
	}

	@Override
	public String getRedirect() {
		return redirect;
	}

	@Override
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
