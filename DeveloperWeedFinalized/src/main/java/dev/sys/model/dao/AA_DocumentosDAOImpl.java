package dev.sys.model.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_DocumentosDTO;

@Repository
@Transactional
public class AA_DocumentosDAOImpl implements AA_DocumentosDAO{
	private String list = "SELECT * FROM aa_documentos ORDER BY id_doc";
	private String select = "SELECT * FROM aa_documentos WHERE id_doc=?";
	private String insert = "INSERT INTO aa_documentos VALUES (?,?)";
	private String update = "UPDATE aa_documentos SET id_doc=?, documentos=? "+
							"WHERE id_doc=?";
	private String delete = "DELETE aa_documentos WHERE id_doc=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_DocumentosDTO> list() {
		List<AA_DocumentosDTO> listAA_DocumentosDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_DocumentosDTO.class));
		return listAA_DocumentosDTO;
	}
	@Override
	public AA_DocumentosDTO get(String id_doc) {
	    Object[] args = {id_doc};
	    AA_DocumentosDTO aa_documentosDTO;
	    
	    try {
	    	aa_documentosDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_DocumentosDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_documentosDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_documentosDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_documentosDTO;
	}
	@Override
	public int insert(AA_DocumentosDTO aa_documentosDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_documentosDTO.getId_doc(),
	    		aa_documentosDTO.getDocumentos()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_DocumentosDTO aa_documentosDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_documentosDTO.getId_doc(),
	    		aa_documentosDTO.getDocumentos()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_doc) {
		int rows = 0;
	    Object[] args = {id_doc};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
