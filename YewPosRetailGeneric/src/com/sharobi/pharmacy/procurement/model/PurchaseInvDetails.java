package com.sharobi.pharmacy.procurement.model;

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

@XmlRootElement
@Entity
@Table(name = "purchase_inv_details")
public class PurchaseInvDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	
	public PurchaseInvDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "purchase_inv_id")
	private int purchaseInvId;
	
	@Expose
	@Column(name = "inv_no")
	private String invNo;
	
	
	@Expose
	@Column(name = "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;
	
	@Expose
	@Column(name = "retail_type_id")
	private int retailTypeId;
	
	@Expose
	@Column(name = "item_id")
	private int itemId;
	
	@Expose
	@Column(name = "batch_no")
	private String batchNo;
	
	@Expose
	@Column(name = "expiry_month")
	private int expiryMonth;
	
	@Expose
	@Column(name = "mfd_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mfdDate;
	
	@Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;
	
	@Expose
	@Column(name = "pack_unit-Id")
	private int packUnitId;
	
	@Expose
	@Column(name = "pack_qty")
	private double packQty;
	
	@Expose
	@Column(name = "conversion")
	private int conversion;
	
	@Expose
	@Column(name = "loose_qty")
	private int looseQty;
	
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
	@Column(name = "sale_rate")
	private double saleRate;
	
	@Expose
	@Column(name = "amount")
	private double amount;
	
	@Expose
	@Column(name = "ed_per")
	private double edPer;
	
	@Expose
	@Column(name = "ed")
	private double ed;
	
	@Expose
	@Column(name = "tax_per")
	private double taxPer;
	
	@Expose
	@Column(name = "tax")
	private double tax;
	
	@Expose
	@Column(name = "vat_per")
	private double vatPer;
	
	@Expose
	@Column(name = "vat")
	private double vat;
	
	@Expose
	@Column(name = "disc_per")
	private double discPer;
	
	@Expose
	@Column(name = "disc")
	private double disc;
	
	@Expose
	@Column(name = "item_lot_adj_amount")
	private double itemLotAdjAmount;
	
	@Expose
	@Column(name = "tax_id")
	private double taxId;
	
	@Expose
	@Column(name = "tax_percentage")
	private double taxPercentage;
	
	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Expose
	@Column(name = "is_groupTax")
	private double isGroupTax;
	
	@Expose
	@Column(name = "tax_mode")
	private String taxMode;
	
	@Expose
	@Column(name = "purchase_net_amount")
	private double purchaseNetAmount;
	
	@Expose
	@Column(name = "tot_amount")
	private double totAmount;
	
	@Expose
	@Column(name = "purchase_order_id")
	private double purchaseOrderId;
	
	@Expose
	@Column(name = "tmp_mapping_id")
	private int tmpMappingId;
	
	@Expose
	@Column(name = "location_id")
	private int locationId;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "store_id")
	private int storeId;
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;
	
	@Expose
	@Transient
	private List<PurchaseInvDetailsSerialMapping> purchaseDetailsSerialMapper;

	//NEW fields
	@Expose
	@Transient
	private String lang;

	@Expose
	@Transient
	private String qryCondition;

	@Expose
	@Transient
	private String packUnitName;

	@Expose
	@Transient
	private String itemName;

	@Expose
	@Transient
	private int grpId;

	@Expose
	@Transient
	private String grpName;

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
	private String expiryDateFormat;
	
	@Expose
	@Transient
	private String manuCode;
	
	@Expose
	@Transient
	private String itemUniqueKey;
	
	
	@Expose
	@Transient
	private String taxName;
	
	@Expose
	@Transient
	private double taxableRate;
	
	@Expose
	@Transient
	private int isTaxOnMrp;
	
	@Expose
	@Transient
	private String sku;
	
	@Expose
	@Transient
	private String hsnCode;
	
	@Expose
	@Transient
	private String purchaseOrderInvNo;
	
	@Expose
	@Transient
	private int stockRequired;
	
	@Expose
	@Transient
	private int batchWiseStock;
	
	@Expose
	@Transient
	private int expiryDateRequired;
	
	@Expose
	@Transient
	private int expiryMonthRequired;
	
	@Expose
	@Transient
	private int dualStockRequired;
	
	@Expose
	@Transient
	private int locationRequired;
	
	@Expose
	@Transient
	private int priceListRequired;
	
	@Expose
	@Transient
	private int sizeWiseStockRequired;
	
	@Expose
	@Transient
	private int colourWiseStockRequired;
	
	@Expose
	@Transient
	private int warrantyRequired;
	
	@Expose
	@Transient
	private int warrantyMonth;
	
	@Expose
	@Transient
	private int mrpRequired;
	
	@Expose
	@Transient
	private int serialNoRequired;
	
	@Expose
	@Transient
	private int serialNoSuffRequired;
	
	@Expose
	@Transient
	private int serialNoPrefRequired;
	
	@Expose
	@Transient
	private int rateOn;
	
	@Expose
	@Transient
	private String serialNoType;
	
	@Expose
	@Transient
	private String warrantyTypeOn;
	
	@Expose
	@Transient
	private String size;
	
	@Expose
	@Transient
	private String sizeType;
	
	@Expose
	@Transient
	private String colour;

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	
	public int getPurchaseInvId() {
		return purchaseInvId;
	}

	@XmlElement
	public void setPurchaseInvId(int purchaseInvId) {
		this.purchaseInvId = purchaseInvId;
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

	public int getRetailTypeId() {
		return retailTypeId;
	}

	@XmlElement
	public void setRetailTypeId(int retailTypeId) {
		this.retailTypeId = retailTypeId;
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

	public int getExpiryMonth() {
		return expiryMonth;
	}

	@XmlElement
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	@XmlElement
	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	@XmlElement
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
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

	public double getSaleRate() {
		return saleRate;
	}

	@XmlElement
	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
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

	public double getItemLotAdjAmount() {
		return itemLotAdjAmount;
	}

	@XmlElement
	public void setItemLotAdjAmount(double itemLotAdjAmount) {
		this.itemLotAdjAmount = itemLotAdjAmount;
	}

	public double getTaxId() {
		return taxId;
	}

	@XmlElement
	public void setTaxId(double taxId) {
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

	public double getIsGroupTax() {
		return isGroupTax;
	}

	@XmlElement
	public void setIsGroupTax(double isGroupTax) {
		this.isGroupTax = isGroupTax;
	}

	public String getTaxMode() {
		return taxMode;
	}

	@XmlElement
	public void setTaxMode(String taxMode) {
		this.taxMode = taxMode;
	}

	public double getPurchaseNetAmount() {
		return purchaseNetAmount;
	}

	@XmlElement
	public void setPurchaseNetAmount(double purchaseNetAmount) {
		this.purchaseNetAmount = purchaseNetAmount;
	}

	public double getTotAmount() {
		return totAmount;
	}

	@XmlElement
	public void setTotAmount(double totAmount) {
		this.totAmount = totAmount;
	}

	public double getPurchaseOrderId() {
		return purchaseOrderId;
	}

	@XmlElement
	public void setPurchaseOrderId(double purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public int getTmpMappingId() {
		return tmpMappingId;
	}

	@XmlElement
	public void setTmpMappingId(int tmpMappingId) {
		this.tmpMappingId = tmpMappingId;
	}

	public int getLocationId() {
		return locationId;
	}

	@XmlElement
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public int getCompanyId() {
		return companyId;
	}

	@XmlElement
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	@XmlElement
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public List<PurchaseInvDetailsSerialMapping> getPurchaseDetailsSerialMapper() {
		return purchaseDetailsSerialMapper;
	}

	public void setPurchaseDetailsSerialMapper(List<PurchaseInvDetailsSerialMapping> purchaseDetailsSerialMapper) {
		this.purchaseDetailsSerialMapper = purchaseDetailsSerialMapper;
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

	public String getPackUnitName() {
		return packUnitName;
	}

	@XmlElement
	public void setPackUnitName(String packUnitName) {
		this.packUnitName = packUnitName;
	}

	public String getItemName() {
		return itemName;
	}

	@XmlElement
	public void setItemName(String itemName) {
		this.itemName = itemName;
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

	public String getExpiryDateFormat() {
		return expiryDateFormat;
	}

	@XmlElement
	public void setExpiryDateFormat(String expiryDateFormat) {
		this.expiryDateFormat = expiryDateFormat;
	}

	public String getManuCode() {
		return manuCode;
	}

	@XmlElement
	public void setManuCode(String manuCode) {
		this.manuCode = manuCode;
	}

	public String getItemUniqueKey() {
		return itemUniqueKey;
	}

	@XmlElement
	public void setItemUniqueKey(String itemUniqueKey) {
		this.itemUniqueKey = itemUniqueKey;
	}

	public String getTaxName() {
		return taxName;
	}

	@XmlElement
	public void setTaxName(String taxName) {
		this.taxName = taxName;
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

	public String getPurchaseOrderInvNo() {
		return purchaseOrderInvNo;
	}

	@XmlElement
	public void setPurchaseOrderInvNo(String purchaseOrderInvNo) {
		this.purchaseOrderInvNo = purchaseOrderInvNo;
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

	@Override
	public String toString() {
		return "PurchaseInvDetails [id=" + id + ", purchaseInvId=" + purchaseInvId + ", invNo=" + invNo + ", invDate="
				+ invDate + ", retailTypeId=" + retailTypeId + ", itemId=" + itemId + ", batchNo=" + batchNo
				+ ", expiryMonth=" + expiryMonth + ", mfdDate=" + mfdDate + ", expiryDate=" + expiryDate
				+ ", packUnitId=" + packUnitId + ", packQty=" + packQty + ", conversion=" + conversion + ", looseQty="
				+ looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp + ", rate=" + rate + ", saleRate=" + saleRate
				+ ", amount=" + amount + ", edPer=" + edPer + ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax
				+ ", vatPer=" + vatPer + ", vat=" + vat + ", discPer=" + discPer + ", disc=" + disc
				+ ", itemLotAdjAmount=" + itemLotAdjAmount + ", taxId=" + taxId + ", taxPercentage=" + taxPercentage
				+ ", taxAmount=" + taxAmount + ", isGroupTax=" + isGroupTax + ", taxMode=" + taxMode
				+ ", purchaseNetAmount=" + purchaseNetAmount + ", totAmount=" + totAmount + ", purchaseOrderId="
				+ purchaseOrderId + ", tmpMappingId=" + tmpMappingId + ", locationId=" + locationId + ", companyId="
				+ companyId + ", storeId=" + storeId + ", finyrId=" + finyrId + ", purchaseDetailsSerialMapper="
				+ purchaseDetailsSerialMapper + ", lang=" + lang + ", qryCondition=" + qryCondition + ", packUnitName="
				+ packUnitName + ", itemName=" + itemName + ", grpId=" + grpId + ", grpName=" + grpName + ", schdId="
				+ schdId + ", schdName=" + schdName + ", manuId=" + manuId + ", manuName=" + manuName
				+ ", expiryDateFormat=" + expiryDateFormat + ", manuCode=" + manuCode + ", itemUniqueKey="
				+ itemUniqueKey + ", taxName=" + taxName + ", taxableRate=" + taxableRate + ", isTaxOnMrp=" + isTaxOnMrp
				+ ", sku=" + sku + ", hsnCode=" + hsnCode + ", purchaseOrderInvNo=" + purchaseOrderInvNo
				+ ", stockRequired=" + stockRequired + ", batchWiseStock=" + batchWiseStock + ", expiryDateRequired="
				+ expiryDateRequired + ", expiryMonthRequired=" + expiryMonthRequired + ", dualStockRequired="
				+ dualStockRequired + ", locationRequired=" + locationRequired + ", priceListRequired="
				+ priceListRequired + ", sizeWiseStockRequired=" + sizeWiseStockRequired + ", colourWiseStockRequired="
				+ colourWiseStockRequired + ", warrantyRequired=" + warrantyRequired + ", warrantyMonth="
				+ warrantyMonth + ", mrpRequired=" + mrpRequired + ", serialNoRequired=" + serialNoRequired
				+ ", serialNoSuffRequired=" + serialNoSuffRequired + ", serialNoPrefRequired=" + serialNoPrefRequired
				+ ", rateOn=" + rateOn + ", serialNoType=" + serialNoType + ", warrantyTypeOn=" + warrantyTypeOn
				+ ", size=" + size + ", sizeType=" + sizeType + ", colour=" + colour + "]";
	}


}
