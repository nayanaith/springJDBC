package com.gfs.integration.glazier.automation.dao;


/**
 * This interface defines the query methods used for Glazier GFS Customer Unit 
 * integration query DAO.
 * @author e3k17
 */
public interface GlazierShiptoInfoToGFSCustUnitDao {	
	
        /**
         * This method returns the number of Glazier Customer Units identified by
         * the Glazier input data.
         * @return the number of Customer Units in GLAZIER_CUSTOMER
         */
	public int countGlazierCustomerUnits();
        
        /**
         * This method returns the number of Glazier Customer Units to be loaded 
         * into the staged GFS_CUSTOMER table.
         * @return the number of Customer Units in GFS_CUSTOMER
         */
	public int countStagedGFSCustomer();
        
        /**
         * This method returns the number of Customer Unit records
         * loaded into the staged GFS_ENTITY_XREF table.
         * @return the number of Customer Unit records
         */
	public int countStagedCustUnitsInGFSEntityXref();        

	/**
         * This method counts the Glazier Customer Units loaded into GFS_ENTITY_XREF
         * but missing in GLAZIER CUSTOMER
         * @return a count of Customer Units with no Glazier Customer record
         */
	public int countXrefWithNoCustUnitInGlazierCustomer();

	/**
         * This method counts the gfs customer loaded into GFS_ENTITY_XREF
         * but missing in the target GFS_CUSTOMER
         * @return the count of gfs customer id's with no GFS_CUSTOMER record
         */
	public int countXrefWithNoUnitInGFSCustomer();
        
        
        /**
         * This method find the Unit GFS_ENTITY_XREF entries that are missing
         * either the original entity id or the target id.
         * @return the number of unit records missing id's in the 
         * GFS_ENTITY_XREF table
         */
	public int countUnitXrefEntriesWithoutId();
        
        /**
         * This method returns the number of Glazier Customer Units to be loaded 
         * into the staged GFS_CUST_UNIT table.
         * @return the number of Customer Units in GFS_CUST_UNIT
         */
	public int countStagedGFSCustUnit();

        /**
         * This method returns the number of Glazier Customer Units to be loaded 
         * into the target GFS_CUSTOMER table.
         * @return the number of Customer Units in GFS_CUSTOMER
         */
	public int countTargetGFSCustomer();

        /**
         * This method returns the number of Glazier Customer Units to be loaded 
         * into the target GFS_CUST_UNIT table.
         * @return the number of Customer Units in GFS_CUST_UNIT
         */
	public int countTargetGFSCustUnit();
        

        /**
         * This method counts the number of Customer Units that have a difference
         * between the Glazier input data and the staged GFS_CUSTOMER table.
         * @return the count of invalid fields in staged GFS CUSTOMER
         */
	public int countStagedGFSCustomerWithInvalidFields();
   
        /**
         * This method counts the number of Customer Units that have a difference
         * between the staged and target GFS_CUSTOMER table.
         * @return the count of invalid fields in target GFS CUSTOMR
         */
	public int countTargetGFSCustomerWithInvalidFields();

        /**
         * This method counts the number of Customer Units that have a difference
         * between the Glazier input data and the staged GFS_CUST_UNIT table.
         * @return the count of invalid fields in staged GFS CUST UNIT
         */
	public int countStagedGFSCustUnitWithInvalidFields();

        /**
         * This method counts the number of crm id's that are different
         * between the Glazier input data and the staged GFS_CUST_UNIT table.
         * @return the count of invalid crm id's in staged GFS CUST UNIT
         */
	public int countStagedGFSCustUnitWithInvalidCrmId();
        
        /**
         * This method counts the number of Customer Units that have a difference
         * between the staged and target GFS_CUST_UNIT table.
         * @return the count of invalid fields in target GFS CUST UNIT
         */
	public int countTargetGFSCustUnitWithInvalidFields();
        
}//end GlazierShiptoInfoToGFSCustUnitDao
