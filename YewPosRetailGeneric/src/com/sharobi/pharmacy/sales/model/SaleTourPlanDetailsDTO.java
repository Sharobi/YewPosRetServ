/**
 * 
 */
package com.sharobi.pharmacy.sales.model;

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
public class SaleTourPlanDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "tourplan_id" })
	private int tourPlanId;

	@Expose
	@MapToData(columnAliases = { "tourplan_no" })
	private String tourPlanNo;

	@Expose
	@MapToData(columnAliases = { "tour_date" })
	private Date tourDate;
	
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
	@MapToData(columnAliases = { "city_id" })
	private int cityId;
	
	@Expose
	@MapToData(columnAliases = { "city_name" })
	private String cityName;
	
	@Expose
	@MapToData(columnAliases = { "zone_id" })
	private int zoneId;
	
	@Expose
	@MapToData(columnAliases = { "zone_name" })
	private String zoneName;
	
	@Expose
	@MapToData(columnAliases = { "area_id" })
	private int areaid;
	
	@Expose
	@MapToData(columnAliases = { "area_name" })
	private String areaName;

	public int getTourPlanId() {
		return tourPlanId;
	}

	public void setTourPlanId(int tourPlanId) {
		this.tourPlanId = tourPlanId;
	}

	public String getTourPlanNo() {
		return tourPlanNo;
	}

	public void setTourPlanNo(String tourPlanNo) {
		this.tourPlanNo = tourPlanNo;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
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

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getZoneId() {
		return zoneId;
	}

	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public int getAreaid() {
		return areaid;
	}

	public void setAreaid(int areaid) {
		this.areaid = areaid;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	@Override
	public String toString() {
		return "SaleTourPlanDetailsDTO [tourPlanId=" + tourPlanId + ", tourPlanNo=" + tourPlanNo + ", tourDate="
				+ tourDate + ", customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerPhone=" + customerPhone + ", cityId=" + cityId + ", cityName=" + cityName
				+ ", zoneId=" + zoneId + ", zoneName=" + zoneName + ", areaid=" + areaid + ", areaName=" + areaName
				+ "]";
	}

	
	
	
}
