package com.gfs.integration.glazier.automation;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao;
import org.junit.Before;

/**
 * This class performs the integration tests for the epic "Move Glazier Ship-to Information
 * to GFS Customer Unit Information"
 * @author Mike Woodworth
 *
 */
public class GlazierShiptoInfoToGFSCustUnitTest {
    
    /** DAO used to execute the queries. **/
    GlazierShiptoInfoToGFSCustUnitDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets the instances need for the test.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (GlazierShiptoInfoToGFSCustUnitDao) context.getBean("glazierCustUnitDao");
    }

    /**
     * Test for CUSMAINT_1409 - Verify staged GFS_CUSTOMER load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1409(){
        assertEquals("The number of staged GFS_CUSTOMER records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedGFSCustomer()));		
    }

    /**
     * Test for CUSMAINT_1410 - Verify staged GFS_CUST_UNIT load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1410(){
        assertEquals("The number of staged GFS_CUST_UNIT records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedGFSCustUnit()));		
    }
    
    /**
     * Test for CUSMAINT_1411 - Verify target GFS_CUSTOMER load from staged 
     * GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1411(){
        assertEquals("The number of target GFS_CUSTOMER records does not equal staged!",
                String.valueOf(dao.countStagedGFSCustomer()),
                String.valueOf(dao.countTargetGFSCustomer()));		
    }
    
 
    /**
     * Test for CUSMAINT_1412 - Verify target GFS_CUST_UNIT load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1412(){
        assertEquals("The number of target GFS_CUST_UNIT records does not equal staged!",
                String.valueOf(dao.countStagedGFSCustUnit()),
                String.valueOf(dao.countTargetGFSCustUnit()));		
    }

    /**
     * Test for CUSMAINT-1413 - Field level validation for Staged GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1413(){
        int a=dao.countStagedGFSCustomerWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUSTOMER failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1414 - Field level validation for Staged GFS_CUST_UNIT
     */
    @Test
    public void CUSMAINT_1414(){
        int a=dao.countStagedGFSCustUnitWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_UNIT failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1415 - Field level validation for Target GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1415(){
        int a=dao.countTargetGFSCustomerWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUSTOMER failed!",0,a);
    }
 
    /**
     * Test for CUSMAINT-1416 - Field level validation for Target GFS_CUST_UNIT
     */
    @Test
    public void CUSMAINT_1416(){
        int a=dao.countTargetGFSCustUnitWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUST_UNIT failed!",0,a);
    }
 
    /**
     * Test for CUSMAINT_1425 - Verify staged GFS_ENTITY_XREF load
     * from Glazier Customer
     */
    @Test
    public void CUSMAINT_1425(){
        assertEquals("The number of staged GFS_ENTITY_XREF Customer Unit records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedCustUnitsInGFSEntityXref()));		
    }
    
    /**
     * Test for CUSMAINT-1426 - Verify GFS_ENTITY_XREF.original_entity_id 
     * has matching GLAZIER_CUSTOMER.cust_nbr
     */
    @Test
    public void CUSMAINT_1426(){
        int a=dao.countXrefWithNoCustUnitInGlazierCustomer();
        assertEquals("GFS_ENTITY_XREF has original entity id (UNIT) not found in GLAZIER_CUSTOMER",0,a);
    }

    /**
     * Test for CUSMAINT-1427 - Verify Unit records in GFS_ENTITY_XREF table 
     * have valid original entity id and gfs entity id
     */
    @Test
    public void CUSMAINT_1427(){
        assertEquals("GFS_ENTITY_XREF has null original or gfs entity id(s)",
                Integer.parseInt("0"), dao.countUnitXrefEntriesWithoutId());
    }

    /**
     * Test for CUSMAINT-1428 - Verify GFS_ENTITY_XREF.original_entity_id 
     * has matching GFS_CUSTOMER.gfs_customer_id
     */
    @Test
    public void CUSMAINT_1428(){
        int a=dao.countXrefWithNoUnitInGFSCustomer();
        assertEquals("GFS_ENTITY_XREF has gfs entity id (gfs customer id) not found in GFS_CUSTOMER",0,a);
    }
    
    /**
     * Test for CUSMAINT-1853 - Field level validation for Staged GFS_CUST_UNIT
     */
    @Test
    public void CUSMAINT_1853(){
        int a=dao.countStagedGFSCustUnitWithInvalidCrmId();
        assertEquals("Field level validation for STAGED GFS_CUST_UNIT.cust_reln_mgr_id failed!",0,a);
    }
    
    /**
     * This method releases resources used during the tests.
     */
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
	
}//GlazierShiptoInfoToGFSCustUnitTest
