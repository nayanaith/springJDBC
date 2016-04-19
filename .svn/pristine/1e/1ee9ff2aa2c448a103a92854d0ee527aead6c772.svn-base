package com.gfs.integration.glazier.automation;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTaxDao;
import org.junit.Before;

/**
 * This class performs the integration tests for the epic "Move Glazier Ship-to Information
 * to GFS Cust Unit Tax Information"
 * @author Mike Woodworth
 *
 */
public class GlazierShiptoInfoToGFSCustUnitTaxTest {
    
    /** DAO used to execute the queries. **/
    GlazierShiptoInfoToGFSCustUnitTaxDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets the instances need for the test.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (GlazierShiptoInfoToGFSCustUnitTaxDao) context.getBean("glazierCustUnitTaxDao");
    }

    /**
     * Test for CUSMAINT_1417 - Verify staged GFS_CUST_UNIT_TAX load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1417(){
        assertEquals("The number of staged GFS_CUST_UNIT_TAX records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedGFSCustUnitTax()));		
    }

    /**
     * Test for CUSMAINT_1418 - Verify target GFS_CUST_UNIT_TAX load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1418(){
        assertEquals("The number of target GFS_CUST_UNIT_TAX records does not equal staged!",
                String.valueOf(dao.countStagedGFSCustUnitTax()),
                String.valueOf(dao.countTargetGFSCustUnitTax()));		
    }
    
    /**
     * Test for CUSMAINT-1419 - Field level validation for Staged GFS_CUST_UNIT_TAX
     */
    @Test
    public void CUSMAINT_1419(){
        int a=dao.countStagedGFSCustUnitTaxWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_UNIT_TAX failed!",0,a);
    }
 
    /**
     * Test for CUSMAINT-1420 - Field level validation for Target GFS_CUST_UNIT_TAX
     */
    @Test
    public void CUSMAINT_1420(){
        int a=dao.countTargetGFSCustUnitTaxWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_UNIT_TAX failed!",0,a);
    }
    
    /**
     * This method releases resources used during the tests.
     */
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
	
}//UploadValidationTest
