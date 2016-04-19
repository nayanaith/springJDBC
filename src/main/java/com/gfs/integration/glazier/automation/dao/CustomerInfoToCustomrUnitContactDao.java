package com.gfs.integration.glazier.automation.dao;

public interface CustomerInfoToCustomrUnitContactDao {
	public int glzCustRecords();
	
	public int shpToCustContact();
	
	public int invldShptoStgCustomerContact();
	
	public int shpToCustContactMechanism();
	
	public int invldStgShipToCustomerContactMechanism();
	
	public int shpToCustContactAsgn();
	
	public int invldStgShipToCustomerContactAsgn();
	
	public int targetShpToCustContact();
	
	public int trgtInvldShptoStgCustomerContact();
	
	public int invldTrgtShipToCustomerContact();
	
	public int trgtShpToCustContactMechanism();
	
	public int invldTrgtShipToCustomerContactMechanism();
	
	public int trgtShpToCustContactAsgn();
	
	public int invldTrgtShipToCustomerContactAsgn();
	
	public int bilToRecdsGlzCustomer();
	
	public int bilToRecdsStgCustContact();
	
	public int invldStgBillToCustomerContact();
	
	public int bilToRecdsStgCustContactMechansm();
	
	public int invldStBilToCustomerContactMechanism();
	
	public int bilToRecdsStgCustContactAsgn();
	
	public int invldStBilToCustomerContactAsgn();
	
	public int bilToRecdsTrgtCustContact();
	
	public int invldTrgtBillToCustomerContact();
	
	public int bilToRecdsTrgtCustContactMechansm();
	
	public int invldTrgtBilToCustomerContactMechanism();
	
	public int bilToRecdsTrgtCustContactAsgn();
	
	public int invldTrgtBilToCustomerContactAsgn();
	
	public int billToShipToRcrdsGfsEntityXref1();
	
//	public int billToShipToRcrdsGfsEntityXref2();
	
	public int invldGfsEntityXref();
        
        public int countGlzShipToBillToContacts();
        
}//end CustomerInfoToCustomrUnitContactDao
