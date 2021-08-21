package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class PurchaseHistoryDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
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
	private int freeQty;

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
	@MapToData(columnAliases = { "item_lot_adj_amount" })
	private double itemLotAdjAmount;

	@Expose
	@MapToData(columnAliases = { "tot_amount" })
	private double totAmount;
	
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
	@MapToData(columnAliases = { "taxable_rate" })
	private double taxableRate;
	
	@Expose
	@MapToData(columnAliases = { "tax_mode" })
	private String taxMode;
	
	@Expose
	@MapToData(columnAliases = { "is_group_tax" })
	private int isGroupTax;

	@Expose
	@MapToData(columnAliases = { "is_tax_on_mrp" })
	private int isTaxOnMrp;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName ;
	
	@Expose
	@MapToData(columnAliases = { "sale_rate" })
	private double saleRate;
	
	private static final long serialVersionUID = 1L;

	public double getSaleRate() {
		return saleRate;
	}

	public void setSaleRate(double saleRate) {
		this.saleRate = saleRate;
	}



	public String getInvNo() {
		return invNo;
	}



	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}



	public Date getInvDate() {
		return invDate;
	}



	public void setInvDate(Date invDate) {
		this.invDate = invDate;
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



	public int getFreeQty() {
		return freeQty;
	}



	public void setFreeQty(int freeQty) {
		this.freeQty = freeQty;
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



	public double getTaxableRate() {
		return taxableRate;
	}



	public void setTaxableRate(double taxableRate) {
		this.taxableRate = taxableRate;
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



	public int getIsTaxOnMrp() {
		return isTaxOnMrp;
	}



	public void setIsTaxOnMrp(int isTaxOnMrp) {
		this.isTaxOnMrp = isTaxOnMrp;
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
		result = prime * result + distributorId;
		result = prime * result
				+ ((distributorName == null) ? 0 : distributorName.hashCode());
		temp = Double.doubleToLongBits(ed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(edPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime
				* result
				+ ((expiryDateFormat == null) ? 0 : expiryDateFormat.hashCode());
		result = prime * result + freeQty;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isGroupTax;
		result = prime * result + isTaxOnMrp;
		result = prime * result + itemId;
		temp = Double.doubleToLongBits(itemLotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + looseQty;
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		//result = prime * result + packQty;
		result = prime * result + packUnitId;
		result = prime * result
				+ ((packUnitName == null) ? 0 : packUnitName.hashCode());
		temp = Double.doubleToLongBits(rate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(saleRate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		temp = Double.doubleToLongBits(taxableRate);
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
		PurchaseHistoryDTO other = (PurchaseHistoryDTO) obj;
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
		if (distributorId != other.distributorId)
			return false;
		if (distributorName == null) {
			if (other.distributorName != null)
				return false;
		} else if (!distributorName.equals(other.distributorName))
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
		if (invDate == null) {
			if (other.invDate != null)
				return false;
		} else if (!invDate.equals(other.invDate))
			return false;
		if (invNo == null) {
			if (other.invNo != null)
				return false;
		} else if (!invNo.equals(other.invNo))
			return false;
		if (isGroupTax != other.isGroupTax)
			return false;
		if (isTaxOnMrp != other.isTaxOnMrp)
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
		if (looseQty != other.looseQty)
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
		if (Double.doubleToLongBits(rate) != Double
				.doubleToLongBits(other.rate))
			return false;
		if (Double.doubleToLongBits(saleRate) != Double
				.doubleToLongBits(other.saleRate))
			return false;
		if (Double.doubleToLongBits(tax) != Double.doubleToLongBits(other.tax))
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double
				.doubleToLongBits(other.taxAmount))
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
		if (Double.doubleToLongBits(taxableRate) != Double
				.doubleToLongBits(other.taxableRate))
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
		return "PurchaseHistoryDTO [invNo=" + invNo + ", invDate=" + invDate
				+ ", itemId=" + itemId + ", itemName=" + itemName
				+ ", batchNo=" + batchNo + ", expiryDate=" + expiryDate
				+ ", expiryDateFormat=" + expiryDateFormat + ", packUnitId="
				+ packUnitId + ", packUnitName=" + packUnitName + ", packQty="
				+ packQty + ", conversion=" + conversion + ", looseQty="
				+ looseQty + ", freeQty=" + freeQty + ", mrp=" + mrp
				+ ", rate=" + rate + ", amount=" + amount + ", edPer=" + edPer
				+ ", ed=" + ed + ", taxPer=" + taxPer + ", tax=" + tax
				+ ", vatPer=" + vatPer + ", vat=" + vat + ", discPer="
				+ discPer + ", disc=" + disc + ", itemLotAdjAmount="
				+ itemLotAdjAmount + ", totAmount=" + totAmount + ", taxId="
				+ taxId + ", taxName=" + taxName + ", taxPercentage="
				+ taxPercentage + ", taxAmount=" + taxAmount + ", taxableRate="
				+ taxableRate + ", taxMode=" + taxMode + ", isGroupTax="
				+ isGroupTax + ", isTaxOnMrp=" + isTaxOnMrp
				+ ", distributorId=" + distributorId + ", distributorName="
				+ distributorName + ", saleRate=" + saleRate + "]";
	}
	
	
}