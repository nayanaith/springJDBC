package com.gfs.integration.glazier.automation.dao;
/**
 * This interface defines the query methods used for 
 * Glazier Ship-to Address Information to GFS Customer Unit Site Information
 * @author v7vyo
 * */
public interface GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao {
	public int countGlazierCust();
	
	public int crmSiteGlazierRecords();
	
	public int bilingAgntStgCrmSite();
	
	public int targetAgntStgCrmSite();
	
	public int stgInvalidCustomerSiteRecords();
	
	public int trgtInvalidCustomerSiteRecords();
	
}//end GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao
