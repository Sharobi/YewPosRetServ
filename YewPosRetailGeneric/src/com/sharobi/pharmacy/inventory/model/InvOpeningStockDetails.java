package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: inv_t_op_stock_details
 * 
 */

@XmlRootElement
@Entity
@Table(name = "inv_t_op_stock_details")
public class InvOpeningStockDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "item_id")
	private int itemId;
	
	@Expose
	@Column(name = "op_stock_id")
	private int opStockId;

	@Expose
	@Column(name = "batch_no")
	private String batchNo;

	@Expose
	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	@Expose
	@Column(name = "unique_identifier_no")
	private String uniqueIdentifierNo;

	@Expose
	@Column(name = "qty")
	private double qty;

	
	@Expose
	@Column(name = "finyr_id")
	private int finyrId;

	
	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	@XmlElement
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getOpStockId() {
		return opStockId;
	}

	@XmlElement
	public void setOpStockId(int opStockId) {
		this.opStockId = opStockId;
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
	
	public InvOpeningStockDetails() { }

	public String getUniqueIdentifierNo() {
		return uniqueIdentifierNo;
	}

	@XmlElement
	public void setUniqueIdentifierNo(String uniqueIdentifierNo) {
		this.uniqueIdentifierNo = uniqueIdentifierNo;
	}

	

	public double getQty() {
		return qty;
	}

	@XmlElement
	public void setQty(double qty) {
		this.qty = qty;
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

	@Override
	public String toString() {
		return "InvOpeningStockDetails [id=" + id + ", itemId=" + itemId + ", opStockId=" + opStockId + ", batchNo="
				+ batchNo + ", expiryDate=" + expiryDate + ", uniqueIdentifierNo=" + uniqueIdentifierNo + ", qty=" + qty
				+ ", finyrId=" + finyrId + ", storeId=" + storeId + ", companyId=" + companyId + "]";
	}

}