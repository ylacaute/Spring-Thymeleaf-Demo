package org.yla.lib.skeleton.mvc;

public interface FormModel {

	String getModelName();
	
	String getSuccessRedirect();
	void setSuccessRedirect(String successRedirect);
	
	String getFailRedirect();
	void setFailRedirect(String failRedirect);
	
}
