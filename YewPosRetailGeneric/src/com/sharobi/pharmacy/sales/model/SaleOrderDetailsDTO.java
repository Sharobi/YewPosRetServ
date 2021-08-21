package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;


@XmlRootElement
public class SaleOrderDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "item_id" })
	private int itemId;
	
	@Expose
	@MapToData(columnAliases = { "item_name" })
	private String itemName;
	
	@Expose
	@MapToData(columnAliases = { "pack_unit_id" })
	private int packUnitId;
	
	@Expose
	@MapToData(columnAliases = { "pack_qty" })
	private double packQty;
	
	@Expose
	@MapToData(columnAliases = { "conversion" })
	private int conversion;
	
	@Expose
	@MapToData(columnAliases = { "loose_qty" })
	private double looseQty;
	
	@Expose
	@MapToData(columnAliases = { "free_qty" })
	private double freeQty;
	
	@Expose
	@MapToData(columnAliases = { "sold_pack_qty" })
	private double soldPackQty;
	
	@Expose
	@MapToData(columnAliases = { "sold_loose_qty" })
	private double soldLooseQty;
	
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
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;
	
	@Expose
	@MapToData(columnAliases = { "disc_per" })
	private double discPer;

	@Expose
	@MapToData(columnAliases = { "disc" })
	private double disc;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "tmp_id" })
	private int	tmpId;
	
	@Expose
	@MapToData(columnAliases = { "group_id" })
	private int	groupId;
	
	@Expose
	@MapToData(columnAliases = { "group_name" })
	private String	groupName;
	
	@Expose
	@MapToData(columnAliases = { "schedule_id" })
	private int	scheduleId;
	
	@Expose
	@MapToData(columnAliases = { "schedule_name" })
	private String	scheduleName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_id" })
	private int	manufacturerId;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_name" })
	private String	manufacturerName;
	
	@Expose
	@MapToData(columnAliases = { "manufacturer_code" })
	private String	manufacturerCode;
	
	@Expose
	@MapToData(columnAliases = { "tax_id" })
	private int taxId;
	
	@Expose
	@MapToData(columnAliases = { "tax_name" })
	private String	taxName;
	
	@Expose
	@MapToData(columnAliases = { "tax_percentage" })
	private double taxPercentage;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;
	
	@Expose
	@MapToData(columnAliases = { "SKU" })
	private String sku;
	
	@Expose
	@MapToData(columnAliases = { "HSN_code" })
	private String hsnCode;
	
	@Expose
	@MapToData(columnAliases = { "inv_type" })
	private String invType;
	
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "sale_order_id" })
	private int saleOrderId;
	
	@Expose
	@MapToData(columnAliases = { "item_total_mrp" })
	private double itemTotalMrp;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	@Expose
	@MapToData(columnAliases = { "order_pack_qty" })
	private int orderPackQty;
	
	@Expose
	@MapToData(columnAliases = { "order_loose_qty" })
	private int orderLooseQty;
	
	///////////
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
	@MapToData(columnAliases = { "item_unique_key" })
	private String itemUniqueKey;
	
	@Expose
	@MapToData(columnAliases = { "pack_unit_name" })
	private String packUnitName;
	
	@Expose
	@MapToData(columnAliases = { "pending_pack_qty" })
	private int pendingPackQty;
	
	@Expose
	@MapToData(columnAliases = { "pending_rec_loose_qty" })
	private int pendingRecLooseQty;
	
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
	@MapToData(columnAliases = { "item_lot_adj_amount" })
	private double itemLotAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "tot_amount" })
	private double totAmount;
	
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
	@MapToData(columnAliases = { "tax_type_id" })
	private int taxTypeId;
	
	
	//new fields

	@Expose
	@MapToData(columnAliases = { "qryCondition" })
	private String qryCondition;

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
	@MapToData(columnAliases = { "retail_type_id" })
	private int retailTypeId;
	
	@Expose
	@MapToData(columnAliases = { "tmp_mapping_id" })
	private int tmpMappingId;
	
	@Expose
	@MapToData(columnAliases = { "location_id" })
	private int locationId;
	
	@Expose
	private List<SaleDetailsSerialMapper> saleDetailsSerialMapper;
	
	@Expose
	@MapToData(columnAliases = { "size" })
	private String size;
	
	@Expose
	@MapToData(columnAliases = { "sizeType" })
	private String sizeType;
	
	@Expose
	@MapToData(columnAliases = { "colour" })
	private String colour;
	
	@Expose
	@MapToData(columnAliases = { "expiry_month" })
	private int expiryMonth;
	
	@Expose
	@MapToData(columnAliases = { "item_code" })
	private String itemCode;
	
	@Expose
	@MapToData(columnAliases = { "mfd_date" })
    private Date mfdDate;
	
	@Expose
	@MapToData(columnAliases = { "item_free_against_item" })
    private int itemFreeAgainstItem;
	
	@Expose
	@MapToData(columnAliases = { "adv_amount" })
    private double advAmount;
	
	@Expose
	@MapToData(columnAliases = { "purchase_cost_per_unit" })
	private double purchaseCostPerUnit=0;
	
	@Expose
	@MapToData(columnAliases = { "purchase_rate" })
    private double purchaseRate=0;
	
	@Expose
	@MapToData(columnAliases = { "remarks" })
    private String remarks;
	
	@Expose
	@MapToData(columnAliases = { "taxable_amount" })
	private double taxableAmount;
	
	@Expose
	@MapToData(columnAliases = { "item_remarks" })
    private String itemRemarks;
	
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
	@MapToData(columnAliases = { "is_discount" })
	private int isDiscount;

	@Expose
	@MapToData(columnAliases = { "max_discount_limit" })
	private double maxDiscountLimit;
	
	@Expose
	@MapToData(columnAliases = { "discount" })
	private double discount;
	
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

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	public String getPackUnitName() {
		return packUnitName;
	}

	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public int getPendingPackQty() {
		return pendingPackQty;
	}

	public void setPendingPackQty(int pendingPackQty) {
		this.pendingPackQty = pendingPackQty;
	}

	

	public int getPendingRecLooseQty() {
		return pendingRecLooseQty;
	}

	public void setPendingRecLooseQty(int pendingRecLooseQty) {
		this.pendingRecLooseQty = pendingRecLooseQty;
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

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public double getTotAmount() {
		return totAmount;
	}

	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}

	public double getTaxableRate() {
		return taxableRate;
	}

	public void setTaxableRate(double taxableRate) {
		this.taxableRate = taxableRate;
	}

	public int getIsTaxOnMrp() {
		return isTaxOnMrp;
	}

	public void setIsTaxOnMrp(int isTaxOnMrp) {
		this.isTaxOnMrp = isTaxOnMrp;
	}

	public double getPurchaseNetAmount() {
		return purchaseNetAmount;
	}

	public void setPurchaseNetAmount(double purchaseNetAmount) {
		this.purchaseNetAmount = purchaseNetAmount;
	}

	public int getDistributorId() {
		return distributorId;
	}

	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public int getOrderPackQty() {
		return orderPackQty;
	}

	public void setOrderPackQty(int orderPackQty) {
		this.orderPackQty = orderPackQty;
	}

	public int getOrderLooseQty() {
		return orderLooseQty;
	}

	public void setOrderLooseQty(int orderLooseQty) {
		this.orderLooseQty = orderLooseQty;
	}

	public double getItemTotalMrp() {
		return itemTotalMrp;
	}

	public void setItemTotalMrp(double itemTotalMrp) {
		this.itemTotalMrp = itemTotalMrp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
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

	public int getPackUnitId() {
		return packUnitId;
	}

	public void setPackUnitId(int packUnitId) {
		this.packUnitId = packUnitId;
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

	public double getLooseQty() {
		return looseQty;
	}

	public void setLooseQty(double looseQty) {
		this.looseQty = looseQty;
	}

	public double getFreeQty() {
		return freeQty;
	}

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

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
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

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public int getTmpId() {
		return tmpId;
	}

	public void setTmpId(int tmpId) {
		this.tmpId = tmpId;
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

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
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

	public int getTaxTypeId() {
		return taxTypeId;
	}

	public void setTaxTypeId(int taxTypeId) {
		this.taxTypeId = taxTypeId;
	}

	public String getQryCondition() {
		return qryCondition;
	}

	public void setQryCondition(String qryCondition) {
		this.qryCondition = qryCondition;
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

	public int getRetailTypeId() {
		return retailTypeId;
	}

	public void setRetailTypeId(int retailTypeId) {
		this.retailTypeId = retailTypeId;
	}

	public int getTmpMappingId() {
		return tmpMappingId;
	}

	public void setTmpMappingId(int tmpMappingId) {
		this.tmpMappingId = tmpMappingId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}


	public List<SaleDetailsSerialMapper> getSaleDetailsSerialMapper() {
		return saleDetailsSerialMapper;
	}

	public void setSaleDetailsSerialMapper(List<SaleDetailsSerialMapper> saleDetailsSerialMapper) {
		this.saleDetailsSerialMapper = saleDetailsSerialMapper;
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

	public int getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	public int getItemFreeAgainstItem() {
		return itemFreeAgainstItem;
	}

	public void setItemFreeAgainstItem(int itemFreeAgainstItem) {
		this.itemFreeAgainstItem = itemFreeAgainstItem;
	}

	public double getAdvAmount() {
		return advAmount;
	}

	public void setAdvAmount(double advAmount) {
		this.advAmount = advAmount;
	}

	public double getPurchaseCostPerUnit() {
		return purchaseCostPerUnit;
	}

	public void setPurchaseCostPerUnit(double purchaseCostPerUnit) {
		this.purchaseCostPerUnit = purchaseCostPerUnit;
	}

	public double getPurchaseRate() {
		return purchaseRate;
	}

	public void setPurchaseRate(double purchaseRate) {
		this.purchaseRate = purchaseRate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	

	public double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public String getItemRemarks() {
		return itemRemarks;
	}

	public void setItemRemarks(String itemRemarks) {
		this.itemRemarks = itemRemarks;
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

	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "SaleOrderDetailsDTO [itemId=" + itemId + ", itemName=" + itemName + ", packUnitId=" + packUnitId
				+ ", packQty=" + packQty + ", conversion=" + conversion + ", looseQty=" + looseQty + ", freeQty="
				+ freeQty + ", soldPackQty=" + soldPackQty + ", soldLooseQty=" + soldLooseQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", saleRate=" + saleRate + ", grossAmount=" + grossAmount + ", discPer=" + discPer
				+ ", disc=" + disc + ", netAmount=" + netAmount + ", tmpId=" + tmpId + ", groupId=" + groupId
				+ ", groupName=" + groupName + ", scheduleId=" + scheduleId + ", scheduleName=" + scheduleName
				+ ", manufacturerId=" + manufacturerId + ", manufacturerName=" + manufacturerName
				+ ", manufacturerCode=" + manufacturerCode + ", taxId=" + taxId + ", taxName=" + taxName
				+ ", taxPercentage=" + taxPercentage + ", taxAmount=" + taxAmount + ", taxMode=" + taxMode
				+ ", isGroupTax=" + isGroupTax + ", sku=" + sku + ", hsnCode=" + hsnCode + ", invType=" + invType
				+ ", id=" + id + ", saleOrderId=" + saleOrderId + ", itemTotalMrp=" + itemTotalMrp + ", distributorId="
				+ distributorId + ", distributorName=" + distributorName + ", orderPackQty=" + orderPackQty
				+ ", orderLooseQty=" + orderLooseQty + ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", itemUniqueKey=" + itemUniqueKey + ", packUnitName="
				+ packUnitName + ", pendingPackQty=" + pendingPackQty + ", pendingRecLooseQty=" + pendingRecLooseQty
				+ ", amount=" + amount + ", edPer=" + edPer + ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax
				+ ", vatPer=" + vatPer + ", vat=" + vat + ", itemLotAdjAmount=" + itemLotAdjAmount + ", totAmount="
				+ totAmount + ", taxableRate=" + taxableRate + ", isTaxOnMrp=" + isTaxOnMrp + ", purchaseNetAmount="
				+ purchaseNetAmount + ", taxTypeId=" + taxTypeId + ", qryCondition=" + qryCondition + ", stockRequired="
				+ stockRequired + ", batchWiseStock=" + batchWiseStock + ", expiryDateRequired=" + expiryDateRequired
				+ ", expiryMonthRequired=" + expiryMonthRequired + ", dualStockRequired=" + dualStockRequired
				+ ", locationRequired=" + locationRequired + ", priceListRequired=" + priceListRequired
				+ ", sizeWiseStockRequired=" + sizeWiseStockRequired + ", colourWiseStockRequired="
				+ colourWiseStockRequired + ", warrantyRequired=" + warrantyRequired + ", warrantyMonth="
				+ warrantyMonth + ", mrpRequired=" + mrpRequired + ", serialNoRequired=" + serialNoRequired
				+ ", serialNoSuffRequired=" + serialNoSuffRequired + ", serialNoPrefRequired=" + serialNoPrefRequired
				+ ", rateOn=" + rateOn + ", serialNoType=" + serialNoType + ", retailTypeId=" + retailTypeId
				+ ", tmpMappingId=" + tmpMappingId + ", locationId=" + locationId + ", saleDetailsSerialMapper="
				+ saleDetailsSerialMapper + ", size=" + size + ", sizeType=" + sizeType + ", colour=" + colour
				+ ", expiryMonth=" + expiryMonth + ", itemCode=" + itemCode + ", mfdDate=" + mfdDate
				+ ", itemFreeAgainstItem=" + itemFreeAgainstItem + ", advAmount=" + advAmount + ", purchaseCostPerUnit="
				+ purchaseCostPerUnit + ", purchaseRate=" + purchaseRate + ", remarks=" + remarks + ", taxableAmount="
				+ taxableAmount + ", itemRemarks=" + itemRemarks + ", cgst=" + cgst + ", cgstPercentage="
				+ cgstPercentage + ", sgst=" + sgst + ", sgstPercentage=" + sgstPercentage + ", igst=" + igst
				+ ", igstPercentage=" + igstPercentage + ", isDiscount=" + isDiscount + ", maxDiscountLimit="
				+ maxDiscountLimit + ", discount=" + discount + "]";
	}

	
	
	

	

}