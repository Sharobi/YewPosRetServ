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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

/**
 * Entity implementation class for Entity: in_m_customer
 * 
 */

@XmlRootElement
@Entity
@Table(name = "in_m_customer")
public class CustomerMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Expose
	@Column(name = "name")
	private String name;

	@Expose
	@Column(name = "code")
	private String code;

	@Expose
	@Column(name = "address")
	private String address;

	@Expose
	@Column(name = "pin")
	private String pin;

	@Expose
	@Column(name = "city")
	private int city;

	@Expose
	@Column(name = "state")
	private int state;

	@Expose
	@Column(name = "country")
	private int country;

	@Expose
	@Column(name = "phone_no")
	private String phoneNo;

	@Expose
	@Column(name = "fax")
	private String fax;

	@Expose
	@Column(name = "ob_bal")
	private double obBal;

	@Expose
	@Column(name = "credit_limit")
	private double creditLimit;

	@Expose
	@Column(name = "store_id")
	private int storeId;

	@Expose
	@Column(name = "company_id")
	private int companyId;

	@Expose
	@Column(name = "is_deleted")
	private int isDeleted;

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
	private int finyrId;
	
	@Expose
	@Column(name = "addhar_card_no")
	private String addharCardNo;
	
	@Expose
	@Column(name = "dob")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dob;
	
	@Expose
	@Column(name = "gender")
	private String gender;
	
	@Expose
	@Column(name = "pan_no")
	private String panNo;
	
	@Expose
	@Column(name = "gst_no")
	private String gstNo;
	
	@Expose
	@Column(name = "dl_no")
	private String dlNo;
	
	@Expose
	@Column(name = "customer_type_id")
	private int customerTypeId;
	
	@Expose
	@Transient
	private String customerTypeName;
	
	//22.03.2018
	@Expose
	@Column(name = "age")
	private int age;
	
	@Expose
	@Column(name = "guardian_name")
	private String guardian_name;
	
	//added on 14.08.2019
	@Expose
	@Column(name = "anniversary_date")
	@Temporal(TemporalType.DATE)
	private Date anniversaryDate;
	
	@Expose
	@Column(name = "relative_type")
	private String relativeType;
	
	@Expose
	@Column(name = "relative_dob")
	@Temporal(TemporalType.DATE)
	private Date relativeDob;
	

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddharCardNo() {
		return addharCardNo;
	}

	public void setAddharCardNo(String addharCardNo) {
		this.addharCardNo = addharCardNo;
	}

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public double getObBal() {
		return obBal;
	}

	public void setObBal(double obBal) {
		this.obBal = obBal;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	/**
	 * @return the customerTypeId
	 */
	public int getCustomerTypeId() {
		return customerTypeId;
	}

	/**
	 * @param customerTypeId the customerTypeId to set
	 */
	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	/**
	 * @return the customerTypeName
	 */
	public String getCustomerTypeName() {
		return customerTypeName;
	}

	/**
	 * @param customerTypeName the customerTypeName to set
	 */
	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGuardian_name() {
		return guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		this.guardian_name = guardian_name;
	}

	public String getDlNo() {
		return dlNo;
	}

	public void setDlNo(String dlNo) {
		this.dlNo = dlNo;
	}

	public Date getAnniversaryDate() {
		return anniversaryDate;
	}

	public void setAnniversaryDate(Date anniversaryDate) {
		this.anniversaryDate = anniversaryDate;
	}

	public String getRelativeType() {
		return relativeType;
	}

	public void setRelativeType(String relativeType) {
		this.relativeType = relativeType;
	}

	public Date getRelativeDob() {
		return relativeDob;
	}

	public void setRelativeDob(Date relativeDob) {
		this.relativeDob = relativeDob;
	}

	@Override
	public String toString() {
		return "CustomerMaster [id=" + id + ", name=" + name + ", code=" + code + ", address=" + address + ", pin="
				+ pin + ", city=" + city + ", state=" + state + ", country=" + country + ", phoneNo=" + phoneNo
				+ ", fax=" + fax + ", obBal=" + obBal + ", creditLimit=" + creditLimit + ", storeId=" + storeId
				+ ", companyId=" + companyId + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", lang=" + lang + ", finyrId=" + finyrId + ", addharCardNo=" + addharCardNo + ", dob=" + dob
				+ ", gender=" + gender + ", panNo=" + panNo + ", gstNo=" + gstNo + ", dlNo=" + dlNo
				+ ", customerTypeId=" + customerTypeId + ", customerTypeName=" + customerTypeName + ", age=" + age
				+ ", guardian_name=" + guardian_name + ", anniversaryDate=" + anniversaryDate + ", relativeType="
				+ relativeType + ", relativeDob=" + relativeDob + "]";
	}

	

}