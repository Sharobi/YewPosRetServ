package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;



@XmlRootElement
public class ControlAccessItemWiseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "stock_required"})
	private int stockRequired;
	
	@Expose
	@MapToData(columnAliases = { "batch_wise_stock"})
	private int batchWiseStock;

	@Expose
	@MapToData(columnAliases = { "expiry_date_required"})
	private int expiryDateRequired;
	
	@Expose
	@MapToData(columnAliases = { "expiry_month_required"})
	private int expiryMonthRequired;
	
	@Expose
	@MapToData(columnAliases = { "dual_stock_required"})
	private int dualStockRequired;
	
	@Expose
	@MapToData(columnAliases = { "location_required"})
	private int locationRequired;
	
	@Expose
	@MapToData(columnAliases = { "price_list_required"})
	private int priceListRequired;
	
	@Expose
	@MapToData(columnAliases = { "size_wise_stock_required"})
	private int sizeWiseStockRequired;
	
	@Expose
	@MapToData(columnAliases = { "colour_wise_stock_required"})
	private int colourWiseStockRequired;
	
	@Expose
	@MapToData(columnAliases = { "warranty_required"})
	private int warrantyRequired;
	
	@Expose
	@MapToData(columnAliases = { "warranty_month"})
	private int warrantyMonth;
	
	@Expose
	@MapToData(columnAliases = { "mrp_required"})
	private int mrpRequired;

	@Expose
	@MapToData(columnAliases = { "serial_no_required"})
	private int serialNoRequired;

	@Expose
	@MapToData(columnAliases = { "serial_no_suff_required"})
	private int serialNoSuffRequired;

	@Expose
	@MapToData(columnAliases = { "serial_no_pref_required"})
	private int serialNoPrefRequired;
	
	@Expose
	@MapToData(columnAliases = { "rate_on"})
	private int rateOn;
	
	@Expose
	@MapToData(columnAliases = { "serial_no_type"})
	private String serialNoType;
	
	

	public String getSerialNoType() {
		return serialNoType;
	}

	public void setSerialNoType(String serialNoType) {
		this.serialNoType = serialNoType;
	}

	public int getStockRequired() {
		return stockRequired;
	}

	public void setStockRequired(int stockRequired) {
		this.stockRequired = stockRequired;
	}

	public int getBatchWiseStock() {
		return batchWiseStock;
	}

	public void setBatchWiseStock(int batchWiseStock) {
		this.batchWiseStock = batchWiseStock;
	}

	public int getExpiryDateRequired() {
		return expiryDateRequired;
	}

	public void setExpiryDateRequired(int expiryDateRequired) {
		this.expiryDateRequired = expiryDateRequired;
	}

	public int getExpiryMonthRequired() {
		return expiryMonthRequired;
	}

	public void setExpiryMonthRequired(int expiryMonthRequired) {
		this.expiryMonthRequired = expiryMonthRequired;
	}

	public int getDualStockRequired() {
		return dualStockRequired;
	}

	public void setDualStockRequired(int dualStockRequired) {
		this.dualStockRequired = dualStockRequired;
	}

	public int getLocationRequired() {
		return locationRequired;
	}

	public void setLocationRequired(int locationRequired) {
		this.locationRequired = locationRequired;
	}

	public int getPriceListRequired() {
		return priceListRequired;
	}

	public void setPriceListRequired(int priceListRequired) {
		this.priceListRequired = priceListRequired;
	}

	public int getSizeWiseStockRequired() {
		return sizeWiseStockRequired;
	}

	public void setSizeWiseStockRequired(int sizeWiseStockRequired) {
		this.sizeWiseStockRequired = sizeWiseStockRequired;
	}

	public int getColourWiseStockRequired() {
		return colourWiseStockRequired;
	}

	public void setColourWiseStockRequired(int colourWiseStockRequired) {
		this.colourWiseStockRequired = colourWiseStockRequired;
	}

	public int getWarrantyRequired() {
		return warrantyRequired;
	}

	public void setWarrantyRequired(int warrantyRequired) {
		this.warrantyRequired = warrantyRequired;
	}

	public int getWarrantyMonth() {
		return warrantyMonth;
	}

	public void setWarrantyMonth(int warrantyMonth) {
		this.warrantyMonth = warrantyMonth;
	}

	public int getMrpRequired() {
		return mrpRequired;
	}

	public void setMrpRequired(int mrpRequired) {
		this.mrpRequired = mrpRequired;
	}

	public int getSerialNoRequired() {
		return serialNoRequired;
	}

	public void setSerialNoRequired(int serialNoRequired) {
		this.serialNoRequired = serialNoRequired;
	}

	public int getSerialNoSuffRequired() {
		return serialNoSuffRequired;
	}

	public void setSerialNoSuffRequired(int serialNoSuffRequired) {
		this.serialNoSuffRequired = serialNoSuffRequired;
	}

	public int getSerialNoPrefRequired() {
		return serialNoPrefRequired;
	}

	public void setSerialNoPrefRequired(int serialNoPrefRequired) {
		this.serialNoPrefRequired = serialNoPrefRequired;
	}

	public int getRateOn() {
		return rateOn;
	}

	public void setRateOn(int rateOn) {
		this.rateOn = rateOn;
	}
	
	
}