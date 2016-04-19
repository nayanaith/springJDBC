package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gfs.integration.glazier.automation.dao.ChainMembershipToPmgMembershipDao;


public class ChainMembershipToPmgMembershipTest {
    /** DAO used to execute the queries. **/
	ChainMembershipToPmgMembershipDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;


	@Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (ChainMembershipToPmgMembershipDao) context.getBean("chainMembershipToPmgMembershipDao");
    }//end setup
	
	
	@Test
	public void CUSMAINT_1549(){
	assertEquals("The number of staged glazier customer records are not equal to number of records in stg GFS_CUST_GRP_MEMBERSHIP !",
            dao.recordsInGlzcustomer(),
            dao.recordsInGfsCustGrpMemship());
	}//end custmaint_1549

	@Test
	public void CUSMAINT_1551(){
	assertEquals("The stg GFS_CUST_GRP_MEMBERSHIP table has been loaded with invalid records",
            dao.invldsInGfsCustGrpMemship(),0);
	}//end custmaint_1551
	

	@Test
	public void CUSMAINT_1552(){
	assertEquals("The target GFS_CUST_GRP_MEMBERSHIP table has been loaded with invalid records!",
            dao.invldsInTrgtGfsCustGrpMemship(),0);
	}//end custmaint_1552
	
	@Test
	public void CUSMAINT_1553(){
	assertEquals("The number of staged GFS_CUST_GRP_MEMBERSHIP records are not equal to number of records target GFS_CUST_GRP_MEMBERSHIP!",
            dao.recordsInTrgtGfsCustGrpMemship(),
            dao.recordsInGfsCustGrpMemship());
	}//end custmaint_1553

    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing

}//end ChainMembershipToPmgMembershipTest