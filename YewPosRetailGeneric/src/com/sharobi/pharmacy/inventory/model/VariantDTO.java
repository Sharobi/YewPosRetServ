package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class VariantDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "value" })
	private String value;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	
}
