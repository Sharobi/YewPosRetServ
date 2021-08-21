package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * @author mubarak:
 *
 */
@XmlRootElement
public class PurchaseChallanReturnDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "purchase_id" })
	private int purchaseId;
	
	@Expose
	@MapToData(columnAliases = { "inv_mode_name" })
	private String invModeName;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distributorName;
	
	@Expose
	@MapToData(columnAliases = { "distributor_name" })
	private String distName;
	
	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;
	
	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;
	
	@Expose
	@MapToData(columnAliases = { "po_order_id" })
	private int poOrderId;
	
	@Expose
	@MapToData(columnAliases = { "purchase_inv_id" })
	private int purchaseInvId;
	
	@Expose
	@MapToData(columnAliases = { "purchase_return_id" })
	private int purchaseReturnId;
	
	@Expose
	@MapToData(columnAliases = { "bill_no" })
	private String billNo;
	
	@Expose
	@MapToData(columnAliases = { "bill_date" })
	private Date billDate;
	
	@Expose
	@MapToData(columnAliases = { "inv_mode" })
	private int invMode;
	
	@Expose
	@MapToData(columnAliases = { "distributor_id" })
	private int distributorId;
	
	@Expose
	@MapToData(columnAliases = { "distributor_disc_per" })
	private double distributor_disc_per;
	
	@Expose
	@MapToData(columnAliases = { "due_date" })
	private Date dueDate;
	
	@Expose
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;
	
	@Expose
	@MapToData(columnAliases = { "ed_amount" })
	private double edAmount;
	
	@Expose
	@MapToData(columnAliases = { "disc_amount" })
	private double discAmount;
	
	@Expose
	@MapToData(columnAliases = { "cst" })
	private double cst;
	
	@Expose
	@MapToData(columnAliases = { "vat_diff" })
	private double vatDiff;
	
	@Expose
	@MapToData(columnAliases = { "vat_amount" })
	private double vatAmount;
	
	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;
	
	@Expose
	@MapToData(columnAliases = { "lot_adj_amount" })
	private double lotAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "spec_disc_per" })
	private double specDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "spec_disc_amount" })
	private double specDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundoff;
	
	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp" })
	private double totalMrp;
	
	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;
	
	@Expose
	@MapToData(columnAliases = { "adv_amount" })
	private double advAmount;
	
	@Expose
	@MapToData(columnAliases = { "distributor_bill_amount" })
	private double distributorBillAmount;
	
	@Expose
	@MapToData(columnAliases = { "other_adj_amount" })
	private double other_adj_amount;
	
	@Expose
	@MapToData(columnAliases = { "expiry_adj_amount" })
	private double expiryAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "is_deleted" })
	private int isDeleted;
	
	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;
	
	@Expose
	@MapToData(columnAliases = { "is_from_inv" })
	private int isFromInv;
	
	@Expose
	@MapToData(columnAliases = { "is_inv_made" })
	private int isInvMade;
	
	
	
	//new variables
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;
	
	@Expose
	@MapToData(columnAliases = { "pst_id" })
	private int pstId;
	
	@Expose
	@MapToData(columnAliases = { "pst_no" })
	private String pstNo;
	
	@Expose
	@MapToData(columnAliases = { "payment_id" })
	private int paymentId;
	
	@Expose
	@MapToData(columnAliases = { "is_direct" })
	private int isDirect;
	
	@Expose
	@MapToData(columnAliases = { "pur_challan_no" })
	private String purChallanNo;
	
	
	
	

	public PurchaseChallanReturnDTO() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(advAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((billDate == null) ? 0 : billDate.hashCode());
		result = prime * result + ((billNo == null) ? 0 : billNo.hashCode());
		temp = Double.doubleToLongBits(cst);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(distributorBillAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + distributorId;
		result = prime * result + ((distributorName == null) ? 0 : distributorName.hashCode());
		temp = Double.doubleToLongBits(distributor_disc_per);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		temp = Double.doubleToLongBits(edAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(expiryAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + invMode;
		result = prime * result + ((invModeName == null) ? 0 : invModeName.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + isDeleted;
		result = prime * result + isDirect;
		result = prime * result + isFromInv;
		result = prime * result + isInvMade;
		result = prime * result + isPosted;
		temp = Double.doubleToLongBits(lotAdjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(other_adj_amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + paymentId;
		result = prime * result + poOrderId;
		result = prime * result + pstId;
		result = prime * result + ((pstNo == null) ? 0 : pstNo.hashCode());
		result = prime * result + purchaseId;
		result = prime * result + purchaseInvId;
		result = prime * result + purchaseReturnId;
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(specDiscAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(specDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalMrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vatDiff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		PurchaseChallanReturnDTO other = (PurchaseChallanReturnDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double.doubleToLongBits(other.adjAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(advAmount) != Double.doubleToLongBits(other.advAmount)) {
			return false;
		}
		if (billDate == null) {
			if (other.billDate != null) {
				return false;
			}
		} else if (!billDate.equals(other.billDate)) {
			return false;
		}
		if (billNo == null) {
			if (other.billNo != null) {
				return false;
			}
		} else if (!billNo.equals(other.billNo)) {
			return false;
		}
		if (Double.doubleToLongBits(cst) != Double.doubleToLongBits(other.cst)) {
			return false;
		}
		if (Double.doubleToLongBits(discAmount) != Double.doubleToLongBits(other.discAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(distributorBillAmount) != Double.doubleToLongBits(other.distributorBillAmount)) {
			return false;
		}
		if (distributorId != other.distributorId) {
			return false;
		}
		if (distributorName == null) {
			if (other.distributorName != null) {
				return false;
			}
		} else if (!distributorName.equals(other.distributorName)) {
			return false;
		}
		if (Double.doubleToLongBits(distributor_disc_per) != Double.doubleToLongBits(other.distributor_disc_per)) {
			return false;
		}
		if (dueDate == null) {
			if (other.dueDate != null) {
				return false;
			}
		} else if (!dueDate.equals(other.dueDate)) {
			return false;
		}
		if (Double.doubleToLongBits(edAmount) != Double.doubleToLongBits(other.edAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(expiryAdjAmount) != Double.doubleToLongBits(other.expiryAdjAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(grossAmount) != Double.doubleToLongBits(other.grossAmount)) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		if (invDate == null) {
			if (other.invDate != null) {
				return false;
			}
		} else if (!invDate.equals(other.invDate)) {
			return false;
		}
		if (invMode != other.invMode) {
			return false;
		}
		if (invModeName == null) {
			if (other.invModeName != null) {
				return false;
			}
		} else if (!invModeName.equals(other.invModeName)) {
			return false;
		}
		if (invNo == null) {
			if (other.invNo != null) {
				return false;
			}
		} else if (!invNo.equals(other.invNo)) {
			return false;
		}
		if (isDeleted != other.isDeleted) {
			return false;
		}
		if (isDirect != other.isDirect) {
			return false;
		}
		if (isFromInv != other.isFromInv) {
			return false;
		}
		if (isInvMade != other.isInvMade) {
			return false;
		}
		if (isPosted != other.isPosted) {
			return false;
		}
		if (Double.doubleToLongBits(lotAdjAmount) != Double.doubleToLongBits(other.lotAdjAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(netAmount) != Double.doubleToLongBits(other.netAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(other_adj_amount) != Double.doubleToLongBits(other.other_adj_amount)) {
			return false;
		}
		if (paymentId != other.paymentId) {
			return false;
		}
		if (poOrderId != other.poOrderId) {
			return false;
		}
		if (pstId != other.pstId) {
			return false;
		}
		if (pstNo == null) {
			if (other.pstNo != null) {
				return false;
			}
		} else if (!pstNo.equals(other.pstNo)) {
			return false;
		}
		if (purchaseId != other.purchaseId) {
			return false;
		}
		if (purchaseInvId != other.purchaseInvId) {
			return false;
		}
		if (purchaseReturnId != other.purchaseReturnId) {
			return false;
		}
		if (Double.doubleToLongBits(roundoff) != Double.doubleToLongBits(other.roundoff)) {
			return false;
		}
		if (Double.doubleToLongBits(specDiscAmount) != Double.doubleToLongBits(other.specDiscAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(specDiscPer) != Double.doubleToLongBits(other.specDiscPer)) {
			return false;
		}
		if (Double.doubleToLongBits(taxAmount) != Double.doubleToLongBits(other.taxAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(totalMrp) != Double.doubleToLongBits(other.totalMrp)) {
			return false;
		}
		if (Double.doubleToLongBits(vatAmount) != Double.doubleToLongBits(other.vatAmount)) {
			return false;
		}
		if (Double.doubleToLongBits(vatDiff) != Double.doubleToLongBits(other.vatDiff)) {
			return false;
		}
		return true;
	}

	/**
	 * @return the purchaseId
	 */
	public int getPurchaseId() {
		return purchaseId;
	}

	/**
	 * @param purchaseId the purchaseId to set
	 */
	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	/**
	 * @return the invModeName
	 */
	public String getInvModeName() {
		return invModeName;
	}

	/**
	 * @param invModeName the invModeName to set
	 */
	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
	}

	/**
	 * @return the distributorName
	 */
	public String getDistributorName() {
		return distributorName;
	}

	/**
	 * @param distributorName the distributorName to set
	 */
	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	/**
	 * @return the invNo
	 */
	public String getInvNo() {
		return invNo;
	}

	/**
	 * @param invNo the invNo to set
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}

	/**
	 * @return the invDate
	 */
	public Date getInvDate() {
		return invDate;
	}

	/**
	 * @param invDate the invDate to set
	 */
	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	/**
	 * @return the poOrderId
	 */
	public int getPoOrderId() {
		return poOrderId;
	}

	/**
	 * @param poOrderId the poOrderId to set
	 */
	public void setPoOrderId(int poOrderId) {
		this.poOrderId = poOrderId;
	}

	/**
	 * @return the purchaseInvId
	 */
	public int getPurchaseInvId() {
		return purchaseInvId;
	}

	/**
	 * @param purchaseInvId the purchaseInvId to set
	 */
	public void setPurchaseInvId(int purchaseInvId) {
		this.purchaseInvId = purchaseInvId;
	}

	/**
	 * @return the purchaseReturnId
	 */
	public int getPurchaseReturnId() {
		return purchaseReturnId;
	}

	/**
	 * @param purchaseReturnId the purchaseReturnId to set
	 */
	public void setPurchaseReturnId(int purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	/**
	 * @return the billNo
	 */
	public String getBillNo() {
		return billNo;
	}

	/**
	 * @param billNo the billNo to set
	 */
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	/**
	 * @return the billDate
	 */
	public Date getBillDate() {
		return billDate;
	}

	/**
	 * @param billDate the billDate to set
	 */
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	/**
	 * @return the invMode
	 */
	public int getInvMode() {
		return invMode;
	}

	/**
	 * @param invMode the invMode to set
	 */
	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	/**
	 * @return the distributorId
	 */
	public int getDistributorId() {
		return distributorId;
	}

	/**
	 * @param distributorId the distributorId to set
	 */
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	/**
	 * @return the distributor_disc_per
	 */
	public double getDistributor_disc_per() {
		return distributor_disc_per;
	}

	/**
	 * @param distributor_disc_per the distributor_disc_per to set
	 */
	public void setDistributor_disc_per(double distributor_disc_per) {
		this.distributor_disc_per = distributor_disc_per;
	}

	/**
	 * @return the dueDate
	 */
	public Date getDueDate() {
		return dueDate;
	}

	/**
	 * @param dueDate the dueDate to set
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * @return the grossAmount
	 */
	public double getGrossAmount() {
		return grossAmount;
	}

	/**
	 * @param grossAmount the grossAmount to set
	 */
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	/**
	 * @return the edAmount
	 */
	public double getEdAmount() {
		return edAmount;
	}

	/**
	 * @param edAmount the edAmount to set
	 */
	public void setEdAmount(double edAmount) {
		this.edAmount = edAmount;
	}

	/**
	 * @return the discAmount
	 */
	public double getDiscAmount() {
		return discAmount;
	}

	/**
	 * @param discAmount the discAmount to set
	 */
	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	/**
	 * @return the cst
	 */
	public double getCst() {
		return cst;
	}

	/**
	 * @param cst the cst to set
	 */
	public void setCst(double cst) {
		this.cst = cst;
	}

	/**
	 * @return the vatDiff
	 */
	public double getVatDiff() {
		return vatDiff;
	}

	/**
	 * @param vatDiff the vatDiff to set
	 */
	public void setVatDiff(double vatDiff) {
		this.vatDiff = vatDiff;
	}

	/**
	 * @return the vatAmount
	 */
	public double getVatAmount() {
		return vatAmount;
	}

	/**
	 * @param vatAmount the vatAmount to set
	 */
	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	/**
	 * @return the taxAmount
	 */
	public double getTaxAmount() {
		return taxAmount;
	}

	/**
	 * @param taxAmount the taxAmount to set
	 */
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * @return the lotAdjAmount
	 */
	public double getLotAdjAmount() {
		return lotAdjAmount;
	}

	/**
	 * @param lotAdjAmount the lotAdjAmount to set
	 */
	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}

	/**
	 * @return the specDiscPer
	 */
	public double getSpecDiscPer() {
		return specDiscPer;
	}

	/**
	 * @param specDiscPer the specDiscPer to set
	 */
	public void setSpecDiscPer(double specDiscPer) {
		this.specDiscPer = specDiscPer;
	}

	/**
	 * @return the specDiscAmount
	 */
	public double getSpecDiscAmount() {
		return specDiscAmount;
	}

	/**
	 * @param specDiscAmount the specDiscAmount to set
	 */
	public void setSpecDiscAmount(double specDiscAmount) {
		this.specDiscAmount = specDiscAmount;
	}

	/**
	 * @return the roundoff
	 */
	public double getRoundoff() {
		return roundoff;
	}

	/**
	 * @param roundoff the roundoff to set
	 */
	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	/**
	 * @return the netAmount
	 */
	public double getNetAmount() {
		return netAmount;
	}

	/**
	 * @param netAmount the netAmount to set
	 */
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	/**
	 * @return the totalMrp
	 */
	public double getTotalMrp() {
		return totalMrp;
	}

	/**
	 * @param totalMrp the totalMrp to set
	 */
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	/**
	 * @return the adjAmount
	 */
	public double getAdjAmount() {
		return adjAmount;
	}

	/**
	 * @param adjAmount the adjAmount to set
	 */
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	/**
	 * @return the advAmount
	 */
	public double getAdvAmount() {
		return advAmount;
	}

	/**
	 * @param advAmount the advAmount to set
	 */
	public void setAdvAmount(double advAmount) {
		this.advAmount = advAmount;
	}

	/**
	 * @return the distributorBillAmount
	 */
	public double getDistributorBillAmount() {
		return distributorBillAmount;
	}

	/**
	 * @param distributorBillAmount the distributorBillAmount to set
	 */
	public void setDistributorBillAmount(double distributorBillAmount) {
		this.distributorBillAmount = distributorBillAmount;
	}

	/**
	 * @return the other_adj_amount
	 */
	public double getOther_adj_amount() {
		return other_adj_amount;
	}

	/**
	 * @param other_adj_amount the other_adj_amount to set
	 */
	public void setOther_adj_amount(double other_adj_amount) {
		this.other_adj_amount = other_adj_amount;
	}

	/**
	 * @return the expiryAdjAmount
	 */
	public double getExpiryAdjAmount() {
		return expiryAdjAmount;
	}

	/**
	 * @param expiryAdjAmount the expiryAdjAmount to set
	 */
	public void setExpiryAdjAmount(double expiryAdjAmount) {
		this.expiryAdjAmount = expiryAdjAmount;
	}

	/**
	 * @return the isDeleted
	 */
	public int getIsDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the isPosted
	 */
	public int getIsPosted() {
		return isPosted;
	}

	/**
	 * @param isPosted the isPosted to set
	 */
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	/**
	 * @return the isFromInv
	 */
	public int getIsFromInv() {
		return isFromInv;
	}

	/**
	 * @param isFromInv the isFromInv to set
	 */
	public void setIsFromInv(int isFromInv) {
		this.isFromInv = isFromInv;
	}

	/**
	 * @return the isInvMade
	 */
	public int getIsInvMade() {
		return isInvMade;
	}

	/**
	 * @param isInvMade the isInvMade to set
	 */
	public void setIsInvMade(int isInvMade) {
		this.isInvMade = isInvMade;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pstId
	 */
	public int getPstId() {
		return pstId;
	}

	/**
	 * @param pstId the pstId to set
	 */
	public void setPstId(int pstId) {
		this.pstId = pstId;
	}

	/**
	 * @return the pstNo
	 */
	public String getPstNo() {
		return pstNo;
	}

	/**
	 * @param pstNo the pstNo to set
	 */
	public void setPstNo(String pstNo) {
		this.pstNo = pstNo;
	}

	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the isDirect
	 */
	public int getIsDirect() {
		return isDirect;
	}

	/**
	 * @param isDirect the isDirect to set
	 */
	public void setIsDirect(int isDirect) {
		this.isDirect = isDirect;
	}

	public String getDistName() {
		return distName;
	}

	public void setDistName(String distName) {
		this.distName = distName;
	}
	
	

	public String getPurChallanNo() {
		return purChallanNo;
	}

	public void setPurChallanNo(String purChallanNo) {
		this.purChallanNo = purChallanNo;
	}

	@Override
	public String toString() {
		return "PurchaseChallanReturnDTO [purchaseId=" + purchaseId + ", invModeName=" + invModeName
				+ ", distributorName=" + distributorName + ", distName=" + distName + ", invNo=" + invNo + ", invDate="
				+ invDate + ", poOrderId=" + poOrderId + ", purchaseInvId=" + purchaseInvId + ", purchaseReturnId="
				+ purchaseReturnId + ", billNo=" + billNo + ", billDate=" + billDate + ", invMode=" + invMode
				+ ", distributorId=" + distributorId + ", distributor_disc_per=" + distributor_disc_per + ", dueDate="
				+ dueDate + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount + ", discAmount=" + discAmount
				+ ", cst=" + cst + ", vatDiff=" + vatDiff + ", vatAmount=" + vatAmount + ", taxAmount=" + taxAmount
				+ ", lotAdjAmount=" + lotAdjAmount + ", specDiscPer=" + specDiscPer + ", specDiscAmount="
				+ specDiscAmount + ", roundoff=" + roundoff + ", netAmount=" + netAmount + ", totalMrp=" + totalMrp
				+ ", adjAmount=" + adjAmount + ", advAmount=" + advAmount + ", distributorBillAmount="
				+ distributorBillAmount + ", other_adj_amount=" + other_adj_amount + ", expiryAdjAmount="
				+ expiryAdjAmount + ", isDeleted=" + isDeleted + ", isPosted=" + isPosted + ", isFromInv=" + isFromInv
				+ ", isInvMade=" + isInvMade + ", id=" + id + ", pstId=" + pstId + ", pstNo=" + pstNo + ", paymentId="
				+ paymentId + ", isDirect=" + isDirect + ", purChallanNo=" + purChallanNo + "]";
	}

	


}
