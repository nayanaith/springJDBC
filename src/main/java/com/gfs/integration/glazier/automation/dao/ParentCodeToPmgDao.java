package com.gfs.integration.glazier.automation.dao;

public interface ParentCodeToPmgDao {
	public int countGlazierParentCodes();
	
	public int countParentCodesInGfsCustomer();
	
	public int countStagedGFSCustomerPMGWithInvalidFields();
	
	public int countParentCodesInGFSCustGroup();
	
	public int countStagedGFSCustGroupPMGWithInvalidFields();
	
	public int countGlazierSuperPMG();
	
	public int countStagedGFSCustomerSuperPMG();
	
	public int countStagedGFSCustomerSuperPMGWithInvalidFields();
	
	public int countStagedGFSCustGroupSuperPMG();
	
	public int sprPmgInGfsCustGrp2();
	
	public int countStagedGFSCustGroupSuperPMGWithInvalidFields();
	
	public int countGlazierNewPMG();
	
	public int countStagedGFSCustGrpMemberNewPMG();
	
	public int invldNewPmgStgGfsCustGrpMemship();
	
	public int exstngPmgGlzPmg();
	
	public int exstngPmgStgGfsCustGrpMemshp();
	
	public int invldExtngPmgStgGfsCustGrpMemship();
	
	public int stgPmgRecordsGfsCust();
    
	public int trgtPmgRecordsGfsCust();
	
	public int invldPmgTrgtGfsCustCustomer();
	
	public int stgSprPmgRecordsGfsCust();
    
	public int trgtSprPmgRecordsGfsCust();
	
	public int invldSprPmgTrgtGfsCustCustomer();
	
	public int stgPmgRecordsGfsCustGrp();
	
	public int trgtPmgRecordsGfsCustGrp();
	
	public int invldPmgTrgtGfsCustomerGrp();
	
	public int stgSprPmgRecordsGfsCustGrp1();
	
//	public int stgSprPmgRecordsGfsCustGrp2();
	
	public int trgtSprPmgRecordsGfsCustGrp1();
	
//	public int trgtSprPmgRecordsGfsCustGrp2();
	
	public int invldSuprPmgTrgtGfsCustomerGrp();
	
	public int stgNwPmgRecordsGfsCustGrpMemship();
	
	public int trgtNwPmgRecordsGfsCustGrpMemship();
	
	public int invldNwPmgTrgtGfsCustomerGrpMemship();
	
	public int stgExtnPmgRecordsGfsCustGrpMemship();
	
	public int trgtExtnPmgRecordsGfsCustGrpMemship();
	
	public int invldExtnPmgTrgtGfsCustomerGrpMemship();
	
	
}//end ParentCodeToPmgDao
