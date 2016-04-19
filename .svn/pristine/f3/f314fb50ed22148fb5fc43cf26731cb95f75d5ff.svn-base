package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.ParentCodeToPmgDao;

public class ParentCodeToPmgDaoImpl extends NamedParameterJdbcTemplate implements ParentCodeToPmgDao{
	public ParentCodeToPmgDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	public int countGlazierParentCodes(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                  +  "from  cust_stage_admin.glazier_parent_code "
                  +  "where parent_code NOT IN ('33','44','78')";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierParentCodes
	
	public int countParentCodesInGfsCustomer(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code in (15,18) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   sgc.gfs_customer_name NOT LIKE 'Exist%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countParentCodesInGfsCustomer
	
	public int countStagedGFSCustomerPMGWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.glazier_parent_code gpc " +
                "where xref.gfs_entity_type_code in (15,18) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.original_entity_id =  gpc.parent_code " +
                "and   xref.original_entity_id NOT IN ('33','44','78') " +
                "and   (sgc.gfs_customer_name <> gpc.pmg_name " +
                "or     sgc.site_id IS NOT NULL " +
                "or     sgc.last_update_tmstmp IS NULL " +
                "or    (sgc.last_update_user_id IS NULL or sgc.last_update_user_id NOT LIKE 'Glazier%'))"; 

        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedGFSCustomerPMGWithInvalidFields
	
	public int countParentCodesInGFSCustGroup(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code in (15,18) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   scg.customer_group_name NOT LIKE 'Existing%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countParentCodesInGFSCustGroup
	
	public int countStagedGFSCustGroupPMGWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " +
            "from  cust_stage_admin.gfs_cust_group scg, " +
            "      cust_stage_admin.gfs_entity_xref xref, " +
            "      cust_stage_admin.glazier_parent_code gpc " +
            "where xref.gfs_entity_type_code in (15,18) " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.original_entity_id = scg.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
            "and   xref.original_entity_id =  gpc.parent_code " +
            "and   xref.original_entity_id NOT IN ('33','44','78') " +
            "and   (scg.customer_group_name <> gpc.pmg_name " +
            "or     scg.customer_group_desc <> gpc.pmg_desc " +
            "or    (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) " +
            "or     scg.cust_grp_status_date IS NULL " +
            "or     scg.company_nbr <> 1 " +
            "or    (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) " +
            "or    (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) " +
            "or     scg.site_id IS NOT NULL " +
            "or     scg.last_update_tmstmp IS NULL " +
            "or    (scg.last_update_user_id IS NULL or scg.last_update_user_id NOT LIKE 'Glazier%') " +
            "or     scg.buyer_nbr IS NOT NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedGFSCustGroupPMGWithInvalidFields
	
	public int countGlazierSuperPMG(){
		final SqlParameterSource paramMap = null;
                
        String sql = "select count(distinct gfs_super_pmg_name) " +
                    "from  cust_stage_admin.glazier_parent_code gpc " +
                    "where gfs_super_pmg_name <> 'N/A'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierSuperPMG
	
	public int countStagedGFSCustomerSuperPMG(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct gfs_customer_name) " +
                    "from  cust_stage_admin.gfs_customer sgc, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code IN (19) " +
                    "and   xref.business_unit_code IN (36,37) " +
                    "and   xref.original_entity_id = sgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedGFSCustomerSuperPMG
	
	public int countStagedGFSCustomerSuperPMGWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct gfs_customer_name) " +
                "from  cust_stage_admin.gfs_customer sgc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.glazier_parent_code gpc " +
                "where xref.gfs_entity_type_code in (19) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                "and   xref.original_entity_id =  gpc.parent_code " +
                "and   (sgc.gfs_customer_name <> gpc.gfs_super_pmg_name " +
                "or     sgc.site_id IS NOT NULL " +
                "or     sgc.last_update_tmstmp IS NULL " +
                "or    (sgc.last_update_user_id IS NULL or sgc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldInStgGfsCustGrpFrmGlazierSuperPmg

	public int countStagedGFSCustGroupSuperPMG(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct scg.customer_group_name) " +
                "from  cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code in (19) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   scg.customer_group_name NOT LIKE 'Existing%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end sprPmgInGfsCustGrp1
	
	public int sprPmgInGfsCustGrp2(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code in (19) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end sprPmgInGfsCustGrp2
	
	public int countStagedGFSCustGroupSuperPMGWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct scg.customer_group_name) " +
                "from  cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.glazier_parent_code gpc " +
                "where xref.gfs_entity_type_code in (19) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   xref.original_entity_id =  gpc.parent_code " +
                "and   scg.customer_group_name NOT LIKE 'Existing%' " +
                "and   (scg.customer_group_name <> gpc.gfs_super_pmg_name " +
                "or     scg.customer_group_desc <> gpc.gfs_super_pmg_desc " +
                "or    (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) " +
                "or     scg.cust_grp_status_date IS NULL " +
                "or     scg.company_nbr <> 1 " +
                "or    (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) " +
                "or    (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) " +
//                "--or   scg.cust_reln_mgr_id = TBD " +
                "or     scg.site_id IS NOT NULL " +
                "or     scg.last_update_tmstmp IS NULL " +
                "or    (scg.last_update_user_id IS NULL or scg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or     scg.buyer_nbr IS NOT NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedGFSCustGroupSuperPMGWithInvalidFields
	
	public int countGlazierNewPMG(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_parent_code " +
                "where (gfs_super_pmg_name <> 'N/A' or existing_super_pmg_id <> 'N/A')";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end allNwPmgInGlzPmg
	
	public int countStagedGFSCustGrpMemberNewPMG(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code IN " +
                "      ((select distinct gpc.gfs_super_pmg_type_code " +
                "       from CUST_STAGE_ADMIN.glazier_parent_code gpc " +
                "       where gpc.gfs_super_pmg_desc IS NOT NULL and gpc.gfs_super_pmg_type_code IS NOT NULL), " +
                "      (select distinct gpc.existing_super_pmg_type_code " +
                "       from CUST_STAGE_ADMIN.glazier_parent_code gpc " +
                "       where gpc.existing_super_pmg_id IS NOT NULL and  gpc.gfs_super_pmg_name IS NULL) ) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scgm.group_id " +
                "and   xref.gfs_entity_type_code = scgm.group_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countStagedGFSCustGrpMemberNewPMG
		
	public int invldNewPmgStgGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
            "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
            "      cust_stage_admin.gfs_entity_xref xref " +
            "where xref.gfs_entity_type_code = 19 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.original_entity_id = scgm.group_id " +
            "and   xref.gfs_entity_type_code = scgm.group_type_code " +
            "and   (scgm.member_customer_id IS NULL " +
            "or     scgm.member_customer_type_code IS NULL " +
            "or     scgm.effective_date IS NULL " +
            "or     scgm.expiration_date IS NULL " +
            "or    (scgm.pricing_precedence_ind IS NULL or scgm.pricing_precedence_ind <> 0) " +
            "or     scgm.group_cust_store_nbr IS NOT NULL " +
            "or     scgm.last_update_tmstmp IS NULL " +
            "or    (scgm.last_update_user_id IS NULL or scgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldNewPmgStgGfsCustGrpMemship
	
	public int exstngPmgGlzPmg(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_parent_code " +
                    "where existing_pmg_to_attach_id <> 'N/A'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end exstngPmgGlzPmg
	
	public int exstngPmgStgGfsCustGrpMemshp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
                "      cust_stage_admin.glazier_parent_code gpc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scgm.group_id " +
                "and   xref.gfs_entity_type_code = scgm.group_type_code " +
                "and   scgm.group_id = gpc.parent_code " +
                "and   scgm.group_type_code = gpc.gfs_super_pmg_type_code " +
                "and   gpc.existing_pmg_to_attach_id <> 'N/A' " +
                "and   xref2.gfs_entity_type_code = 15 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.original_entity_id = scgm.member_customer_id " +
                "and   xref2.gfs_entity_type_code = scgm.member_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end exstngPmgStgGfsCustGrpMemshp
	
	public int invldExtngPmgStgGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
                "      cust_stage_admin.glazier_parent_code gpc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scgm.group_id " +
                "and   xref.gfs_entity_type_code = scgm.group_type_code " +
                "and   scgm.group_id = gpc.parent_code " +
                "and   scgm.group_type_code = gpc.gfs_super_pmg_type_code " +
                "and   gpc.existing_pmg_to_attach_id <> 'N/A' " +
                "and   xref2.gfs_entity_type_code = 15 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.original_entity_id = scgm.group_id " +
                "and   xref2.gfs_entity_type_code = scgm.member_customer_type_code " +
                "and   (scgm.member_customer_id IS NULL " +
                "or     scgm.member_customer_type_code IS NULL " +
                "or     scgm.effective_date IS NULL " +
                "or     scgm.expiration_date IS NULL " +
                "or    (scgm.pricing_precedence_ind IS NULL or scgm.pricing_precedence_ind <> 0) " +
                "or     scgm.group_cust_store_nbr IS NOT NULL " +
                "or     scgm.last_update_tmstmp IS NULL " +
                "or    (scgm.last_update_user_id IS NULL or scgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end exstngPmgStgGfsCustGrpMemshp
	
	public int stgPmgRecordsGfsCust(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
        		+ " from   cust_stage_admin.gfs_customer sgc, "
        		+ " cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code in (15,18) "
        		+ " and    xref.business_unit_code in (36,37) "
        		+ " and    xref.original_entity_id = sgc.gfs_customer_id "
        		+ " and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgPmgRecordsGfsCust
    
	public int trgtPmgRecordsGfsCust(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*)  "
        		+ " from   cust_admin.gfs_customer sgc, "
        		+ " cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code in (15,18) "
        		+ " and    xref.business_unit_code in (36,37) "
        		+ " and    xref.gfs_entity_id = sgc.gfs_customer_id"
        		+ " and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtPmgRecordsGfsCust
	
	public int invldPmgTrgtGfsCustCustomer(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                    "from  cust_admin.gfs_customer tgc, " +
                    "      cust_stage_admin.gfs_customer sgc, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code in (15,18) " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = sgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                    "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code  = tgc.gfs_customer_type_code " +
                    "and   sgc.gfs_customer_name NOT LIKE 'Existing%' " +
                    "and   (sgc.gfs_customer_name <> tgc.gfs_customer_name " +
                    "or     tgc.site_id IS NOT NULL " +
                    "or     tgc.last_update_tmstmp IS NULL " +
                    "or    (tgc.last_update_user_id IS NULL or tgc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldPmgTrgtGfsCustCustomer
	
	public int stgSprPmgRecordsGfsCust(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct gfs_customer_name) "
        		+ " from   cust_stage_admin.gfs_customer sgc, "
        		+ "        cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code IN (19) "
        		+ " and    xref.business_unit_code IN (36,37)        "
        		+ " and    xref.original_entity_id = sgc.gfs_customer_id "
        		+ " and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgSprPmgRecordsGfsCust
    
	public int trgtSprPmgRecordsGfsCust(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct gfs_customer_name)"
        		+ " from   cust_admin.gfs_customer tgc, "
        		+ " cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code IN (19) "
        		+ " and    xref.business_unit_code IN (36,37) "
        		+ " and    xref.gfs_entity_id = tgc.gfs_customer_id "
        		+ " and    xref.gfs_entity_type_code = tgc.gfs_customer_type_code"
                        + " and    tgc.last_update_user_id LIKE 'Glazier%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtSprPmgRecordsGfsCust
	
	public int invldSprPmgTrgtGfsCustCustomer(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct gfs_customer_name) "
        		+ " from   cust_admin.gfs_customer tgc, "
        		+ " cust_stage_admin.gfs_entity_xref xref, "
        		+ " cust_stage_admin.glazier_parent_code gpc "
        		+ " where  xref.gfs_entity_type_code in (19) "
        		+ " and    xref.business_unit_code in (36,37) "
        		+ " and    xref.gfs_entity_id = tgc.gfs_customer_id "
        		+ " and    xref.gfs_entity_type_code = tgc.gfs_customer_type_code  "
        		+ " and    xref.original_entity_id =  gpc.parent_code "
                        + " and    tgc.last_update_user_id LIKE 'Glazier%' "
        		+ " and    (tgc.gfs_customer_name <> gpc.gfs_super_pmg_name "
        		+ " or      tgc.site_id IS NOT NULL "
        		+ " or      tgc.last_update_tmstmp IS NULL "
        		+ " or     (tgc.last_update_user_id IS NULL or tgc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldSprPmgTrgtGfsCustCustomer
	
	public int stgPmgRecordsGfsCustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) from   cust_stage_admin.gfs_cust_group scg, "
        		+ " cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code in (15,18) "
        		+ " and    xref.business_unit_code in (36,37) "
        		+ " and    xref.original_entity_id = scg.gfs_customer_id"
        		+ " and    xref.gfs_entity_type_code = scg.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgSprPmgRecordsGfsCustGrp
	
	public int trgtPmgRecordsGfsCustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
        		+ " from   cust_admin.gfs_cust_group tcg, "
                        + "        cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code in (15,18) "
        		+ " and    xref.business_unit_code in (36,37) "
        		+ " and    xref.gfs_entity_id = tcg.gfs_customer_id "
        		+ " and    xref.gfs_entity_type_code = tcg.gfs_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtSprPmgRecordsGfsCustGrp
	
	public int invldPmgTrgtGfsCustomerGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
            "from  cust_admin.gfs_cust_group tcg, " +
            "      cust_stage_admin.gfs_cust_group scg, " +
            "      cust_stage_admin.gfs_entity_xref xref " +
            "where xref.gfs_entity_type_code in (15,18) " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code " +
            "and   xref.original_entity_id =  scg.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
            "and   scg.customer_group_name NOT LIKE 'Existing%' " +
            "and   (tcg.customer_group_name <> scg.customer_group_name " +
            "or     tcg.customer_group_desc <> scg.customer_group_desc " +
            "or    (tcg.cust_grp_status_code IS NULL or tcg.cust_grp_status_code <> 1) " +
            "or     tcg.cust_grp_status_date IS NULL " +
            "or     tcg.company_nbr <> 1 " +
            "or    (tcg.pricing_audit_privlg_ind IS NULL or tcg.pricing_audit_privlg_ind <> 0) " +
            "or    (tcg.order_lock_out_code IS NULL or tcg.order_lock_out_code <> 2) " +
            "or     tcg.cust_reln_mgr_id <> scg.cust_reln_mgr_id " +
            "or     tcg.site_id IS NOT NULL " +
            "or     tcg.last_update_tmstmp IS NULL " +
            "or    (tcg.last_update_user_id IS NULL or tcg.last_update_user_id NOT LIKE 'Glazier%') " +
            "or     tcg.buyer_nbr IS NOT NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldSprPmgTrgtGfsCustCustomerGrp
	

	public int stgSprPmgRecordsGfsCustGrp1(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct scg.customer_group_name)  "
        		+ " from   cust_stage_admin.gfs_cust_group scg, "
        		+ " cust_stage_admin.gfs_entity_xref xref "
        		+ " where  xref.gfs_entity_type_code in (19) "
        		+ " and    xref.business_unit_code in (36,37) "
        		+ " and    xref.original_entity_id = scg.gfs_customer_id "
        		+ " and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
        		+ " and    scg.customer_group_name NOT LIKE 'Existing%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgSprPmgRecordsGfsCustGrp1
	
//	public int stgSprPmgRecordsGfsCustGrp2(){
//		final SqlParameterSource paramMap = null;
//        String sql = "select count(*) from CUST_STAGE_ADMIN.GFS_CUST_GROUP gc"+
//        				" where (gc.gfs_customer_type_code=19) and gc.last_update_user_id like 'Glazier%'";
        
//        String result = this.queryForObject(sql,paramMap,String.class);	
//        return Integer.parseInt(result);
//	}//end stgSprPmgRecordsGfsCustGrp2
	
	public int trgtSprPmgRecordsGfsCustGrp1(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct tcg.customer_group_name) " +
                    "from   cust_admin.gfs_cust_group tcg, " +
                    "       cust_stage_admin.gfs_entity_xref xref " +
                    "where  xref.gfs_entity_type_code in (19) " +
                    "and    xref.business_unit_code in (36,37) " +
                    "and    xref.gfs_entity_id = tcg.gfs_customer_id " +
                    "and    xref.gfs_entity_type_code = tcg.gfs_customer_type_code " +
                    "and    tcg.last_update_user_id LIKE '%Glazier%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtSprPmgRecordsGfsCustGrp1
	
//	public int trgtSprPmgRecordsGfsCustGrp2(){
//		final SqlParameterSource paramMap = null;
//        String sql = "select count(*) from CUST_ADMIN.GFS_CUST_GROUP gc"
//        			+" where (gc.gfs_customer_type_code=19) and gc.last_update_user_id like 'Glazier%'";
        
//        String result = this.queryForObject(sql,paramMap,String.class);	
//        return Integer.parseInt(result);
//	}//end trgtSprPmgRecordsGfsCustGrp2
	
	public int invldSuprPmgTrgtGfsCustomerGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(distinct tcg.customer_group_name) " +
                "from  cust_admin.gfs_cust_group tcg, " +
                "      cust_stage_admin.gfs_cust_group scg, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code in (19) " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tcg.gfs_customer_type_code " +
                "and   xref.original_entity_id = scg.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = scg.gfs_customer_type_code " +
                "and   tcg.last_update_user_id LIKE 'Glazier%' " +
                "and   (tcg.customer_group_name <> scg.customer_group_name " +
                "or     tcg.customer_group_desc <> scg.customer_group_desc " +
                "or    (tcg.cust_grp_status_code IS NULL or tcg.cust_grp_status_code <> 1) " +
                "or     tcg.cust_grp_status_date IS NULL " +
                "or     tcg.company_nbr <> 1 " +
                "or    (tcg.pricing_audit_privlg_ind IS NULL or tcg.pricing_audit_privlg_ind <> 0) " +
                "or    (tcg.order_lock_out_code IS NULL or tcg.order_lock_out_code <> 2) " +
                "or     tcg.cust_reln_mgr_id <> scg.cust_reln_mgr_id " +
                "or     tcg.site_id IS NOT NULL " +
                "or     tcg.last_update_tmstmp IS NULL " +
                "or    (tcg.last_update_user_id IS NULL or tcg.last_update_user_id NOT LIKE 'Glazier%') " +
                "or     tcg.buyer_nbr IS NOT NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldSuprPmgTrgtGfsCustomerGrp
	

	public int stgNwPmgRecordsGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from   cust_stage_admin.gfs_cust_group_membership scgm, " +
                "       cust_stage_admin.gfs_entity_xref xref " +
                "where  xref.gfs_entity_type_code = 19 " +
                "and    xref.business_unit_code in (36,37) " +
                "and    xref.original_entity_id = scgm.group_id " +
                "and    xref.gfs_entity_type_code = scgm.group_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgNwPmgRecordsGfsCustGrpMemship
	
	public int trgtNwPmgRecordsGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group_membership tcgm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcgm.group_id " +
                "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
                "and   tcgm.last_update_user_id LIKE 'Glazier%' ";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtNwPmgRecordsGfsCustGrpMemship
	
	public int invldNwPmgTrgtGfsCustomerGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group_membership tcgm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcgm.group_id " +
                "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
                "and   (tcgm.member_customer_id IS NULL " +
                "or     tcgm.member_customer_type_code IS NULL " +
                "or     tcgm.effective_date IS NULL " +
                "or     tcgm.expiration_date IS NULL " +
                "or    (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) " +
                "or     tcgm.group_cust_store_nbr IS NOT NULL " +
                "or     tcgm.last_update_tmstmp IS NULL)";
//                "or    (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldNwPmgTrgtGfsCustomerGrpMemship
	

	public int stgExtnPmgRecordsGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_stage_admin.gfs_cust_group_membership scgm, " +
                "      cust_stage_admin.glazier_parent_code gpc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = scgm.group_id " +
                "and   xref.gfs_entity_type_code = scgm.group_type_code " +
                "and   scgm.group_id = gpc.parent_code " +
                "and   scgm.group_type_code = gpc.gfs_super_pmg_type_code " +
                "and   gpc.existing_pmg_to_attach_id <> 'N/A' " +
                "and   xref2.gfs_entity_type_code = 15 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.original_entity_id = scgm.member_customer_id " +
                "and   xref2.gfs_entity_type_code = scgm.member_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgExtnPmgRecordsGfsCustGrpMemship
	
	public int trgtExtnPmgRecordsGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group_membership tcgm, " +
                "      cust_stage_admin.glazier_parent_code gpc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcgm.group_id " +
                "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
                "and   xref.original_entity_id = gpc.parent_code " +
                "and   tcgm.group_type_code = gpc.gfs_super_pmg_type_code " +
                "and   gpc.existing_pmg_to_attach_id <> 'N/A' " +
                "and   xref2.gfs_entity_type_code = 15 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tcgm.member_customer_id " +
                "and   xref2.gfs_entity_type_code = tcgm.member_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtExtnPmgRecordsGfsCustGrpMemship
	
	public int invldExtnPmgTrgtGfsCustomerGrpMemship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_group_membership tcgm, " +
                "      cust_stage_admin.glazier_parent_code gpc, " +
                "      cust_stage_admin.gfs_entity_xref xref, " +
                "      cust_stage_admin.gfs_entity_xref xref2 " +
                "where xref.gfs_entity_type_code = 19 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tcgm.group_id " +
                "and   xref.gfs_entity_type_code = tcgm.group_type_code " +
                "and   xref.original_entity_id = gpc.parent_code " +
                "and   tcgm.group_type_code = gpc.gfs_super_pmg_type_code " +
                "and   gpc.existing_pmg_to_attach_id <> 'N/A' " +
                "and   xref2.gfs_entity_type_code = 15 " +
                "and   xref2.business_unit_code in (36,37) " +
                "and   xref2.gfs_entity_id = tcgm.member_customer_id " +
                "and   xref2.gfs_entity_type_code = tcgm.member_customer_type_code " +
                "and   (tcgm.member_customer_id IS NULL " +
                "or     tcgm.member_customer_type_code IS NULL " +
                "or     tcgm.effective_date IS NULL " +
                "or     tcgm.expiration_date IS NULL " +
                "or    (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) " +
                "or     tcgm.group_cust_store_nbr IS NOT NULL " +
                "or     tcgm.last_update_tmstmp IS NULL) ";
//                "or    (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldExtnPmgTrgtGfsCustomerGrpMemship
	
}//end ParentCodeToPmgDaoImpl
