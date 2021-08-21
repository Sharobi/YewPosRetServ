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
 * Entity implementation class for Entity: pur_t_expiry_mapping
 * 
 */

@XmlRootElement
@Entity
@Table(name = "pur_t_expiry_mapping")
public class ExpiryPurchaseMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "purchase_id")
	private int purchaseId;

	@Expose
	@Column(name = "purchase_inv_no")
	private int purchaseInvNo;

	@Expose
	@Column(name = "purchase_inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date purchaseInvDate;

	@Expose
	@Column(name = "expiry_id")
	private int expiryId;

	@Expose
	@Column(name = "expiry_details_id")
	private int expiryDetailsId;

	@Expose
	@Column(name = "expiry_inv_no")
	private String expiryInvNo;

	@Expose
	@Column(name = "expiry_inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryInvDate;

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
	@Column(name = "is_mrp")
	private int isMrp;

	@Expose
	@Column(name = "net_amount")
	private double netAmount;

	@Expose
	@Column(name = "adj_amount")
	private double adjAmount;
	
	@Expose
	@Column(name = "sale_rate")
	private double saleRate;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Transient
	private String expiryDateFormat;
	
	

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

	public int getPurchaseId() {
		return purchaseId;
	}

	@XmlElement
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public int getPurchaseInvNo() {
		return purchaseInvNo;
	}

	@XmlElement
	public void setPurchaseInvNo(int purchaseInvNo) {
		this.purchaseInvNo = purchaseInvNo;
	}

	public Date getPurchaseInvDate() {
		return purchaseInvDate;
	}

	@XmlElement
	public void setPurchaseInvDate(Date purchaseInvDate) {
		this.purchaseInvDate = purchaseInvDate;
	}

	public int getExpiryId() {
		return expiryId;
	}

	@XmlElement
	public void setExpiryId(int expiryId) {
		this.expiryId = expiryId;
	}

	public int getExpiryDetailsId() {
		return expiryDetailsId;
	}

	@XmlElement
	public void setExpiryDetailsId(int expiryDetailsId) {
		this.expiryDetailsId = expiryDetailsId;
	}

	public String getExpiryInvNo() {
		return expiryInvNo;
	}

	@XmlElement
	public void setExpiryInvNo(String expiryInvNo) {
		this.expiryInvNo = expiryInvNo;
	}

	public Date getExpiryInvDate() {
		return expiryInvDate;
	}

	@XmlElement
	public void setExpiryInvDate(Date expiryInvDate) {
		this.expiryInvDate = expiryInvDate;
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

	public int getIsMrp() {
		return isMrp;
	}

	@XmlElement
	public void setIsMrp(int isMrp) {
		this.isMrp = isMrp;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	@XmlElement
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	public String getLang() {
		return lang;
	}

	@XmlElement
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

	@Override
	public String toString() {
		return "ExpiryPurchaseMapping [id=" + id + ", purchaseId=" + purchaseId + ", purchaseInvNo=" + purchaseInvNo
				+ ", purchaseInvDate=" + purchaseInvDate + ", expiryId=" + expiryId + ", expiryDetailsId="
				+ expiryDetailsId + ", expiryInvNo=" + expiryInvNo + ", expiryInvDate=" + expiryInvDate + ", itemId="
				+ itemId + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate + ", packQty=" + packQty
				+ ", conversion=" + conversion + ", looseQty=" + looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", isMrp=" + isMrp + ", netAmount=" + netAmount + ", adjAmount=" + adjAmount
				+ ", saleRate=" + saleRate + ", lang=" + lang + ", expiryDateFormat=" + expiryDateFormat + "]";
	}

	
	
}
