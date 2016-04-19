package com.gfs.integration.glazier.automation;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao;
import org.junit.Before;

/**
 * This class performs the integration tests for the epic "Load Glazier to GFS Legal Owner"
 * @author Mike Woodworth
 *
 */
public class GlazierInfoToLegalOwnerTest {
    
    /** DAO used to execute the queries. **/
    GlazierInfoToLegalOwnerDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets the instances need for the test.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (GlazierInfoToLegalOwnerDao) context.getBean("glazierLegalOwnerDao");
    }

    /**
     * Test for CUSMAINT_1209 - Verify staged GFS_CUSTOMER Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1209(){
        assertEquals("The number of staged GFS_CUSTOMER Legal Owner records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwners()),
                String.valueOf(dao.countStagedLegalOwnersInGFSCustomer()));		
    }

    /**
     * Test for CUSMAINT-1210 - Field level validation for Staged GFS_CUSTOMER (Where Parent Code <> 1)
     */
    @Test
    public void CUSMAINT_1210(){
        int a=dao.countStagedGFSCustomerWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUSTOMER failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT_1212 - Verify target GFS_CUSTOMER Legal Owner load from
     *staged GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1212(){
        assertEquals("The number of target GFS_CUSTOMER Legal Owner records does not equal Staged!",
                String.valueOf(dao.countStagedLegalOwnersInGFSCustomer()),
                String.valueOf(dao.countTargetLegalOwnersInGFSCustomer()));		
    }

    /**
     * Test for CUSMAINT_1213 - Verify staged GFS_CUST_LEGAL_OWNER Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1213(){
        assertEquals("The number of staged GFS_CUST_LEGAL_OWNER records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwners()),
                String.valueOf(dao.countStagedLegalOwnersInGFSCustLegalOwner()));		
    }

    /**
     * Test for CUSMAINT-1214 - Field level validation for Staged GFS_CUST_LEGAL_OWNER
     */
    @Test
    public void CUSMAINT_1214(){
        int a=dao.countStagedGFSCustLegalOwnerWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_LEGAL_OWNER failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1215 - Field level validation for Target GFS_CUST_LEGAL_OWNER
     */
    @Test
    public void CUSMAINT_1215(){
        int a=dao.countTargetGFSCustLegalOwnerWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUST_LEGAL_OWNER failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT_1236 - Verify staged LEGAL_OWNER_PRINCIPAL load
     * from Glazier Customer
     */
    @Test
    public void CUSMAINT_1236(){
        assertEquals("The number of staged LEGAL_OWNER_PRINCIPAL records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwnerPrincipal()),
                String.valueOf(dao.countStagedLegalOwnerPrincipal()));		
    }
    
    /**
     * Test for CUSMAINT_1237 - Verify staged LEGAL_OWNER_PRINCIPAL_ASGN load
     * from Glazier Customer
     */
    @Test
    public void CUSMAINT_1237(){
        assertEquals("The number of staged LEGAL_OWNER_PRINCIPAL_ASGN records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwnerPrincipalAssignments()),
                String.valueOf(dao.countStagedLegalOwnerPrincipalAsgn()));		
    }
    
    /**
     * Test for CUSMAINT-1238 - Verify staged LEGAL_OWNER_SIC load
     */
    @Test
    public void CUSMAINT_1238(){
        int a=dao.countStagedLegalOwnerSic();
        assertEquals("Staged LEGAL_OWNER_SIC has records and should not!",0,a);
    }

    /**
     * Test for CUSMAINT_1239 - Verify staged GFS_CUSTOMER_SITE Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1239(){
        assertEquals("The number of staged GFS_CUSTOMER_SITE Legal Owner records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwners()),
                String.valueOf(dao.countStagedLegalOwnersInGFSCustomerSite()));		
    }
    
    /**
     * Test for CUSMAINT-1240 - Field level validation for Staged LEGAL_OWNER_PRINCIPAL
     */
    @Test
    public void CUSMAINT_1240(){
        int a=dao.countStagedLegalOwnerPrincipalWithInvalidFields();
        assertEquals("Field level validation for STAGED LEGAL_OWNER_PRINCIPAL failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT_1241 - Verify target GFS_CUSTOMER_SITE Legal Owner load from
     * staged GFS_CUSTOMER_SITE
     */
    @Test
    public void CUSMAINT_1241(){
        assertEquals("The number of target GFS_CUSTOMER_SITE Legal Owner records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnersInGFSCustomerSite()),
                String.valueOf(dao.countTargetLegalOwnersInGFSCustomerSite()));		
    }
    
    /**
     * Test for CUSMAINT-1242 - Verify staged LEGAL_OWNER_BANK load
     */
    @Test
    public void CUSMAINT_1242(){
        int a=dao.countStagedLegalOwnerBank();
        assertEquals("Staged LEGAL_OWNER_BANK has records and should not!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1243 - Field level validation for Target GFS_CUSTOMER
     */
    @Test
    public void CUSMAINT_1243(){
        int a=dao.countTargetGFSCustomerWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUSTOMER failed!",0,a);
    }

    /**
     * Test for CUSMAINT_1244 - Verify target LEGAL_OWNER_PRINCIPAL load
     * from target LEGAL_OWNER_PRINCIPAL
     */
    @Test
    public void CUSMAINT_1244(){
        assertEquals("The number of target LEGAL_OWNER_PRINCIPAL records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnerPrincipal()),
                String.valueOf(dao.countTargetLegalOwnerPrincipal()));		
    }

    /**
     * Test for CUSMAINT_1246 - Verify target CRM_SITE Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1246(){
        assertEquals("The number of target CRM_SITE Legal Owner records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnersInCRMSite()),
                String.valueOf(dao.countTargetLegalOwnersInCRMSite()));		
    }
    
    /**
     * Test for CUSMAINT_1248 - Verify target LEGAL_OWNER_PRINCIPAL_ASGN load
     * from target LEGAL_OWNER_PRINCIPAL_ASGN
     */
    @Test
    public void CUSMAINT_1248(){
        assertEquals("The number of target LEGAL_OWNER_PRINCIPAL_ASGN records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnerPrincipalAsgn()),
                String.valueOf(dao.countTargetLegalOwnerPrincipalAsgn()));		
    }
    
    /**
     * Test for CUSMAINT-1249 - Verify target LEGAL_OWNER_SIC load
     */
    @Test
    public void CUSMAINT_1249(){
        int a=dao.countTargetLegalOwnerSic();
        assertEquals("Target LEGAL_OWNER_SIC has records and should not!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1250 - Verify target LEGAL_OWNER_BANK load
     */
    @Test
    public void CUSMAINT_1250(){
        int a=dao.countTargetLegalOwnerBank();
        assertEquals("Target LEGAL_OWNER_BANK has records and should not!",0,a);
    }

    /**
     * Test for CUSMAINT_1251 - Verify staged GFS_CUST_GROUP Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1251(){
        assertEquals("The number of staged GFS_CUST_GROUP Legal Owner records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwners()),
                String.valueOf(dao.countStagedLegalOwnersInGFSCustGroup()));		
    }
    
    /**
     * Test for CUSMAINT_1362 - Verify target GFS_CUST_LEGAL_OWNER Legal Owner load from
     * staged GFS_CUST_LEGAL_OWNER
     */
    @Test
    public void CUSMAINT_1362(){
        assertEquals("The number of target GFS_CUST_LEGAL_OWNER records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnersInGFSCustLegalOwner()),
                String.valueOf(dao.countTargetLegalOwnersInGFSCustLegalOwner()));		
    }

    /**
     * Test for CUSMAINT-1363 - Validate Target GFS_CUST_LEGAL_OWNER.credit_limit_dollar_amt field 
     */
    @Test
    public void CUSMAINT_1363(){
        int a=dao.countTargetGFSCustLegalOwnerWithInvalidCreditLimitDollarAmt();
        assertEquals("Field level validation for STAGED GFS_CUST_LEGAL_OWNER credit limit amount failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1366 - Field level validation for Staged LEGAL_OWNER_PRINCIPAL_ASGN
     */
    @Test
    public void CUSMAINT_1366(){
        int a=dao.countStagedLegalOwnerPrincipalAsgnWithInvalidFields();
        assertEquals("Field level validation for STAGED LEGAL_OWNER_PRINCIPAL_ASGN failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1367 - Field level validation for Target LEGAL_OWNER_PRINCIPAL
     */
    @Test
    public void CUSMAINT_1367(){
        int a=dao.countTargetLegalOwnerPrincipalWithInvalidFields();
        assertEquals("Field level validation for TARGET LEGAL_OWNER_PRINCIPAL failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1368 - Field level validation for Target LEGAL_OWNER_PRINCIPAL_ASGN
     */
    @Test
    public void CUSMAINT_1368(){
        int a=dao.countTargetLegalOwnerPrincipalAsgnWithInvalidFields();
        assertEquals("Field level validation for TARGET LEGAL_OWNER_PRINCIPAL_ASGN failed!",0,a);
    }

    /**
     * Test for CUSMAINT_1369 - Verify staged CRM_SITE Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1369(){
        assertEquals("The number of staged CRM_SITE Legal Owner records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwners()),
                String.valueOf(dao.countStagedLegalOwnersInCRMSite()));		
    }
    
    /**
     * Test for CUSMAINT_1370 - Verify target GFS_CUST_GROUP Legal Owner load from
     * staged GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1370(){
        assertEquals("The number of target GFS_CUST_GROUP Legal Owner records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnersInGFSCustGroup()),
                String.valueOf(dao.countTargetLegalOwnersInGFSCustGroup()));		
    }

    /**
     * Test for CUSMAINT-1371 - Field level validation for Staged GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1371(){
        int a=dao.countStagedGFSCustGroupWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUST_GROUP failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1372 - Field level validation for Target GFS_CUST_GROUP
     */
    @Test
    public void CUSMAINT_1372(){
        int a=dao.countTargetGFSCustGroupWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUST_GROUP failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1373 - Field level validation for Staged CRM_SITE
     */
    @Test
    public void CUSMAINT_1373(){
        int a=dao.countStagedCRMSiteWithInvalidFields();
        assertEquals("Field level validation for STAGED CRM_SITE failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1374 - Field level validation for Target CRM_SITE
     */
    @Test
    public void CUSMAINT_1374(){
        int a=dao.countTargetCRMSiteWithInvalidFields();
        assertEquals("Field level validation for TARGET CRM_SITE failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1375 - Field level validation for Staged GFS_CUSTOMER_SITE
     */
    @Test
    public void CUSMAINT_1375(){
        int a=dao.countStagedGFSCustomerSiteWithInvalidFields();
        assertEquals("Field level validation for STAGED GFS_CUSTOMER_SITE failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1376 - Field level validation for Target GFS_CUSTOMER_SITE
     */
    @Test
    public void CUSMAINT_1376(){
        int a=dao.countTargetGFSCustomerSiteWithInvalidFields();
        assertEquals("Field level validation for TARGET GFS_CUSTOMER_SITE failed!",0,a);
    }

    /**
     * Test for CUSMAINT_1378 - Verify staged CUSTOMER_CONTACT load
     * from Glazier Customer
     */
    @Test
    public void CUSMAINT_1378(){
        assertEquals("The number of staged CUSTOMER_CONTACT records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwnerPrincipalAssignments()),
                String.valueOf(dao.countStagedLegalOwnerCustomerContact()));		
    }

    /**
     * Test for CUSMAINT_1379 - Verify target CUSTOMER_CONTACT load
     * from staged CUSTOMER_CONTACT
     */
    @Test
    public void CUSMAINT_1379(){
        assertEquals("The number of target CUSTOMER_CONTACT records does not equal staged!",
                String.valueOf(dao.countStagedLegalOwnerCustomerContact()),
                String.valueOf(dao.countTargetLegalOwnerCustomerContact()));		
    }
 
    /**
     * Test for CUSMAINT-1380 - Field level validation for Staged CUSTOMER_CONTACT
     */
    @Test
    public void CUSMAINT_1380(){
        int a=dao.countStagedCustomerContactWithInvalidFields();
        assertEquals("Field level validation for STAGED CUSTOMER_CONTACT failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1380 - Field level validation for Target CUSTOMER_CONTACT
     */
    @Test
    public void CUSMAINT_1381(){
        int a=dao.countTargetCustomerContactWithInvalidFields();
        assertEquals("Field level validation for TARGET CUSTOMER_CONTACT failed!",0,a);
    }
    
    /**
     * Test for CUSMAINT-1403 - Verify Legal Owner records in GFS_ENTITY_XREF table 
     * have valid original entity id and gfs entity id
     */
    @Test
    public void CUSMAINT_1403(){
        assertEquals("GFS_ENTITY_XREF has null original or gfs entity id(s)",
                Integer.parseInt("0"), dao.countLegalOwnerXrefEntriesWithoutId());
    }
    
    /**
     * Test for CUSMAINT_1404 - Verify staged GFS_ENTITY_XREF Legal Owner load from
     * Glazier Customer
     */
    @Test
    public void CUSMAINT_1404(){
        assertEquals("The number of staged GFS_ENTITY_XREF Legal Owner records does not equal GLAZIER_CUSTOMER!",
                String.valueOf(dao.countGlazierLegalOwners()),
                String.valueOf(dao.countStagedLegalOwnersInGFSEntityXref()));		
    }
    
    /**
     * Test for CUSMAINT-1407 - Verify GFS_ENTITY_XREF.original_entity_id has 
     * matching GLAZIER_CUSTOMER.cust_nbr / GLAZIER_CUSTOMER.chain_code
     */
    @Test
    public void CUSMAINT_1407(){
        int a=dao.countXrefWithNoLegalOwnerInGlazierCust();
        assertEquals("GFS_ENTITY_XREF has original entity id (CUST NBR or CHAIN CODE) not found in GLAZIER_CUSTOMER",0,a);
    }
    
    /**
     * Test for CUSMAINT-1408 - Verify GFS_ENTITY_XREF.original_entity_id 
     * has matching GFS_CUSTOMER.gfs_customer_id
     */
    @Test
    public void CUSMAINT_1408(){
        int a=dao.countXrefWithNoLegalOwnerInGFSCustomer();
        assertEquals("GFS_ENTITY_XREF has gfs entity id (gfs customer id) not found in GFS_CUSTOMER",0,a);
    }

    /**
     * Test for CUSMAINT-1495 - Field level validation for Staged GFS_CUSTOMER (Where Parent Code = 1)
     */
    @Test
    public void CUSMAINT_1495(){
        int a=dao.countStagedGFSCustomerWithInvalidCustName();
        assertEquals("Field level validation of Avendra Cust Name (Staged GFS_CUSTOMER) failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1506 - Field level validation for Staged GFS_CUST_GROUP (Where Parent Code = 1)
     */
    @Test
    public void CUSMAINT_1506(){
        int a=dao.countStagedGFSCustGroupWithInvalidCustName();
        assertEquals("Field level validation of Avendra Cust Name (Staged GFS_CUST_GROUP) failed!",0,a);
    }

    /**
     * Test for CUSMAINT-1538 - Field level validation for Staged GFS_CUST_GROUP.cust_reln_mgr_id
     */
    @Test
    public void CUSMAINT_1538(){
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
