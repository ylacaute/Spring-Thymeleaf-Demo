package org.yla.lib.skeleton.domain;

import java.io.Serializable;

public interface Resource<T extends Serializable> {
	
	T getId();

}
