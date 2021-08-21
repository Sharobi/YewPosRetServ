package com.sharobi.pharmacy.sales.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
@Entity
@Table(name="com_card_payment_status")
public class CardPaymentStatus {
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@MapToData(columnAliases = "id")
	private int id;
	@Expose
	@Column(name = "inv_id")
	@MapToData(columnAliases = "inv_id")
	private int invId;
	@Expose
	@Column(name = "inv_date")
	@MapToData(columnAliases = "inv_date")
	private Date invDate;
	@Expose
	@Transient
	@MapToData(columnAliases = "inv_time")
	private String invTime;
	@Expose
	@Column(name = "card_no")
	@MapToData(columnAliases = "card_no")
	private String cardNo;
	@Expose
	@Column(name = "amount")
	@MapToData(columnAliases = "amount")
	private double amount;
	@Expose
	@Column(name = "trans_id")
	@MapToData(columnAliases = "trans_id")
	private String transId;
	@Expose
	@Column(name = "trans_type")
	@MapToData(columnAliases = "trans_type")
	private String transType;
	@Expose
	@Column(name = "status")
	@MapToData(columnAliases = "status")
	private int status;
	@Expose
	@Column(name = "card_expiry_date")
	@MapToData(columnAliases = "card_expiry_date")
	private String cardExpiryDate;
	@Expose
	@Column(name = "payment_id")
	@MapToData(columnAliases = "payment_id")
	private String paymentId;
	@Expose
	@Column(name = "merchant_id")
	@MapToData(columnAliases = "merchant_id")
	private String merchantId;
	@Expose
	@Column(name = "card_brand")
	@MapToData(columnAliases = "card_brand")
	private String cardBrand;
	@Expose
	@Column(name = "card_level")
	@MapToData(columnAliases = "card_level")
	private String cardLevel;
	@Expose
	@Column(name = "card_number")
	@MapToData(columnAliases = "card_number")
	private String cardNumber;
	@Expose
	@Column(name = "response_code")
	@MapToData(columnAliases = "response_code")
	private String responseCode;
	@Expose
	@Column(name = "card_type")
	@MapToData(columnAliases = "card_type")
	private String cardType;
	@Expose
	@Column(name = "tdr_percentage")
	@MapToData(columnAliases = "tdr_percentage")
	private double tdrPercentage;
	@Expose
	@Column(name = "transaction_id")
	@MapToData(columnAliases = "transaction_id")
	private String transactionId;
	@Expose
	@Column(name = "pan_length")
	@MapToData(columnAliases = "pan_length")
	private String panLength;
	@Expose
	@Column(name = "pin_verified_flag")
	@MapToData(columnAliases = "pin_verified_flag")
	private String pinVerifiedFlag;
	@Expose
	@Column(name = "icc_data")
	@MapToData(columnAliases = "icc_data")
	private String iccData;
	@Expose
	@Column(name = "rrn")
	@MapToData(columnAliases = "rrn")
	private String rrn;
	@Expose
	@Column(name = "merchant_ref_invoice_no")
	@MapToData(columnAliases = "merchant_ref_invoice_no")
	private String merchantRefInvoiceNo;
	@Expose
	@Column(name = "company_id")
	@MapToData(columnAliases = "company_id")
	private int companyId;
	@Expose
	@Column(name = "store_id")
	@MapToData(columnAliases = "store_id")
	private int storeId;
	@Expose
	@Column(name = "created_by")
	@MapToData(columnAliases = "created_by")
	private int createdBy;
	@Expose
	@Column(name = "updated_by")
	@MapToData(columnAliases = "updated_by")
	private int updatedBy;
	
	@Expose
	@Transient
	@MapToData(columnAliases = "inv_code")
	private String invCode;
	@Expose
	@Transient
	@MapToData(columnAliases = "customer_name")
	private String customerName;
	@Expose
	@Transient
	@MapToData(columnAliases = "customer_phone")
	private String customerPhone;
	
	@Expose
	@Transient
	@MapToData(columnAliases = "inv_mode")
	private String invMode;
	
	@Expose
	@Transient
	@MapToData(columnAliases = "created_date")
	private String createdDate;
	
	@Expose
	@Transient
	@MapToData(columnAliases = "void")
	private int isVoid;
	
	@Expose
	@Transient
	@MapToData(columnAliases = "is_posted")
	private String isPosted;
	
	public CardPaymentStatus() { }

	public int getInvId() {
		return invId;
	}

	public void setInvId(int invId) {
		this.invId = invId;
	}

	public Date getInvDate() {
		return invDate;
	}

	public void setInvDate(Date invDate) {
		this.invDate = invDate;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	public String getCardLevel() {
		return cardLevel;
	}

	public void setCardLevel(String cardLevel) {
		this.cardLevel = cardLevel;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getTdrPercentage() {
		return tdrPercentage;
	}

	public void setTdrPercentage(double tdrPercentage) {
		this.tdrPercentage = tdrPercentage;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPanLength() {
		return panLength;
	}

	public void setPanLength(String panLength) {
		this.panLength = panLength;
	}

	public String getPinVerifiedFlag() {
		return pinVerifiedFlag;
	}

	public void setPinVerifiedFlag(String pinVerifiedFlag) {
		this.pinVerifiedFlag = pinVerifiedFlag;
	}

	public String getIccData() {
		return iccData;
	}

	public void setIccData(String iccData) {
		this.iccData = iccData;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public String getMerchantRefInvoiceNo() {
		return merchantRefInvoiceNo;
	}

	public void setMerchantRefInvoiceNo(String merchantRefInvoiceNo) {
		this.merchantRefInvoiceNo = merchantRefInvoiceNo;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInvCode() {
		return invCode;
	}

	public void setInvCode(String invCode) {
		this.invCode = invCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getInvMode() {
		return invMode;
	}

	public void setInvMode(String invMode) {
		this.invMode = invMode;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getIsVoid() {
		return isVoid;
	}

	public void setIsVoid(int isVoid) {
		this.isVoid = isVoid;
	}

	public String getInvTime() {
		return invTime;
	}

	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}

	public String getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(String isPosted) {
		this.isPosted = isPosted;
	}

	@Override
	public String toString() {
		return "CardPaymentStatus [id=" + id + ", invId=" + invId + ", invDate=" + invDate + ", invTime=" + invTime
				+ ", cardNo=" + cardNo + ", amount=" + amount + ", transId=" + transId + ", transType=" + transType
				+ ", status=" + status + ", cardExpiryDate=" + cardExpiryDate + ", paymentId=" + paymentId
				+ ", merchantId=" + merchantId + ", cardBrand=" + cardBrand + ", cardLevel=" + cardLevel
				+ ", cardNumber=" + cardNumber + ", responseCode=" + responseCode + ", cardType=" + cardType
				+ ", tdrPercentage=" + tdrPercentage + ", transactionId=" + transactionId + ", panLength=" + panLength
				+ ", pinVerifiedFlag=" + pinVerifiedFlag + ", iccData=" + iccData + ", rrn=" + rrn
				+ ", merchantRefInvoiceNo=" + merchantRefInvoiceNo + ", companyId=" + companyId + ", storeId=" + storeId
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", invCode=" + invCode + ", customerName="
				+ customerName + ", customerPhone=" + customerPhone + ", invMode=" + invMode + ", createdDate="
				+ createdDate + ", isVoid=" + isVoid + ", isPosted=" + isPosted + "]";
	}

}
