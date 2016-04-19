package com.gfs.integration.glazier.automation.dao.impl;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gfs.integration.glazier.automation.dao.GlazierCustomerNoteToGfsCustomerNoteDao;

public class GlazierCustomerNoteToGfsCustomerNoteDaoImpl extends NamedParameterJdbcTemplate implements GlazierCustomerNoteToGfsCustomerNoteDao{
	
	public GlazierCustomerNoteToGfsCustomerNoteDaoImpl(final DataSource dataSource) {
		super(dataSource);
	}//end CustomerInfoToCustomrUnitContactDaoImpl
	
	public int countGlazierCustomerNotes(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_customer_note gcn "
                + "where  gc.cust_nbr = gcn.cust_nbr "
                + "and    gc.valid_record_ind = 1 "
                + "and    gcn.note_text IS NOT NULL";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGlazierCustomerNotes

	public int countDistinctGlazierCustomerNotes(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(distinct gcn.cust_nbr) "
                + "from   cust_stage_admin.glazier_customer gc, "
                + "       cust_stage_admin.glazier_customer_note gcn "
                + "where  gc.cust_nbr = gcn.cust_nbr "
                + "and    gc.valid_record_ind = 1";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countDistinctGlazierCustomerNotes
        
	public int countStagedGFSCustomerNotes(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                   + "from   cust_stage_admin.gfs_customer_note";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
        
	}//countStagedGFSCustomerNotes
	
	
	public int countStagedGFSCustomerNotesWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from  (select GCN.CUST_NBR   GCN_CUST_NBR, "
                + "                   GCN.NOTE_LINE_NBR GCN_NOTE_LINE_NBR, "
                + "                   GCN.NOTE_TEXT GCN_NOTE_TEXT, "
                + "                   tg_total_Note_Records, "
                + "                   row_number() over (partition by GCN.CUST_NBR order by GCN.NOTE_LINE_NBR asc) tobe_seq_nbr, "
                + "                   (to_date('13-jun-15', 'DD-MON-RR') - (tg_total_Note_Records - row_number() "
                + "                    over (partition by GCN.CUST_NBR order by GCN.NOTE_LINE_NBR asc)  )) tobe_adddate "
                + "            from cust_stage_admin.glazier_customer_note gcn "
                + "                    join (select CGCN.cust_nbr CGCN_CUST_NBR, "
                + "                               count(*) tg_total_Note_Records "
                + "                              from CUST_Stage_ADMIN.glazier_customer_note Cgcn "
                + "                              group by cGCN.cust_nbr ) cgcn "
                + "                            on GCN.CUST_NBR = cGCN_CUST_NBR "
                + "            where GCN.CUST_NBR in "
                + "                      (Select distinct GCN.CUST_NBR "
                + "                        from CUST_Stage_ADMIN.glazier_customer_note gcn) "
                + "            and GCN.NOTE_TEXT is not null "
                + "            order by GCN.CUST_NBR asc) "
                + "            join cust_stage_admin.gfs_entity_xref xref "
                + "                 on xref.original_entity_id = GCN_CUST_NBR and "
                + "                    xref.gfs_entity_type_code = 0 "
                + "            join cust_stage_admin.gfs_customer_note scn "
                + "                 on xref.original_entity_id = scn.gfs_customer_id "
                + "            join cust_stage_admin.glazier_customer gc "
                + "                 on xref.original_entity_id = gc.cust_nbr "
                + "where  xref.gfs_entity_type_code = 0 "
                + "and    gc.valid_record_ind = 1 "
                + "and    xref.business_unit_code in (36,37) "
                + "and SCN.CUSTOMER_NOTE_SEQ = tobe_seq_nbr "
                + "and (GCN_NOTE_TEXT <> SCN.CUSTOMER_NOTE_TXT "
                + "or SCN.ADDED_DATE <> tobe_adddate "
                + "or (SCN.NOTE_TYPE_CODE is null or "
                + "      SCN.NOTE_TYPE_CODE <> 1) "
                + "or SCN.CUSTOMER_NOTE_TXT is null "
                + "or SCN.NOTE_DATE is not null "
                + "or SCN.LAST_UPDATE_TMSTMP is null "
                + "or (SCN.LAST_UPDATE_USER_ID is null or "
                + "     SCN.LAST_UPDATE_USER_ID not like 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
        
	}//end countStagedGFSCustomerNotesWithInvalidFields
	
	public int count1stStgGFSCustNoteWithInvalidAddDate(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_customer_note sgcn "
                + "where  sgcn.customer_note_seq = 1 "
                + "and    sgcn.added_date <> to_date('6/13/2015','MM/DD/YYYY')";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
        
	}//end count1stStgGFSCustNoteWithInvalidAddDate
	
	public int countTargetGFSCustomerNotes(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from  cust_admin.gfs_customer_note tcn "
                + "where tcn.last_update_user_id LIKE 'Glazier%'";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
        
	}//end countTargetGFSCustomerNotes
	
	public int countTargetGFSCustomerNotesWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                    + "from  (select GCN.CUST_NBR   GCN_CUST_NBR, "
                    + "                   GCN.NOTE_LINE_NBR GCN_NOTE_LINE_NBR, "
                    + "                   GCN.NOTE_TEXT        GCN_NOTE_TEXT, "
                    + "                   tg_total_Note_Records, "
                    + "                   row_number() over (partition by GCN.CUST_NBR order by GCN.NOTE_LINE_NBR asc) tobe_seq_nbr, "
                    + "                   (to_date('13-jun-15', 'DD-MON-RR') - (tg_total_Note_Records - row_number() "
                    + "                    over (partition by GCN.CUST_NBR order by GCN.NOTE_LINE_NBR asc)  )) tobe_adddate "
                    + "            from cust_stage_admin.glazier_customer_note gcn "
                    + "                    join (select CGCN.cust_nbr CGCN_CUST_NBR, "
                    + "                               count(*) tg_total_Note_Records "
                    + "                              from CUST_Stage_ADMIN.glazier_customer_note Cgcn "
                    + "                              group by cGCN.cust_nbr ) cgcn "
                    + "                            on GCN.CUST_NBR = cGCN_CUST_NBR "
                    + "            where GCN.CUST_NBR in "
                    + "                      (Select distinct GCN.CUST_NBR "
                    + "                        from CUST_Stage_ADMIN.glazier_customer_note gcn) "
                    + "            and GCN.NOTE_TEXT is not null "
                    + "            order by GCN.CUST_NBR asc) "
                    + "            join cust_stage_admin.gfs_entity_xref xref "
                    + "                 on xref.original_entity_id = GCN_CUST_NBR and "
                    + "                    xref.gfs_entity_type_code = 0 "
                    + "            join cust_admin.gfs_customer_note tgcn "
                    + "                 on xref.gfs_entity_id = tgcn.gfs_customer_id "
                    + "            join cust_stage_admin.glazier_customer gc "
                    + "                 on xref.original_entity_id = gc.cust_nbr "
                    + "where  xref.gfs_entity_type_code = 0 "
                    + "and    gc.valid_record_ind = 1 "
                    + "and    xref.business_unit_code in (36,37) "
                    + "and tgCN.CUSTOMER_NOTE_SEQ = tobe_seq_nbr "
                    + "and (GCN_NOTE_TEXT <> tgCN.CUSTOMER_NOTE_TXT "
                    + "or tgCN.ADDED_DATE <> tobe_adddate "
                    + "or (tgCN.NOTE_TYPE_CODE is null or "
                    + "      tgCN.NOTE_TYPE_CODE <> 1) "
                    + "or tgCN.CUSTOMER_NOTE_TXT is null "
                    + "or tgCN.NOTE_DATE is not null "
                    + "or tgCN.LAST_UPDATE_TMSTMP is null "
                    + "or (tgCN.LAST_UPDATE_USER_ID is null or "
                    + "     tgCN.LAST_UPDATE_USER_ID not like 'Glazier%'))";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countTargetGFSCustomerNotesWithInvalidFields
	
	public int countCustomerNotesInEntityXref(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 97 "
                + "and    xref.business_unit_code in (36,37)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countCustomerNotesInEntityXref
	
	public int countGFSEntityXrefWithInvalidFields(){
		final SqlParameterSource paramMap = null;
        
        String sql = "select count(*) "
                + "from   cust_stage_admin.gfs_entity_xref xref "
                + "where  xref.gfs_entity_type_code = 97 "
                + "and    xref.business_unit_code in (36,37) "
                + "and    (xref.original_entity_id IS NULL "
                + "or     xref.gfs_entity_id IS NULL)";
        
        String result = this.queryForObject(sql,paramMap,String.class);	
        return Integer.parseInt(result);
	}//end countGFSEntityXrefWithInvalidFields
        
}//end GlazierCustomerNoteToGfsCustomerNoteDaoImpl
