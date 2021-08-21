package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;


@XmlRootElement
public class SaleOrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "sale_order_id" })
	private int saleOrderId;

	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;

	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;

	@Expose
	@MapToData(columnAliases = { "due_date" })
	private Date dueDate;

	@Expose
	@MapToData(columnAliases = { "inv_type" })
	private String invType;

	@Expose
	@MapToData(columnAliases = { "customer_id" })
	private int customerId;
	
	@Expose
	@MapToData(columnAliases = { "customer_name" })
	private String customerName;
	
	@Expose
	@MapToData(columnAliases = { "customer_address" })
	private String customerAddress;
	
	@Expose
	@MapToData(columnAliases = { "customer_phone" })
	private String customerPhone;

	@Expose
	@MapToData(columnAliases = { "customer_disc_per" })
	private double customerDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "customer_email" })
	private String customerEmail;
	
	@Expose
	@MapToData(columnAliases = { "customer_gst_no" })
	private String customerGstNo;
	
	@Expose
	@MapToData(columnAliases = { "doctor_id" })
	private int doctorId;
	
	@Expose
	@MapToData(columnAliases = { "doctor_name" })
	private String doctorName;

	@Expose
	@MapToData(columnAliases = { "gross_amount" })
	private double grossAmount;

	@Expose
	@MapToData(columnAliases = { "disc_amount" })
	private double discAmount;

	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;

	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;

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
	@MapToData(columnAliases = { "adv_amount" })
	private double advAmount;
	
	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;

	@Expose
	@MapToData(columnAliases = { "status" })
	private int status;
	
	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;
	
	@Expose
	@MapToData(columnAliases = { "r_dv_sph" })
	private double rDvSph;
	
	@Expose
	@MapToData(columnAliases = { "r_dv_cyl" })
	private double rDvCyl;
	
	@Expose
	@MapToData(columnAliases = { "r_dv_axis" })
	private double rDvAxis;
	
	@Expose
	@MapToData(columnAliases = { "l_dv_sph" })
	private double lDvSph;
	
	@Expose
	@MapToData(columnAliases = { "l_dv_cyl" })
	private double lDvCyl;
	
	@Expose
	@MapToData(columnAliases = { "l_dv_axis" })
	private double lDvAxis;
	
	@Expose
	@MapToData(columnAliases = { "r_nv_sph" })
	private double rNvSph;
	
	@Expose
	@MapToData(columnAliases = { "r_nv_cyl" })
	private double rNvCyl;
	
	@Expose
	@MapToData(columnAliases = { "r_nv_axis" })
	private double rNvAxis;
	
	@Expose
	@MapToData(columnAliases = { "l_nv_sph" })
	private double lNvSph;
	
	@Expose
	@MapToData(columnAliases = { "l_nv_cyl" })
	private double lNvCyl;
	
	@Expose
	@MapToData(columnAliases = { "l_nv_axis" })
	private double lNvAxis;
	
	@Expose
	@MapToData(columnAliases = { "r_add" })
	private double rAdd;
	
	@Expose
	@MapToData(columnAliases = { "l_add" })
	private double lAdd;

	public int getSaleOrderId() {
		return saleOrderId;
	}

	public void setSaleOrderId(int saleOrderId) {
		this.saleOrderId = saleOrderId;
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

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getInvType() {
		return invType;
	}

	public void setInvType(String invType) {
		this.invType = invType;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public double getCustomerDiscPer() {
		return customerDiscPer;
	}

	public void setCustomerDiscPer(double customerDiscPer) {
		this.customerDiscPer = customerDiscPer;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getRoundoff() {
		return roundoff;
	}

	public void setRoundoff(double roundoff) {
		this.roundoff = roundoff;
	}

	public double getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(double netAmount) {
		this.netAmount = netAmount;
	}

	public double getTotalMrp() {
		return totalMrp;
	}

	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public double getAdvAmount() {
		return advAmount;
	}

	public void setAdvAmount(double advAmount) {
		this.advAmount = advAmount;
	}

	public double getrDvSph() {
		return rDvSph;
	}

	public void setrDvSph(double rDvSph) {
		this.rDvSph = rDvSph;
	}

	public double getrDvCyl() {
		return rDvCyl;
	}

	public void setrDvCyl(double rDvCyl) {
		this.rDvCyl = rDvCyl;
	}

	public double getrDvAxis() {
		return rDvAxis;
	}

	public void setrDvAxis(double rDvAxis) {
		this.rDvAxis = rDvAxis;
	}

	public double getlDvSph() {
		return lDvSph;
	}

	public void setlDvSph(double lDvSph) {
		this.lDvSph = lDvSph;
	}

	public double getlDvCyl() {
		return lDvCyl;
	}

	public void setlDvCyl(double lDvCyl) {
		this.lDvCyl = lDvCyl;
	}

	public double getlDvAxis() {
		return lDvAxis;
	}

	public void setlDvAxis(double lDvAxis) {
		this.lDvAxis = lDvAxis;
	}

	public double getrNvSph() {
		return rNvSph;
	}

	public void setrNvSph(double rNvSph) {
		this.rNvSph = rNvSph;
	}

	public double getrNvCyl() {
		return rNvCyl;
	}

	public void setrNvCyl(double rNvCyl) {
		this.rNvCyl = rNvCyl;
	}

	public double getrNvAxis() {
		return rNvAxis;
	}

	public void setrNvAxis(double rNvAxis) {
		this.rNvAxis = rNvAxis;
	}

	public double getlNvSph() {
		return lNvSph;
	}

	public void setlNvSph(double lNvSph) {
		this.lNvSph = lNvSph;
	}

	public double getlNvCyl() {
		return lNvCyl;
	}

	public void setlNvCyl(double lNvCyl) {
		this.lNvCyl = lNvCyl;
	}

	public double getlNvAxis() {
		return lNvAxis;
	}

	public void setlNvAxis(double lNvAxis) {
		this.lNvAxis = lNvAxis;
	}

	public double getrAdd() {
		return rAdd;
	}

	public void setrAdd(double rAdd) {
		this.rAdd = rAdd;
	}

	public double getlAdd() {
		return lAdd;
	}

	public void setlAdd(double lAdd) {
		this.lAdd = lAdd;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerGstNo() {
		return customerGstNo;
	}

	public void setCustomerGstNo(String customerGstNo) {
		this.customerGstNo = customerGstNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(advAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((customerAddress == null) ? 0 : customerAddress.hashCode());
		temp = Double.doubleToLongBits(customerDiscPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerId;
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPhone == null) ? 0 : customerPhone.hashCode());
		temp = Double.doubleToLongBits(discAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + doctorId;
		result = prime * result + ((doctorName == null) ? 0 : doctorName.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		temp = Double.doubleToLongBits(grossAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((invDate == null) ? 0 : invDate.hashCode());
		result = prime * result + ((invNo == null) ? 0 : invNo.hashCode());
		result = prime * result + ((invType == null) ? 0 : invType.hashCode());
		result = prime * result + isPosted;
		temp = Double.doubleToLongBits(lAdd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lDvAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lDvCyl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lDvSph);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lNvAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lNvCyl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lNvSph);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rAdd);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rDvAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rDvCyl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rDvSph);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rNvAxis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rNvCyl);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(rNvSph);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((remarks == null) ? 0 : remarks.hashCode());
		temp = Double.doubleToLongBits(roundoff);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + saleOrderId;
		result = prime * result + status;
		temp = Double.doubleToLongBits(taxAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(totalMrp);
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
		SaleOrderDTO other = (SaleOrderDTO) obj;
		if (Double.doubleToLongBits(adjAmount) != Double.doubleToLongBits(other.adjAmount))
			return false;
		if (Double.doubleToLongBits(advAmount) != Double.doubleToLongBits(other.advAmount))
			return false;
		if (customerAddress == null) {
			if (other.customerAddress != null)
				return false;
		} else if (!customerAddress.equals(other.customerAddress))
			return false;
		if (Double.doubleToLongBits(customerDiscPer) != Double.doubleToLongBits(other.customerDiscPer))
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPhone == null) {
			if (other.customerPhone != null)
				return false;
		} else if (!customerPhone.equals(other.customerPhone))
			return false;
		if (Double.doubleToLongBits(discAmount) != Double.doubleToLongBits(other.discAmount))
			return false;
		if (doctorId != other.doctorId)
			return false;
		if (doctorName == null) {
			if (other.doctorName != null)
				return false;
		} else if (!doctorName.equals(other.doctorName))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (Double.doubleToLongBits(grossAmount) != Double.doubleToLongBits(other.grossAmount))
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
		if (invType == null) {
			if (other.invType != null)
				return false;
		} else if (!invType.equals(other.invType))
			return false;
		if (isPosted != other.isPosted)
			return false;
		if (Double.doubleToLongBits(lAdd) != Double.doubleToLongBits(other.lAdd))
			return false;
		if (Double.doubleToLongBits(lDvAxis) != Double.doubleToLongBits(other.lDvAxis))
			return false;
		if (Double.doubleToLongBits(lDvCyl) != Double.doubleToLongBits(other.lDvCyl))
			return false;
		if (Double.doubleToLongBits(lDvSph) != Double.doubleToLongBits(other.lDvSph))
			return false;
		if (Double.doubleToLongBits(lNvAxis) != Double.doubleToLongBits(other.lNvAxis))
			return false;
		if (Double.doubleToLongBits(lNvCyl) != Double.doubleToLongBits(other.lNvCyl))
			return false;
		if (Double.doubleToLongBits(lNvSph) != Double.doubleToLongBits(other.lNvSph))
			return false;
		if (Double.doubleToLongBits(netAmount) != Double.doubleToLongBits(other.netAmount))
			return false;
		if (Double.doubleToLongBits(rAdd) != Double.doubleToLongBits(other.rAdd))
			return false;
		if (Double.doubleToLongBits(rDvAxis) != Double.doubleToLongBits(other.rDvAxis))
			return false;
		if (Double.doubleToLongBits(rDvCyl) != Double.doubleToLongBits(other.rDvCyl))
			return false;
		if (Double.doubleToLongBits(rDvSph) != Double.doubleToLongBits(other.rDvSph))
			return false;
		if (Double.doubleToLongBits(rNvAxis) != Double.doubleToLongBits(other.rNvAxis))
			return false;
		if (Double.doubleToLongBits(rNvCyl) != Double.doubleToLongBits(other.rNvCyl))
			return false;
		if (Double.doubleToLongBits(rNvSph) != Double.doubleToLongBits(other.rNvSph))
			return false;
		if (remarks == null) {
			if (other.remarks != null)
				return false;
		} else if (!remarks.equals(other.remarks))
			return false;
		if (Double.doubleToLongBits(roundoff) != Double.doubleToLongBits(other.roundoff))
			return false;
		if (saleOrderId != other.saleOrderId)
			return false;
		if (status != other.status)
			return false;
		if (Double.doubleToLongBits(taxAmount) != Double.doubleToLongBits(other.taxAmount))
			return false;
		if (Double.doubleToLongBits(totalMrp) != Double.doubleToLongBits(other.totalMrp))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SaleOrderDTO [saleOrderId=" + saleOrderId + ", invNo=" + invNo + ", invDate=" + invDate + ", dueDate="
				+ dueDate + ", invType=" + invType + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + ", customerPhone=" + customerPhone + ", customerDiscPer="
				+ customerDiscPer + ", customerEmail=" + customerEmail + ", customerGstNo=" + customerGstNo
				+ ", doctorId=" + doctorId + ", doctorName=" + doctorName + ", grossAmount=" + grossAmount
				+ ", discAmount=" + discAmount + ", adjAmount=" + adjAmount + ", taxAmount=" + taxAmount + ", roundoff="
				+ roundoff + ", netAmount=" + netAmount + ", totalMrp=" + totalMrp + ", advAmount=" + advAmount
				+ ", remarks=" + remarks + ", status=" + status + ", isPosted=" + isPosted + ", rDvSph=" + rDvSph
				+ ", rDvCyl=" + rDvCyl + ", rDvAxis=" + rDvAxis + ", lDvSph=" + lDvSph + ", lDvCyl=" + lDvCyl
				+ ", lDvAxis=" + lDvAxis + ", rNvSph=" + rNvSph + ", rNvCyl=" + rNvCyl + ", rNvAxis=" + rNvAxis
				+ ", lNvSph=" + lNvSph + ", lNvCyl=" + lNvCyl + ", lNvAxis=" + lNvAxis + ", rAdd=" + rAdd + ", lAdd="
				+ lAdd + "]";
	}

}
