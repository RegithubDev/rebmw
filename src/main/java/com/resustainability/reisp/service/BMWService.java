package com.resustainability.reisp.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.resustainability.reisp.dao.BMWDao;
import com.resustainability.reisp.model.BMW;
import com.resustainability.reisp.model.BrainBox;
import com.resustainability.reisp.model.SBU;

@Service
public class BMWService {

	@Autowired
	BMWDao dao;

	public List<BrainBox> getHydCNDList(SBU obj1, BrainBox obj, HttpServletResponse response)  throws Exception{
		return dao.getHydCNDList(obj1,obj,response);
	}

	public Object getLogsOfResults(List<BrainBox> hydList, SBU obj1) throws Exception{
		return dao.getLogsOfResults(hydList,obj1);
		
	}

	public int getLogInfo(SBU obj1, BrainBox obj, List<BrainBox> companiesList) throws SQLException {
		return dao.getLogInfo(obj1,obj,companiesList);
		
	}

	public boolean pushBMWList(BMW obj1, BrainBox obj, List<BMW> pushedRecords, HttpServletResponse response) throws SQLException {
		return dao.pushBMWList(obj1,obj,pushedRecords,response);
	}

	public int getCountOfRecords(BMW obj1) throws SQLException{
		return dao.getCountOfRecords(obj1);
	}
}
