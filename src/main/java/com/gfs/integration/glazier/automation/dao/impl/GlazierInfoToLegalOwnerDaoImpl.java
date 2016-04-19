/**
 * 
 */
package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao;

/**
 * This class implements the methods identified by the GlazierInfoToLegalOwnerDao
 * interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
 * schema and the cust_admin schema.
 * @author e3k17
 *
 */
public class GlazierInfoToLegalOwnerDaoImpl extends NamedParameterJdbcTemplate implements GlazierInfoToLegalOwnerDao{
        
        //Default Consturctor
	public GlazierInfoToLegalOwnerDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countGlazierLegalOwners() 
         */
	public int countGlazierLegalOwners() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
                    + "select gc.cust_nbr "
                    + "from   cust_stage_admin.glazier_customer gc, "
                    + "       cust_stage_admin.glazier_avendra_customers gac "
                    + "where  gc.cust_nbr = gac.cust_nbr "
                    + "and    gc.valid_record_ind = 1 "
                    + "and    gc.parent_code = 1 "
                    + "UNION "
                    + "select distinct gc.chain_code "
                    + "from   cust_stage_admin.glazier_customer gc "
                    + "where  gc.valid_record_ind = 1 "
                    + "and    (gc.parent_code is NULL or gc.parent_code <> 1))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countGlazierLegalOwnerPrincipal() 
         */
	public int countGlazierLegalOwnerPrincipal() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
                + "select gc.cust_nbr, gc.chain_code "
                + "from   cust_stage_admin.glazier_customer gc, " 
                + "       cust_stage_admin.glazier_avendra_customers gac " 
                + "where  gc.cust_nbr = gac.cust_nbr " 
                + "and    gc.valid_record_ind = 1 " 
                + "and    gc.parent_code = 1 " 
                + "UNION " 
                + "(select cust_nbr, chain_code " 
                + "   from " 
                + "      (select gc.cust_nbr, gc.chain_code, " 
                + "              row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " 
                + "       from   cust_stage_admin.glazier_customer gc " 
                + "       where  (parent_code is NULL OR parent_code <> 1) " 
                + "       and     valid_record_ind = 1) " 
                + "   where  rownbr = 1) " 
                + "INTERSECT " 
                + "select  cust_nbr,chain_code " 
                + "from    cust_stage_admin.glazier_customer " 
                + "where valid_record_ind = 1 " 
                + "and     bill_to_addr_line_2 IS NOT NULL " 
                + "and     bill_to_addr_line_2 NOT LIKE ' ' " 
                + "and     bill_to_addr_line_2 NOT LIKE '%AP%' " 
                + "and     bill_to_addr_line_2 NOT LIKE '%A/P%' " 
                + "and     bill_to_addr_line_2 NOT LIKE '%Accounts Payable%' " 
                + "and     bill_to_addr_line_2 NOT LIKE '%ACCOUNTS PAYABLE%' " 
                + "and     bill_to_addr_line_2 NOT LIKE '%ACCOUNT PAYABLE%')"; 

		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countGlazierLegalOwnerPrincipalAssignments() 
         */
	public int countGlazierLegalOwnerPrincipalAssignments() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select  count(*) from ( " +
                    "select gc.cust_nbr, gc.chain_code " +
                    "from   cust_stage_admin.glazier_customer gc, " +
                    "       cust_stage_admin.glazier_avendra_customers gac " +
                    "where  gc.cust_nbr = gac.cust_nbr " +
                    "and    gc.valid_record_ind = 1 " +
                    "and    gc.parent_code = 1 " +
                    "UNION " +
                    "(select cust_nbr, chain_code " +
                    "   from " +
                    "      (select gc.cust_nbr, gc.chain_code, " +
                    "              row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
                    "       from   cust_stage_admin.glazier_customer gc " +
                    "       where  (parent_code is NULL OR parent_code <> 1) " +
                    "       and     valid_record_ind = 1) " +
                    "   where  rownbr = 1) " +
                    "INTERSECT " +
                    "select  cust_nbr,chain_code " +
                    "from    cust_stage_admin.glazier_customer " +
                    "where valid_record_ind = 1 " +
                    "and     bill_to_addr_line_2 IS NOT NULL " +
                    "and     bill_to_addr_line_2 NOT LIKE ' ' " +
                    "and     bill_to_addr_line_2 NOT LIKE '%AP%' " +
                    "and     bill_to_addr_line_2 NOT LIKE '%A/P%' " +
                    "and     bill_to_addr_line_2 NOT LIKE '%Accounts Payable%' " +
                    "and     bill_to_addr_line_2 NOT LIKE '%ACCOUNTS PAYABLE%' " +
                    "and     bill_to_addr_line_2 NOT LIKE '%ACCOUNT PAYABLE%')";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnersInGFSCustomer() 
         */
	public int countStagedLegalOwnersInGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnersInGFSCustomer
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnersInGFSCustomer() 
         */
	public int countTargetLegalOwnersInGFSCustomer() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnersInGFSCustomer

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustomerWithInvalidFields() 
         */
	public int countStagedGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
                + "select sgc.gfs_customer_id "
                + "from   cust_stage_admin.gfs_customer sgc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "          (select * "
                + "          from "
                + "             (select cust_stage_admin.glazier_customer.*, "
                + "             row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr "
                + "             from   cust_stage_admin.glazier_customer "
                + "             where  (parent_code is NULL OR parent_code <> 1)) "
                + "          where  rownbr = 1) gc "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.chain_code "
                + "and    gc.valid_record_ind = 1 "
                + "and    (sgc.last_update_tmstmp IS NULL "
                + "or     (sgc.last_update_user_id IS NOT NULL and sgc.last_update_user_id <> 'Glazier Load') "
                + "or     sgc.gfs_customer_name <> NVL2(trim(gc.parent_code),gc.chain_code_name,gc.bill_to_name) "
                + "or     sgc.site_id IS NULL) "
                + "UNION "
                + "select sgc.gfs_customer_id "
                + "from   cust_stage_admin.gfs_customer sgc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_avendra_customers gac "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code = 1 "
                + "and    (sgc.last_update_tmstmp IS NULL "
                + "or     (sgc.last_update_user_id IS NOT NULL and sgc.last_update_user_id <> 'Glazier Load') "
                + "or     sgc.gfs_customer_name <> gac.management_co_name "
                + "or     sgc.site_id IS NULL))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustomerWithInvalidFields    

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustomerWithInvalidCustName() 
         */
	public int countStagedGFSCustomerWithInvalidCustName() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) "
                    + "from   cust_stage_admin.gfs_customer sgc, "
                    + "       cust_stage_admin.gfs_entity_xref xref, "
                    + "       cust_stage_admin.glazier_customer gc, "
                    + "       cust_stage_admin.glazier_avendra_customers gac "
                    + "where  xref.gfs_entity_type_code = 10 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = sgc.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                    + "and    xref.original_entity_id = gc.cust_nbr "
                    + "and    gc.cust_nbr = gac.cust_nbr "
                    + "and    gc.valid_record_ind = 1 "
                    + "and    gc.parent_code = 1 "
                    + "and    sgc.gfs_customer_name <> gac.management_co_name";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustomerWithInvalidCustName

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustGroupWithInvalidCustName() 
         */
	public int countStagedGFSCustGroupWithInvalidCustName() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_group scg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_avendra_customers gac "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code = 1 "
                + "and    scg.customer_group_name <> gac.management_co_name";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustGroupWithInvalidCustName

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
            "  where crmx.business_unit_id IN (36,37) " +
            "  and CRMX.ORIGINAL_CRM_ID = GCCR.CHAIN_CODE_REP) GFS_CUST_RELN_MGR_ID, " +
            "  gc.* " +
            "  from cust_stage_admin.glazier_chain_code_rep gccr " +
            "      left outer join " +
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
            " where crmx.business_unit_id IN (36,37) " +
            " and  CRMX.ORIGINAL_CRM_ID = GC.CSR_INITIALS) GFS_CUST_RELN_MGR_ID, " +
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
            "(select " +
            "  (select distinct CRMX.CUST_RELN_MGR_ID " +
            "   from CUST_STAGE_ADMIN.CUST_RELN_MGR_XREF crmx " +
            "   where crmx.business_unit_id IN (36,37) " +
            "   and   CRMX.ORIGINAL_CRM_ID = GC.SALES_REP_NBR ) GFS_CUST_RELN_MGR_ID, gc.* " +
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
            "where xref.gfs_entity_type_code = 10 " +
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
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetGFSCustomerWithInvalidFields() 
         */
	public int countTargetGFSCustomerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   xref2.gfs_entity_type_code = 99 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tgc.site_id " +
                "and   (tgc.last_update_tmstmp IS NULL " +
                "or    (tgc.last_update_user_id IS NOT NULL and tgc.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tgc.gfs_customer_name <> sgc.gfs_customer_name " +
                "or    tgc.site_id IS NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustomerWithInvalidFields  

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustGroupWithInvalidFields() 
         */
	public int countStagedGFSCustGroupWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
                + "select scg.gfs_customer_id "
                + "from   cust_stage_admin.gfs_cust_group scg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       (select * "
                + "       from "
                + "           (select cust_stage_admin.glazier_customer.*, "
                + "                   row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr "
                + "           from   cust_stage_admin.glazier_customer "
                + "           where  (parent_code is NULL OR parent_code <> 1)) "
                + "       where  rownbr = 1) gc "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.chain_code "
                + "and    gc.valid_record_ind = 1 "
                + "and    (scg.customer_group_name <> NVL2(trim(gc.parent_code),gc.chain_code_name,gc.bill_to_name) "
                + "or     scg.customer_group_desc IS NOT NULL "
                + "or     (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) "
                + "or     scg.cust_grp_status_date IS NULL "
                + "or     (scg.company_nbr IS NULL or scg.company_nbr <> 1) "
                + "or     scg.added_date IS NULL "
                + "or     (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) "
                + "or     (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) "
                + "or     scg.site_id IS NULL "
                + "or     scg.last_update_tmstmp IS NULL "
                + "or     (scg.last_update_user_id IS NULL OR scg.last_update_user_id NOT LIKE 'Glazier%') "
                + "or     scg.buyer_nbr IS NOT NULL) "
                + "UNION "
                + "select scg.gfs_customer_id "
                + "from   cust_stage_admin.gfs_cust_group scg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_avendra_customers gac "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code = 1 "
                + "and    (scg.customer_group_name <> gac.management_co_name "
                + "or     scg.customer_group_desc IS NOT NULL "
                + "or     (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) "
                + "or     scg.cust_grp_status_date IS NULL "
                + "or     (scg.company_nbr IS NULL or scg.company_nbr <> 1) "
                + "or     scg.added_date IS NULL "
                + "or     (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) "
                + "or     (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) "
                + "or     scg.site_id IS NULL "
                + "or     scg.last_update_tmstmp IS NULL "
                + "or     (scg.last_update_user_id IS NULL OR scg.last_update_user_id NOT LIKE 'Glazier%') "
                + "or     scg.buyer_nbr IS NOT NULL))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustGroupWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetGFSCustGroupWithInvalidFields() 
         */
	public int countTargetGFSCustGroupWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group tcg, " +
                "      cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code " +
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
                "or    (tcg.cust_reln_mgr_id <> scg.cust_reln_mgr_id) " +
                "or    tcg.site_id IS NULL " +
                "or    tcg.last_update_tmstmp IS NULL " +
                "or    (tcg.last_update_user_id IS NULL or tcg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or    tcg.buyer_nbr IS NOT NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetGFSCustGroupWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedCRMSiteWithInvalidFields() 
         */
	public int countStagedCRMSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( " +
            "select cs.crm_site_id " +
            "from   cust_stage_admin.gfs_customer_site scs, " +
            "       cust_stage_admin.crm_site cs, " +
            "       cust_stage_admin.gfs_entity_xref xref, " +
            "       (select * " +
            "       from  " +
            "       (select cust_stage_admin.glazier_customer.*, " +
            "       row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " +
            "from   cust_stage_admin.glazier_customer " +
            "where  (parent_code is NULL OR parent_code <> 1)) " +
            "where  rownbr = 1) gc " +
            "where  xref.gfs_entity_type_code = 10 " +
            "and    xref.business_unit_code in (36,37) " +
            "and    xref.original_entity_id = scs.gfs_customer_id " +
            "and    xref.gfs_entity_type_code = scs.gfs_customer_type_code " +
            "and    xref.original_entity_id = gc.chain_code " +
            "and    scs.crm_site_id = cs.crm_site_id " +
            "and    gc.valid_record_ind = 1 " +
            "and    (cs.crm_site_id IS NULL " +
            "or     cs.site_desc IS NOT NULL " +
            "or     cs.address_1_txt <> NVL2(trim(gc.parent_code),gc.ship_to_addr_line_1,gc.bill_to_addr_line_1) " +
            "or     cs.address_2_txt IS NOT NULL " +
            "or     cs.address_3_txt IS NOT NULL " +
            "or     cs.address_attn_txt IS NOT NULL " +
            "or     cs.city_name <> NVL2(trim(gc.parent_code),gc.ship_to_city_name,gc.bil_to_city_name) " +
            "or     cs.state_alpha_code <> NVL2(trim(gc.parent_code),gc.ship_to_state_code,gc.bill_to_state_code) " +
            "or     cs.postal_code <> substr(NVL2(trim(gc.parent_code),gc.ship_to_postal_code,gc.bill_to_postal_code),1,5) " +
            "or     (cs.country_code IS NULL or cs.country_code <> 'US') " +
            "or     cs.county_code IS NOT NULL " +
            "or     cs.default_tax_geo_code IS NOT NULL " +
            "or     cs.override_tax_geo_code IS NOT NULL " +
            "or     cs.last_update_tmstmp IS NULL " +
            "or     (cs.last_update_user_id IS NULL or cs.last_update_user_id NOT LIKE 'Glazier%') " +
            "or     cs.temp_default_tax_geo_code IS NOT NULL " +
            "or     cs.temp_override_tax_geo_code IS NOT NULL " +
            "or     cs.twe_tax_geo_code IS NOT NULL) " +
            "UNION " +
            "select cs.crm_site_id " +
            "from   cust_stage_admin.gfs_customer_site scs, " +
            "       cust_stage_admin.crm_site cs, " +
            "       cust_stage_admin.gfs_entity_xref xref, " +
            "       cust_stage_admin.glazier_customer gc, " +
            "       cust_stage_admin.glazier_avendra_customers gac " +
            "where  xref.gfs_entity_type_code = 10 " +
            "and    xref.business_unit_code in (36,37) " +
            "and    xref.original_entity_id = scs.gfs_customer_id " +
            "and    xref.gfs_entity_type_code = scs.gfs_customer_type_code " +
            "and    xref.original_entity_id = gc.cust_nbr " +
            "and    scs.crm_site_id = cs.crm_site_id " +
            "and    gc.valid_record_ind = 1 " +
            "and    gc.parent_code = 1 " +
            "and    gc.cust_nbr = gac.cust_nbr " +
            "and    (cs.crm_site_id IS NULL " +
            "or     cs.site_desc IS NOT NULL " +
            "or     cs.address_1_txt <> gac.street_1 " +
            "or     cs.address_2_txt IS NOT NULL " +
            "or     cs.address_3_txt IS NOT NULL " +
            "or     cs.address_attn_txt IS NOT NULL " +
            "or     cs.city_name <> gac.city " +
            "or     cs.state_alpha_code <> gac.state " +
            "or     cs.postal_code <> substr(gac.zip,1,5) " +
            "or     (cs.country_code IS NULL or cs.country_code <> 'US') " +
            "or     cs.county_code IS NOT NULL " +
            "or     cs.default_tax_geo_code IS NOT NULL " +
            "or     cs.override_tax_geo_code IS NOT NULL " +
            "or     cs.last_update_tmstmp IS NULL " +
            "or     (cs.last_update_user_id IS NULL or cs.last_update_user_id NOT LIKE 'Glazier%') " +
            "or     cs.temp_default_tax_geo_code IS NOT NULL " +
            "or     cs.temp_override_tax_geo_code IS NOT NULL " +
            "or     cs.twe_tax_geo_code IS NOT NULL))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedCRMSiteWithInvalidFields
     
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetCRMSiteWithInvalidFields() 
         */
	public int countTargetCRMSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
            "from  cust_admin.gfs_customer tgc, " +
            "      cust_admin.crm_site tcs, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2, " +
            "      cust_stage_admin.crm_site scs " +
            "where tgc.gfs_customer_type_code = 10 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   tgc.gfs_customer_id = xref.gfs_entity_id " +
            "and   tgc.gfs_customer_type_code = xref.gfs_entity_type_code " +
            "and   tgc.site_id = xref2.gfs_entity_id " +
            "and   xref2.gfs_entity_type_code = 99 " +
            "and   xref2.business_unit_code in (36,37) " +
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
            "or    tcs.county_code IS NULL " +
            "or    tcs.default_tax_geo_code IS NOT NULL " +
            "or    tcs.override_tax_geo_code IS NOT NULL " +
            "or    tcs.last_update_tmstmp IS NULL " +
            "or    (tcs.last_update_user_id IS NULL or tcs.last_update_user_id NOT LIKE 'Glazier%') " +
            "or    tcs.temp_default_tax_geo_code IS NOT NULL " +
            "or    tcs.temp_override_tax_geo_code IS NOT NULL " +
            "or    tcs.twe_tax_geo_code IS NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetCRMSiteWithInvalidFields
    
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustomerSiteWithInvalidFields() 
         */
	public int countStagedGFSCustomerSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
            + "select scs.gfs_customer_id "
            + "from   cust_stage_admin.gfs_customer_site scs, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       (select * "
            + "       from "
            + "         (select cust_stage_admin.glazier_customer.*, "
            + "         row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr "
            + "         from   cust_stage_admin.glazier_customer "
            + "         where  (parent_code is NULL OR parent_code <> 1)) "
            + "       where  rownbr = 1) gc "
            + "where  xref.gfs_entity_type_code = 10 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = scs.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scs.gfs_customer_type_code "
            + "and    xref.original_entity_id = gc.chain_code "                       
            + "and    gc.valid_record_ind = 1 "
            + "and    (scs.crm_site_id IS NULL "
            + "or     (scs.primary_site_ind IS NULL or scs.primary_site_ind <> 1) "
            + "or     scs.last_update_tmstmp IS NULL "
            + "or     (scs.last_update_user_id IS NULL or scs.last_update_user_id NOT LIKE 'Glazier%')) "
            + "UNION "
            + "select scs.gfs_customer_id "
            + "from   cust_stage_admin.gfs_customer_site scs, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.glazier_customer gc "
            + "where  xref.gfs_entity_type_code = 10 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = scs.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scs.gfs_customer_type_code "
            + "and    xref.original_entity_id = gc.cust_nbr "
            + "and    gc.valid_record_ind = 1 "
            + "and    gc.parent_code = 1 "
            + "and    (scs.crm_site_id IS NULL "
            + "or     (scs.primary_site_ind IS NULL or scs.primary_site_ind <> 1) "
            + "or     scs.last_update_tmstmp IS NULL "
            + "or     (scs.last_update_user_id IS NULL or scs.last_update_user_id NOT LIKE 'Glazier%')))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustomerSiteWithInvalidFields
    
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetGFSCustomerSiteWithInvalidFields() 
         */
	public int countTargetGFSCustomerSiteWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
            "from  cust_admin.gfs_customer_site tcs, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2, " +
            "      cust_stage_admin.gfs_customer_site scs " +
            "where xref.gfs_entity_type_code = 10 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.gfs_entity_id = tcs.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = tcs.gfs_customer_type_code " +
            "and   xref.original_entity_id = scs.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = scs.gfs_customer_type_code " +
            "and   xref2.gfs_entity_type_code = 99 " +
            "and   xref2.business_unit_code in (36,37) " +
            "and   xref2.original_entity_id = scs.crm_site_id " +
            "and   xref2.gfs_entity_id = tcs.crm_site_id " +
            "and   (tcs.crm_site_id IS NULL " +
            "or    (tcs.primary_site_ind IS NULL or tcs.primary_site_ind <> 1) " +
            "or    tcs.last_update_tmstmp IS NULL " +
            "or    (tcs.last_update_user_id IS NULL or tcs.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetGFSCustomerSiteWithInvalidFields
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnersInGFSCustGroup() 
         */
	public int countStagedLegalOwnersInGFSCustGroup() {
		final SqlParameterSource paramMap = null;
                
                String sql = " select count(*) " +
                    "from  cust_stage_admin.gfs_cust_group scg, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 10 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = scg.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnersInGFSCustGroup
 
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnersInGFSCustGroup() 
         */
	public int countTargetLegalOwnersInGFSCustGroup() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group tcg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnersInGFSCustGroup

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnersInCRMSite() 
         */
	public int countStagedLegalOwnersInCRMSite() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_customer_site scs, " +
                "      cust_stage_admin.crm_site cs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scs.gfs_customer_type_code " +
                "and   scs.crm_site_id = cs.crm_site_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnersInCRMSite

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnersInCRMSite() 
         */
	public int countTargetLegalOwnersInCRMSite() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from   cust_admin.gfs_customer_site tcs, " +
                    "       cust_admin.crm_site cs, " +
                    "       cust_stage_admin.gfs_entity_xref xref " +
                    "where  xref.gfs_entity_type_code = 10 " +
                    "and    xref.business_unit_code in (36,37) " +
                    "and    xref.gfs_entity_id = tcs.gfs_customer_id " +
                    "and    xref.gfs_entity_type_code = tcs.gfs_customer_type_code " +
                    "and    tcs.crm_site_id = cs.crm_site_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnersInCRMSite
    
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnersInGFSCustomerSite() 
         */
	public int countStagedLegalOwnersInGFSCustomerSite() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_customer_site scs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scs.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnersInGFSCustomerSite

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnersInGFSCustomerSite() 
         */
	public int countTargetLegalOwnersInGFSCustomerSite() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer_site tcs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcs.gfs_customer_type_code";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnersInGFSCustomerSite
    
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnersInGFSEntityXref() 
         */
	public int countStagedLegalOwnersInGFSEntityXref() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(* ) " +
                        "from  cust_stage_admin.gfs_entity_xref xref " +
                        "where xref.gfs_entity_type_code = 10 " +
                        "and   xref.business_unit_code in (36,37)";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnersInGFSEntityXref
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedGFSCustLegalOwnerWithInvalidFields() 
         */
	public int countStagedGFSCustLegalOwnerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( " 
                + "select sclo.gfs_customer_id " 
                + "from   cust_stage_admin.gfs_cust_legal_owner sclo, " 
                + "       cust_stage_admin.gfs_entity_xref xref, " 
                + "       (select * " 
                + "       from " 
                + "       (select cust_stage_admin.glazier_customer.*, " 
                + "       row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr " 
                + "from   cust_stage_admin.glazier_customer " 
                + "where  (parent_code is NULL OR parent_code <> 1)) " 
                + "where  rownbr = 1) gc " 
                + "where  xref.gfs_entity_type_code = 10 " 
                + "and    xref.business_unit_code in (36,37) " 
                + "and    xref.original_entity_id = sclo.gfs_customer_id " 
                + "and    xref.original_entity_id = gc.chain_code " 
                + "and    gc.valid_record_ind = 1 " 
                + "and    (gc.chain_code <> sclo.customer_family_id " 
                + "or     (sclo.statements_provided_code IS NULL or sclo.statements_provided_code <> 2) " 
                + "or     ((gc.bill_to_addr_line_2 IS NULL and sclo.guarantee_code <> 1) " 
                + "or     (gc.bill_to_addr_line_2 LIKE '%AP%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%A/P%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%Accounts Payable%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%ACCOUNTS PAYABLE%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%ACCOUNT PAYABLE%'  and sclo.guarantee_code <> 1)) "
                + "and    ((gc.bill_to_addr_line_2 NOT LIKE '%AP%' and sclo.guarantee_code <> 2) "
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%A/P%' and sclo.guarantee_code <> 2) "
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%Accounts Payable%' and sclo.guarantee_code <> 2) "
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%ACCOUNTS PAYABLE%' and sclo.guarantee_code <> 2) "
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%ACCOUNT PAYABLE%'  and sclo.guarantee_code <> 2)) "
                + "or     sclo.statements_provided_date IS NOT NULL "
                + "or     ((sclo.guarantee_code = 1 and sclo.guarantee_date IS NOT NULL) OR (sclo.guarantee_code = 2 and sclo.guarantee_date IS NULL)) "
                + "or     sclo.duns_nbr IS NOT NULL "
                + "or     (sclo.business_code IS NOT NULL and sclo.business_code <> 6) "
                + "or     (sclo.bankruptcy_filed_ind IS NULL or sclo.bankruptcy_filed_ind <> 0) "
                + "or     (sclo.bankruptcy_code IS NULL or sclo.bankruptcy_code <> 7) "
                + "or     sclo.bankruptcy_discharged_date IS NOT NULL "
                + "or     sclo.last_update_tmstmp IS NULL "
                + "or     (sclo.last_update_user_id IS NULL or sclo.last_update_user_id NOT LIKE 'Glazier%')) "
                + "UNION "
                + "select sclo.gfs_customer_id "
                + "from   cust_stage_admin.gfs_cust_legal_owner sclo, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_customer gc  "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sclo.gfs_customer_id "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code = 1 "
                + "and    (gc.chain_code <> sclo.customer_family_id "
                + "or     (sclo.statements_provided_code IS NULL or sclo.statements_provided_code <> 2) "
                + "or     ((gc.bill_to_addr_line_2 IS NULL and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%AP%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%A/P%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%Accounts Payable%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%ACCOUNTS PAYABLE%' and sclo.guarantee_code <> 1) "
                + "or     (gc.bill_to_addr_line_2 LIKE '%ACCOUNT PAYABLE%'  and sclo.guarantee_code <> 1)) "
                + "and    ((gc.bill_to_addr_line_2 NOT LIKE '%AP%' and sclo.guarantee_code <> 2) "
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%A/P%' and sclo.guarantee_code <> 2) "
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%Accounts Payable%' and sclo.guarantee_code <> 2) "  
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%ACCOUNTS PAYABLE%' and sclo.guarantee_code <> 2) "  
                + "or     (gc.bill_to_addr_line_2 NOT LIKE '%ACCOUNT PAYABLE%'  and sclo.guarantee_code <> 2)) "
                + "or     sclo.statements_provided_date IS NOT NULL "
                + "or     ((sclo.guarantee_code = 1 and sclo.guarantee_date IS NOT NULL) OR (sclo.guarantee_code = 2 and sclo.guarantee_date IS NULL)) "
                + "or     sclo.duns_nbr IS NOT NULL "
                + "or     (sclo.business_code IS NOT NULL and sclo.business_code <> 6) "
                + "or     (sclo.bankruptcy_filed_ind IS NULL or sclo.bankruptcy_filed_ind <> 0) "
                + "or     (sclo.bankruptcy_code IS NULL or sclo.bankruptcy_code <> 7) "
                + "or     sclo.bankruptcy_discharged_date IS NOT NULL "
                + "or     sclo.last_update_tmstmp IS NULL "
                + "or     (sclo.last_update_user_id IS NULL or sclo.last_update_user_id NOT LIKE 'Glazier%')))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
                
	}//end countStagedGFSCustLegalOwnerWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetGFSCustLegalOwnerWithInvalidFields() 
         */
	public int countTargetGFSCustLegalOwnerWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = " select count(*) " +
            "from  cust_stage_admin.gfs_cust_legal_owner sclo, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.gfs_entity_xref xref2, " +
            "      cust_admin.gfs_cust_legal_owner tclo " +
            "where xref.gfs_entity_type_code = 10 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.original_entity_id = sclo.gfs_customer_id " +
            "and   xref.gfs_entity_id = tclo.gfs_customer_id " +
            "and   xref2.gfs_entity_type_code = 3 " +
            "and   xref2.business_unit_code in (36,37) " +
            "and   xref2.gfs_entity_id = tclo.customer_family_id " +
            "and   (sclo.statements_provided_code <> tclo.statements_provided_code " +
            "or    sclo.guarantee_code <> tclo.guarantee_code " +
            "or    tclo.statements_provided_date IS NOT NULL " +
            "or    (tclo.guarantee_date IS NULL AND tclo.guarantee_code = 2 OR " +
            "      tclo.guarantee_date IS NOT NULL AND tclo.guarantee_code = 1) " + 
            "or    tclo.duns_nbr IS NOT NULL " +
            "or    (tclo.business_code IS NULL or tclo.business_code <> 6) " +
            "or    (tclo.bankruptcy_filed_ind IS NULL or tclo.bankruptcy_filed_ind <> 0) " +
            "or    (tclo.bankruptcy_code IS NULL or tclo.bankruptcy_code <> 7) " +
            "or    tclo.bankruptcy_discharged_date IS NOT NULL " +
            "or    tclo.last_update_tmstmp IS NULL " +
            "or    (tclo.last_update_user_id IS NULL or tclo.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetGFSCustLegalOwnerWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerPrincipalWithInvalidFields() 
         */
	public int countStagedLegalOwnerPrincipalWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_entity_xref xref," +
                "      cust_stage_admin.legal_owner_principal_asgn lopa, " +
                "      cust_stage_admin.legal_owner_principal slop " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = lopa.gfs_customer_id " +
                "and   lopa.legal_owner_principal_id = slop.legal_owner_principal_id " +
                "and   (slop.principal_ttl IS NOT NULL " +
                "or    (slop.signature_on_file_ind IS NULL or slop.signature_on_file_ind <> 0) " +
                "or    slop.signature_on_file_date IS NOT NULL " +
                "or    slop.contact_id IS NULL " +
                "or    slop.last_update_tmstmp IS NULL " +
                "or    (slop.last_update_user_id IS NULL or slop.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerPrincipalWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerPrincipalWithInvalidFields() 
         */
	public int countTargetLegalOwnerPrincipalWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from   cust_admin.legal_owner_principal_asgn tlopa, " +
                "       cust_admin.legal_owner_principal tlop, " +
                "       cust_stage_admin.gfs_entity_xref xref, " +
                "       cust_stage_admin.gfs_entity_xref xref2 " +
                "where  xref.gfs_entity_type_code = 10 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.gfs_entity_id = tlopa.gfs_customer_id " +
                "and    tlopa.legal_owner_principal_id = tlop.legal_owner_principal_id " +
                "and    xref2.gfs_entity_type_code = 96 " +
                "and    xref2.business_unit_code in (36,37) " +
                "and    xref2.gfs_entity_id = tlop.legal_owner_principal_id " +
                "and    (tlop.principal_ttl IS NOT NULL " +
                "and    (tlop.signature_on_file_ind IS NULL or tlop.signature_on_file_ind <> 0) " +
                "and    tlop.signature_on_file_date IS NOT NULL " +
                "and    tlop.contact_id IS NULL " +
                "and    tlop.last_update_tmstmp IS NULL " +
                "and    (tlop.last_update_user_id IS NULL or tlop.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerPrincipalWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerPrincipalAsgnWithInvalidFields() 
         */
	public int countStagedLegalOwnerPrincipalAsgnWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.legal_owner_principal_asgn lopa, " +
                "      cust_stage_admin.legal_owner_principal slop " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = lopa.gfs_customer_id " +
                "and   lopa.legal_owner_principal_id = slop.legal_owner_principal_id " +
                "and   (lopa.last_update_tmstmp IS NULL " +
                "or    (lopa.last_update_user_id IS NULL or lopa.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerPrincipalAsgnWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerPrincipalAsgnWithInvalidFields() 
         */
	public int countTargetLegalOwnerPrincipalAsgnWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
        "from  cust_admin.legal_owner_principal_asgn tlopa, " +
        "      cust_stage_admin.gfs_entity_xref xref, " +
        "      cust_stage_admin.gfs_entity_xref xref2, " +
        "      cust_stage_admin.legal_owner_principal_asgn slopa " +
        "where xref.gfs_entity_type_code = 10 " +
        "and   xref.business_unit_code in (36,37) " +
        "and   xref.gfs_entity_id = tlopa.gfs_customer_id " +
        "and   xref.original_entity_id = slopa.gfs_customer_id " +
        "and   xref2.gfs_entity_type_code = 96 " +
        "and   xref2.business_unit_code in (37,38) " +                
        "and   xref2.gfs_entity_id = tlopa.legal_owner_principal_id " +
        "and   xref2.original_entity_id = slopa.legal_owner_principal_id " +
        "and   (tlopa.last_update_tmstmp IS NULL " +
        "and   (tlopa.last_update_user_id IS NULL or tlopa.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerPrincipalAsgnWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedCustomerContactWithInvalidFields() 
         */
	public int countStagedCustomerContactWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
                + "select slopa.gfs_customer_id "
                + "from   cust_stage_admin.legal_owner_principal_asgn slopa, "
                + "       cust_stage_admin.legal_owner_principal slop, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact scc, "
                + "       (select * "
                + "       from "
                + "         (select cust_stage_admin.glazier_customer.*, "
                + "         row_number() OVER (PARTITION BY chain_code ORDER BY chain_code, cust_nbr ASC) as rownbr "
                + "         from   cust_stage_admin.glazier_customer "
                + "         where  (parent_code is NULL OR parent_code <> 1)) "
                + "       where  rownbr = 1) gc "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = slopa.gfs_customer_id "
                + "and    xref.original_entity_id = gc.chain_code "
                + "and    gc.valid_record_ind = 1 "
                + "and    slopa.legal_owner_principal_id = slop.legal_owner_principal_id "
                + "and    slop.contact_id = scc.contact_id "
                + "and    scc.contact_id = xref2.original_entity_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    (scc.contact_name <> gc.bill_to_addr_line_2 "
                + "or     scc.last_update_tmstmp IS NULL "
                + "or     (scc.last_update_user_id IS NULL or scc.last_update_user_id NOT LIKE 'Glazier%') "
                + "or     scc.site_id IS NOT NULL) "
                + "UNION "
                + "select slopa.gfs_customer_id "
                + "from   cust_stage_admin.legal_owner_principal_asgn slopa, "
                + "       cust_stage_admin.legal_owner_principal slop, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact scc, "
                + "       cust_stage_admin.glazier_customer gc "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = slopa.gfs_customer_id "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code = 1 "
                + "and    slopa.legal_owner_principal_id = slop.legal_owner_principal_id "
                + "and    slop.contact_id = scc.contact_id "
                + "and    scc.contact_id = xref2.original_entity_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    (scc.contact_name <> gc.bill_to_addr_line_2 "
                + "or     scc.last_update_tmstmp IS NULL "
                + "or     (scc.last_update_user_id IS NULL or scc.last_update_user_id NOT LIKE 'Glazier%') "
                + "or     scc.site_id IS NOT NULL))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedCustomerContactWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetCustomerContactWithInvalidFields() 
         */
	public int countTargetCustomerContactWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) "
                + "from   cust_admin.legal_owner_principal_asgn tlopa, "
                + "       cust_admin.legal_owner_principal tlop, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_admin.customer_contact tcc, "
                + "       cust_stage_admin.customer_contact scc "
                + "where  xref.gfs_entity_type_code = 10 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tlopa.gfs_customer_id "
                + "and    tlopa.legal_owner_principal_id = tlop.legal_owner_principal_id "
                + "and    tlop.contact_id = tcc.contact_id "
                + "and    tcc.contact_id = xref2.gfs_entity_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = scc.contact_id "
                + "and    (tcc.contact_name <> scc.contact_name "
                + "or     tcc.last_update_tmstmp IS NULL "
                + "or     (tcc.last_update_user_id IS NULL or tcc.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetCustomerContactWithInvalidFields
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnersInGFSCustLegalOwner() 
         */
	public int countStagedLegalOwnersInGFSCustLegalOwner() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_legal_owner sclo, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_customer sgc " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   sgc.gfs_customer_id = sclo.gfs_customer_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnersInGFSCustLegalOwner

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnersInGFSCustLegalOwner() 
         */
	public int countTargetLegalOwnersInGFSCustLegalOwner() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_legal_owner tclo, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_admin.gfs_customer tgc " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   tgc.gfs_customer_id = tclo.gfs_customer_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnersInGFSCustLegalOwner
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerBank() 
         */
	public int countStagedLegalOwnerBank() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from   cust_stage_admin.legal_owner_bank lob, " +
                        "       cust_stage_admin.gfs_entity_xref xref " +
                        "where  xref.gfs_entity_type_code = 10 " +
                        "and    xref.business_unit_code in (36,37) " +
                        "and    xref.original_entity_id = lob.gfs_customer_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerBank

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerBank() 
         */
	public int countTargetLegalOwnerBank() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from   cust_admin.legal_owner_bank lob, " +
                        "       cust_stage_admin.gfs_entity_xref xref " +
                        "where  xref.gfs_entity_type_code = 10 " +
                        "and    xref.business_unit_code in (36,37) " +
                        "and    xref.gfs_entity_id = lob.gfs_customer_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerBank

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerPrincipal() 
         */
	public int countStagedLegalOwnerPrincipal() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.gfs_entity_xref xref, " +
                    "      cust_stage_admin.gfs_entity_xref xref2, " +
                    "      cust_stage_admin.legal_owner_principal_asgn lopa, " +
                    "      cust_stage_admin.legal_owner_principal lp " +
                    "where xref.gfs_entity_type_code = 10 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = lopa.gfs_customer_id " +
                    "and   lopa.legal_owner_principal_id = lp.legal_owner_principal_id " +
                    "and   xref2.gfs_entity_type_code = 96 " +
                    "and   xref2.business_unit_code in (36,37) " +
                    "and   xref2.original_entity_id = lp.legal_owner_principal_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerPrincipal

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerPrincipal() 
         */
	public int countTargetLegalOwnerPrincipal() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_admin.legal_owner_principal_asgn tlopa, " +
                    "      cust_admin.legal_owner_principal lop, " +
                    "      cust_stage_admin.gfs_entity_xref xref, " +
                    "      cust_stage_admin.gfs_entity_xref xref2 " +
                    "where xref.gfs_entity_type_code = 10 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.gfs_entity_id = tlopa.gfs_customer_id " +
                    "and   tlopa.legal_owner_principal_id = lop.legal_owner_principal_id " +
                    "and   xref2.gfs_entity_type_code = 96 " +
                    "and   xref2.business_unit_code in (36,37) " +
                    "and   xref2.gfs_entity_id = lop.legal_owner_principal_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerPrincipal
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerPrincipalAsgn() 
         */
	public int countStagedLegalOwnerPrincipalAsgn() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_stage_admin.legal_owner_principal_asgn lopa, " +
                "      cust_stage_admin.legal_owner_principal lp " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = lopa.gfs_customer_id " +
                "and   lopa.legal_owner_principal_id = lp.legal_owner_principal_id " +
                "and   xref2.gfs_entity_type_code = 96 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.original_entity_id = lp.legal_owner_principal_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerPrincipalAsgn

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerPrincipalAsgn() 
         */
	public int countTargetLegalOwnerPrincipalAsgn() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.legal_owner_principal_asgn tlopa, " +
                "      cust_admin.legal_owner_principal lop, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tlopa.gfs_customer_id " +
                "and   tlopa.legal_owner_principal_id = lop.legal_owner_principal_id " +
                "and   xref2.gfs_entity_type_code = 96 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = lop.legal_owner_principal_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerPrincipalAsgn
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerSic() 
         */
	public int countStagedLegalOwnerSic() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from   cust_stage_admin.legal_owner_sic los, " +
                        "       cust_stage_admin.gfs_entity_xref xref " +
                        "where  xref.gfs_entity_type_code = 10 " +
                        "and    xref.business_unit_code in (36,37) " +
                        "and    xref.original_entity_id = los.gfs_customer_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerSic

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerSic() 
         */
	public int countTargetLegalOwnerSic() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from   cust_admin.legal_owner_sic los, " +
                        "       cust_stage_admin.gfs_entity_xref xref " +
                        "where  xref.gfs_entity_type_code = 10 " +
                        "and    xref.business_unit_code in (36,37) " +
                        "and    xref.gfs_entity_id = los.gfs_customer_id";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerSic
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countXrefWithNoLegalOwnerInGlazierCust() 
       
         */
	public int countXrefWithNoLegalOwnerInGlazierCust(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from (" +
                    "select cust_nbr " +
                    "from   cust_stage_admin.gfs_entity_xref xref " +
                    "              full outer join cust_stage_admin.glazier_customer gc " +
                    "              on xref.original_entity_id = gc.cust_nbr " +
                    "where  gc.valid_record_ind = 1 " +
                    "and    gc.parent_code = 1 " +
                    "and    xref.gfs_entity_type_code = 10 " +
                    "and    xref.business_unit_code in (36,37) " +
                    "and    gc.cust_nbr IS NULL " +
                    "UNION " +
                    "select distinct gc.chain_code as cust_nbr " +
                    "from   cust_stage_admin.gfs_entity_xref xref " +
                    "              full outer join cust_stage_admin.glazier_customer gc " +
                    "              on xref.original_entity_id = gc.chain_code " +
                    "where  gc.valid_record_ind = 1 " +
                    "and          (gc.parent_code is NULL or gc.parent_code <> 1) " +
                    "and    xref.gfs_entity_type_code = 10 " +
                    "and    xref.business_unit_code in (36,37) " +
                    "and    gc.chain_code is NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}//end countXrefWithNoLegalOwnerInGlazierCust

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countLegalOwnerXrefEntriesWithoutId()
         */
	public int countLegalOwnerXrefEntriesWithoutId(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select   count(*) " +
                "from  cust_stage_admin.GFS_ENTITY_XREF xref " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   (xref.original_entity_id is null or xref.gfs_entity_id is null) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
                
	}//end countLegalOwnerXrefEntriesWithoutId
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierIntoToLegalOwnerDao#findXrefWithNoLegalOwnerInGFSCustomer()
         */
	public int countXrefWithNoLegalOwnerInGFSCustomer(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from cust_stage_admin.gfs_entity_xref xref " +
                "where xref.GFS_ENTITY_TYPE_CODE = 10 " +
                "      and xref.BUSINESS_UNIT_CODE in (36,37) " +
                "      and(xref.GFS_ENTITY_ID, xref.GFS_ENTITY_TYPE_CODE) not in ( " +
                "              select tgc.gfs_customer_id, tgc.gfs_customer_type_code " +
                "              from cust_admin.GFS_CUSTOMER tgc  " +
                "			  where tgc.last_update_user_id like 'Glazier%') ";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}//end countXrefWithNoLegalOwnerInGFSCustomer
 
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierIntoToLegalOwnerDao#findTargetGFSCustLegalOwnerWithInvalidCreditLimitDollarAmt()
         */
	public int countTargetGFSCustLegalOwnerWithInvalidCreditLimitDollarAmt(){
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from      cust_stage_admin.gfs_entity_xref xref, " +
                "          cust_admin.gfs_cust_legal_owner tclo " +
//                "--Summing the units Credit Limit by each LO ID " +
                "        join (select tcgm.group_id slo_id, SUM(tgcu.credit_limit_dollar_amt) sum_lo_credit_limit " +
                "              from cust_admin.gfs_cust_group_membership tcgm " +
                "                        left outer join  cust_admin.gfs_cust_unit tgcu " +
                "                              on tcgm.member_customer_id = tgcu.gfs_customer_id " +
                "                where tcgm.group_type_code = 10 and " +
                "                          tcgm.group_id IN ( " +
//                "--Getting Target Legal Owner ID's " +
                "                select tclo.gfs_customer_id " +
                "                from   cust_admin.gfs_cust_legal_owner tclo, " +
                "                       cust_stage_admin.gfs_entity_xref xref " +
                "                where  xref.gfs_entity_type_code = 10 " +
                "                and    xref.business_unit_code in (36,37) " +
                "                and    xref.gfs_entity_id = tclo.gfs_customer_id) " +
                "                group by tcgm.group_id) " +
                "              on tclo.gfs_customer_id = slo_id " +
                "where  xref.gfs_entity_type_code = 10 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.gfs_entity_id = tclo.gfs_customer_id " +
                "and    tclo.credit_limit_dollar_amt <> sum_lo_credit_limit";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);
	}//end countTargetGFSCustLegalOwnerWithInvalidCreditLimitDollarAmt

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countStagedLegalOwnerCustomerContact() 
         */
	public int countStagedLegalOwnerCustomerContact() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.legal_owner_principal_asgn slopa, " +
                    "      cust_stage_admin.legal_owner_principal slop, " +
                    "      cust_stage_admin.gfs_entity_xref xref, " +
                    "      cust_stage_admin.gfs_entity_xref xref2, " +
                    "      cust_stage_admin.customer_contact scc " +
                    "where xref.gfs_entity_type_code = 10 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = slopa.gfs_customer_id " +
                    "and   slopa.legal_owner_principal_id = slop.legal_owner_principal_id " +
                    "and   slop.contact_id = scc.contact_id " +
                    "and   scc.contact_id = xref2.original_entity_id " +
                    "and   xref2.gfs_entity_type_code = 98 " +
                    "and   xref2.business_unit_code in (36,37) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedLegalOwnerCustomerContact
        
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierInfoToLegalOwnerDao#countTargetLegalOwnerCustomerContact() 
         */
	public int countTargetLegalOwnerCustomerContact() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.legal_owner_principal_asgn tlopa, " +
                "      cust_admin.legal_owner_principal tlop, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2, " +
                "      cust_admin.customer_contact tcc " +
                "where xref.gfs_entity_type_code = 10 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tlopa.gfs_customer_id " +
                "and   tlopa.legal_owner_principal_id = tlop.legal_owner_principal_id " +
                "and   tlop.contact_id = tcc.contact_id " +
                "and   tcc.contact_id = xref2.gfs_entity_id " +
                "and   xref2.gfs_entity_type_code = 98 " +
                "and   xref2.business_unit_code in (36,37) ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetLegalOwnerCustomerContact        
        
}//end GlazierInfoToLegalOwnerImpl
