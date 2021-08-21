package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ItemSearchDTO implements Serializable {
	
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;
	
	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;

	@Expose
	@MapToData(columnAliases = { "brand_name" })
	private String brandName;

	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;	

	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;

	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;
	
	@Expose
	@MapToData(columnAliases = { "rack_name" })
	private String rackName;
	
	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;

	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String groupName;

	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "purchase_rate" })
	private double purchaseRate;

	@Expose
	@MapToData(columnAliases = { "listed_mrp" })
	private double listed_mrp;
	
	private static final long serialVersionUID = 1L;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public String getRackName() {
		return rackName;
	}

	public void setRackName(String rackName) {
		this.rackName = rackName;
	}

	public int getConversion() {
		return conversion;
	}

	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public double getListed_mrp() {
		return listed_mrp;
	}

	public void setListed_mrp(double listed_mrp) {
		this.listed_mrp = listed_mrp;
	}

	
	
}