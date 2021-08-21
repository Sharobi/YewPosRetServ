package com.sharobi.pharmacy.store.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

/**
 * Entity implementation class for Entity: gen_m_store
 * 
 */

@XmlRootElement
@Entity
@Table(name = "gen_m_store")
public class StoreMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@MapToData(columnAliases={"id"})
	@Column(name = "id")
	private int id;

	@Expose
	@ManyToOne
	@JoinColumn(name = "company_id")
	private CompanyMaster companyMaster;

	@Expose
	@Column(name = "name")
	@MapToData(columnAliases={"name"})
	private String name;

	@Expose
	@Column(name = "registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date registrationDate;

	@Expose
	@Column(name = "termination_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date terminationDate;

	@Expose
	@Column(name = "currency_id")
	private int currencyId;

	@Expose
	@Column(name = "latitude")
	private String latitude;

	@Expose
	@Column(name = "longitude")
	private String longitude;

	@Expose
	@Column(name = "address")
	private String address;

	@Expose
	@Column(name = "state")
	private String state;

	@Expose
	@Column(name = "country")
	private String country;

	@Expose
	@Column(name = "postcode")
	private String postcode;

	@Expose
	@Column(name = "email")
	private String email;

	@Expose
	@Column(name = "phone")
	private String phone;

	@Expose
	@Column(name = "fax")
	private String fax;

	@Expose
	@Column(name = "is_active")
	private int isActive;

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
	@Column(name = "is_default")
	private int isDefault;
	
	@Expose
	@Column(name = "dl_licence_no")
	private String dlLicenceNo;
	
	@Expose
	@Column(name = "dl_registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dlRegistrationDate;
	
	@Expose
	@Column(name = "dl_expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dlExpiryDate;
	
	@Expose
	@Column(name = "state_licence_no")
	private String stateLicenceNo;
	
	@Expose
	@Column(name = "state_registration_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stateRegistrationDate;
	
	@Expose
	@Column(name = "state_expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date stateExpiryDate;
	
	@Expose
	@Column(name = "tax_reg_no")
	private String taxRegNo;
	
	@Expose
	@Column(name = "tax_per")
	private double taxPer;
	
	@Expose
	@Column(name = "vat_per")
	private double vatPer;
	
	@Expose
	@Column(name = "is_mail_enable")
	private int isMailEnable;
	
	@Expose
	@Column(name = "mail_password")
	private String mailPassword;
	
	@Expose
	@Column(name = "mail_port")
	private String mailPort;
	
	@Expose
	@Column(name = "mail_smtp")
	private String mailSmtp;
	
	@Expose
	@Column(name = "tax_reg_no_text")
	private String taxRegNoText;
	
	@Expose
	@Column(name = "is_exclusive")
	private int isExclusive;
	
	@Expose
	@Column(name = "is_esi")
	private int isEsi;
	
	@Expose
	@Column(name = "default_port")
	private String defaultPort;
	
	@Expose
	@Column(name = "baud_rate")
	private int baudRate;
	
	@Expose
	@Column(name = "numeric_key_board")
	private int numericKeyBoard;
	
	@Expose
	@Column(name = "is_account")
	private int is_account ;
	
	@Expose
	@Column(name = "is_customer_display")
	private int isCustomerDisplay ;
	
	@Expose
	@Column(name = "is_salesman")
	private int isSalesman ;
	
	@Expose
	@Column(name = "is_conversion")
	private int isConversion ;
	
	@Expose
	@Column(name = "is_manufacturer")
	private int isManufacturer ;
	
	@Expose
	@Column(name = "is_free")
	private int isFree ;
	
	@Expose
	@Column(name = "is_on_bill_sale")
	private int isOnBillSale ;
	
	@Expose
	@Column(name = "is_on_bill_purchase")
	private int isOnBillPurchase ;
	
	@Expose
	@Column(name = "is_new_display")
	private int isNewDisplay ;
	
	@Expose
	@Column(name = "is_saleman")
	private int isSaleman ;
	
	@Expose
	@Column(name = "is_optical")
	private int isOptical;
	
	@Expose
	@Column(name = "is_mrp_enable")
	private int isMrpEnable;
	
	@Expose
	@Transient
	@MapToData(columnAliases = { "fin_yr_id" })
	private int finYrId;
	
	public StoreMaster() { }
	
	public int getIsEsi() {
		return isEsi;
	}

	public void setIsEsi(int isEsi) {
		this.isEsi = isEsi;
	}

	public int getIsMailEnable() {
		return isMailEnable;
	}

	public void setIsMailEnable(int isMailEnable) {
		this.isMailEnable = isMailEnable;
	}

	public String getMailPassword() {
		return mailPassword;
	}

	public void setMailPassword(String mailPassword) {
		this.mailPassword = mailPassword;
	}

	public String getMailPort() {
		return mailPort;
	}

	public void setMailPort(String mailPort) {
		this.mailPort = mailPort;
	}

	public String getMailSmtp() {
		return mailSmtp;
	}

	public void setMailSmtp(String mailSmtp) {
		this.mailSmtp = mailSmtp;
	}

	public String getTaxRegNoText() {
		return taxRegNoText;
	}

	public void setTaxRegNoText(String taxRegNoText) {
		this.taxRegNoText = taxRegNoText;
	}

	public int getIsExclusive() {
		return isExclusive;
	}

	public void setIsExclusive(int isExclusive) {
		this.isExclusive = isExclusive;
	}

	public String getTaxRegNo() {
		return taxRegNo;
	}

	public void setTaxRegNo(String taxRegNo) {
		this.taxRegNo = taxRegNo;
	}

	public double getTaxPer() {
		return taxPer;
	}

	public void setTaxPer(double taxPer) {
		this.taxPer = taxPer;
	}

	public double getVatPer() {
		return vatPer;
	}

	public void setVatPer(double vatPer) {
		this.vatPer = vatPer;
	}

	public String getDlLicenceNo() {
		return dlLicenceNo;
	}

	public void setDlLicenceNo(String dlLicenceNo) {
		this.dlLicenceNo = dlLicenceNo;
	}

	public Date getDlRegistrationDate() {
		return dlRegistrationDate;
	}

	public void setDlRegistrationDate(Date dlRegistrationDate) {
		this.dlRegistrationDate = dlRegistrationDate;
	}

	public Date getDlExpiryDate() {
		return dlExpiryDate;
	}

	public void setDlExpiryDate(Date dlExpiryDate) {
		this.dlExpiryDate = dlExpiryDate;
	}

	public String getStateLicenceNo() {
		return stateLicenceNo;
	}

	public void setStateLicenceNo(String stateLicenceNo) {
		this.stateLicenceNo = stateLicenceNo;
	}

	public Date getStateRegistrationDate() {
		return stateRegistrationDate;
	}

	public void setStateRegistrationDate(Date stateRegistrationDate) {
		this.stateRegistrationDate = stateRegistrationDate;
	}

	public Date getStateExpiryDate() {
		return stateExpiryDate;
	}

	public void setStateExpiryDate(Date stateExpiryDate) {
		this.stateExpiryDate = stateExpiryDate;
	}

	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CompanyMaster getCompanyMaster() {
		return companyMaster;
	}

	public void setCompanyMaster(CompanyMaster companyMaster) {
		this.companyMaster = companyMaster;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public int getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
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

	/**
	 * @return the defaultPort
	 */
	public String getDefaultPort() {
		return defaultPort;
	}

	/**
	 * @param defaultPort the defaultPort to set
	 */
	public void setDefaultPort(String defaultPort) {
		this.defaultPort = defaultPort;
	}

	/**
	 * @return the baudRate
	 */
	public int getBaudRate() {
		return baudRate;
	}

	/**
	 * @param baudRate the baudRate to set
	 */
	public void setBaudRate(int baudRate) {
		this.baudRate = baudRate;
	}

	/**
	 * @return the numericKeyBoard
	 */
	public int getNumericKeyBoard() {
		return numericKeyBoard;
	}

	/**
	 * @param numericKeyBoard the numericKeyBoard to set
	 */
	public void setNumericKeyBoard(int numericKeyBoard) {
		this.numericKeyBoard = numericKeyBoard;
	}
	
	

	public int getIs_account() {
		return is_account;
	}

	public void setIs_account(int is_account) {
		this.is_account = is_account;
	}

	/**
	 * @return the isCustomerDisplay
	 */
	public int getIsCustomerDisplay() {
		return isCustomerDisplay;
	}

	/**
	 * @param isCustomerDisplay the isCustomerDisplay to set
	 */
	public void setIsCustomerDisplay(int isCustomerDisplay) {
		this.isCustomerDisplay = isCustomerDisplay;
	}
	
	/**
	 * @return the isSalesman
	 */
	public int getIsSalesman() {
		return isSalesman;
	}

	/**
	 * @param isSalesman the isSalesman to set
	 */
	public void setIsSalesman(int isSalesman) {
		this.isSalesman = isSalesman;
	}

	/**
	 * @return the isConversion
	 */
	public int getIsConversion() {
		return isConversion;
	}

	/**
	 * @param isConversion the isConversion to set
	 */
	public void setIsConversion(int isConversion) {
		this.isConversion = isConversion;
	}

	/**
	 * @return the isManufacturer
	 */
	public int getIsManufacturer() {
		return isManufacturer;
	}

	/**
	 * @param isManufacturer the isManufacturer to set
	 */
	public void setIsManufacturer(int isManufacturer) {
		this.isManufacturer = isManufacturer;
	}

	/**
	 * @return the isFree
	 */
	public int getIsFree() {
		return isFree;
	}

	/**
	 * @param isFree the isFree to set
	 */
	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}

	/**
	 * @return the isOnBillSale
	 */
	public int getIsOnBillSale() {
		return isOnBillSale;
	}

	/**
	 * @param isOnBillSale the isOnBillSale to set
	 */
	public void setIsOnBillSale(int isOnBillSale) {
		this.isOnBillSale = isOnBillSale;
	}

	/**
	 * @return the isOnBillPurchase
	 */
	public int getIsOnBillPurchase() {
		return isOnBillPurchase;
	}

	/**
	 * @param isOnBillPurchase the isOnBillPurchase to set
	 */
	public void setIsOnBillPurchase(int isOnBillPurchase) {
		this.isOnBillPurchase = isOnBillPurchase;
	}

	/**
	 * @return the isNewDisplay
	 */
	public int getIsNewDisplay() {
		return isNewDisplay;
	}

	/**
	 * @param isNewDisplay the isNewDisplay to set
	 */
	public void setIsNewDisplay(int isNewDisplay) {
		this.isNewDisplay = isNewDisplay;
	}
	
	

	public int getIsSaleman() {
		return isSaleman;
	}

	public void setIsSaleman(int isSaleman) {
		this.isSaleman = isSaleman;
	}

	public int getIsOptical() {
		return isOptical;
	}

	public void setIsOptical(int isOptical) {
		this.isOptical = isOptical;
	}

	public int getIsMrpEnable() {
		return isMrpEnable;
	}

	public void setIsMrpEnable(int isMrpEnable) {
		this.isMrpEnable = isMrpEnable;
	}

	public int getFinYrId() {
		return finYrId;
	}

	public void setFinYrId(int finYrId) {
		this.finYrId = finYrId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + baudRate;
		result = prime * result + ((companyMaster == null) ? 0 : companyMaster.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + createdBy;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + currencyId;
		result = prime * result + ((defaultPort == null) ? 0 : defaultPort.hashCode());
		result = prime * result + ((dlExpiryDate == null) ? 0 : dlExpiryDate.hashCode());
		result = prime * result + ((dlLicenceNo == null) ? 0 : dlLicenceNo.hashCode());
		result = prime * result + ((dlRegistrationDate == null) ? 0 : dlRegistrationDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result + id;
		result = prime * result + isActive;
		result = prime * result + isConversion;
		result = prime * result + isCustomerDisplay;
		result = prime * result + isDefault;
		result = prime * result + isDeleted;
		result = prime * result + isEsi;
		result = prime * result + isExclusive;
		result = prime * result + isFree;
		result = prime * result + isMailEnable;
		result = prime * result + isManufacturer;
		result = prime * result + isNewDisplay;
		result = prime * result + isOnBillPurchase;
		result = prime * result + isOnBillSale;
		result = prime * result + isOptical;
		result = prime * result + isSaleman;
		result = prime * result + isSalesman;
		result = prime * result + is_account;
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((mailPassword == null) ? 0 : mailPassword.hashCode());
		result = prime * result + ((mailPort == null) ? 0 : mailPort.hashCode());
		result = prime * result + ((mailSmtp == null) ? 0 : mailSmtp.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numericKeyBoard;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((stateExpiryDate == null) ? 0 : stateExpiryDate.hashCode());
		result = prime * result + ((stateLicenceNo == null) ? 0 : stateLicenceNo.hashCode());
		result = prime * result + ((stateRegistrationDate == null) ? 0 : stateRegistrationDate.hashCode());
		long temp;
		temp = Double.doubleToLongBits(taxPer);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((taxRegNo == null) ? 0 : taxRegNo.hashCode());
		result = prime * result + ((taxRegNoText == null) ? 0 : taxRegNoText.hashCode());
		result = prime * result + ((terminationDate == null) ? 0 : terminationDate.hashCode());
		result = prime * result + updatedBy;
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		temp = Double.doubleToLongBits(vatPer);
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
		StoreMaster other = (StoreMaster) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (baudRate != other.baudRate)
			return false;
		if (companyMaster == null) {
			if (other.companyMaster != null)
				return false;
		} else if (!companyMaster.equals(other.companyMaster))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (createdBy != other.createdBy)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (currencyId != other.currencyId)
			return false;
		if (defaultPort == null) {
			if (other.defaultPort != null)
				return false;
		} else if (!defaultPort.equals(other.defaultPort))
			return false;
		if (dlExpiryDate == null) {
			if (other.dlExpiryDate != null)
				return false;
		} else if (!dlExpiryDate.equals(other.dlExpiryDate))
			return false;
		if (dlLicenceNo == null) {
			if (other.dlLicenceNo != null)
				return false;
		} else if (!dlLicenceNo.equals(other.dlLicenceNo))
			return false;
		if (dlRegistrationDate == null) {
			if (other.dlRegistrationDate != null)
				return false;
		} else if (!dlRegistrationDate.equals(other.dlRegistrationDate))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (isConversion != other.isConversion)
			return false;
		if (isCustomerDisplay != other.isCustomerDisplay)
			return false;
		if (isDefault != other.isDefault)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (isEsi != other.isEsi)
			return false;
		if (isExclusive != other.isExclusive)
			return false;
		if (isFree != other.isFree)
			return false;
		if (isMailEnable != other.isMailEnable)
			return false;
		if (isManufacturer != other.isManufacturer)
			return false;
		if (isNewDisplay != other.isNewDisplay)
			return false;
		if (isOnBillPurchase != other.isOnBillPurchase)
			return false;
		if (isOnBillSale != other.isOnBillSale)
			return false;
		if (isOptical != other.isOptical)
			return false;
		if (isSaleman != other.isSaleman)
			return false;
		if (isSalesman != other.isSalesman)
			return false;
		if (is_account != other.is_account)
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (mailPassword == null) {
			if (other.mailPassword != null)
				return false;
		} else if (!mailPassword.equals(other.mailPassword))
			return false;
		if (mailPort == null) {
			if (other.mailPort != null)
				return false;
		} else if (!mailPort.equals(other.mailPort))
			return false;
		if (mailSmtp == null) {
			if (other.mailSmtp != null)
				return false;
		} else if (!mailSmtp.equals(other.mailSmtp))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numericKeyBoard != other.numericKeyBoard)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (stateExpiryDate == null) {
			if (other.stateExpiryDate != null)
				return false;
		} else if (!stateExpiryDate.equals(other.stateExpiryDate))
			return false;
		if (stateLicenceNo == null) {
			if (other.stateLicenceNo != null)
				return false;
		} else if (!stateLicenceNo.equals(other.stateLicenceNo))
			return false;
		if (stateRegistrationDate == null) {
			if (other.stateRegistrationDate != null)
				return false;
		} else if (!stateRegistrationDate.equals(other.stateRegistrationDate))
			return false;
		if (Double.doubleToLongBits(taxPer) != Double.doubleToLongBits(other.taxPer))
			return false;
		if (taxRegNo == null) {
			if (other.taxRegNo != null)
				return false;
		} else if (!taxRegNo.equals(other.taxRegNo))
			return false;
		if (taxRegNoText == null) {
			if (other.taxRegNoText != null)
				return false;
		} else if (!taxRegNoText.equals(other.taxRegNoText))
			return false;
		if (terminationDate == null) {
			if (other.terminationDate != null)
				return false;
		} else if (!terminationDate.equals(other.terminationDate))
			return false;
		if (updatedBy != other.updatedBy)
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (Double.doubleToLongBits(vatPer) != Double.doubleToLongBits(other.vatPer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StoreMaster [id=" + id + ", companyMaster=" + companyMaster + ", name=" + name + ", registrationDate="
				+ registrationDate + ", terminationDate=" + terminationDate + ", currencyId=" + currencyId
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", address=" + address + ", state=" + state
				+ ", country=" + country + ", postcode=" + postcode + ", email=" + email + ", phone=" + phone + ", fax="
				+ fax + ", isActive=" + isActive + ", isDeleted=" + isDeleted + ", createdBy=" + createdBy
				+ ", createdDate=" + createdDate + ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate
				+ ", isDefault=" + isDefault + ", dlLicenceNo=" + dlLicenceNo + ", dlRegistrationDate="
				+ dlRegistrationDate + ", dlExpiryDate=" + dlExpiryDate + ", stateLicenceNo=" + stateLicenceNo
				+ ", stateRegistrationDate=" + stateRegistrationDate + ", stateExpiryDate=" + stateExpiryDate
				+ ", taxRegNo=" + taxRegNo + ", taxPer=" + taxPer + ", vatPer=" + vatPer + ", isMailEnable="
				+ isMailEnable + ", mailPassword=" + mailPassword + ", mailPort=" + mailPort + ", mailSmtp=" + mailSmtp
				+ ", taxRegNoText=" + taxRegNoText + ", isExclusive=" + isExclusive + ", isEsi=" + isEsi
				+ ", defaultPort=" + defaultPort + ", baudRate=" + baudRate + ", numericKeyBoard=" + numericKeyBoard
				+ ", is_account=" + is_account + ", isCustomerDisplay=" + isCustomerDisplay + ", isSalesman="
				+ isSalesman + ", isConversion=" + isConversion + ", isManufacturer=" + isManufacturer + ", isFree="
				+ isFree + ", isOnBillSale=" + isOnBillSale + ", isOnBillPurchase=" + isOnBillPurchase
				+ ", isNewDisplay=" + isNewDisplay + ", isSaleman=" + isSaleman + ", isOptical=" + isOptical
				+ ", isMrpEnable=" + isMrpEnable + ", finYrId=" + finYrId + "]";
	}

}