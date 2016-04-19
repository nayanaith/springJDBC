package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gfs.integration.glazier.automation.dao.GlazierCustomerNoteToGfsCustomerNoteDao;


public class GlazierCustomerNoteToGfsCustomerNoteTest {
    /** DAO used to execute the queries. **/
	GlazierCustomerNoteToGfsCustomerNoteDao dao;
    
    /** Application context used to get beans for the test. **/
    ApplicationContext context;

	@Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (GlazierCustomerNoteToGfsCustomerNoteDao) context.getBean("glazierCustomerNoteToGfsCustomerNoteDao");
    }//end setup
	
	@Test
	public void cusmaint_1711(){
		assertEquals("The number of Glazier Customer Notes does not equal Staged GFS_CUSTOMER_NOTE!",
	          dao.countGlazierCustomerNotes(),
	          dao.countStagedGFSCustomerNotes());
	}//end cusmaint_1645

	@Test
	public void cusmaint_1712(){
		assertEquals("There are invalid records in staged GFS_CUSTOMER_NOTE !",
	          dao.countStagedGFSCustomerNotesWithInvalidFields(),0);
	}//end cusmaint_1712
	
//	@Test
//	public void cusmaint_1718(){
		
//		assertEquals("Staged GFS CUSTOMER NOTE has invalid Add Date !",
//                         dao.count1stStgGFSCustNoteWithInvalidAddDate(),0);
//	}//end cusmaint_1718
	
	
	@Test
	public void cusmaint_1719(){
		assertEquals("The number of staged GFS_CUSTOMER_NOTE records does not equal target!",
	          dao.countTargetGFSCustomerNotes(),
	          dao.countStagedGFSCustomerNotes());
	}//end cusmaint_1719
	
	
	@Test
	public void cusmaint_1720(){
		assertEquals("There are invalid records in target GFS_CUSTOMER_NOTE !",
		          dao.countTargetGFSCustomerNotesWithInvalidFields(),
		          0);
	}//end cusmaint_1720
	
	@Test
	public void cusmaint_1721(){
		assertEquals("The number of Glazier Customer Notes does not equal Staged GFS_ENTITY_XREF !",
	          dao.countDistinctGlazierCustomerNotes(),
	          dao.countCustomerNotesInEntityXref());
	}//end cusmaint_1721
	
	
	@Test
	public void cusmaint_1722(){
		assertEquals("There are invalid records in GFS_ENTITY_XREF !",
		          dao.countGFSEntityXrefWithInvalidFields(),
		          0);
	}//end cusmaint_1722
	
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
}//end GlazierCustomerNoteToGfsCustomerNoteTest
