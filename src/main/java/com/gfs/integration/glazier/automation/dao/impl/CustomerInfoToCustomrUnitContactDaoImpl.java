package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.gfs.integration.glazier.automation.dao.CustomerInfoToCustomrUnitContactDao;

public class CustomerInfoToCustomrUnitContactDaoImpl extends NamedParameterJdbcTemplate implements CustomerInfoToCustomrUnitContactDao{

	public CustomerInfoToCustomrUnitContactDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}//end CustomerInfoToCustomrUnitContactDaoImpl
	
	public int glzCustRecords(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from   cust_stage_admin.glazier_customer gc "
                    + "where  gc.valid_record_ind=1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end glzCustRecords
	
	public int shpToCustContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.customer_contact scc, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 1 "
                + "and    scca.contact_id = scc.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end shpToCustContact
	
	public int invldShptoStgCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.customer_contact scc, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.glazier_customer gc "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gc.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 1 "
            + "and    scca.contact_id = scc.contact_id "
            + "and    (scc.contact_name <> gc.ship_to_addr_line_2 "
            + "or      scc.site_id IS NOT NULL "
            + "or      scc.last_update_tmstmp IS NULL "
            + "or     (scc.last_update_user_id IS NULL or scc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldShptoStgCustomerContact
	
	
	public int shpToCustContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.customer_contact_mechanism sccm, "
                + "       cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.contact_id = sccm.contact_id "
                + "and    scca.customer_contact_role_id = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end shpToCustContact
	

	public int invldStgShipToCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.customer_contact_mechanism sccm, "
            + "       cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.glazier_customer gc "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = gc.cust_nbr "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.contact_id = sccm.contact_id "
            + "and    scca.customer_contact_role_id = 1 "
            + "and    ((sccm.contact_mechanism_prty_seq IS NULL or sccm.contact_mechanism_prty_seq <> 1) "
            + "or      (sccm.contact_mechanism_id IS NULL or sccm.contact_mechanism_id <> 1) "
            + "or       sccm.contact_mechanism_value <> gc.ship_to_phone_nbr "
            + "or       sccm.last_update_tmstmp IS NULL "
            + "or      (sccm.last_update_user_id IS NULL or sccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldStgShipToCustomerContactMechanism
	
	
	public int shpToCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2 "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 1 "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    xref2.original_entity_id = scca.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end shpToCustContactAsgn
	
	
	public int invldStgShipToCustomerContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2 "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 1 "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) " 
            + "and    xref2.original_entity_id = scca.contact_id "
            + "and    (scca.comment_txt IS NOT NULL "
            + "or      scca.last_update_tmstmp IS NULL "
            + "or     (scca.last_update_user_id IS NULL or scca.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldStgShipToCustomerContactAsgn
	
	public int targetShpToCustContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_admin.gfs_cust_contact_asgn tcca, "
            + "       cust_admin.customer_contact tcc, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
            + "and    tcca.customer_contact_role_id = 1 "
            + "and    tcca.contact_id = tcc.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end stgShipToRecsCustomerContact
	
	public int trgtInvldShptoStgCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from CUST_ADMIN.CUSTOMER_CONTACT gcon where gcon.last_update_user_id like 'Glazie%' and "
        		+ " (gcon.site_id is not null or gcon.last_update_tmstmp is null or gcon.contact_id is null)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtInvldShptoStgCustomerContact
	
	public int invldTrgtShipToCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_admin.gfs_cust_contact_asgn tcca, "
            + "       cust_admin.customer_contact tcc, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.customer_contact scc "
            + "where  xref.gfs_entity_type_code = 98 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.gfs_entity_id = tcca.contact_id "
            + "and    xref.original_entity_id = scc.contact_id "
            + "and    tcca.customer_contact_role_id = 1 "
            + "and    tcca.contact_id = tcc.contact_id "
            + "and    (tcc.contact_name <> scc.contact_name "
            + "and     tcc.site_id IS NOT NULL "
            + "and     tcc.last_update_tmstmp IS NULL "
            + "and    (tcc.last_update_user_id IS NULL or tcc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldTrgtShipToCustomerContact
	
	public int trgtShpToCustContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.customer_contact_mechanism tccm, "
                + "       cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
                + "and    tcca.contact_id = tccm.contact_id "
                + "and    tcca.customer_contact_role_id = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtShpToCustContactMechanism
	
	public int invldTrgtShipToCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_admin.customer_contact_mechanism tccm, "
            + "       cust_admin.gfs_cust_contact_asgn tcca, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.customer_contact_mechanism sccm "
            + "where  xref.gfs_entity_type_code = 98 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.gfs_entity_id = tcca.contact_id "
            + "and    xref.original_entity_id = sccm.contact_id "
            + "and    tcca.contact_id = tccm.contact_id "
            + "and    tcca.customer_contact_role_id = 1 "
            + "and    ((tccm.contact_mechanism_prty_seq IS NULL or tccm.contact_mechanism_prty_seq <> 1) "
            + "or      (tccm.contact_mechanism_id IS NULL or tccm.contact_mechanism_id <> 1) "
            + "or       tccm.contact_mechanism_value <> sccm.contact_mechanism_value "
            + "or       tccm.last_update_tmstmp IS NULL "
            + "or      (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldTrgtShipToCustomerContactMechanism
	
	public int trgtShpToCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
                + "and    tcca.customer_contact_role_id = 1 "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.gfs_entity_id = tcca.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end trgtShpToCustContactAsgn

	public int invldTrgtShipToCustomerContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
        + "from   cust_admin.gfs_cust_contact_asgn tcca, "
        + "       cust_stage_admin.gfs_entity_xref xref, "
        + "       cust_stage_admin.gfs_entity_xref xref2 "
        + "where  xref.gfs_entity_type_code = 0 "
        + "and    xref.business_unit_code in (36,37) "
        + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
        + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
        + "and    tcca.customer_contact_role_id = 1 "
        + "and    xref2.gfs_entity_type_code = 98 "
        + "and    xref2.business_unit_code in (36,37) "
        + "and    xref2.gfs_entity_id = tcca.contact_id "
        + "and    (tcca.comment_txt IS NOT NULL "
        + "or      tcca.last_update_tmstmp IS NULL "
        + "or     (tcca.last_update_user_id IS NULL or tcca.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldTrgtShipToCustomerContactAsgn
	
	
	public int bilToRecdsGlzCustomer(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.bill_to_phone_nbr <> 0 "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsGlzCustomer
	
	public int bilToRecdsStgCustContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.customer_contact scc, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.customer_contact_role_id = 2 "
            + "and    scca.contact_id = scc.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsStgCustContact
	
	public int invldStgBillToCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.customer_contact scc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_customer gc "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 2 "
                + "and    scca.contact_id = scc.contact_id "
                + "and    (scc.contact_name IS NOT NULL "
                + "or      scc.site_id IS NOT NULL "
                + "or      scc.last_update_tmstmp IS NULL "
                + "or     (scc.last_update_user_id IS NULL or scc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldStgBillToCustomerContact
	
	public int bilToRecdsStgCustContactMechansm(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_stage_admin.customer_contact_mechanism sccm, "
            + "       cust_stage_admin.gfs_cust_contact_asgn scca, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.original_entity_id = scca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
            + "and    scca.contact_id = sccm.contact_id "
            + "and    scca.customer_contact_role_id = 2";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsStgCustContactMechansm
	
	public int invldStBilToCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.customer_contact_mechanism sccm, "
                + "       cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.glazier_customer gc "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = gc.cust_nbr "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.contact_id = sccm.contact_id "
                + "and    scca.customer_contact_role_id = 2 "
                + "and    ((sccm.contact_mechanism_prty_seq IS NULL or sccm.contact_mechanism_prty_seq <> 2) "
                + "or      (sccm.contact_mechanism_id IS NULL or sccm.contact_mechanism_id <> 1) "
                + "or       sccm.contact_mechanism_value <> gc.bill_to_phone_nbr "
                + "or       sccm.last_update_tmstmp IS NULL "
                + "or      (sccm.last_update_user_id IS NULL or sccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldStBilToCustomerContactMechanism
	
	public int bilToRecdsStgCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 2 "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = scca.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsStgCustContactAsgn
	
	public int invldStBilToCustomerContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_cust_contact_asgn scca, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.original_entity_id = scca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = scca.gfs_customer_type_code "
                + "and    scca.customer_contact_role_id = 2 "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.original_entity_id = scca.contact_id "
                + "and    (scca.comment_txt IS NOT NULL "
                + "or      scca.last_update_tmstmp IS NULL "
                + "or     (scca.last_update_user_id IS NULL or scca.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldStBilToCustomerContactAsgn
	
	public int bilToRecdsTrgtCustContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_admin.customer_contact tcc, "
                + "       cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
                + "and    tcca.customer_contact_role_id = 2 "
                + "and    tcca.contact_id = tcc.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsTrgtCustContact
	
	public int invldTrgtBillToCustomerContact(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_admin.customer_contact tcc, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.customer_contact scc "
                + "where  xref.gfs_entity_type_code = 98 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.contact_id "
                + "and    xref.original_entity_id = scc.contact_id "
                + "and    tcca.customer_contact_role_id = 2 "
                + "and    tcca.contact_id = tcc.contact_id "
                + "and    (tcc.contact_name <> scc.contact_name "
                + "and     tcc.site_id IS NOT NULL "
                + "and     tcc.last_update_tmstmp IS NULL "
                + "and    (tcc.last_update_user_id IS NULL or tcc.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldTrgtBillToCustomerContact
	
	public int bilToRecdsTrgtCustContactMechansm(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_admin.customer_contact_mechanism tccm, "
            + "       cust_admin.gfs_cust_contact_asgn tcca, "
            + "       cust_stage_admin.gfs_entity_xref xref "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
            + "and    tcca.contact_id = tccm.contact_id "
            + "and    tcca.customer_contact_role_id = 2";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsTrgtCustContactMechansm
	
	public int invldTrgtBilToCustomerContactMechanism(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.customer_contact_mechanism tccm, "
                + "       cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.customer_contact_mechanism sccm "
                + "where  xref.gfs_entity_type_code = 98 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.contact_id "
                + "and    xref.original_entity_id = sccm.contact_id "
                + "and    tcca.contact_id = tccm.contact_id "
                + "and    tcca.customer_contact_role_id = 2 "
                + "and    ((tccm.contact_mechanism_prty_seq IS NULL or tccm.contact_mechanism_prty_seq <> 2) "
                + "or      (tccm.contact_mechanism_id IS NULL or tccm.contact_mechanism_id <> 1) "
                + "or       tccm.contact_mechanism_value <> sccm.contact_mechanism_value "
                + "or       tccm.last_update_tmstmp IS NULL "
                + "or      (tccm.last_update_user_id IS NULL or tccm.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldTrgtBilToCustomerContactMechanism
	
	public int bilToRecdsTrgtCustContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_admin.gfs_cust_contact_asgn tcca, "
                + "       cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2 "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
                + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
                + "and    tcca.customer_contact_role_id = 2 "
                + "and    xref2.gfs_entity_type_code = 98 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.gfs_entity_id = tcca.contact_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end bilToRecdsTrgtCustContactAsgn
	
	public int invldTrgtBilToCustomerContactAsgn(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
            + "from   cust_admin.gfs_cust_contact_asgn tcca, "
            + "       cust_stage_admin.gfs_entity_xref xref, "
            + "       cust_stage_admin.gfs_entity_xref xref2 "
            + "where  xref.gfs_entity_type_code = 0 "
            + "and    xref.business_unit_code in (36,37) "
            + "and    xref.gfs_entity_id = tcca.gfs_customer_id "
            + "and    xref.gfs_entity_type_code = tcca.gfs_customer_type_code "
            + "and    tcca.customer_contact_role_id = 2 "
            + "and    xref2.gfs_entity_type_code = 98 "
            + "and    xref2.business_unit_code in (36,37) "
            + "and    xref2.gfs_entity_id = tcca.contact_id "
            + "and    (tcca.comment_txt IS NOT NULL "
            + "or      tcca.last_update_tmstmp IS NULL "
            + "or     (tcca.last_update_user_id IS NULL or tcca.last_update_user_id NOT LIKE 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldTrgtBilToCustomerContactAsgn
	
	public int billToShipToRcrdsGfsEntityXref1(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_entity_xref xref, "
                + "       cust_stage_admin.gfs_entity_xref xref2, "
                + "       cust_admin.gfs_cust_contact_asgn tcca "
                + "where  xref.gfs_entity_type_code = 98 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    xref.gfs_entity_id = tcca.contact_id "
                + "and    tcca.customer_contact_role_id in (1,2) "
                + "and    xref2.gfs_entity_type_code = 0 "
                + "and    xref2.business_unit_code in (36,37) "
                + "and    xref2.gfs_entity_id = tcca.gfs_customer_id";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end billToShipToRcrdsGfsEntityXref
	
//	public int billToShipToRcrdsGfsEntityXref2(){
//		final SqlParameterSource paramMap = null;
        
//        String sql = "select count(gx.original_entity_id) from CUST_STAGE_ADMIN.GFS_ENTITY_XREF gx "
//        		+ " where gx.gfs_entity_type_code=98 and gx.original_entity_id in"
//        		+ " (select distinct(gc.cust_nbr) from CUST_STAGE_ADMIN.Glazier_customer gc)";
        
//        String result = this.queryForObject(sql,paramMap,String.class);	
//        return Integer.parseInt(result);
//	}//end billToShipToRcrdsGfsEntityXref
	
	public int invldGfsEntityXref(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code=98 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    (xref.original_entity_id IS NULL "
                + "or     xref.gfs_entity_id IS NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end invldGfsEntityXref
        
	public int countGlzShipToBillToContacts(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) from ( "
                + "select gc.cust_nbr "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.valid_record_ind = 1 "
                + "UNION ALL "
                + "select gc.cust_nbr "
                + "from   cust_stage_admin.glazier_customer gc "
                + "where  gc.bill_to_phone_nbr <> 0 "
                + "and    gc.valid_record_ind = 1)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlzShipToBillToContacts
        
}//end CustomerInfoToCustomrUnitContactDaoImpl
