package com.resustainability.reisp.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.resustainability.reisp.common.DateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.resustainability.reisp.model.BMW;
import com.resustainability.reisp.model.BrainBox;
import com.resustainability.reisp.model.SBU;

@Repository
public class BMWDao {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	@Autowired
	DataSourceTransactionManager transactionManager;

	public List<BrainBox> getHydCNDList(SBU obj1, BrainBox obj, HttpServletResponse response) throws Exception{
		List<BrainBox> menuList = null;
		boolean flag = false;
		int count = 0;
		try{  
			String user_id = "recgwbbmw";
			String password = "X1298extvbddyzA";
			//String Myip = Inet4Address.getLocalHost().getHostAddress();
			String Myip = "10.100.3.11";
			String time = " 12:00:00AM";
			String IP [] = {"10.2.24.18","10.2.24.81","10.2.28.164","196.12.46.130","117.200.48.237","112.133.222.124","61.0.227.124","14.99.138.146","34.93.149.251",Myip}; 
			if(IP.length > 0) {
				for(int i=0; i< IP.length; i++) {
					if(IP[i].contentEquals(Myip)  ) {
						if(user_id.contentEquals(obj1.getUser_id()) && password.contentEquals(obj1.getPassword())) {
							flag = true;
						}
					}
				}
				System.out.println(flag);
			}
			if(flag) {
			String qry = "SELECT SITEID as TransactionNo1,Trno as TransactionNo2,TRANSPORTER as Transporter,PARTY as Transferstation, Vehicleno as VehicleNo, Material as Zone, "
					+ "Party as Location, Transporter as Transporter, LEFT(CONVERT(varchar, Datein, 24),9) AS DateIN, "
					+ "RIGHT(CONVERT(varchar, Timein, 24),11) AS TimeIN, LEFT(CONVERT(varchar, Dateout, 24),9) AS DateOUT, "
					+ "RIGHT(CONVERT(varchar, Timeout, 24),11) AS TimeOUT,Firstweight as GROSSWeight, SiteID, Secondweight as TareWeight,"
					+ "NetWT as NetWeight, typeofwaste AS TypeofMaterial FROM weight WITH (nolock) "
					+ "WHERE (Trno IS NOT NULL) AND (Vehicleno IS NOT NULL) AND (Datein IS NOT NULL)"
					+ "AND (Timein IS NOT NULL) AND (Firstweight IS NOT NULL) AND (Dateout IS NOT NULL) AND "
					+ "(Timeout IS NOT NULL) AND (Secondweight IS NOT NULL) AND (NetWT IS NOT NULL) and(SiteID is not null) AND SITEID IN"
					+ "('WB1','WB2','WB3')  and NetWT <> '' and NetWT is not null ";
					int arrSize = 0;
				    if(!StringUtils.isEmpty(obj1) && !StringUtils.isEmpty(obj1.getFrom_date())) {
				    	qry = qry + " AND CONVERT(varchar(10), DATEOUT, 105) = CONVERT(varchar(10), ?, 105) ";
						arrSize++;
					}
					qry = qry +"  ORDER BY TRNO desc "; 
					Object[] pValues = new Object[arrSize];
					int i = 0;
					if(!StringUtils.isEmpty(obj1) && !StringUtils.isEmpty(obj1.getFrom_date())) {
						pValues[i++] = obj1.getFrom_date()+time;;
					}
			menuList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<BrainBox>(BrainBox.class));
		}else {
			menuList = new ArrayList<BrainBox>(1);
		}
		}catch(Exception e){ 
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return menuList;
	}

	public Object getLogsOfResults(List<BrainBox> hydList, SBU obj1) throws SQLException {
		int count = 0;
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			if(hydList.size() > 0) {
				for(BrainBox obj : hydList) {
					obj.setGROSSWeight(obj1.getPTC_status());
					obj.setTareWeight(obj1.getMSG());
					obj.setDateOUT(obj1.getUser_ip());					
					String insertQry = "INSERT INTO [hyd_logs] (user_ip,weight_TRNO,VEHICLENO,PTC_status,PTCDT,MSG)"
							+ " values (:dateOUT,:TransactionNo2,:VehicleNo,:GROSSWeight,GETDATE(),:TareWeight)  ";
					
					BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
				    count = namedParamJdbcTemplate.update(insertQry, paramSource);
				}
			}else {
				BrainBox obj = new BrainBox();
				obj.setGROSSWeight(null);
				obj.setTareWeight(obj1.getMSG());
				obj.setDateOUT(obj1.getUser_ip());		
				String insertQry = "INSERT INTO [hyd_logs] (user_ip,weight_TRNO,VEHICLENO,PTC_status,PTCDT,MSG) values (:dateOUT,:TransactionNo2,:VehicleNo,:GROSSWeight,GETDATE(),:TareWeight)  "
				+ " ";
				
				BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
			    count = namedParamJdbcTemplate.update(insertQry, paramSource);
			}
		
			
		}catch(Exception e){ 
			e.printStackTrace();
			throw new SQLException(e.getMessage());
			
		}
		return count;
	}

	public int getLogInfo(SBU obj1, BrainBox obj, List<BrainBox> companiesList) throws SQLException {
		int count = 0;
		try{  
			if(!StringUtils.isEmpty(companiesList) && companiesList.size() > 0) {
				for (BrainBox obj11 : companiesList) {
					String checkingLogQry = "SELECT count(*) from [hyd_logs] where weight_TRNO= ? and VEHICLENO= ?";
					count = jdbcTemplate.queryForObject(checkingLogQry, new Object[] {obj11.getTransactionNo2(),obj11.getVehicleNo()}, Integer.class);
				}
			}
		}catch(Exception e){ 
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return count;
	}

	public boolean pushBMWList(BMW obj1, BrainBox objs, List<BMW> pushedRecords, HttpServletResponse response) throws SQLException {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			if(!StringUtils.isEmpty(obj1)) {
				BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj1);
					obj1.setCabsTransID(obj1.getCabsTransID());
					obj1.setCustomerDistrict(obj1.getDistrictName());
					obj1.setCollectionLatitude(obj1.getLat());
					obj1.setCollectionLongitude(obj1.getLon());	

					obj1.setYellowWeight(obj1.getYellow_Weight());
					obj1.setServiceFrequency(obj1.getServiceFrequency());
					obj1.setCytotoxicCount(obj1.getCytotoxic_Count());	

					obj1.setTotalWeight(obj1.getTotal_Weight());
					obj1.setRoute(obj1.getRoute());
					obj1.setCustomerCABSCode(obj1.getPartner_Id());	

					obj1.setWhitesWeight(obj1.getWhites_Weight()); 
					obj1.setBlueCount(obj1.getBlue_Count());
					obj1.setPlant(obj1.getPlantLocation());	

					obj1.setVehicleRegNo(obj1.getVehicleRegNo());
					obj1.setRedWeight(obj1.getRed_Weight());
					obj1.setBlueWeight(obj1.getBlue_Weight());	

					obj1.setCustomerTown(obj1.getTownName());
					obj1.setCustomerSAPCode(obj1.getSap_Id());
					obj1.setCustomerName(obj1.getPartner_Name());	

					obj1.setTotalCount(obj1.getTotal_Count());
					obj1.setActualVisitMonth(obj1.getMonth());
					obj1.setYellowCount(obj1.getYellow_Count());	

					obj1.setCytotoxicWeight(obj1.getCytotoxic_Weight());
					obj1.setRedCount(obj1.getRed_Count());
					obj1.setTypeofEstablishment(obj1.getEstablishment_Type());	

					obj1.setActualVisitYear(obj1.getYear());
					obj1.setVisitDayTime(DateParser.parseDateTime(obj1.getDate()));
					obj1.setManifestNo(obj1.getManifestNo());	

					obj1.setCompany(obj1.getPlantName());
					obj1.setWhitesCount(obj1.getWhites_Count());
					obj1.setAPIType(obj1.getAPIType());	
					obj1.setActualVisitDate(obj1.getVisitDate());
					
					String insertQry = "INSERT INTO [bmw_detailed] " 
							+ "(company,plant,route,CustomerDistrict,CustomerTown,VehicleRegNo,CustomerName,CustomerCABSCode,"
							+ "CustomerSAPCode,TypeofEstablishment,ManifestNo,ActualVisitDate,ActualVisitMonth,ActualVisitYear"
							+ ",VisitDayTime,ServiceFrequency,BlueCount,BlueWeight,RedCount,RedWeight,YellowCount,YellowWeight,"
							+ "CytotoxicCount,CytotoxicWeight,WhitesCount,WhitesWeight,TotalCount,TotalWeight,CollectionLatitude,"
							+ "CollectionLongitude,ServerDateTime,APIType,CabsTransID,APIID,CustomerStatus)"
							+ " VALUES"
							+ " (:company,:plant,:route,:CustomerDistrict,:CustomerTown,:VehicleRegNo,:CustomerName,"
							+ ":CustomerCABSCode,:CustomerSAPCode,:TypeofEstablishment,:ManifestNo,:ActualVisitDate,"
							+ ":ActualVisitMonth,:ActualVisitYear,:VisitDayTime,:ServiceFrequency,:BlueCount,:BlueWeight,"
							+ ":RedCount,:RedWeight,:YellowCount,:YellowWeight,:CytotoxicCount,:CytotoxicWeight,:WhitesCount,"
							+ ":WhitesWeight,:TotalCount,:TotalWeight,:CollectionLatitude,:CollectionLongitude,getdate(),"
							+ ":APIType,:CabsTransID,:APIID,:CustomerStatus)";
					
					paramSource = new BeanPropertySqlParameterSource(obj1);	 
				    count = namedParamJdbcTemplate.update(insertQry, paramSource);
				    if(count > 0) {
				    	flag = true;
				    }
				    if("start".equalsIgnoreCase(obj1.getLog())) {
				    	flag = true;
				    	obj1.setMsg("Success");
				    	obj1.setPTC_status("Y");
				    	String logQry = "INSERT INTO [bmw_logs] "
								+ "(APIID,	PTC_status,	PTCDT,	MSG, Logs )"
								+ " VALUES"
								+ " (	:APIID,	:PTC_status,	getdate(),	:Msg, :Log)";
						
						paramSource = new BeanPropertySqlParameterSource(obj1);		 
					    count = namedParamJdbcTemplate.update(logQry, paramSource);
				    }else if("end".equalsIgnoreCase(obj1.getLog())) {
				    	obj1.setMsg("Success");
				    	obj1.setPTC_status("Y");
				    	String logQry = "INSERT INTO [bmw_logs] "
				    			+ "(	APIID,	PTC_status,	PTCDT,	MSG, Logs)"
								+ " VALUES"
								+ " (	:APIID,	:PTC_status,	getdate(),	:Msg, :Log)";
						
						paramSource = new BeanPropertySqlParameterSource(obj1);		 
					    count = namedParamJdbcTemplate.update(logQry, paramSource);
				    }
				}
			
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw new SQLException(e.getMessage());
			
		}
		return flag;
	}
	public int getCountOfRecords(BMW obj1) throws SQLException {
		int count = 0;
		try{  
			
					String checkingLogQry = "SELECT count(*) from [bmw_detailed] where CabsTransID = ? ";
					count = jdbcTemplate.queryForObject(checkingLogQry, new Object[] {obj1.getCabsTransID()}, Integer.class);
		}catch(Exception e){ 
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return count;
	}
}
