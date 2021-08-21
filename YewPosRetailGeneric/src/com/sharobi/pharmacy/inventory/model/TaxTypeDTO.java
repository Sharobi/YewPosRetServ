package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class TaxTypeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "tax_type_id" })
	private int taxTypeId;

	@Expose
	@MapToData(columnAliases = { "tax_type_name" })
	private String taxTypeName;

	public int getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public String getTaxTypeName() {
		return taxTypeName;
	}

	public void setTaxTypeName(String taxTypeName) {
		this.taxTypeName = taxTypeName;
	}
	
	
}
