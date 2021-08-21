/**
 * 
 */
package com.sharobi.pharmacy.store.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * @author Habib
 *
 */
public class PrintBill implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@MapToData(columnAliases={"id"})
	private int id;
	@Expose
	@Column(name = "acc_name")
	@MapToData(columnAliases={"acc_name"})
	private String accName;
	@Expose
	@Column(name = "acc_no")
	@MapToData(columnAliases={"acc_no"})
	private String accNo;
	@Expose
	@Column(name = "ifsc_code")
	@MapToData(columnAliases={"ifsc_code"})
	private String ifscCode;
	@Expose
	@Column(name = "bank_name")
	@MapToData(columnAliases={"bank_name"})
	private String bankName;
	@Expose
	@Column(name = "branch_name")
	@MapToData(columnAliases={"branch_name"})
	private String branchName;
	@Expose
	@Column(name = "electro_ref_no")
	@MapToData(columnAliases={"electro_ref_no"})
	private String electroRefNo;
	@Expose
	@Column(name = "acc_dt_display")
	@MapToData(columnAliases={"acc_dt_display"})
	private int accDtDisplay;
	@Expose
	@Column(name = "tax_dt_display")
	@MapToData(columnAliases={"tax_dt_display"})
	private int taxDtDisplay;
	@Expose
	@Column(name = "tag_line")
	@MapToData(columnAliases={"tag_line"})
	private String tagLine;
	@Expose
	@Column(name = "print_type")
	@MapToData(columnAliases={"print_type"})
	private String printType;
	@Expose
	@Column(name = "bill_size")
	@MapToData(columnAliases={"bill_size"})
	private String billSize;
	@Expose
	@Column(name = "noteline_1")
	@MapToData(columnAliases={"noteline_1"})
	private String noteLine1;
	@Expose
	@Column(name = "noteline_2")
	@MapToData(columnAliases={"noteline_2"})
	private String noteLine2;
	@Expose
	@Column(name = "noteline_3")
	@MapToData(columnAliases={"noteline_3"})
	private String noteLine3;
	@Expose
	@Column(name = "noteline_4")
	@MapToData(columnAliases={"noteline_4"})
	private String noteLine4;
	@Expose
	@Column(name = "noteline_5")
	@MapToData(columnAliases={"noteline_5"})
	private String noteLine5;
	@Expose
	@Column(name = "logo_url")
	@MapToData(columnAliases={"logo_url"})
	private String logoUrl;
	@Expose
	@Column(name = "company_id")
	private int companyId;
	@Expose
	@Column(name = "store_id")
	private int storeId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getElectroRefNo() {
		return electroRefNo;
	}
	public void setElectroRefNo(String electroRefNo) {
		this.electroRefNo = electroRefNo;
	}
	public int getAccDtDisplay() {
		return accDtDisplay;
	}
	public void setAccDtDisplay(int accDtDisplay) {
		this.accDtDisplay = accDtDisplay;
	}
	public int getTaxDtDisplay() {
		return taxDtDisplay;
	}
	public void setTaxDtDisplay(int taxDtDisplay) {
		this.taxDtDisplay = taxDtDisplay;
	}
	public String getTagLine() {
		return tagLine;
	}
	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}
	public String getPrintType() {
		return printType;
	}
	public void setPrintType(String printType) {
		this.printType = printType;
	}
	public String getBillSize() {
		return billSize;
	}
	public void setBillSize(String billSize) {
		this.billSize = billSize;
	}
	public String getNoteLine1() {
		return noteLine1;
	}
	public void setNoteLine1(String noteLine1) {
		this.noteLine1 = noteLine1;
	}
	public String getNoteLine2() {
		return noteLine2;
	}
	public void setNoteLine2(String noteLine2) {
		this.noteLine2 = noteLine2;
	}
	public String getNoteLine3() {
		return noteLine3;
	}
	public void setNoteLine3(String noteLine3) {
		this.noteLine3 = noteLine3;
	}
	public String getNoteLine4() {
		return noteLine4;
	}
	public void setNoteLine4(String noteLine4) {
		this.noteLine4 = noteLine4;
	}
	public String getNoteLine5() {
		return noteLine5;
	}
	public void setNoteLine5(String noteLine5) {
		this.noteLine5 = noteLine5;
	}
	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
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
	@Override
	public String toString() {
		return "PrintBill [id=" + id + ", accName=" + accName + ", accNo=" + accNo + ", ifscCode=" + ifscCode
				+ ", bankName=" + bankName + ", branchName=" + branchName + ", electroRefNo=" + electroRefNo
				+ ", accDtDisplay=" + accDtDisplay + ", taxDtDisplay=" + taxDtDisplay + ", tagLine=" + tagLine
				+ ", printType=" + printType + ", billSize=" + billSize + ", noteLine1=" + noteLine1 + ", noteLine2="
				+ noteLine2 + ", noteLine3=" + noteLine3 + ", noteLine4=" + noteLine4 + ", noteLine5=" + noteLine5
				+ ", logoUrl=" + logoUrl + ", companyId=" + companyId + ", storeId=" + storeId + "]";
	}
	
	

}
