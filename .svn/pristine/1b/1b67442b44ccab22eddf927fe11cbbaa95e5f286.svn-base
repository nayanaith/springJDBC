package com.gfs.integration.glazier.automation.dao;


/**
 * This interface defines the query methods used for Glazier Legal Owner integration query DAO.
 * @author e3k17
 */
public interface GlazierInfoToLegalOwnerDao {	
	
        /**
         * This method returns the number of Glazier Legal Owners identified by
         * the Glazier input data.
         * @return the number of Glazier legal owners
         */
	public int countGlazierLegalOwners();

        /**
         * This method returns the number of Glazier Legal Owner Principal Assignments
         * identified by the Glazier input data.
         * @return the number of Glazier legal owner principal assignments
         */
	public int countGlazierLegalOwnerPrincipalAssignments();

        /**
         * This method returns the number of Glazier Legal Owner Principal
         * records identified by the Glazier input data.
         * @return the number of Glazier legal owner principal assignments
         */
	public int countGlazierLegalOwnerPrincipal();
        
        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the staged GFS_CUSTOMER table
         * @return the number of Glazier legal owners
         */
	public int countStagedLegalOwnersInGFSCustomer();
        
        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the target GFS_CUSTOMER table
         * @return the number of legal owners
         */
	public int countTargetLegalOwnersInGFSCustomer();

        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the staged GFS_CUST_GROUP table
         * @return the number of Glazier legal owners
         */
	public int countStagedLegalOwnersInGFSCustGroup();

        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the target GFS_CUST_GROUP table
         * @return the number of Glazier legal owners
         */
	public int countTargetLegalOwnersInGFSCustGroup();

        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the staged GFS_CUSTOMER_SITE table
         * @return the number of Glazier legal owners
         */
	public int countStagedLegalOwnersInGFSCustomerSite();
    
        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the target GFS_CUSTOMER_SITE table
         * @return the number of Glazier legal owners
         */
	public int countTargetLegalOwnersInGFSCustomerSite();
        
        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the staged CRM_SITE table
         * @return the number of Glazier legal owners
         */
	public int countStagedLegalOwnersInCRMSite();
 
        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the target CRM_SITE table
         * @return the number of Glazier legal owners
         */
	public int countTargetLegalOwnersInCRMSite();
        
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged GFS_CUSTOMER table.
         * @return the count of invalid fields in staged GFS CUSTOMER
         */
	public int countStagedGFSCustomerWithInvalidFields();        

        /**
         * This method counts the number of Legal Owners where the customer name 
         * derived from the Glazier Avendra table does not match the gfs_customer_name
         * in the staged GFS_CUSTOMER table.
         * @return the count of invalid fields in staged GFS CUSTOMER (particularly name)
         */
	public int countStagedGFSCustomerWithInvalidCustName();

        /**
         * This method counts the number of Legal Owners where the customer name 
         * derived from the Glazier Avendra table does not match the gfs_customer_name
         * in the staged GFS_CUST_GROUP table.
         * @return the count of invalid fields in staged GFS CUST_GROUP (particularly name)
         */
	public int countStagedGFSCustGroupWithInvalidCustName();

        /**
         * This method counts the number of Legal Owners where the cust reln mgr id 
         * derived from the Glazier table does not match the cust reln mgr id in 
         * the staged GFS_CUST_GROUP table.
         * @return the count of invalid crm id's in staged GFS CUST_GROUP
         */
	public int countStagedGFSCustGroupWithInvalidCrmId();
        
        /**
         * This method counts the number of legal owners that have a difference
         * between the staged and target GFS_CUSTOMER tables.
         * @return the count of invalid fields in target GFS CUSTOMER
         */
	public int countTargetGFSCustomerWithInvalidFields();

        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged CUSTOMER_CONTACT table.
         * @return the count of invalid fields in staged CUSTOMER CONTACT
         */
	public int countStagedCustomerContactWithInvalidFields();

        /**
         * This method counts the number of Legal Owners that have a difference
         * between the staged and target CUSTOMER_CONTACT table.
         * @return the count of invalid fields in target CUSTOMER CONTACT
         */
	public int countTargetCustomerContactWithInvalidFields();
        
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged GFS_CUST_GROUP table.
         * @return the count of invalid fields in staged GFS CUST GROUP
         */
	public int countStagedGFSCustGroupWithInvalidFields();

        /**
         * This method counts the number of Legal Owners that have a difference
         * between the staged and target GFS_CUST_GROUP table.
         * @return the count of invalid fields in target GFS CUST GROUP
         */
	public int countTargetGFSCustGroupWithInvalidFields();
 
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged CRM_SITE table.
         * @return the count of invalid fields in staged CRM SITE
         */
	public int countStagedCRMSiteWithInvalidFields();
     
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the staged and target CRM_SITE table.
         * @return the count of invalid fields in target CRM SITE
         */
	public int countTargetCRMSiteWithInvalidFields();
    
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged GFS_CUSTOMER_SITE table.
         * @return the count of invalid fields in staged GFS CUSTOMER SITE
         */
	public int countStagedGFSCustomerSiteWithInvalidFields();
     
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the staged and target GFS_CUSTOMER_SITE tables.
         * @return the count of invalid fields in target GFS CUSTOMER SITE
         */
	public int countTargetGFSCustomerSiteWithInvalidFields();
        
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged GFS_CUST_LEGAL_OWNER table.
         * @return the count of invalid fields in staged GFS CUST LEGAL OWNER
         */
	public int countStagedGFSCustLegalOwnerWithInvalidFields();

        /**
         * This method counts the number of Legal Owners that have a difference
         * between the staged and target GFS_CUST_LEGAL_OWNER tables.
         * @return the count of invalid fields in target GFS CUST LEGAL OWNER
         */
	public int countTargetGFSCustLegalOwnerWithInvalidFields();


        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged LEGAL_OWNER_PRINCIPAL table.
         * @return the count of invalid fields in staged LEGAL OWNER PRINCIPAL
         */
	public int countStagedLegalOwnerPrincipalWithInvalidFields();

        /**
         * This method counts the number of Legal Owners that have a difference
         * between the staged and target LEGAL_OWNER_PRINCIPAL tables.
         * @return the count of invalid fields in target LEGAL OWNER PRINCIPAL
         */
	public int countTargetLegalOwnerPrincipalWithInvalidFields();
        
        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the staged LEGAL_OWNER_PRINCIPAL_ASGN table.
         * @return the count of invalid fields in staged LEGAL OWNER PRINCIPAL ASGN
         */
	public int countStagedLegalOwnerPrincipalAsgnWithInvalidFields();

        /**
         * This method counts the number of Legal Owners that have a difference
         * between the Glazier input data and the target LEGAL_OWNER_PRINCIPAL_ASGN table.
         * @return the count of invalid fields in target LEGAL OWNER PRINCIPAL ASGN
         */
	public int countTargetLegalOwnerPrincipalAsgnWithInvalidFields();
        
        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the staged GFS_CUST_LEGAL_OWNER table
         * @return the number of Glazier legal owners
         */
	public int countStagedLegalOwnersInGFSCustLegalOwner();

        /**
         * This method returns the number of Glazier Legal Owners loaded into
         * the target GFS_CUST_LEGAL_OWNER table
         * @return the number of Glazier legal owners
         */
	public int countTargetLegalOwnersInGFSCustLegalOwner();
        
        /**
         * This method returns the number of Glazier Legal Owner Bank records
         * loaded into staged LEGAL_OWNER_BANK (should be 0).
         * @return the number of Legal Owner Bank records
         */
	public int countStagedLegalOwnerBank();        

        /**
         * This method returns the number of Legal Owner Bank records
         * loaded into the target LEGAL_OWNER_BANK (should be 0).
         * @return the number of Legal Owner Bank records
         */
	public int countTargetLegalOwnerBank();

        /**
         * This method returns the number of Legal Owner Principal Assignment
         * records loaded into the staged LEGAL_OWNER_PRINCIPAL_ASGN.
         * @return the number of Legal Owner Principal Assignment records
         */
	public int countStagedLegalOwnerPrincipalAsgn();

        /**
         * This method returns the number of Legal Owner Principal records
         * loaded into the staged LEGAL_OWNER_PRINCIPAL table.
         * @return the number of Legal Owner Principal records
         */
	public int countStagedLegalOwnerPrincipal();

        /**
         * This method returns the number of Legal Owner Principal records
         * loaded into the target LEGAL_OWNER_PRINCIPAL table.
         * @return the number of Legal Owner Principal records
         */
	public int countTargetLegalOwnerPrincipal();
        
        /**
         * This method returns the number of Legal Owner Principal Assignment
         * records loaded into the target LEGAL_OWNER_PRINCIPAL_ASGN.
         * @return the number of Legal Owner Principal Assignment records
         */
	public int countTargetLegalOwnerPrincipalAsgn();
        
        /**
         * This method returns the number of Legal Owner Sic records
         * loaded into the staged LEGAL_OWNER_SIC (should be 0).
         * @return the number of Legal Owner Sic records
         */
	public int countStagedLegalOwnerSic();

        /**
         * This method returns the number of Legal Owner Sic records
         * loaded into the target LEGAL_OWNER_SIC (should be 0).
         * @return the number of Legal Owner Sic records
         */
	public int countTargetLegalOwnerSic();
        
	/**
         * This method returns the Glazier legal owners loaded into GFS_ENTITY_XREF
         * but missing in GLAZIER CUSTOMER
         * @return the count of family xref with no Glazier Customers
         */
	public int countXrefWithNoLegalOwnerInGlazierCust();
        
        /**
         * This method returns the number of Legal Owner records
         * loaded into the staged GFS_ENTITY_XREF table.
         * @return the number of Legal Owner records
         */
	public int countStagedLegalOwnersInGFSEntityXref();  
        
        /**
         * This method finds the Legal Owner GFS_ENTITY_XREF entries that are missing
         * either the original entity id or the target id.
         * @return the number of legal owner records missing id's in the 
         * GFS_ENTITY_XREF table
         */
	public int countLegalOwnerXrefEntriesWithoutId();        

	/**
         * This method counts legal owners loaded into GFS_ENTITY_XREF
         * but missing in the target GFS_CUSTOMER
         * @return the count of Xref legal owners with no GFS_CUSTOMER record
         */
	public int countXrefWithNoLegalOwnerInGFSCustomer();        

	/**
         * This method counts legal owners loaded into target GFS_CUST_LEGAL_OWNER
         * where the credit_limit_dollar_amt is not correct
         * @return the count of legal owners with incorrect credit limit dollar amt's
         */
	public int countTargetGFSCustLegalOwnerWithInvalidCreditLimitDollarAmt();
        
        /**
         * This method returns the number of Legal Owner Principal records
         * loaded into the staged CUSTOMER_CONTACT.
         * @return the number of Legal Owner Principal Contact records
         */
	public int countStagedLegalOwnerCustomerContact();        
      
        /**
         * This method returns the number of Legal Owner Principal records
         * loaded into the target CUSTOMER_CONTACT.
         * @return the number of Legal Owner Principal Contact records
         */
	public int countTargetLegalOwnerCustomerContact();
        
}//end GlazierInfoToLegalOwnerDao
