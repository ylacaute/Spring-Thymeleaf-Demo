package org.yla.lib.skeleton.domain;

import java.io.Serializable;


/**
 * Abstract class which represent a domain Resource 
 * 
 * @author Yannick Lacaute
 */
public abstract class BaseResource implements Serializable, Comparable<BaseResource>, Resource<String> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
     * Resource identifier
     */
	private String id;

    /**
     * Version of the information stored in the resource
     */
	private Integer version;

    /**
     * @return Resource identifier
     */
	public String getId() {
		return id;
	}

    /**
     * @param id Resource identifier
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * @return Version of the information stored in the resource
     */
	public Integer getVersion() {
		return version;
	}

    /**
     * @param version Version of the information stored in the resource
     */
	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		if (id == null)
			return super.hashCode();
		return id.hashCode();
	}

	/**
	 * Equal default implementation
	 * 
	 * Warn : think to override it when you use business not yet saved resource (this
	 * kind of resource will not have id)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseResource))
			return false;
		BaseResource other = (BaseResource) obj;
		if (id == null) {
			return false;
		} else if (!id.equals(other.getId()))
			return false;
		return true;
	}

    /**
     * Default comparison callback.
     * Should be overrided.
     * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(BaseResource other) {
		if (other == null)
			return 1;
		return 0;
	}
	
	/** 
	 * Default implementation of the toString method.
	 * Should be overrided.
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new StringBuilder()
			.append(this.getClass().getSimpleName())
			.append(" { id:").append(id)
			.append(", version:").append(version)
			.append(" }")
			.toString();
	}

}
