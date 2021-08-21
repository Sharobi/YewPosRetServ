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
public class PrintBillDetails implements Serializable{
	
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
	@Column(name = "print_bill_id")
	@MapToData(columnAliases={"print_bill_id"})
	private int printBillId;
	@Expose
	@Column(name = "bill_type")
	@MapToData(columnAliases={"bill_type"})
	private String billType;
	@Expose
	@Column(name = "page_url")
	@MapToData(columnAliases={"page_url"})
	private String pageUrl;
	@Expose
	@Column(name = "bill_header")
	@MapToData(columnAliases={"bill_header"})
	private String billHeader;
	@Expose
	@Column(name = "bill_footer")
	@MapToData(columnAliases={"bill_footer"})
	private String billFooter;
	@Expose
	@Column(name = "bill_text")
	@MapToData(columnAliases={"bill_text"})
	private String billText;
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
	public int getPrintBillId() {
		return printBillId;
	}
	public void setPrintBillId(int printBillId) {
		this.printBillId = printBillId;
	}
	public String getBillType() {
		return billType;
	}
	public void setBillType(String billType) {
		this.billType = billType;
	}
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getBillHeader() {
		return billHeader;
	}
	public void setBillHeader(String billHeader) {
		this.billHeader = billHeader;
	}
	public String getBillFooter() {
		return billFooter;
	}
	public void setBillFooter(String billFooter) {
		this.billFooter = billFooter;
	}
	public String getBillText() {
		return billText;
	}
	public void setBillText(String billText) {
		this.billText = billText;
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
		return "PrintBillDetails [id=" + id + ", printBillId=" + printBillId + ", billType=" + billType + ", pageUrl="
				+ pageUrl + ", billHeader=" + billHeader + ", billFooter=" + billFooter + ", billText=" + billText
				+ ", companyId=" + companyId + ", storeId=" + storeId + "]";
	}
	
	

}
