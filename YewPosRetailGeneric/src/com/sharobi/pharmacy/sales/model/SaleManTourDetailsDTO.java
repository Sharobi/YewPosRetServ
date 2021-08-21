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
public class SaleManTourDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Expose
	@MapToData(columnAliases = { "tourplan_id" })
	private int tourPlanId;

	@Expose
	@MapToData(columnAliases = { "salesman_id" })
	private int salesmanId;

	@Expose
	@MapToData(columnAliases = { "tour_date" })
	private Date tourDate;
	
	@Expose
	@MapToData(columnAliases = { "tour_time" })
	private String tourTime;
	
	@Expose
	@MapToData(columnAliases = { "latitude" })
	private String latitude;
	
	@Expose
	@MapToData(columnAliases = { "longitude" })
	private String longitude;
	
	@Expose
	@MapToData(columnAliases = { "tour_type" })
	private String tourType;
	
	@Expose
	@MapToData(columnAliases = { "imei_no" })
	private String imeiNo;
	
	@Expose
	@MapToData(columnAliases = { "company_id" })
	private String companyId;
	
	@Expose
	@MapToData(columnAliases = { "store_id" })
	private String storeId;
	
	@Expose
	@MapToData(columnAliases = { "finyr_id" })
	private String finyrId;

	public int getTourPlanId() {
		return tourPlanId;
	}

	public void setTourPlanId(int tourPlanId) {
		this.tourPlanId = tourPlanId;
	}

	public int getSalesmanId() {
		return salesmanId;
	}

	public void setSalesmanId(int salesmanId) {
		this.salesmanId = salesmanId;
	}

	public Date getTourDate() {
		return tourDate;
	}

	public void setTourDate(Date tourDate) {
		this.tourDate = tourDate;
	}

	public String getTourTime() {
		return tourTime;
	}

	public void setTourTime(String tourTime) {
		this.tourTime = tourTime;
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

	public String getTourType() {
		return tourType;
	}

	public void setTourType(String tourType) {
		this.tourType = tourType;
	}

	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public String getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(String finyrId) {
		this.finyrId = finyrId;
	}

	@Override
	public String toString() {
		return "SaleManTourDetailsDTO [tourPlanId=" + tourPlanId + ", salesmanId=" + salesmanId + ", tourDate="
				+ tourDate + ", tourTime=" + tourTime + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", tourType=" + tourType + ", imeiNo=" + imeiNo + ", companyId=" + companyId + ", storeId=" + storeId
				+ ", finyrId=" + finyrId + "]";
	}
	
	

}
