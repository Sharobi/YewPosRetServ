/**
 * 
 */
package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * @author Habib
 *
 */
@XmlRootElement
public class StockTransferDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Expose
	@MapToData(columnAliases = { "trans_id" })
	private int transId;

	@Expose
	@MapToData(columnAliases = { "stock_transfer_no" })
	private String stockTransNo;

	@Expose
	@MapToData(columnAliases = { "stock_transfer_date" })
	private Date stockTransDate;
	
	@Expose
	@MapToData(columnAliases = { "send_gross_amount" })
	private double sendGrossAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_gross_amount" })
	private double recvdGrossAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_gross_amount" })
	private double transitGrossAmount;
	
	@Expose
	@MapToData(columnAliases = { "send_disc_amount" })
	private double sendDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_disc_amount" })
	private double recvdDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_disc_amount" })
	private double transitDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "send_tax_amount" })
	private double sendTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_tax_amount" })
	private double recvdTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_tax_amount" })
	private double transitTaxAmount;
	
	@Expose
	@MapToData(columnAliases = { "send_net_amount" })
	private double sendNetAmount;
	
	@Expose
	@MapToData(columnAliases = { "recvd_net_amount" })
	private double recvdNetAmount;
	
	@Expose
	@MapToData(columnAliases = { "transit_net_amount" })
	private double transitNetAmount;
	
	@Expose
	@MapToData(columnAliases = { "send_roundoff" })
	private double sendRoundoff;
	
	@Expose
	@MapToData(columnAliases = { "recvd_roundoff" })
	private double recvdRoundoff;
	
	@Expose
	@MapToData(columnAliases = { "transit_roundoff" })
	private double transitRoundoff;
	
	@Expose
	@MapToData(columnAliases = { "send_total_mrp" })
	private double sendTotalMrp;
	
	@Expose
	@MapToData(columnAliases = { "recvd_total_mrp" })
	private double recvdTotalMrp;
	
	@Expose
	@MapToData(columnAliases = { "transit_total_mrp" })
	private double transitTotalMrp;
	
	@Expose
	@MapToData(columnAliases = { "send_is_posted" })
	private int sendIsPosted;
	
	@Expose
	@MapToData(columnAliases = { "recvd_is_posted" })
	private int recvIsPosted;
	
	@Expose
	@MapToData(columnAliases = { "is_deleted" })
	private int isDeleted;
	
	@Expose
	@MapToData(columnAliases = { "due_date" })
	private Date dueDate;
	
	@Expose
	@MapToData(columnAliases = { "send_remarks" })
	private String sendRemarks;
	
	@Expose
	@MapToData(columnAliases = { "receive_remarks" })
	private String receiveRemarks;
	
	@Expose
	@MapToData(columnAliases = { "dispatch_status" })
	private String dispatchStatus;
	
	@Expose
	@MapToData(columnAliases = { "receive_status" })
	private String receiveStatus;
	
	@Expose
	@MapToData(columnAliases = { "received_date" })
	private Date receivedDate;
	
	@Expose
	@MapToData(columnAliases = { "received_by" })
	private int receivedBy;
	
	@Expose
	@MapToData(columnAliases = { "from_store_id" })
	private int fromStoreId;
	
	@Expose
	@MapToData(columnAliases = { "from_store_name" })
	private String fromStoreName;
	
	@Expose
	@MapToData(columnAliases = { "to_store_id" })
	private int toStoreId;
	
	@Expose
	@MapToData(columnAliases = { "to_store_name" })
	private String toStoreName;

	public int getTransId() {
		return transId;
	}

	public void setTransId(int transId) {
		this.transId = transId;
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

	public int getFromStoreId() {
		return fromStoreId;
	}

	public void setFromStoreId(int fromStoreId) {
		this.fromStoreId = fromStoreId;
	}

	public String getFromStoreName() {
		return fromStoreName;
	}

	public void setFromStoreName(String fromStoreName) {
		this.fromStoreName = fromStoreName;
	}

	public int getToStoreId() {
		return toStoreId;
	}

	public void setToStoreId(int toStoreId) {
		this.toStoreId = toStoreId;
	}

	public String getToStoreName() {
		return toStoreName;
	}

	public void setToStoreName(String toStoreName) {
		this.toStoreName = toStoreName;
	}

	@Override
	public String toString() {
		return "StockTransferDTO [transId=" + transId + ", stockTransNo=" + stockTransNo + ", stockTransDate="
				+ stockTransDate + ", sendGrossAmount=" + sendGrossAmount + ", recvdGrossAmount=" + recvdGrossAmount
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
				+ ", receivedBy=" + receivedBy + ", fromStoreId=" + fromStoreId + ", fromStoreName=" + fromStoreName
				+ ", toStoreId=" + toStoreId + ", toStoreName=" + toStoreName + "]";
	}

	
	
	

}
