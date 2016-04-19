package com.gfs.integration.glazier.automation.dao;


/**
 * This interface defines the query methods used for the chain code to family integration query DAO.
 * @author v7vyo
 */
public interface ChainCodeToFamilyDao {	
	
        /**
         * This method returns the number of families identified by the Glazier
         * input data.
         * @return the number of families
         */
	public int countGlazierFamilies();
	
        /**
         * This method returns the number of families loaded into the staged
         * GFS_CUSTOMER table.
         * @return the number of families 
         */
        public int countStagedGlazierFamiliesInGFSCustomer();
        
        /**
         * This method returns the number of Glazier families loaded into the
         * target GFS_CUSTOMER table.
         * @return the number of families
         */
	public int countTargetGlazierFamiliesInGFSCustomer();
        
        /**
         * This method counts the number of families that have a difference
         * between the Glazier input data and the staged GFS_CUSTOMER table.
         * @return the count of invalid fields in staged GFS CUSTOMER
         */
	public int countStagedGFSCustomerWithInvalidFields();

        /**
         * This method counts the number of families that have a difference
         * between the the staged and target GFS_CUSTOMER table.
         * @return the count of invalid fields in target GFS CUSTOMER
         */
	public int countTargetGFSCustomerWithInvalidFields();

        /**
         * This method counts the number of families that have a difference
         * between the the staged and target GFS_CUST_GROUP table.
         * @return the count of invalid fields in target GFS CUST GROUP
         */
	public int countTargetGFSCustGroupWithInvalidFields();
        
        /**
         * This method counts the number of families that have a difference
         * between the Glazier input data and the staged GFS_CUST_GROUP table.
         * @return the count of invalid fields in staged GFS CUST GROUP
         */
	public int countStagedGFSCustGroupWithInvalidFields();

        /**
         * This method counts the number of families that have a difference
         * between the Glazier input data and the staged GFS_CUST_FAMILY table.
         * @return the count of invalid fields in staged GFS CUST FAMILY
         */
	public int countStagedGFSCustFamilyWithInvalidFields();

        /**
         * This method counts the number of families that have a difference
         * between the staged and target GFS_CUST_FAMILY tables.
         * @return the count of invalid fields in target GFS CUST FAMILY
         */
	public int countTargetGFSCustFamilyWithInvalidFields();
        
	/**
         * This method returns the number of Glazier families loaded into the
         * target GFS_CUSTOMER_GROUP table.
         * @return the number of families
         */
	public int countStagedGlazierFamiliesInGFSCustGroup();
        
        /**
         * This method returns the number of Glazier families loaded into the
         * target GFS_CUST_GROUP table.
         * @return the number of families
         */
	public int countTargetGlazierFamiliesInGFSCustGroup();

	/**
         * This method returns the number of Glazier families loaded into the 
         * staged GFS_CUST_FAMILY table.
         * @return  the number of families
         */
	public int countStagedGlazierFamiliesInGFSCustFamily();
        
        /**
         * This method returns the number of Glazier families loaded into the 
         * target GFS_CUST_FAMILY table.
         * @return  the number of families
         */
	public int countTargetGlazierFamiliesInGFSCustFamily();
        
	/**
         * This method counts the number of Glazier families loaded into GFS_ENTITY_XREF
         * but missing in GLAZIER CUSTOMER
         * @return the number of GFS ENTITY XREF families with no Glazier 
         * Customer
         */
	public int countXrefWithNoChainCodeInGlazierCust();

	/**
         * This method counts the number of customers loaded into GFS_ENTITY_XREF
         * but missing in target GFS_CUSTOMER
         * @return the count of GFS ENTITY XREF gfs customer id's with no GFS_CUSTOMER record
         */
	public int countXrefWithNoFamilyInGFSCustomer();
        
        /**
         * This method counts the Family GFS_ENTITY_XREF entries that are missing
         * either the original entity id or the target id.
         * @return the count of family records missing id's in the 
         * GFS_ENTITY_XREF table
         */
	public int countFamilyXrefEntriesWithoutId();
        
        /**
         * This method returns the number of Family records
         * loaded into the staged GFS_ENTITY_XREF table.
         * @return the number of Family records
         */
	public int countStagedFamiliesInGFSEntityXref();        

        /**
         * This method counts the number of Families where the cust reln mgr id 
         * derived from the Glazier table does not match the cust reln mgr id in 
         * the staged GFS_CUST_GROUP table.
         * @return the count of invalid crm id's in staged GFS CUST_GROUP
         */
	public int countStagedGFSCustGroupWithInvalidCrmId(); 
        
}//end ChainCdToFamilyDao
