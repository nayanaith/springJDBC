package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao;

/**
 * This class implements the methods identified by the GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao
 * interface.  It queries the input table GLAZIER_CUSTOMER, 
 * @author v7vyo
 */
public class GlzrShpToAdrsInfoToGFScustUnitSiteInfoDaoImpl extends NamedParameterJdbcTemplate implements GlzrShpToAdrsInfoToGFScustUnitSiteInfoDao{
	
	public GlzrShpToAdrsInfoToGFScustUnitSiteInfoDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	public int countGlazierCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from cust_stage_admin.glazier_customer where valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end GlzrShpToAdrsInfoToGFScustUnitSiteInfoDaoImpl
	
	
	public int crmSiteGlazierRecords(){
		final SqlParameterSource paramMap = null;        
        String sql = "select count(*) from cust_stage_admin.glazier_customer gc, cust_stage_admin.gfs_customer_site scs, cust_stage_admin.crm_site cs, cust_stage_admin.gfs_entity_xref xref where xref.gfs_entity_type_code = 0 and xref.business_unit_code in (36,37) and xref.original_entity_id = scs.gfs_customer_id and xref.gfs_entity_type_code = scs.gfs_customer_type_code"+" and xref.original_entity_id = gc.cust_nbr and scs.crm_site_id = cs.crm_site_id and gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end crmSiteGlazierRecords
	
	
	public int bilingAgntStgCrmSite(){
		final SqlParameterSource paramMap = null;        
        String sql = "select count(*) from cust_stage_admin.glazier_customer gc, cust_stage_admin.gfs_customer_site scs, cust_stage_admin.crm_site cs, cust_stage_admin.gfs_entity_xref xref"
        		+" where xref.gfs_entity_type_code = 0 and xref.business_unit_code in (36,37) and xref.original_entity_id = scs.gfs_customer_id and xref.gfs_entity_type_code = scs.gfs_customer_type_code"
        		+" and xref.original_entity_id = gc.cust_nbr and scs.crm_site_id = cs.crm_site_id and gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilingAgntStgCrmSite
	
	public int targetAgntStgCrmSite(){
		final SqlParameterSource paramMap = null;        
        String sql = "select count(*) from cust_admin.gfs_customer_site tcs, cust_admin.crm_site cs, cust_stage_admin.gfs_entity_xref xref"
+" where  xref.gfs_entity_type_code = 0 and xref.business_unit_code in (36,37) and xref.gfs_entity_id = tcs.gfs_customer_id and    xref.gfs_entity_type_code = tcs.gfs_customer_type_code"
+" and tcs.crm_site_id = cs.crm_site_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end targetAgntStgCrmSite
	
	
	public int stgInvalidCustomerSiteRecords(){
		final SqlParameterSource paramMap = null;        
        String sql = "select count(*) " +
                "from  cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.gfs_customer_site gcs, " +
                "      cust_stage_admin.crm_site cs, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = gcs.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = gcs.gfs_customer_type_code " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gcs.crm_site_id = cs.crm_site_id " +
                "and   gc.valid_record_ind = 1 " +
                "and   (cs.crm_site_id IS NULL " +
                "or    cs.site_desc IS NOT NULL " +
                "or    cs.address_1_txt <> gc.ship_to_addr_line_1 " +
                "or    cs.address_2_txt IS NOT NULL " +
                "or    cs.address_3_txt IS NOT NULL " +
                "or    cs.address_attn_txt IS NOT NULL " +
                "or    cs.city_name <> gc.ship_to_city_name " +
                "or    cs.state_alpha_code <> gc.ship_to_state_code " +
                "or    cs.postal_code <> substr(gc.ship_to_postal_code,1,5) " +
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
        return Integer.parseInt(result);
	}//end stgInvalidCustomerSiteRecords
	
	
	public int trgtInvalidCustomerSiteRecords(){
		final SqlParameterSource paramMap = null;        
        String sql = "select count(*) from   cust_admin.gfs_customer tgc, cust_admin.crm_site tcs, cust_stage_admin.gfs_entity_xref xref,"+
       " cust_stage_admin.gfs_entity_xref xref2,"+
       " cust_stage_admin.crm_site scs"+
" where  tgc.gfs_customer_type_code = 0"+
" and    xref.business_unit_code in (36,37)"+
" and    xref.gfs_entity_id = tgc.gfs_customer_id"+
" and    xref.gfs_entity_type_code = tgc.gfs_customer_type_code"+
" and    xref2.gfs_entity_type_code = 99"+
" and    xref2.business_unit_code in (36,37)"+ 
" and    xref2.gfs_entity_id = tgc.site_id"+
" and    xref2.gfs_entity_id = tcs.crm_site_id"+
" and    xref2.original_entity_id = scs.crm_site_id"+
" and    (tcs.site_desc IS NOT NULL"+
" or     tcs.address_1_txt <> scs.address_1_txt"+
" or     tcs.address_2_txt IS NOT NULL"+
" or     tcs.address_3_txt IS NOT NULL"+
" or     tcs.city_name <> scs.city_name"+
" or     tcs.state_alpha_code <> scs.state_alpha_code"+
" or     tcs.postal_code <> scs.postal_code"+
" or     tcs.country_code <> 'US'"+
" or     tcs.county_code <> scs.county_code"+
" or     tcs.default_tax_geo_code IS NOT NULL"+
" or     tcs.override_tax_geo_code IS NOT NULL"+
" or     tcs.last_update_tmstmp IS NULL"+
" or     (tcs.last_update_user_id IS NULL or tcs.last_update_user_id NOT LIKE 'Glazier%')"+
" or     tcs.temp_default_tax_geo_code IS NOT NULL"+
" or     tcs.temp_override_tax_geo_code IS NOT NULL"+
" or     tcs.twe_tax_geo_code IS NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgInvalidCustomerSiteRecords
}//end GlzrShpToAdrsInfoToGFScustUnitSiteInfoDaoImpl
