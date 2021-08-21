package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class ItemCurrentStockDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;

	@Expose
	@MapToData(columnAliases = { "code" })
	private String code;
	
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
	@MapToData(columnAliases = { "conversion" })
	private int conversion;

	@Expose
	@MapToData(columnAliases = { "mrp" })
	private double mrp;

	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private double packQty;

	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private double looseQty;

	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;

	@Expose
	@MapToData(columnAliases = { "content_name" })
	private String contentName;

	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String manufacturerName;

	@Expose
	@MapToData(columnAliases = { "net_content" })
	private String netContent;

	@Expose
	@MapToData(columnAliases = { "stock_qty" })
	private String stockQty;

	@Expose
	@MapToData(columnAliases = { "rack_name" })
	private String rackName;

	@Expose
	@MapToData(columnAliases = { "hold_qty" })
	private String holdQty;

	@Expose
	@MapToData(columnAliases = { "calculate_loose_hold_qty" })
	private double calculateLooseHoldQty;

	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String groupName;

	@Expose
	@MapToData(columnAliases = { "loose_unit_id" })
	private int looseUnitId;

	@Expose
	@MapToData(columnAliases = { "loose_unit_name" })
	private String looseUnitName;

	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int scheduleId;

	@Expose
	@MapToData(columnAliases = { "schedule_name" })
	private String scheduleName;
	
	@Expose
	@MapToData(columnAliases = { "calculate_loose_qty" })
	private double calculateLooseQty ;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "expiry_status_mode" })
	private int expiryStatusMode;

	@Expose
	@MapToData(columnAliases = { "expiry_status" })
	private String expiryStatus;
	
	@Expose
	@MapToData(columnAliases = { "vat_per" })
	private double vatPer;
	
	@Expose
	@MapToData(columnAliases = { "tax_per" })
	private double taxPer;
	
	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;
	
	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;
	
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
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;
	
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
	@MapToData(columnAliases = { "note" })
	private String note;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;
	
	@Expose
	@MapToData(columnAliases = { "purchase_rate" })
	private double purchaseRate;
	
	@Expose
	@MapToData(columnAliases = { "claculate_loose_reorder_level_qty" })
	private double claculateLooseReorderLevelQty;
	
	@Expose
	@MapToData(columnAliases={"stock_required"})
	private int stockRequired;
	
	@Expose
	@MapToData(columnAliases={"batch_wise_stock"})
	private int batchWiseStock;
	
	@Expose
	@MapToData(columnAliases={"expiry_date_required"})
	private int expiryDateRequired;
	
	@Expose
	@MapToData(columnAliases={"expiry_month_required"})
	private int expiryMonthRequired;
	
	@Expose
	@MapToData(columnAliases={"dual_stock_required"})
	private int dualStockRequired;
	
	@Expose
	@MapToData(columnAliases={"location_required"})
	private int locationRequired;
	
	@Expose
	@MapToData(columnAliases={"price_list_required"})
	private int priceListRequired;
	
	@Expose
	@MapToData(columnAliases={"size_wise_stock_required"})
	private int sizeWiseStockRequired;
	
	@Expose
	@MapToData(columnAliases={"colour_wise_stock_required"})
	private int colourWiseStockRequired;
	
	@Expose
	@MapToData(columnAliases={"warranty_required"})
	private int warrantyRequired;
	
	@Expose
	@MapToData(columnAliases={"warranty_month"})
	private int warrantyMonth;
	
	@Expose
	@MapToData(columnAliases={"mrp_required"})
	private int mrpRequired;
	
	@Expose
	@MapToData(columnAliases={"serial_no_required"})
	private int serialNoRequired;
	
	@Expose
	@MapToData(columnAliases={"serial_no_suff_required"})
	private int serialNoSuffRequired;
	
	@Expose
	@MapToData(columnAliases={"serial_no_pref_required"})
	private int  serialNoPrefRequired;
	
	@Expose
	@MapToData(columnAliases={"rate_on"})
	private int rateOn;
	
	@Expose
	@MapToData(columnAliases={"serial_no_type"})
	private String serialNoType;
	
	@Expose
	@MapToData(columnAliases={"warranty_type_on"})
	private String warrantyTypeOn;
	
	@Expose
	@MapToData(columnAliases={"size"})
	private String size;
	
	@Expose
	@MapToData(columnAliases={"size_type"})
	private String sizeType;
	
	@Expose
	@MapToData(columnAliases={"colour"})
	private String colour;
	
	@Expose
	@MapToData(columnAliases={"location_id"})
	private int locationId;
	
	@Expose
	@MapToData(columnAliases = { "mfd_date" })
	private Date mfdDate;
	
	@Expose
	@MapToData(columnAliases = { "tax_type_id" })
	private int taxTypeId;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate_on" })
	private String sale_rate_on;
	
	@Expose
	@MapToData(columnAliases = { "item_code" })
	private String itemCode;
	
	//new field 23.07.2018
	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;
	
	private static final long serialVersionUID = 1L;
	
	
	public int getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getWarrantyTypeOn() {
		return warrantyTypeOn;
	}

	public void setWarrantyTypeOn(String warrantyTypeOn) {
		this.warrantyTypeOn = warrantyTypeOn;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getSizeType() {
		return sizeType;
	}

	public void setSizeType(String sizeType) {
		this.sizeType = sizeType;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public double getClaculateLooseReorderLevelQty() {
		return claculateLooseReorderLevelQty;
	}

	public void setClaculateLooseReorderLevelQty(double claculateLooseReorderLevelQty) {
		this.claculateLooseReorderLevelQty = claculateLooseReorderLevelQty;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getTaxMode() {
		return taxMode;
	}

	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public int getIsGroupTax() {
		return isGroupTax;
	}

	public void setIsGroupTax(int isGroupTax) {
		this.isGroupTax = isGroupTax;
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

	public double getPurchaseCostPerUnit() {
		return purchaseCostPerUnit;
	}

	public void setPurchaseCostPerUnit(double purchaseCostPerUnit) {
		this.purchaseCostPerUnit = purchaseCostPerUnit;
	}

	public double getVatPer() {
		return vatPer;
	}

	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public double getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public String getExpiryStatus() {
		return expiryStatus;
	}

	public void setExpiryStatus(String expiryStatus) {
		this.expiryStatus = expiryStatus;
	}

	public int getExpiryStatusMode() {
		return expiryStatusMode;
	}

	public void setExpiryStatusMode(int expiryStatusMode) {
		this.expiryStatusMode = expiryStatusMode;
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

	public double getCalculateLooseQty() {
		return calculateLooseQty;
	}

	public void setCalculateLooseQty(double calculateLooseQty) {
		this.calculateLooseQty = calculateLooseQty;
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

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getNetContent() {
		return netContent;
	}

	public void setNetContent(String netContent) {
		this.netContent = netContent;
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

	public String getHoldQty() {
		return holdQty;
	}

	public void setHoldQty(String holdQty) {
		this.holdQty = holdQty;
	}

	public double getCalculateLooseHoldQty() {
		return calculateLooseHoldQty;
	}

	public void setCalculateLooseHoldQty(double calculateLooseHoldQty) {
		this.calculateLooseHoldQty = calculateLooseHoldQty;
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

	public int getConversion() {
		return conversion;
	}

	public void setConversion(int conversion) {
		this.conversion = conversion;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getPackQty() {
		return packQty;
	}

	public void setPackQty(double packQty) {
		this.packQty = packQty;
	}

	public double getLooseQty() {
		return looseQty;
	}

	public void setLooseQty(double looseQty) {
		this.looseQty = looseQty;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	
	
	/**
	 * @return the stockRequired
	 */
	public int getStockRequired() {
		return stockRequired;
	}

	/**
	 * @param stockRequired the stockRequired to set
	 */
	public void setStockRequired(int stockRequired) {
		this.stockRequired = stockRequired;
	}

	/**
	 * @return the batchWiseStock
	 */
	public int getBatchWiseStock() {
		return batchWiseStock;
	}

	/**
	 * @param batchWiseStock the batchWiseStock to set
	 */
	public void setBatchWiseStock(int batchWiseStock) {
		this.batchWiseStock = batchWiseStock;
	}

	/**
	 * @return the expiryDateRequired
	 */
	public int getExpiryDateRequired() {
		return expiryDateRequired;
	}

	/**
	 * @param expiryDateRequired the expiryDateRequired to set
	 */
	public void setExpiryDateRequired(int expiryDateRequired) {
		this.expiryDateRequired = expiryDateRequired;
	}

	/**
	 * @return the expiryMonthRequired
	 */
	public int getExpiryMonthRequired() {
		return expiryMonthRequired;
	}

	/**
	 * @param expiryMonthRequired the expiryMonthRequired to set
	 */
	public void setExpiryMonthRequired(int expiryMonthRequired) {
		this.expiryMonthRequired = expiryMonthRequired;
	}

	/**
	 * @return the dualStockRequired
	 */
	public int getDualStockRequired() {
		return dualStockRequired;
	}

	/**
	 * @param dualStockRequired the dualStockRequired to set
	 */
	public void setDualStockRequired(int dualStockRequired) {
		this.dualStockRequired = dualStockRequired;
	}

	/**
	 * @return the locationRequired
	 */
	public int getLocationRequired() {
		return locationRequired;
	}

	/**
	 * @param locationRequired the locationRequired to set
	 */
	public void setLocationRequired(int locationRequired) {
		this.locationRequired = locationRequired;
	}

	/**
	 * @return the priceListRequired
	 */
	public int getPriceListRequired() {
		return priceListRequired;
	}

	/**
	 * @param priceListRequired the priceListRequired to set
	 */
	public void setPriceListRequired(int priceListRequired) {
		this.priceListRequired = priceListRequired;
	}

	/**
	 * @return the sizeWiseStockRequired
	 */
	public int getSizeWiseStockRequired() {
		return sizeWiseStockRequired;
	}

	/**
	 * @param sizeWiseStockRequired the sizeWiseStockRequired to set
	 */
	public void setSizeWiseStockRequired(int sizeWiseStockRequired) {
		this.sizeWiseStockRequired = sizeWiseStockRequired;
	}

	/**
	 * @return the colourWiseStockRequired
	 */
	public int getColourWiseStockRequired() {
		return colourWiseStockRequired;
	}

	/**
	 * @param colourWiseStockRequired the colourWiseStockRequired to set
	 */
	public void setColourWiseStockRequired(int colourWiseStockRequired) {
		this.colourWiseStockRequired = colourWiseStockRequired;
	}

	/**
	 * @return the warrantyRequired
	 */
	public int getWarrantyRequired() {
		return warrantyRequired;
	}

	/**
	 * @param warrantyRequired the warrantyRequired to set
	 */
	public void setWarrantyRequired(int warrantyRequired) {
		this.warrantyRequired = warrantyRequired;
	}

	/**
	 * @return the warrantyMonth
	 */
	public int getWarrantyMonth() {
		return warrantyMonth;
	}

	/**
	 * @param warrantyMonth the warrantyMonth to set
	 */
	public void setWarrantyMonth(int warrantyMonth) {
		this.warrantyMonth = warrantyMonth;
	}

	/**
	 * @return the mrpRequired
	 */
	public int getMrpRequired() {
		return mrpRequired;
	}

	/**
	 * @param mrpRequired the mrpRequired to set
	 */
	public void setMrpRequired(int mrpRequired) {
		this.mrpRequired = mrpRequired;
	}

	/**
	 * @return the serialNoRequired
	 */
	public int getSerialNoRequired() {
		return serialNoRequired;
	}

	/**
	 * @param serialNoRequired the serialNoRequired to set
	 */
	public void setSerialNoRequired(int serialNoRequired) {
		this.serialNoRequired = serialNoRequired;
	}

	/**
	 * @return the serialNoSuffRequired
	 */
	public int getSerialNoSuffRequired() {
		return serialNoSuffRequired;
	}

	/**
	 * @param serialNoSuffRequired the serialNoSuffRequired to set
	 */
	public void setSerialNoSuffRequired(int serialNoSuffRequired) {
		this.serialNoSuffRequired = serialNoSuffRequired;
	}

	/**
	 * @return the serialNoPrefRequired
	 */
	public int getSerialNoPrefRequired() {
		return serialNoPrefRequired;
	}

	/**
	 * @param serialNoPrefRequired the serialNoPrefRequired to set
	 */
	public void setSerialNoPrefRequired(int serialNoPrefRequired) {
		this.serialNoPrefRequired = serialNoPrefRequired;
	}

	/**
	 * @return the rateOn
	 */
	public int getRateOn() {
		return rateOn;
	}

	/**
	 * @param rateOn the rateOn to set
	 */
	public void setRateOn(int rateOn) {
		this.rateOn = rateOn;
	}

	/**
	 * @return the serialNoType
	 */
	public String getSerialNoType() {
		return serialNoType;
	}

	/**
	 * @param serialNoType the serialNoType to set
	 */
	public void setSerialNoType(String serialNoType) {
		this.serialNoType = serialNoType;
	}

	public String getSale_rate_on() {
		return sale_rate_on;
	}

	public void setSale_rate_on(String sale_rate_on) {
		this.sale_rate_on = sale_rate_on;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		//result = prime * result + calculateLooseHoldQty;
		//result = prime * result + calculateLooseQty;
		result = prime * result
				+ ((contentName == null) ? 0 : contentName.hashCode());
		result = prime * result + conversion;
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result
				+ ((expiryStatus == null) ? 0 : expiryStatus.hashCode());
		result = prime * result + expiryStatusMode;
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((holdQty == null) ? 0 : holdQty.hashCode());
		result = prime * result + ((hsnCode == null) ? 0 : hsnCode.hashCode());
		result = prime * result + isDiscount;
		result = prime * result + isGroupTax;
		result = prime * result + itemId;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		temp = Double.doubleToLongBits(looseQty);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + looseUnitId;
		result = prime * result
				+ ((looseUnitName == null) ? 0 : looseUnitName.hashCode());
		result = prime
				* result
				+ ((manufacturerCode == null) ? 0 : manufacturerCode.hashCode());
		result = prime
				* result
				+ ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		temp = Double.doubleToLongBits(maxDiscountLimit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((netContent == null) ? 0 : netContent.hashCode());
		result = prime * result + ((note == null) ? 0 : note.hashCode());
		//result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		temp = Double.doubleToLongBits(purchaseCostPerUnit);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(purchaseRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((rackName == null) ? 0 : rackName.hashCode());
		temp = Double.doubleToLongBits(saleRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + scheduleId;
		result = prime * result
				+ ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		result = prime * result
				+ ((stockQty == null) ? 0 : stockQty.hashCode());
		result = prime * result + taxId;
		result = prime * result + ((taxMode == null) ? 0 : taxMode.hashCode());
		result = prime * result + ((taxName == null) ? 0 : taxName.hashCode());
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxPercentage);
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
		ItemCurrentStockDTO other = (ItemCurrentStockDTO) obj;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (calculateLooseHoldQty != other.calculateLooseHoldQty)
			return false;
		if (calculateLooseQty != other.calculateLooseQty)
			return false;
		if (contentName == null) {
			if (other.contentName != null)
				return false;
		} else if (!contentName.equals(other.contentName))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(discount) != Double
				.doubleToLongBits(other.discount))
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
		if (expiryStatus == null) {
			if (other.expiryStatus != null)
				return false;
		} else if (!expiryStatus.equals(other.expiryStatus))
			return false;
		if (expiryStatusMode != other.expiryStatusMode)
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (holdQty == null) {
			if (other.holdQty != null)
				return false;
		} else if (!holdQty.equals(other.holdQty))
			return false;
		if (hsnCode == null) {
			if (other.hsnCode != null)
				return false;
		} else if (!hsnCode.equals(other.hsnCode))
			return false;
		if (isDiscount != other.isDiscount)
			return false;
		if (isGroupTax != other.isGroupTax)
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemUniqueKey == null) {
			if (other.itemUniqueKey != null)
				return false;
		} else if (!itemUniqueKey.equals(other.itemUniqueKey))
			return false;
		if (Double.doubleToLongBits(looseQty) != Double
				.doubleToLongBits(other.looseQty))
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
		if (manufacturerName == null) {
			if (other.manufacturerName != null)
				return false;
		} else if (!manufacturerName.equals(other.manufacturerName))
			return false;
		if (Double.doubleToLongBits(maxDiscountLimit) != Double
				.doubleToLongBits(other.maxDiscountLimit))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (netContent == null) {
			if (other.netContent != null)
				return false;
		} else if (!netContent.equals(other.netContent))
			return false;
		if (note == null) {
			if (other.note != null)
				return false;
		} else if (!note.equals(other.note))
			return false;
		if (packQty != other.packQty)
			return false;
		if (packUnitId != other.packUnitId)
			return false;
		if (packUnitName == null) {
			if (other.packUnitName != null)
				return false;
		} else if (!packUnitName.equals(other.packUnitName))
			return false;
		if (Double.doubleToLongBits(purchaseCostPerUnit) != Double
				.doubleToLongBits(other.purchaseCostPerUnit))
			return false;
		if (Double.doubleToLongBits(purchaseRate) != Double
				.doubleToLongBits(other.purchaseRate))
			return false;
		if (rackName == null) {
			if (other.rackName != null)
				return false;
		} else if (!rackName.equals(other.rackName))
			return false;
		if (Double.doubleToLongBits(saleRate) != Double
				.doubleToLongBits(other.saleRate))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		if (stockQty == null) {
			if (other.stockQty != null)
				return false;
		} else if (!stockQty.equals(other.stockQty))
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
		if (Double.doubleToLongBits(taxPer) != Double
				.doubleToLongBits(other.taxPer))
			return false;
		if (Double.doubleToLongBits(taxPercentage) != Double
				.doubleToLongBits(other.taxPercentage))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemCurrentStockDTO [itemId=" + itemId + ", code=" + code + ", batchNo=" + batchNo + ", expiryDate="
				+ expiryDate + ", expiryDateFormat=" + expiryDateFormat + ", packUnitId=" + packUnitId + ", conversion="
				+ conversion + ", mrp=" + mrp + ", packQty=" + packQty + ", looseQty=" + looseQty + ", packUnitName="
				+ packUnitName + ", contentName=" + contentName + ", manufacturerName=" + manufacturerName
				+ ", netContent=" + netContent + ", stockQty=" + stockQty + ", rackName=" + rackName + ", holdQty="
				+ holdQty + ", calculateLooseHoldQty=" + calculateLooseHoldQty + ", groupName=" + groupName
				+ ", looseUnitId=" + looseUnitId + ", looseUnitName=" + looseUnitName + ", scheduleId=" + scheduleId
				+ ", scheduleName=" + scheduleName + ", calculateLooseQty=" + calculateLooseQty + ", manufacturerCode="
				+ manufacturerCode + ", itemUniqueKey=" + itemUniqueKey + ", expiryStatusMode=" + expiryStatusMode
				+ ", expiryStatus=" + expiryStatus + ", vatPer=" + vatPer + ", taxPer=" + taxPer + ", itemName="
				+ itemName + ", sku=" + sku + ", hsnCode=" + hsnCode + ", taxId=" + taxId + ", taxName=" + taxName
				+ ", taxPercentage=" + taxPercentage + ", taxMode=" + taxMode + ", isGroupTax=" + isGroupTax
				+ ", discount=" + discount + ", isDiscount=" + isDiscount + ", maxDiscountLimit=" + maxDiscountLimit
				+ ", purchaseCostPerUnit=" + purchaseCostPerUnit + ", note=" + note + ", saleRate=" + saleRate
				+ ", purchaseRate=" + purchaseRate + ", claculateLooseReorderLevelQty=" + claculateLooseReorderLevelQty
				+ ", stockRequired=" + stockRequired + ", batchWiseStock=" + batchWiseStock + ", expiryDateRequired="
				+ expiryDateRequired + ", expiryMonthRequired=" + expiryMonthRequired + ", dualStockRequired="
				+ dualStockRequired + ", locationRequired=" + locationRequired + ", priceListRequired="
				+ priceListRequired + ", sizeWiseStockRequired=" + sizeWiseStockRequired + ", colourWiseStockRequired="
				+ colourWiseStockRequired + ", warrantyRequired=" + warrantyRequired + ", warrantyMonth="
				+ warrantyMonth + ", mrpRequired=" + mrpRequired + ", serialNoRequired=" + serialNoRequired
				+ ", serialNoSuffRequired=" + serialNoSuffRequired + ", serialNoPrefRequired=" + serialNoPrefRequired
				+ ", rateOn=" + rateOn + ", serialNoType=" + serialNoType + ", warrantyTypeOn=" + warrantyTypeOn
				+ ", size=" + size + ", sizeType=" + sizeType + ", colour=" + colour + ", locationId=" + locationId
				+ ", mfdDate=" + mfdDate + ", taxTypeId=" + taxTypeId + ", sale_rate_on=" + sale_rate_on + ", itemCode="
				+ itemCode + ", name=" + name + "]";
	}


}