/**
 * 
 */
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
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;


/**
 * @author Habib
 *
 */
@XmlRootElement
@Entity
@Table(name = "in_st_stock_transfer_details")
public class StockTransferDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "stock_transfer_id")
	private int stockTransId;

	@Expose
	@Column(name = "stock_transfer_no")
	private String stockTransNo;

	@Expose
	@Column(name = "stock_transfer_date")
	@Temporal(TemporalType.DATE)
	private Date stockTransDate;

	@Expose
	@Column(name = "item_id")
	private int itemId;

	@Expose
	@Column(name = "batch_no")
	private String batchNo;
	
	@Expose
	@Column(name = "mfd_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mfdDate;

	@Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	@Expose
	@Transient
	private String expiryDateFormat;

	@Expose
	@Column(name = "pack_unit_id")
	private int packUnitId;

	@Expose
	@Column(name = "send_pack_qty")
	private double sendPackQty;
	
	@Expose
	@Column(name = "act_send_pack_qty")
	private double actSendPackQty;
	
	@Expose
	@Column(name = "recvd_pack_qty")
	private double recvdPackQty;
	
	@Expose
	@Column(name = "transit_pack_qty")
	private double transitPackQty;

	@Expose
	@Column(name = "conversion")
	private int conversion;

	@Expose
	@Column(name = "loose_unit_id")
	private int looseUnitId;

	@Expose
	@Column(name = "send_loose_qty")
	private int sendLooseQty;
	
	@Expose
	@Column(name = "act_send_loose_qty")
	private int actSendLooseQty;
	
	@Expose
	@Column(name = "recvd_loose_qty")
	private int recvdLooseQty;
	
	@Expose
	@Column(name = "transit_loose_qty")
	private int transitLooseQty;

	@Expose
	@Column(name = "mrp")
	private double mrp;

	@Expose
	@Column(name = "rate")
	private double rate;
	
	@Expose
	@Column(name =  "sale_rate")
	private double saleRate;
	
	@Expose
	@Column(name =  "purchase_rate")
	private double purchaseRate;
	
	@Expose
	@Column(name = "mrp_per_unit")
	private double mrpPerUnit;
	
	@Expose
	@Column(name = "rate_per_unit")
	private double ratePerUnit;
	
	@Expose
	@Column(name = "send_item_gross_amount")
	private double sendItemGrossAmount;
	
	@Expose
	@Column(name = "recvd_item_gross_amount")
	private double recvdItemGrossAmount;
	
	@Expose
	@Column(name = "transit_item_gross_amount")
	private double transitItemGrossAmount;
	
	@Expose
	@Column(name = "disc_per")
	private double discPer;
	
	@Expose
	@Column(name = "send_item_disc_amount")
	private double sendItemDiscAmount;
	
	@Expose
	@Column(name = "recvd_item_disc_amount")
	private double recvdItemDiscAmount;
	
	@Expose
	@Column(name = "transit_item_disc_amount")
	private double transitItemDiscAmount;
	
	@Expose
	@Column(name = "tax_id")
	private int taxId;
	
	@Expose
	@Column(name = "tax_type_id")
	private int taxTypeId;
	
	@Expose
	@Column(name = "tax_percentage")
	private double taxPercentage;
	
	@Expose
	@Column(name = "send_item_tax_amount")
	private double sendItemTaxAmount;
	
	@Expose
	@Column(name = "recvd_item_tax_amount")
	private double recvdItemTaxAmount;
	
	@Expose
	@Column(name = "transit_item_tax_amount")
	private double transitItemTaxAmount;
	
	@Expose
	@Column(name = "send_item_net_amount")
	private double sendItemNetAmount;
	
	@Expose
	@Column(name = "recvd_item_net_amount")
	private double recvdItemNetAmount;
	
	@Expose
	@Column(name = "transit_item_net_amount")
	private double transitItemNetAmount;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "from_store_id")
	private int fromStoreId;
	
	@Expose
	@Column(name = "from_finyr_id")
	private int fromFinyrId;
	
	@Expose
	@Column(name = "to_store_id")
	private int toStoreId;
	
	@Expose
	@Column(name = "to_finyr_id")
	private int toFinyrId;
	
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStockTransId() {
		return stockTransId;
	}

	public void setStockTransId(int stockTransId) {
		this.stockTransId = stockTransId;
	}

	public String getStockTransNo() {
		return stockTransNo;
	}

	public void setStockTransNo(String stockTransNo) {
		this.stockTransNo = stockTransNo;
	}

	public Date getStockTransDate() {
		return stockTransDate;
	}

	public void setStockTransDate(Date stockTransDate) {
		this.stockTransDate = stockTransDate;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
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

	public double getSendPackQty() {
		return sendPackQty;
	}

	public void setSendPackQty(double sendPackQty) {
		this.sendPackQty = sendPackQty;
	}

	public double getActSendPackQty() {
		return actSendPackQty;
	}

	public void setActSendPackQty(double actSendPackQty) {
		this.actSendPackQty = actSendPackQty;
	}


	public double getRecvdPackQty() {
		return recvdPackQty;
	}

	public void setRecvdPackQty(double recvdPackQty) {
		this.recvdPackQty = recvdPackQty;
	}

	public double getTransitPackQty() {
		return transitPackQty;
	}

	public void setTransitPackQty(double transitPackQty) {
		this.transitPackQty = transitPackQty;
	}

	public int getConversion() {
		return conversion;
	}

	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public int getLooseUnitId() {
		return looseUnitId;
	}

	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
	}

	public int getSendLooseQty() {
		return sendLooseQty;
	}

	public void setSendLooseQty(int sendLooseQty) {
		this.sendLooseQty = sendLooseQty;
	}
	
	public int getActSendLooseQty() {
		return actSendLooseQty;
	}

	public void setActSendLooseQty(int actSendLooseQty) {
		this.actSendLooseQty = actSendLooseQty;
	}

	public int getRecvdLooseQty() {
		return recvdLooseQty;
	}

	public void setRecvdLooseQty(int recvdLooseQty) {
		this.recvdLooseQty = recvdLooseQty;
	}

	public int getTransitLooseQty() {
		return transitLooseQty;
	}

	public void setTransitLooseQty(int transitLooseQty) {
		this.transitLooseQty = transitLooseQty;
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

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public double getMrpPerUnit() {
		return mrpPerUnit;
	}

	public void setMrpPerUnit(double mrpPerUnit) {
		this.mrpPerUnit = mrpPerUnit;
	}

	public double getRatePerUnit() {
		return ratePerUnit;
	}

	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	}

	public double getSendItemGrossAmount() {
		return sendItemGrossAmount;
	}

	public void setSendItemGrossAmount(double sendItemGrossAmount) {
		this.sendItemGrossAmount = sendItemGrossAmount;
	}

	public double getRecvdItemGrossAmount() {
		return recvdItemGrossAmount;
	}

	public void setRecvdItemGrossAmount(double recvdItemGrossAmount) {
		this.recvdItemGrossAmount = recvdItemGrossAmount;
	}

	public double getTransitItemGrossAmount() {
		return transitItemGrossAmount;
	}

	public void setTransitItemGrossAmount(double transitItemGrossAmount) {
		this.transitItemGrossAmount = transitItemGrossAmount;
	}

	public double getDiscPer() {
		return discPer;
	}

	public void setDiscPer(double discPer) {
		this.discPer = discPer;
	}

	public double getSendItemDiscAmount() {
		return sendItemDiscAmount;
	}

	public void setSendItemDiscAmount(double sendItemDiscAmount) {
		this.sendItemDiscAmount = sendItemDiscAmount;
	}

	public double getRecvdItemDiscAmount() {
		return recvdItemDiscAmount;
	}

	public void setRecvdItemDiscAmount(double recvdItemDiscAmount) {
		this.recvdItemDiscAmount = recvdItemDiscAmount;
	}

	public double getTransitItemDiscAmount() {
		return transitItemDiscAmount;
	}

	public void setTransitItemDiscAmount(double transitItemDiscAmount) {
		this.transitItemDiscAmount = transitItemDiscAmount;
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

	public double getSendItemTaxAmount() {
		return sendItemTaxAmount;
	}

	public void setSendItemTaxAmount(double sendItemTaxAmount) {
		this.sendItemTaxAmount = sendItemTaxAmount;
	}

	public double getRecvdItemTaxAmount() {
		return recvdItemTaxAmount;
	}

	public void setRecvdItemTaxAmount(double recvdItemTaxAmount) {
		this.recvdItemTaxAmount = recvdItemTaxAmount;
	}

	public double getTransitItemTaxAmount() {
		return transitItemTaxAmount;
	}

	public void setTransitItemTaxAmount(double transitItemTaxAmount) {
		this.transitItemTaxAmount = transitItemTaxAmount;
	}

	public double getSendItemNetAmount() {
		return sendItemNetAmount;
	}

	public void setSendItemNetAmount(double sendItemNetAmount) {
		this.sendItemNetAmount = sendItemNetAmount;
	}

	public double getRecvdItemNetAmount() {
		return recvdItemNetAmount;
	}

	public void setRecvdItemNetAmount(double recvdItemNetAmount) {
		this.recvdItemNetAmount = recvdItemNetAmount;
	}

	public double getTransitItemNetAmount() {
		return transitItemNetAmount;
	}

	public void setTransitItemNetAmount(double transitItemNetAmount) {
		this.transitItemNetAmount = transitItemNetAmount;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getFromStoreId() {
		return fromStoreId;
	}

	public void setFromStoreId(int fromStoreId) {
		this.fromStoreId = fromStoreId;
	}

	public int getFromFinyrId() {
		return fromFinyrId;
	}

	public void setFromFinyrId(int fromFinyrId) {
		this.fromFinyrId = fromFinyrId;
	}

	public int getToStoreId() {
		return toStoreId;
	}

	public void setToStoreId(int toStoreId) {
		this.toStoreId = toStoreId;
	}

	public int getToFinyrId() {
		return toFinyrId;
	}

	public void setToFinyrId(int toFinyrId) {
		this.toFinyrId = toFinyrId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "StockTransferDetails [id=" + id + ", stockTransId=" + stockTransId + ", stockTransNo=" + stockTransNo
				+ ", stockTransDate=" + stockTransDate + ", itemId=" + itemId + ", batchNo=" + batchNo + ", mfdDate="
				+ mfdDate + ", expiryDate=" + expiryDate + ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
				+ packUnitId + ", sendPackQty=" + sendPackQty + ", actSendPackQty=" + actSendPackQty + ", recvdPackQty="
				+ recvdPackQty + ", transitPackQty=" + transitPackQty + ", conversion=" + conversion + ", looseUnitId="
				+ looseUnitId + ", sendLooseQty=" + sendLooseQty + ", actSendLooseQty=" + actSendLooseQty
				+ ", recvdLooseQty=" + recvdLooseQty + ", transitLooseQty=" + transitLooseQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", saleRate=" + saleRate + ", purchaseRate=" + purchaseRate + ", mrpPerUnit="
				+ mrpPerUnit + ", ratePerUnit=" + ratePerUnit + ", sendItemGrossAmount=" + sendItemGrossAmount
				+ ", recvdItemGrossAmount=" + recvdItemGrossAmount + ", transitItemGrossAmount="
				+ transitItemGrossAmount + ", discPer=" + discPer + ", sendItemDiscAmount=" + sendItemDiscAmount
				+ ", recvdItemDiscAmount=" + recvdItemDiscAmount + ", transitItemDiscAmount=" + transitItemDiscAmount
				+ ", taxId=" + taxId + ", taxTypeId=" + taxTypeId + ", taxPercentage=" + taxPercentage
				+ ", sendItemTaxAmount=" + sendItemTaxAmount + ", recvdItemTaxAmount=" + recvdItemTaxAmount
				+ ", transitItemTaxAmount=" + transitItemTaxAmount + ", sendItemNetAmount=" + sendItemNetAmount
				+ ", recvdItemNetAmount=" + recvdItemNetAmount + ", transitItemNetAmount=" + transitItemNetAmount
				+ ", isDeleted=" + isDeleted + ", companyId=" + companyId + ", fromStoreId=" + fromStoreId
				+ ", fromFinyrId=" + fromFinyrId + ", toStoreId=" + toStoreId + ", toFinyrId=" + toFinyrId
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + "]";
	}

	
	

}
