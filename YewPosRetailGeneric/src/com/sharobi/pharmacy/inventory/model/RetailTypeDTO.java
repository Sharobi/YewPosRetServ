package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class RetailTypeDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "retail_type_id " })
	private int retailTypeId ;
	
	@Expose
	@MapToData(columnAliases={"retail_type_name"})
	private String retailTypeName;

	/**
	 * @return the retailTypeId
	 */
	public int getRetailTypeId() {
		return retailTypeId;
	}

	/**
	 * @param retailTypeId the retailTypeId to set
	 */
	public void setRetailTypeId(int retailTypeId) {
		this.retailTypeId = retailTypeId;
	}

	/**
	 * @return the retailTypeName
	 */
	public String getRetailTypeName() {
		return retailTypeName;
	}

	/**
	 * @param retailTypeName the retailTypeName to set
	 */
	public void setRetailTypeName(String retailTypeName) {
		this.retailTypeName = retailTypeName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RetailTypeDTO [retailTypeId=" + retailTypeId
				+ ", retailTypeName=" + retailTypeName + "]";
	}

}
