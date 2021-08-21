/**
 * 
 */
package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * @author Habib
 *
 */
@XmlRootElement
public class StockTransferDetailsDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "trans_id" })
	private int transId;

	@Expose
	@MapToData(columnAliases = { "trans_details_id" })
	private int transDetailId;

	@Expose
	@MapToData(columnAliases = { "stock_transfer_no" })
	private String stockTransNo;

	@Expose
	@MapToData(columnAliases = { "stock_transfer_date" })
	private Date stockTransDate;

	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;
	
	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "item_code" })
	private String itemCode;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;

	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;

	@Expose
	@MapToData(columnAliases = { "batch_no" })
	private String batchNo;
	
	@Expose
	@MapToData(columnAliases = { "mfd_date" })
	private Date mfdDate;

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
	@MapToData(columnAliases = { "send_pack_qty" })
	private double sendPackQty;
	
	@Expose
	@MapToData(columnAliases = { "act_send_pack_qty" })
	private double actSendPackQty;
	
	@Expose
	@MapToData(columnAliases = { "recvd_pack_qty" })
	private double recvdPackQty;
	
	@Expose
	@MapToData(columnAliases = { "transit_pack_qty" })
	private double transitPackQty;

	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;

	@Expose
	@MapToData(columnAliases = { "loose_unit_id" })
	private int looseUnitId;
	
	@Expose
	@MapToData(columnAliases = { "loose_unit_name" })
	private String looseUnitName;

	@Expose
	@MapToData(columnAliases = { "send_loose_qty" })
	private int sendLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "act_send_loose_qty" })
	private int actSendLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "recvd_loose_qty" })
	private int recvdLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "transit_loose_qty" })
	private int transitLooseQty;

	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "rate" })
	private double rate;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;
	
	@Expose
	@MapToData(columnAliases = { "purchase_rate" })
	private double purchaseRate;
	
	@Expose
	@MapToData(columnAliases = { "mrp_per_unit" })
	private double mrpPerUnit;
	
	@Expose
	@MapToData(columnAliases = { "rate_per_unit" })
	private double ratePerUnit;
	
	@Expose
	@MapToData(columnAliases = { "send_item_gross_amount" })
	private double sendItemGrossAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_item_gross_amount" })
	private double recvdItemGrossAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_item_gross_amount" })
	private double transitItemGrossAmount;
	
	@Expose
	@MapToData(columnAliases = { "disc_per" })
	private double discPer;
	
	@Expose
	@MapToData(columnAliases = { "send_item_disc_amount" })
	private double sendItemDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_item_disc_amount" })
	private double recvdItemDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_item_disc_amount" })
	private double transitItemDiscAmount;
	
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
	@MapToData(columnAliases = { "send_item_tax_amount" })
	private double sendItemTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_item_tax_amount" })
	private double recvdItemTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_item_tax_amount" })
	private double transitItemTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "send_item_net_amount" })
	private double sendItemNetAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_item_net_amount" })
	private double recvdItemNetAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_item_net_amount" })
	private double transitItemNetAmount;
	
	@Expose
	@MapToData(columnAliases = { "is_deleted" })
	private int isDeleted;
	
	@Expose
	@MapToData(columnAliases = { "company_id" })
	private int companyId;
	
	@Expose
	@MapToData(columnAliases = { "from_store_id" })
	private int fromStoreId;
	
	@Expose
	@MapToData(columnAliases = { "from_store_name" })
	private String fromStoreName;
	
	@Expose
	@MapToData(columnAliases = { "from_finyr_id" })
	private int fromFinyrId;
	
	@Expose
	@MapToData(columnAliases = { "to_store_id" })
	private int toStoreId;
	
	@Expose
	@MapToData(columnAliases = { "to_store_name" })
	private String toStoreName;
	
	@Expose
	@MapToData(columnAliases = { "to_finyr_id" })
	private int toFinyrId;
	
	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int groupId;

	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String groupName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_id" })
	private int manufacturerId;

	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
	}

	public int getTransDetailId() {
		return transDetailId;
	}

	public void setTransDetailId(int transDetailId) {
		this.transDetailId = transDetailId;
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

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
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

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
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

	public String getLooseUnitName() {
		return looseUnitName;
	}

	public void setLooseUnitName(String looseUnitName) {
		this.looseUnitName = looseUnitName;
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

	public String getFromStoreName() {
		return fromStoreName;
	}

	public void setFromStoreName(String fromStoreName) {
		this.fromStoreName = fromStoreName;
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

	public String getToStoreName() {
		return toStoreName;
	}

	public void setToStoreName(String toStoreName) {
		this.toStoreName = toStoreName;
	}

	public int getToFinyrId() {
		return toFinyrId;
	}

	public void setToFinyrId(int toFinyrId) {
		this.toFinyrId = toFinyrId;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(int manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	@Override
	public String toString() {
		return "StockTransferDetailsDTO [transId=" + transId + ", transDetailId=" + transDetailId + ", stockTransNo="
				+ stockTransNo + ", stockTransDate=" + stockTransDate + ", itemId=" + itemId + ", itemName=" + itemName
				+ ", itemCode=" + itemCode + ", sku=" + sku + ", hsnCode=" + hsnCode + ", batchNo=" + batchNo
				+ ", mfdDate=" + mfdDate + ", expiryDate=" + expiryDate + ", expiryDateFormat=" + expiryDateFormat
				+ ", packUnitId=" + packUnitId + ", packUnitName=" + packUnitName + ", sendPackQty=" + sendPackQty
				+ ", actSendPackQty=" + actSendPackQty + ", recvdPackQty=" + recvdPackQty + ", transitPackQty="
				+ transitPackQty + ", conversion=" + conversion + ", looseUnitId=" + looseUnitId + ", looseUnitName="
				+ looseUnitName + ", sendLooseQty=" + sendLooseQty + ", actSendLooseQty=" + actSendLooseQty
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
				+ ", fromStoreName=" + fromStoreName + ", fromFinyrId=" + fromFinyrId + ", toStoreId=" + toStoreId
				+ ", toStoreName=" + toStoreName + ", toFinyrId=" + toFinyrId + ", groupId=" + groupId + ", groupName="
				+ groupName + ", manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", itemUniqueKey=" + itemUniqueKey + "]";
	}
	

}
