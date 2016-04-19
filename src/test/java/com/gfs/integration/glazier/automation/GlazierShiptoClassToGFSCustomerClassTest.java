package com.gfs.integration.glazier.automation;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao;
import org.junit.Before;

/**
 * This class performs the integration tests for the epic "Load GFS Customer Unit 
 * Classifications from Glazier Ship To Classifications"
 * @author Mike Woodworth
 *
 */
public class GlazierShiptoClassToGFSCustomerClassTest {
    
    /** DAO used to execute the queries. **/
    GlazierShiptoClassToGFSCustomerClassDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets the instances need for the test.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (GlazierShiptoClassToGFSCustomerClassDao) context.getBean("glazierCustClassDao");
    }

    /**
     * Test for CUSMAINT_1473 - Verify staged CUSTOMER_CLASS_MEMBER (Sub Class)
     * load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1473(){
        assertEquals("The number of staged CCM Sub-Class records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedCCMSubClasses()));		
    }

    /**
     * Test for CUSMAINT_1474 - Verify staged CUSTOMER_CLASS_MEMBER (Affiliation)
     * load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1474(){
        assertEquals("The number of staged CCM Affiliation records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedCCMAffiliations()));		
    }

    /**
     * Test for CUSMAINT_1475 - Verify staged CUSTOMER_CLASS_MEMBER (Menu Themes)
     * load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1475(){
        assertEquals("The number of staged CCM Menu Theme records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedCCMMenuThemes()));		
    }

    /**
     * Test for CUSMAINT_1476 - Verify staged CUSTOMER_CLASS_MEMBER (Mgmt Types)
     * load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1476(){
        assertEquals("The number of staged CCM Mgmt Type records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierCustomerUnits()),
                String.valueOf(dao.countStagedCCMMgmtType()));		
    }

    /**
     * Test for CUSMAINT_1477 - Verify target CUSTOMER_CLASS_MEMBER (Sub Class) 
     * load from staged CUSTOMER_CLASS_MEMBER
     */
    @Test
    public void CUSMAINT_1477(){
        assertEquals("The number of target CUSTOMER_CLASS_MEMBER (Sub Class) records does not equal Staged!",
                String.valueOf(dao.countStagedCCMSubClasses()),
                String.valueOf(dao.countTargetCCMSubClasses()));		
    }

    /**
     * Test for CUSMAINT_1478 - Verify target CUSTOMER_CLASS_MEMBER (Affiliations) 
     * load from staged CUSTOMER_CLASS_MEMBER
     */
    @Test
    public void CUSMAINT_1478(){
        assertEquals("The number of target CUSTOMER_CLASS_MEMBER (Affiliation) records does not equal Staged!",
                String.valueOf(dao.countStagedCCMAffiliations()),
                String.valueOf(dao.countTargetCCMAffiliations()));		
    }
 
    /**
     * Test for CUSMAINT_1479 - Verify target CUSTOMER_CLASS_MEMBER (Menu Themes) 
     * load from staged CUSTOMER_CLASS_MEMBER
     */
    @Test
    public void CUSMAINT_1479(){
        assertEquals("The number of target CUSTOMER_CLASS_MEMBER (Menu Themes) records does not equal Staged!",
                String.valueOf(dao.countStagedCCMMenuThemes()),
                String.valueOf(dao.countTargetCCMMenuThemes()));		
    }

    /**
     * Test for CUSMAINT_1480 - Verify target CUSTOMER_CLASS_MEMBER (Mgmt Types) 
     * load from staged CUSTOMER_CLASS_MEMBER
     */
    @Test
    public void CUSMAINT_1480(){
        assertEquals("The number of target CUSTOMER_CLASS_MEMBER (Mgmt Type) records does not equal Staged!",
                String.valueOf(dao.countStagedCCMMgmtType()),
                String.valueOf(dao.countTargetCCMMgmtType()));		
    }
    
    /**
     * Test for CUSMAINT-1481 - Field level validation for Staged CUSTOMER_CLASS_MEMBER (Sub Class)
     */
    @Test
    public void CUSMAINT_1481(){
        int a=dao.countStagedCCMSubClassesWithInvalidFields();
        assertEquals("Field level validation for Staged CUSTOMER_CLASS_MEMBER Sub Classes failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1482 - Field level validation for Target CUSTOMER_CLASS_MEMBER (Sub Class)
     */
    @Test
    public void CUSMAINT_1482(){
        int a=dao.countTargetCCMSubClassesWithInvalidFields();
        assertEquals("Field level validation for Target CUSTOMER_CLASS_MEMBER Sub Classes failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1483 - Field level validation for Staged CUSTOMER_CLASS_MEMBER (Affiliation)
     */
    @Test
    public void CUSMAINT_1483(){
        int a=dao.countStagedCCMAffiliationsWithInvalidFields();
        assertEquals("Field level validation for Staged CUSTOMER_CLASS_MEMBER Affiliations failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1484 - Field level validation for Target CUSTOMER_CLASS_MEMBER (Affiliation)
     */
    @Test
    public void CUSMAINT_1484(){
        int a=dao.countTargetCCMAffiliationsWithInvalidFields();
        assertEquals("Field level validation for Target CUSTOMER_CLASS_MEMBER Affiliations failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1485 - Field level validation for Staged CUSTOMER_CLASS_MEMBER (Menu Themes)
     */
    @Test
    public void CUSMAINT_1485(){
        int a=dao.countStagedCCMMenuThemesWithInvalidFields();
        assertEquals("Field level validation for Staged CUSTOMER_CLASS_MEMBER Menu Themes failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1486 - Field level validation for Target CUSTOMER_CLASS_MEMBER (Menu Theme)
     */
    @Test
    public void CUSMAINT_1486(){
        int a=dao.countTargetCCMMenuThemesWithInvalidFields();
        assertEquals("Field level validation for Target CUSTOMER_CLASS_MEMBER Menu Themes failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1489 - Field level validation for Staged CUSTOMER_CLASS_MEMBER (Mgmt Types)
     */
    @Test
    public void CUSMAINT_1489(){
        int a=dao.countStagedCCMMgmtTypesWithInvalidFields();
        assertEquals("Field level validation for Staged CUSTOMER_CLASS_MEMBER Mgmt Types failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1490 - Field level validation for Target CUSTOMER_CLASS_MEMBER (Mgmt Type)
     */
    @Test
    public void CUSMAINT_1490(){
        int a=dao.countTargetCCMMgmtTypeWithInvalidFields();
        assertEquals("Field level validation for Target CUSTOMER_CLASS_MEMBER Mgmt Type failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1642 - Field level validation for Staged 
     * GFS_CUST_UNIT.fuel_surcharge_eligible_ind
     */
    @Test
    public void CUSMAINT_1642(){
        int a=dao.countStagedGFSCustUnitWithInvalidFuelSurcharge();
        assertEquals("Field level validation for STAGED GFS_CUST_UNIT.fuel_surcharge failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1644 - Field level validation for Target 
     * GFS_CUST_UNIT.fuel_surcharge_eligible_ind
     */
    @Test
    public void CUSMAINT_1644(){
        int a=dao.countTargetGFSCustUnitWithInvalidFuelSurcharge();
        assertEquals("Field level validation for TARGET GFS_CUST_UNIT.fuel_surcharge failed!",0,a);
    }
    
    /**
     * This method releases resources used during the tests.
     */
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
	
}//UploadValidationTest
