package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SubcatByCatDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "sub_category_id" })
	private int subCategoryId;

	@Expose
	@MapToData(columnAliases = { "sub_category_name" })
	private String subCategoryName;
	
	@Expose
	@MapToData(columnAliases = { "category_id" })
	private int categoryId;
	
	
	@Expose
	@MapToData(columnAliases = { "category_name" })
	private String categoryName;


	private static final long serialVersionUID = 1L;


	public int getSubCategoryId() {
		return subCategoryId;
	}


	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}


	public String getSubCategoryName() {
		return subCategoryName;
	}


	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	
}