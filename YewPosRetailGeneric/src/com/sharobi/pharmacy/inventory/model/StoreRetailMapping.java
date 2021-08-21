package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: gen_t_store_retail_mapping
 * 
 */

@XmlRootElement
@Entity
@Table(name = "gen_t_store_retail_mapping")
public class StoreRetailMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "retail_type_id")
	private int retailTypeId;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "store_id")
	private int storeId;
	
	@Expose
	@Column(name = "is_active")
	private int isActive;
	
	@Expose
	@Transient
	private String lang;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRetailTypeId() {
		return retailTypeId;
	}

	public void setRetailTypeId(int retailTypeId) {
		this.retailTypeId = retailTypeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	
}