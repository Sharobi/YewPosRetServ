/**
 * 
 */
package com.sharobi.pharmacy.inventory.model;

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
import javax.xml.bind.annotation.XmlRootElement;
import com.google.gson.annotations.Expose;


/**
 * @author Habib
 *
 */
@XmlRootElement
@Entity
@Table(name = "in_st_stock_transfer")
public class StockTransfer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "stock_transfer_no")
	private String stockTransNo;

	@Expose
	@Column(name = "stock_transfer_date")
	@Temporal(TemporalType.DATE)
	private Date stockTransDate;
	
	@Expose
	@Column(name = "send_gross_amount")
	private double sendGrossAmount;
	
	@Expose
	@Column(name = "recvd_gross_amount")
	private double recvdGrossAmount;
	
	@Expose
	@Column(name = "transit_gross_amount")
	private double transitGrossAmount;
	
	@Expose
	@Column(name = "send_disc_amount")
	private double sendDiscAmount;
	
	@Expose
	@Column(name = "recvd_disc_amount")
	private double recvdDiscAmount;
	
	@Expose
	@Column(name = "transit_disc_amount")
	private double transitDiscAmount;
	
	@Expose
	@Column(name = "send_tax_amount")
	private double sendTaxAmount;
	
	@Expose
	@Column(name = "recvd_tax_amount")
	private double recvdTaxAmount;
	
	@Expose
	@Column(name = "transit_tax_amount")
	private double transitTaxAmount;
	
	@Expose
	@Column(name = "send_net_amount")
	private double sendNetAmount;
	
	@Expose
	@Column(name = "recvd_net_amount")
	private double recvdNetAmount;
	
	@Expose
	@Column(name = "transit_net_amount")
	private double transitNetAmount;
	
	@Expose
	@Column(name = "send_roundoff")
	private double sendRoundoff;
	
	@Expose
	@Column(name = "recvd_roundoff")
	private double recvdRoundoff;
	
	@Expose
	@Column(name = "transit_roundoff")
	private double transitRoundoff;
	
	@Expose
	@Column(name = "send_total_mrp")
	private double sendTotalMrp;
	
	@Expose
	@Column(name = "recvd_total_mrp")
	private double recvdTotalMrp;
	
	@Expose
	@Column(name = "transit_total_mrp")
	private double transitTotalMrp;
	
	@Expose
	@Column(name = "send_is_posted")
	private int sendIsPosted;
	
	@Expose
	@Column(name = "recvd_is_posted")
	private int recvIsPosted;
	
	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;
	
	@Expose
	@Column(name = "due_date")
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@Expose
	@Column(name = "send_remarks")
	private String sendRemarks;
	
	@Expose
	@Column(name = "receive_remarks")
	private String receiveRemarks;
	
	@Expose
	@Column(name = "dispatch_status")
	private String dispatchStatus="N";
	
	@Expose
	@Column(name = "receive_status")
	private String receiveStatus="N";
	
	@Expose
	@Column(name = "received_date")
	@Temporal(TemporalType.DATE)
	private Date receivedDate;
	
	@Expose
	@Column(name = "received_by")
	private int receivedBy;
	
	@Expose
	@Column(name = "company_id")
	private int companyId;
	
	@Expose
	@Column(name = "from_store_id")
	private int fromStoreId;
	
	@Expose
	@Column(name = "from_finyr_id")
	private int fromFinyrId;
	
	@Expose
	@Column(name = "to_store_id")
	private int toStoreId;
	
	@Expose
	@Column(name = "to_finyr_id")
	private int toFinyrId;

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
	private List<StockTransferDetails> stockTransferDetails;
	
	@Expose
	@Transient
	private String finyrCode;
	
	@Expose
	@Transient
	private String qs;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockTransNo() {
		return stockTransNo;
	}

	public void setStockTransNo(String stockTransNo) {
		this.stockTransNo = stockTransNo;
	}

	public Date getStockTransDate() {
		return stockTransDate;
	}

	public void setStockTransDate(Date stockTransDate) {
		this.stockTransDate = stockTransDate;
	}

	public double getSendGrossAmount() {
		return sendGrossAmount;
	}

	public void setSendGrossAmount(double sendGrossAmount) {
		this.sendGrossAmount = sendGrossAmount;
	}

	public double getRecvdGrossAmount() {
		return recvdGrossAmount;
	}

	public void setRecvdGrossAmount(double recvdGrossAmount) {
		this.recvdGrossAmount = recvdGrossAmount;
	}

	public double getTransitGrossAmount() {
		return transitGrossAmount;
	}

	public void setTransitGrossAmount(double transitGrossAmount) {
		this.transitGrossAmount = transitGrossAmount;
	}

	public double getSendDiscAmount() {
		return sendDiscAmount;
	}

	public void setSendDiscAmount(double sendDiscAmount) {
		this.sendDiscAmount = sendDiscAmount;
	}

	public double getRecvdDiscAmount() {
		return recvdDiscAmount;
	}

	public void setRecvdDiscAmount(double recvdDiscAmount) {
		this.recvdDiscAmount = recvdDiscAmount;
	}

	public double getTransitDiscAmount() {
		return transitDiscAmount;
	}

	public void setTransitDiscAmount(double transitDiscAmount) {
		this.transitDiscAmount = transitDiscAmount;
	}

	public double getSendTaxAmount() {
		return sendTaxAmount;
	}

	public void setSendTaxAmount(double sendTaxAmount) {
		this.sendTaxAmount = sendTaxAmount;
	}

	public double getRecvdTaxAmount() {
		return recvdTaxAmount;
	}

	public void setRecvdTaxAmount(double recvdTaxAmount) {
		this.recvdTaxAmount = recvdTaxAmount;
	}

	public double getTransitTaxAmount() {
		return transitTaxAmount;
	}

	public void setTransitTaxAmount(double transitTaxAmount) {
		this.transitTaxAmount = transitTaxAmount;
	}

	public double getSendNetAmount() {
		return sendNetAmount;
	}

	public void setSendNetAmount(double sendNetAmount) {
		this.sendNetAmount = sendNetAmount;
	}

	public double getRecvdNetAmount() {
		return recvdNetAmount;
	}

	public void setRecvdNetAmount(double recvdNetAmount) {
		this.recvdNetAmount = recvdNetAmount;
	}

	public double getTransitNetAmount() {
		return transitNetAmount;
	}

	public void setTransitNetAmount(double transitNetAmount) {
		this.transitNetAmount = transitNetAmount;
	}

	public double getSendRoundoff() {
		return sendRoundoff;
	}

	public void setSendRoundoff(double sendRoundoff) {
		this.sendRoundoff = sendRoundoff;
	}

	public double getRecvdRoundoff() {
		return recvdRoundoff;
	}

	public void setRecvdRoundoff(double recvdRoundoff) {
		this.recvdRoundoff = recvdRoundoff;
	}

	public double getTransitRoundoff() {
		return transitRoundoff;
	}

	public void setTransitRoundoff(double transitRoundoff) {
		this.transitRoundoff = transitRoundoff;
	}

	public double getSendTotalMrp() {
		return sendTotalMrp;
	}

	public void setSendTotalMrp(double sendTotalMrp) {
		this.sendTotalMrp = sendTotalMrp;
	}

	public double getRecvdTotalMrp() {
		return recvdTotalMrp;
	}

	public void setRecvdTotalMrp(double recvdTotalMrp) {
		this.recvdTotalMrp = recvdTotalMrp;
	}

	public double getTransitTotalMrp() {
		return transitTotalMrp;
	}

	public void setTransitTotalMrp(double transitTotalMrp) {
		this.transitTotalMrp = transitTotalMrp;
	}

	

	public int getSendIsPosted() {
		return sendIsPosted;
	}

	public void setSendIsPosted(int sendIsPosted) {
		this.sendIsPosted = sendIsPosted;
	}

	public int getRecvIsPosted() {
		return recvIsPosted;
	}

	public void setRecvIsPosted(int recvIsPosted) {
		this.recvIsPosted = recvIsPosted;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getSendRemarks() {
		return sendRemarks;
	}

	public void setSendRemarks(String sendRemarks) {
		this.sendRemarks = sendRemarks;
	}

	public String getReceiveRemarks() {
		return receiveRemarks;
	}

	public void setReceiveRemarks(String receiveRemarks) {
		this.receiveRemarks = receiveRemarks;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public String getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(String receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public int getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(int receivedBy) {
		this.receivedBy = receivedBy;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public int getFromStoreId() {
		return fromStoreId;
	}

	public void setFromStoreId(int fromStoreId) {
		this.fromStoreId = fromStoreId;
	}

	public int getFromFinyrId() {
		return fromFinyrId;
	}

	public void setFromFinyrId(int fromFinyrId) {
		this.fromFinyrId = fromFinyrId;
	}

	public int getToStoreId() {
		return toStoreId;
	}

	public void setToStoreId(int toStoreId) {
		this.toStoreId = toStoreId;
	}

	public int getToFinyrId() {
		return toFinyrId;
	}

	public void setToFinyrId(int toFinyrId) {
		this.toFinyrId = toFinyrId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public List<StockTransferDetails> getStockTransferDetails() {
		return stockTransferDetails;
	}

	public void setStockTransferDetails(List<StockTransferDetails> stockTransferDetails) {
		this.stockTransferDetails = stockTransferDetails;
	}

	public String getFinyrCode() {
		return finyrCode;
	}

	public void setFinyrCode(String finyrCode) {
		this.finyrCode = finyrCode;
	}

	public String getQs() {
		return qs;
	}

	public void setQs(String qs) {
		this.qs = qs;
	}

	@Override
	public String toString() {
		return "StockTransfer [id=" + id + ", stockTransNo=" + stockTransNo + ", stockTransDate=" + stockTransDate
				+ ", sendGrossAmount=" + sendGrossAmount + ", recvdGrossAmount=" + recvdGrossAmount
				+ ", transitGrossAmount=" + transitGrossAmount + ", sendDiscAmount=" + sendDiscAmount
				+ ", recvdDiscAmount=" + recvdDiscAmount + ", transitDiscAmount=" + transitDiscAmount
				+ ", sendTaxAmount=" + sendTaxAmount + ", recvdTaxAmount=" + recvdTaxAmount + ", transitTaxAmount="
				+ transitTaxAmount + ", sendNetAmount=" + sendNetAmount + ", recvdNetAmount=" + recvdNetAmount
				+ ", transitNetAmount=" + transitNetAmount + ", sendRoundoff=" + sendRoundoff + ", recvdRoundoff="
				+ recvdRoundoff + ", transitRoundoff=" + transitRoundoff + ", sendTotalMrp=" + sendTotalMrp
				+ ", recvdTotalMrp=" + recvdTotalMrp + ", transitTotalMrp=" + transitTotalMrp + ", sendIsPosted="
				+ sendIsPosted + ", recvIsPosted=" + recvIsPosted + ", isDeleted=" + isDeleted + ", dueDate=" + dueDate
				+ ", sendRemarks=" + sendRemarks + ", receiveRemarks=" + receiveRemarks + ", dispatchStatus="
				+ dispatchStatus + ", receiveStatus=" + receiveStatus + ", receivedDate=" + receivedDate
				+ ", receivedBy=" + receivedBy + ", companyId=" + companyId + ", fromStoreId=" + fromStoreId
				+ ", fromFinyrId=" + fromFinyrId + ", toStoreId=" + toStoreId + ", toFinyrId=" + toFinyrId
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedBy=" + updatedBy
				+ ", updatedDate=" + updatedDate + ", stockTransferDetails=" + stockTransferDetails + ", finyrCode="
				+ finyrCode + ", qs=" + qs + "]";
	}

	

	

	

}
