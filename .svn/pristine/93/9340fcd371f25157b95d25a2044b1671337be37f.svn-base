package com.gfs.integration.glazier.automation.dao;
/**
 * This interface defines the query methods used for Glazier GFS Customer Unit 
 * Tax integration query DAO.
 * @author e3k17
 */
public interface GlazierShiptoInfoToGFSCustUnitTaxDao {	
	
        /**
         * This method returns the count of Glazier Customer Units identified by
         * the Glazier input data.
         * @return the number of Customer Units in GLAZIER_CUSTOMER
         */
	public int countGlazierCustomerUnits();

        /**
         * This method returns the count of Glazier Customer Units to be loaded 
         * into the staged GFS_CUST_UNIT_TAX table.
         * @return the number of Customer Units in GFS_CUST_UNIT_TAX
         */
	public int countStagedGFSCustUnitTax();

        /**
         * This method returns the number of Glazier Customer Units to be loaded 
         * into the target GFS_CUST_UNIT_TAX table.
         * @return the number of Customer Units in GFS_CUST_UNIT_TAX
         */
	public int countTargetGFSCustUnitTax();    
        
        /**
         * This method counts the number of Customer Units that have a difference
         * between the Glazier input data and the staged GFS_CUST_UNIT_TAX table.
         * @return the count of invalid fields in staged GFS CUST UNIT_TAX
         */
	public int countStagedGFSCustUnitTaxWithInvalidFields();        
        
        /**
         * This method counts the number of Customer Units that have a difference
         * between staged and target GFS_CUST_UNIT_TAX table.
         * @return the count of invalid fields in target GFS CUST UNIT_TAX
         */
	public int countTargetGFSCustUnitTaxWithInvalidFields();
        
}//end GlazierShiptoInfoToGFSCustUnitTaxDao
