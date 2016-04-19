package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.ShipToToCustomerPreferenceDao;

public class ShipToToCustomerPreferenceDaoImpl extends NamedParameterJdbcTemplate implements ShipToToCustomerPreferenceDao{
	public ShipToToCustomerPreferenceDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}//end ShipToToCustomerPreferenceDaoImpl
	
	public int invoicePrintSequencePrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                  +  "from  cust_stage_admin.glazier_customer gc "
                  +  "where gc.parent_code in (26,27,28) "
                  +  "and   gc.invoice_sequence in ('C','E')"
                  +  "and   gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierFamilyCust
	
	public int invoicePrintSequencePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from   cust_stage_admin.cust_preference_selection cps, "
                    + "       cust_stage_admin.gfs_entity_xref xref " 
                    + "where  xref.gfs_entity_type_code = 0 " 
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = cps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code =  cps.gfs_customer_type_code "
                    + "and    cps.customer_preference_id = 100 "
                    + "and    cps.cust_preference_option_id = 4";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierFamilyCust
	
	public int invalidInvoicePrintSequencePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from  cust_stage_admin.cust_preference_selection cps, "
            + "      cust_stage_admin.gfs_entity_xref xref "
            + "where xref.gfs_entity_type_code = 0 "
            + "and   xref.business_unit_code in (36,37) "
            + "and   xref.original_entity_id = cps.gfs_customer_id "
            + "and   xref.gfs_entity_type_code =  cps.gfs_customer_type_code "
            + "and   cps.customer_preference_id = 100 "
            + "and   cps.cust_preference_option_id = 4 "
            + "and   ((preference_option_value IS NULL or preference_option_value NOT LIKE 'Use a List%') "
            + "or     last_update_tmstmp IS NULL "
            + "or    (last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierFamilyCust
	
	public int invoicePrintSeqListIdPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                   + "from   cust_stage_admin.glazier_customer gc "
                   + "where  valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invoicePrintSeqListIdPrefInGlzCust
	
	
	public int invoicePrintSeqListIdPrefCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code =  cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 101 "
                + "and    cps.cust_preference_option_id = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invoicePrintSeqListIdPrefCustPrefSelction
	
	public int invalidInvoicePrintSeqListIdInPrefCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code =  cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 101 "
            + "and    cps.cust_preference_option_id = 1 "
            + "and    (preference_option_value IS NULL "
            + "or      last_update_tmstmp IS NULL "
            + "or     (last_update_user_id IS NULL or last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidInvoicePrintSeqListIdInPrefCustPrefSelction
	
	public int invoiceSubtotalPrintPrefInGlazCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from   cust_stage_admin.glazier_customer gc "
                    + "where  gc.invoice_sequence='E' "
                    + "and    valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invoicePrntListIdPrefInGlazCust
	
	public int invoiceSubtotalPrintPrefInCustPrefSelection(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from  cust_stage_admin.cust_preference_selection cps, "
                + "      cust_stage_admin.gfs_entity_xref xref "
                + "where xref.gfs_entity_type_code = 0 "
                + "and   xref.business_unit_code in (36,37) "
                + "and   xref.original_entity_id = cps.gfs_customer_id "
                + "and   xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and   cps.customer_preference_id = 102 "
                + "and   cps.cust_preference_option_id = 3";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end inoicePrntListIdPrefInCustPrefSelection
	
	public int invalidInvoiceSubtotalPrintPrefInPrefCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
        + "from   cust_stage_admin.cust_preference_selection cps, "
        + "       cust_stage_admin.gfs_entity_xref xref "
        + "where  xref.gfs_entity_type_code = 0 "
        + "and    xref.business_unit_code in (36,37) "
        + "and    xref.original_entity_id = cps.gfs_customer_id "
        + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
        + "and    cps.customer_preference_id = 102 "
        + "and    cps.cust_preference_option_id = 3 "
        + "and    ((cps.preference_option_value IS NULL or cps.preference_option_value NOT LIKE 'On Separate Page%') "
        + "or      cps.last_update_tmstmp IS NULL "
        + "or     (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidInvoiceSubtotalPrintPrefInPrefCustPrefSelction
	
	public int invoiceCopiesPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql =    "select count(*) "
                + "from  cust_stage_admin.glazier_customer gc "
                + "where gc.invoice_copies > 0";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invoiceCopiesPrefInGlzCust
	
	public int invoiceCopiesPrefInCustPrefSelection(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 104 "
                + "and    cps.cust_preference_option_id > 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invoiceCopiesPrefInCustPrefSelection
	
	public int invalidinvoiceCopiesPrefInPrefCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.glazier_customer gc "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    xref.original_entity_id = gc.cust_nbr "
            + "and    gc.valid_record_ind = 1 "
            + "and    cps.customer_preference_id = 104 "
            + "and    cps.cust_preference_option_id > 1 "
            + "and    (cps.preference_option_value <> (gc.invoice_copies+1) "
            + "or      cps.last_update_tmstmp IS NULL "
            + "or     (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidinvoiceCopiesPrefInPrefCustPrefSelction
	
	public int deliveryDocTypePrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.print_invoice_prices = 'N' "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryDocTypePrefInGlzCust
	
	
	public int deliveryDocTypePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 106 "
                + "and    cps.cust_preference_option_id = 2";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryDocTypePrefInCustPrefSelction
	
	public int invalidDeliveryDocTypePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 106 "
                + "and    cps.cust_preference_option_id = 2 "
                + "and    ((cps.preference_option_value IS NULL or cps.preference_option_value NOT LIKE 'Bill of Lading%') "
                + "or     cps.last_update_tmstmp IS NULL "
                + "or     (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryDocTypePrefInCustPrefSelction
	
	public int custItemCodeSourcePrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.parent_code in (26,27,28) "
                + "and    gc.invoice_sequence in ('C','E') "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end custItemCodeSourcePrefInGlzCust
	
	public int custItemCodeSourcePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 200 "
                + "and    cps.cust_preference_option_id = 2";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end custItemCodeSourcePrefInCustPrefSelction
	
	public int invalidCustItemCodeSourcePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 200 "
            + "and    cps.cust_preference_option_id = 2 "
            + "and    ((cps.preference_option_value IS NULL or cps.preference_option_value NOT LIKE 'Use a List%') "
            + "or       cps.last_update_tmstmp IS NULL "
            + "or      (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidCustItemCodeSourcePrefInCustPrefSelction
	
	public int custItemCodeListIdPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from   cust_stage_admin.glazier_customer gc "
                    + "where  gc.parent_code in (26,27,28) "
                    + "and    gc.invoice_sequence in ('C','E') "
                    + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end custItemCodeListIdPrefInGlzCust
	
	public int custItemCodeListIdPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 201 "
            + "and    cps.cust_preference_option_id = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end custItemCodeListIdPrefInCustPrefSelction
	
	
	public int invalidCustItemCodeListIdPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 201 "
            + "and    cps.cust_preference_option_id = 1 "
            + "and    (cps.preference_option_value IS NULL "
            + "or      cps.last_update_tmstmp IS NULL "
            + "or     (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidCustItemCodeListIdPrefInCustPrefSelction
	
	public int custItemCodeVisibltyPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.parent_code in (26,27,28) "
                + "and    gc.invoice_sequence in ('C','E') "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end custItemCodeVisibltyPrefInGlzCust
	
	public int custItemCodeVisibltyPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 202 "
            + "and    cps.cust_preference_option_id = 4";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end custItemCodeVisibltyPrefInCustPrefSelction
	
	public int invalidCustItemCodeVisibltyPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 202 "
                + "and    cps.cust_preference_option_id = 4 "
                + "and    ((cps.preference_option_value IS NULL or cps.preference_option_value NOT LIKE 'Both%') "
                + "or       cps.last_update_tmstmp IS NULL "
                + "or      (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidCustItemCodeVisibltyPrefInCustPrefSelction
	
	public int frequencyPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) " 
            + "from   cust_stage_admin.glazier_customer gc "
            + "where  gc.credit_term_code in (2,3,4,5,6,10,11) "
            + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end frequencyPrefInGlzCust
	
	public int frequencyPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 601 "
                + "and    cps.cust_preference_option_id = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end frequencyPrefInCustPrefSelction
	
	public int invalidFrequencyPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 601 "
            + "and    cps.cust_preference_option_id = 1 "
            + "and    ((cps.preference_option_value IS NULL or cps.preference_option_value NOT LIKE 'Weekly%') "
            + "or       cps.last_update_tmstmp IS NULL "
            + "or      (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidfrequencyPrefInCustPrefSelction
	
	public int statementDistributionPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select distinct gs.cust_nbr "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_statement_distribution gs "
                + "where  gc.cust_nbr = gs.cust_nbr "
                + "and    gc.valid_record_ind = 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end statementFrequencyPrefInGlzCust
	
	public int statementDistributionPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 602 "
            + "and    cps.cust_preference_option_id = 3";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end statementFrequencyPrefInCustPrefSelction
	
	public int invalidStatementDistributionPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    cps.customer_preference_id = 602 "
            + "and    cps.cust_preference_option_id = 3 "
            + "and    ((cps.preference_option_value IS NULL or cps.preference_option_value NOT LIKE 'Email%') "
            + "or       cps.last_update_tmstmp IS NULL "
            + "or      (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidStatementFreqncyPrefInCustPrefSelction
	
	public int statementEmailPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select distinct gs.cust_nbr "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_statement_distribution gs "
                + "where  gc.cust_nbr = gs.cust_nbr "
                + "and    gc.valid_record_ind = 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end statementEmailPrefInGlzCust
	
	public int statementEmailPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_preference_selection cps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = cps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
                + "and    cps.customer_preference_id = 605 "
                + "and    cps.cust_preference_option_id = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end statementEmailPrefInCustPrefSelction
	
	public int invalidstatementEmailPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_preference_selection cps, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.glazier_statement_distribution gsd "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = cps.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = cps.gfs_customer_type_code "
            + "and    xref.original_entity_id = gsd.cust_nbr "
            + "and    cps.customer_preference_id = 605 "
            + "and    cps.cust_preference_option_id = 1 "
            + "and    (cps.preference_option_value <> gsd.contact_1_email "
            + "or       cps.last_update_tmstmp IS NULL "
            + "or      (cps.last_update_user_id IS NULL or cps.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidstatementEmailPrefInCustPrefSelction

	public int mktPlcInstntInviceDelPrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
        + "from   cust_stage_admin.glazier_customer gc "
        + "where  gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end mktPlcInstntInviceDelPrefInGlzCust
	
	public int mktPlcInstntInviceDelPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_doc_proc_option dpo, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = dpo.gfs_customer_id "
            + "and    dpo.document_proc_opt_code = 10";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end mktPlcInstntInviceDelPrefInCustPrefSelction
	
	public int invalidmktPlcInstntInviceDelPrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.cust_doc_proc_option dpo, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = dpo.gfs_customer_id "
            + "and    dpo.document_proc_opt_code = 10 "
            + "and    ((dpo.document_proc_opt_seq IS NULL or dpo.document_proc_opt_seq <> 1) "
            + "or       dpo.last_update_tmstmp IS NULL "
            + "or      (dpo.last_update_user_id IS NULL or dpo.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidmktPlcInstntInviceDelPrefInCustPrefSelction
	
	public int deliveryInvoicePrefInGlzCust(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInGlzCust

	public int deliveryInvoicePrefInGlzCustToCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.glazier_customer gc, "
            + "       cust_stage_admin.glazier_invoice_distribution gid "
            + "where  gc.cust_nbr = gid.cust_nbr "
            + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInGlzCustToCustomerContact
        
	public int deliveryInvoicePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    dpo.document_proc_opt_code = 11 "
                + "and    dpo.document_proc_opt_seq = 1 "
                + "UNION "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    dpo.document_proc_opt_code = 11 "
                + "and    dpo.document_proc_opt_seq = 5)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInCustPrefSelction
	
	public int invaliddeliveryInvoicePrefInCustPrefSelction(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    dpo.document_proc_opt_code = 11 "
                + "and    dpo.document_proc_opt_seq = 1 "
                + "and    (dpo.last_update_tmstmp IS NULL "
                + "or      dpo.last_update_user_id IS NULL or dpo.last_update_user_id NOT LIKE 'Glazier%') "
                + "UNION "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    dpo.document_proc_opt_code = 11 "
                + "and    dpo.document_proc_opt_seq = 5 "
                + "and    (dpo.last_update_tmstmp IS NULL "
                + "or      dpo.last_update_user_id IS NULL or dpo.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invaliddeliveryInvoicePrefInCustPrefSelction
	
	public int deliveryInvoicePrefInCustContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                    + "       cust_stage_admin.glazier_invoice_distribution gid, "
                    + "       cust_stage_admin.gfs_entity_xref xref, "
                    + "       cust_stage_admin.gfs_entity_xref xref2, "
                    + "       cust_stage_admin.customer_contact scc "
                    + "where  xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = gid.cust_nbr "
                    + "and    xref.original_entity_id = scca.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                    + "and    scca.customer_contact_role_id = 8"
                    + "and    scca.contact_id = scc.contact_id "
                    + "and    xref2.gfs_entity_type_code = 98 "
                    + "and    xref2.business_unit_code in (36,37) "
                    + "and    scc.contact_id = xref2.original_entity_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInCustContact
	
	public int invaliddeliveryInvoicePrefInCustContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact scc "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 8"
                + "and    scca.contact_id = scc.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    scc.contact_id = xref2.original_entity_id "
                + "and    (scc.contact_name IS NOT NULL "
                + "or      scc.site_id IS NOT NULL "
                + "or      scc.last_update_tmstmp IS NULL "
                + "or     (scc.last_update_user_id IS NULL or scc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invaliddeliveryInvoicePrefInCustContact
	
	public int deliveryInvoicePrefInGlzCustToGfsCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  gc.cust_nbr = gid.cust_nbr "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInGlzCustToGfsCustContactAsgn
	
	public int deliveryInvoicePrefInGfsCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 8 "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = scca.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInGfsCustContactAsgn
	
	public int invaliddeliveryInvoicePrefInCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.glazier_invoice_distribution gid, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2 "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gid.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 8"
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    xref2.original_entity_id = scca.contact_id "
            + "and    ((scca.customer_contact_role_id IS NULL or scca.customer_contact_role_id <> 8)"
            + "or      scca.comment_txt IS NOT NULL "
            + "or      scca.last_update_tmstmp IS NULL "
            + "or     (scca.last_update_user_id IS NULL or scca.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invaliddeliveryInvoicePrefInCustContactAsgn
	
	public int deliveryInvoicePrefInGlzCustToCustomerContctMechansm(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  gc.cust_nbr = gid.cust_nbr "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInGlzCustToCustomerContctMechansm
	
	public int deliveryInvoicePrefInCustomerContctMechansm(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.glazier_invoice_distribution gid, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2, "
            + "       cust_stage_admin.customer_contact_mechanism sccm "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gid.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 8 "
            + "and    scca.contact_id = sccm.contact_id "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    xref2.original_entity_id = sccm.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end deliveryInvoicePrefInCustomerContctMechansm
	
	public int invaliddeliveryInvoicePrefInCustomerContctMechansm(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact_mechanism sccm "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 8 "
                + "and    scca.contact_id = sccm.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = sccm.contact_id "
                + "and    ((sccm.contact_mechanism_prty_seq IS NULL or sccm.contact_mechanism_prty_seq <> 1) "
                + "or      (sccm.contact_mechanism_id IS NULL or sccm.contact_mechanism_id <> 5) "
                + "or       sccm.contact_mechanism_value <> gid.contact_1_email "
                + "or       sccm.last_update_tmstmp IS NULL "
                + "or      (sccm.last_update_user_id IS NULL or sccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invaliddeliveryInvoicePrefInCustomerContctMechansm
	
	public int pastDueNticeDelPrefRecsInGlaCust(){
		final SqlParameterSource paramMap = null;
        
                        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end pastDueNticeDelPrefRecsInGlaCust

	public int pastDueNticeDelPrefRecsInGlaCustForCustContact(){
		final SqlParameterSource paramMap = null;
        
                        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  gc.cust_nbr = gid.cust_nbr "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end pastDueNticeDelPrefRecsInGlaCustForCustContact
        
	public int pastDueNticeDelPrefRecsInCustDocProcOption(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    dpo.document_proc_opt_code = 12 "
                + "and    dpo.document_proc_opt_seq = 1 "
                + "UNION "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    dpo.document_proc_opt_code = 12 "
                + "and    dpo.document_proc_opt_seq = 5)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end pastDueNticeDelPrefRecsInCustDocProcOption
	
	public int invldPastDueNticeDelPrefRecsInCustDocProcOption(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    dpo.document_proc_opt_code = 12 "
                + "and    dpo.document_proc_opt_seq = 1 "
                + "and    (dpo.last_update_tmstmp IS NULL "
                + "or      dpo.last_update_user_id IS NULL or dpo.last_update_user_id NOT LIKE 'Glazier%') "
                + "UNION "
                + "select dpo.gfs_customer_id "
                + "from   cust_stage_admin.cust_doc_proc_option dpo, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_invoice_distribution gid "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = dpo.gfs_customer_id "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    dpo.document_proc_opt_code = 12 "
                + "and    dpo.document_proc_opt_seq = 5 "
                + "and    (dpo.last_update_tmstmp IS NULL "
                + "or      dpo.last_update_user_id IS NULL or dpo.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end InvldPastDueNticeDelPrefRecsInCustDocProcOption
	
	public int pastDueNticeDelPrefRecsInCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact scc "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 9 "
                + "and    scca.contact_id = scc.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    scc.contact_id = xref2.original_entity_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end pastDueNticeDelPrefRecsInCustomerContact
	
	public int invldPastDueNticeDelPrefRecsInCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.glazier_invoice_distribution gid, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2, "
            + "       cust_stage_admin.customer_contact scc "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gid.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 9 "
            + "and    scca.contact_id = scc.contact_id "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    scc.contact_id = xref2.original_entity_id "
            + "and    (scc.contact_name IS NOT NULL "
            + "or      scc.site_id IS NOT NULL "
            + "or      scc.last_update_tmstmp IS NULL "
            + "or     (scc.last_update_user_id IS NULL or scc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldPastDueNticeDelPrefRecsInCustomerContact
	
	public int pastDueNticeDelPrefRecsInGfsCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.glazier_invoice_distribution gid, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2 "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gid.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 9 "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    xref2.original_entity_id = scca.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end pastDueNticeDelPrefRecsInGfsCustContactAsgn
	
	public int invldPastDueNticeDelPrefRecsInGfsCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.glazier_invoice_distribution gid, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2 "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gid.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 9 "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    xref2.original_entity_id = scca.contact_id "
            + "and    ((scca.customer_contact_role_id IS NULL or scca.customer_contact_role_id <> 9) "
            + "or      scca.comment_txt IS NOT NULL "
            + "or      scca.last_update_tmstmp IS NULL "
            + "or     (scca.last_update_user_id IS NULL or scca.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldPastDueNticeDelPrefRecsInGfsCustContactAsgn
	
	public int pastDueNticeDelPrefRecsInCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact_mechanism sccm "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and   scca.customer_contact_role_id = 9 "
                + "and    scca.contact_id = sccm.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = sccm.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end pastDueNticeDelPrefRecsInCustomerContactMechanism
	
	public int invldPastDueNticeDelPrefRecsInCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
        + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
        + "       cust_stage_admin.glazier_invoice_distribution gid, "
        + "       cust_stage_admin.gfs_entity_xref xref, "
        + "       cust_stage_admin.gfs_entity_xref xref2, "
        + "       cust_stage_admin.customer_contact_mechanism sccm "
        + "where  xref.gfs_entity_type_code = 0 "
        + "and    xref.business_unit_code in (36,37) "
        + "and    xref.original_entity_id = gid.cust_nbr "
        + "and    xref.original_entity_id = scca.gfs_customer_id "
        + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
        + "and    scca.customer_contact_role_id = 9 "
        + "and    scca.contact_id = sccm.contact_id "
        + "and    xref2.gfs_entity_type_code = 98 "
        + "and    xref2.business_unit_code in (36,37) "
        + "and    xref2.original_entity_id = sccm.contact_id "
        + "and    ((sccm.contact_mechanism_prty_seq IS NULL or sccm.contact_mechanism_prty_seq <> 1) "
        + "or      (sccm.contact_mechanism_id IS NULL or sccm.contact_mechanism_id <> 5) "
        + "or       sccm.contact_mechanism_value <> gid.contact_1_email "
        + "or       sccm.last_update_tmstmp IS NULL "
        + "or      (sccm.last_update_user_id IS NULL or sccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldPastDueNticeDelPrefRecsInCustomerContactMechanism
	
	
	public int glzPrefRecsInStgCustDocProcOption(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.cust_doc_proc_option sdpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sdpo.gfs_customer_id "
                + "and    ((sdpo.document_proc_opt_code = 10 and sdpo.document_proc_opt_seq = 1) "
                + "or      (sdpo.document_proc_opt_code = 11 and sdpo.document_proc_opt_seq in (1,5)) "
                + "or      (sdpo.document_proc_opt_code = 12 and sdpo.document_proc_opt_seq in (1,5)))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInStgCustDocProcOption
	
	public int glzPrefRecsInTrgtCustDocProcOption(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.cust_doc_proc_option tdpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tdpo.gfs_customer_id "
                + "and    ((tdpo.document_proc_opt_code = 10 and tdpo.document_proc_opt_seq = 1) "
                + "or      (tdpo.document_proc_opt_code = 11 and tdpo.document_proc_opt_seq in (1,5)) "
                + "or      (tdpo.document_proc_opt_code = 12 and tdpo.document_proc_opt_seq in (1,5)))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInTrgtCustDocProcOption
	
	public int invalidGlzPrefRecsInTrgtCustDocProcOption(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.cust_doc_proc_option tdpo, "
                + "       cust_stage_admin.cust_doc_proc_option sdpo, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tdpo.gfs_customer_id "
                + "and    xref.original_entity_id = sdpo.gfs_customer_id "
                + "and    tdpo.document_proc_opt_code = sdpo.document_proc_opt_code "
                + "and    tdpo.document_proc_opt_seq = sdpo.document_proc_opt_seq "
                + "and    ((tdpo.document_proc_opt_code = 10 and tdpo.document_proc_opt_seq = 1) "
                + "or      (tdpo.document_proc_opt_code = 11 and tdpo.document_proc_opt_seq in (1,5)) "
                + "or      (tdpo.document_proc_opt_code = 12 and tdpo.document_proc_opt_seq in (1,5))) "
                + "and     (tdpo.last_update_tmstmp IS NULL "
                + "or      (tdpo.last_update_user_id IS NULL or tdpo.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//invalidGlzPrefRecsInTrgtCustDocProcOption
	
	public int glzPrefRecsInStgCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact scc "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id in (8,9) "
                + "and    scca.contact_id = scc.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    scc.contact_id = xref2.original_entity_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInStgCustomerContact
	
	public int glzPrefRecsInTrgtCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_admin.customer_contact tcc "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
                + "and    tcca.customer_contact_role_id in (8,9) "
                + "and    tcca.contact_id = tcc.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    tcc.contact_id = xref2.gfs_entity_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInTrgtCustomerContact
	
	public int invalidGlzPrefRecsInTrgtCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_admin.gfs_cust_contact_asgn tcca, "
            + "       cust_stage_admin.glazier_invoice_distribution gid, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2, "
            + "       cust_admin.customer_contact tcc "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gid.cust_nbr "
            + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
            + "and    tcca.customer_contact_role_id in (8,9) "
            + "and    tcca.contact_id = tcc.contact_id "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    tcc.contact_id = xref2.gfs_entity_id "
            + "and    (tcc.contact_name IS NOT NULL "
            + "or      tcc.site_id IS NOT NULL "
            + "or      tcc.last_update_tmstmp IS NULL "
            + "or     (tcc.last_update_user_id IS NULL or tcc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidGlzPrefRecsInTrgtCustomerContact
	
	public int glzPrefRecsInStgCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_stage_admin.customer_contact_mechanism sccm "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id in (8,9) "
                + "and    scca.contact_id = sccm.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = sccm.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInStgCustomerContactMechanism
	
	public int glzPrefRecsInTrgtCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_stage_admin.glazier_invoice_distribution gid, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_admin.customer_contact_mechanism tccm "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gid.cust_nbr "
                + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
                + "and    tcca.customer_contact_role_id in (8,9) "
                + "and    tcca.contact_id = tccm.contact_id "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.gfs_entity_id = tccm.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInTrgtCustomerContactMechanism
	
	public int invalidGlzPrefRecsInTrgtCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.customer_contact_mechanism sccm, "
                + "       cust_admin.customer_contact_mechanism tccm, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 98 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = sccm.contact_id "
                + "and    xref.gfs_entity_id = tccm.contact_id  "
                + "and    (tccm.contact_mechanism_prty_seq <> sccm.contact_mechanism_prty_seq "
                + "or      tccm.contact_mechanism_id <> sccm.contact_mechanism_id "
                + "or      tccm.contact_mechanism_value <> sccm.contact_mechanism_value "
                + "or      tccm.last_update_tmstmp IS NULL "
                + "or     (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidGlzPrefRecsInTrgtCustomerContactMechanism
	
	public int glzPrefRecsInStgCustPreferenceSelection(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from   cust_stage_admin.cust_preference_selection scps, "
                    + "       cust_stage_admin.gfs_entity_xref xref "
                    + "where  (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 102 "
                    + "and    scps.cust_preference_option_id = 3) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 104 "
                    + "and    scps.cust_preference_option_id > 1) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id " 
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 106 "
                    + "and    scps.cust_preference_option_id = 2) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 200 "
                    + "and    scps.cust_preference_option_id = 2) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 201 "
                    + "and    scps.cust_preference_option_id = 1) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 202 "
                    + "and    scps.cust_preference_option_id = 4) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 601 "
                    + "and    scps.cust_preference_option_id = 1) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 602 "
                    + "and    scps.cust_preference_option_id = 3) "
                    + "OR     (xref.gfs_entity_type_code = 0 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and    xref.original_entity_id = scps.gfs_customer_id "
                    + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                    + "and    scps.customer_preference_id = 605 "
                    + "and    scps.cust_preference_option_id = 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInStgCustPreferenceSelection
	
	public int glzPrefRecsInTrgtCustPreferenceSelection(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.cust_preference_selection tcps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 102 "
                + "and    tcps.cust_preference_option_id = 3) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 104 "
                + "and    tcps.cust_preference_option_id > 1) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 106 "
                + "and    tcps.cust_preference_option_id = 2) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 200 "
                + "and    tcps.cust_preference_option_id = 2) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 201 "
                + "and    tcps.cust_preference_option_id = 1) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 202 "
                + "and    tcps.cust_preference_option_id = 4) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 601 "
                + "and    tcps.cust_preference_option_id = 1) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 602 "
                + "and    tcps.cust_preference_option_id = 3) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = 605 "
                + "and    tcps.cust_preference_option_id = 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzPrefRecsInTrgtCustPreferenceSelection
	
	public int invalidGlzPrefRecsInTrgtPreferenceSelection(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.cust_preference_selection tcps, "
                + "       cust_stage_admin.cust_preference_selection scps, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "
                + "and    tcps.customer_preference_id = 100 "
                + "and    tcps.cust_preference_option_id = 4 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 101 "
                + "and    tcps.cust_preference_option_id = 1 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 102 "
                + "and    tcps.cust_preference_option_id = 3 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 104 "
                + "and    tcps.cust_preference_option_id > 1 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 106 "
                + "and    tcps.cust_preference_option_id = 2 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 200 "
                + "and    tcps.cust_preference_option_id = 2 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 201 "
                + "and    tcps.cust_preference_option_id = 1 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 202 "
                + "and    tcps.cust_preference_option_id = 4 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 601 "
                + "and    tcps.cust_preference_option_id = 1 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 602 "
                + "and    tcps.cust_preference_option_id = 3 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%'))) "
                + "OR     (xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scps.gfs_customer_type_code "
                + "and    xref.gfs_entity_id = tcps.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcps.gfs_customer_type_code "
                + "and    tcps.customer_preference_id = scps.customer_preference_id "
                + "and    tcps.cust_preference_option_id = scps.cust_preference_option_id "                
                + "and    tcps.customer_preference_id = 605 "
                + "and    tcps.cust_preference_option_id = 1 "
                + "and    (tcps.preference_option_value <> scps.preference_option_value "
                + "or      tcps.last_update_tmstmp IS NULL "
                + "or     (tcps.last_update_user_id IS NULL or tcps.last_update_user_id NOT LIKE 'Glazier%')))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invalidGlzPrefRecsInTrgtPreferenceSelection
        
        
}//end ShipToToCustomerPreferenceDaoImpl
