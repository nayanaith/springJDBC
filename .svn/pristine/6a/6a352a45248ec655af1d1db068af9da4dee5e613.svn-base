package com.gfs.integration.glazier.automation;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao;
import org.junit.Before;

/**
 * This class performs the integration tests for the epic "Load Glazier Chain Code to GFS Family"
 * @author Naya Bandara
 *
 */
public class ChainCodeToFamilyTest {
    
    /** DAO used to execute the queries. **/
    ChainCodeToFamilyDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets the instances need for the test.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (ChainCodeToFamilyDao) context.getBean("glazierCustomerDao");
    }

    /**
     * Test for CUSMAINT_1142 - Verify staged GFS_CUSTOMER load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1142(){
        assertEquals("The number of staged GFS_CUSTOMER (Family) records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierFamilies()),
                String.valueOf(dao.countStagedGlazierFamiliesInGFSCustomer()));		
    }

    /**
     * Test for CUSMAINT-1143 - Verify target GFS_CUSTOMER load from staged GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1143(){
        assertEquals("The number of staged Families in GFS_CUSTOMER does not equal target!", 
                String.valueOf(dao.countStagedGlazierFamiliesInGFSCustomer()),
                String.valueOf(dao.countTargetGlazierFamiliesInGFSCustomer()));
    }

    /**
     * Test for CUSMAINT-1144 - Field level validation for Staged GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1144(){
        int a=dao.countStagedGFSCustomerWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUSTOMER failed!",0,a);
    }

    /**
     * Teat for CUSMAINT-1151 - Verify target GFS_CUST_GROUP load from staged GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1151(){
        assertEquals("The number of staged Families in GFS_CUST_GROUP does not equal target!",
                     String.valueOf(dao.countStagedGlazierFamiliesInGFSCustGroup()),
                     String.valueOf(dao.countTargetGlazierFamiliesInGFSCustGroup()));		
        
    }

    /**
     * Test for CUSMAINT-1152 - Verify staged GFS_CUST_FAMILY load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1152(){
        assertEquals("The number of staged GFS_CUST_FAMILY records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierFamilies()),
                String.valueOf(dao.countStagedGlazierFamiliesInGFSCustFamily()));
    }	

    /**
     * Test for CUSMAINT-1153 - Verify target GFS_CUST_FAMILY load from staged GFS_CUST_FAMILY
     */
    @Test
    public void CUSMAINT_1153(){
        assertEquals("The number of staged Families in GFS_CUST_FAMILY does not equal target!",
                String.valueOf(dao.countStagedGlazierFamiliesInGFSCustFamily()),
                String.valueOf(dao.countTargetGlazierFamiliesInGFSCustFamily()));
    }

    /**
     * Test for CUSMAINT-1154 - Verify staged GFS_CUST_GROUP load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1154(){
        assertEquals("The number of staged GFS_CUST_GROUP records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierFamilies()),
                String.valueOf(dao.countStagedGlazierFamiliesInGFSCustGroup()));		
    }

    /**
     * Test for CUSMAINT-1155 - Verify GFS_ENTITY_XREF.original_entity_id 
     * has matching GLAZIER_CUSTOMER.chain_code
     */
    @Test
    public void CUSMAINT_1155(){
        int a=dao.countXrefWithNoChainCodeInGlazierCust();
        assertEquals("GFS_ENTITY_XREF has original entity id (CHAIN CODE) not found in GLAZIER_CUSTOMER",0,a);
    }

    /**
     * Test for CUSMAINT-1156 - Verify staged GFS_ENTITY_XREF load from Glazier Customer 
     */
    @Test
    public void CUSMAINT_1156(){
        assertEquals("The number of staged GFS_ENTITY_XREF records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierFamilies()),
                String.valueOf(dao.countStagedFamiliesInGFSEntityXref()));
    }

    /**
     * Test for CUSMAINT-1157 - Verify Family records in GFS_ENTITY_XREF table 
     * have valid original entity id and gfs entity id
     */
    @Test
    public void CUSMAINT_1157(){
        assertEquals("GFS_ENTITY_XREF has null original or gfs entity id(s)",
                Integer.parseInt("0"), dao.countFamilyXrefEntriesWithoutId());
    }

    /**
     * Test for CUSMAINT-1356 - Field level validation for Staged GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1356(){
        int a=dao.countStagedGFSCustGroupWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_GROUP failed!",0,a);
    }

        /**
     * Test for CUSMAINT-1357 - Field level validation for Staged GFS_CUST_FAMILY
     */
    @Test
    public void CUSMAINT_1357(){
        int a=dao.countStagedGFSCustFamilyWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_FAMILY failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1358 - Field level validation for Target GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1358(){
        int a=dao.countTargetGFSCustomerWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUSTOMER failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1359 - Field level validation for Target GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1359(){
        int a=dao.countTargetGFSCustGroupWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUST_GROUP failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1360 - Field level validation for Target GFS_CUST_FAMILY
     */
    @Test
    public void CUSMAINT_1360(){
        int a=dao.countTargetGFSCustFamilyWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUST_FAMILY failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1361 - Verify GFS_ENTITY_XREF.original_entity_id 
     * has matching GFS_CUSTOMER.gfs_customer_id
     */
    @Test
    public void CUSMAINT_1361(){
        int a=dao.countXrefWithNoFamilyInGFSCustomer();
        assertEquals("GFS_ENTITY_XREF has gfs entity id (gfs customer id) not found in GFS_CUSTOMER",0,a);
    }

    /**
     * Test for CUSMAINT-1548 - Field level validation for Staged GFS_CUST_GROUP.cust_reln_mgr_id
     */
    @Test
    public void CUSMAINT_1548(){
        int a=dao.countStagedGFSCustGroupWithInvalidCrmId();
        assertEquals("Field level validation for Staged GFS_CUST_GROUP.cust_reln_mgr_id failed!",0,a);
    }
    
    /**
     * This method releases resources used during the tests.
     */
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
	
}//UploadValidationTest
