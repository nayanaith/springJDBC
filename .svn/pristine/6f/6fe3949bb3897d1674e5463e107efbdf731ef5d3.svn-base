package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao;

public class GlzrShpToAdrsInfoToGFScustUnitSiteInfoTest{

    /** DAO used to execute the queries. **/
	GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao) context.getBean("glzrShpToAdrsInfoToGFScustUnitSiteInfoDao");
    }
    
    @Test
    public void CUSMAINT_1487(){
        assertEquals("The number of staged CRM_SITE records does not equal GLAZIER_CUSTOMER!",
                dao.countGlazierCust(),
                dao.crmSiteGlazierRecords());		
    }
    
    @Test
    public void CUSMAINT_1488(){
        assertEquals("The number of target CRM_SITE records does not equal staged CRM_SITE!",
                dao.bilingAgntStgCrmSite(),
                dao.targetAgntStgCrmSite());		
    }
    
    @Test
    public void CUSMAINT_1491(){
        assertEquals("There are invalid customer unit site records in the staged crm_site",
                dao.stgInvalidCustomerSiteRecords(),0);		
    }
    
    @Test
    public void CUSMAINT_1492(){
        assertEquals("There are invalid customer unit site records in the target crm_site",
                dao.trgtInvalidCustomerSiteRecords(),0);		
    }
    
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
}//end GlzrShpToAdrsInfoToGFScustUnitSiteInfoTest
