package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * Entity implementation class for Entity: inv_t_op_stock
 * 
 */

@XmlRootElement
@Entity
@Table(name = "inv_t_op_stock")
public class OpeningStockDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

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
	@Column(name = "mrp")
	private double mrp;

	@Expose
	@Column(name = "rate")
	private double rate;

	@Expose
	@Column(name = "as_on_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date asOnDate;

	@Expose
	@Column(name = "last_distributor_id")
	private int lastDistributorId;

	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	@Expose
	@Column(name = "pack_unit_id")
	private int packUnitId;

	@Expose
	@Column(name = "conversion")
	private int conversion;

	@Expose
	@Column(name = "loose_qty")
	private int looseQty;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;

	@Expose
	@Column(name = "created_by")
	private int createdBy;

	@Expose
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Expose
	@Column(name = "updated_by")
	private int updatedBy;

	@Expose
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Expose
	@Transient
	private String expiryDateFormat;
	
	@Expose
	@Column(name = "vat_per")
	private double vatPer;
	
	@Expose
	@Column(name = "tax_per")
	private double taxPer;
	
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
	@Column(name = "is_group_tax")
	private int isGroupTax;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name = "sale_rate")
	private double saleRate;
	
	@Expose
	@Column(name = "purchase_rate")
	private double purchaseRate;
	
	@Expose
	@Column(name = "loose_unit_id")
	private int looseUnitId;
	
	@Expose
	@Column(name = "markup")
	private double markup;
	
	@Expose
	@Column(name = "listed_mrp")
	private double listedMrp;
	
	@Expose
	@Column(name = "retail_type_id")
	private int retailTypeId;
	
	@Expose
	@Column(name = "tmp_mapping_id")
	private int tmpMappingId;
	
	
	@Expose
	@Column(name = "location_id")
	private int locationId;
	
	@Expose
	@Column(name = "mfd_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mfdDate;
	
	@Expose
	@Transient
	private List<InvOpeningStockDetails> invOpeningStockDetails;
	
	@Expose
	@Column(name = "expiry_month")
	private int expiryMonth;
	
	@Expose
	@Transient
	@MapToData(columnAliases = { "tax_type_id" })
	private int taxTypeId;
	
	public OpeningStockDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public int getExpiryMonth() {
		return expiryMonth;
	}

	@XmlElement
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public List<InvOpeningStockDetails> getInvOpeningStockDetails() {
		return invOpeningStockDetails;
	}

	public void setInvOpeningStockDetails(
			List<InvOpeningStockDetails> invOpeningStockDetails) {
		this.invOpeningStockDetails = invOpeningStockDetails;
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

	@XmlElement
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getRetailTypeId() {
		return retailTypeId;
	}

	@XmlElement
	public void setRetailTypeId(int retailTypeId) {
		this.retailTypeId = retailTypeId;
	}

	public int getTmpMappingId() {
		return tmpMappingId;
	}

	@XmlElement
	public void setTmpMappingId(int tmpMappingId) {
		this.tmpMappingId = tmpMappingId;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	@XmlElement
	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public int getLooseUnitId() {
		return looseUnitId;
	}

	@XmlElement
	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
	}

	public double getMarkup() {
		return markup;
	}

	@XmlElement
	public void setMarkup(double markup) {
		this.markup = markup;
	}

	public double getListedMrp() {
		return listedMrp;
	}

	@XmlElement
	public void setListedMrp(double listedMrp) {
		this.listedMrp = listedMrp;
	}

	public double getSaleRate() {
		return saleRate;
	}

	@XmlElement
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
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

	public int getIsGroupTax() {
		return isGroupTax;
	}

	@XmlElement
	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public String getTaxMode() {
		return taxMode;
	}

	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public double getVatPer() {
		return vatPer;
	}

	@XmlElement
	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public double getTaxPer() {
		return taxPer;
	}

	@XmlElement
	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
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

	public Date getAsOnDate() {
		return asOnDate;
	}

	@XmlElement
	public void setAsOnDate(Date asOnDate) {
		this.asOnDate = asOnDate;
	}

	public int getLastDistributorId() {
		return lastDistributorId;
	}

	@XmlElement
	public void setLastDistributorId(int lastDistributorId) {
		this.lastDistributorId = lastDistributorId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public int getPackUnitId() {
		return packUnitId;
	}

	@XmlElement
	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
	}

	public int getConversion() {
		return conversion;
	}

	@XmlElement
	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public int getLooseQty() {
		return looseQty;
	}

	@XmlElement
	public void setLooseQty(int looseQty) {
		this.looseQty = looseQty;
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

	public int getIsDeleted() {
		return isDeleted;
	}

	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	@XmlElement
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@XmlElement
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	@XmlElement
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	@XmlElement
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getTaxTypeId() {
		return taxTypeId;
	}

	@XmlElement
	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	@Override
	public String toString() {
		return "OpeningStockDetails [id=" + id + ", itemId=" + itemId + ", batchNo=" + batchNo + ", expiryDate="
				+ expiryDate + ", packQty=" + packQty + ", mrp=" + mrp + ", rate=" + rate + ", asOnDate=" + asOnDate
				+ ", lastDistributorId=" + lastDistributorId + ", finyrId=" + finyrId + ", packUnitId=" + packUnitId
				+ ", conversion=" + conversion + ", looseQty=" + looseQty + ", storeId=" + storeId + ", companyId="
				+ companyId + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", expiryDateFormat=" + expiryDateFormat
				+ ", vatPer=" + vatPer + ", taxPer=" + taxPer + ", taxId=" + taxId + ", taxPercentage=" + taxPercentage
				+ ", taxAmount=" + taxAmount + ", isGroupTax=" + isGroupTax + ", taxMode=" + taxMode + ", saleRate="
				+ saleRate + ", purchaseRate=" + purchaseRate + ", looseUnitId=" + looseUnitId + ", markup=" + markup
				+ ", listedMrp=" + listedMrp + ", retailTypeId=" + retailTypeId + ", tmpMappingId=" + tmpMappingId
				+ ", locationId=" + locationId + ", mfdDate=" + mfdDate + ", invOpeningStockDetails="
				+ invOpeningStockDetails + ", expiryMonth=" + expiryMonth + ", taxTypeId=" + taxTypeId + "]";
	}

}