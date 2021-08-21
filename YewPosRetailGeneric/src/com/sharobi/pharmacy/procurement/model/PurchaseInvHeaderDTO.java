package com.sharobi.pharmacy.procurement.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * @author mubarak:
 *
 */
@XmlRootElement
public class PurchaseInvHeaderDTO implements Serializable{
		
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
		@MapToData(columnAliases = { "remarks" })
		private String remarks;
		
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
		private String purchaseOrderInvNo;
		
		//new required fields
		@Expose
		@MapToData(columnAliases = { "purchase_order_id" })
		private int purchaseOrderId;

		@Expose
		@MapToData(columnAliases = { "inv_type" })
		private String invType;

		@Expose
		@MapToData(columnAliases = { "distributor_disc_per" })
		private double distributorDiscPer;

		@Expose
		@MapToData(columnAliases = { "status" })
		private int status;
		
		@Expose
		@MapToData(columnAliases = { "purchase_id_list" })
		private String purchaseIDList;
		
		public PurchaseInvHeaderDTO() {
			// TODO Auto-generated constructor stub
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
		public void setExpiryAdjAmount(double expiryAdjAmount) {
			this.expiryAdjAmount = expiryAdjAmount;
		}

		/**
		 * @return the remarks
		 */
		public String getRemarks() {
			return remarks;
		}

		/**
		 * @param remarks the remarks to set
		 */
		@XmlElement
		public void setRemarks(String remarks) {
			this.remarks = remarks;
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
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
		@XmlElement
		public void setIsDirect(int isDirect) {
			this.isDirect = isDirect;
		}

		public String getPurchaseOrderInvNo() {
			return purchaseOrderInvNo;
		}

		@XmlElement
		public void setPurchaseOrderInvNo(String purchaseOrderInvNo) {
			this.purchaseOrderInvNo = purchaseOrderInvNo;
		}

		public int getPurchaseOrderId() {
			return purchaseOrderId;
		}

		@XmlElement
		public void setPurchaseOrderId(int purchaseOrderId) {
			this.purchaseOrderId = purchaseOrderId;
		}

		public String getInvType() {
			return invType;
		}

		@XmlElement
		public void setInvType(String invType) {
			this.invType = invType;
		}

		public double getDistributorDiscPer() {
			return distributorDiscPer;
		}

		@XmlElement
		public void setDistributorDiscPer(double distributorDiscPer) {
			this.distributorDiscPer = distributorDiscPer;
		}

		public int getStatus() {
			return status;
		}

		@XmlElement
		public void setStatus(int status) {
			this.status = status;
		}

		public String getPurchaseIDList() {
			return purchaseIDList;
		}

		@XmlElement
		public void setPurchaseIDList(String purchaseIDList) {
			this.purchaseIDList = purchaseIDList;
		}

		@Override
		public String toString() {
			return "PurchaseInvHeaderDTO [purchaseId=" + purchaseId + ", invModeName=" + invModeName
					+ ", distributorName=" + distributorName + ", invNo=" + invNo + ", invDate=" + invDate
					+ ", poOrderId=" + poOrderId + ", purchaseInvId=" + purchaseInvId + ", purchaseReturnId="
					+ purchaseReturnId + ", billNo=" + billNo + ", billDate=" + billDate + ", invMode=" + invMode
					+ ", distributorId=" + distributorId + ", distributor_disc_per=" + distributor_disc_per
					+ ", dueDate=" + dueDate + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount
					+ ", discAmount=" + discAmount + ", cst=" + cst + ", vatDiff=" + vatDiff + ", vatAmount="
					+ vatAmount + ", taxAmount=" + taxAmount + ", lotAdjAmount=" + lotAdjAmount + ", specDiscPer="
					+ specDiscPer + ", specDiscAmount=" + specDiscAmount + ", roundoff=" + roundoff + ", netAmount="
					+ netAmount + ", totalMrp=" + totalMrp + ", adjAmount=" + adjAmount + ", advAmount=" + advAmount
					+ ", distributorBillAmount=" + distributorBillAmount + ", other_adj_amount=" + other_adj_amount
					+ ", expiryAdjAmount=" + expiryAdjAmount + ", remarks=" + remarks + ", isDeleted=" + isDeleted
					+ ", isPosted=" + isPosted + ", isFromInv=" + isFromInv + ", isInvMade=" + isInvMade + ", id=" + id
					+ ", pstId=" + pstId + ", pstNo=" + pstNo + ", paymentId=" + paymentId + ", isDirect=" + isDirect
					+ ", purchaseOrderInvNo=" + purchaseOrderInvNo + ", purchaseOrderId=" + purchaseOrderId
					+ ", invType=" + invType + ", distributorDiscPer=" + distributorDiscPer + ", status=" + status
					+ ", purchaseIDList=" + purchaseIDList + "]";
		}

	}
