/**
 * 
 */
package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao;

/**
 * This class implements the methods identified by the GlazierShiptoInfoToGFSCustUnitDao
 interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
 * schema and the cust_admin schema.
 * @author e3k17
 *
 */
public class GlazierShiptoInfoToGFSCustUnitDaoImpl extends NamedParameterJdbcTemplate implements GlazierShiptoInfoToGFSCustUnitDao{
        
        //Default Consturctor
	public GlazierShiptoInfoToGFSCustUnitDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countGlazierCustomerUnits() 
         */
	public int countGlazierCustomerUnits() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                             "from   cust_stage_admin.GLAZIER_CUSTOMER glz " +
                             "where  valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countGlazierCustomerUnits        

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countStagedGFSCustomer() 
         */
	public int countStagedGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc, " +
                    "      cust_stage_admin.gfs_customer sgc, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 0 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = sgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                    "and   xref.original_entity_id = gc.cust_nbr " +
                    "and   gc.valid_record_ind = 1 ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedGFSCustomer

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countStagedGFSCustUnit() 
         */
	public int countStagedGFSCustUnit() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc, " +
                    "      cust_stage_admin.gfs_customer sgc, " +
                    "      cust_stage_admin.gfs_cust_unit sgcu, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 0 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = sgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                    "and   xref.original_entity_id = gc.cust_nbr " +
                    "and   sgc.gfs_customer_id = sgcu.gfs_customer_id " +
                    "and   gc.valid_record_ind = 1 ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedGFSCustUnit

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countTargetGFSCustomer() 
         */
	public int countTargetGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetGFSCustomer

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countTargetGFSCustUnit() 
         */
	public int countTargetGFSCustUnit() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_unit tgcu, " +
                "      cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   tgc.gfs_customer_id = tgcu.gfs_customer_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetGFSCustUnit

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countStagedCustUnitsInGFSEntityXref() 
         */
	public int countStagedCustUnitsInGFSEntityXref() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 0 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = gc.cust_nbr " +
                    "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedCustUnitsInGFSEntityXref

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countXrefWithNoCustUnitInGlazierCustomer() 
         */
	public int countXrefWithNoCustUnitInGlazierCustomer(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.gfs_entity_xref xref " +
                    "             full outer join cust_stage_admin.glazier_customer gc " +
                    "             on gc.cust_nbr = xref.original_entity_id " +
                    "where xref.gfs_entity_type_code = 0 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   gc.cust_nbr IS NULL ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}//end countXrefWithNoCustUnitInGlazierCustomer

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countUnitXrefEntriesWithoutId() 
         */
	public int countUnitXrefEntriesWithoutId(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select   count(*) " +
                "from  cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   (xref.original_entity_id is null or xref.gfs_entity_id is null) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}
     
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countXrefWithNoUnitInGFSCustomer() 
         */
	public int countXrefWithNoUnitInGFSCustomer(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from cust_stage_admin.gfs_entity_xref xref " +
                "where xref.GFS_ENTITY_TYPE_CODE = 0 " +
                "      and xref.BUSINESS_UNIT_CODE in (36,37) " +
                "      and(xref.GFS_ENTITY_ID, xref.GFS_ENTITY_TYPE_CODE) not in ( " +
                "              select tgc.gfs_customer_id, tgc.gfs_customer_type_code " +
                "              from cust_admin.GFS_CUSTOMER tgc)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
                
	}//end countXrefWithNoUnitInGFSCustomer
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countStagedGFSCustomerWithInvalidFields() 
         */
	public int countStagedGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.valid_record_ind = 1 " +
                "and   (sgc.last_update_tmstmp IS NULL " +
                "or    (sgc.last_update_user_id IS NULL OR sgc.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    sgc.gfs_customer_name <> gc.cust_name " +
                "or    sgc.site_id IS NULL) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustomerWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countTargetGFSCustomerWithInvalidFields() 
         */
	public int countTargetGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   xref2.gfs_entity_type_code = 99 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tgc.site_id " +
                "and   (tgc.last_update_tmstmp IS NULL " +
//                "or    (tgc.last_update_user_id IS NULL or tgc.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tgc.gfs_customer_name <> sgc.gfs_customer_name " +
                "or    tgc.site_id IS NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetGFSCustomerWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countStagedGFSCustUnitWithInvalidFields() 
         */
	public int countStagedGFSCustUnitWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
            "from cust_stage_admin.glazier_customer gc " +
            "       left outer join CUST_STAGE_ADMIN.GLAZIER_CREDIT_TERM_OVERRIDE gcto " +
            "                    on GC.CHAIN_CODE = GCTO.CHAIN_CODE " +
            "                  join CUST_STAGE_ADMIN.GLAZIER_CREDIT_TERM_MAPPING gcgctm " +
            "                    on GC.CREDIT_TERM_CODE = gcGCTM.GLAZIER_CREDIT_TERM_CODE " +
            "       left outer join CUST_STAGE_ADMIN.GLAZIER_CREDIT_TERM_MAPPING gctogctm " +
            "                    on GCTO.GLAZIER_CREDIT_TERM = GCTOGCTM.GLAZIER_CREDIT_TERM_CODE, " +
            "       cust_stage_admin.gfs_customer sgc, " +
            "       cust_stage_admin.gfs_cust_unit sgcu, " +
            "       cust_stage_admin.gfs_entity_xref xref " +
            "where xref.gfs_entity_type_code = 0 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.original_entity_id = sgc.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
            "and   xref.original_entity_id = gc.cust_nbr " +
            "and   sgc.gfs_customer_id = sgcu.gfs_customer_id " +
            "and   gc.valid_record_ind = 1 " +
            "and   (sgcu.customer_name <> gc.cust_name " +
            "or    sgcu.customer_status_code <> decode(gc.status,'A',1,'S',1,3) " +
            "or    sgcu.customer_add_date <> to_date(gc.add_date, 'YYYYMMDD') " +
            "or    sgcu.customer_status_date IS NULL " +
            "or    sgcu.customer_store_nbr <> NVL(trim(gc.efoods_nbr),trim(gc.store_nbr)) " +
            "or    (sgcu.key_acct_ind IS NULL or sgcu.key_acct_ind <> 0) " +
            "or    (sgcu.nationwide_acct_ind IS NULL or sgcu.nationwide_acct_ind <> 0) " +
            "or    (sgcu.franchise_ind IS NULL or sgcu.franchise_ind <> 0) " +
            "or    (sgcu.non_profit_ind IS NULL or sgcu.non_profit_ind <> 0) " +
            "or    (sgcu.accept_orders_ind IS NULL or sgcu.accept_orders_ind <> 0) " +
            "or     (  (GCTO.GLAZIER_CREDIT_TERM is not null and " +
            "             sgcu.credit_terms_code <> GCTOGCTM.GFS_CREDIT_TERM_CODE) " +
            "       or (GCTO.GLAZIER_CREDIT_TERM is NULL and " +
            "             sgcu.credit_terms_code <> GCGCTM.GFS_CREDIT_TERM_CODE)) " +
            "or    (sgcu.credit_limit_dollar_amt IS NULL or sgcu.credit_limit_dollar_amt <> 250) " +
            "or    (sgcu.credit_risk_code IS NULL or sgcu.credit_risk_code <> 2) " +
            "or    (sgcu.retail_credit_code IS NULL or sgcu.retail_credit_code <> 5) " +
            "or    sgcu.order_accept_status_date IS NULL " +
            "or    (sgcu.ar_statement_ind IS NULL or sgcu.ar_statement_ind <> 0) " +
            "or     ( (GCTO.GLAZIER_CREDIT_TERM is not NULL and " +
            "             sgcu.invoice_aging_code <> GCTOGCTM.GFS_INVOICE_AGING_CODE ) " +
            "       or (GCTO.GLAZIER_CREDIT_TERM is NULL and " +
            "             sgcu.invoice_aging_code <> GCGCTM.GFS_INVOICE_AGING_CODE )) " +
            "or    sgcu.order_guide_code <> decode(gc.status,'S',1,2) " +
            "or    (sgcu.food_show_spcl_ind IS NULL or sgcu.food_show_spcl_ind <> 0) " +
            "or    (sgcu.invoice_sales_copy_ind IS NULL or sgcu.invoice_sales_copy_ind <> 0) " +
            "or    (sgcu.cust_key_required_ind IS NULL or sgcu.cust_key_required_ind <> 0) " +
            "or    (sgcu.cust_palletize_ind IS  NULL or sgcu.cust_palletize_ind <> 0) " +
            "or    (sgcu.commission_cust_ind IS NULL or sgcu.commission_cust_ind <> 0) " +
            "or    sgcu.predecessor_gfs_customer_id <> gc.cust_nbr " +
            "or    sgcu.cust_dw_key IS NULL " +
            "or    sgcu.price_zone_nbr IS NOT NULL " +
            "or    (sgcu.order_lock_out_code IS NULL or sgcu.order_lock_out_code <> 2) " +
            "or    sgcu.sales_branch_nbr IS NULL " +
            "or    (sgcu.dsr_updates_og_ind IS NULL or sgcu.dsr_updates_og_ind <> 0) " +
//            "-- or (sgcu.trap_cust_reln_mgr_id = TBD) " +
            "or    (sgcu.dma_cust_ind IS NULL or sgcu.dma_cust_ind <> 0) " +
            "or    (sgcu.ec_cust_ind IS NULL or sgcu.ec_cust_ind <> 0) " +
            "or    (sgcu.pricing_audit_privlg_ind IS NULL or sgcu.pricing_audit_privlg_ind <> 0) " +
            "or    sgcu.first_sale_date <> to_date(gc.add_date,'YYYYMMDD') " +
            "or    sgcu.ar_acct_grp_id IS NOT NULL " +
            "or    sgcu.liquor_license_nbr IS NOT NULL " +
            "or    sgcu.liquor_license_name IS NOT NULL " +
            "or    (sgcu.new_sales_code IS NULL or sgcu.new_sales_code <> 1) " +
            "or    (sgcu.new_cust_ovrd_code IS NULL or sgcu.new_cust_ovrd_code <> 1) " +
            "or    sgcu.cpb_equip_code <> 2 " +
            "or    sgcu.sales_srvc_credit_apprv_code IS NULL " +
            "or    (sgcu.invoice_summary_format_id IS NULL or sgcu.invoice_summary_format_id <> 1) " +
            "or    (sgcu.invoice_item_order_format_id IS NULL or sgcu.invoice_item_order_format_id <> 1) " +
            "or    (sgcu.invoice_copies_cnt IS NULL or sgcu.invoice_copies_cnt <> 0) " +
            "or    (sgcu.accept_orders_user_id IS NULL or sgcu.accept_orders_user_id <> 'Glazier Conversion') " +
            "or    (sgcu.credit_cpb_equip_ind IS NULL or sgcu.credit_cpb_equip_ind <> 0) " +
            "or    (sgcu.credit_gfsplus_equip_ind IS NULL or sgcu.credit_gfsplus_equip_ind <> 0) " +
            "or    sgcu.business_opened_date IS NOT NULL " +
            "or    sgcu.business_current_owners_date IS NOT NULL " +
//            "--or   sgcu.cust_statement_code = TBD " +
            "or    sgcu.credit_action_defer_date IS NOT NULL " +
            "or    (sgcu.retail_min_charge_amt IS NULL or sgcu.retail_min_charge_amt <> 0) " +
            "or    sgcu.credit_risk_date IS NULL " +
            "or    (sgcu.retail_forced_authorize_ind IS NULL or sgcu.retail_forced_authorize_ind <> 0) " +
            "or    sgcu.customer_card_id IS NOT NULL " +
            "or    sgcu.measurement_system_code <> 'ANG' " +
            "or    sgcu.language_type_code <> 'EN' " +
            "or    sgcu.site_id IS NULL " +
            "or    (sgcu.company_nbr IS NULL or sgcu.company_nbr <> 1) " +
//            "--or  (sgcu.cust_reln_mgr_id = TBD) " +
            "or    sgcu.last_yr_winners_circle_crm_nbr IS NOT NULL " +
            "or    sgcu.winners_circle_crm_nbr IS NOT NULL " +
            "or    (sgcu.hps_commit_code IS NULL or sgcu.hps_commit_code <> 4) " +
            "or    sgcu.last_update_tmstmp IS NULL " +
            "or    (sgcu.last_update_user_id IS NULL or sgcu.last_update_user_id <> 'Glazier Load') " +
            "or    sgcu.price_bracket_id IS NOT NULL " +
            "or    sgcu.coffee_equipment_upcharge_amt IS NOT NULL " +
            "or    sgcu.franchisee_id IS NOT NULL " +
            "or    sgcu.business_unit_code <> decode(gc.ship_warehouse,1,36,2,37) " +
            "or    (sgcu.crm_pricing_privilege_ind IS NULL or sgcu.crm_pricing_privilege_ind <> 0) " +
            "or    sgcu.primary_ship_dc_nbr <> decode(gc.ship_warehouse,1,15,2,16) " +
            "or    sgcu.orig_gfs_customer_id IS NOT NULL " +
            "or    sgcu.orig_first_sales_date IS NOT NULL " +
            "or    sgcu.actual_first_sales_date <> to_date(gc.add_date,'YYYYMMDD') " +
            "or    sgcu.cpb_employee_nbr IS NOT NULL " +
            "or    (sgcu.arvon_report_ind IS NULL or sgcu.arvon_report_ind <> 0))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustUnitWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countStagedGFSCustUnitWithInvalidCrmId() 
         */
	public int countStagedGFSCustUnitWithInvalidCrmId() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from cust_stage_admin.gfs_cust_unit sgcu, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "       ((select distinct CRMX.CUST_RELN_MGR_ID, " +
                "                    gc.* " +
                "          from cust_stage_admin.glazier_customer gc " +
                "                  left outer join cust_stage_admin.glazier_chain_code_rep gccr " +
                "                        on GC.CHAIN_CODE = GCCR.CHAIN_CODE " +
                "                  left outer join CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF crmx " +
                "                        on CRMX.ORIGINAL_CRM_ID = GCCR.CHAIN_CODE_REP " +
                "         where  gccr.chain_code is not null and " +
                "                    CRMX.CUST_RELN_MGR_ID is not null and " +
                "                    crmx.business_unit_id IN (36,37)) " +
                "        union " +
                "         (select distinct CRMX.CUST_RELN_MGR_ID, " +
                "                     gc.* " +
                "          from cust_stage_admin.glazier_customer gc " +
                "                 left outer join cust_stage_admin.glazier_chain_code_rep gccr " +
                "                      on GC.CHAIN_CODE = GCCR.CHAIN_CODE " +
                "                left outer join CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF crmx " +
                "                      on CRMX.ORIGINAL_CRM_ID = gc.sales_rep_nbr " +
                "                      and (gc.parent_code not in (1,26,27,28) OR gc.parent_code IS NULL) "  +      
                "          where  gccr.chain_code is null and " +
                "                    CRMX.CUST_RELN_MGR_ID is not null and " +
                "                    crmx.business_unit_id IN (36,37)) " +
                "        union " +
                "         (select distinct INITCRMX.CUST_RELN_MGR_ID, " +
                "                     gc.* " +
                "           from cust_stage_admin.glazier_customer gc " +
                "                   left outer join cust_stage_admin.glazier_chain_code_rep gccr " +
                "                         on GC.CHAIN_CODE = GCCR.CHAIN_CODE " +
                "                left outer join CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF initcrmx " +
                "                      on initCRMX.ORIGINAL_CRM_ID = gc.CSR_INITIALS " +
                "            where GC.PARENT_CODE IN (1,26,27,28) and " +
                "                      GCCR.CHAIN_CODE is null and " +
                "                      INITCRMX.CUST_RELN_MGR_ID is not null)) gcrm " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgcu.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = 0 " +
                "and   xref.original_entity_id = gcrm.CUST_NBR " +
                "and   gcrm.valid_record_ind = 1 " +
                "and   sgcu.cust_reln_mgr_id <> gcrm.CUST_RELN_MGR_ID";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustUnitWithInvalidCrmId
        
       /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitDao#countTargetGFSCustUnitWithInvalidFields() 
         */
	public int countTargetGFSCustUnitWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_admin.gfs_cust_unit tgcu, " +
                "      cust_stage_admin.gfs_cust_unit sgcu, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   xref.original_entity_id = sgcu.gfs_customer_id " +
                "and   sgcu.gfs_customer_id = tgcu.gfs_customer_id " +
                "and   xref2.gfs_entity_type_code = 99 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tgcu.site_id " +
                "and   (sgcu.customer_name <> tgcu.customer_name " +
                "or    sgcu.customer_status_code <> tgcu.customer_status_code " +
                "or    to_date(sgcu.customer_add_date,'YYYYMMDD') <> to_date(tgcu.customer_add_date,'YYYYMMDD') " +
                "or    sgcu.customer_status_date IS NOT NULL " +
                "or    sgcu.customer_store_nbr <> tgcu.customer_store_nbr " +
                "or    (tgcu.key_acct_ind IS NOT NULL and tgcu.key_acct_ind <> 0) " +
                "or    (tgcu.nationwide_acct_ind IS NOT NULL and tgcu.nationwide_acct_ind <> 0) " +
                "or    (tgcu.franchise_ind IS NOT NULL and tgcu.franchise_ind <> 0) " +
                "or    (tgcu.non_profit_ind IS NOT NULL and tgcu.non_profit_ind <> 0) " +
                "or    (tgcu.accept_orders_ind IS NOT NULL and tgcu.accept_orders_ind <> 0) " +
//                "--or  (tgcu.credit_terms_code = TBD) " +
                "or    (tgcu.credit_limit_dollar_amt IS NOT NULL and tgcu.credit_limit_dollar_amt <> 250) " +
                "or    (tgcu.credit_risk_code IS NOT NULL and tgcu.credit_risk_code <> 2) " +
                "or    (tgcu.retail_credit_code IS NOT NULL and tgcu.retail_credit_code <> 5) " +
                "or    tgcu.order_accept_status_date IS NULL " +
                "or    (tgcu.ar_statement_ind IS NOT NULL and tgcu.ar_statement_ind <> 0) " +
//                "--or  (tgcu.invoice_aging_code = TBD) " +
                "or    sgcu.order_guide_code <> tgcu.order_guide_code " +
                "or    (tgcu.food_show_spcl_ind IS NOT NULL and tgcu.food_show_spcl_ind <> 0) " +
                "or    (tgcu.invoice_sales_copy_ind IS NOT NULL and tgcu.invoice_sales_copy_ind <> 0) " +
                "or    (tgcu.cust_key_required_ind IS NOT NULL and tgcu.cust_key_required_ind <> 0) " +
                "or    (tgcu.cust_palletize_ind IS NOT NULL and tgcu.cust_palletize_ind <> 0) " +
                "or    (tgcu.commission_cust_ind IS NOT NULL and tgcu.commission_cust_ind <> 0) " +
                "or    sgcu.predecessor_gfs_customer_id <> tgcu.predecessor_gfs_customer_id " +
                "or    tgcu.cust_dw_key IS NOT NULL " +
                "or    tgcu.price_zone_nbr IS NOT NULL " +
                "or    (tgcu.order_lock_out_code IS NOT NULL and tgcu.order_lock_out_code <> 2) " +
                "or    tgcu.sales_branch_nbr IS NOT NULL " +
                "or    (tgcu.dsr_updates_og_ind IS NOT NULL and tgcu.dsr_updates_og_ind <> 0) " +
//                "-- or (tgcu.trap_cust_reln_mgr_id = TBD) " +
                "or    (tgcu.dma_cust_ind IS NOT NULL and tgcu.dma_cust_ind <> 0) " +
                "or    (tgcu.ec_cust_ind IS NOT NULL and tgcu.ec_cust_ind <> 0) " +
                "or    (tgcu.pricing_audit_privlg_ind IS NOT NULL and tgcu.pricing_audit_privlg_ind <> 0) " +
                "or    to_date(sgcu.first_sale_date,'YYYYMMDD') <> to_date(tgcu.first_sale_date,'YYYYMMDD') " +
                "or    tgcu.ar_acct_grp_id IS NOT NULL " +
                "or    tgcu.liquor_license_nbr IS NOT NULL " +
                "or    tgcu.liquor_license_name IS NOT NULL " +
                "or    (tgcu.new_sales_code IS NOT NULL and tgcu.new_sales_code <> 1) " +
                "or    (tgcu.new_cust_ovrd_code IS NOT NULL and tgcu.new_cust_ovrd_code <> 1) " +
                "or    tgcu.cpb_equip_code IS NOT NULL " +
                "or    tgcu.sales_srvc_credit_apprv_code IS NOT NULL " +
                "or    (tgcu.invoice_summary_format_id IS NOT NULL and tgcu.invoice_summary_format_id <> 1) " +
                "or    (tgcu.invoice_item_order_format_id IS NOT NULL and tgcu.invoice_item_order_format_id <> 1) " +
                "or    (tgcu.invoice_copies_cnt IS NOT NULL and tgcu.invoice_copies_cnt <> 0) " +
                "or    (tgcu.accept_orders_user_id IS NOT NULL and tgcu.accept_orders_user_id <> 'Glazier Conversion') " +
                "or    (tgcu.credit_cpb_equip_ind IS NOT NULL and tgcu.credit_cpb_equip_ind <> 0) " +
                "or    (tgcu.credit_gfsplus_equip_ind IS NOT NULL and tgcu.credit_gfsplus_equip_ind <> 0) " +
                "or    tgcu.business_opened_date IS NOT NULL " +
                "or    tgcu.business_current_owners_date IS NOT NULL " +
//                "--or   tsgcu.cust_statement_code = TBD " +
                "or    tgcu.credit_action_defer_date IS NOT NULL " +
                "or    (tgcu.retail_min_charge_amt IS NOT NULL and tgcu.retail_min_charge_amt <> 0) " +
                "or    tgcu.credit_risk_date IS NOT NULL " +
                "or    (tgcu.retail_forced_authorize_ind IS NOT NULL and tgcu.retail_forced_authorize_ind <> 0) " +
                "or    tgcu.customer_card_id IS NOT NULL " +
                "or    tgcu.measurement_system_code <> 'ANG' " +
                "or    tgcu.language_type_code <> 'EN' " +
                "or    tgcu.site_id IS NOT NULL " +
                "or    (tgcu.company_nbr IS NOT NULL and tgcu.company_nbr <> 1) " +
//                "--or  (tgcu.cust_reln_mgr_id = TBD) " +
                "or    tgcu.last_yr_winners_circle_crm_nbr IS NOT NULL " +
                "or    tgcu.winners_circle_crm_nbr IS NOT NULL " +
                "or    (tgcu.hps_commit_code IS NOT NULL and tgcu.hps_commit_code <> 4) " +
                "or    tgcu.last_update_tmstmp IS NULL " +
                "or    (tgcu.last_update_user_id IS NOT NULL and tgcu.last_update_user_id <> 'Glazier Load') " +
                "or    tgcu.price_bracket_id IS NOT NULL " +
                "or    tgcu.coffee_equipment_upcharge_amt IS NOT NULL " +
                "or    tgcu.franchisee_id IS NOT NULL " +
                "or    sgcu.business_unit_code <> tgcu.business_unit_code " +
                "or    (tgcu.crm_pricing_privilege_ind IS NOT NULL and tgcu.crm_pricing_privilege_ind <> 0) " +
                "or    sgcu.primary_ship_dc_nbr <> tgcu.primary_ship_dc_nbr " +
                "or    tgcu.orig_gfs_customer_id IS NOT NULL " +
                "or    tgcu.orig_first_sales_date IS NOT NULL " +
                "or    to_date(sgcu.actual_first_sales_date,'YYYYMMDD') <> to_date(tgcu.actual_first_sales_date,'YYYYMMDD') " +
                "or    tgcu.cpb_employee_nbr IS NOT NULL " +
                "or    (tgcu.arvon_report_ind IS NOT NULL and tgcu.arvon_report_ind <> 0)) ";
//                "--or    tgcu.fuel_surcharge_eligible_ind = TBD))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetGFSCustUnitWithInvalidFields
        
}//end GlazierShiptoInfoToGFSCustUnitImpl
