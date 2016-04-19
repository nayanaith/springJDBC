package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.AvendraMembrshpToPmgMembrshpDao;



//public class  extends   implements AvendraMembrshpToPmgMembrshpDao{
//	
//	public AvendraMembrshpToPmgMembrshpDaoImpl (final DataSource dataSource) {
//		super(dataSource);
//	}//end AvendraMembrshpToPmgMembrshpDaoImpl
	
public class AvendraMembrshpToPmgMembrshpDaoImpl extends NamedParameterJdbcTemplate implements AvendraMembrshpToPmgMembrshpDao{
	
	public AvendraMembrshpToPmgMembrshpDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}

	public int countGlazierAvendraCustomers(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_avendra_customers gac, "
                + "       cust_stage_admin.avendra_bracket_mapping abm, "
                + "       cust_stage_admin.glazier_customer gc "
                + "where  substr(gac.bracket_name,1,1) = abm.avendra_bracket_id "
                + "and    trim(substr(gac.bracket_name,5,15)) = abm.avendra_customer_type "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end countGlazierAvendraCustomers
        
	public int exstingPmgRecordsInGlzAvndra(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(am.pmg_id) "
                    + "from   cust_stage_admin.avendra_bracket_mapping am "
                    + "where  am.avendra_bracket_id IN "
                    + "        (select substr(ga.Bracket_Name,1,1) "
                    + "        from    cust_stage_admin.glazier_avendra_customers ga "
                    + "        where   ga.cust_nbr IN "
                    + "                (select gc.cust_nbr "
                    + "                from    cust_stage_admin.glazier_customer gc "
                    + "                where   gc.parent_code=1))";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end ExstingPmgRecordsInGlzAvndra
	
	
	public int exstingPmgRecordsInGlzAvndraInStgGfs_Cust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_customer sgc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                + "and    sgc.gfs_customer_id = abm.pmg_id "
                + "and    sgc.gfs_customer_name like 'Existing%'";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end ExstingPmgRecordsInGlzAvndraInStgGfs_Cust
	
	public int invldRecordsInGlzAvndraInStgGfs_Cust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_customer sgc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                + "and    sgc.gfs_customer_id = abm.pmg_id "
                + "and    sgc.gfs_customer_name like 'Existing%' "
                + "and    (sgc.gfs_customer_name NOT LIKE 'Existing%' "
                + "or      sgc.site_id IS NOT NULL "
                + "or      sgc.last_update_tmstmp IS NULL "
                + "or     (sgc.last_update_user_id IS NULL or sgc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end InvldRecordsInGlzAvndraInStgGfs_Cust

	public int exstingPmgRecordsInGlzAvndraInStgGfs_CustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_group scg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
                + "and    scg.gfs_customer_id = abm.pmg_id "
                + "and    scg.customer_group_name like 'Existing%'";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end exstingPmgRecordsInGlzAvndraInStgGfs_CustGrp
	
	public int invldRecordsInGlzAvndraInStgGfs_CustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_group scg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
                + "and    scg.gfs_customer_id = abm.pmg_id "
                + "and    scg.customer_group_name like 'Existing%' "
                + "and    (scg.customer_group_name NOT LIKE 'Existing%' "
                + "or      scg.customer_group_desc IS NOT NULL "
                + "or     (scg.cust_grp_status_code IS NULL or scg.cust_grp_status_code <> 1) "
                + "or      scg.cust_grp_status_date IS NULL "
                + "or     (scg.company_nbr IS NULL or scg.company_nbr <> 1) "
                + "or      scg.added_date IS NULL "
                + "or     (scg.pricing_audit_privlg_ind IS NULL or scg.pricing_audit_privlg_ind <> 0) "
                + "or     (scg.order_lock_out_code IS NULL or scg.order_lock_out_code <> 2) "
                + "or      scg.cust_reln_mgr_id IS NOT NULL "
                + "or      scg.last_update_tmstmp IS NULL "
                + "or     (scg.last_update_user_id IS NULL or scg.last_update_user_id NOT LIKE 'Glazier%') "
                + "or      scg.buyer_nbr IS NOT NULL)";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end invldRecordsInGlzAvndraInStgGfs_CustGrp
	
	public int exstingPmgRecordsInGfsCustGrpMembershp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_avendra_customers gac, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.avendra_bracket_mapping abm, "
                + "       cust_stage_admin.gfs_entity_xref xref, " 
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.gfs_cust_group_membership scgm "
                + "where  substr(gac.bracket_name,1,1) = abm.avendra_bracket_id "
                + "and    trim(substr(gac.bracket_name,5,15)) = abm.avendra_customer_type "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = abm.pmg_id "
                + "and    xref.gfs_entity_type_code = abm.pmg_type_code "
                + "and    xref.original_entity_id = scgm.group_id "
                + "and    xref.gfs_entity_type_code = scgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 0 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = gac.cust_nbr "
                + "and    xref2.original_entity_id = scgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = scgm.member_customer_type_code";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end exstingPmgRecordsInGfsCustGrpMembershp
	
	
	public int invldRecordsInGlzAvndraInStgGfsCustGrpMembrship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_avendra_customers gac, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.avendra_bracket_mapping abm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.gfs_cust_group_membership scgm "
                + "where  substr(gac.bracket_name,1,1) = abm.avendra_bracket_id "
                + "and    trim(substr(gac.bracket_name,5,15)) = abm.avendra_customer_type "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = abm.pmg_id "
                + "and    xref.gfs_entity_type_code = abm.pmg_type_code "
                + "and    xref.original_entity_id = scgm.group_id "
                + "and    xref.gfs_entity_type_code = scgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 0 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = gac.cust_nbr "
                + "and    xref2.original_entity_id = scgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = scgm.member_customer_type_code "
                + "and    (scgm.effective_date <> to_date('12/1/2014','MM/DD/YYYY') "
                + "or      scgm.expiration_date <> to_date('1/1/9999','MM/DD/YYYY') "
                + "or     (scgm.pricing_precedence_ind IS NULL or scgm.pricing_precedence_ind <> 0) "
                + "or      scgm.group_cust_store_nbr IS NOT NULL "
                + "or      scgm.last_update_tmstmp IS NULL "
                + "or     (scgm.last_update_user_id IS NULL or scgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end invldRecordsInGlzAvndraInStgGfsCustGrpMembrship
	
	public int glzAvndraRecrdsInStgGfsCustGrpMembrshp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_avendra_customers gac, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.avendra_bracket_mapping abm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.gfs_cust_group_membership scgm "
                + "where  substr(gac.bracket_name,1,1) = abm.avendra_bracket_id "
                + "and    trim(substr(gac.bracket_name,5,15)) = abm.avendra_customer_type "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = abm.pmg_id "
                + "and    xref.gfs_entity_type_code = abm.pmg_type_code "
                + "and    xref.original_entity_id = scgm.group_id "
                + "and    xref.gfs_entity_type_code = scgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 0 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = gac.cust_nbr "
                + "and    xref2.original_entity_id = scgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = scgm.member_customer_type_code "
                + "and    scgm.effective_date <= sysdate "
                + "and    scgm.expiration_date >= sysdate";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end glzAvndraRecrdsInStgGfsCustGrpMembrshp
	
	public int glzAvndraRecrdsInTrgtGfsCustGrpMembrshp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_avendra_customers gac, "
                + "       cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.avendra_bracket_mapping abm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_admin.gfs_cust_group_membership tcgm "
                + "where  substr(gac.bracket_name,1,1) = abm.avendra_bracket_id "
                + "and    trim(substr(gac.bracket_name,5,15)) = abm.avendra_customer_type "
                + "and    gc.cust_nbr = gac.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = abm.pmg_id "
                + "and    xref.gfs_entity_type_code = abm.pmg_type_code "
                + "and    xref.gfs_entity_id = tcgm.group_id "
                + "and    xref.gfs_entity_type_code = tcgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 0 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = gac.cust_nbr "
                + "and    xref2.gfs_entity_id = tcgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = tcgm.member_customer_type_code "
                + "and    tcgm.effective_date <= sysdate "
                + "and    tcgm.expiration_date >= sysdate";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end glzAvndraRecrdsInTrgtGfsCustGrpMembrshp
	
	public int invldRecordsInGlzAvndraInTrgtGfsCustGrpMembrship(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) " 
                    + "from   cust_stage_admin.glazier_avendra_customers gac, "
                    + "       cust_stage_admin.glazier_customer gc, "
                    + "       cust_stage_admin.avendra_bracket_mapping abm, "
                    + "       cust_stage_admin.gfs_entity_xref xref, "
                    + "       cust_stage_admin.gfs_entity_xref xref2, "
                    + "       cust_admin.gfs_cust_group_membership tcgm "
                    + "where  substr(gac.bracket_name,1,1) = abm.avendra_bracket_id "
                    + "and    trim(substr(gac.bracket_name,5,15)) = abm.avendra_customer_type "
                    + "and    gc.cust_nbr = gac.cust_nbr "
                    + "and    gc.valid_record_ind = 1 "
                    + "and    xref.gfs_entity_type_code = 15 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.gfs_entity_id = abm.pmg_id "
                    + "and    xref.gfs_entity_type_code = abm.pmg_type_code "
                    + "and    xref.gfs_entity_id = tcgm.group_id "
                    + "and    xref.gfs_entity_type_code = tcgm.group_type_code "
                    + "and    xref2.gfs_entity_type_code = 0 "
                    + "and    xref2.business_unit_code in (36,37) "
                    + "and    xref2.original_entity_id = gac.cust_nbr "
                    + "and    xref2.gfs_entity_id = tcgm.member_customer_id "
                    + "and    xref2.gfs_entity_type_code = tcgm.member_customer_type_code "
                    + "and    (tcgm.effective_date IS NULL "
                    + "or      tcgm.expiration_date IS NULL "
                    + "or     (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) "
                    + "or      tcgm.group_cust_store_nbr IS NOT NULL "
                    + "or      tcgm.last_update_tmstmp IS NULL "
                    + "or     (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end invldRecordsInGlzAvndraInTrgtGfsCustGrpMembrship
	
	public int exstingPmgRecordsInGlzAvndraInTrgtgGfs_Cust(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_admin.gfs_customer tgc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tgc.gfs_customer_type_code "
                + "and    tgc.gfs_customer_id = abm.pmg_id";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end exstingPmgRecordsInGlzAvndraInTrgtgGfs_Cust
	
	public int invldRecordsInGlzAvndraInTrgtGfsCust(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_admin.gfs_customer tgc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tgc.gfs_customer_type_code "
                + "and    tgc.gfs_customer_id = abm.pmg_id "
                + "and    (tgc.site_id IS NOT NULL "
                + "or      tgc.gfs_customer_name IS NULL "
                + "or      tgc.last_update_user_id IS NULL "
                + "or      tgc.last_update_tmstmp IS NULL)";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end invldRecordsInGlzAvndraInTrgtGfsCust
	
	public int glzAvndraRecrdsInStgGfsCustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_group scg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scg.gfs_customer_type_code "
                + "and    scg.gfs_customer_id = abm.pmg_id "
                + "and    scg.customer_group_name like 'Existing%'";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end glzAvndraRecrdsInStgGfsCustGrp
	
	
	public int glzAvndraRecrdsInTrgtGfsCustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_group tcg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcg.gfs_customer_type_code "
                + "and    tcg.gfs_customer_id = abm.pmg_id";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end glzAvndraRecrdsInTrgtGfsCustGrp
	
	public int invldRecordsInGlzAvndraInTrgtGfsCustGrp(){
		final SqlParameterSource paramMap = null;
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_group tcg, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.avendra_bracket_mapping abm "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcg.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcg.gfs_customer_type_code "
                + "and    tcg.gfs_customer_id = abm.pmg_id "
                + "and    tcg.gfs_customer_id NOT IN ('7787','7788','7789','7790','7791','7792','7793','7795','7796','7797','7798','7799','7801','7802','7803') "
                + "and    (tcg.customer_group_name IS NULL "
                + "or      tcg.customer_group_desc IS NULL "
                + "or     (tcg.cust_grp_status_code IS NULL or tcg.cust_grp_status_code <> 1) "
                + "or      tcg.cust_grp_status_date IS NULL "
                + "or     (tcg.company_nbr IS NULL or tcg.company_nbr <> 1) "
                + "or      tcg.added_date IS NULL "
                + "or     (tcg.pricing_audit_privlg_ind IS NULL or tcg.pricing_audit_privlg_ind <> 0) "
                + "or     (tcg.order_lock_out_code IS NULL or tcg.order_lock_out_code <> 2) "
                + "or      tcg.cust_reln_mgr_id IS NOT NULL "
                + "or      tcg.last_update_tmstmp IS NULL "
                + "or     (tcg.last_update_user_id IS NULL) "
                + "or      tcg.buyer_nbr IS NOT NULL)";
        
        String result = this.queryForObject(sql, paramMap , String.class);
        return Integer.parseInt(result);
	}//end glzAvndraRecrdsInTrgtGfsCustGrp
}//end AvendraMembrshpToPmgMembrshpDaoImpl
