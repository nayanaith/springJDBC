package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.AvendraMembrshpToPmgMembrshpDao;

public class AvendraMembrshpToPmgMembrshpTest {
    /** DAO used to execute the queries. **/
	AvendraMembrshpToPmgMembrshpDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;
    
    /**
     * This method sets up the instances prior to the tests running.
     */
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (AvendraMembrshpToPmgMembrshpDao) context.getBean("avendraMembrshpToPmgMembrshpDao");
    }
    
    @Test
    public void CUSMAINT_1560(){
        assertEquals("The number of staged Glazier Avendra records does not equal Glazier Avendra file!",
            dao.exstingPmgRecordsInGlzAvndra(),
            dao.exstingPmgRecordsInGlzAvndraInStgGfs_Cust());
    }//end CUSMAINT_1560
    
    @Test
    public void CUSMAINT_1564(){
        assertEquals("GFS_Customers have invalid records due to imported Glazier Avendra file!",
                dao.invldRecordsInGlzAvndraInStgGfs_Cust(),0);

    }//end CUSMAINT_1564
    
    @Test
    public void CUSMAINT_1567(){
        assertEquals("The number of staged Gfs_cust_group records does not equal Glazier Avendra file!",
                        dao.exstingPmgRecordsInGlzAvndraInStgGfs_CustGrp(),
        		dao.exstingPmgRecordsInGlzAvndra());
    }//end CUSMAINT_1567
    
    @Test
    public void CUSMAINT_1569(){
        assertEquals("1 GFS_Cust_Grp have invalid records due to imported Glazier Avendra file!",
                dao.invldRecordsInGlzAvndraInStgGfs_CustGrp(),0);
        
    }//end CUSMAINT_1569
    
    @Test
    public void CUSMAINT_1573(){
        assertEquals("1 GFS_Cust_Grp have invalid records due to imported Glazier Avendra file!",
        		dao.exstingPmgRecordsInGfsCustGrpMembershp(),
        		dao.countGlazierAvendraCustomers());
    }//end CUSMAINT_1573
    
        
    @Test
    public void CUSMAINT_1574(){
        assertEquals("GFS_CUST_GROUP_MEMBERSHIP have invalid records due to imported Glazier Avendra file!",
                dao.invldRecordsInGlzAvndraInStgGfsCustGrpMembrship(),0);
    }//end CUSMAINT_1574
    
    
    @Test
    public void CUSMAINT_1575(){
        assertEquals("staged GFS_CUST_GRP_MEMBERSHIP imported from Glazier Avendra file not equal to target GFS_CUST_GRP_MEMBERSHIP!",
        		dao.glzAvndraRecrdsInStgGfsCustGrpMembrshp(),
        		dao.glzAvndraRecrdsInTrgtGfsCustGrpMembrshp());
    }//end CUSMAINT_1575
    
    @Test
    public void CUSMAINT_1576(){
        assertEquals("target GFS_CUST_GROUP_MEMBERSHIP have invalid records due to imported Glazier Avendra file!",
                dao.invldRecordsInGlzAvndraInTrgtGfsCustGrpMembrship(),0);
    }//end CUSMAINT_1576
    
    @Test
    public void CUSMAINT_1577(){
        assertEquals("staged GFS_CUST_GRP_MEMBERSHIP imported from Glazier Avendra file not equal to target GFS_CUST_GRP_MEMBERSHIP!",
        		dao.exstingPmgRecordsInGlzAvndraInStgGfs_Cust(),
        		dao.exstingPmgRecordsInGlzAvndraInTrgtgGfs_Cust());
    }//end CUSMAINT_1577
    
    @Test
    public void CUSMAINT_1578(){
        assertEquals("target GFS_CUSTOMER have invalid records due to imported Glazier Avendra file!",
                dao.invldRecordsInGlzAvndraInTrgtGfsCust(),0);
    }//end CUSMAINT_1578
    
    @Test
    public void CUSMAINT_1579(){
        assertEquals("staged GFS_CUST_GROUP imported from Glazier Avendra file not equal to target GFS_CUST_GROUP!",
        		dao.glzAvndraRecrdsInStgGfsCustGrp(),
        		dao.glzAvndraRecrdsInTrgtGfsCustGrp());
    }//end CUSMAINT_1579
    
    @Test
    public void CUSMAINT_1580(){
        assertEquals("target GFS_CUST_GROUP have invalid records due to imported Glazier Avendra file!",
                dao.invldRecordsInGlzAvndraInTrgtGfsCustGrp(),0);
    }//end CUSMAINT_1580
    
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
    
}//end AvendraMembrshpToPmgMembrshpTest
