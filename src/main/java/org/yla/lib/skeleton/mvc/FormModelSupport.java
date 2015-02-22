package org.yla.lib.skeleton.mvc;

public abstract class FormModelSupport implements FormModel {

	private String successRedirect;
	private String failRedirect;
	private boolean ajaxSubmit = false;
	
	public boolean isAjaxSubmit() {
		return ajaxSubmit;
	}

	public void setAjaxSubmit(boolean ajaxSubmit) {
		this.ajaxSubmit = ajaxSubmit;
	}

	@Override
	public String getSuccessRedirect() {
		return successRedirect;
	}

	@Override
	public void setSuccessRedirect(String successRedirect) {
		this.successRedirect = successRedirect;
	}
	
	@Override
	public String getFailRedirect() {
		return failRedirect;
	}

	@Override
	public void setFailRedirect(String failRedirect) {
		this.failRedirect = failRedirect;
	}

	@Override
	public String toString() {
		return new StringBuilder()
			.append(", successRedirect:").append(successRedirect)
			.append(", failRedirect:").append(failRedirect)
			.toString();
	}
}
