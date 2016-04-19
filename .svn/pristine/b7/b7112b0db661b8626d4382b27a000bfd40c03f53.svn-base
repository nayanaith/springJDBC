package com.gfs.integration.glazier.automation.dao;


/**
 * This interface defines the query methods used for the Bill-to to Bill-to 
 * integration query DAO.
 * @author v7vyo
 */
public interface BilltoToBilltoDao {	
	
        /**
         * This method returns the number of Bill-to's identified by the Glazier
         * input data.
         * @return the number of bill-to's
         */
	public int countGlazierBillto();
	
        /**
         * This method returns the number of bill-to's loaded into the staged
         * GFS_CUST_BILLING_AGENT table.
         * @return the number of Staged bill-to's 
         */
        public int countStagedGlazierBillto();
        
        /**
         * This method returns the number of bill-to's loaded into the target
         * GFS_CUST_BILLING_AGENT table.
         * @return the number of Target bill-to's 
         */
        public int countTargetGlazierBillto();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Staged GFS_CUST_GROUP table.
         * @return the number of bill-to's
         */
	public int countStagedGlazierBilltoGFSCustGroup();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Target GFS_CUST_GROUP table.
         * @return the number of bill-to's
         */
	public int countTargetGlazierBilltoGFSCustGroup();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Staged GFS_CUSTOMER_SITE table.
         * @return the number of staged sites where type is 11
         */
	public int countStagedGlazierBilltoGFSCustomerSite();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Target GFS_CUSTOMER_SITE table.
         * @return the number of bill-to's
         */
	public int countTargetGlazierBilltoGFSCustomerSite();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Staged CRM_SITE table.
         * @return the number of bill-to's
         */
	public int countStagedGlazierBilltoCRMSite();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Staged GFS_ENTITY_XREF table.
         * @return the number of bill-to's
         */
	public int countStagedGlazierBilltoXref();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Target CRM_SITE table.
         * @return the number of bill-to's
         */
	public int countTargetGlazierBilltoCRMSite();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Staged GFS_CUSTOMER table.
         * @return the number of bill to agents in gfs customer
         */
	public int countStagedGlazierBilltoGFSCustomer();
        
        /**
         * This method returns the number of Glazier bill-to's loaded into the
         * Target GFS_CUSTOMER table.
         * @return the number of bill-to's
         */
	public int countTargetGlazierBilltoGFSCustomer();
        
        /**
         * This method returns the Staged Glazier bill-to's with empty fields
         * @return the list of invalid bill-to's
         */
        public int countStagedGlazierBilltoWithInvalidFields();
        
        /**
         * This method returns a count of the Staged Glazier bill-to's GFS Cust Group 
         * with invalid fields
         * @return the number of staged invalid bill-to's GFS Cust Group Records
         */
        public int countStagedGlazierBilltoGFSCustGroupWithInvalidFields();        

        /**
         * This method returns a count of Target Glazier bill-to's GFS Cust Group 
         * with invalid fields
         * @return the number of target invalid bill-to's GFS Cust Group Records
         */
        public int countTargetGlazierBilltoGFSCustGroupWithInvalidFields();        

        /**
         * This method returns a count of Staged Glazier bill-to's GFS Customer Sites 
         * with invalid fields
         * @return the number of target invalid bill-to's GFS Customer Site Records
         */
        public int countStagedGlazierBilltoGFSCustomerSiteWithInvalidFields();

        /**
         * This method returns a count of  Target Glazier bill-to's GFS Customer Sites 
         * with invalid fields
         * @return the number of target invalid bill-to's GFS Customer Site Records
         */
        public int countTargetGlazierBilltoGFSCustomerSiteWithInvalidFields();

        /**
         * This method returns a count of Target Glazier bill-to's GFS Customer 
         * with invalid fields
         * @return the number of target invalid bill-to's GFS Customer Records
         */
        public int countTargetGlazierBilltoGFSCustomerWithInvalidFields();
        
        /**
         * This method returns a count of Target Glazier bill-to's CRM Sites 
         * with invalid fields
         * @return the number of target invalid bill-to's CRM Site Records
         */
        public int countTargetGlazierBilltoCRMSiteWithInvalidFields();
        
        /**
         * This method returns a count of Staged Glazier bill-to CRM Sites 
         * with invalid fields
         * @return the number of staged invalid bill-to's CRM Site Records
         */
        public int countStagedGlazierBilltoCRMSiteWithInvalidFields();
        
        /**
         * This method returns a count of Staged Glazier bill-to GFS Customer 
         * with invalid fields
         * @return the number of staged bill-to GFS Customer Records
         */
        public int countStagedGlazierBilltoGFSCustomerWithInvalidFields();
        
        /**
         * This method returns a count of Target Glazier bill-to's 
         * with invalid fields
         * @return the number of target invalid bill-to's
         */
        public int countTargetGlazierBilltoWithInvalidFields();

        /**
         * This method returns a count of target billing agents 
         * with invalid bill to units
         * @return the number of target invalid bill-to units
         */
        public int countTargetInvalidBilltoUnits();
        
        /**
         * This method returns a count of the Glazier Bill-to's loaded into
         * staged GFS CUSTOMER table with no GFS_ENTITY_XREF entry.
         * @return the count of families with no XREF entry
         */
	public int countXrefWithNoBillingAgentInGlazierCust();
        
        /**
         * This method returns a count of the Glazier Bill-to's loaded into
         * staged GFS_ENTITY_XREF table but missing in the target GFS CUSTOMOMER
         * @return the count of missing target GFS CUSTOMER records
         */
	public int countXrefWithNoBillingAgentInGFSCustomer();
        
        /**
         * This method returns a count of Glazier Bill-to's loaded into staged
         * GFS_ENTITY_XREF missing a valid original entity id or gfs entity id
         * @return the count of families with no XREF entry
         */
	public int countBillingAgentXrefEntriesWithoutId();
        
	
}//end BilltoToBilltoDao
