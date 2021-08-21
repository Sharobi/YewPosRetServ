package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

	@XmlRootElement
	public class PurchaseInvDetailsDTO implements Serializable {
		
		private static final long serialVersionUID = 1L;
		
		
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
		@MapToData(columnAliases = { "taxable_rate" })
		private double taxableRate;
		
		@Expose
		@MapToData(columnAliases = { "is_tax_on_mrp" })
		private int isTaxOnMrp;
		
		@Expose
		@MapToData(columnAliases = { "purchase_net_amount" })
		private double purchaseNetAmount;
		
		@Expose
		@MapToData(columnAliases = { "sale_rate" })
		private double saleRate;
		
		@Expose
		@MapToData(columnAliases = { "purchase_order_id" })
		private int purchaseOrderId;
		
		@Expose
		@MapToData(columnAliases = { "purchase_order_inv_no" })
		private String purchaseOrderInvNo;
		
		
		@Expose
		@MapToData(columnAliases = { "tmp_mapping_id" })
		private int tmpMappingId;
		
		
		@Expose
		@MapToData(columnAliases = { "id" })
		private int id;
		
		@Expose
		@MapToData(columnAliases = { "location_id" })
		private int locationId;
		
		@Expose
		@MapToData(columnAliases = { "mfd_date" })
		private Date idmfdDate;
		
		@Expose
		@MapToData(columnAliases = { "expiry_month" })
		private int expiryMonth;
		

		//new fields
		@Expose
		@MapToData(columnAliases = { "inv_no"})
		private String invNo;

		@Expose
		@MapToData(columnAliases = { "inv_date"})
		@Temporal(TemporalType.TIMESTAMP)
		private Date invDate;


		@Expose
		@MapToData(columnAliases = { "finyr_id"})
		private int finyrId;

		@Expose
		@Column(name = "store_id")
		private int storeId;

		@Expose
		@MapToData(columnAliases = { "company_id"})
		private int companyId;

		@Expose
		@Transient
		private String lang;

		@Expose
		@Transient
		private String qryCondition;

		@Expose
		@Transient
		private int schdId;

		@Expose
		@Transient
		private String schdName;

		@Expose
		@Transient
		private int manuId;

		@Expose
		@Transient
		private String manuName;

		@Expose
		@Transient
		private String manuCode;
		
		@Expose
		@MapToData(columnAliases = { "mfd_date"})
		@Temporal(TemporalType.TIMESTAMP)
		private Date mfdDate;
		
		@Expose
		@MapToData(columnAliases = { "retail_type_id"})
		private int retailTypeId;
		
		@Expose
		@Transient
		private List<PurchaseInvDetailsSerialMapping> purchaseDetailsSerialMapper;
		
		@Expose
		@MapToData(columnAliases = { "purchase_inv_id"})
		private int purchaseInvId;
		
		@Expose
		@MapToData(columnAliases = { "category_name" })
		private String categoryName;
		
		@Expose
		@MapToData(columnAliases = { "subcategory_name" })
		private String subcategoryName;
		
		@Expose
		@MapToData(columnAliases = { "category_id" })
		private int categoryId;
		
		@Expose
		@MapToData(columnAliases = { "subcategory_id" })
		private int subcategoryId;

		public int getItemId() {
			return itemId;
		}

		@XmlElement
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}

		public String getItemName() {
			return itemName;
		}

		@XmlElement
		public void setItemName(String itemName) {
			this.itemName = itemName;
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

		public String getExpiryDateFormat() {
			return expiryDateFormat;
		}

		@XmlElement
		public void setExpiryDateFormat(String expiryDateFormat) {
			this.expiryDateFormat = expiryDateFormat;
		}

		public int getPackUnitId() {
			return packUnitId;
		}

		@XmlElement
		public void setPackUnitId(int packUnitId) {
			this.packUnitId = packUnitId;
		}

		public String getPackUnitName() {
			return packUnitName;
		}

		@XmlElement
		public void setPackUnitName(String packUnitName) {
			this.packUnitName = packUnitName;
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

		public int getLooseQty() {
			return looseQty;
		}

		@XmlElement
		public void setLooseQty(int looseQty) {
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

		public double getEdPer() {
			return edPer;
		}

		@XmlElement
		public void setEdPer(double edPer) {
			this.edPer = edPer;
		}

		public double getEd() {
			return ed;
		}

		@XmlElement
		public void setEd(double ed) {
			this.ed = ed;
		}

		public double getTaxPer() {
			return taxPer;
		}

		@XmlElement
		public void setTaxPer(double taxPer) {
			this.taxPer = taxPer;
		}

		public double getTax() {
			return tax;
		}

		@XmlElement
		public void setTax(double tax) {
			this.tax = tax;
		}

		public double getVatPer() {
			return vatPer;
		}

		@XmlElement
		public void setVatPer(double vatPer) {
			this.vatPer = vatPer;
		}

		public double getVat() {
			return vat;
		}

		@XmlElement
		public void setVat(double vat) {
			this.vat = vat;
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

		public double getTotAmount() {
			return totAmount;
		}

		@XmlElement
		public void setTotAmount(double totAmount) {
			this.totAmount = totAmount;
		}

		public int getPurchaseId() {
			return purchaseId;
		}

		@XmlElement
		public void setPurchaseId(int purchaseId) {
			this.purchaseId = purchaseId;
		}

		public String getPurchaseInvNo() {
			return purchaseInvNo;
		}

		@XmlElement
		public void setPurchaseInvNo(String purchaseInvNo) {
			this.purchaseInvNo = purchaseInvNo;
		}

		public int getHidePackQty() {
			return hidePackQty;
		}

		@XmlElement
		public void setHidePackQty(int hidePackQty) {
			this.hidePackQty = hidePackQty;
		}

		public int getHideLooseQty() {
			return hideLooseQty;
		}

		@XmlElement
		public void setHideLooseQty(int hideLooseQty) {
			this.hideLooseQty = hideLooseQty;
		}

		public int getScheduleId() {
			return scheduleId;
		}

		@XmlElement
		public void setScheduleId(int scheduleId) {
			this.scheduleId = scheduleId;
		}

		public String getScheduleName() {
			return scheduleName;
		}

		@XmlElement
		public void setScheduleName(String scheduleName) {
			this.scheduleName = scheduleName;
		}

		public int getManufacturerId() {
			return manufacturerId;
		}

		@XmlElement
		public void setManufacturerId(int manufacturerId) {
			this.manufacturerId = manufacturerId;
		}

		public String getManufacturerName() {
			return manufacturerName;
		}

		@XmlElement
		public void setManufacturerName(String manufacturerName) {
			this.manufacturerName = manufacturerName;
		}

		public String getManufacturerCode() {
			return manufacturerCode;
		}

		@XmlElement
		public void setManufacturerCode(String manufacturerCode) {
			this.manufacturerCode = manufacturerCode;
		}

		public int getRemainingPackQty() {
			return remainingPackQty;
		}

		@XmlElement
		public void setRemainingPackQty(int remainingPackQty) {
			this.remainingPackQty = remainingPackQty;
		}

		public int getRemainingLooseQty() {
			return remainingLooseQty;
		}

		@XmlElement
		public void setRemainingLooseQty(int remainingLooseQty) {
			this.remainingLooseQty = remainingLooseQty;
		}

		public int getGrpId() {
			return grpId;
		}

		@XmlElement
		public void setGrpId(int grpId) {
			this.grpId = grpId;
		}

		public String getGrpName() {
			return grpName;
		}

		@XmlElement
		public void setGrpName(String grpName) {
			this.grpName = grpName;
		}

		public String getItemUniqueKey() {
			return itemUniqueKey;
		}

		@XmlElement
		public void setItemUniqueKey(String itemUniqueKey) {
			this.itemUniqueKey = itemUniqueKey;
		}

		public double getItemLotAdjAmount() {
			return itemLotAdjAmount;
		}

		@XmlElement
		public void setItemLotAdjAmount(double itemLotAdjAmount) {
			this.itemLotAdjAmount = itemLotAdjAmount;
		}

		public String getStockQty() {
			return stockQty;
		}

		@XmlElement
		public void setStockQty(String stockQty) {
			this.stockQty = stockQty;
		}

		public int getTaxId() {
			return taxId;
		}

		@XmlElement
		public void setTaxId(int taxId) {
			this.taxId = taxId;
		}

		public String getTaxName() {
			return taxName;
		}

		@XmlElement
		public void setTaxName(String taxName) {
			this.taxName = taxName;
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

		public String getSku() {
			return sku;
		}

		@XmlElement
		public void setSku(String sku) {
			this.sku = sku;
		}

		public String getHsnCode() {
			return hsnCode;
		}

		@XmlElement
		public void setHsnCode(String hsnCode) {
			this.hsnCode = hsnCode;
		}

		public int getReasonId() {
			return reasonId;
		}

		@XmlElement
		public void setReasonId(int reasonId) {
			this.reasonId = reasonId;
		}

		public String getReasonTypeName() {
			return reasonTypeName;
		}

		@XmlElement
		public void setReasonTypeName(String reasonTypeName) {
			this.reasonTypeName = reasonTypeName;
		}

		public int getStockRequired() {
			return stockRequired;
		}

		@XmlElement
		public void setStockRequired(int stockRequired) {
			this.stockRequired = stockRequired;
		}

		public int getBatchWiseStock() {
			return batchWiseStock;
		}

		@XmlElement
		public void setBatchWiseStock(int batchWiseStock) {
			this.batchWiseStock = batchWiseStock;
		}

		public int getExpiryDateRequired() {
			return expiryDateRequired;
		}

		@XmlElement
		public void setExpiryDateRequired(int expiryDateRequired) {
			this.expiryDateRequired = expiryDateRequired;
		}

		public int getExpiryMonthRequired() {
			return expiryMonthRequired;
		}

		@XmlElement
		public void setExpiryMonthRequired(int expiryMonthRequired) {
			this.expiryMonthRequired = expiryMonthRequired;
		}

		public int getDualStockRequired() {
			return dualStockRequired;
		}

		@XmlElement
		public void setDualStockRequired(int dualStockRequired) {
			this.dualStockRequired = dualStockRequired;
		}

		public int getLocationRequired() {
			return locationRequired;
		}

		@XmlElement
		public void setLocationRequired(int locationRequired) {
			this.locationRequired = locationRequired;
		}

		public int getPriceListRequired() {
			return priceListRequired;
		}

		@XmlElement
		public void setPriceListRequired(int priceListRequired) {
			this.priceListRequired = priceListRequired;
		}

		public int getSizeWiseStockRequired() {
			return sizeWiseStockRequired;
		}

		@XmlElement
		public void setSizeWiseStockRequired(int sizeWiseStockRequired) {
			this.sizeWiseStockRequired = sizeWiseStockRequired;
		}

		public int getColourWiseStockRequired() {
			return colourWiseStockRequired;
		}

		@XmlElement
		public void setColourWiseStockRequired(int colourWiseStockRequired) {
			this.colourWiseStockRequired = colourWiseStockRequired;
		}

		public int getWarrantyRequired() {
			return warrantyRequired;
		}

		@XmlElement
		public void setWarrantyRequired(int warrantyRequired) {
			this.warrantyRequired = warrantyRequired;
		}

		public int getWarrantyMonth() {
			return warrantyMonth;
		}

		@XmlElement
		public void setWarrantyMonth(int warrantyMonth) {
			this.warrantyMonth = warrantyMonth;
		}

		public int getMrpRequired() {
			return mrpRequired;
		}

		@XmlElement
		public void setMrpRequired(int mrpRequired) {
			this.mrpRequired = mrpRequired;
		}

		public int getSerialNoRequired() {
			return serialNoRequired;
		}

		@XmlElement
		public void setSerialNoRequired(int serialNoRequired) {
			this.serialNoRequired = serialNoRequired;
		}

		public int getSerialNoSuffRequired() {
			return serialNoSuffRequired;
		}

		@XmlElement
		public void setSerialNoSuffRequired(int serialNoSuffRequired) {
			this.serialNoSuffRequired = serialNoSuffRequired;
		}

		public int getSerialNoPrefRequired() {
			return serialNoPrefRequired;
		}

		@XmlElement
		public void setSerialNoPrefRequired(int serialNoPrefRequired) {
			this.serialNoPrefRequired = serialNoPrefRequired;
		}

		public int getRateOn() {
			return rateOn;
		}

		@XmlElement
		public void setRateOn(int rateOn) {
			this.rateOn = rateOn;
		}

		public String getSerialNoType() {
			return serialNoType;
		}

		@XmlElement
		public void setSerialNoType(String serialNoType) {
			this.serialNoType = serialNoType;
		}

		public String getWarrantyTypeOn() {
			return warrantyTypeOn;
		}

		@XmlElement
		public void setWarrantyTypeOn(String warrantyTypeOn) {
			this.warrantyTypeOn = warrantyTypeOn;
		}

		public String getSize() {
			return size;
		}

		@XmlElement
		public void setSize(String size) {
			this.size = size;
		}

		public String getSizeType() {
			return sizeType;
		}

		@XmlElement
		public void setSizeType(String sizeType) {
			this.sizeType = sizeType;
		}

		public String getColour() {
			return colour;
		}

		@XmlElement
		public void setColour(String colour) {
			this.colour = colour;
		}

		public double getDiscount() {
			return discount;
		}

		@XmlElement
		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public int getIsDiscount() {
			return isDiscount;
		}

		@XmlElement
		public void setIsDiscount(int isDiscount) {
			this.isDiscount = isDiscount;
		}

		public int getPurchaseReturnId() {
			return purchaseReturnId;
		}

		@XmlElement
		public void setPurchaseReturnId(int purchaseReturnId) {
			this.purchaseReturnId = purchaseReturnId;
		}

		public int getPurchaseReturnDetailsId() {
			return purchaseReturnDetailsId;
		}

		@XmlElement
		public void setPurchaseReturnDetailsId(int purchaseReturnDetailsId) {
			this.purchaseReturnDetailsId = purchaseReturnDetailsId;
		}

		public double getTaxableRate() {
			return taxableRate;
		}

		@XmlElement
		public void setTaxableRate(double taxableRate) {
			this.taxableRate = taxableRate;
		}

		public int getIsTaxOnMrp() {
			return isTaxOnMrp;
		}

		@XmlElement
		public void setIsTaxOnMrp(int isTaxOnMrp) {
			this.isTaxOnMrp = isTaxOnMrp;
		}

		public double getPurchaseNetAmount() {
			return purchaseNetAmount;
		}

		@XmlElement
		public void setPurchaseNetAmount(double purchaseNetAmount) {
			this.purchaseNetAmount = purchaseNetAmount;
		}

		public double getSaleRate() {
			return saleRate;
		}

		@XmlElement
		public void setSaleRate(double saleRate) {
			this.saleRate = saleRate;
		}

		public int getPurchaseOrderId() {
			return purchaseOrderId;
		}

		@XmlElement
		public void setPurchaseOrderId(int purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
		}

		public String getPurchaseOrderInvNo() {
			return purchaseOrderInvNo;
		}

		@XmlElement
		public void setPurchaseOrderInvNo(String purchaseOrderInvNo) {
			this.purchaseOrderInvNo = purchaseOrderInvNo;
		}

		public int getTmpMappingId() {
			return tmpMappingId;
		}

		@XmlElement
		public void setTmpMappingId(int tmpMappingId) {
			this.tmpMappingId = tmpMappingId;
		}

		public int getId() {
			return id;
		}

		@XmlElement
		public void setId(int id) {
			this.id = id;
		}

		public int getLocationId() {
			return locationId;
		}

		@XmlElement
		public void setLocationId(int locationId) {
			this.locationId = locationId;
		}

		public Date getIdmfdDate() {
			return idmfdDate;
		}

		@XmlElement
		public void setIdmfdDate(Date idmfdDate) {
			this.idmfdDate = idmfdDate;
		}

		public int getExpiryMonth() {
			return expiryMonth;
		}

		@XmlElement
		public void setExpiryMonth(int expiryMonth) {
			this.expiryMonth = expiryMonth;
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

		public String getQryCondition() {
			return qryCondition;
		}

		@XmlElement
		public void setQryCondition(String qryCondition) {
			this.qryCondition = qryCondition;
		}

		public int getSchdId() {
			return schdId;
		}

		@XmlElement
		public void setSchdId(int schdId) {
			this.schdId = schdId;
		}

		public String getSchdName() {
			return schdName;
		}

		@XmlElement
		public void setSchdName(String schdName) {
			this.schdName = schdName;
		}

		public int getManuId() {
			return manuId;
		}

		@XmlElement
		public void setManuId(int manuId) {
			this.manuId = manuId;
		}

		public String getManuName() {
			return manuName;
		}

		@XmlElement
		public void setManuName(String manuName) {
			this.manuName = manuName;
		}

		public String getManuCode() {
			return manuCode;
		}

		@XmlElement
		public void setManuCode(String manuCode) {
			this.manuCode = manuCode;
		}

		public Date getMfdDate() {
			return mfdDate;
		}

		@XmlElement
		public void setMfdDate(Date mfdDate) {
			this.mfdDate = mfdDate;
		}

		public int getRetailTypeId() {
			return retailTypeId;
		}

		@XmlElement
		public void setRetailTypeId(int retailTypeId) {
			this.retailTypeId = retailTypeId;
		}

		public List<PurchaseInvDetailsSerialMapping> getPurchaseDetailsSerialMapper() {
			return purchaseDetailsSerialMapper;
		}

		public void setPurchaseDetailsSerialMapper(List<PurchaseInvDetailsSerialMapping> purchaseDetailsSerialMapper) {
			this.purchaseDetailsSerialMapper = purchaseDetailsSerialMapper;
		}

		public int getPurchaseInvId() {
			return purchaseInvId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		@XmlElement
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getSubcategoryName() {
			return subcategoryName;
		}

		@XmlElement
		public void setSubcategoryName(String subcategoryName) {
			this.subcategoryName = subcategoryName;
		}

		public int getCategoryId() {
			return categoryId;
		}

		@XmlElement
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}

		public int getSubcategoryId() {
			return subcategoryId;
		}

		@XmlElement
		public void setSubcategoryId(int subcategoryId) {
			this.subcategoryId = subcategoryId;
		}

		@XmlElement
		public void setPurchaseInvId(int purchaseInvId) {
			this.purchaseInvId = purchaseInvId;
		}

		@Override
		public String toString() {
			return "PurchaseInvDetailsDTO [itemId=" + itemId + ", itemName=" + itemName + ", batchNo=" + batchNo
					+ ", expiryDate=" + expiryDate + ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
					+ packUnitId + ", packUnitName=" + packUnitName + ", packQty=" + packQty + ", conversion="
					+ conversion + ", looseQty=" + looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp + ", rate=" + rate
					+ ", amount=" + amount + ", edPer=" + edPer + ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax
					+ ", vatPer=" + vatPer + ", vat=" + vat + ", discPer=" + discPer + ", disc=" + disc + ", totAmount="
					+ totAmount + ", purchaseId=" + purchaseId + ", purchaseInvNo=" + purchaseInvNo + ", hidePackQty="
					+ hidePackQty + ", hideLooseQty=" + hideLooseQty + ", scheduleId=" + scheduleId + ", scheduleName="
					+ scheduleName + ", manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
					+ ", manufacturerCode=" + manufacturerCode + ", remainingPackQty=" + remainingPackQty
					+ ", remainingLooseQty=" + remainingLooseQty + ", grpId=" + grpId + ", grpName=" + grpName
					+ ", itemUniqueKey=" + itemUniqueKey + ", itemLotAdjAmount=" + itemLotAdjAmount + ", stockQty="
					+ stockQty + ", taxId=" + taxId + ", taxName=" + taxName + ", taxPercentage=" + taxPercentage
					+ ", taxAmount=" + taxAmount + ", isGroupTax=" + isGroupTax + ", taxMode=" + taxMode + ", sku="
					+ sku + ", hsnCode=" + hsnCode + ", reasonId=" + reasonId + ", reasonTypeName=" + reasonTypeName
					+ ", stockRequired=" + stockRequired + ", batchWiseStock=" + batchWiseStock
					+ ", expiryDateRequired=" + expiryDateRequired + ", expiryMonthRequired=" + expiryMonthRequired
					+ ", dualStockRequired=" + dualStockRequired + ", locationRequired=" + locationRequired
					+ ", priceListRequired=" + priceListRequired + ", sizeWiseStockRequired=" + sizeWiseStockRequired
					+ ", colourWiseStockRequired=" + colourWiseStockRequired + ", warrantyRequired=" + warrantyRequired
					+ ", warrantyMonth=" + warrantyMonth + ", mrpRequired=" + mrpRequired + ", serialNoRequired="
					+ serialNoRequired + ", serialNoSuffRequired=" + serialNoSuffRequired + ", serialNoPrefRequired="
					+ serialNoPrefRequired + ", rateOn=" + rateOn + ", serialNoType=" + serialNoType
					+ ", warrantyTypeOn=" + warrantyTypeOn + ", size=" + size + ", sizeType=" + sizeType + ", colour="
					+ colour + ", discount=" + discount + ", isDiscount=" + isDiscount + ", purchaseReturnId="
					+ purchaseReturnId + ", purchaseReturnDetailsId=" + purchaseReturnDetailsId + ", taxableRate="
					+ taxableRate + ", isTaxOnMrp=" + isTaxOnMrp + ", purchaseNetAmount=" + purchaseNetAmount
					+ ", saleRate=" + saleRate + ", purchaseOrderId=" + purchaseOrderId + ", purchaseOrderInvNo="
					+ purchaseOrderInvNo + ", tmpMappingId=" + tmpMappingId + ", id=" + id + ", locationId="
					+ locationId + ", idmfdDate=" + idmfdDate + ", expiryMonth=" + expiryMonth + ", invNo=" + invNo
					+ ", invDate=" + invDate + ", finyrId=" + finyrId + ", storeId=" + storeId + ", companyId="
					+ companyId + ", lang=" + lang + ", qryCondition=" + qryCondition + ", schdId=" + schdId
					+ ", schdName=" + schdName + ", manuId=" + manuId + ", manuName=" + manuName + ", manuCode="
					+ manuCode + ", mfdDate=" + mfdDate + ", retailTypeId=" + retailTypeId
					+ ", purchaseDetailsSerialMapper=" + purchaseDetailsSerialMapper + ", purchaseInvId="
					+ purchaseInvId + ", categoryName=" + categoryName + ", subcategoryName=" + subcategoryName
					+ ", categoryId=" + categoryId + ", subcategoryId=" + subcategoryId + "]";
		}

}
