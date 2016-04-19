/**
 * 
 */
package com.gfs.integration.glazier.automation.dao.impl;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao;

/**
 * This class implements the methods identified by the GlazierShiptoClassToGFSCustomerClassDao
 * interface.  It queries the input table GLAZIER_CUSTOMER, the cust_stage_admin
 * schema and the cust_admin schema.
 * @author e3k17
 *
 */
public class GlazierShiptoClassToGFSCustomerClassDaoImpl extends NamedParameterJdbcTemplate implements GlazierShiptoClassToGFSCustomerClassDao{
        
        //Default Consturctor
	public GlazierShiptoClassToGFSCustomerClassDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}
	
	/**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countGlazierCustomerUnits() 
         */
	public int countGlazierCustomerUnits() {
		final SqlParameterSource paramMap = null;
                
                String sql = " select count(*) " +
                    "from  cust_stage_admin.glazier_customer " +
                    "where valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countGlazierCustomerUnits 

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMSubClasses() 
         */
	public int countStagedCCMSubClasses() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.glazier_customer gc, " +
                        "      cust_stage_admin.customer_class_member sccm, " +
                        "      cust_stage_admin.gfs_entity_xref xref " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.original_entity_id = sccm.gfs_customer_id " +
                        "and   sccm.class_category_id = 3 " +
                        "and   xref.original_entity_id = gc.cust_nbr " +
                        "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedCCMSubClasses
 
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMAffiliations() 
         */
	public int countStagedCCMAffiliations() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.glazier_customer gc, " +
                        "      cust_stage_admin.customer_class_member sccm, " +
                        "      cust_stage_admin.gfs_entity_xref xref " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.original_entity_id = sccm.gfs_customer_id " +
                        "and   sccm.class_category_id = 4 " +
                        "and   xref.original_entity_id = gc.cust_nbr " +
                        "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedCCMAffiliations

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMMenuThemes() 
         */
	public int countStagedCCMMenuThemes() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.glazier_customer gc, " +
                        "      cust_stage_admin.customer_class_member sccm, " +
                        "      cust_stage_admin.gfs_entity_xref xref " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.original_entity_id = sccm.gfs_customer_id " +
                        "and   sccm.class_category_id = 5 " +
                        "and   xref.original_entity_id = gc.cust_nbr " +
                        "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedCCMMenuThemes
 
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMMgmtType() 
         */
	public int countStagedCCMMgmtType() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.glazier_customer gc, " +
                        "      cust_stage_admin.customer_class_member sccm, " +
                        "      cust_stage_admin.gfs_entity_xref xref " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.original_entity_id = sccm.gfs_customer_id " +
                        "and   sccm.class_category_id = 6 " +
                        "and   xref.original_entity_id = gc.cust_nbr " +
                        "and   gc.valid_record_ind = 1";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedCCMMgmtType

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMSubClassesWithInvalidFields() 
         */
	public int countStagedCCMSubClassesWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member ccm, " +
                "      cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.glazier_cust_type_mapping ctm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.cust_nbr = ccm.gfs_customer_id " +
                "and   gc.valid_record_ind = 1 " +
                "and   ccm.class_category_id = 3 " +
                "and   gc.customer_type = ctm.glazier_customer_type " +
                "and   ((locked_membership_ind IS NULL or locked_membership_ind <> 0) " +
                "or    (primary_membership_ind IS NULL or primary_membership_ind <> 0) " +
                "or    (last_update_tmstmp IS NULL) " +
                "or    (ccm.class_id <> decode(gc.parent_code,30,2,40,2,ctm.gfs_sub_class_id)) " +
                "or    (last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countStagedCCMSubClassesWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMAffiliationsWithInvalidFields() 
         */
	public int countStagedCCMAffiliationsWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member ccm, " +
                "      cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.glazier_cust_type_mapping ctm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.cust_nbr = ccm.gfs_customer_id " +
                "and   gc.valid_record_ind = 1 " +
                "and   ccm.class_category_id = 4 " +
                "and   gc.customer_type = ctm.glazier_customer_type " +
                "and   ((locked_membership_ind IS NULL or locked_membership_ind <> 0) " +
                "or    (primary_membership_ind IS NULL or primary_membership_ind <> 0) " +
                "or    (last_update_tmstmp IS NULL) " +
                "or    (ccm.class_id <> ctm.gfs_affiliation_id) " +
                "or    (last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);                
	}//end countStagedCCMAffiliationsWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMMenuThemesWithInvalidFields() 
         */
	public int countStagedCCMMenuThemesWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member ccm, " +
                "      cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.glazier_cust_type_mapping ctm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.cust_nbr = ccm.gfs_customer_id " +
                "and   gc.valid_record_ind = 1 " +
                "and   ccm.class_category_id = 5 " +
                "and   gc.customer_type = ctm.glazier_customer_type " +
                "and   ((locked_membership_ind IS NULL or locked_membership_ind <> 0) " +
                "or    (primary_membership_ind IS NULL or primary_membership_ind <> 0) " +
                "or    (last_update_tmstmp IS NULL) " +
                "or    (ccm.class_id <> ctm.gfs_menu_theme_id) " +
                "or    (last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);               
	}//end countStagedCCMMenuThemesWithInvalidFields  

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedCCMMgmtTypesWithInvalidFields() 
         */
	public int countStagedCCMMgmtTypesWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member ccm, " +
                "      cust_stage_admin.glazier_customer gc, " +
                "      cust_stage_admin.glazier_cust_type_mapping ctm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = gc.cust_nbr " +
                "and   gc.cust_nbr = ccm.gfs_customer_id " +
                "and   gc.valid_record_ind = 1 " +
                "and   ccm.class_category_id = 6 " +
                "and   gc.customer_type = ctm.glazier_customer_type " +
                "and   ((locked_membership_ind IS NULL or locked_membership_ind <> 0) " +
                "or    (primary_membership_ind IS NULL or primary_membership_ind <> 0) " +
                "or    (last_update_tmstmp IS NULL) " +
                "or    (ccm.class_id <> ctm.gfs_management_type_id) " +
                "or    (last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);               
	}//end countStagedCCMMgmtTypesWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMSubClasses() 
         */
	public int countTargetCCMSubClasses() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.gfs_entity_xref xref, " +
                        "      cust_admin.customer_class_member tccm " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                        "and   tccm.class_category_id = 3";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMSubClasses

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMAffiliations() 
         */
	public int countTargetCCMAffiliations() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.gfs_entity_xref xref, " +
                        "      cust_admin.customer_class_member tccm " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                        "and   tccm.class_category_id = 4";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMAffiliations

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMMenuThemes() 
         */
	public int countTargetCCMMenuThemes() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.gfs_entity_xref xref, " +
                        "      cust_admin.customer_class_member tccm " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                        "and   tccm.class_category_id = 5";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMMenuThemes

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMMgmtType() 
         */
	public int countTargetCCMMgmtType() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                        "from  cust_stage_admin.gfs_entity_xref xref, " +
                        "      cust_admin.customer_class_member tccm " +
                        "where xref.gfs_entity_type_code = 0 " +
                        "and   xref.business_unit_code in (36,37) " +
                        "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                        "and   tccm.class_category_id = 6";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMMgmtType

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMSubClassesWithInvalidFields() 
         */
	public int countTargetCCMSubClassesWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member sccm, " +
                "      cust_admin.customer_class_member tccm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sccm.gfs_customer_id " +
                "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                "and   sccm.class_category_id = 3 " +
                "and   tccm.class_category_id = 3 " +
                "and   (sccm.locked_membership_ind <> tccm.locked_membership_ind " +
                "or    sccm.primary_membership_ind <> tccm.primary_membership_ind " +
                "or    tccm.last_update_tmstmp IS NULL " +
                "or    sccm.class_id <> tccm.class_id " +
                "or    (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMSubClassesWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMAffiliationsWithInvalidFields() 
         */
	public int countTargetCCMAffiliationsWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member sccm, " +
                "      cust_admin.customer_class_member tccm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sccm.gfs_customer_id " +
                "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                "and   sccm.class_category_id = 4 " +
                "and   tccm.class_category_id = 4 " +
                "and   (sccm.locked_membership_ind <> tccm.locked_membership_ind " +
                "or    sccm.primary_membership_ind <> tccm.primary_membership_ind " +
                "or    tccm.last_update_tmstmp IS NULL " +
                "or    sccm.class_id <> tccm.class_id " +
                "or    (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMAffiliationsWithInvalidFields
        
        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMMenuThemesWithInvalidFields() 
         */
	public int countTargetCCMMenuThemesWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member sccm, " +
                "      cust_admin.customer_class_member tccm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sccm.gfs_customer_id " +
                "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                "and   sccm.class_category_id = 5 " +
                "and   tccm.class_category_id = 5 " +
                "and   (sccm.locked_membership_ind <> tccm.locked_membership_ind " +
                "or    sccm.primary_membership_ind <> tccm.primary_membership_ind " +
                "or    tccm.last_update_tmstmp IS NULL " +
                "or    sccm.class_id <> tccm.class_id " +
                "or    (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMMenuThemesWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetCCMMgmtTypeWithInvalidFields() 
         */
	public int countTargetCCMMgmtTypeWithInvalidFields() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                "from  cust_stage_admin.customer_class_member sccm, " +
                "      cust_admin.customer_class_member tccm, " +
                "      cust_stage_admin.gfs_entity_xref xref " +
                "where xref.gfs_entity_type_code = 0 " +
                "and   xref.business_unit_code in (36,37) " +
                "and   xref.original_entity_id = sccm.gfs_customer_id " +
                "and   xref.gfs_entity_id = tccm.gfs_customer_id " +
                "and   sccm.class_category_id = 6 " +
                "and   tccm.class_category_id = 6 " +
                "and   (sccm.locked_membership_ind <> tccm.locked_membership_ind " +
                "or    sccm.primary_membership_ind <> tccm.primary_membership_ind " +
                "or    tccm.last_update_tmstmp IS NULL " +
                "or    sccm.class_id <> tccm.class_id " +
                "or    (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
                
		String result = this.queryForObject(sql,paramMap,String.class);	
		return Integer.parseInt(result);
	}//end countTargetCCMMgmtTypeWithInvalidFields

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countStagedGFSCustUnitWithInvalidFuelSurcharge() 
         */
	public int countStagedGFSCustUnitWithInvalidFuelSurcharge() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) from ( "
                + "select gc.cust_nbr "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.gfs_customer sgc, "
                + "       cust_stage_admin.gfs_cust_unit sgcu,  "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_cust_type_mapping gctm "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    gc.customer_type = gctm.glazier_customer_type "
                + "and    sgc.gfs_customer_id = sgcu.gfs_customer_id "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code IS NULL "
                + "and    sgcu.fuel_surcharge_eligible_ind <> gctm.gfs_fuel_surchrg_eligible_ind "
                + "UNION "
                + "select gc.cust_nbr "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.gfs_customer sgc, "
                + "       cust_stage_admin.gfs_cust_unit sgcu, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sgc.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = sgc.gfs_customer_type_code "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    sgc.gfs_customer_id = sgcu.gfs_customer_id "
                + "and    gc.valid_record_ind = 1 "
                + "and    gc.parent_code IS NOT NULL "
                + "and    sgcu.fuel_surcharge_eligible_ind <> 0)";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countStagedGFSCustUnitWithInvalidFuelSurcharge

        /**
         * @see com.gfs.integration.glazier.automation.dao.GlazierShiptoClassToGFSCustomerClassDao#countTargetGFSCustUnitWithInvalidFuelSurcharge() 
         */
	public int countTargetGFSCustUnitWithInvalidFuelSurcharge() {
		final SqlParameterSource paramMap = null;
                
                String sql = "select count(*) " +
                    "from  cust_stage_admin.gfs_entity_xref xref, " +
                    "      cust_stage_admin.gfs_cust_unit sgcu, " +
                    "      cust_admin.gfs_customer tgc, " +
                    "      cust_admin.gfs_cust_unit tgcu " +
                    "where xref.gfs_entity_type_code = 0 " +
                    "and   xref.business_unit_code in (36,37) " +
                    "and   xref.gfs_entity_id = tgc.gfs_customer_id " +
                    "and   xref.gfs_entity_type_code = tgc.gfs_customer_type_code " +
                    "and   xref.original_entity_id = sgcu.gfs_customer_id " +
                    "and   tgc.gfs_customer_id = tgcu.gfs_customer_id " +
                    "and   sgcu.fuel_surcharge_eligible_ind <> tgcu.fuel_surcharge_eligible_ind";
                
		String result = this.queryForObject(sql,paramMap,String.class);
		//System.out.printf("%d",result.size());
		return Integer.parseInt(result);
	}//end countTargetGFSCustUnitWithInvalidFuelSurcharge 
        
}//end GlazierShiptoClassToGFSCustomerClassImpl
