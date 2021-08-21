package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class VariantTypeDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "variant_type_id" })
	private int variantTypeId;

	@Expose
	@MapToData(columnAliases = { "variant_type_name" })
	private String variantTypeName;

	public int getVariantTypeId() {
		return variantTypeId;
	}

	public void setVariantTypeId(int variantTypeId) {
		this.variantTypeId = variantTypeId;
	}

	public String getVariantTypeName() {
		return variantTypeName;
	}

	public void setVariantTypeName(String variantTypeName) {
		this.variantTypeName = variantTypeName;
	}

	
	
}
