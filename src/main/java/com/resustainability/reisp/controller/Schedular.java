package com.resustainability.reisp.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.resustainability.reisp.model.DashBoardWeighBridge;
import com.resustainability.reisp.service.BMWService;


@Controller
public class Schedular {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    } 
	public static Logger logger = Logger.getLogger(Schedular.class);
	
	@Autowired
	LoginController loginController;
	
	@Autowired
	
	@Value("${common.error.message}")
	public String commonError;
	
	@Value("${run.cron.jobs}")
	public boolean is_cron_jobs_enabled;
	
	@Value("${run.cron.jobs.in.qa}")
	public boolean is_cron_jobs_enabled_in_qa;
	
	@Autowired
	BMWService service;
	
	
	/**********************************************************************************/
	
	@Scheduled(cron = "${cron.expression.run.procedures}")
	public void userLoginTimeout(){
		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
			try {
				List <DashBoardWeighBridge> trasactionsList = service.getSpacesOutFromTablesList(null);
		    	 System.out.println("cronJob Called!!!!");
			 } catch (Exception e) {
				 e.printStackTrace();
				 logger.error("userLoginTimeout() : "+e.getMessage());
			 }
		}
	}
	/**********************************************************************************/	
	
}
