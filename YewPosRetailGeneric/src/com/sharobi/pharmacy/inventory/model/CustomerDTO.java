package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;


@XmlRootElement
public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;

	@Expose
	@MapToData(columnAliases = { "code" })
	private String code;

	@Expose
	@MapToData(columnAliases = { "address" })
	private String address;

	@Expose
	@MapToData(columnAliases = { "pin" })
	private String pin;

	@Expose
	@MapToData(columnAliases = { "city" })
	private String city;

	@Expose
	@MapToData(columnAliases = { "state" })
	private String state;

	@Expose
	@MapToData(columnAliases = { "country" })
	private String country;

	@Expose
	@MapToData(columnAliases = { "phone_no" })
	private String phoneNo;

	@Expose
	@MapToData(columnAliases = { "fax" })
	private String fax;

	@Expose
	@MapToData(columnAliases = { "ob_bal" })
	private double obBal;

	@Expose
	@MapToData(columnAliases = { "credit_limit" })
	private double creditLimit;
	
	@Expose
	@MapToData(columnAliases = { "payble_amount" })
	private double paybleAmount;
	
	@Expose
	@MapToData(columnAliases = { "payble_text" })
	private String paybleText;
	
	@Expose
	@MapToData(columnAliases = { "addhar_card_no" })
	private String addharCardNo;
	
	@Expose
	@MapToData(columnAliases = { "outstanding_amount" })
	private double outstandingAmount;
	
	@Expose
	@MapToData(columnAliases = { "dob" })
	private Date dob;
	
	@Expose
	@MapToData(columnAliases = { "gender" })
	private String gender;
	
	@Expose
	@MapToData(columnAliases = "customer_type_id")
	private int customerTypeId;
	
	@Expose
	@MapToData(columnAliases = "customer_type_name")
	private String customerTypeName;
	
	@Expose
	@MapToData(columnAliases = "gst_no")
	private String gstNo;
	
	@Expose
	@MapToData(columnAliases = "country_id")
	private int countryId;
	
	
	@Expose
	@MapToData(columnAliases = "state_id")
	private int stateId;
	
	@Expose
	@MapToData(columnAliases = "city_id")
	private int cityId;
	
	@Expose
	@MapToData(columnAliases = { "dl_no"})
	private String dlNo;
	
	@Expose
	@MapToData(columnAliases = { "pan_no"})
	private String panNo;
	
	@Expose
	@MapToData(columnAliases = { "anniversary_date" })
	private Date anniversaryDate;
	
	@Expose
	@MapToData(columnAliases = { "relative_type"})
	private String relativeType;
	
	@Expose
	@MapToData(columnAliases = { "relative_dob" })
	private Date relativeDob;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

	public double getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getAddharCardNo() {
		return addharCardNo;
	}

	public void setAddharCardNo(String addharCardNo) {
		this.addharCardNo = addharCardNo;
	}

	public double getPaybleAmount() {
		return paybleAmount;
	}

	public void setPaybleAmount(double paybleAmount) {
		this.paybleAmount = paybleAmount;
	}

	public String getPaybleText() {
		return paybleText;
	}

	public void setPaybleText(String paybleText) {
		this.paybleText = paybleText;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
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

	public int getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
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
		return "CustomerDTO [id=" + id + ", name=" + name + ", code=" + code + ", address=" + address + ", pin=" + pin
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", phoneNo=" + phoneNo + ", fax="
				+ fax + ", obBal=" + obBal + ", creditLimit=" + creditLimit + ", paybleAmount=" + paybleAmount
				+ ", paybleText=" + paybleText + ", addharCardNo=" + addharCardNo + ", outstandingAmount="
				+ outstandingAmount + ", dob=" + dob + ", gender=" + gender + ", customerTypeId=" + customerTypeId
				+ ", customerTypeName=" + customerTypeName + ", gstNo=" + gstNo + ", countryId=" + countryId
				+ ", stateId=" + stateId + ", cityId=" + cityId + ", dlNo=" + dlNo + ", panNo=" + panNo
				+ ", anniversaryDate=" + anniversaryDate + ", relativeType=" + relativeType + ", relativeDob="
				+ relativeDob + "]";
	}

	
}