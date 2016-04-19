package com.gfs.integration.glazier.automation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.gfs.integration.glazier.automation.dao.ParentCodeToPmgDao;
import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ParentCodeToPmgTest {
	/** DAO used to execute the queries. **/
	ParentCodeToPmgDao dao;

	/** Application context used to get beans for the test. **/
	ApplicationContext context;
	
	@Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (ParentCodeToPmgDao) context.getBean("parentCodeToPmgDao");
    }//end setup
	
	@Test
	public void CUSMAINT_1518(){
    	assertEquals("The number of staged GFS_CUSTOMER PMG records does not equal GLAZIER_PARENT_CODE!",
                dao.countGlazierParentCodes(),
                dao.countParentCodesInGfsCustomer());
	}//end CUSMAINT_1518
	
	@Test
	public void CUSMAINT_1519(){
    	assertEquals("Field level validation for STAGED GFS_CUSTOMER PMG's failed!",
                dao.countStagedGFSCustomerPMGWithInvalidFields(),0);
 	}//end CUSMAINT_1519
	
	@Test
	public void CUSMAINT_1520(){
    	assertEquals("The number of staged GFS_CUST_GROUP PMG records does not equal GLAZIER_PARENT_CODE!",
                dao.countGlazierParentCodes(),
                dao.countParentCodesInGFSCustGroup());
 	}//end CUSMAINT_1520
	
	@Test
	public void CUSMAINT_1521(){
    	assertEquals("Field level validation for STAGED GFS_CUST_GROUP PMG's failed!",
                dao.countStagedGFSCustGroupPMGWithInvalidFields(),
                0);
 	}//end CUSMAINT_1521
	
	@Test
	public void CUSMAINT_1522(){
    	assertEquals("The number of staged GFS_CUSTOMER Super PMG records does not equal GLAZIER_PARENT_CODE!",
                 dao.countGlazierSuperPMG(),
                 dao.countStagedGFSCustomerSuperPMG());
    	
 	}//end CUSMAINT_1522
	
	@Test
	public void CUSMAINT_1523(){
    	assertEquals("Field level validation for STAGED GFS_CUSTOMER Super PMG's failed!",
                dao.countStagedGFSCustomerSuperPMGWithInvalidFields(),
                0);
 	}//end CUSMAINT_1523
	
	@Test
	public void CUSMAINT_1524(){
    	assertEquals("The number of staged GFS_CUST_GROUP Super PMG records does not equal GLAZIER_PARENT_CODE!",
                 dao.countGlazierSuperPMG(),
                 dao.countStagedGFSCustGroupSuperPMG());
 	}//end CUSMAINT_1524
		
	@Test
	public void CUSMAINT_1525(){
    	assertEquals("Field level validation for STAGED GFS_CUST_GROUP Super PMG's failed!",
                dao.countStagedGFSCustGroupSuperPMGWithInvalidFields(),
                0);
 	}//end CUSMAINT_1525
	
	@Test
	public void CUSMAINT_1526(){
    	assertEquals("The number of staged GFS_CUST_GROUP_MEMBERSHIP New PMG records does not equal GLAZIER_PARENT_CODE!",
                dao.countGlazierNewPMG(),
                dao.countStagedGFSCustGrpMemberNewPMG());
 	}//end CUSMAINT_1526
	
	@Test
	public void CUSMAINT_1527(){
    	assertEquals("There are invalid glazier new pmg records in gfs_cust_grp_membership!",
                dao.invldNewPmgStgGfsCustGrpMemship(),
                0);
 	}//end CUSMAINT_1527
	
	@Test
	public void CUSMAINT_1528(){
    	assertEquals("The number of staged glazier existing pmg records are not equal to number of records in GFS_CUST_GROUP_MEMBERSHIP!",
                dao.exstngPmgGlzPmg(),
                dao.exstngPmgStgGfsCustGrpMemshp());
 	}//end CUSMAINT_1528
	
	@Test
	public void CUSMAINT_1529(){
    	assertEquals("There are invalid glazier existing pmg records in gfs_cust_grp_membership!",
                dao.invldExtngPmgStgGfsCustGrpMemship(),
                0);
 	}//end CUSMAINT_1529
	
	@Test
	public void CUSMAINT_1530(){
    	assertEquals("The number of staged PMG glazier records are not equal to number of records in target gfs_customer!",
                dao.stgPmgRecordsGfsCust(),
                dao.trgtPmgRecordsGfsCust());
 	}//end CUSMAINT_1530
	
	@Test
	public void CUSMAINT_1531(){
    	assertEquals("There are invalid glazier existing pmg records in gfs_cust_grp_membership!",
                dao.invldPmgTrgtGfsCustCustomer(),
                0);
 	}//end CUSMAINT_1531
	
	@Test
	public void CUSMAINT_1532(){
    	assertEquals("The number of staged PMG glazier records are not equal to number of records in target gfs_customer!",
                dao.stgSprPmgRecordsGfsCust(),
                dao.trgtSprPmgRecordsGfsCust());
 	}//end CUSMAINT_1532
	
	@Test
	public void CUSMAINT_1533(){
    	assertEquals("There are invalid glazier existing pmg records in gfs_customer!",
                dao.invldSprPmgTrgtGfsCustCustomer(),
                0);
 	}//end CUSMAINT_1533
	
	@Test
	public void CUSMAINT_1534(){
    	assertEquals("The number of staged PMG glazier records are not equal to number of records in target GFS_CUST_GROUP!",
                dao.stgPmgRecordsGfsCustGrp(),
                dao.trgtPmgRecordsGfsCustGrp());
 	}//end CUSMAINT_1534
	
	@Test
	public void CUSMAINT_1535(){
    	assertEquals("There are invalid glazier existing pmg records in GFS_CUST_GROUP!",
                dao.invldPmgTrgtGfsCustomerGrp(),
                0);
 	}//end CUSMAINT_1535

	@Test
	public void CUSMAINT_1536(){
    	assertEquals("The number of staged super PMG glazier records 1 are not equal to number of records in target GFS_CUST_GROUP!",
                dao.stgSprPmgRecordsGfsCustGrp1(),
                dao.trgtSprPmgRecordsGfsCustGrp1());
    	
//    	assertEquals("The number of staged super PMG glazier records 2 are not equal to number of records in target GFS_CUST_GROUP!",
//                dao.stgSprPmgRecordsGfsCustGrp1(),
//                dao.trgtSprPmgRecordsGfsCustGrp2());
    	
//    	assertEquals("The number of staged super PMG glazier records 3 are not equal to number of records in target GFS_CUST_GROUP!",
//                dao.stgSprPmgRecordsGfsCustGrp2(),
//                dao.trgtSprPmgRecordsGfsCustGrp1());
    	
//    	assertEquals("The number of staged super PMG glazier records 4 are not equal to number of records in target GFS_CUST_GROUP!",
//                dao.stgSprPmgRecordsGfsCustGrp2(),
//                dao.trgtSprPmgRecordsGfsCustGrp2());
 	}//end CUSMAINT_1536
	
	@Test
	public void CUSMAINT_1537(){
    	assertEquals("There are invalid glazier super pmg records in GFS_CUST_GROUP!",
                dao.invldSuprPmgTrgtGfsCustomerGrp(),
                0);
 	}//end CUSMAINT_1537
	
	@Test
	public void CUSMAINT_1539(){
    	assertEquals("The number of staged PMG glazier records are not equal to target GFS_CUST_GRP_Membership table!",
                dao.stgNwPmgRecordsGfsCustGrpMemship(),
                dao.trgtNwPmgRecordsGfsCustGrpMemship());
 	}//end CUSMAINT_1539
	
	@Test
	public void CUSMAINT_1540(){
    	assertEquals("There are invalid glazier new pmg records in GFS_CUST_GRP_Membership table!",
                dao.invldNwPmgTrgtGfsCustomerGrpMemship(),
                0);
 	}//end CUSMAINT_1540
	
	@Test
	public void CUSMAINT_1541(){
    	assertEquals("The number of staged PMG glazier records are not equal to number of records in target GFS_CUST_GRP_Membership table!",
                dao.stgExtnPmgRecordsGfsCustGrpMemship(),
                dao.trgtExtnPmgRecordsGfsCustGrpMemship());
 	}//end CUSMAINT_1539
	
	@Test
	public void CUSMAINT_1542(){
    	assertEquals("There are invalid glazier existing pmg records in GFS_CUST_GRP_Membership table!",
                dao.invldExtnPmgTrgtGfsCustomerGrpMemship(),
                0);
 	}//end CUSMAINT_1540
	
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
}//ParentCodeToPmgDaoTest
