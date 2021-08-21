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
import com.sharobi.pharmacy.accounts.model.PurchaseReturnLedger;
import com.sharobi.pharmacy.inventory.model.ExpiryPurchaseMapping;

@XmlRootElement
@Entity
@Table(name = "pur_t_purchase_inv")
public class PurchaseInv implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "inv_no")
	private String invNo;
	
	@Expose
	@Column(name = "inv_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date invDate;
	
	@Expose
	@Column(name = "po_order_id")
	private int poOrderId;

	@Expose
	@Column(name = "purchase_return_id")
	private int purchaseReturnId;
	
	@Expose
	@Column(name = "is_direct")
	private int isDirect;

	@Expose
	@Column(name = "bill_no")
	private String billNo;
	
	@Expose
	@Column(name = "bill_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date billDate;
	
	@Expose
	@Column(name = "inv_mode")
	private int invMode;
	
	@Expose
	@Column(name = "distributor_id")
	private int distributorId;
	
	@Expose
	@Column(name = "distributor-disc_per")
	private double distributorDiscPer;
	
	@Expose
	@Column(name = "due_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	
	@Expose
	@Column(name = "gross_amount")
	private Double grossAmount;
	
	@Expose
	@Column(name = "ed_amount")
	private double edAmount;
	
	@Expose
	@Column(name = "disc_amount")
	private double discAmount;
	
	@Expose
	@Column(name = "cst")
	private double cst;
	
	@Expose
	@Column(name = "vat_diff")
	private double vatDiff;
	
	@Expose
	@Column(name = "vat_amount")
	private double vatAmount;
	
	@Expose
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Expose
	@Column(name = "lot_adj_amount")
	private double lotAdjAmount;
	
	@Expose
	@Column(name = "spec_disc_per")
	private double specDiscPer;
	
	@Expose
	@Column(name = "spec_disc_amount")
	private double specDiscAmount;
	
	@Expose
	@Column(name = "roundoff")
	private double roundoff;
	
	@Expose
	@Column(name = "net_amount")
	private double netAmount;

	@Expose
	@Column(name = "total_mrp")
	private double totalMrp;
	
	@Expose
	@Column(name = "adj_amount")
	private double adjAmount;
	
	@Expose
	@Column(name = "adv_amount")
	private double advAmount;
	
	@Expose
	@Column(name = "distributor_bill_amount")
	private double distributorBillAmount;
	
	@Expose
	@Column(name = "other_adj_amount")
	private double otherAdjAmount;
	
	@Expose
	@Column(name = "expiry_adj_amount")
	private double expiryAdjAmount;
	
	@Expose
	@Column(name = "remarks")
	private String remarks;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;
	
	@Expose
	@Column(name = "is_posted")
	private int isPosted;
	
	@Expose
	@Column(name = "pst_id")
	private int pstId;
	
	@Expose
	@Column(name = "pst_no")
	private String pstNo;
	
	@Expose
	@Column(name = "payment_id")
	private int paymentId;
	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "store_id")
	private int storeId;
	
	@Expose
	@Column(name = "created_by")
	private int createdBy;
	
	@Expose
	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Expose
	@Column(name = "updated_by")
	private int updatedBy;
	
	@Expose
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;
	
	@Expose
	@Transient
	private String lang;

	@Expose
	@Transient
	private String qryCondition;

	@Expose
	@Transient
	private String invModeName;

	@Expose
	@Transient
	private String distName;

	@Expose
	@Transient
	private List<PurchaseInvDetails> purchaseDetails;
	
	@Expose
	@Transient
	private String finyrCode;

	@Expose
	@Transient
	private double distDiscPer;
	
	@Expose
	@Transient
	private List<PurchaseReturn> purchaseReturns;
	
	@Expose
	@Transient
	private List<ExpiryPurchaseMapping> expiryReturns;
	
	@Expose
	@Transient
	private String purchaseOrderInvNo;
	
	@Expose
	@Transient
	private List<String> itemNotFndList;
	
	@Expose
	@Transient
	private List<PurchaseInvDetailsSerialMapping> purchaseSerialMapper;
	
	@Expose
	@Transient
	private List<PurchaseReturnLedger> prls;
	
	@Expose
	@Transient
	private int duties_ledger_id;
	@Expose
	@Transient
	private int round_ledger_id;
	@Expose
	@Transient
	private int purchase_ledger_id;
	@Expose
	@Transient
	private int discount_ledger_id;
	@Expose
	@Transient
	private int credior_ledger_id;
	@Expose
	@Transient
	private int lotadjas_ledger_id;
	@Expose
	@Transient
	private String qs;
	
	//04.04.2018
	@Expose
	@Transient
	private int is_account ;
	
	@Expose
	@Transient
	private double creditor_amt;
	
	@Expose
	@Transient
	private String purchaseIDList;
	
	/*@Expose
	@Column(name = "is_from_inv")
	private int isFromInv;
	
	@Expose
	@Column(name = "purchase_inv_id")
	private int purchaseInvId;
	
	@Expose
	@Column(name = "is_inv_made")
	private int isInvMade;*/
	
	public PurchaseInv() { }

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
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

	public int getPoOrderId() {
		return poOrderId;
	}

	@XmlElement
	public void setPoOrderId(int poOrderId) {
		this.poOrderId = poOrderId;
	}

	public int getPurchaseReturnId() {
		return purchaseReturnId;
	}

	@XmlElement
	public void setPurchaseReturnId(int purchaseReturnId) {
		this.purchaseReturnId = purchaseReturnId;
	}

	public int getIsDirect() {
		return isDirect;
	}

	@XmlElement
	public void setIsDirect(int isDirect) {
		this.isDirect = isDirect;
	}

	public String getBillNo() {
		return billNo;
	}

	@XmlElement
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public Date getBillDate() {
		return billDate;
	}

	@XmlElement
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public int getInvMode() {
		return invMode;
	}

	@XmlElement
	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	public int getDistributorId() {
		return distributorId;
	}

	@XmlElement
	public void setDistributorId(int distributorId) {
		this.distributorId = distributorId;
	}

	public double getDistributorDiscPer() {
		return distributorDiscPer;
	}

	@XmlElement
	public void setDistributorDiscPer(double distributorDiscPer) {
		this.distributorDiscPer = distributorDiscPer;
	}

	public Date getDueDate() {
		return dueDate;
	}

	@XmlElement
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public double getEdAmount() {
		return edAmount;
	}

	@XmlElement
	public void setEdAmount(double edAmount) {
		this.edAmount = edAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	@XmlElement
	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getCst() {
		return cst;
	}

	@XmlElement
	public void setCst(double cst) {
		this.cst = cst;
	}

	public double getVatDiff() {
		return vatDiff;
	}

	@XmlElement
	public void setVatDiff(double vatDiff) {
		this.vatDiff = vatDiff;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	@XmlElement
	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	@XmlElement
	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getLotAdjAmount() {
		return lotAdjAmount;
	}

	@XmlElement
	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}

	public double getSpecDiscPer() {
		return specDiscPer;
	}

	@XmlElement
	public void setSpecDiscPer(double specDiscPer) {
		this.specDiscPer = specDiscPer;
	}

	public double getSpecDiscAmount() {
		return specDiscAmount;
	}

	@XmlElement
	public void setSpecDiscAmount(double specDiscAmount) {
		this.specDiscAmount = specDiscAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	@XmlElement
	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getNetAmount() {
		return netAmount;
	}

	@XmlElement
	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	@XmlElement
	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	@XmlElement
	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	public double getAdvAmount() {
		return advAmount;
	}

	@XmlElement
	public void setAdvAmount(double advAmount) {
		this.advAmount = advAmount;
	}

	public double getDistributorBillAmount() {
		return distributorBillAmount;
	}

	@XmlElement
	public void setDistributorBillAmount(double distributorBillAmount) {
		this.distributorBillAmount = distributorBillAmount;
	}

	public double getOtherAdjAmount() {
		return otherAdjAmount;
	}

	@XmlElement
	public void setOtherAdjAmount(double otherAdjAmount) {
		this.otherAdjAmount = otherAdjAmount;
	}

	public double getExpiryAdjAmount() {
		return expiryAdjAmount;
	}

	@XmlElement
	public void setExpiryAdjAmount(double expiryAdjAmount) {
		this.expiryAdjAmount = expiryAdjAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	@XmlElement
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getIsPosted() {
		return isPosted;
	}

	@XmlElement
	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getPstId() {
		return pstId;
	}

	@XmlElement
	public void setPstId(int pstId) {
		this.pstId = pstId;
	}

	public String getPstNo() {
		return pstNo;
	}

	@XmlElement
	public void setPstNo(String pstNo) {
		this.pstNo = pstNo;
	}

	public int getPaymentId() {
		return paymentId;
	}

	@XmlElement
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getFinyrId() {
		return finyrId;
	}

	@XmlElement
	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
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

	public int getCreatedBy() {
		return createdBy;
	}

	@XmlElement
	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	@XmlElement
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	@XmlElement
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	@XmlElement
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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

	public String getInvModeName() {
		return invModeName;
	}

	@XmlElement
	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
	}

	public String getDistName() {
		return distName;
	}

	@XmlElement
	public void setDistName(String distName) {
		this.distName = distName;
	}

	public List<PurchaseInvDetails> getPurchaseDetails() {
		return purchaseDetails;
	}

	public void setPurchaseDetails(List<PurchaseInvDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}

	public double getDistDiscPer() {
		return distDiscPer;
	}

	@XmlElement
	public void setDistDiscPer(double distDiscPer) {
		this.distDiscPer = distDiscPer;
	}

	public List<PurchaseReturn> getPurchaseReturns() {
		return purchaseReturns;
	}

	public void setPurchaseReturns(List<PurchaseReturn> purchaseReturns) {
		this.purchaseReturns = purchaseReturns;
	}

	public List<ExpiryPurchaseMapping> getExpiryReturns() {
		return expiryReturns;
	}

	public void setExpiryReturns(List<ExpiryPurchaseMapping> expiryReturns) {
		this.expiryReturns = expiryReturns;
	}

	public String getPurchaseOrderInvNo() {
		return purchaseOrderInvNo;
	}

	@XmlElement
	public void setPurchaseOrderInvNo(String purchaseOrderInvNo) {
		this.purchaseOrderInvNo = purchaseOrderInvNo;
	}

	public List<String> getItemNotFndList() {
		return itemNotFndList;
	}

	public void setItemNotFndList(List<String> itemNotFndList) {
		this.itemNotFndList = itemNotFndList;
	}

	public List<PurchaseInvDetailsSerialMapping> getPurchaseSerialMapper() {
		return purchaseSerialMapper;
	}

	public void setPurchaseSerialMapper(List<PurchaseInvDetailsSerialMapping> purchaseSerialMapper) {
		this.purchaseSerialMapper = purchaseSerialMapper;
	}

	public List<PurchaseReturnLedger> getPrls() {
		return prls;
	}

	public void setPrls(List<PurchaseReturnLedger> prls) {
		this.prls = prls;
	}

	public int getDuties_ledger_id() {
		return duties_ledger_id;
	}

	@XmlElement
	public void setDuties_ledger_id(int duties_ledger_id) {
		this.duties_ledger_id = duties_ledger_id;
	}

	public int getRound_ledger_id() {
		return round_ledger_id;
	}

	@XmlElement
	public void setRound_ledger_id(int round_ledger_id) {
		this.round_ledger_id = round_ledger_id;
	}

	public int getPurchase_ledger_id() {
		return purchase_ledger_id;
	}

	@XmlElement
	public void setPurchase_ledger_id(int purchase_ledger_id) {
		this.purchase_ledger_id = purchase_ledger_id;
	}

	public int getDiscount_ledger_id() {
		return discount_ledger_id;
	}

	@XmlElement
	public void setDiscount_ledger_id(int discount_ledger_id) {
		this.discount_ledger_id = discount_ledger_id;
	}

	public int getCredior_ledger_id() {
		return credior_ledger_id;
	}

	@XmlElement
	public void setCredior_ledger_id(int credior_ledger_id) {
		this.credior_ledger_id = credior_ledger_id;
	}

	public int getLotadjas_ledger_id() {
		return lotadjas_ledger_id;
	}

	@XmlElement
	public void setLotadjas_ledger_id(int lotadjas_ledger_id) {
		this.lotadjas_ledger_id = lotadjas_ledger_id;
	}

	public String getQs() {
		return qs;
	}

	@XmlElement
	public void setQs(String qs) {
		this.qs = qs;
	}

	public int getIs_account() {
		return is_account;
	}

	@XmlElement
	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}

	public String getFinyrCode() {
		return finyrCode;
	}

	@XmlElement
	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public double getCreditor_amt() {
		return creditor_amt;
	}

	@XmlElement
	public void setCreditor_amt(double creditor_amt) {
		this.creditor_amt = creditor_amt;
	}

	public String getPurchaseIDList() {
		return purchaseIDList;
	}

	@XmlElement
	public void setPurchaseIDList(String purchaseIDList) {
		this.purchaseIDList = purchaseIDList;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	@XmlElement
	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	@Override
	public String toString() {
		return "PurchaseInv [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", poOrderId=" + poOrderId
				+ ", purchaseReturnId=" + purchaseReturnId + ", isDirect=" + isDirect + ", billNo=" + billNo
				+ ", billDate=" + billDate + ", invMode=" + invMode + ", distributorId=" + distributorId
				+ ", distributorDiscPer=" + distributorDiscPer + ", dueDate=" + dueDate + ", grossAmount=" + grossAmount
				+ ", edAmount=" + edAmount + ", discAmount=" + discAmount + ", cst=" + cst + ", vatDiff=" + vatDiff
				+ ", vatAmount=" + vatAmount + ", taxAmount=" + taxAmount + ", lotAdjAmount=" + lotAdjAmount
				+ ", specDiscPer=" + specDiscPer + ", specDiscAmount=" + specDiscAmount + ", roundoff=" + roundoff
				+ ", netAmount=" + netAmount + ", totalMrp=" + totalMrp + ", adjAmount=" + adjAmount + ", advAmount="
				+ advAmount + ", distributorBillAmount=" + distributorBillAmount + ", otherAdjAmount=" + otherAdjAmount
				+ ", expiryAdjAmount=" + expiryAdjAmount + ", remarks=" + remarks + ", isDeleted=" + isDeleted
				+ ", isPosted=" + isPosted + ", pstId=" + pstId + ", pstNo=" + pstNo + ", paymentId=" + paymentId
				+ ", finyrId=" + finyrId + ", companyId=" + companyId + ", storeId=" + storeId + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate="
				+ updatedDate + ", lang=" + lang + ", qryCondition=" + qryCondition + ", invModeName=" + invModeName
				+ ", distName=" + distName + ", purchaseDetails=" + purchaseDetails + ", finyrCode=" + finyrCode
				+ ", distDiscPer=" + distDiscPer + ", purchaseReturns=" + purchaseReturns + ", expiryReturns="
				+ expiryReturns + ", purchaseOrderInvNo=" + purchaseOrderInvNo + ", itemNotFndList=" + itemNotFndList
				+ ", purchaseSerialMapper=" + purchaseSerialMapper + ", prls=" + prls + ", duties_ledger_id="
				+ duties_ledger_id + ", round_ledger_id=" + round_ledger_id + ", purchase_ledger_id="
				+ purchase_ledger_id + ", discount_ledger_id=" + discount_ledger_id + ", credior_ledger_id="
				+ credior_ledger_id + ", lotadjas_ledger_id=" + lotadjas_ledger_id + ", qs=" + qs + ", is_account="
				+ is_account + ", creditor_amt=" + creditor_amt + ", purchaseIDList=" + purchaseIDList + "]";
	}

}
