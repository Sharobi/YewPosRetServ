package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: para_retail_type
 * 
 */

@XmlRootElement
@Entity
@Table(name = "para_retail_type")
public class RetailTypeMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "type_name")
	private String typeName;
	
	@Expose
	@Column(name = "type_tag")
	private String typeTag;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
	 * @return the typeTag
	 */
	public String getTypeTag() {
		return typeTag;
	}

	/**
	 * @param typeTag the typeTag to set
	 */
	public void setTypeTag(String typeTag) {
		this.typeTag = typeTag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetailTypeMaster [id=" + id + ", typeName=" + typeName
				+ ", typeTag=" + typeTag + "]";
	}

}