package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SaleDetailsDTO implements Serializable {
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
	@MapToData(columnAliases = { "loose_unit_name" })
	private String looseUnitName;

	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private int looseQty;

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
	@MapToData(columnAliases = { "ed_per" })
	private double edPer;

	@Expose
	@MapToData(columnAliases = { "ed" })
	private double ed;

	@Expose
	@MapToData(columnAliases = { "tax_per" })
	private double taxPer;

	@Expose
	@MapToData(columnAliases = { "tax" })
	private double tax;

	@Expose
	@MapToData(columnAliases = { "vat_per" })
	private double vatPer;

	@Expose
	@MapToData(columnAliases = { "vat" })
	private double vat;

	@Expose
	@MapToData(columnAliases = { "disc_per" })
	private double discPer;

	@Expose
	@MapToData(columnAliases = { "disc" })
	private double disc;

	@Expose
	@MapToData(columnAliases = { "tot_amount" })
	private double totAmount;

	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int groupId;

	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String groupName;

	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int scheduleId;

	@Expose
	@MapToData(columnAliases = { "schedule_name" })
	private String scheduleName;

	@Expose
	@MapToData(columnAliases = { "manufacturer_id" })
	private int manufacturerId;

	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;

	@Expose
	@MapToData(columnAliases = { "content_id" })
	private int contentId;

	@Expose
	@MapToData(columnAliases = { "content_name" })
	private String contentName;

	@Expose
	@MapToData(columnAliases = { "mrp_per_unit" })
	private double mrpPerUnit;

	@Expose
	@MapToData(columnAliases = { "rate_per_unit" })
	private double ratePerUnit;

	@Expose
	@MapToData(columnAliases = { "loose_unit_id" })
	private int looseUnitId;

	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;

	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;

	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;

	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String taxName;

	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;

	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;

	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;

	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;

	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;

	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;

	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;

	@Expose
	@MapToData(columnAliases = { "is_discount" })
	private int isDiscount;

	@Expose
	@MapToData(columnAliases = { "max_discount_limit" })
	private double maxDiscountLimit;

	@Expose
	@MapToData(columnAliases = { "purchase_cost_per_unit" })
	private double purchaseCostPerUnit;

	@Expose
	@MapToData(columnAliases = { "total_amount" })
	private double totalAmount;

	@Expose
	@MapToData(columnAliases = { "taxable_amount" })
	private double taxableAmount;

	@Expose
	@MapToData(columnAliases = { "CGST" })
	private double cgst;

	@Expose
	@MapToData(columnAliases = { "CGST_percentage" })
	private double cgstPercentage;

	@Expose
	@MapToData(columnAliases = { "SGST" })
	private double sgst;

	@Expose
	@MapToData(columnAliases = { "SGST_percentage" })
	private double sgstPercentage;

	@Expose
	@MapToData(columnAliases = { "IGST" })
	private double igst;

	@Expose
	@MapToData(columnAliases = { "IGST_percentage" })
	private double igstPercentage;

	@Expose
	@MapToData(columnAliases = { "item_total_mrp" })
	private double itemTotalMrp;

	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;

	@Expose
	@MapToData(columnAliases = { "net_content" })
	private String netContent;

	@Expose
	@MapToData(columnAliases = { "purchase_rate" })
	private double purchaseRate;

	@Expose
	@MapToData(columnAliases = { "tax_type_id" })
	private int taxTypeId;

	@Expose
	@Transient
	private List<SalesDetailsSerialMapper> salesDetailsSerialMapper;

	@Expose
	@MapToData(columnAliases = { "item_lot_adj_amount" })
	private double itemLotAdjAmount;

	@Expose
	@MapToData(columnAliases = { "serial_no_required" })
	private int serialNoRequired;

	@Expose
	@MapToData(columnAliases = { "serial_no_dtl" })
	private String serialNoDtl;

	@Expose
	@MapToData(columnAliases = { "itemdualstock" })
	private int itemdualstock;

	@Expose
	@MapToData(columnAliases = { "salesman_id" })
	private int salesmanId;

	@Expose
	@MapToData(columnAliases = { "salesman_factor" })
	private double salesmanFactor;

	@Expose
	@MapToData(columnAliases = { "salesman_amount" })
	private double salesmanAmount;
	
	@Expose
	@MapToData(columnAliases = { "salesman_name"} )
	private String salesmanName;

	@Expose
	@MapToData(columnAliases = { "free_qty" })
	private double freeQty;
	
	@Expose
	@MapToData(columnAliases = { "item_free_against_item"})
	private int itemFreeAgainstItem;
	
	@Expose
	@MapToData(columnAliases = { "sale_order_id"})
	private int saleOrderId;
	
	@Expose
	@MapToData(columnAliases = { "remarks"})
	private String remarks;
	
	@Expose
	@MapToData(columnAliases = { "item_remarks"})
	private String itemRemarks;
	
	@Expose
	@MapToData(columnAliases = { "sale_order_inv_no" })
	private String saleOrderInvNo;

	private static final long serialVersionUID = 1L;

	public SaleDetailsDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getSerialNoRequired() {
		return serialNoRequired;
	}

	public void setSerialNoRequired(int serialNoRequired) {
		this.serialNoRequired = serialNoRequired;
	}

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public List<SalesDetailsSerialMapper> getSalesDetailsSerialMapper() {
		return salesDetailsSerialMapper;
	}

	public void setSalesDetailsSerialMapper(List<SalesDetailsSerialMapper> salesDetailsSerialMapper) {
		this.salesDetailsSerialMapper = salesDetailsSerialMapper;
	}

	public int getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
	}

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getCgstPercentage() {
		return cgstPercentage;
	}

	public void setCgstPercentage(double cgstPercentage) {
		this.cgstPercentage = cgstPercentage;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getSgstPercentage() {
		return sgstPercentage;
	}

	public void setSgstPercentage(double sgstPercentage) {
		this.sgstPercentage = sgstPercentage;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getIgstPercentage() {
		return igstPercentage;
	}

	public void setIgstPercentage(double igstPercentage) {
		this.igstPercentage = igstPercentage;
	}

	public double getPurchaseCostPerUnit() {
		return purchaseCostPerUnit;
	}

	public void setPurchaseCostPerUnit(double purchaseCostPerUnit) {
		this.purchaseCostPerUnit = purchaseCostPerUnit;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getIsDiscount() {
		return isDiscount;
	}

	public void setIsDiscount(int isDiscount) {
		this.isDiscount = isDiscount;
	}

	public double getMaxDiscountLimit() {
		return maxDiscountLimit;
	}

	public void setMaxDiscountLimit(double maxDiscountLimit) {
		this.maxDiscountLimit = maxDiscountLimit;
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

	public int getTaxId() {
		return taxId;
	}

	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}

	public String getTaxName() {
		return taxName;
	}

	public void setTaxName(String taxName) {
		this.taxName = taxName;
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

	public int getIsGroupTax() {
		return isGroupTax;
	}

	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public int getLooseUnitId() {
		return looseUnitId;
	}

	public void setLooseUnitId(int looseUnitId) {
		this.looseUnitId = looseUnitId;
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

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
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

	public String getLooseUnitName() {
		return looseUnitName;
	}

	public void setLooseUnitName(String looseUnitName) {
		this.looseUnitName = looseUnitName;
	}

	public int getLooseQty() {
		return looseQty;
	}

	public void setLooseQty(int looseQty) {
		this.looseQty = looseQty;
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

	public double getEdPer() {
		return edPer;
	}

	public void setEdPer(double edPer) {
		this.edPer = edPer;
	}

	public double getEd() {
		return ed;
	}

	public void setEd(double ed) {
		this.ed = ed;
	}

	public double getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getVatPer() {
		return vatPer;
	}

	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
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

	public double getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
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

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
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

	/**
	 * @return the serialNoDtl
	 */
	public String getSerialNoDtl() {
		return serialNoDtl;
	}

	/**
	 * @param serialNoDtl
	 *            the serialNoDtl to set
	 */
	public void setSerialNoDtl(String serialNoDtl) {
		this.serialNoDtl = serialNoDtl;
	}

	public int getItemdualstock() {
		return itemdualstock;
	}

	public void setItemdualstock(int itemdualstock) {
		this.itemdualstock = itemdualstock;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	public double getSalesmanFactor() {
		return salesmanFactor;
	}

	public void setSalesmanFactor(double salesmanFactor) {
		this.salesmanFactor = salesmanFactor;
	}

	public double getSalesmanAmount() {
		return salesmanAmount;
	}

	public void setSalesmanAmount(double salesmanAmount) {
		this.salesmanAmount = salesmanAmount;
	}

	public double getFreeQty() {
		return freeQty;
	}

	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	public int getItemFreeAgainstItem() {
		return itemFreeAgainstItem;
	}

	public void setItemFreeAgainstItem(int itemFreeAgainstItem) {
		this.itemFreeAgainstItem = itemFreeAgainstItem;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
	}

	public String getSaleOrderInvNo() {
		return saleOrderInvNo;
	}

	public void setSaleOrderInvNo(String saleOrderInvNo) {
		this.saleOrderInvNo = saleOrderInvNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		temp = Double.doubleToLongBits(cgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cgstPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + contentId;
		result = prime * result + ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result + conversion;
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		temp = Double.doubleToLongBits(freeQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + groupId;
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((hsnCode == null) ? 0 : hsnCode.hashCode());
		temp = Double.doubleToLongBits(igst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(igstPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + isDiscount;
		result = prime * result + isGroupTax;
		result = prime * result + itemFreeAgainstItem;
		result = prime * result + itemId;
		temp = Double.doubleToLongBits(itemLotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		temp = Double.doubleToLongBits(itemTotalMrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + itemdualstock;
		result = prime * result + looseQty;
		result = prime * result + looseUnitId;
		result = prime * result + ((looseUnitName == null) ? 0 : looseUnitName.hashCode());
		result = prime * result + ((manufacturerCode == null) ? 0 : manufacturerCode.hashCode());
		result = prime * result + manufacturerId;
		result = prime * result + ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		temp = Double.doubleToLongBits(maxDiscountLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mrpPerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((netContent == null) ? 0 : netContent.hashCode());
		temp = Double.doubleToLongBits(packQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + packUnitId;
		result = prime * result + ((packUnitName == null) ? 0 : packUnitName.hashCode());
		temp = Double.doubleToLongBits(purchaseCostPerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(purchaseRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ratePerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleOrderId;
		temp = Double.doubleToLongBits(saleRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((salesDetailsSerialMapper == null) ? 0 : salesDetailsSerialMapper.hashCode());
		temp = Double.doubleToLongBits(salesmanAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(salesmanFactor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + salesmanId;
		result = prime * result + ((salesmanName == null) ? 0 : salesmanName.hashCode());
		result = prime * result + scheduleId;
		result = prime * result + ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result + ((serialNoDtl == null) ? 0 : serialNoDtl.hashCode());
		result = prime * result + serialNoRequired;
		temp = Double.doubleToLongBits(sgst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sgstPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		temp = Double.doubleToLongBits(tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taxId;
		result = prime * result + ((taxMode == null) ? 0 : taxMode.hashCode());
		result = prime * result + ((taxName == null) ? 0 : taxName.hashCode());
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxPercentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + taxTypeId;
		temp = Double.doubleToLongBits(taxableAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SaleDetailsDTO other = (SaleDetailsDTO) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (Double.doubleToLongBits(cgst) != Double.doubleToLongBits(other.cgst))
			return false;
		if (Double.doubleToLongBits(cgstPercentage) != Double.doubleToLongBits(other.cgstPercentage))
			return false;
		if (contentId != other.contentId)
			return false;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(disc) != Double.doubleToLongBits(other.disc))
			return false;
		if (Double.doubleToLongBits(discPer) != Double.doubleToLongBits(other.discPer))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (Double.doubleToLongBits(ed) != Double.doubleToLongBits(other.ed))
			return false;
		if (Double.doubleToLongBits(edPer) != Double.doubleToLongBits(other.edPer))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (expiryDateFormat == null) {
			if (other.expiryDateFormat != null)
				return false;
		} else if (!expiryDateFormat.equals(other.expiryDateFormat))
			return false;
		if (Double.doubleToLongBits(freeQty) != Double.doubleToLongBits(other.freeQty))
			return false;
		if (groupId != other.groupId)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (hsnCode == null) {
			if (other.hsnCode != null)
				return false;
		} else if (!hsnCode.equals(other.hsnCode))
			return false;
		if (Double.doubleToLongBits(igst) != Double.doubleToLongBits(other.igst))
			return false;
		if (Double.doubleToLongBits(igstPercentage) != Double.doubleToLongBits(other.igstPercentage))
			return false;
		if (isDiscount != other.isDiscount)
			return false;
		if (isGroupTax != other.isGroupTax)
			return false;
		if (itemFreeAgainstItem != other.itemFreeAgainstItem)
			return false;
		if (itemId != other.itemId)
			return false;
		if (Double.doubleToLongBits(itemLotAdjAmount) != Double.doubleToLongBits(other.itemLotAdjAmount))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(itemTotalMrp) != Double.doubleToLongBits(other.itemTotalMrp))
			return false;
		if (itemUniqueKey == null) {
			if (other.itemUniqueKey != null)
				return false;
		} else if (!itemUniqueKey.equals(other.itemUniqueKey))
			return false;
		if (itemdualstock != other.itemdualstock)
			return false;
		if (looseQty != other.looseQty)
			return false;
		if (looseUnitId != other.looseUnitId)
			return false;
		if (looseUnitName == null) {
			if (other.looseUnitName != null)
				return false;
		} else if (!looseUnitName.equals(other.looseUnitName))
			return false;
		if (manufacturerCode == null) {
			if (other.manufacturerCode != null)
				return false;
		} else if (!manufacturerCode.equals(other.manufacturerCode))
			return false;
		if (manufacturerId != other.manufacturerId)
			return false;
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		if (Double.doubleToLongBits(maxDiscountLimit) != Double.doubleToLongBits(other.maxDiscountLimit))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (Double.doubleToLongBits(mrpPerUnit) != Double.doubleToLongBits(other.mrpPerUnit))
			return false;
		if (netContent == null) {
			if (other.netContent != null)
				return false;
		} else if (!netContent.equals(other.netContent))
			return false;
		if (Double.doubleToLongBits(packQty) != Double.doubleToLongBits(other.packQty))
			return false;
		if (packUnitId != other.packUnitId)
			return false;
		if (packUnitName == null) {
			if (other.packUnitName != null)
				return false;
		} else if (!packUnitName.equals(other.packUnitName))
			return false;
		if (Double.doubleToLongBits(purchaseCostPerUnit) != Double.doubleToLongBits(other.purchaseCostPerUnit))
			return false;
		if (Double.doubleToLongBits(purchaseRate) != Double.doubleToLongBits(other.purchaseRate))
			return false;
		if (Double.doubleToLongBits(rate) != Double.doubleToLongBits(other.rate))
			return false;
		if (Double.doubleToLongBits(ratePerUnit) != Double.doubleToLongBits(other.ratePerUnit))
			return false;
		if (saleOrderId != other.saleOrderId)
			return false;
		if (Double.doubleToLongBits(saleRate) != Double.doubleToLongBits(other.saleRate))
			return false;
		if (salesDetailsSerialMapper == null) {
			if (other.salesDetailsSerialMapper != null)
				return false;
		} else if (!salesDetailsSerialMapper.equals(other.salesDetailsSerialMapper))
			return false;
		if (Double.doubleToLongBits(salesmanAmount) != Double.doubleToLongBits(other.salesmanAmount))
			return false;
		if (Double.doubleToLongBits(salesmanFactor) != Double.doubleToLongBits(other.salesmanFactor))
			return false;
		if (salesmanId != other.salesmanId)
			return false;
		if (salesmanName == null) {
			if (other.salesmanName != null)
				return false;
		} else if (!salesmanName.equals(other.salesmanName))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (serialNoDtl == null) {
			if (other.serialNoDtl != null)
				return false;
		} else if (!serialNoDtl.equals(other.serialNoDtl))
			return false;
		if (serialNoRequired != other.serialNoRequired)
			return false;
		if (Double.doubleToLongBits(sgst) != Double.doubleToLongBits(other.sgst))
			return false;
		if (Double.doubleToLongBits(sgstPercentage) != Double.doubleToLongBits(other.sgstPercentage))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double.doubleToLongBits(other.taxAmount))
			return false;
		if (taxId != other.taxId)
			return false;
		if (taxMode == null) {
			if (other.taxMode != null)
				return false;
		} else if (!taxMode.equals(other.taxMode))
			return false;
		if (taxName == null) {
			if (other.taxName != null)
				return false;
		} else if (!taxName.equals(other.taxName))
			return false;
		if (Double.doubleToLongBits(taxPer) != Double.doubleToLongBits(other.taxPer))
			return false;
		if (Double.doubleToLongBits(taxPercentage) != Double.doubleToLongBits(other.taxPercentage))
			return false;
		if (taxTypeId != other.taxTypeId)
			return false;
		if (Double.doubleToLongBits(taxableAmount) != Double.doubleToLongBits(other.taxableAmount))
			return false;
		if (Double.doubleToLongBits(totAmount) != Double.doubleToLongBits(other.totAmount))
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SaleDetailsDTO [itemId=" + itemId + ", itemName=" + itemName + ", itemCode=" + itemCode + ", batchNo="
				+ batchNo + ", expiryDate=" + expiryDate + ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
				+ packUnitId + ", packUnitName=" + packUnitName + ", packQty=" + packQty + ", conversion=" + conversion
				+ ", looseUnitName=" + looseUnitName + ", looseQty=" + looseQty + ", mrp=" + mrp + ", rate=" + rate
				+ ", amount=" + amount + ", edPer=" + edPer + ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax
				+ ", vatPer=" + vatPer + ", vat=" + vat + ", discPer=" + discPer + ", disc=" + disc + ", totAmount="
				+ totAmount + ", groupId=" + groupId + ", groupName=" + groupName + ", scheduleId=" + scheduleId
				+ ", scheduleName=" + scheduleName + ", manufacturerId=" + manufacturerId + ", manufacturerName="
				+ manufacturerName + ", contentId=" + contentId + ", contentName=" + contentName + ", mrpPerUnit="
				+ mrpPerUnit + ", ratePerUnit=" + ratePerUnit + ", looseUnitId=" + looseUnitId + ", manufacturerCode="
				+ manufacturerCode + ", itemUniqueKey=" + itemUniqueKey + ", taxId=" + taxId + ", taxName=" + taxName
				+ ", taxPercentage=" + taxPercentage + ", taxAmount=" + taxAmount + ", isGroupTax=" + isGroupTax
				+ ", taxMode=" + taxMode + ", sku=" + sku + ", hsnCode=" + hsnCode + ", discount=" + discount
				+ ", isDiscount=" + isDiscount + ", maxDiscountLimit=" + maxDiscountLimit + ", purchaseCostPerUnit="
				+ purchaseCostPerUnit + ", totalAmount=" + totalAmount + ", taxableAmount=" + taxableAmount + ", cgst="
				+ cgst + ", cgstPercentage=" + cgstPercentage + ", sgst=" + sgst + ", sgstPercentage=" + sgstPercentage
				+ ", igst=" + igst + ", igstPercentage=" + igstPercentage + ", itemTotalMrp=" + itemTotalMrp
				+ ", saleRate=" + saleRate + ", netContent=" + netContent + ", purchaseRate=" + purchaseRate
				+ ", taxTypeId=" + taxTypeId + ", salesDetailsSerialMapper=" + salesDetailsSerialMapper
				+ ", itemLotAdjAmount=" + itemLotAdjAmount + ", serialNoRequired=" + serialNoRequired + ", serialNoDtl="
				+ serialNoDtl + ", itemdualstock=" + itemdualstock + ", salesmanId=" + salesmanId + ", salesmanFactor="
				+ salesmanFactor + ", salesmanAmount=" + salesmanAmount + ", salesmanName=" + salesmanName
				+ ", freeQty=" + freeQty + ", itemFreeAgainstItem=" + itemFreeAgainstItem + ", saleOrderId="
				+ saleOrderId + ", remarks=" + remarks + ", itemRemarks=" + itemRemarks + ", saleOrderInvNo="
				+ saleOrderInvNo + "]";
	}

}