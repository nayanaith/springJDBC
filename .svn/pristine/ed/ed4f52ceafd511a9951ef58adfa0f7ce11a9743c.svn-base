package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao;

/**
 * This class implements the methods identified by the BilltoToBilltoDao
 * interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
 * schema and the cust_admin schema.
 * @author v7vyo
 *
 */
public class BilltoToBilltoDaoImpl extends NamedParameterJdbcTemplate implements BilltoToBilltoDao{
        
        //Default Consturctor
	public BilltoToBilltoDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}

	public int custCount() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                             "from cust_stage_admin.glazier_customer";
                
		String result = this.queryForObject(sql, paramMap , String.class);
		return Integer.parseInt(result);
	}//end custCount
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countGlazierBillto()  
         */
	public int countGlazierBillto() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                             "from cust_stage_admin.glazier_customer gc " +
                             "where gc.valid_record_ind = 1 ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countGlazierBillto
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBillto() 
         */
	public int countStagedGlazierBillto() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from " +
                    "cust_stage_admin.glazier_customer gc, " +
                    "cust_stage_admin.gfs_cust_billing_agent scba, " + 
                    "cust_stage_admin.gfs_entity_xref xref " +
                    "where  xref.gfs_entity_type_code = 11 " +
                    "and xref.business_unit_code in (36,37) " +
                    "and xref.original_entity_id = scba.gfs_customer_id " +
                    "and xref.original_entity_id = gc.cust_nbr " +
                    "and gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
                            
		return Integer.parseInt(result);
	}//end countStagedGlazierBillto
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBillto() 
         */
	public int countTargetGlazierBillto() {
		final SqlParameterSource paramMap = null;
                
                String sql="select count(*) " +
                "from  cust_admin.gfs_cust_billing_agent tcba, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcba.gfs_customer_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetGlazierBillto
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoGFSCustomer() 
         */
	public int countStagedGlazierBilltoGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
                            
		return Integer.parseInt(result);
	}// end countStagedGlazierBilltoGFSCustomer
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoGFSCustomer()
         */
	public int countTargetGlazierBilltoGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}// end countTargetGlazierBilltoGFSCustomer
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoGFSCustGroup() 
         */
	public int countStagedGlazierBilltoGFSCustGroup() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
                            
		return Integer.parseInt(result);
	}// end countStagedGlazierBilltoGFSCustGroup
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoGFSCustGroup()
         */
	public int countTargetGlazierBilltoGFSCustGroup() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group tcg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}// end countTargetGlazierBilltoGFSCustGroup
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoGFSCustomerSite()
         */
	public int countTargetGlazierBilltoGFSCustomerSite() {
		final SqlParameterSource paramMap = null;
                
                String sql="select count(*) " +
                "from  cust_admin.gfs_customer_site tcs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcs.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
        }// end countTargetGlazierBilltoGFSCustomerSite        
         
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoGFSCustomerSite() 
         */
	public int countStagedGlazierBilltoGFSCustomerSite() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc, " +
                    "      cust_stage_admin.gfs_customer_site scs, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 11 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = scs.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = scs.gfs_customer_type_code " +
                    "and   xref.original_entity_id = gc.cust_nbr " +
                    "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
                            
		return Integer.parseInt(result);
	}// end countStagedGlazierBilltoGFSCustomerSite

        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoCRMSite() 
         */
	public int countStagedGlazierBilltoCRMSite() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_customer_site scs, " +
                "      cust_stage_admin.crm_site cs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scs.gfs_customer_type_code " +        
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   scs.crm_site_id = cs.crm_site_id " +
                "and 	gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
                            
		return Integer.parseInt(result);
	}// end countStagedGlazierBilltoCRMSite

        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoXref() 
         */
	public int countStagedGlazierBilltoXref() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from   cust_stage_admin.glazier_customer gc, " +
                "       cust_stage_admin.gfs_entity_xref xref " +
                "where  xref.gfs_entity_type_code = 11 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.original_entity_id = gc.cust_nbr " +
                "and    gc.valid_record_ind = 1 ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
                            
		return Integer.parseInt(result);
	}// end countStagedGlazierBilltoXref
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoCRMSite()
         */
	public int countTargetGlazierBilltoCRMSite() {
		final SqlParameterSource paramMap = null;
                
                String sql="select count(*) " +
                "from  cust_admin.gfs_customer_site tcs, " +
                "      cust_admin.crm_site cs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcs.gfs_customer_type_code " +        
                "and   tcs.crm_site_id = cs.crm_site_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
        }// end countTargetGlazierBilltoCRMSite
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoWithInvalidFields() 
         */
        public int countStagedGlazierBilltoWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_cust_billing_agent scba, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scba.gfs_customer_id " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.valid_record_ind = 1 " +
                "and   (gc.chain_code <> scba.customer_bill_to_nbr " +
                "or    (scba.last_update_user_id IS NULL or scba.last_update_user_id NOT LIKE 'Glazier%')) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		
		return Integer.parseInt(result);                
	}// end countStagedGlazierBilltoWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoGFSCustGroupWithInvalidFields() 
         */
        public int countStagedGlazierBilltoGFSCustGroupWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc, " +
                    "      cust_stage_admin.gfs_cust_group scg, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 11 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = scg.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                    "and   xref.original_entity_id = gc.cust_nbr " +
                    "and   gc.valid_record_ind = 1 " +
                    "and   (scg.customer_group_name <> gc.bill_to_name " +
                    "or    scg.customer_group_desc IS NOT NULL " +
                    "or    (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) " +
                    "or    scg.cust_grp_status_date IS NULL " +
                    "or    (scg.company_nbr IS NULL or scg.company_nbr <> 1) " +
                    "or    scg.added_date IS NULL " +
                    "or    (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) " +
                    "or    (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) " +
//                    "--or   scg.cust_reln_mgr_id <> TBD " +
                    "or    scg.site_id IS NULL " +
                    "or    scg.last_update_tmstmp IS NULL " +
                    "or    (scg.last_update_user_id IS NULL or scg.last_update_user_id NOT LIKE 'Glazier%') " +
                    "or    scg.buyer_nbr IS NOT NULL)"; 
		
		String result = this.queryForObject(sql,paramMap,String.class);
		
		return Integer.parseInt(result);
	}// end countStagedGlazierBilltoGFSCustGroupWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoGFSCustGroupWithInvalidFields() 
         */
        public int countTargetGlazierBilltoGFSCustGroupWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group tcg, " +
                "      cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   xref2.gfs_entity_type_code = 99 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tcg.site_id " +
                "and   (scg.customer_group_name <> tcg.customer_group_name " +
                "or    tcg.customer_group_desc IS NOT NULL " +
                "or    (tcg.cust_grp_status_code IS NULL or tcg.cust_grp_status_code <> 1) " +
                "or    tcg.cust_grp_status_date IS NULL " +
                "or    (tcg.company_nbr IS NULL or tcg.company_nbr <> 1) " +
                "or    tcg.added_date IS NULL " +
                "or    (tcg.pricing_audit_privlg_ind IS NULL or tcg.pricing_audit_privlg_ind <> 0) " +
                "or    (tcg.order_lock_out_code IS NULL or tcg.order_lock_out_code <> 2) " +
                "or    tcg.cust_reln_mgr_id <> scg.cust_reln_mgr_id " +
                "or    tcg.site_id IS NULL " +
                "or    tcg.last_update_tmstmp IS NULL " +
                "or    (tcg.last_update_user_id IS NULL or tcg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tcg.buyer_nbr IS NOT NULL)";

		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoGFSCustomerSiteWithInvalidFields() 
         */
        public int countStagedGlazierBilltoGFSCustomerSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_customer_site scs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scs.gfs_customer_type_code " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.valid_record_ind = 1  " +
                "      and    (scs.crm_site_id IS NULL " +
                "or    (scs.primary_site_ind IS NULL or scs.primary_site_ind <> 1) " +
                "or    scs.last_update_tmstmp IS NULL " +
                "or    (scs.last_update_user_id IS NULL or scs.last_update_user_id NOT LIKE 'Glazier%'))";

		
                String result = this.queryForObject(sql,paramMap,String.class);

                return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoGFSCustomerSiteWithInvalidFields() 
         */
        public int countTargetGlazierBilltoGFSCustomerSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
                "from  cust_admin.gfs_customer_site tcs, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcs.gfs_customer_type_code " +
                "and   xref2.gfs_entity_type_code = 99 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tcs.crm_site_id " +
                "and   (tcs.crm_site_id IS NULL " +
                "or    (tcs.primary_site_ind IS NULL or tcs.primary_site_ind <> 1) " +
                "or    tcs.last_update_tmstmp IS NULL " +
                "or    (tcs.last_update_user_id IS NULL or tcs.last_update_user_id NOT LIKE 'Glazier%'))";
		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}

        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoGFSCustomerWithInvalidFields() 
         */
        public int countTargetGlazierBilltoGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
            "from  cust_admin.gfs_customer tgc, " +
            "      cust_stage_admin.gfs_customer sgc, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2 " +
            "where xref.gfs_entity_type_code = 11 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
            "and   xref.original_entity_id = sgc.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
            "and   xref2.gfs_entity_type_code = 99 " +
            "and   xref2.business_unit_code in (36,37) " +
            "and   xref2.gfs_entity_id = tgc.site_id " +
            "and   (tgc.last_update_tmstmp IS NULL " +
            "or    (tgc.last_update_user_id IS NULL or tgc.last_update_user_id NOT LIKE 'Glazier%') " +
            "or    tgc.gfs_customer_name <> sgc.gfs_customer_name " +
            "or    tgc.site_id IS NULL)";

		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetGlazierBilltoCRMSiteWithInvalidFields() 
         */
        public int countTargetGlazierBilltoCRMSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_admin.crm_site tcs, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_stage_admin.crm_site scs " +
                "where tgc.gfs_customer_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   xref2.gfs_entity_type_code = 99 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tgc.site_id " +
                "and   xref2.gfs_entity_id = tcs.crm_site_id " +
                "and   xref2.original_entity_id = scs.crm_site_id " +
                "and   (tcs.site_desc IS NOT NULL " +
                "or    tcs.address_1_txt <> scs.address_1_txt " +
                "or    tcs.address_2_txt IS NOT NULL " +
                "or    tcs.address_3_txt IS NOT NULL " +
                "or    tcs.city_name <> scs.city_name " +
                "or    tcs.state_alpha_code <> scs.state_alpha_code " +
                "or    tcs.postal_code <> scs.postal_code " +
                "or    tcs.country_code <> 'US' " +
                "or    tcs.county_code <> scs.county_code " +
                "or    tcs.default_tax_geo_code IS NOT NULL " +
                "or    tcs.override_tax_geo_code IS NOT NULL " +
                "or    tcs.last_update_tmstmp IS NULL " +
                "or    (tcs.last_update_user_id IS NULL or tcs.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tcs.temp_default_tax_geo_code IS NOT NULL " +
                "or    tcs.temp_override_tax_geo_code IS NOT NULL " +
                "or    tcs.twe_tax_geo_code IS NULL)";       

		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoCRMSiteWithInvalidFields() 
         */
        public int countStagedGlazierBilltoCRMSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
		String sql="select count(*) " +
            "from  cust_stage_admin.glazier_customer gc, " +
            "      cust_stage_admin.gfs_customer_site gcs, " +
            "      cust_stage_admin.crm_site cs, " +
            "      cust_stage_admin.gfs_entity_xref xref " +
            "where xref.gfs_entity_type_code = 11 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.original_entity_id = gcs.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = gcs.gfs_customer_type_code " +
            "and   xref.original_entity_id = gc.cust_nbr " +
            "and   gcs.crm_site_id = cs.crm_site_id " +
            "and   gc.valid_record_ind = 1 " +
            "and   (cs.crm_site_id IS NULL " +
            "or    cs.site_desc IS NOT NULL " +
            "or    cs.address_1_txt <> gc.bill_to_addr_line_1 " +
            "or    cs.address_2_txt IS NOT NULL " +
            "or    cs.address_3_txt IS NOT NULL " +
            "or    cs.address_attn_txt IS NOT NULL " +
            "or    cs.city_name <> gc.bil_to_city_name " +
            "or    cs.state_alpha_code <> gc.bill_to_state_code " +
            "or    cs.postal_code <> substr(gc.bill_to_postal_code,1,5) " +
            "or    cs.country_code <> 'US' " +
            "or    cs.county_code IS NOT NULL " +
            "or    cs.default_tax_geo_code IS NOT NULL " +
            "or    cs.override_tax_geo_code IS NOT NULL " +
            "or    cs.last_update_tmstmp IS NULL " +
            "or    (cs.last_update_user_id IS NULL or gcs.last_update_user_id NOT LIKE 'Glazier%') " +
            "or    cs.temp_default_tax_geo_code IS NOT NULL " +
            "or    cs.temp_override_tax_geo_code IS NOT NULL " +
            "or    cs.twe_tax_geo_code IS NOT NULL)"; 
		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countStagedGlazierBilltoGFSCustomerWithInvalidFields() 
         */
        public int countStagedGlazierBilltoGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.valid_record_ind = 1 " +
                "and   (sgc.last_update_tmstmp IS NULL " +
                "or    (sgc.last_update_user_id IS NULL or sgc.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    sgc.gfs_customer_name <> gc.bill_to_name " +
                "or    sgc.site_id IS NULL)"; 
		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#findTargetGlazierBilltoWithEmptyFields() 
         */
        public int countTargetGlazierBilltoWithInvalidFields() {
                final SqlParameterSource paramMap = null;
                
		String sql="select count(*) " +
                "from  cust_admin.gfs_cust_billing_agent tcba, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcba.gfs_customer_id " +
                "and   (tcba.last_update_tmstmp IS NULL " +
                "or    (tcba.last_update_user_id IS NULL or tcba.last_update_user_id NOT LIKE 'Glazier%'))"; 
		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countXrefWithNoBillingAgentInGlazierCust()
         */
	public int countXrefWithNoBillingAgentInGlazierCust(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_entity_xref xref " +
                "      full outer join cust_stage_admin.glazier_customer gc " +
                "      on gc.cust_nbr=xref.original_entity_id " +
                "where xref.gfs_entity_type_code=11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   gc.cust_nbr IS NULL ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countBillingAgentXrefEntriesWithoutId() 
         */
	public int countBillingAgentXrefEntriesWithoutId(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.GFS_ENTITY_XREF xref " +
                "where xref.gfs_entity_type_code=11 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   (xref.original_entity_id IS NULL or xref.gfs_entity_id IS NULL) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
        }
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countXrefWithNoBillingAgentInGFSCustomer() 
         */
	public int countXrefWithNoBillingAgentInGFSCustomer(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from cust_stage_admin.gfs_entity_xref xref " +
                "where xref.GFS_ENTITY_TYPE_CODE = 11 " +
                "      and xref.BUSINESS_UNIT_CODE in (36,37) " +
                "      and(xref.GFS_ENTITY_ID, xref.GFS_ENTITY_TYPE_CODE) not in (" +
                "              select tgc.gfs_customer_id, tgc.gfs_customer_type_code " +
                "              from cust_admin.GFS_CUSTOMER tgc " +
                "			  where tgc.last_update_user_id like 'Glazier%') ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
        }
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.BilltoToBilltoDao#countTargetInvalidBilltoUnits() 
         */
	public int countTargetInvalidBilltoUnits(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( " +
                             "select count(*) " +
                    "from  cust_admin.GFS_CUST_BILLING_AGENT tcba, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where tcba.customer_bill_to_nbr = xref.gfs_entity_id " +
                    "and   xref.gfs_entity_type_code = 11 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "group by tcba.customer_bill_to_nbr, tcba.customer_bill_to_unit " +
                    "having count(*) > 1)";
		
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
        }        
        
}//end BiltoToBiltoDaoImpl
