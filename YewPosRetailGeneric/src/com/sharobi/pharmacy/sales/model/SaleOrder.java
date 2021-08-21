package com.sharobi.pharmacy.sales.model;

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

	/**
	 * Entity implementation class for Entity: pur_t_purchase_order
	 * 
	 */

	@XmlRootElement
	@Entity
	@Table(name = "sal_t_sale_order")
	public class SaleOrder implements Serializable {

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
		@Column(name = "due_date")
		@Temporal(TemporalType.TIMESTAMP)
		private Date dueDate;

		@Expose
		@Column(name = "inv_type")
		private String invType;

		@Expose
		@Column(name = "customer_id")
		private int customerId;
		
		@Expose
		@Column(name = "customer_name")
		private String customerName;
		@Expose
		@Column(name = "customer_address")
		private String customerAddress;
		@Expose
		@Column(name = "customer_phone")
		private String customerPhone;

		@Expose
		@Column(name = "customer_disc_per")
		private double customerDiscPer;
		
		@Expose
		@Column(name = "doctor_id")
		private int doctorId;
		
		@Expose
		@Column(name = "doctor_name")
		private String doctorName;
		

		@Expose
		@Column(name = "gross_amount")
		private double grossAmount;

		@Expose
		@Column(name = "disc_amount")
		private double discAmount;

		@Expose
		@Column(name = "adj_amount")
		private double adjAmount;
		
		@Expose
		@Column(name = "adv_amount")
		private double advAmount;

		@Expose
		@Column(name = "tax_amount")
		private double taxAmount;

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
		@Column(name = "remarks")
		private String remarks;

		@Expose
		@Column(name = "is_canceled")
		private int isCanceled;

		@Expose
		@Column(name = "is_deleted")
		private int isDeleted;

		@Expose
		@Column(name = "status")
		private int status;

		@Expose
		@Column(name = "finyr_id")
		private int finyrId;

		@Expose
		@Column(name = "store_id")
		private int storeId;

		@Expose
		@Column(name = "company_id")
		private int companyId;

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
		private String finyrCode;

		@Expose
		@Transient
		private List<SaleOrderDetails> saleOrderDetails;
		
		@Expose
		@Column(name = "is_posted")
		private int isPosted;
		
		@Expose
		@Column(name = "r_dv_sph")
		private double rDvSph;
		
		@Expose
		@Column(name = "r_dv_cyl")
		private double rDvCyl;
		
		@Expose
		@Column(name = "r_dv_axis")
		private double rDvAxis;
		
		@Expose
		@Column(name = "l_dv_sph")
		private double lDvSph;
		
		@Expose
		@Column(name = "l_dv_cyl")
		private double lDvCyl;
		
		@Expose
		@Column(name = "l_dv_axis")
		private double lDvAxis;
		
		@Expose
		@Column(name = "r_nv_sph")
		private double rNvSph;
		
		@Expose
		@Column(name = "r_nv_cyl")
		private double rNvCyl;
		
		@Expose
		@Column(name = "r_nv_axis")
		private double rNvAxis;
		
		@Expose
		@Column(name = "l_nv_sph")
		private double lNvSph;
		
		@Expose
		@Column(name = "l_nv_cyl")
		private double lNvCyl;
		
		@Expose
		@Column(name = "l_nv_axis")
		private double lNvAxis;
		
		@Expose
		@Column(name = "r_add")
		private double rAdd;
		
		@Expose
		@Column(name = "l_add")
		private double lAdd;
		
		
		
		public int getIsPosted() {
			return isPosted;
		}

		@XmlElement
		public void setIsPosted(int isPosted) {
			this.isPosted = isPosted;
		}

		public String getFinyrCode() {
			return finyrCode;
		}

		@XmlElement
		public void setFinyrCode(String finyrCode) {
			this.finyrCode = finyrCode;
		}

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

		public Date getDueDate() {
			return dueDate;
		}

		@XmlElement
		public void setDueDate(Date dueDate) {
			this.dueDate = dueDate;
		}

		public String getInvType() {
			return invType;
		}

		@XmlElement
		public void setInvType(String invType) {
			this.invType = invType;
		}


		public int getCustomerId() {
			return customerId;
		}

		@XmlElement
		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		@XmlElement
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getCustomerAddress() {
			return customerAddress;
		}

		@XmlElement
		public void setCustomerAddress(String customerAddress) {
			this.customerAddress = customerAddress;
		}

		public String getCustomerPhone() {
			return customerPhone;
		}

		@XmlElement
		public void setCustomerPhone(String customerPhone) {
			this.customerPhone = customerPhone;
		}

		public double getCustomerDiscPer() {
			return customerDiscPer;
		}

		@XmlElement
		public void setCustomerDiscPer(double customerDiscPer) {
			this.customerDiscPer = customerDiscPer;
		}

		public double getGrossAmount() {
			return grossAmount;
		}

		@XmlElement
		public void setGrossAmount(double grossAmount) {
			this.grossAmount = grossAmount;
		}

		public double getDiscAmount() {
			return discAmount;
		}

		@XmlElement
		public void setDiscAmount(double discAmount) {
			this.discAmount = discAmount;
		}

		public double getAdjAmount() {
			return adjAmount;
		}

		@XmlElement
		public void setAdjAmount(double adjAmount) {
			this.adjAmount = adjAmount;
		}

		public double getTaxAmount() {
			return taxAmount;
		}

		@XmlElement
		public void setTaxAmount(double taxAmount) {
			this.taxAmount = taxAmount;
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

		public String getRemarks() {
			return remarks;
		}

		@XmlElement
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		public int getIsCanceled() {
			return isCanceled;
		}

		@XmlElement
		public void setIsCanceled(int isCanceled) {
			this.isCanceled = isCanceled;
		}

		public int getIsDeleted() {
			return isDeleted;
		}

		@XmlElement
		public void setIsDeleted(int isDeleted) {
			this.isDeleted = isDeleted;
		}

		public int getStatus() {
			return status;
		}

		@XmlElement
		public void setStatus(int status) {
			this.status = status;
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

		public List<SaleOrderDetails> getSaleOrderDetails() {
			return saleOrderDetails;
		}

		public void setSaleOrderDetails(List<SaleOrderDetails> saleOrderDetails) {
			this.saleOrderDetails = saleOrderDetails;
		}

		public int getDoctorId() {
			return doctorId;
		}

		@XmlElement
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}

		public String getDoctorName() {
			return doctorName;
		}

		@XmlElement
		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}

		public double getAdvAmount() {
			return advAmount;
		}

		@XmlElement
		public void setAdvAmount(double advAmount) {
			this.advAmount = advAmount;
		}

		public double getrDvSph() {
			return rDvSph;
		}

		@XmlElement
		public void setrDvSph(double rDvSph) {
			this.rDvSph = rDvSph;
		}

		public double getrDvCyl() {
			return rDvCyl;
		}

		@XmlElement
		public void setrDvCyl(double rDvCyl) {
			this.rDvCyl = rDvCyl;
		}

		public double getrDvAxis() {
			return rDvAxis;
		}

		@XmlElement
		public void setrDvAxis(double rDvAxis) {
			this.rDvAxis = rDvAxis;
		}

		public double getlDvSph() {
			return lDvSph;
		}

		@XmlElement
		public void setlDvSph(double lDvSph) {
			this.lDvSph = lDvSph;
		}

		public double getlDvCyl() {
			return lDvCyl;
		}

		@XmlElement
		public void setlDvCyl(double lDvCyl) {
			this.lDvCyl = lDvCyl;
		}

		public double getlDvAxis() {
			return lDvAxis;
		}

		@XmlElement
		public void setlDvAxis(double lDvAxis) {
			this.lDvAxis = lDvAxis;
		}

		public double getrNvSph() {
			return rNvSph;
		}

		@XmlElement
		public void setrNvSph(double rNvSph) {
			this.rNvSph = rNvSph;
		}

		public double getrNvCyl() {
			return rNvCyl;
		}

		@XmlElement
		public void setrNvCyl(double rNvCyl) {
			this.rNvCyl = rNvCyl;
		}

		public double getrNvAxis() {
			return rNvAxis;
		}

		@XmlElement
		public void setrNvAxis(double rNvAxis) {
			this.rNvAxis = rNvAxis;
		}

		public double getlNvSph() {
			return lNvSph;
		}

		@XmlElement
		public void setlNvSph(double lNvSph) {
			this.lNvSph = lNvSph;
		}

		public double getlNvCyl() {
			return lNvCyl;
		}

		@XmlElement
		public void setlNvCyl(double lNvCyl) {
			this.lNvCyl = lNvCyl;
		}

		public double getlNvAxis() {
			return lNvAxis;
		}

		@XmlElement
		public void setlNvAxis(double lNvAxis) {
			this.lNvAxis = lNvAxis;
		}

		public double getrAdd() {
			return rAdd;
		}

		@XmlElement
		public void setrAdd(double rAdd) {
			this.rAdd = rAdd;
		}

		public double getlAdd() {
			return lAdd;
		}

		@XmlElement
		public void setlAdd(double lAdd) {
			this.lAdd = lAdd;
		}

		@Override
		public String toString() {
			return "SaleOrder [id=" + id + ", invNo=" + invNo + ", invDate=" + invDate + ", dueDate=" + dueDate
					+ ", invType=" + invType + ", customerId=" + customerId + ", customerName=" + customerName
					+ ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", customerDiscPer="
					+ customerDiscPer + ", doctorId=" + doctorId + ", doctorName=" + doctorName + ", grossAmount="
					+ grossAmount + ", discAmount=" + discAmount + ", adjAmount=" + adjAmount + ", advAmount="
					+ advAmount + ", taxAmount=" + taxAmount + ", roundoff=" + roundoff + ", netAmount=" + netAmount
					+ ", totalMrp=" + totalMrp + ", remarks=" + remarks + ", isCanceled=" + isCanceled + ", isDeleted="
					+ isDeleted + ", status=" + status + ", finyrId=" + finyrId + ", storeId=" + storeId
					+ ", companyId=" + companyId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
					+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", lang=" + lang + ", finyrCode="
					+ finyrCode + ", saleOrderDetails=" + saleOrderDetails + ", isPosted=" + isPosted + ", rDvSph="
					+ rDvSph + ", rDvCyl=" + rDvCyl + ", rDvAxis=" + rDvAxis + ", lDvSph=" + lDvSph + ", lDvCyl="
					+ lDvCyl + ", lDvAxis=" + lDvAxis + ", rNvSph=" + rNvSph + ", rNvCyl=" + rNvCyl + ", rNvAxis="
					+ rNvAxis + ", lNvSph=" + lNvSph + ", lNvCyl=" + lNvCyl + ", lNvAxis=" + lNvAxis + ", rAdd=" + rAdd
					+ ", lAdd=" + lAdd + "]";
		}


	}

