package com.resustainability.reisp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BMW {
	
private String company,plant,CustomerDistrict,user_id,password,repulled,user_ip,msg,PTC_status,CustomerTown,CustomerName,CustomerCABSCode,CustomerSAPCode,
	TypeofEstablishment,ActualVisitDate,ActualVisitMonth,ActualVisitYear,VisitDayTime,BlueCount,BlueWeight,
	RedCount,RedWeight,YellowCount,YellowWeight,CytotoxicCount,CytotoxicWeight,WhitesCount,WhitesWeight,TotalCount,Logs,
	CollectionLatitude,ServerDateTime,uniqueID,Active;

	

	@JsonProperty("BATCHID")
	private String APIID;
	
	@JsonProperty("Active")
	private String CustomerStatus;
	
	
	@JsonProperty("id")
	private String CabsTransID;
	
	@JsonProperty("Log")
	private String Log;
	
	@JsonProperty("Count")
	private String Count;
	
	@JsonProperty("ManifestNo")
	private String ManifestNo;
	
	@JsonProperty("VehicleRegNo")
	private String VehicleRegNo;
	
	@JsonProperty("ServiceFrequency")
	private String ServiceFrequency;
	
	@JsonProperty("APIType")
	private String APIType;
	
	@JsonProperty("TotalWeight")
	private String TotalWeight;
	
	@JsonProperty("CollectionLongitude")
	private String CollectionLongitude;

	@JsonProperty("DistrictName")
	private String DistrictName;
	
	@JsonProperty("Lat")
	private String Lat;
	
	@JsonProperty("Lon")
	private String Lon;
	
	@JsonProperty("Vehicle_Name")
	private String route;
	
	@JsonProperty("Yellow_Weight")
	private String Yellow_Weight;
	
	@JsonProperty("Cytotoxic_Count")
	private String Cytotoxic_Count;
	
	@JsonProperty("Total_Weight")
	private String Total_Weight;
	
	@JsonProperty("Partner_Id")
	private String Partner_Id;
	
	@JsonProperty("Whites_Weight")
	private String Whites_Weight;
	
	@JsonProperty("Blue_Count")
	private String Blue_Count;
	
	@JsonProperty("PlantLocation")
	private String PlantLocation;
	
	@JsonProperty("Red_Weight")
	private String Red_Weight;
	
	@JsonProperty("Blue_Weight")
	private String Blue_Weight;
	
	@JsonProperty("TownName")
	private String TownName;
	
	@JsonProperty("Sap_Id")
	private String Sap_Id;
	
	@JsonProperty("Partner_Name")
	private String Partner_Name;
	
	@JsonProperty("Total_Count")
	private String Total_Count;
	
	@JsonProperty("Month")
	private String Month;
	@JsonProperty("Yellow_Count")
	private String Yellow_Count;
	
	@JsonProperty("Cytotoxic_Weight")
	private String Cytotoxic_Weight;
	
	@JsonProperty("Red_Count")
	private String Red_Count;
	
	@JsonProperty("Establishment_Type")
	private String Establishment_Type;
	
	@JsonProperty("Year")
	private String Year;
	@JsonProperty("Date")
	private String Date;
	
	@JsonProperty("PlantName")
	private String PlantName;
	
	@JsonProperty("Whites_Count")
	private String Whites_Count;
	
	@JsonProperty("Visit_Date")
	private String VisitDate;
	
	public String getActive() {
		return Active;
	}

	public void setActive(String active) {
		Active = active;
	}

	public String getCustomerStatus() {
		return CustomerStatus;
	}

	public void setCustomerStatus(String customerStatus) {
		CustomerStatus = customerStatus;
	}

	public String getAPIID() {
		return APIID;
	}

	public void setAPIID(String APIID) {
		this.APIID = APIID;
	}
	
public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

public String getLogs() {
		return Logs;
	}

	public void setLogs(String logs) {
		Logs = logs;
	}

public String getCabsTransID() {
		return CabsTransID;
	}

	public void setCabsTransID(String cabsTransID) {
		CabsTransID = cabsTransID;
	}



public String getLog() {
		return Log;
	}

	public void setLog(String log) {
		Log = log;
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

public BMW() {
}

public String getLon() {
	return Lon;
}

public void setLon(String lon) {
	Lon = lon;
}

public String getDistrictName() {
	return DistrictName;
}

public void setDistrictName(String districtName) {
	DistrictName = districtName;
}

public String getLat() {
	return Lat;
}

public void setLat(String lat) {
	Lat = lat;
}


public String getYellow_Weight() {
	return Yellow_Weight;
}

public void setYellow_Weight(String yellow_Weight) {
	Yellow_Weight = yellow_Weight;
}

public String getCytotoxic_Count() {
	return Cytotoxic_Count;
}

public void setCytotoxic_Count(String cytotoxic_Count) {
	Cytotoxic_Count = cytotoxic_Count;
}

public String getTotal_Weight() {
	return Total_Weight;
}

public void setTotal_Weight(String total_Weight) {
	Total_Weight = total_Weight;
}



public String getPartner_Id() {
	return Partner_Id;
}

public void setPartner_Id(String partner_Id) {
	Partner_Id = partner_Id;
}

public String getWhites_Weight() {
	return Whites_Weight;
}

public void setWhites_Weight(String whites_Weight) {
	Whites_Weight = whites_Weight;
}

public String getBlue_Count() {
	return Blue_Count;
}

public void setBlue_Count(String blue_Count) {
	Blue_Count = blue_Count;
}

public String getPlantLocation() {
	return PlantLocation;
}

public void setPlantLocation(String plantLocation) {
	PlantLocation = plantLocation;
}

public String getRed_Weight() {
	return Red_Weight;
}

public void setRed_Weight(String Red_Weight) {
	this.Red_Weight = Red_Weight;
}

public String getBlue_Weight() {
	return Blue_Weight;
}

public void setBlue_Weight(String blue_Weight) {
	Blue_Weight = blue_Weight;
}

public String getTownName() {
	return TownName;
}

public void setTownName(String townName) {
	TownName = townName;
}

public String getSap_Id() {
	return Sap_Id;
}

public void setSap_Id(String sap_Id) {
	Sap_Id = sap_Id;
}

public String getPartner_Name() {
	return Partner_Name;
}

public void setPartner_Name(String partner_Name) {
	Partner_Name = partner_Name;
}

public String getTotal_Count() {
	return Total_Count;
}

public void setTotal_Count(String total_Count) {
	Total_Count = total_Count;
}

public String getMonth() {
	return Month;
}

public void setMonth(String month) {
	Month = month;
}

public String getYellow_Count() {
	return Yellow_Count;
}

public void setYellow_Count(String yellow_Count) {
	Yellow_Count = yellow_Count;
}

public String getCytotoxic_Weight() {
	return Cytotoxic_Weight;
}

public void setCytotoxic_Weight(String cytotoxic_Weight) {
	Cytotoxic_Weight = cytotoxic_Weight;
}

public String getRed_Count() {
	return Red_Count;
}

public void setRed_Count(String Red_Count) {
	this.Red_Count = Red_Count;
}

public String getEstablishment_Type() {
	return Establishment_Type;
}

public void setEstablishment_Type(String establishment_Type) {
	Establishment_Type = establishment_Type;
}

public String getYear() {
	return Year;
}

public void setYear(String year) {
	Year = year;
}

public String getDate() {
	return Date;
}

public void setDate(String date) {
	Date = date;
}

public String getPlantName() {
	return PlantName;
}

public void setPlantName(String plantName) {
	PlantName = plantName;
}

public String getWhites_Count() {
	return Whites_Count;
}

public void setWhites_Count(String whites_Count) {
	Whites_Count = whites_Count;
}

public String getVisitDate() {
	return VisitDate;
}

public void setVisitDate(String visitDate) {
	VisitDate = visitDate;
}


public String getRepulled() {
	return repulled;
}

public void setRepulled(String repulled) {
	this.repulled = repulled;
}

public String getUser_ip() {
	return user_ip;
}

public void setUser_ip(String user_ip) {
	this.user_ip = user_ip;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public String getPTC_status() {
	return PTC_status;
}

public void setPTC_status(String pTC_status) {
	PTC_status = pTC_status;
}

public String getUser_id() {
	return user_id;
}

public void setUser_id(String user_id) {
	this.user_id = user_id;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getPlant() {
	return plant;
}

public void setPlant(String plant) {
	this.plant = plant;
}

public String getRoute() {
	return route;
}

public void setRoute(String route) {
	this.route = route;
}

public String getCustomerDistrict() {
	return CustomerDistrict;
}

public void setCustomerDistrict(String customerDistrict) {
	CustomerDistrict = customerDistrict;
}

public String getCustomerTown() {
	return CustomerTown;
}

public void setCustomerTown(String customerTown) {
	CustomerTown = customerTown;
}

public String getVehicleRegNo() {
	return VehicleRegNo;
}

public void setVehicleRegNo(String vehicleRegNo) {
	VehicleRegNo = vehicleRegNo;
}

public String getCustomerName() {
	return CustomerName;
}

public void setCustomerName(String customerName) {
	CustomerName = customerName;
}

public String getCustomerCABSCode() {
	return CustomerCABSCode;
}

public void setCustomerCABSCode(String customerCABSCode) {
	CustomerCABSCode = customerCABSCode;
}

public String getCustomerSAPCode() {
	return CustomerSAPCode;
}

public void setCustomerSAPCode(String customerSAPCode) {
	CustomerSAPCode = customerSAPCode;
}

public String getTypeofEstablishment() {
	return TypeofEstablishment;
}

public void setTypeofEstablishment(String typeofEstablishment) {
	TypeofEstablishment = typeofEstablishment;
}

public String getManifestNo() {
	return ManifestNo;
}

public void setManifestNo(String manifestNo) {
	ManifestNo = manifestNo;
}

public String getActualVisitDate() {
	return ActualVisitDate;
}

public void setActualVisitDate(String actualVisitDate) {
	ActualVisitDate = actualVisitDate;
}

public String getActualVisitMonth() {
	return ActualVisitMonth;
}

public void setActualVisitMonth(String actualVisitMonth) {
	ActualVisitMonth = actualVisitMonth;
}

public String getActualVisitYear() {
	return ActualVisitYear;
}

public void setActualVisitYear(String actualVisitYear) {
	ActualVisitYear = actualVisitYear;
}

public String getVisitDayTime() {
	return VisitDayTime;
}

public void setVisitDayTime(String visitDayTime) {
	VisitDayTime = visitDayTime;
}

public String getServiceFrequency() {
	return ServiceFrequency;
}

public void setServiceFrequency(String serviceFrequency) {
	ServiceFrequency = serviceFrequency;
}

public String getBlueCount() {
	return BlueCount;
}

public void setBlueCount(String blueCount) {
	BlueCount = blueCount;
}

public String getBlueWeight() {
	return BlueWeight;
}

public void setBlueWeight(String blueWeight) {
	BlueWeight = blueWeight;
}

public String getRedCount() {
	return RedCount;
}

public void setRedCount(String redCount) {
	RedCount = redCount;
}

public String getRedWeight() {
	return RedWeight;
}

public void setRedWeight(String redWeight) {
	RedWeight = redWeight;
}

public String getYellowCount() {
	return YellowCount;
}

public void setYellowCount(String yellowCount) {
	YellowCount = yellowCount;
}

public String getYellowWeight() {
	return YellowWeight;
}

public void setYellowWeight(String yellowWeight) {
	YellowWeight = yellowWeight;
}

public String getCytotoxicCount() {
	return CytotoxicCount;
}

public void setCytotoxicCount(String cytotoxicCount) {
	CytotoxicCount = cytotoxicCount;
}

public String getCytotoxicWeight() {
	return CytotoxicWeight;
}

public void setCytotoxicWeight(String cytotoxicWeight) {
	CytotoxicWeight = cytotoxicWeight;
}

public String getWhitesCount() {
	return WhitesCount;
}

public void setWhitesCount(String whitesCount) {
	WhitesCount = whitesCount;
}

public String getWhitesWeight() {
	return WhitesWeight;
}

public void setWhitesWeight(String whitesWeight) {
	WhitesWeight = whitesWeight;
}

public String getTotalCount() {
	return TotalCount;
}

public void setTotalCount(String totalCount) {
	TotalCount = totalCount;
}

public String getTotalWeight() {
	return TotalWeight;
}

public void setTotalWeight(String totalWeight) {
	TotalWeight = totalWeight;
}

public String getCollectionLatitude() {
	return CollectionLatitude;
}

public void setCollectionLatitude(String collectionLatitude) {
	CollectionLatitude = collectionLatitude;
}

public String getCollectionLongitude() {
	return CollectionLongitude;
}

public void setCollectionLongitude(String collectionLongitude) {
	CollectionLongitude = collectionLongitude;
}

public String getServerDateTime() {
	return ServerDateTime;
}

public void setServerDateTime(String serverDateTime) {
	ServerDateTime = serverDateTime;
}

public String getAPIType() {
	return APIType;
}

public void setAPIType(String APIType) {
	this.APIType = APIType;
}



}
