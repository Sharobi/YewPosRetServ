/**
 * 
 */
package com.sharobi.pharmacy.sales.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * @author Habib
 *
 */
@XmlRootElement
public class SaleManTour implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int companyId;
	private int storeId;
	private int finyrId;

	private List<SaleManTourDetails> saleManTourDetails;

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

	public int getFinyrId() {
		return finyrId;
	}

	public void setFinyrId(int finyrId) {
		this.finyrId = finyrId;
	}

	public List<SaleManTourDetails> getSaleManTourDetails() {
		return saleManTourDetails;
	}

	public void setSaleManTourDetails(List<SaleManTourDetails> saleManTourDetails) {
		this.saleManTourDetails = saleManTourDetails;
	}

	@Override
	public String toString() {
		return "SaleManTour [companyId=" + companyId + ", storeId=" + storeId + ", finyrId=" + finyrId
				+ ", saleManTourDetails=" + saleManTourDetails + "]";
	}
	
	
	
	
	
	

}
