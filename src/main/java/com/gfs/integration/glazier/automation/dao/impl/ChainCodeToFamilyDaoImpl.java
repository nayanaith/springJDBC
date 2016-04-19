/**
 * 
 */
package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao;

/**
 * This class implements the methods identified by the ChainCodeTofamilyDao
 * interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
 * schema and the cust_admin schema.
 * @author v7vyo
 *
 */
public class ChainCodeToFamilyDaoImpl extends NamedParameterJdbcTemplate implements ChainCodeToFamilyDao{
        
        //Default Consturctor
	public ChainCodeToFamilyDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countGlazierFamilies() 
         * for CUSMAINT_1142, CUSMAINT-1152, CUSMAINT-1154, CUSMAINT-1156
         */
	public int countGlazierFamilies() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(distinct chain_code) " + 
                             "from   cust_stage_admin.GLAZIER_CUSTOMER glz " +
                             "where  valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedGlazierFamiliesInGFSCustomer()
         * for CUSMAINT-1142, CUSMAINT-1143
         */
	public int countStagedGlazierFamiliesInGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countTargetGlazierFamiliesInGFSCustomer() 
         * for CUSMAINT_1143 
         */
	public int countTargetGlazierFamiliesInGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.println(result);		
		return Integer.parseInt(result);
	}
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedGFSCustomerWithInvalidFields() 
         * for CUSMAINT_1144
         */
	public int countStagedGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( " +
                    "select sgc.gfs_customer_id " +
                    "from   cust_stage_admin.gfs_customer sgc, " +
                    "       cust_stage_admin.gfs_entity_xref xref, " +
                    "          (select * " +
                    "          from  " +
                    "             (select cust_stage_admin.glazier_customer.*, " +
                    "             row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                    "             from   cust_stage_admin.glazier_customer " +
                    "             where  (parent_code is NULL OR parent_code <> 1)) " +
                    "          where  rownbr = 1) gc " +
                    "where  xref.gfs_entity_type_code = 3 " +
                    "and    xref.business_unit_code in (36,37) " +
                    "and    xref.original_entity_id = sgc.gfs_customer_id " +
                    "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                    "and    xref.original_entity_id = gc.chain_code " +
                    "and    gc.valid_record_ind = 1 " +
                    "and    (sgc.last_update_tmstmp IS NULL " +
                    "or     (sgc.last_update_user_id IS NULL or sgc.last_update_user_id NOT LIKE 'Glazier%') " +
                    "or     sgc.gfs_customer_name <> gc.chain_code_name " +
                    "or     sgc.site_id IS NOT NULL) " +
                    "UNION " +
                    "select sgc.gfs_customer_id " +
                    "from   cust_stage_admin.gfs_customer sgc, " +
                    "       cust_stage_admin.gfs_entity_xref xref, " +
                    "       cust_stage_admin.glazier_customer gc " +
                    "where  xref.gfs_entity_type_code = 3 " +
                    "and    xref.business_unit_code in (36,37) " +
                    "and    xref.original_entity_id = sgc.gfs_customer_id " +
                    "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                    "and    xref.original_entity_id = gc.chain_code " +
                    "and    gc.valid_record_ind = 1 " +
                    "and    gc.parent_code = 1 " +
                    "and    (sgc.last_update_tmstmp IS NULL " +
                    "or     (sgc.last_update_user_id IS NULL or sgc.last_update_user_id NOT LIKE 'Glazier%' " +
                    "or     sgc.gfs_customer_name <> gc.chain_code_name " +
                    "or     sgc.site_id IS NOT NULL)))";
                
		String result = this.queryForObject(sql, paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
                
	}//end countStagedGFSCustomerWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countTargetGFSCustomerWithInvalidFields()
         * for CUSMAINT-1358
         */
	public int countTargetGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   (tgc.last_update_tmstmp IS NULL " +
                "or    (tgc.last_update_user_id IS NULL or tgc.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tgc.gfs_customer_name <> sgc.gfs_customer_name " +
                "or    tgc.site_id IS NOT NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
                
	}//end countTargetGFSCustomerWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countTargetGFSCustFamilyWithInvalidFields()
         * for CUSMAINT-1360
         */
	public int countTargetGFSCustFamilyWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_family tcf, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_id = tcf.gfs_customer_id " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_type_code = 3 " +
                "and   (tcf.last_update_tmstmp IS NULL " +
                "or    (tcf.last_update_user_id IS NULL or tcf.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
                
	}//end countTargetGFSCustFamilyWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedGFSCustFamilyWithInvalidFields()
         * for CUSMAINT-1357
         */
	public int countStagedGFSCustFamilyWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( " +
                "select gc.cust_nbr " +
                "from   cust_stage_admin.gfs_cust_family gcf, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "          (select * " +
                "          from " +
                "             (select cust_stage_admin.glazier_customer.*, " +
                "             row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "             from   cust_stage_admin.glazier_customer " +
                "             where  (parent_code is NULL OR parent_code <> 1)) " +
                "          where  rownbr = 1) gc " +
                "where  xref.gfs_entity_type_code = 3 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.original_entity_id = gcf.gfs_customer_id " +
                "and    xref.original_entity_id = gc.chain_code " +
                "and    gc.valid_record_ind = 1 " +
                "and    (gcf.last_update_tmstmp IS NULL " +
                "or     (gcf.last_update_user_id IS NULL and gcf.last_update_user_id NOT LIKE 'Glazier%')) " +
                "UNION " +
                "select gc.cust_nbr " +
                "from   cust_stage_admin.gfs_cust_family gcf, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "       cust_stage_admin.glazier_customer gc " +
                "where  xref.gfs_entity_type_code = 3 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.original_entity_id = gcf.gfs_customer_id " +
                "and    xref.original_entity_id = gc.chain_code " +
                "and    gc.valid_record_ind = 1 " +
                "and    gc.parent_code = 1 " +
                "and    (gcf.last_update_tmstmp IS NULL " +
                "or     (gcf.last_update_user_id IS NULL and gcf.last_update_user_id NOT LIKE 'Glazier%')))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustFamilyWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedGFSCustGroupWithInvalidFields()
         * for CUSMAINT-1356
         */
	public int countStagedGFSCustGroupWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( " +
                "select scg.gfs_customer_id " +
                "from   cust_stage_admin.gfs_cust_group scg, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "          (select * " +
                "          from " +
                "             (select cust_stage_admin.glazier_customer.*, " +
                "             row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "             from   cust_stage_admin.glazier_customer " +
                "             where  (parent_code is NULL OR parent_code <> 1)) " +
                "          where  rownbr = 1) gc " +
                "where  xref.gfs_entity_type_code = 3 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.original_entity_id = scg.gfs_customer_id " +
                "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and    xref.original_entity_id = gc.chain_code " +
                "and    gc.valid_record_ind = 1 " +
                "and    (scg.customer_group_name <> gc.chain_code_name " +
                "or     scg.customer_group_desc IS NOT NULL " +
                "or     (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) " +
                "or     scg.cust_grp_status_date IS NULL " +
                "or     (scg.company_nbr IS NULL or scg.company_nbr <> 1) " +
                "or     scg.added_date IS NULL " +
                "or     (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) " +
                "or     (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) " +
                "or     scg.site_id IS NOT NULL " +
                "or     scg.last_update_tmstmp IS NULL " +
                "or     (scg.last_update_user_id IS NULL OR scg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or     scg.buyer_nbr IS NOT NULL) " +
                "UNION " +
                "select scg.gfs_customer_id " +
                "from   cust_stage_admin.gfs_cust_group scg, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "       cust_stage_admin.glazier_customer gc " +
                "where  xref.gfs_entity_type_code = 3 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.original_entity_id = scg.gfs_customer_id " +
                "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and    xref.original_entity_id = gc.chain_code " +
                "and    gc.valid_record_ind = 1 " +
                "and    (scg.customer_group_name <> gc.chain_code_name " +
                "or     scg.customer_group_desc IS NOT NULL " +
                "or     (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) " +
                "or     scg.cust_grp_status_date IS NULL " +
                "or     (scg.company_nbr IS NULL or scg.company_nbr <> 1) " +
                "or     scg.added_date IS NULL " +
                "or     (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) " +
                "or     (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) " +
                "or     scg.site_id IS NOT NULL " +
                "or     scg.last_update_tmstmp IS NULL " +
                "or     (scg.last_update_user_id IS NULL OR scg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or     scg.buyer_nbr IS NOT NULL))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}

        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countTargetGFSCustGroupWithInvalidFields()
         * for CUSMAINT-1359
         */
	public int countTargetGFSCustGroupWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group tcg, " +
                "      cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   (scg.customer_group_name <> tcg.customer_group_name " +
                "or    tcg.customer_group_desc IS NOT NULL " +
                "or    (tcg.cust_grp_status_code IS NULL or tcg.cust_grp_status_code <> 1) " +
                "or    tcg.cust_grp_status_date IS NULL " +
                "or    (tcg.company_nbr IS NULL or tcg.company_nbr <> 1) " +
                "or    tcg.added_date IS NULL " +
                "or    (tcg.pricing_audit_privlg_ind IS NULL or tcg.pricing_audit_privlg_ind <> 0) " +
                "or    (tcg.order_lock_out_code IS NULL or tcg.order_lock_out_code <> 2) " +
                "or    tcg.cust_reln_mgr_id <> scg.cust_reln_mgr_id " +
                "or    tcg.site_id IS NOT NULL " +
                "or    tcg.last_update_tmstmp IS NULL " +
                "or    (tcg.last_update_user_id IS NULL or tcg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tcg.buyer_nbr IS NOT NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
                
	}//end countTargetGFSCustGroupWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedGlazierFamiliesInGFSCustGroup() 
         * for CUSMAINT-1151, CUSMAINT-1154
         */
	public int countStagedGlazierFamiliesInGFSCustGroup(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.gfs_cust_group scg, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 3 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = scg.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);		
	}
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countTargetGlazierFamiliesInGFSCustGroup() 
         * for CUSMAINT-1151
         */
	public int countTargetGlazierFamiliesInGFSCustGroup(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select  count(*) " +
                             "from  cust_admin.gfs_cust_group tcg, " +
                             "      cust_stage_admin.gfs_entity_xref xref " +
                             "where xref.gfs_entity_type_code = 3 " +
                             "and   xref.business_unit_code in (36,37) " +
                             "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                             "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);		
		return Integer.parseInt(result);
	}
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedGlazierFamiliesInGFSCustFamily() 
         * for CUSMAINT_1153
         */
	public int countStagedGlazierFamiliesInGFSCustFamily(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.gfs_cust_family scf, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 3 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = scf.gfs_customer_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);		
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countTargetGlazierFamiliesInGFSCustFamily()
         * for CUSMAINT-1153
         */
	public int countTargetGlazierFamiliesInGFSCustFamily(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_admin.gfs_cust_family tcf, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 3 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.gfs_entity_id = tcf.gfs_customer_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}	
	
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countXrefWithNoChainCodeInGlazierCust() 
         * for CUSMAINT_1155
         */
	public int countXrefWithNoChainCodeInGlazierCust(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.gfs_entity_xref xref " +
                    "           full outer join cust_stage_admin.glazier_customer gc " +
                    "           on gc.chain_code = xref.original_entity_id " +
                    "where xref.gfs_entity_type_code = 3 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   gc.chain_code IS NULL ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}

        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countXrefWithNoFamilyInGFSCustomer() 
         * for CUSMAINT_1361
         */
	public int countXrefWithNoFamilyInGFSCustomer(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from cust_stage_admin.gfs_entity_xref xref " +
                "where xref.GFS_ENTITY_TYPE_CODE = 3 " +
                "      and xref.BUSINESS_UNIT_CODE in (36,37) " +
                "      and(xref.GFS_ENTITY_ID, xref.GFS_ENTITY_TYPE_CODE) not in ( " +
                "              select tgc.gfs_customer_id, tgc.gfs_customer_type_code " +
                "              from cust_admin.GFS_CUSTOMER tgc  " +
                "			  where tgc.last_update_user_id like 'Glazier%') ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}

                /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countStagedFamiliesInGFSEntityXref() 
         * for CUSMAINT_1156
         */
	public int countStagedFamiliesInGFSEntityXref(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.gfs_entity_xref xref " +
                        "where xref.gfs_entity_type_code = 3 " +
                        "and   xref.business_unit_code in (36,37)";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.ChainCodeToFamilyDao#countFamilyXrefEntriesWithoutId() 
         * for CUSMAINT_1157
         */
	public int countFamilyXrefEntriesWithoutId(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select   count(*) " +
                "from  cust_stage_admin.GFS_ENTITY_XREF xref " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   (xref.original_entity_id is null or xref.gfs_entity_id is null) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustGroupWithInvalidCrmId() 
         */
	public int countStagedGFSCustGroupWithInvalidCrmId() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from   cust_stage_admin.gfs_cust_group scg, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "((select " +
                " (select distinct CRMX.CUST_RELN_MGR_ID " +
                "  from CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF crmx " +
                "  where CRMX.BUSINESS_UNIT_ID in (36,37) and " +
                "             CRMX.ORIGINAL_CRM_ID = GCCR.CHAIN_CODE_REP) GFS_CUST_RELN_MGR_ID, " +
                "  gc.* " +
                "  from cust_stage_admin.glazier_chain_code_rep gccr " +
                "      left outer join  " +
                "         (select * " +
                "          from " +
                "             (select cust_stage_admin.glazier_customer.*, " +
                "                     row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "              from   cust_stage_admin.glazier_customer " +
                "              where  (parent_code is NULL OR parent_code <> 1)) " +
                "          where  rownbr = 1) gc " +
                "          on GCCR.CHAIN_CODE = GC.CHAIN_CODE " +
                "  where GC.CHAIN_CODE is not null) " +
                "UNION " +
                "(select " +
                "(select distinct CRMX.CUST_RELN_MGR_ID " +
                " from CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF crmx " +
                " where CRMX.BUSINESS_UNIT_ID in (36,37) and " +
                "           CRMX.ORIGINAL_CRM_ID = GC.CSR_INITIALS) GFS_CUST_RELN_MGR_ID, " +
                " gc.* " +
                " from " +
                "   (select * " +
                "    from " +
                "       (select cust_stage_admin.glazier_customer.*, " +
                "               row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "        from   cust_stage_admin.glazier_customer " +
                "        where  (parent_code is NULL OR parent_code <> 1)) " +
                "   where  rownbr = 1) gc " +
                "where GC.PARENT_CODE IN (1,26,27,28)) " +
                "UNION " +
                "(select  " +
                "  (select distinct CRMX.CUST_RELN_MGR_ID " +
                "   from CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF crmx " +
                "   where CRMX.BUSINESS_UNIT_ID in (36,37) and " +
                "             CRMX.ORIGINAL_CRM_ID = GC.SALES_REP_NBR ) GFS_CUST_RELN_MGR_ID, gc.* " +
                " from " +
                "  (select * " +
                "   from " +
                "      (select cust_stage_admin.glazier_customer.*, " +
                "              row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "       from   cust_stage_admin.glazier_customer " +
                "       where  (parent_code is NULL OR parent_code <> 1)) " +
                "   where  rownbr = 1) gc " +
                "where GC.CHAIN_CODE not in ( " +
                "   ((select gc.chain_code " +
                "     from cust_stage_admin.glazier_chain_code_rep gccr " +
                "     left outer join " +
                "        (select * " +
                "         from " +
                "           (select cust_stage_admin.glazier_customer.*, " +
                "                   row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "            from   cust_stage_admin.glazier_customer " +
                "            where  (parent_code is NULL OR parent_code <> 1)) " +
                "         where  rownbr = 1) gc " +
                "      on GCCR.CHAIN_CODE = GC.CHAIN_CODE " +
                "where GC.CHAIN_CODE is not null) " +
                "UNION " +
                "(select gc.chain_code " +
                " from " +
                "  (select * " +
                "   from " +
                "      (select cust_stage_admin.glazier_customer.*, " +
                "              row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                "       from   cust_stage_admin.glazier_customer " +
                "       where  (parent_code is NULL OR parent_code <> 1)) " +
                "   where  rownbr = 1) gc " +
                "where GC.PARENT_CODE IN (1,26,27,28))   )))) gcrm " +
                "where xref.gfs_entity_type_code = 3 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   xref.original_entity_id = gcrm.chain_code " +
                "and   gcrm.valid_record_ind = 1 " +
                "and   scg.cust_reln_mgr_id <> gcrm.GFS_CUST_RELN_MGR_ID";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustGroupWithInvalidCrmId
        
}//end BiltoToBiltoDaoImpl
