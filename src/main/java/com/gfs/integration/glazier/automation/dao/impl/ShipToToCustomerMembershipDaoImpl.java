package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.ShipToToCustomerMembershipDao;

/*
* This class implements the methods identified by the ShipToToCustomerMembershipDao
interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
* schema and the cust_admin schema.
* @author v7vyo
*/
public class ShipToToCustomerMembershipDaoImpl extends NamedParameterJdbcTemplate implements ShipToToCustomerMembershipDao{
	public ShipToToCustomerMembershipDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	public int countGlazierFamilyCust(){
		final SqlParameterSource paramMap = null;
        
        String sql =  "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc " +
                "where gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierFamilyCust
	
	public int countStagedFamiliesInCustGroupMembership(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership cgm, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_stage_admin.glazier_customer gc " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   cgm.group_id = xref.original_entity_id " +
                "and   cgm.group_type_code = xref.gfs_entity_type_code " +
                "and   cgm.group_id = gc.chain_code " +
                "and   xref2.gfs_entity_type_code = 0 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   cgm.member_customer_id = xref2.original_entity_id " +
                "and   cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
                "and   cgm.member_customer_id = gc.cust_nbr";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedFamiliesInCustGroupMembership

	public int countTargetFamiliesInCustGroupMembership(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
            "from   cust_stage_admin.gfs_cust_group_membership scgm, " +
            "       cust_stage_admin.gfs_entity_xref xref, " +
            "       cust_stage_admin.gfs_entity_xref xref2, " +
            "       cust_admin.gfs_cust_group_membership tcgm " +
            "where  xref.gfs_entity_type_code = 3 " +
            "and    xref.business_unit_code in (36,37) " +
            "and    scgm.group_id = xref.original_entity_id " +
            "and    xref.gfs_entity_id = tcgm.group_id " +
            "and    xref.gfs_entity_type_code = tcgm.group_type_code " +
            "and    scgm.group_type_code = xref.gfs_entity_type_code " +
            "and    xref2.gfs_entity_type_code = 0 " +
            "and    xref2.business_unit_code in (36,37) " +
            "and    scgm.member_customer_id = xref2.original_entity_id " +
            "and    xref2.gfs_entity_id = tcgm.member_customer_id " +
            "and    scgm.member_customer_type_code = xref2.gfs_entity_type_code " +
            "and    xref2.gfs_entity_type_code = tcgm.member_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetFamiliesInCustGroupMembership
        
	public int countStagedFamilyGroupMembershipWithInvalidFields(){
		final SqlParameterSource paramMap = null;
		
		String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership cgm, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_stage_admin.glazier_customer gc " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   cgm.group_id = xref.original_entity_id " +
                "and   cgm.group_type_code = xref.gfs_entity_type_code " +
                "and   cgm.group_id = gc.chain_code " +
                "and   xref2.gfs_entity_type_code = 0 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   cgm.member_customer_id = xref2.original_entity_id " +
                "and   cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
                "and   cgm.member_customer_id = gc.cust_nbr " +
                "and   (cgm.group_id IS NULL " +
                "or     cgm.member_customer_id IS NULL " +
                "or     cgm.effective_date IS NULL " +
                "or     cgm.expiration_date IS NULL " +
                "or    (cgm.pricing_precedence_ind IS NULL or cgm.pricing_precedence_ind <> 0) " +
                "or     cgm.group_cust_store_nbr IS NOT NULL " +
                "or     cgm.last_update_tmstmp IS NULL " +
                "or    (cgm.last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
		
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedFamilyGroupMembershipWithInvalidFields
	
	public int countStagedBillingAgentGroupMembershipWithInvalidFields(){
		final SqlParameterSource paramMap = null;
		
		String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership cgm, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_stage_admin.glazier_customer gc " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   cgm.group_id = xref.original_entity_id " +
                "and   cgm.group_type_code = xref.gfs_entity_type_code " +
                "and   cgm.group_id = gc.cust_nbr " +
                "and   xref2.gfs_entity_type_code = 0 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   cgm.member_customer_id = xref2.original_entity_id " +
                "and   cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
                "and   cgm.member_customer_id = gc.cust_nbr " +
                "and   (cgm.group_id IS NULL " +
                "or     cgm.member_customer_id IS NULL " +
                "or     cgm.effective_date <> to_date('12/1/2014','MM/DD/YYYY') " +
                "or     cgm.expiration_date <> to_date('1/1/9999','MM/DD/YYYY') " +
                "or    (cgm.pricing_precedence_ind IS NULL or cgm.pricing_precedence_ind <> 0) " +
                "or    cgm.group_cust_store_nbr IS NOT NULL " +
                "or     cgm.last_update_tmstmp IS NULL " +
                "or    (cgm.last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
		
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedBillingAgentGroupMembershipWithInvalidFields
	
	public int countGlazierBilToCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc " +
                "where gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierBilToCust
	
	public int countStagedBillingAgentsInCustGroupMembership(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
            "from  cust_stage_admin.gfs_cust_group_membership cgm, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2, " +
            "      cust_stage_admin.glazier_customer gc " +
            "where xref.gfs_entity_type_code = 11 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   cgm.group_id = xref.original_entity_id " +
            "and   cgm.group_type_code = xref.gfs_entity_type_code " +
            "and   cgm.group_id = gc.cust_nbr " +
            "and   xref2.gfs_entity_type_code = 0 " +
            "and   xref2.business_unit_code in (36,37) " +
            "and   cgm.member_customer_id = xref2.original_entity_id " +
            "and   cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
            "and   cgm.member_customer_id = gc.cust_nbr " +
            "and   cgm.effective_date <= sysdate " +
            "and   cgm.expiration_date >= sysdate ";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedBillingAgentsInCustGroupMembership
	
	public int countStagedLegalOwnerGroupMembershipWithInvalidFields(){
		final SqlParameterSource paramMap = null;
		
		String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_group_membership cgm "
            + "where  cgm.group_type_code = 10 "
            + "and    cgm.last_update_user_id LIKE 'Glazier%' "
            + "and    (cgm.group_id IS NULL "
            + "or      cgm.member_customer_id IS NULL "
            + "or      cgm.effective_date IS NULL "
            + "or      cgm.expiration_date IS NULL "
            + "or     (cgm.pricing_precedence_ind IS NULL or cgm.pricing_precedence_ind <> 0) "
            + "or      cgm.group_cust_store_nbr IS NOT NULL "
            + "or      cgm.last_update_tmstmp IS NULL "
            + "or     (cgm.last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
		
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedLegalOwnerGroupMembershipWithInvalidFields
	
	
	public int countGlazierLegalOwnerCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc " +
                    "where gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierLegalOwnerCust
	
	
	public int countStagedLegalOwnersInCustGroupMembership(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( " +
            "select gc.cust_nbr " +
            "from   cust_stage_admin.gfs_cust_group_membership cgm, " +
            "       cust_stage_admin.gfs_entity_xref xref, " +
            "       cust_stage_admin.gfs_entity_xref xref2, " +
            "       cust_stage_admin.glazier_customer gc " +
            "where  xref.gfs_entity_type_code = 10 " +
            "and    xref.business_unit_code in (36,37) " +
            "and    cgm.group_id = xref.original_entity_id " +
            "and    cgm.group_type_code = xref.gfs_entity_type_code " +
            "and    cgm.group_id = gc.chain_code " +
            "and    xref2.gfs_entity_type_code = 0 " +
            "and    xref2.business_unit_code in (36,37) " +
            "and    cgm.member_customer_id = xref2.original_entity_id " +
            "and    cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
            "and    cgm.member_customer_id = gc.cust_nbr " +
            "and    (gc.parent_code IS NULL or gc.parent_code <> 1) " +
            "and    gc.valid_record_ind = 1 " +
            "UNION " +
            "select gc.cust_nbr " +
            "from   cust_stage_admin.gfs_cust_group_membership cgm, " +
            "       cust_stage_admin.gfs_entity_xref xref, " +
            "       cust_stage_admin.gfs_entity_xref xref2, " +
            "       cust_stage_admin.glazier_customer gc " +
            "where  xref.gfs_entity_type_code = 10 " +
            "and    xref.business_unit_code in (36,37) " +
            "and    cgm.group_id = xref.original_entity_id " +
            "and    cgm.group_type_code = xref.gfs_entity_type_code " +
            "and    cgm.group_id = gc.cust_nbr " +
            "and    xref2.gfs_entity_type_code = 0 " +
            "and    xref2.business_unit_code in (36,37) " +
            "and    cgm.member_customer_id = xref2.original_entity_id " +
            "and    cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
            "and    cgm.member_customer_id = gc.cust_nbr " +
            "and    gc.parent_code = 1 " +
            "and    gc.valid_record_ind = 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedLegalOwnersInCustGroupMembership
	
        public int countTargetLegalOwnersInCustGroupMembership(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_admin.gfs_cust_group_membership tcgm " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcgm.group_id " +
                "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
                "and   xref2.gfs_entity_type_code = 0 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tcgm.member_customer_id " +
                "and   xref2.gfs_entity_type_code = tcgm.member_customer_type_code " +
                "and   tcgm.effective_date <= sysdate " +
                "and   tcgm.expiration_date >= sysdate";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetLegalOwnersInCustGroupMembership

//	public int countGlazierFmBiltoLgownCust(){
//		final SqlParameterSource paramMap = null;
       
//        String sql = "select count(*)  from  cust_stage_admin.GFS_CUST_GROUP_MEMBERSHIP mem "
//        		+ "where mem.last_update_user_id like 'Glazie%' and "
//        		+ "(mem.GROUP_TYPE_CODE=3 or mem.group_type_code=10 or mem.group_type_code=11)";
        
//        String result = this.queryForObject(sql,paramMap,String.class);	
//        return Integer.parseInt(result);
//	}//end countGlazierFmBiltoLgownCust
	
	public int countTargetBillingAgentsInCustGroupMembership(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group_membership cgm, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   cgm.group_id = xref.gfs_entity_id " +
                "and   cgm.group_type_code = xref.gfs_entity_type_code " +
                "and   xref2.gfs_entity_type_code = 0 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   cgm.member_customer_id = xref2.gfs_entity_id " +
                "and   cgm.member_customer_type_code = xref2.gfs_entity_type_code " +
                "and   cgm.effective_date <= sysdate " +
                "and   cgm.expiration_date >= sysdate ";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetBillingAgentsInCustGroupMembership
	
	public int countTargetBillingAgentGroupMembershipWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
            "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2, " +
            "      cust_admin.gfs_cust_group_membership tcgm " +
            "where xref.gfs_entity_type_code = 11 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   scgm.group_id = xref.original_entity_id " +
            "and   xref.gfs_entity_id = tcgm.group_id " +
            "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
            "and   scgm.group_type_code = xref.gfs_entity_type_code " +
            "and   xref2.gfs_entity_type_code = 0 " +
            "and   xref2.business_unit_code in (36,37) " +
            "and   scgm.member_customer_id = xref2.original_entity_id " +
            "and   xref2.gfs_entity_id = tcgm.member_customer_id " +
            "and   scgm.member_customer_type_code = xref2.gfs_entity_type_code " +
            "and   xref2.gfs_entity_type_code = tcgm.member_customer_type_code " +
            "and   (tcgm.group_id IS NULL " +
            "or     tcgm.member_customer_id IS NULL " +
            "or     tcgm.effective_date IS NULL " +
            "or     tcgm.expiration_date IS NULL " +
            "or    (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) " +
            "or    tcgm.group_cust_store_nbr IS NOT NULL " +
            "or    tcgm.last_update_tmstmp IS NULL " +
            "or    (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))"; 
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetBillingAgentGroupMembershipWithInvalidFields
	
	public int countTargetFamilyGroupMembershipWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_admin.gfs_cust_group_membership tcgm " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   scgm.group_id = xref.original_entity_id " +
                "and   xref.gfs_entity_id = tcgm.group_id " +
                "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
                "and   scgm.group_type_code = xref.gfs_entity_type_code " +
                "and   xref2.gfs_entity_type_code = 0 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   scgm.member_customer_id = xref2.original_entity_id " +
                "and   xref2.gfs_entity_id = tcgm.member_customer_id " +
                "and   scgm.member_customer_type_code = xref2.gfs_entity_type_code " +
                "and   xref2.gfs_entity_type_code = tcgm.member_customer_type_code " +
                "and   (tcgm.group_id IS NULL " +
                "or     tcgm.member_customer_id IS NULL " +
                "or     tcgm.effective_date IS NULL " +
                "or     tcgm.expiration_date IS NULL " +
                "or    (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) " +
                "or    tcgm.group_cust_store_nbr IS NOT NULL " +
                "or    tcgm.last_update_tmstmp IS NULL " +
                "or    (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))"; 
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetFamilyGroupMembershipWithInvalidFields

	public int countTargetLegalOwnerGroupMembershipWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
            "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2, " +
            "      cust_admin.gfs_cust_group_membership tcgm " +
            "where xref.gfs_entity_type_code = 3 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   scgm.group_id = xref.original_entity_id " +
            "and   xref.gfs_entity_id = tcgm.group_id " +
            "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
            "and   scgm.group_type_code = xref.gfs_entity_type_code " +
            "and   xref2.gfs_entity_type_code = 0 " +
            "and   xref2.business_unit_code in (36,37) " +
            "and   scgm.member_customer_id = xref2.original_entity_id " +
            "and   xref2.gfs_entity_id = tcgm.member_customer_id " +
            "and   scgm.member_customer_type_code = xref2.gfs_entity_type_code " +
            "and   xref2.gfs_entity_type_code = tcgm.member_customer_type_code " +
            "and   (tcgm.group_id IS NULL " +
            "or     tcgm.member_customer_id IS NULL " +
            "or     tcgm.effective_date IS NULL " +
            "or     tcgm.expiration_date IS NULL " +
            "or    (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) " +
            "or    tcgm.group_cust_store_nbr IS NOT NULL " +
            "or    tcgm.last_update_tmstmp IS NULL " +
            "or    (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))"; 
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetLegalOwnerGroupMembershipWithInvalidFields
        
}//end ShipToToCustomerMembershipImpl
