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
@Table(name = "sal_t_salesman_tour_details")
public class SaleManTourDetails implements Serializable {

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
	@Column(name = "salesman_id")
	private int salesmanId;
	
	@Expose
	@Column(name = "latitude")
	private double latitude;
	
	@Expose
	@Column(name = "longitude")
	private double longitude;

	@Expose
	@Column(name = "tour_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tourDate;
	
	@Expose
	@Column(name = "tour_time")
	private String tourTime;
	
	@Expose
	@Column(name = "tour_type")
	private String tourType;
	
	@Expose
	@Column(name = "imei_no")
	private String imeiNo;

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

	public int getSalesmanId() {
		return salesmanId;
	}

	@XmlElement
	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
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

	public Date getTourDate() {
		return tourDate;
	}

	@XmlElement
	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public String getTourTime() {
		return tourTime;
	}

	@XmlElement
	public void setTourTime(String tourTime) {
		this.tourTime = tourTime;
	}

	public String getTourType() {
		return tourType;
	}

	@XmlElement
	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	@XmlElement
	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
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

	@Override
	public String toString() {
		return "SaleManTourDetails [id=" + id + ", tourPlanId=" + tourPlanId + ", salesmanId=" + salesmanId
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", tourDate=" + tourDate + ", tourTime="
				+ tourTime + ", tourType=" + tourType + ", imeiNo=" + imeiNo + ", finyrId=" + finyrId + ", storeId="
				+ storeId + ", companyId=" + companyId + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + "]";
	}
	
	

}
