package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlRootElement;

import net.sf.resultsetmapper.MapToData;

import com.google.gson.annotations.Expose;

@XmlRootElement
public class SaleOrderHeaderDTO implements Serializable {
	@Expose
	@MapToData(columnAliases = { "sale_id" })
	private int saleId;

	

	@Expose
	@MapToData(columnAliases = { "inv_no" })
	private String invNo;

	@Expose
	@MapToData(columnAliases = { "inv_date" })
	private Date invDate;

	@Expose
	@MapToData(columnAliases = { "inv_mode" })
	private int invMode;

	@Expose
	@MapToData(columnAliases = { "inv_mode_name" })
	private String invModeName;

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
	@MapToData(columnAliases = { "vat_amount" })
	private double vatAmount;

	@Expose
	@MapToData(columnAliases = { "tax_amount" })
	private double taxAmount;

	@Expose
	@MapToData(columnAliases = { "adj_amount" })
	private double adjAmount;

	@Expose
	@MapToData(columnAliases = { "roundoff" })
	private double roundoff;

	@Expose
	@MapToData(columnAliases = { "net_amount" })
	private double netAmount;

	@Expose
	@MapToData(columnAliases = { "remarks" })
	private String remarks;

	@Expose
	@MapToData(columnAliases = { "customer_id" })
	private int customerId;

	@Expose
	@MapToData(columnAliases = { "customer_name" })
	private String customerName;

	@Expose
	@MapToData(columnAliases = { "customer_phone" })
	private String customerPhone;

	@Expose
	@MapToData(columnAliases = { "customer_address" })
	private String customerAddress;

	@Expose
	@MapToData(columnAliases = { "doctor_id" })
	private int doctorId;

	@Expose
	@MapToData(columnAliases = { "doctor_name" })
	private String doctorName;

	@Expose
	@MapToData(columnAliases = { "cash_amount" })
	private double cashAmount;

	@Expose
	@MapToData(columnAliases = { "card_amount" })
	private double cardAmount;

	@Expose
	@MapToData(columnAliases = { "credit_amount" })
	private double creditAmount;

	@Expose
	@MapToData(columnAliases = { "card_four_digit" })
	private String cardFourDigit;

	@Expose
	@MapToData(columnAliases = { "card_exp_date" })
	private String cardExpDate;

	@Expose
	@MapToData(columnAliases = { "tender_amount" })
	private double tenderAmount;

	@Expose
	@MapToData(columnAliases = { "print_count" })
	private int printCount;

	@Expose
	@MapToData(columnAliases = { "hold_flag" })
	private int holdFlag;

	@Expose
	@MapToData(columnAliases = { "is_posted" })
	private int isPosted;

	@Expose
	@MapToData(columnAliases = { "customer_disc_per" })
	private double customerDiscPer;

	@Expose
	@MapToData(columnAliases = { "inv_time" })
	private String invTime;

	@Expose
	@MapToData(columnAliases = { "sale_return_id" })
	private int saleReturnId;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_per" })
	private double specialDiscPer;
	
	@Expose
	@MapToData(columnAliases = { "special_disc_amount" })
	private double specialDiscAmount;
	
	@Expose
	@MapToData(columnAliases = { "credit_limit" })
	private double creditLimit;
	
	@Expose
	@MapToData(columnAliases = { "total_amount" })
	private double totalAmount;
	
	@Expose
	@MapToData(columnAliases = { "taxable_amount" })
	private double taxableAmount;
	
	@Expose
	@MapToData(columnAliases = { "CGST" })
	private double cgst;
	
	@Expose
	@MapToData(columnAliases = { "SGST" })
	private double sgst;
	
	@Expose
	@MapToData(columnAliases = { "IGST" })
	private double igst;
	
	@Expose
	@MapToData(columnAliases = { "total_mrp" })
	private double totalMrp;
	
	@Expose
	@MapToData(columnAliases = { "esi_type" })
	private String esiType;
	
	@Expose
	@MapToData(columnAliases = { "prescription_reg_no" })
	private String prescriptionRegNo;
	
	@Expose
	@MapToData(columnAliases = { "prescription_issue_date" })
	private Date prescriptionIssueDate;
	
	@Expose
	@MapToData(columnAliases = { "slip_no" })
	private String slipNo;
	
	@Expose
	@MapToData(columnAliases = { "esi_code" })
	private String esiCode;
	
	@Expose
	@MapToData(columnAliases = { "customer_code" })
	private String customerCode;
	
	@Expose
	@MapToData(columnAliases = { "gender" })
	private String gender;
	
	@Expose
	@MapToData(columnAliases = { "place_of_treatment" })
	private String placeOfTreatment;
	
	@Expose
	@MapToData(columnAliases = { "lot_adj_amount" })
	private double lotAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "oth_adj_amount" })
	private double othAdjAmount;
	
	@Expose
	@MapToData(columnAliases = { "gst_no"})
	private String gstNo;

	@Expose
	@MapToData(columnAliases = { "dl_no"})
	private String dlNo;
	
	@Expose
	@MapToData(columnAliases = { "pan_no"})
	private String panNo;
	
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
	
	@Expose
	@MapToData(columnAliases = { "due_date" })
	private String dueDate;
	
	private static final long serialVersionUID = 1L;
	
	public double getLotAdjAmount() {
		return lotAdjAmount;
	}

	public void setLotAdjAmount(double lotAdjAmount) {
		this.lotAdjAmount = lotAdjAmount;
	}

	public String getPlaceOfTreatment() {
		return placeOfTreatment;
	}

	public void setPlaceOfTreatment(String placeOfTreatment) {
		this.placeOfTreatment = placeOfTreatment;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEsiType() {
		return esiType;
	}

	public void setEsiType(String esiType) {
		this.esiType = esiType;
	}

	public String getPrescriptionRegNo() {
		return prescriptionRegNo;
	}

	public void setPrescriptionRegNo(String prescriptionRegNo) {
		this.prescriptionRegNo = prescriptionRegNo;
	}

	public Date getPrescriptionIssueDate() {
		return prescriptionIssueDate;
	}

	public void setPrescriptionIssueDate(Date prescriptionIssueDate) {
		this.prescriptionIssueDate = prescriptionIssueDate;
	}

	public String getSlipNo() {
		return slipNo;
	}

	public void setSlipNo(String slipNo) {
		this.slipNo = slipNo;
	}

	public String getEsiCode() {
		return esiCode;
	}

	public void setEsiCode(String esiCode) {
		this.esiCode = esiCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	
	public double getTotalMrp() {
		return totalMrp;
	}

	public void setTotalMrp(double totalMrp) {
		this.totalMrp = totalMrp;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public double getCgst() {
		return cgst;
	}

	public void setCgst(double cgst) {
		this.cgst = cgst;
	}

	public double getSgst() {
		return sgst;
	}

	public void setSgst(double sgst) {
		this.sgst = sgst;
	}

	public double getIgst() {
		return igst;
	}

	public void setIgst(double igst) {
		this.igst = igst;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public double getSpecialDiscPer() {
		return specialDiscPer;
	}

	public void setSpecialDiscPer(double specialDiscPer) {
		this.specialDiscPer = specialDiscPer;
	}

	public double getSpecialDiscAmount() {
		return specialDiscAmount;
	}

	public void setSpecialDiscAmount(double specialDiscAmount) {
		this.specialDiscAmount = specialDiscAmount;
	}

	public int getSaleReturnId() {
		return saleReturnId;
	}

	public void setSaleReturnId(int saleReturnId) {
		this.saleReturnId = saleReturnId;
	}

	public String getInvTime() {
		return invTime;
	}

	public void setInvTime(String invTime) {
		this.invTime = invTime;
	}

	public double getCustomerDiscPer() {
		return customerDiscPer;
	}

	public void setCustomerDiscPer(double customerDiscPer) {
		this.customerDiscPer = customerDiscPer;
	}

	public int getIsPosted() {
		return isPosted;
	}

	public void setIsPosted(int isPosted) {
		this.isPosted = isPosted;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
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

	public int getInvMode() {
		return invMode;
	}

	public void setInvMode(int invMode) {
		this.invMode = invMode;
	}

	public String getInvModeName() {
		return invModeName;
	}

	public void setInvModeName(String invModeName) {
		this.invModeName = invModeName;
	}

	public double getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public double getEdAmount() {
		return edAmount;
	}

	public void setEdAmount(double edAmount) {
		this.edAmount = edAmount;
	}

	public double getDiscAmount() {
		return discAmount;
	}

	public void setDiscAmount(double discAmount) {
		this.discAmount = discAmount;
	}

	public double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getAdjAmount() {
		return adjAmount;
	}

	public void setAdjAmount(double adjAmount) {
		this.adjAmount = adjAmount;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
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

	public double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public double getCardAmount() {
		return cardAmount;
	}

	public void setCardAmount(double cardAmount) {
		this.cardAmount = cardAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getCardFourDigit() {
		return cardFourDigit;
	}

	public void setCardFourDigit(String cardFourDigit) {
		this.cardFourDigit = cardFourDigit;
	}

	public String getCardExpDate() {
		return cardExpDate;
	}

	public void setCardExpDate(String cardExpDate) {
		this.cardExpDate = cardExpDate;
	}

	public double getTenderAmount() {
		return tenderAmount;
	}

	public void setTenderAmount(double tenderAmount) {
		this.tenderAmount = tenderAmount;
	}

	public int getPrintCount() {
		return printCount;
	}

	public void setPrintCount(int printCount) {
		this.printCount = printCount;
	}

	public int getHoldFlag() {
		return holdFlag;
	}

	public void setHoldFlag(int holdFlag) {
		this.holdFlag = holdFlag;
	}

	public double getOthAdjAmount() {
		return othAdjAmount;
	}

	public void setOthAdjAmount(double othAdjAmount) {
		this.othAdjAmount = othAdjAmount;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
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

	@Override
	public String toString() {
		return "SaleOrderHeaderDTO [saleId=" + saleId + ", invNo=" + invNo + ", invDate=" + invDate + ", invMode="
				+ invMode + ", invModeName=" + invModeName + ", grossAmount=" + grossAmount + ", edAmount=" + edAmount
				+ ", discAmount=" + discAmount + ", vatAmount=" + vatAmount + ", taxAmount=" + taxAmount
				+ ", adjAmount=" + adjAmount + ", roundoff=" + roundoff + ", netAmount=" + netAmount + ", remarks="
				+ remarks + ", customerId=" + customerId + ", customerName=" + customerName + ", customerPhone="
				+ customerPhone + ", customerAddress=" + customerAddress + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", cashAmount=" + cashAmount + ", cardAmount=" + cardAmount + ", creditAmount="
				+ creditAmount + ", cardFourDigit=" + cardFourDigit + ", cardExpDate=" + cardExpDate + ", tenderAmount="
				+ tenderAmount + ", printCount=" + printCount + ", holdFlag=" + holdFlag + ", isPosted=" + isPosted
				+ ", customerDiscPer=" + customerDiscPer + ", invTime=" + invTime + ", saleReturnId=" + saleReturnId
				+ ", specialDiscPer=" + specialDiscPer + ", specialDiscAmount=" + specialDiscAmount + ", creditLimit="
				+ creditLimit + ", totalAmount=" + totalAmount + ", taxableAmount=" + taxableAmount + ", cgst=" + cgst
				+ ", sgst=" + sgst + ", igst=" + igst + ", totalMrp=" + totalMrp + ", esiType=" + esiType
				+ ", prescriptionRegNo=" + prescriptionRegNo + ", prescriptionIssueDate=" + prescriptionIssueDate
				+ ", slipNo=" + slipNo + ", esiCode=" + esiCode + ", customerCode=" + customerCode + ", gender="
				+ gender + ", placeOfTreatment=" + placeOfTreatment + ", lotAdjAmount=" + lotAdjAmount
				+ ", othAdjAmount=" + othAdjAmount + ", gstNo=" + gstNo + ", dlNo=" + dlNo + ", panNo=" + panNo
				+ ", rDvSph=" + rDvSph + ", rDvCyl=" + rDvCyl + ", rDvAxis=" + rDvAxis + ", lDvSph=" + lDvSph
				+ ", lDvCyl=" + lDvCyl + ", lDvAxis=" + lDvAxis + ", rNvSph=" + rNvSph + ", rNvCyl=" + rNvCyl
				+ ", rNvAxis=" + rNvAxis + ", lNvSph=" + lNvSph + ", lNvCyl=" + lNvCyl + ", lNvAxis=" + lNvAxis
				+ ", rAdd=" + rAdd + ", lAdd=" + lAdd + ", dueDate=" + dueDate + "]";
	}

}