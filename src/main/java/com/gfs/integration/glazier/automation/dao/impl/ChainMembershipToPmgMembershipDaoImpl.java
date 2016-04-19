package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.ChainMembershipToPmgMembershipDao;

public class ChainMembershipToPmgMembershipDaoImpl extends NamedParameterJdbcTemplate implements ChainMembershipToPmgMembershipDao {
	
	public ChainMembershipToPmgMembershipDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	public int recordsInGlzcustomer(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select distinct gc.parent_code,gc.chain_code "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_parent_code gpc "
                + "where  gc.parent_code = gpc.parent_code "
                + "and    gc.parent_code <> 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end recordsInGlzcustomer
	
	public int recordsInGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_group_membership scgm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code IN (15,18) "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scgm.group_id "
                + "and    xref.gfs_entity_type_code = scgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 3 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = scgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = scgm.member_customer_type_code";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end recordsInGfsCustGrpMemship
	
	
	public int invldsInGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_group_membership scgm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scgm.group_id "
                + "and    xref.gfs_entity_type_code = scgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 3 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = scgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = scgm.member_customer_type_code "
                + "and    (scgm.effective_date <> to_date('12/1/2014','MM/DD/YYYY') "
                + "or      scgm.expiration_date <> to_date('1/1/9999','MM/DD/YYYY') "
                + "or     (scgm.pricing_precedence_ind IS NULL or scgm.pricing_precedence_ind <> 0) "
                + "or      scgm.group_cust_store_nbr IS NOT NULL "
                + "or      scgm.last_update_tmstmp IS NULL "
                + "or     (scgm.last_update_user_id IS NULL or scgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldsInGfsCustGrpMemship
	
	public int invldsInTrgtGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_group_membership tcgm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 15 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcgm.group_id "
                + "and    xref.gfs_entity_type_code = tcgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 3 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.gfs_entity_id = tcgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = tcgm.member_customer_type_code "
                + "and    tcgm.effective_date <= sysdate "
                + "and    tcgm.expiration_date >= sysdate "
                + "and    (tcgm.effective_date IS NULL "
                + "or      tcgm.expiration_date IS NULL "
                + "or     (tcgm.pricing_precedence_ind IS NULL or tcgm.pricing_precedence_ind <> 0) "
                + "or      tcgm.group_cust_store_nbr IS NOT NULL "
                + "or      tcgm.last_update_tmstmp IS NULL)";
//                + "or     (tcgm.last_update_user_id IS NULL or tcgm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldsInTrgtGfsCustGrpMemship
	
	public int recordsInTrgtGfsCustGrpMemship(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_group_membership tcgm, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code IN (15,18) "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcgm.group_id "
                + "and    xref.gfs_entity_type_code = tcgm.group_type_code "
                + "and    xref2.gfs_entity_type_code = 3 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.gfs_entity_id = tcgm.member_customer_id "
                + "and    xref2.gfs_entity_type_code = tcgm.member_customer_type_code "
                + "and    tcgm.effective_date <= sysdate "
                + "and    tcgm.expiration_date >= sysdate";
                
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end recordsInTrgtGfsCustGrpMemship
	
}//end ChainMembershipToPmgMembershipDaoImpl
