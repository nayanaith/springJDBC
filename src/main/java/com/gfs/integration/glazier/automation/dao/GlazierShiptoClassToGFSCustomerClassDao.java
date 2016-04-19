package com.gfs.integration.glazier.automation.dao;

import java.util.List;
import java.util.Map;

/**
 * This interface defines the query methods used for Glazier GFS Customer 
 * Classification integration query DAO.
 * @author e3k17
 */
public interface GlazierShiptoClassToGFSCustomerClassDao {	

        /**
         * This method returns the number of Glazier Customer Units identified by
         * the Glazier input data.
         * @return the number of Customer Units in GLAZIER_CUSTOMER
         */
	public int countGlazierCustomerUnits();
        
        /**
         * This method returns the number of Glazier customer units that have a 
         * class category id of 3.
         * @return the number of Customer Sub Classes in GLAZIER_CUSTOMER
         */
	public int countStagedCCMSubClasses();

        /**
         * This method returns the number of target CUSTOMER_CLASS_MEMBER records
         * that have a class category id of 3.
         * @return the number of Customer Sub Classes in CUSTOMER_CLASS_MEMBER
         */
	public int countTargetCCMSubClasses();
        
        /**
         * This method returns the number of Glazier customer units that have a 
         * class category id of 4.
         * @return the number of Customer Affiliations in GLAZIER_CUSTOMER
         */
	public int countStagedCCMAffiliations();

        /**
         * This method returns the number of target CUSTOMER_CLASS_MEMBER records
         * that have a class category id of 4.
         * @return the number of Customer Affiliations in GLAZIER_CUSTOMER
         */
	public int countTargetCCMAffiliations();
        
        /**
         * This method returns the number of Glazier customer units that have a 
         * class category id of 5.
         * @return the number of Customer Menu Themes in GLAZIER_CUSTOMER
         */
	public int countStagedCCMMenuThemes();

        /**
         * This method returns the number of target CUSTOMER_CLASS_MEMBER records
         * that have a class category id of 5.
         * @return the number of Customer Menu Themes in GLAZIER_CUSTOMER
         */
	public int countTargetCCMMenuThemes();
        
        /**
         * This method returns the number of target CUSTOMER_CLASS_MEMBER records
         * that have a class category id of 6.
         * @return the number of Customer Management Type in GLAZIER_CUSTOMER
         */
	public int countTargetCCMMgmtType();

        /**
         * This method returns the number of Glazier customer units that have a 
         * class category id of 6.
         * @return the number of Customer Management Type in GLAZIER_CUSTOMER
         */
	public int countStagedCCMMgmtType();
        
        /**
         * This method counts the number of customer class members (sub class) 
         * that have a difference between the Glazier input date and the staged
         * CUSTOMER_CLASS_MEMBER table (where class category id = 3)
         * @return the count of invalid fields in staged CUSTOMER_CLASS_MEMBER (sub class)
         */
	public int countStagedCCMSubClassesWithInvalidFields();        

        /**
         * This method counts the number of customer class members (sub class) 
         * that have a difference between the staged and target
         * CUSTOMER_CLASS_MEMBER table (where class category id = 3)
         * @return the count of invalid fields in target CUSTOMER_CLASS_MEMBER (sub class)
         */
	public int countTargetCCMSubClassesWithInvalidFields();
        
        /**
         * This method counts the number of customer class members (affiliations) 
         * that have a difference between the Glazier input date and the staged
         * CUSTOMER_CLASS_MEMBER table (where class category id = 4)
         * @return the count of invalid fields in staged CUSTOMER_CLASS_MEMBER (affiliations)
         */
	public int countStagedCCMAffiliationsWithInvalidFields();

        /**
         * This method counts the number of customer class members (affilitations) 
         * that have a difference between the staged and target
         * CUSTOMER_CLASS_MEMBER table (where class category id = 4)
         * @return the count of invalid fields in target CUSTOMER_CLASS_MEMBER (affiliations)
         */
	public int countTargetCCMAffiliationsWithInvalidFields();
        
        /**
         * This method counts the number of customer class members (menu themes) 
         * that have a difference between the Glazier input date and the staged
         * CUSTOMER_CLASS_MEMBER table (where class category id = 5)
         * @return the count of invalid fields in staged CUSTOMER_CLASS_MEMBER (menu themes)
         */
	public int countStagedCCMMenuThemesWithInvalidFields();

        /**
         * This method counts the number of customer class members (menu theme) 
         * that have a difference between the staged and target
         * CUSTOMER_CLASS_MEMBER table (where class category id = 5)
         * @return the count of invalid fields in target CUSTOMER_CLASS_MEMBER (menu theme)
         */
	public int countTargetCCMMenuThemesWithInvalidFields();
        
        /**
         * This method counts the number of customer class members (mgmt types) 
         * that have a difference between the Glazier input date and the staged
         * CUSTOMER_CLASS_MEMBER table (where class category id = 6)
         * @return the count of invalid fields in staged CUSTOMER_CLASS_MEMBER (mgmt types)
         */
	public int countStagedCCMMgmtTypesWithInvalidFields();

        /**
         * This method counts the number of customer class members (mgmt type) 
         * that have a difference between the staged and target
         * CUSTOMER_CLASS_MEMBER table (where class category id = 6)
         * @return the count of invalid fields in target CUSTOMER_CLASS_MEMBER (mgmt type)
         */
	public int countTargetCCMMgmtTypeWithInvalidFields();
        
        /**
         * This method counts the number of Customer Units where the 
         * fuel surcharge indicator does not match between the Glazier input 
         * data and the staged GFS_CUST_UNIT table.
         * @return the count of invalid fields in staged GFS CUST UNIT
         */
	public int countStagedGFSCustUnitWithInvalidFuelSurcharge();        

        /**
         * This method counts the number of Customer Units where the 
         * fuel surcharge indicator does not match between the staged and 
         * target GFS_CUST_UNIT table.
         * @return the count of invalid fields in target GFS CUST UNIT
         */
	public int countTargetGFSCustUnitWithInvalidFuelSurcharge();
        
}//end GlazierShiptoClassToGFSCustomerClassDao
