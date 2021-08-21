package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ExpiryDetailsDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;

	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "batch_no" })
	private String batchNo;
	
	@Expose
	@MapToData(columnAliases = { "expiry_date" })
	private Date expiryDate;
	
	
	@Expose
	@MapToData(columnAliases = { "expiry_date_format" })
	private String expiryDateFormat;

	@Expose
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;
	
	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;
	
	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private double packQty;
	
	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;
	
	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private double looseQty;
	
	@Expose
	@MapToData(columnAliases = { "free_qty" })
	private double freeQty;
	
	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;
	
	@Expose
	@MapToData(columnAliases = { "rate" })
	private double rate;
	
	@Expose
	@MapToData(columnAliases = { "amount" })
	private double amount;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@Transient
	private String lang;
	
	@Expose
	@MapToData(columnAliases = { "net_content" })
	private String netContent;
	
	@Expose
	@MapToData(columnAliases = { "calculate_loose_qty" })
	private double calculateLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "stock_qty" })
	private String stockQty;
	
	@Expose
	@MapToData(columnAliases = { "rack_name" })
	private String rackName;
	
	@Expose
	@MapToData(columnAliases = { "rack_id" })
	private int rackId;
	
	@Expose
	@MapToData(columnAliases = { "expiry_id" })
	private int expiryId;
	
	@Expose
	@MapToData(columnAliases = { "expiry_details_id" })
	private int expiryDetailsId;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = {"inv_date"})
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "is_mrp" })
	private int isMrp;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;
	
	
	//added on 05.07.2019
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;
	
	@Expose
	@MapToData(columnAliases = { "disc_per" })
	private double discPer;
	
	@Expose
	@MapToData(columnAliases = { "disc" })
	private double disc;
	
	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_type_id" })
	private int taxTypeId;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
	@Expose
	@MapToData(columnAliases = { "tot_amount" })
	private double totAmount;
	
	@Expose
	@MapToData(columnAliases = { "mfd_date" })
	private Date mfdDate;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;
	
	@Expose
	@MapToData(columnAliases = { "item_code" })
	private String itemCode;
	
	
	
	private static final long serialVersionUID = 1L;
	
	
	public int getExpiryId() {
		return expiryId;
	}


	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}


	public int getExpiryDetailsId() {
		return expiryDetailsId;
	}


	public void setExpiryDetailsId(int expiryDetailsId) {
		this.expiryDetailsId = expiryDetailsId;
	}


	public String getInvNo() {
		return invNo;
	}


	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}


	public Date getInvDate() {
		return invDate;
	}


	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}


	public int getIsMrp() {
		return isMrp;
	}


	public void setIsMrp(int isMrp) {
		this.isMrp = isMrp;
	}


	public double getNetAmount() {
		return netAmount;
	}


	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}


	public double getAdjAmount() {
		return adjAmount;
	}


	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}


	public String getNetContent() {
		return netContent;
	}


	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}


	public double getCalculateLooseQty() {
		return calculateLooseQty;
	}


	public void setCalculateLooseQty(double calculateLooseQty) {
		this.calculateLooseQty = calculateLooseQty;
	}


	public String getStockQty() {
		return stockQty;
	}


	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}


	public String getRackName() {
		return rackName;
	}


	public void setRackName(String rackName) {
		this.rackName = rackName;
	}


	public int getRackId() {
		return rackId;
	}


	public void setRackId(int rackId) {
		this.rackId = rackId;
	}


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


	public String getBatchNo() {
		return batchNo;
	}


	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}


	public Date getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}


	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}


	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}


	public int getPackUnitId() {
		return packUnitId;
	}


	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
	}


	public String getPackUnitName() {
		return packUnitName;
	}


	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}


	public double getPackQty() {
		return packQty;
	}


	public void setPackQty(double packQty) {
		this.packQty = packQty;
	}


	public int getConversion() {
		return conversion;
	}


	public void setConversion(int conversion) {
		this.conversion = conversion;
	}


	public double getLooseQty() {
		return looseQty;
	}


	public void setLooseQty(double looseQty) {
		this.looseQty = looseQty;
	}


	public double getFreeQty() {
		return freeQty;
	}


	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}


	public double getMrp() {
		return mrp;
	}


	public void setMrp(double mrp) {
		this.mrp = mrp;
	}


	public double getRate() {
		return rate;
	}


	public void setRate(double rate) {
		this.rate = rate;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getDistributorId() {
		return distributorId;
	}


	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}


	public String getDistributorName() {
		return distributorName;
	}


	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}


	public String getItemUniqueKey() {
		return itemUniqueKey;
	}


	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}


	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public double getSaleRate() {
		return saleRate;
	}


	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}


	public double getDiscPer() {
		return discPer;
	}


	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}


	public double getDisc() {
		return disc;
	}


	public void setDisc(double disc) {
		this.disc = disc;
	}


	public int getTaxId() {
		return taxId;
	}


	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}


	public int getTaxTypeId() {
		return taxTypeId;
	}


	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}


	public double getTaxPercentage() {
		return taxPercentage;
	}


	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}


	public double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}


	public double getTotAmount() {
		return totAmount;
	}


	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}
	
	


	public Date getMfdDate() {
		return mfdDate;
	}


	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	

	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	@Override
	public String toString() {
		return "ExpiryDetailsDTO [itemId=" + itemId + ", itemName=" + itemName + ", batchNo=" + batchNo
				+ ", expiryDate=" + expiryDate + ", expiryDateFormat=" + expiryDateFormat + ", packUnitId=" + packUnitId
				+ ", packUnitName=" + packUnitName + ", packQty=" + packQty + ", conversion=" + conversion
				+ ", looseQty=" + looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp + ", rate=" + rate + ", amount="
				+ amount + ", distributorId=" + distributorId + ", distributorName=" + distributorName
				+ ", itemUniqueKey=" + itemUniqueKey + ", lang=" + lang + ", netContent=" + netContent
				+ ", calculateLooseQty=" + calculateLooseQty + ", stockQty=" + stockQty + ", rackName=" + rackName
				+ ", rackId=" + rackId + ", expiryId=" + expiryId + ", expiryDetailsId=" + expiryDetailsId + ", invNo="
				+ invNo + ", invDate=" + invDate + ", isMrp=" + isMrp + ", netAmount=" + netAmount + ", adjAmount="
				+ adjAmount + ", saleRate=" + saleRate + ", discPer=" + discPer + ", disc=" + disc + ", taxId=" + taxId
				+ ", taxTypeId=" + taxTypeId + ", taxPercentage=" + taxPercentage + ", taxAmount=" + taxAmount
				+ ", totAmount=" + totAmount + ", mfdDate=" + mfdDate + ", sku=" + sku + ", itemCode=" + itemCode + "]";
	}

	
}