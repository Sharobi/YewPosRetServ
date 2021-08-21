package com.sharobi.pharmacy.inventory.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.Expose;

import net.sf.resultsetmapper.MapToData;

@XmlRootElement
public class SalesmanDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Expose
	@MapToData(columnAliases = { "id" })
	private int id;

	@Expose
	@MapToData(columnAliases = { "name" })
	private String name;
	
	@Expose
	@MapToData(columnAliases = {"emp_id"})
	private String empId;
	
	@Expose
	@MapToData(columnAliases = {"address"})
	private String address;
	
	@Expose
	@MapToData(columnAliases = {"country_id"})
	private int countryId;
	
	@Expose
	@MapToData(columnAliases = {"country_name"})
	private String countryName;
	
	@Expose
	@MapToData(columnAliases = {"state_id"})
	private int stateId;
	
	@Expose
	@MapToData(columnAliases = {"state_name"})
	private String stateName;
	
	@Expose
	@MapToData(columnAliases = {"city_id"})
	private int cityId;
	
	@Expose
	@MapToData(columnAliases = {"city_name"})
	private String cityName;
	
	@Expose
	@MapToData(columnAliases = {"pin"})
	private String pin;
	
	@Expose
	@MapToData(columnAliases = {"phone_no"})
	private String phoneNo;
	
	@Expose
	@MapToData(columnAliases = {"addhar_card_no"})
	private String addharCardNo;
	
	@Expose
	@MapToData(columnAliases = {"pan_no"})
	private String panNo;
	
	@Expose
	@MapToData(columnAliases = {"commission_percentage"})
	private double commissionPercentage;
}
