package com.sharobi.pharmacy.sales.model;

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

import net.sf.resultsetmapper.MapToData;

/**
 * Entity implementation class for Entity: pur_t_purchase_order_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "sal_t_sale_order_details")
public class SaleOrderDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "sale_order_id")
	private int saleOrderId;

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
	@Column(name = "sold_pack_qty")
	private double soldPackQty;
	
	@Expose
	@Column(name = "sold_loose_qty")
	private double soldLooseQty;
	
	@Expose
	@Column(name = "mrp")
	private double mrp;
	
	@Expose
	@Column(name = "rate")
	private double rate;
	
	@Expose
	@Column(name = "sale_rate")
	private double saleRate;

	@Expose
	@Column(name = "gross_amount")
	private double grossAmount;
	
	@Expose
	@Column(name = "disc_per")
	private double discPer;

	@Expose
	@Column(name = "disc")
	private double disc;
	
	@Expose
	@Column(name = "tax_id")
	private int taxId;
	
	@Expose
	@Column(name = "tax_percentage")
	private double taxPercentage;
	
	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name = "is_group_tax")
	private int isGroupTax;
	
	@Expose
	@Column(name = "net_amount")
	private double netAmount;
	
	@Expose
	@Column(name = "tmp_id")
	private int	tmpId;
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Transient
	private String lang;
	
	@Expose
	@Column(name = "inv_type")
	private String invType;
	
	@Expose
	@Column(name = "item_total_mrp")
	private double itemTotalMrp;
	
	@Expose
	@MapToData(columnAliases = { "tax_type_id" })
	@Transient
	private int taxTypeId;
	
	@Expose
	@Column(name = "itemdualstock")
	private int itemdualstock;
	
	@Expose
	@Column(name = "batch_no")
    private String batchNo;
	
    @Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
    private Date expiryDate;
    
    @Expose
	@Column(name = "mfd_date")
	@Temporal(TemporalType.TIMESTAMP)
    private Date mfdDate;
    
    @Expose
	@Column(name = "item_lot_adj_amount")
    private double itemLotAdjAmount;
    
    @Expose
	@Column(name = "item_free_against_item")
    private int itemFreeAgainstItem;
    
    @Expose
	@Transient
    private String expiryDateFormat;
    
    @Expose
   	@Column(name = "remarks")
    private String remarks;

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	@XmlElement
	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
	}

	public String getInvType() {
		return invType;
	}

	@XmlElement
	public void setInvType(String invType) {
		this.invType = invType;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
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


	public double getSoldPackQty() {
		return soldPackQty;
	}

	public void setSoldPackQty(double soldPackQty) {
		this.soldPackQty = soldPackQty;
	}

	public double getSoldLooseQty() {
		return soldLooseQty;
	}

	public void setSoldLooseQty(double soldLooseQty) {
		this.soldLooseQty = soldLooseQty;
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

	public double getSaleRate() {
		return saleRate;
	}

	@XmlElement
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	@XmlElement
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
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

	public String getTaxMode() {
		return taxMode;
	}

	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	@XmlElement
	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public int getTmpId() {
		return tmpId;
	}

	@XmlElement
	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getLang() {
		return lang;
	}

	@XmlElement
	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getTaxTypeId() {
		return taxTypeId;
	}

	@XmlElement
	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public int getItemdualstock() {
		return itemdualstock;
	}

	@XmlElement
	public void setItemdualstock(int itemdualstock) {
		this.itemdualstock = itemdualstock;
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

	@XmlElement
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	@XmlElement
	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	@XmlElement
	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public int getItemFreeAgainstItem() {
		return itemFreeAgainstItem;
	}

	@XmlElement
	public void setItemFreeAgainstItem(int itemFreeAgainstItem) {
		this.itemFreeAgainstItem = itemFreeAgainstItem;
	}

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "SaleOrderDetails [id=" + id + ", saleOrderId=" + saleOrderId + ", invNo=" + invNo + ", invDate="
				+ invDate + ", itemId=" + itemId + ", packUnitId=" + packUnitId + ", packQty=" + packQty
				+ ", conversion=" + conversion + ", looseQty=" + looseQty + ", freeQty=" + freeQty + ", soldPackQty="
				+ soldPackQty + ", soldLooseQty=" + soldLooseQty + ", mrp=" + mrp + ", rate=" + rate + ", saleRate="
				+ saleRate + ", grossAmount=" + grossAmount + ", discPer=" + discPer + ", disc=" + disc + ", taxId="
				+ taxId + ", taxPercentage=" + taxPercentage + ", taxAmount=" + taxAmount + ", taxMode=" + taxMode
				+ ", isGroupTax=" + isGroupTax + ", netAmount=" + netAmount + ", tmpId=" + tmpId + ", finyrId="
				+ finyrId + ", storeId=" + storeId + ", companyId=" + companyId + ", lang=" + lang + ", invType="
				+ invType + ", itemTotalMrp=" + itemTotalMrp + ", taxTypeId=" + taxTypeId + ", itemdualstock="
				+ itemdualstock + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate + ", mfdDate=" + mfdDate
				+ ", itemLotAdjAmount=" + itemLotAdjAmount + ", itemFreeAgainstItem=" + itemFreeAgainstItem
				+ ", expiryDateFormat=" + expiryDateFormat + ", remarks=" + remarks + "]";
	}

}