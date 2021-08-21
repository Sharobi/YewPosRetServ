package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class PurchaseReturnDetailsDTO implements Serializable {
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
	private int looseQty;
	
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
	@MapToData(columnAliases = { "purchase_id" })
	private int purchaseId;
	
	@Expose
	@MapToData(columnAliases = { "purchase_inv_no" })
	private String purchaseInvNo;
	
	@Expose
	@MapToData(columnAliases = { "hide_pack_qty" })
	private int hidePackQty;
	
	@Expose
	@MapToData(columnAliases = { "hide_loose_qty" })
	private int hideLooseQty;
	
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
	@MapToData(columnAliases = { "manufacturer_code" })
	private String manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "remaining_pack_qty" })
	private int remainingPackQty;
	
	@Expose
	@MapToData(columnAliases = { "remaining_loose_qty" })
	private int remainingLooseQty;
	
	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int grpId;
	
	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String grpName;
	
	@Expose
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "item_lot_adj_amount" })
	private double itemLotAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "stock_qty" })
	private String stockQty;
	
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
	@MapToData(columnAliases = { "reason_id" })
	private int reasonId;
	
	@Expose
	@MapToData(columnAliases = { "reason_type_name" })
	private String reasonTypeName;
	
	@Expose
	@MapToData(columnAliases = { "stock_required" })
	private int stockRequired;
	
	@Expose
	@MapToData(columnAliases = { "batch_wise_stock" })
	private int batchWiseStock;
	
	@Expose
	@MapToData(columnAliases = { "expiry_date_required" })
	private int expiryDateRequired;
	
	@Expose
	@MapToData(columnAliases = { "expiry_month_required" })
	private int expiryMonthRequired;
	
	@Expose
	@MapToData(columnAliases = { "dual_stock_required" })
	private int dualStockRequired;
	
	@Expose
	@MapToData(columnAliases = { "location_required" })
	private int locationRequired;
	
	@Expose
	@MapToData(columnAliases = { "price_list_required" })
	private int priceListRequired;
	
	@Expose
	@MapToData(columnAliases = { "size_wise_stock_required" })
	private int sizeWiseStockRequired;
	
	@Expose
	@MapToData(columnAliases = { "colour_wise_stock_required" })
	private int colourWiseStockRequired;
	
	@Expose
	@MapToData(columnAliases = { "warranty_required" })
	private int warrantyRequired;
	
	@Expose
	@MapToData(columnAliases = { "warranty_month" })
	private int warrantyMonth;
	
	@Expose
	@MapToData(columnAliases = { "mrp_required" })
	private int mrpRequired;
	
	@Expose
	@MapToData(columnAliases = { "serial_no_required" })
	private int serialNoRequired;
	
	@Expose
	@MapToData(columnAliases = { "serial_no_suff_required" })
	private int serialNoSuffRequired;
	
	@Expose
	@MapToData(columnAliases = { "serial_no_pref_required" })
	private int serialNoPrefRequired;
	
	@Expose
	@MapToData(columnAliases = { "rate_on" })
	private int rateOn;
	
	@Expose
	@MapToData(columnAliases = { "serial_no_type" })
	private String serialNoType;
	
	@Expose
	@MapToData(columnAliases = { "warranty_type_on" })
	private String warrantyTypeOn;
	
	@Expose
	@MapToData(columnAliases = { "size" })
	private String size;
	
	@Expose
	@MapToData(columnAliases = { "size_type" })
	private String sizeType;
	
	@Expose
	@MapToData(columnAliases = { "colour" })
	private String colour;
	
	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;
	
	@Expose
	@MapToData(columnAliases = { "is_discount" })
	private int isDiscount;
	
	@Expose
	@MapToData(columnAliases = { "purchase_return_id" })
	private int purchaseReturnId;
	
	@Expose
	@MapToData(columnAliases = { "purchase_return_details_id" })
	private int purchaseReturnDetailsId;
	
	@Expose
	@Transient
	private List<PurchaseReturnDetailsSerialMapper> purchaseReturnDetailsSerialMapper;

	private static final long serialVersionUID = 1L;
	
	
	public List<PurchaseReturnDetailsSerialMapper> getPurchaseReturnDetailsSerialMapper() {
		return purchaseReturnDetailsSerialMapper;
	}

	public void setPurchaseReturnDetailsSerialMapper(
			List<PurchaseReturnDetailsSerialMapper> purchaseReturnDetailsSerialMapper) {
		this.purchaseReturnDetailsSerialMapper = purchaseReturnDetailsSerialMapper;
	}

	public int getPurchaseReturnId() {
		return purchaseReturnId;
	}

	public void setPurchaseReturnId(int purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	public int getPurchaseReturnDetailsId() {
		return purchaseReturnDetailsId;
	}

	public void setPurchaseReturnDetailsId(int purchaseReturnDetailsId) {
		this.purchaseReturnDetailsId = purchaseReturnDetailsId;
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

	public String getSerialNoType() {
		return serialNoType;
	}

	public void setSerialNoType(String serialNoType) {
		this.serialNoType = serialNoType;
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

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public String getReasonTypeName() {
		return reasonTypeName;
	}

	public void setReasonTypeName(String reasonTypeName) {
		this.reasonTypeName = reasonTypeName;
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

	public String getStockQty() {
		return stockQty;
	}

	public void setStockQty(String stockQty) {
		this.stockQty = stockQty;
	}

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	public int getGrpId() {
		return grpId;
	}

	public void setGrpId(int grpId) {
		this.grpId = grpId;
	}

	public String getGrpName() {
		return grpName;
	}

	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}

	public int getHidePackQty() {
		return hidePackQty;
	}

	public void setHidePackQty(int hidePackQty) {
		this.hidePackQty = hidePackQty;
	}

	public int getHideLooseQty() {
		return hideLooseQty;
	}

	public void setHideLooseQty(int hideLooseQty) {
		this.hideLooseQty = hideLooseQty;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	
	public int getRemainingPackQty() {
		return remainingPackQty;
	}

	public void setRemainingPackQty(int remainingPackQty) {
		this.remainingPackQty = remainingPackQty;
	}

	public int getRemainingLooseQty() {
		return remainingLooseQty;
	}

	public void setRemainingLooseQty(int remainingLooseQty) {
		this.remainingLooseQty = remainingLooseQty;
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

//	public int getFreeQty() {
//		return freeQty;
//	}
//
//	public void setFreeQty(int freeQty) {
//		this.freeQty = freeQty;
//	}

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getPurchaseInvNo() {
		return purchaseInvNo;
	}

	public void setPurchaseInvNo(String purchaseInvNo) {
		this.purchaseInvNo = purchaseInvNo;
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

	public double getFreeQty() {
		return freeQty;
	}

	public void setFreeQty(double freeQty) {
		this.freeQty = freeQty;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((batchNo == null) ? 0 : batchNo.hashCode());
		result = prime * result + conversion;
		temp = Double.doubleToLongBits(disc);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(ed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + (int)freeQty;
		result = prime * result + grpId;
		result = prime * result + ((grpName == null) ? 0 : grpName.hashCode());
		result = prime * result + hideLooseQty;
		result = prime * result + hidePackQty;
		result = prime * result + itemId;
		temp = Double.doubleToLongBits(itemLotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((itemUniqueKey == null) ? 0 : itemUniqueKey.hashCode());
		result = prime * result + looseQty;
		result = prime
				* result
				+ ((manufacturerCode == null) ? 0 : manufacturerCode.hashCode());
		result = prime * result + manufacturerId;
		result = prime
				* result
				+ ((manufacturerName == null) ? 0 : manufacturerName.hashCode());
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		//result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		result = prime * result + purchaseId;
		result = prime * result
				+ ((purchaseInvNo == null) ? 0 : purchaseInvNo.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + remainingLooseQty;
		result = prime * result + remainingPackQty;
		result = prime * result + scheduleId;
		result = prime * result
				+ ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime * result
				+ ((stockQty == null) ? 0 : stockQty.hashCode());
		temp = Double.doubleToLongBits(tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totAmount);
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
		PurchaseReturnDetailsDTO other = (PurchaseReturnDetailsDTO) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (batchNo == null) {
			if (other.batchNo != null)
				return false;
		} else if (!batchNo.equals(other.batchNo))
			return false;
		if (conversion != other.conversion)
			return false;
		if (Double.doubleToLongBits(disc) != Double
				.doubleToLongBits(other.disc))
			return false;
		if (Double.doubleToLongBits(discPer) != Double
				.doubleToLongBits(other.discPer))
			return false;
		if (Double.doubleToLongBits(ed) != Double.doubleToLongBits(other.ed))
			return false;
		if (Double.doubleToLongBits(edPer) != Double
				.doubleToLongBits(other.edPer))
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
		if (freeQty != other.freeQty)
			return false;
		if (grpId != other.grpId)
			return false;
		if (grpName == null) {
			if (other.grpName != null)
				return false;
		} else if (!grpName.equals(other.grpName))
			return false;
		if (hideLooseQty != other.hideLooseQty)
			return false;
		if (hidePackQty != other.hidePackQty)
			return false;
		if (itemId != other.itemId)
			return false;
		if (Double.doubleToLongBits(itemLotAdjAmount) != Double
				.doubleToLongBits(other.itemLotAdjAmount))
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
		if (looseQty != other.looseQty)
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
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
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
		if (purchaseId != other.purchaseId)
			return false;
		if (purchaseInvNo == null) {
			if (other.purchaseInvNo != null)
				return false;
		} else if (!purchaseInvNo.equals(other.purchaseInvNo))
			return false;
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (remainingLooseQty != other.remainingLooseQty)
			return false;
		if (remainingPackQty != other.remainingPackQty)
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (stockQty == null) {
			if (other.stockQty != null)
				return false;
		} else if (!stockQty.equals(other.stockQty))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		if (Double.doubleToLongBits(taxPer) != Double
				.doubleToLongBits(other.taxPer))
			return false;
		if (Double.doubleToLongBits(totAmount) != Double
				.doubleToLongBits(other.totAmount))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double
				.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PurchaseReturnDetailsDTO [itemId=" + itemId + ", itemName="
				+ itemName + ", batchNo=" + batchNo + ", expiryDate="
				+ expiryDate + ", expiryDateFormat=" + expiryDateFormat
				+ ", packUnitId=" + packUnitId + ", packUnitName="
				+ packUnitName + ", packQty=" + packQty + ", conversion="
				+ conversion + ", looseQty=" + looseQty + ", freeQty="
				+ freeQty + ", mrp=" + mrp + ", rate=" + rate + ", amount="
				+ amount + ", edPer=" + edPer + ", ed=" + ed + ", taxPer="
				+ taxPer + ", tax=" + tax + ", vatPer=" + vatPer + ", vat="
				+ vat + ", discPer=" + discPer + ", disc=" + disc
				+ ", totAmount=" + totAmount + ", purchaseId=" + purchaseId
				+ ", purchaseInvNo=" + purchaseInvNo + ", hidePackQty="
				+ hidePackQty + ", hideLooseQty=" + hideLooseQty
				+ ", scheduleId=" + scheduleId + ", scheduleName="
				+ scheduleName + ", manufacturerId=" + manufacturerId
				+ ", manufacturerName=" + manufacturerName
				+ ", manufacturerCode=" + manufacturerCode
				+ ", remainingPackQty=" + remainingPackQty
				+ ", remainingLooseQty=" + remainingLooseQty + ", grpId="
				+ grpId + ", grpName=" + grpName + ", itemUniqueKey="
				+ itemUniqueKey + ", itemLotAdjAmount=" + itemLotAdjAmount
				+ ", stockQty=" + stockQty + "]";
	}
	
	

		
}