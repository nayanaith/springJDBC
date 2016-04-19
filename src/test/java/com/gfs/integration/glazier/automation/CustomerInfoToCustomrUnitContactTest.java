package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gfs.integration.glazier.automation.dao.CustomerInfoToCustomrUnitContactDao;

public class CustomerInfoToCustomrUnitContactTest {
    /** DAO used to execute the queries. **/
	CustomerInfoToCustomrUnitContactDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;


	@Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (CustomerInfoToCustomrUnitContactDao) context.getBean("customerInfoToCustomrUnitContactDao");
    }//end setup
	
	@Test
	public void cusmaint_1645(){
		assertEquals("The number of staged ship to records in CUSTOMER_CONTACT are not equal to number of records Glazier_customer !",
	          dao.glzCustRecords(),
	          dao.shpToCustContact());
	}//end cusmaint_1645
	
	@Test
	public void cusmaint_1646(){
		assertEquals("There are invalid records in staged ship to records in CUSTOMER_CONTACT !",
	          dao.invldShptoStgCustomerContact(),
	          0);
	}//end cusmaint_1645
	
	@Test
	public void cusmaint_1647(){
		assertEquals("The number of staged ship to records in CUSTOMER_CONTACT_Mechanism are not equal to number of records Glazier_customer !",
	          dao.glzCustRecords(),
	          dao.shpToCustContactMechanism());
	}//end cusmaint_1647
	
	@Test
	public void cusmaint_1648(){
		assertEquals("There are invalid records in staged ship to records in CUSTOMER_CONTACT_MECHANISM !",
	          dao.invldStgShipToCustomerContactMechanism(),
	          0);
	}//end cusmaint_1648
	
	@Test
	public void cusmaint_1649(){
		assertEquals("The number of staged ship to records in GFS_CUST_CONTACT_ASGN  are not equal to number of records Glazier_customer !",
	          dao.glzCustRecords(),
	          dao.shpToCustContactAsgn());
	}//end cusmaint_1649
	
	@Test
	public void cusmaint_1650(){
		assertEquals("There are invalid records in staged ship to records in GFS_CUST_CONTACT_ASGN  !",
	          dao.invldStgShipToCustomerContactAsgn(),
	          0);
	}//end cusmaint_1650
	
	@Test
	public void cusmaint_1651(){
		assertEquals("The number of staged ship to records in CUSTOMER_CONTACT are not equal to same in target CUSTOMER_CONTACT !",
			dao.glzCustRecords(),
		    dao.targetShpToCustContact());
	}//end cusmaint_1651
	
	@Test
	public void cusmaint_1652(){
		assertEquals("There are invalid records in staged ship to records in CUSTOMER_CONTACT  !",
	          dao.invldTrgtShipToCustomerContact(),
	          0);
	}//end cusmaint_1652
	
	@Test
	public void cusmaint_1653(){
		assertEquals("The number of staged ship to records in CUSTOMER_CONTACT are not equal to same in target CUSTOMER_CONTACT !",
			dao.shpToCustContactMechanism(),
		    dao.trgtShpToCustContactMechanism());
	}//end cusmaint_1653
	
	@Test
	public void cusmaint_1654(){
		assertEquals("There are invalid records in target ship to records in CUSTOMER_CONTACT_MECHANISM !",
	          dao.invldTrgtShipToCustomerContactMechanism(),
	          0);
	}//end cusmaint_1654
	
	@Test
	public void cusmaint_1655(){
		assertEquals("The number of staged ship to records in GFS_CUST_CONTACT_ASGN are not equal to same in target GFS_CUST_CONTACT_ASGN !",
			dao.shpToCustContactAsgn(),
		    dao.trgtShpToCustContactAsgn());
	}//end cusmaint_1655
	
	@Test
	public void cusmaint_1656(){
		assertEquals("There are invalid records in target ship to records in GFS_CUST_CONTACT_ASGN !",
	          dao.invldTrgtShipToCustomerContactAsgn(),
	          0);
	}//end cusmaint_1656
	
	@Test
	public void cusmaint_1662(){
		assertEquals("The number of staged bill to records in CUSTOMER_CONTACT are not equal to same in Glazier_customer !",
			dao.bilToRecdsGlzCustomer(),
		    dao.bilToRecdsStgCustContact());
	}//end cusmaint_1662
	
	@Test
	public void cusmaint_1669(){
		assertEquals("There are invalid records in target bill to records in CUSTOMER_CONTACT !",
	          dao.invldStgBillToCustomerContact(),
	          0);
	}//end cusmaint_1669
	
	@Test
	public void cusmaint_1672(){
		assertEquals("The number of staged bill to records in CUSTOMER_CONTACT are not equal to same in Glazier_customer !",
			dao.bilToRecdsGlzCustomer(),
		    dao.bilToRecdsStgCustContactMechansm());
	}//end cusmaint_1672
	
	@Test
	public void cusmaint_1679(){
		assertEquals("There are invalid records in stage bill to records in CUSTOMER_CONTACT_MECHANISM !",
	          dao.invldStBilToCustomerContactMechanism(),
	          0);
	}//end cusmaint_1679
	
	@Test
	public void cusmaint_1680(){
		assertEquals("The number of staged bill to records in CUSTOMER_CONTACT_ASGN are not equal to same in Glazier_customer !",
			dao.bilToRecdsGlzCustomer(),
		    dao.bilToRecdsStgCustContactAsgn());
	}//end cusmaint_1680
	
	@Test
	public void cusmaint_1683(){
		assertEquals("There are invalid records in stage bill to records in GFS_CUST_CONTACT_ASGN !",
		          dao.invldStBilToCustomerContactAsgn(),
		          0);
	}//end cusmaint_1683
	
	@Test
	public void cusmaint_1684(){
		assertEquals("The number of staged bill to records in CUSTOMER_CONTACT_ASGN are not equal to same target !",
				dao.bilToRecdsStgCustContact(),
			    dao.bilToRecdsTrgtCustContact());
	}//end cusmaint_1684
	
	@Test
	public void cusmaint_1685(){
		assertEquals("There are invalid records in target bill to records in CUSTOMER_CONTACT !",
		          dao.invldTrgtBillToCustomerContact(),
		          0);
	}//end cusmaint_1685
	
	@Test
	public void cusmaint_1686(){
		assertEquals("The number of staged bill to records in CUSTOMER_CONTACT_MECHANISM are not equal to same target !",
				dao.bilToRecdsStgCustContactMechansm(),
			    dao.bilToRecdsTrgtCustContactMechansm());
	}//end cusmaint_1686
	
	@Test
	public void cusmaint_1687(){
		assertEquals("There are invalid records in target bill to records in CUSTOMER_CONTACT !",
		          dao.invldTrgtBilToCustomerContactMechanism(),
		          0);
	}//end cusmaint_1687
	
	@Test
	public void cusmaint_1688(){
		assertEquals("The number of staged bill to records in CUSTOMER_CONTACT_MECHANISM are not equal to same target !",
				dao.bilToRecdsStgCustContactAsgn(),
			    dao.bilToRecdsTrgtCustContactAsgn());
	}//end cusmaint_1688
	
	@Test
	public void cusmaint_1689(){
		assertEquals("There are invalid records in target bill to records in GFS_CUST_CONTACT_ASGN !",
		          dao.invldTrgtBilToCustomerContactAsgn(),
		          0);
	}//end cusmaint_1689
	
	@Test
	public void cusmaint_1690(){
		assertEquals("The number of contact records in GFS_ENTITY_XREF are not equal to Target !",
				dao.countGlzShipToBillToContacts(),
			    dao.billToShipToRcrdsGfsEntityXref1());

	}//end cusmaint_1690
	
	
	@Test
	public void cusmaint_1700(){
		assertEquals("There are invalid records in bill to and Ship to records in GFS_ENTITY_XREF !",
		          dao.invldGfsEntityXref(),
		          0);
	}//end cusmaint_1700
	
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
}//end CustomerInfoToCustomrUnitContactTest
