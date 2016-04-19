package com.gfs.integration.glazier.automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gfs.integration.glazier.automation.dao.ShipToToCustomerPreferenceDao;

public class ShipToToCustomerPreferenceTest {

	/** DAO used to execute the queries. **/
	ShipToToCustomerPreferenceDao dao;

	/** Application context used to get beans for the test. **/
	ApplicationContext context;
	
    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        dao = (ShipToToCustomerPreferenceDao) context.getBean("shipToToCustomerPreferenceDao");
    }
    
    @Test
    public void custmaint_1728(){
    	assertEquals("The number of staged  invoice print sequence preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.invoicePrintSequencePrefInGlzCust(),
                dao.invoicePrintSequencePrefInCustPrefSelction());
    }//end custmaint_1728
    
    @Test
    public void custmaint_1729(){
    	assertEquals("There are invalid records in cust_preference_selection table !",
                dao.invalidInvoicePrintSequencePrefInCustPrefSelction(),
                0);
    }//end custmaint_1729
    
    @Test
    public void custmaint_1730(){
    	assertEquals("The number of staged  invoice print sequence preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.invoicePrintSeqListIdPrefInGlzCust(),
                dao.invoicePrintSeqListIdPrefCustPrefSelction());
    }//end custmaint_1728
    
    @Test
    public void custmaint_1731(){
    	assertEquals("There are invalid Invoice Print Seq List Id records in cust_preference_selection table !",
                dao.invalidInvoicePrintSeqListIdInPrefCustPrefSelction(),
                0);
    }//end custmaint_1731
        
    @Test
    public void custmaint_1732(){
    	assertEquals("The number of staged  Invoice Subtotal Printing Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.invoiceSubtotalPrintPrefInGlazCust(),
                dao.invoiceSubtotalPrintPrefInCustPrefSelection());
    }//end custmaint_1732
    
    @Test
    public void custmaint_1733(){
    	assertEquals("There are invalid Invoice Subtotal Printing Preference records in cust_preference_selection table !",
                dao.invalidInvoiceSubtotalPrintPrefInPrefCustPrefSelction(),
                0);
    }//end custmaint_1733
    
    @Test
    public void custmaint_1735(){
    	assertEquals("The number of staged Invoice Copies Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.invoiceCopiesPrefInGlzCust(),
                dao.invoiceCopiesPrefInCustPrefSelection());
    }//end custmaint_1735
    
    @Test
    public void custmaint_1736(){
    	assertEquals("There are invalid Invoice Copies Preference records in cust_preference_selection table !",
                dao.invalidinvoiceCopiesPrefInPrefCustPrefSelction(),
                0);
    }//end custmaint_1736
    
    @Test
    public void custmaint_1737(){
    	assertEquals("The number of staged delivery DocType Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.deliveryDocTypePrefInGlzCust(),
                dao.deliveryDocTypePrefInCustPrefSelction());
    }//end custmaint_1737
    
    @Test
    public void custmaint_1738(){
    	assertEquals("There are invalid delivery DocType Preference records in cust_preference_selection table !",
                dao.invalidDeliveryDocTypePrefInCustPrefSelction(),
                0);
    }//end custmaint_1738

    @Test
    public void custmaint_1739(){
    	assertEquals("The number of staged Customer Item Code Source Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.custItemCodeSourcePrefInGlzCust(),
                dao.custItemCodeSourcePrefInCustPrefSelction());
    }//end custmaint_1739
    
    @Test
    public void custmaint_1740(){
    	assertEquals("There are invalid Customer Item Code Source Preference records in cust_preference_selection table !",
                dao.invalidCustItemCodeSourcePrefInCustPrefSelction(),
                0);
    }//end custmaint_1740
 
    @Test
    public void custmaint_1741(){
    	assertEquals("The number of staged Customer Item Code List Id Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.custItemCodeListIdPrefInGlzCust(),
                dao.custItemCodeListIdPrefInCustPrefSelction());
    }//end custmaint_1741

    @Test
    public void custmaint_1742(){
    	assertEquals("There are invalid Customer Item Code List Id Preference records in cust_preference_selection table !",
                dao.invalidCustItemCodeListIdPrefInCustPrefSelction(),
                0);
    }//end custmaint_1742
    
    @Test
    public void custmaint_1743(){
    	assertEquals("The number of staged Customer Item Code Visibility Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.custItemCodeVisibltyPrefInGlzCust(),
                dao.custItemCodeVisibltyPrefInCustPrefSelction());
    }//end custmaint_1743
    
    @Test
    public void custmaint_1744(){
    	assertEquals("There are invalid Customer Item Code Visibility Preference records in cust_preference_selection table !",
                dao.invalidCustItemCodeVisibltyPrefInCustPrefSelction(),
                0);
    }//end custmaint_1744
    
    @Test
    public void custmaint_1745(){
    	assertEquals("The number of staged Frequency Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.frequencyPrefInGlzCust(),
                dao.frequencyPrefInCustPrefSelction());
    }//end custmaint_1745
    
    @Test
    public void custmaint_1746(){
    	assertEquals("There are invalid Customer Frequency Preference records in cust_preference_selection table !",
                dao.invalidFrequencyPrefInCustPrefSelction(),
                0);
    }//end custmaint_1746
    
    @Test
    public void custmaint_1747(){
    	assertEquals("The number of staged Statement Distribution Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.statementDistributionPrefInGlzCust(),
                dao.statementDistributionPrefInCustPrefSelction());
    }//end custmaint_1747
    
    @Test
    public void custmaint_1748(){
    	assertEquals("There are invalid Statement Distribution Preference records in cust_preference_selection table !",
                dao.invalidStatementDistributionPrefInCustPrefSelction(),
                0);
    }//end custmaint_1748
    
    @Test
    public void custmaint_1749(){
    	assertEquals("The number of staged Statement E-mail Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.statementEmailPrefInGlzCust(),
                dao.statementEmailPrefInCustPrefSelction());
    }//end custmaint_1749
    
    @Test
    public void custmaint_1750(){
    	assertEquals("There are invalid Statement E-mail Preference records in cust_preference_selection table !",
                dao.invalidstatementEmailPrefInCustPrefSelction(),
                0);
    }//end custmaint_1750
    
    @Test
    public void custmaint_1751(){
    	assertEquals("The number of Marketplace Instant Invoice Delivery Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.mktPlcInstntInviceDelPrefInGlzCust(),
                dao.mktPlcInstntInviceDelPrefInCustPrefSelction());
    }//end custmaint_1751
    
    @Test
    public void custmaint_1752(){
    	assertEquals("There are invalid Marketplace Instant Invoice Delivery Preference records in cust_preference_selection table !",
                dao.invalidmktPlcInstntInviceDelPrefInCustPrefSelction(),
                0);
    }//end custmaint_1752
    
    @Test
    public void custmaint_1753(){
    	assertEquals("The number of Delivery Invoice Preference records does not equal CUST_PREFERENCE_SELECTION !",
                dao.deliveryInvoicePrefInGlzCust(),
                dao.deliveryInvoicePrefInCustPrefSelction());
    }//end custmaint_1753
    
    @Test
    public void custmaint_1754(){
    	assertEquals("There are invalid Delivery Invoice Preference records in cust_preference_selection table !",
                dao.invaliddeliveryInvoicePrefInCustPrefSelction(),
                0);
    }//end custmaint_1754
    
    @Test
    public void custmaint_1755(){
    	assertEquals("The number of Delivery Invoice Preference records does not equal CUSTOMER CONTACT !",
                dao.deliveryInvoicePrefInGlzCustToCustomerContact(),
                dao.deliveryInvoicePrefInCustContact());
    }//end custmaint_1755
    
    @Test
    public void custmaint_1756(){
    	assertEquals("There are invalid Delivery Invoice Preference records in CUSTOMER CONTACT table !",
                dao.invaliddeliveryInvoicePrefInCustContact(),
                0);
    }//end custmaint_1756
    
    @Test
    public void custmaint_1757(){
    	assertEquals("dsshe number of Delivery Invoice Preference records does not equal CUSTOMER_CONTACT table !",
                dao.deliveryInvoicePrefInGlzCustToGfsCustContactAsgn(),
                dao.deliveryInvoicePrefInGfsCustContactAsgn());
    }//end custmaint_1757
    
    @Test
    public void custmaint_1758(){
    	assertEquals("There are invalid Delivery Invoice Preference records in CUSTOMER CONTACT table !",
                dao.invaliddeliveryInvoicePrefInCustContactAsgn(),
                0);
    }//end custmaint_1758
    
    @Test
    public void custmaint_1761(){
    	assertEquals("the number of Delivery Invoice Preference records does not equal CUSTOMER_CONTACT_Mechansm table !",
                dao.deliveryInvoicePrefInGlzCustToCustomerContctMechansm(),
                dao.deliveryInvoicePrefInCustomerContctMechansm());
    }//end custmaint_1761
    
    @Test
    public void custmaint_1762(){
    	assertEquals("There are invalid Delivery Invoice Preference records in CUSTOMER CONTACT Mechansm table !",
                dao.invaliddeliveryInvoicePrefInCustomerContctMechansm(),
                0);
    }//end custmaint_1762
    
    @Test
    public void custmaint_1763(){
    	assertEquals("the number of Past Due Notice Delivery Preference records does not equal CUST_DOC_PROC_OPTION table !",
                dao.pastDueNticeDelPrefRecsInGlaCust(),
                dao.pastDueNticeDelPrefRecsInCustDocProcOption());
    }//end custmaint_1763
    
    @Test
    public void custmaint_1764(){
    	assertEquals("There are invalid Past Due Notice Delivery Preference records in CUST_DOC_PROC_OPTION Mechansm table !",
                dao.invldPastDueNticeDelPrefRecsInCustDocProcOption(),
                0);
    }//end custmaint_1764
    
    @Test
    public void custmaint_1765(){
    	assertEquals("the number of Past Due Notice Delivery Preference records does not equal Customer Contact table !",
                dao.pastDueNticeDelPrefRecsInGlaCustForCustContact(),
                dao.pastDueNticeDelPrefRecsInCustomerContact());
    }//end custmaint_1765
    
    @Test
    public void custmaint_1766(){
    	assertEquals("There are invalid Past Due Notice Delivery Preference records in Customer Contact table !",
                dao.invldPastDueNticeDelPrefRecsInCustomerContact(),
                0);
    }//end custmaint_1766
    
    @Test
    public void custmaint_1767(){
    	assertEquals("the number of Past Due Notice Delivery Preference records does not equal Customer Contact table !",
                dao.pastDueNticeDelPrefRecsInGlaCustForCustContact(),
                dao.pastDueNticeDelPrefRecsInGfsCustContactAsgn());
    }//end custmaint_1767
    
    @Test
    public void custmaint_1768(){
    	assertEquals("There are invalid Past Due Notice Delivery Preference records in Customer Contact table !",
                dao.invldPastDueNticeDelPrefRecsInGfsCustContactAsgn(),
                0);
    }//end custmaint_1768
    
    @Test
    public void custmaint_1769(){
    	assertEquals("the number of Past Due Notice Delivery Preference records does not equal CUSTOMER_CONTACT_MECHANISM table !",
                dao.pastDueNticeDelPrefRecsInGlaCustForCustContact(),
                dao.pastDueNticeDelPrefRecsInCustomerContactMechanism());
    }//end custmaint_1769
    
    @Test
    public void custmaint_1770(){
    	assertEquals("There are invalid Past Due Notice Delivery Preference records in CUSTOMER_CONTACT_MECHANISM table !",
                dao.invldPastDueNticeDelPrefRecsInCustomerContactMechanism(),
                0);
    }//end custmaint_1770
    
    @Test
    public void custmaint_1772(){
    	assertEquals("The number of invalid glazeir preference records does not equal in stg and trgt CUSTOMER_CONTACT_MECHANISM table !",
                dao.glzPrefRecsInStgCustDocProcOption(),
                dao.glzPrefRecsInTrgtCustDocProcOption());
    }//end custmaint_1772
    
    @Test
    public void custmaint_1774(){
    	assertEquals("There are invalid glazeir preferences records in CUST_DOC_PROC_OPTION table !",
                dao.invalidGlzPrefRecsInTrgtCustDocProcOption(),
                0);
    }//end custmaint_1774
    
    @Test
    public void custmaint_1775(){
    	assertEquals("The number of invalid glazeir preference records does not equal in stg and trgt CUSTOMER_CONTACT table !",
                dao.glzPrefRecsInStgCustomerContact(),
                dao.glzPrefRecsInTrgtCustomerContact());
    }//end custmaint_1775
    
    @Test
    public void custmaint_1776(){
    	assertEquals("There are invalid glazeir preferences records in CUSTOMER_CONTACT table !",
                dao.invalidGlzPrefRecsInTrgtCustomerContact(),
                0);
    }//end custmaint_1776
    
    @Test
    public void custmaint_1777(){
    	assertEquals("The number of invalid glazeir preference records does not equal in stg and trgt CUSTOMER_CONTACT_MECHANISM table !",
                dao.glzPrefRecsInStgCustomerContactMechanism(),
                dao.glzPrefRecsInTrgtCustomerContactMechanism());
    }//end custmaint_1777
    
    @Test
    public void custmaint_1778(){
    	assertEquals("There are invalid glazeir preferences records in CUSTOMER_CONTACT_MECHANISM table !",
                dao.invalidGlzPrefRecsInTrgtCustomerContactMechanism(),
                0);
    }//end custmaint_1778

    @Test
    public void custmaint_1779(){
    	assertEquals("The number preference records does not equal in stg and trgt CUST_PREFERENCE_SELECTION table !",
                dao.glzPrefRecsInStgCustPreferenceSelection(),
                dao.glzPrefRecsInTrgtCustPreferenceSelection());
    }//end custmaint_1779

    @Test
    public void custmaint_1780(){
    	assertEquals("Invalid preferences records in target CUST_PREFERENCE_SELECTION table !",
                dao.invalidGlzPrefRecsInTrgtPreferenceSelection(),
                0);
    }//end custmaint_1780
    
    @After
    public void releasing(){
        ((ConfigurableApplicationContext)context).close();
    }//releasing
}//end ShipToToCustomerPreferenceTest
