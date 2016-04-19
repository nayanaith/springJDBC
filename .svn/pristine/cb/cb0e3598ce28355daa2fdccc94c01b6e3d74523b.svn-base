package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.ShipToToCustomerMembershipDao;



public class ShipToToCustomerMembershipTest {
	/** DAO used to execute the queries. **/
	ShipToToCustomerMembershipDao dao;

	/** Application context used to get beans for the test. **/
	ApplicationContext context;
	
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (ShipToToCustomerMembershipDao) context.getBean("shipToToCustomerMembershipImplDao");
    }
    
    @Test
    public void CUSMAINT_1493(){
    	assertEquals("The number of staged Family GFS_CUST_GROUP_MEMBERSHIP records does not equal GLAZIER_CUSTOMER!",
            dao.countGlazierFamilyCust(),
            dao.countStagedFamiliesInCustGroupMembership());
    }//end CUSMAINT_1493
    
    @Test
    public void CUSMAINT_1494(){
    	assertEquals("There are invalid Family records in the staged GFS_CUST_GROUP_MEMBERSHIP",
            dao.countStagedFamilyGroupMembershipWithInvalidFields(),0);	
    }//end CUSMAINT_1494
    
    @Test
    public void CUSMAINT_1500(){
    	assertEquals("There are invalid Billing Agent records in the staged GFS_CUST_GROUP_MEMBERSHIP",
            dao.countStagedBillingAgentGroupMembershipWithInvalidFields(),0);	
    }//end CUSMAINT_1500
    
    @Test
    public void CUSMAINT_1501(){
    	assertEquals("The number of staged Billing Agent GFS_CUST_GROUP_MEMBERSHIP records does not equal GLAZIER_CUSTOMER!",
            dao.countGlazierBilToCust(),
            dao.countStagedBillingAgentsInCustGroupMembership());
    }//end CUSMAINT_1501
        
    @Test
    public void CUSMAINT_1502(){
    	assertEquals("There are invalid Legal Owner records in the staged GFS_CUST_GROUP_MEMBERSHIP",
            dao.countStagedLegalOwnerGroupMembershipWithInvalidFields(),0);	
    }//end CUSMAINT_1502
    
    @Test
    public void CUSMAINT_1507(){
    	assertEquals("The number of staged Legal Owner GFS_CUST_GROUP_MEMBERSHIP records does not equal GLAZIER_CUSTOMER!",
            dao.countGlazierLegalOwnerCust(),
            dao.countStagedLegalOwnersInCustGroupMembership());
    }//end CUSMAINT_1507
    
    @Test
    public void CUSMAINT_1508(){
    	assertEquals("The number of Staged Billing Agent GFS_CUST_GROUP_MEMBERSHIP records does not equal Target",
            dao.countStagedBillingAgentsInCustGroupMembership(),
            dao.countTargetBillingAgentsInCustGroupMembership());
    }//end CUSMAINT_1508
    
    @Test
    public void CUSMAINT_1509(){
    	assertEquals("There are invalid Billing Agent records in Target GFS_CUST_GROUP_MEMBERSHIP",
            dao.countTargetBillingAgentGroupMembershipWithInvalidFields(),0);	
    }//end CUSMAINT_1509

    @Test
    public void CUSMAINT_1723(){
    	assertEquals("The number of Staged Family GFS_CUST_GROUP_MEMBERSHIP records does not equal Target",
            dao.countStagedFamiliesInCustGroupMembership(),
            dao.countTargetFamiliesInCustGroupMembership());
    }//end CUSMAINT_1723

    @Test
    public void CUSMAINT_1724(){
    	assertEquals("There are invalid Family records in Target GFS_CUST_GROUP_MEMBERSHIP",
            dao.countTargetFamilyGroupMembershipWithInvalidFields(),0);	
    }//end CUSMAINT_1724
    
    @Test
    public void CUSMAINT_1725(){
    	assertEquals("The number of Staged Legal Owner GFS_CUST_GROUP_MEMBERSHIP records does not equal Target",
            dao.countStagedLegalOwnersInCustGroupMembership(),
            dao.countTargetLegalOwnersInCustGroupMembership());
    }//end CUSMAINT_1725
    
    @Test
    public void CUSMAINT_1726(){
    	assertEquals("There are invalid Legal Owner records in Target GFS_CUST_GROUP_MEMBERSHIP",
            dao.countTargetLegalOwnerGroupMembershipWithInvalidFields(),0);	
    }//end CUSMAINT_1726
    
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
}//end ShipToToCustomerMembershipTest
