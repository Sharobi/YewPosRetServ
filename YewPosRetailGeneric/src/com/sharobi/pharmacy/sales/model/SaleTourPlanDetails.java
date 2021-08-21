/**
 * 
 */
package com.sharobi.pharmacy.sales.model;

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
 * @author Habib
 *
 */
@XmlRootElement
@Entity
@Table(name = "sal_t_salestourplan_details")
public class SaleTourPlanDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Expose
	@Column(name = "tourplan_id")
	private int tourPlanId;

	@Expose
	@Column(name = "tourplan_no")
	private String tourPlanNo;

	@Expose
	@Column(name = "tour_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tourDate;

	@Expose
	@Column(name = "city_id")
	private int cityId;
	
	@Expose
	@Column(name = "zone_id")
	private int zoneId;
	
	@Expose
	@Column(name = "area_id")
	private int areaId;
	
	@Expose
	@Column(name = "customer_id")
	private int customerId;
	
	@Expose
	@Column(name = "latitude")
	private double latitude;
	
	@Expose
	@Column(name = "longitude")
	private double longitude;
	
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

	public int getTourPlanId() {
		return tourPlanId;
	}

	@XmlElement
	public void setTourPlanId(int tourPlanId) {
		this.tourPlanId = tourPlanId;
	}

	public String getTourPlanNo() {
		return tourPlanNo;
	}

	@XmlElement
	public void setTourPlanNo(String tourPlanNo) {
		this.tourPlanNo = tourPlanNo;
	}

	public Date getTourDate() {
		return tourDate;
	}

	@XmlElement
	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public int getCityId() {
		return cityId;
	}

	@XmlElement
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getZoneId() {
		return zoneId;
	}

	@XmlElement
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}

	public int getAreaId() {
		return areaId;
	}

	@XmlElement
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public double getLatitude() {
		return latitude;
	}

	@XmlElement
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@XmlElement
	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
	
	public int getCustomerId() {
		return customerId;
	}

	@XmlElement
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "SaleTourPlanDetails [id=" + id + ", tourPlanId=" + tourPlanId + ", tourPlanNo=" + tourPlanNo
				+ ", tourDate=" + tourDate + ", cityId=" + cityId + ", zoneId=" + zoneId + ", areaId=" + areaId
				+ ", customerId=" + customerId + ", latitude=" + latitude + ", longitude=" + longitude + ", finyrId="
				+ finyrId + ", storeId=" + storeId + ", companyId=" + companyId + "]";
	}

	
	
	

	
}
