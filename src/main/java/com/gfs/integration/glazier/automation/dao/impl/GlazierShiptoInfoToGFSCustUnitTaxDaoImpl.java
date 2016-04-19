/**
 * 
 */
package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTaxDao;

/**
 * This class implements the methods identified by the GlazierShiptoInfoToGFSCustUnitTaxDao
 * interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
 * schema and the cust_admin schema.
 * @author e3k17
 *
 */
public class GlazierShiptoInfoToGFSCustUnitTaxDaoImpl extends NamedParameterJdbcTemplate implements GlazierShiptoInfoToGFSCustUnitTaxDao{
        
        //Default Consturctor
	public GlazierShiptoInfoToGFSCustUnitTaxDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}

	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTax#countGlazierCustomerUnits() 
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
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTaxDao#countStagedGFSCustUnitTax() 
         */
	public int countStagedGFSCustUnitTax() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.glazier_customer gc, " +
                    "      cust_stage_admin.gfs_customer sgc, " +
                    "      cust_stage_admin.gfs_cust_unit_tax stax, " +
                    "      cust_stage_admin.gfs_entity_xref xref " +
                    "where xref.gfs_entity_type_code = 0 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.original_entity_id = sgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
                    "and   xref.original_entity_id = gc.cust_nbr " +
                    "and   sgc.gfs_customer_id = stax.gfs_customer_id " +
                    "and   gc.valid_record_ind = 1 ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedGFSCustUnitTax

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTaxDao#countTargetGFSCustUnitTax() 
         */
	public int countTargetGFSCustUnitTax() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_cust_unit_tax ttax, " +
                "      cust_admin.gfs_customer tgc, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   tgc.gfs_customer_id = ttax.gfs_customer_id ";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetGFSCustUnitTax

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTaxDao#countStagedGFSCustUnitTaxWithInvalidFields() 
         */
	public int countStagedGFSCustUnitTaxWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
            "from  cust_stage_admin.glazier_customer gc " +
            "         join cust_stage_admin.GLAZIER_CUST_TYPE_MAPPING gctm " +
            "                on GC.CUSTOMER_TYPE = GCTM.GLAZIER_CUSTOMER_TYPE, " +
            "      cust_stage_admin.gfs_customer sgc, " +
            "      cust_stage_admin.gfs_cust_unit_tax sgcut, " +
            "      cust_stage_admin.gfs_entity_xref xref " +
            "where xref.gfs_entity_type_code = 0 " +
            "and   xref.business_unit_code in (36,37) " +
            "and   xref.original_entity_id = sgc.gfs_customer_id " +
            "and   xref.gfs_entity_type_code = sgc.gfs_customer_type_code " +
            "and   xref.original_entity_id = gc.cust_nbr " +
            "and   sgc.gfs_customer_id = sgcut.gfs_customer_id " +
            "and   gc.valid_record_ind = 1 " +
            "and   (sgcut.sales_tax_exempt_id IS NOT NULL " +
            "or    (sgcut.gst_tax_ind IS NOT NULL and sgcut.gst_tax_ind <> 0) " +
            "or     (((GC.CITY_TAX_CODE between '900' and '999') and  " +
            "           (GC.LOCAL_TAX_CODE between '900' and '999') and " +
            "           (GC.STATE_TAX_CODE between '900' and '999') and " +
            "           (GCTM.GFS_SUB_CLASS_ID in (45,46,56,57,60,61,62,63,64,74,75,78,79) and sgcut.tax_exemption_code <>  2)) " +
            "       or (((GC.CITY_TAX_CODE between '900' and '999') and " +
            "           (GC.LOCAL_TAX_CODE between '900' and '999') and " +
            "           (GC.STATE_TAX_CODE between '900' and '999')) and " +
            "            (GCTM.GFS_SUB_CLASS_ID in (90,91,92,93,94,95,99) and sgcut.tax_exemption_code <>  1)) " +
            "       or  (((GC.CITY_TAX_CODE between '900' and '999') and " +
            "           (GC.LOCAL_TAX_CODE between '900' and '999') and " +
            "           (GC.STATE_TAX_CODE between '900' and '999')) and " +
            "           (GCTM.GFS_SUB_CLASS_ID not in (45,46,56,57,60,61,62,63,64,74,75,78,79,90,91,92,93,94,95,99) and sgcut.tax_exemption_code <>  6)) " +
            "      or  (((GC.CITY_TAX_CODE not between '900' and '999') or " +
            "           (GC.LOCAL_TAX_CODE not between '900' and '999') or " +
            "           (GC.STATE_TAX_CODE not between '900' and '999')) and " +
            "            sgcut.tax_exemption_code <>  1)) " +
            "or    sgcut.tax_form_provided_ind <> decode(gc.tax_resale_items,'Y',0,1) " +
            "or    sgcut.tax_form_signed_date IS NOT NULL " +
            "or    sgcut.tax_geo_code IS NOT NULL " +
            "or    sgcut.last_update_tmstmp IS NULL " +
            "or    (sgcut.last_update_user_id IS NOT NULL and sgcut.last_update_user_id <> 'Glazier Load') " +
            "or    sgcut.default_tax_geo_code IS NOT NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);               
	}//end countStagedGFSCustUnitTaxWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoInfoToGFSCustUnitTaxDao#countTargetGFSCustUnitTaxWithInvalidFields() 
         */
	public int countTargetGFSCustUnitTaxWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_admin.gfs_customer tgc, " +
                "      cust_admin.gfs_cust_unit_tax tgcut, " +
                "      cust_stage_admin.gfs_cust_unit_tax sgcut, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                "and   xref.original_entity_id = sgcut.gfs_customer_id " +
                "and   sgcut.gfs_customer_id = tgcut.gfs_customer_id " +
                "and   (tgcut.sales_tax_exempt_id IS NOT NULL " +
                "or    (tgcut.gst_tax_ind IS NOT NULL and tgcut.gst_tax_ind <> 0) " +
                "or    tgcut.tax_exemption_code <> sgcut.tax_exemption_code " +
                "or    tgcut.tax_form_provided_ind <> sgcut.tax_form_provided_ind " +
                "or    tgcut.tax_form_signed_date IS NOT NULL " +
                "or    tgcut.tax_geo_code IS NULL " +
                "or    tgcut.last_update_tmstmp IS NULL " +
                "or    (tgcut.last_update_user_id IS NOT NULL and tgcut.last_update_user_id <> 'Glazier Load') " +
                "or    tgcut.default_tax_geo_code IS NULL)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		return Integer.parseInt(result);               
	}//end countTargetGFSCustUnitTaxWithInvalidFields
        
}//end GlazierShiptoInfoToGFSCustUnitTaxImpl
