package com.gfs.integration.glazier.automation;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao;
import org.junit.Before;

/**
 * This class performs the integration tests for the epic "Load Glazier BillTo to GFS BillTo"
 * @author Naya Bandara
 *
 */
public class BilltoToBilltoTest {
    
    /** DAO used to execute the queries. **/
    BilltoToBilltoDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets up the instances prior to the tests running.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (BilltoToBilltoDao) context.getBean("glazierBilltoDao");
    }
    
    /**
    * Test for CUSMAINT-1158 - Verify staged GFS_CUST_BILLING_AGENT load from Glazier Customer
    */
    @Test
    public void CUSMAINT_1158(){
        assertEquals("The number of staged GFS_CUST_BILLING_AGENT records does not equal GLAZIER_CUSTOMER!",
            String.valueOf(dao.countGlazierBillto()),
            String.valueOf(dao.countStagedGlazierBillto()));
    }
    
    /**
     * Test for CUSMAINT-1159 - Verify staged GFS_CUSTOMER load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1159(){
        assertEquals("The number of staged Billing Agents in GFS_CUSTOMER does not equal GLAZIER_CUSTOMER!",
            String.valueOf(dao.countGlazierBillto()),
            String.valueOf(dao.countStagedGlazierBilltoGFSCustomer()));
    }
    
    /**
     * Test for CUSMAINT-1160 - Field level validation for Staged GFS_CUST_BILLING_AGENT
     */
    @Test
    public void CUSMAINT_1160(){
        assertEquals("Field level validation for Staged GFS_CUST_BILLING_AGENT failed!",
                String.valueOf(0),String.valueOf(dao.countStagedGlazierBilltoWithInvalidFields()));		
    }
    
    /**
     * Test for CUSMAINT-1161 - Verify target GFS_CUST_BILLING_AGENT load from 
     * staged GFS_CUST_BILLING_AGENT
     */
    @Test
    public void CUSMAINT_1161(){
        assertEquals("The number of target Billing Agents in GFS_CUST_BILLING_AGENT does not equal staged!",
                String.valueOf(dao.countStagedGlazierBillto()),
                String.valueOf(dao.countTargetGlazierBillto()));		
    }
    
    /**
     * Test for CUSMAINT-1163 - Field level validation for Target
     * GFS_CUST_BILLING_AGENT
     */
    @Test
    public void CUSMAINT_1163(){
        assertEquals("Field level validation for Target GFS_CUST_BILLING_AGENT failed!",
                String.valueOf(0),String.valueOf(dao.countTargetGlazierBilltoWithInvalidFields()));		
    }
    
    /**
     * Test for CUSMAINT-1164 - Verify target GFS_CUST_GROUP load from 
     * staged GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1164(){
        assertEquals("The number of target Billing Agents in GFS_CUST_GROUP does not equal staged!",
                String.valueOf(dao.countStagedGlazierBilltoGFSCustGroup()),
                String.valueOf(dao.countTargetGlazierBilltoGFSCustGroup()));
    }    
     
    /**
     * Test for CUSMAINT-1179 - Verify target GFS_CUSTOMER_SITE load from 
     * staged GFS_CUSTOMER_SITE
     */
    @Test
    public void CUSMAINT_1179(){
        assertEquals("The number of staged Billing Agents in GFS_CUSTOMER_SITE does not equal target!",
                String.valueOf(dao.countStagedGlazierBilltoGFSCustomerSite()),
                String.valueOf(dao.countTargetGlazierBilltoGFSCustomerSite()));
    }
    
    /**
     * Test for CUSMAINT-1198 - Verify staged GFS_CUSTOMER_SITE load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1198(){
        assertEquals("The number of staged Billing Agents in GFS_CUSTOMER_SITE does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierBillto()),
                String.valueOf(dao.countStagedGlazierBilltoGFSCustomerSite()));
    }
    
    /**
     * Test for CUSMAINT-1199 - Verify GFS_ENTITY_XREF.original_entity_id has 
     * matching GLAZIER_CUSTOMER.cust_nbr
     */
    @Test
    public void CUSMAINT_1199(){
        int a=dao.countXrefWithNoBillingAgentInGlazierCust();
        assertEquals("GFS_ENTITY_XREF has original entity id not found in GLAZIER_CUSTOMER",0,a);
    }
    
        /**
     * Test for CUSMAINT-1200 - Verify staged GFS_ENTITY_XREF load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1200(){
        assertEquals("The number of staged Billing Agents in GFS_ENTITY_XREF does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierBillto()),
                String.valueOf(dao.countStagedGlazierBilltoXref()));
    }
    
    /**
     * Test for CUSMAINT-1201 - Verify all Billing Agent records in GFS_ENTITY_XREF 
     * table have valid original entity id and gfs entity id
     */
    @Test
    public void CUSMAINT_1201(){
        assertEquals("GFS_ENTITY_XREF has null original or gfs entity id's",
                Integer.parseInt("0"), dao.countBillingAgentXrefEntriesWithoutId());
    }
    
    /**
     * Test for CUSMAINT-1202 - Verify target GFS_CUSTOMER load from staged GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1202(){
        assertEquals("The number of staged Billing Agents in GFS_CUSTOMER does not equal target!",
                String.valueOf(dao.countStagedGlazierBilltoGFSCustomer()),
                String.valueOf(dao.countTargetGlazierBilltoGFSCustomer()));		
    }
    
    /**
     * Test for CUSMAINT-1203 - Verify GFS_ENTITY_XREF.gfs_entity_id has matching 
     * GFS_CUSTOMER.gfs_customer_id
     */
    @Test
    public void CUSMAINT_1203(){
        int a=dao.countXrefWithNoBillingAgentInGFSCustomer();
        assertEquals("GFS_ENTITY_XREF has gfs entity id(s) not found in GFS_CUSTOMER",0,a);		
    }

    /**
     * Test for CUSMAINT-1206 - Verify staged GFS_CUST_GROUP load from 
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1206(){
        assertEquals("The number of staged Billing Agents in GFS_CUST_GROUP does not equal GLAZIER_CUSTOMER!",
                (String.valueOf(dao.countGlazierBillto())),
                 String.valueOf(dao.countStagedGlazierBilltoGFSCustGroup()));		
    }

    /**
     * Test for CUSMAINT-1207 - Verify staged CRM_SITE load from Glazier Customer
     */
    @Test
    public void CUSMAINT_1207(){
        assertEquals("The number of staged Billing Agents in CRM_SITE does not equal GLAZIER_CUSTOMER!",
            (String.valueOf(dao.countGlazierBillto())),
             String.valueOf(dao.countStagedGlazierBilltoCRMSite()));
    }
    
    /**
     * Test for CUSMAINT-1208 - Verify target CRM_SITE load from staged CRM_SITE
     */
    @Test
    public void CUSMAINT_1208(){
        assertEquals("The number of staged Billing Agents in CRM_SITE does not equal target!",
                String.valueOf(dao.countStagedGlazierBilltoCRMSite()),
                String.valueOf(dao.countTargetGlazierBilltoCRMSite()));		
    }
    
    /**
     * Test for CUSMAINT-1262 - Field level validation for Staged GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1262(){
        assertEquals("Field level validation for STAGED GFS_CUST_GROUP failed!",
                String.valueOf(0),String.valueOf(dao.countStagedGlazierBilltoGFSCustGroupWithInvalidFields()));		
    } 
    
    /**
     * Test for CUSMAINT-1265 - Field level validation for Staged GFS_CUSTOMER_SITE
     */
    @Test
    public void CUSMAINT_1265(){
        assertEquals("Field level validation for STAGED GFS_CUSTOMER_SITE failed!",
                String.valueOf(0),String.valueOf(dao.countStagedGlazierBilltoGFSCustomerSiteWithInvalidFields()));		
    }     

    /**
     * Test for CUSMAINT-1266 - Field level validation for Staged CRM_SITE
     */
    @Test
    public void CUSMAINT_1266(){
        assertEquals("Field level validation for STAGED CRM_SITE failed!",
                String.valueOf(0),String.valueOf(dao.countStagedGlazierBilltoCRMSiteWithInvalidFields()));		
    }

    /**
     * Test for CUSMAINT-1267 - Field level validation for Staged GFS Customer
     */
    @Test
    public void CUSMAINT_1267(){
        assertEquals("Field level validation for Staged GFS_CUSTOMER failed!",
                String.valueOf(0),String.valueOf(dao.countStagedGlazierBilltoGFSCustomerWithInvalidFields()));		
    }
    
        /**
     * Test for CUSMAINT-1268 - Field level validation for Target GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1268(){
        assertEquals("Field level validation for Target GFS_CUST_GROUP failed!",
                String.valueOf(0),String.valueOf(dao.countTargetGlazierBilltoGFSCustGroupWithInvalidFields()));		
    }

    /**
     * Test for CUSMAINT-1269 - Field level validation for Target GFS_CUSTOMER_SITE
     */
    @Test
    public void CUSMAINT_1269(){
        assertEquals("Field level validation for Target GFS_CUSTOMER_SITE failed!",
                String.valueOf(0),String.valueOf(dao.countTargetGlazierBilltoGFSCustomerSiteWithInvalidFields()));		
    }
    
    /**
     * Test for CUSMAINT-1270 - Field level validation for Target CRM_SITE
     */
    @Test
    public void CUSMAINT_1270(){
        assertEquals("Field level validation for Target CRM_SITE failed!",
                String.valueOf(0),String.valueOf(dao.countTargetGlazierBilltoCRMSiteWithInvalidFields()));		
    }
    
    /**
     * Test for CUSMAINT-1271 - Field level validation for Target GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1271(){
        assertEquals("Field level validation for Target GFS_CUSTOMER failed!",
                String.valueOf(0),String.valueOf(dao.countTargetGlazierBilltoGFSCustomerWithInvalidFields()));		
    }    
    
    /**
     * Test for CUSMAINT-1272 - Check the validity of the target
     * GFS_CUST_BILLING_AGENT.customer_bill_to_unit field
     */
    @Test
    public void CUSMAINT_1272(){
        assertEquals("Validation for Target GFS_CUST_BILLING_AGENT.customer_bill_to_unit failed!",
                String.valueOf(0),String.valueOf(dao.countTargetInvalidBilltoUnits()));		
    }    

    /**
     * This method releases resources used during the tests.
     */
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
	
}//UploadValidationTest
