package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: exp_t_expiry_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "exp_t_expiry_details")
public class ExpiryDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "expiry_id")
	private int expiryId;

	@Expose
	@Column(name = "inv_no")
	private String invNo;
	
	@Expose
	@Column(name = "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;
	
	@Expose
	@Column(name = "item_id")
	private int itemId;
	
	@Expose
	@Column(name = "batch_no")
	private String batchNo;
	
	@Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	@Expose
	@Column(name = "pack_unit_id")
	private int packUnitId;
	
	@Expose
	@Column(name = "pack_qty")
	private double packQty;
	
	@Expose
	@Column(name = "conversion")
	private int conversion;
	
	@Expose
	@Column(name = "loose_qty")
	private double looseQty;
	
	@Expose
	@Column(name = "free_qty")
	private double freeQty;

	@Expose
	@Column(name = "mrp")
	private double mrp;
	
	@Expose
	@Column(name = "rate")
	private double rate;
	
	@Expose
	@Column(name = "amount")
	private double amount;
	
	@Expose
	@Column(name = "distributor_id")
	private int distributorId;
	
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "company_id")
	private int companyId;
	

	@Expose
	@Column(name = "store_id")
	private int storeId;
	
	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private String expiryDateFormat;
	
	@Expose
	@Column(name = "location_id")
	private int locationId;
	
	@Expose
	@Column(name = "mfd_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mfdDate;
	
	@Expose
	@Column(name =  "purchase_rate")
	private double purchaseRate;
	
	//added on 05.07.2019
	@Expose
	@Column(name =  "sale_rate")
	private double saleRate;
	
	@Expose
	@Column(name =  "disc_per")
	private double discPer;
	
	@Expose
	@Column(name =  "disc")
	private double disc;
	
	@Expose
	@Column(name =  "tax_id")
	private int taxId;
	
	@Expose
	@Column(name =  "tax_type_id")
	private int taxTypeId;
	
	@Expose
	@Column(name =  "tax_percentage")
	private double taxPercentage;
	
	@Expose
	@Column(name =  "tax_amount")
	private double taxAmount;
	
	@Expose
	@Column(name =  "net_amount")
	private double netAmount;
	
	@Expose
	@Column(name =  "tot_amount")
	private double totAmount;
	

	public double getPurchaseRate() {
		return purchaseRate;
	}

	@XmlElement
	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}
	
	public Date getMfdDate() {
		return mfdDate;
	}

	@XmlElement
	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}
	
	
	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	@XmlElement
	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getExpiryId() {
		return expiryId;
	}

	@XmlElement
	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}

	public String getInvNo() {
		return invNo;
	}

	@XmlElement
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	public Date getInvDate() {
		return invDate;
	}

	@XmlElement
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public int getItemId() {
		return itemId;
	}

	@XmlElement
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	@XmlElement
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	@XmlElement
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getPackUnitId() {
		return packUnitId;
	}

	@XmlElement
	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
	}

	public double getPackQty() {
		return packQty;
	}

	@XmlElement
	public void setPackQty(double packQty) {
		this.packQty = packQty;
	}

	public int getConversion() {
		return conversion;
	}

	@XmlElement
	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public double getLooseQty() {
		return looseQty;
	}

	@XmlElement
	public void setLooseQty(double looseQty) {
		this.looseQty = looseQty;
	}

	public double getFreeQty() {
		return freeQty;
	}

	@XmlElement
	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public double getMrp() {
		return mrp;
	}

	@XmlElement
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getRate() {
		return rate;
	}

	@XmlElement
	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getAmount() {
		return amount;
	}

	@XmlElement
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDistributorId() {
		return distributorId;
	}

	@XmlElement
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
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

	@XmlElement
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getDiscPer() {
		return discPer;
	}

	@XmlElement
	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}

	public double getDisc() {
		return disc;
	}

	@XmlElement
	public void setDisc(double disc) {
		this.disc = disc;
	}

	public int getTaxId() {
		return taxId;
	}

	@XmlElement
	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public int getTaxTypeId() {
		return taxTypeId;
	}

	@XmlElement
	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public double getTaxPercentage() {
		return taxPercentage;
	}

	@XmlElement
	public void setTaxPercentage(double taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	@XmlElement
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTotAmount() {
		return totAmount;
	}

	@XmlElement
	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}

	@Override
	public String toString() {
		return "ExpiryDetails [id=" + id + ", expiryId=" + expiryId + ", invNo=" + invNo + ", invDate=" + invDate
				+ ", itemId=" + itemId + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate + ", packUnitId="
				+ packUnitId + ", packQty=" + packQty + ", conversion=" + conversion + ", looseQty=" + looseQty
				+ ", freeQty=" + freeQty + ", mrp=" + mrp + ", rate=" + rate + ", amount=" + amount + ", distributorId="
				+ distributorId + ", finyrId=" + finyrId + ", companyId=" + companyId + ", storeId=" + storeId
				+ ", lang=" + lang + ", expiryDateFormat=" + expiryDateFormat + ", locationId=" + locationId
				+ ", mfdDate=" + mfdDate + ", purchaseRate=" + purchaseRate + ", saleRate=" + saleRate + ", discPer="
				+ discPer + ", disc=" + disc + ", taxId=" + taxId + ", taxTypeId=" + taxTypeId + ", taxPercentage="
				+ taxPercentage + ", taxAmount=" + taxAmount + ", netAmount=" + netAmount + ", totAmount=" + totAmount
				+ ", getPurchaseRate()=" + getPurchaseRate() + ", getMfdDate()=" + getMfdDate() + ", getLocationId()="
				+ getLocationId() + ", getExpiryDateFormat()=" + getExpiryDateFormat() + ", getId()=" + getId()
				+ ", getExpiryId()=" + getExpiryId() + ", getInvNo()=" + getInvNo() + ", getInvDate()=" + getInvDate()
				+ ", getItemId()=" + getItemId() + ", getBatchNo()=" + getBatchNo() + ", getExpiryDate()="
				+ getExpiryDate() + ", getPackUnitId()=" + getPackUnitId() + ", getPackQty()=" + getPackQty()
				+ ", getConversion()=" + getConversion() + ", getLooseQty()=" + getLooseQty() + ", getFreeQty()="
				+ getFreeQty() + ", getMrp()=" + getMrp() + ", getRate()=" + getRate() + ", getAmount()=" + getAmount()
				+ ", getDistributorId()=" + getDistributorId() + ", getFinyrId()=" + getFinyrId() + ", getCompanyId()="
				+ getCompanyId() + ", getStoreId()=" + getStoreId() + ", getLang()=" + getLang() + ", getSaleRate()="
				+ getSaleRate() + ", getDiscPer()=" + getDiscPer() + ", getDisc()=" + getDisc() + ", getTaxId()="
				+ getTaxId() + ", getTaxTypeId()=" + getTaxTypeId() + ", getTaxPercentage()=" + getTaxPercentage()
				+ ", getTaxAmount()=" + getTaxAmount() + ", getNetAmount()=" + getNetAmount() + ", getTotAmount()="
				+ getTotAmount() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	


}