package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_IncotermsDTO;

@Repository
@Transactional
public class AA_IncotermsDAOImpl implements AA_IncotermsDAO{
	private String list = "SELECT * FROM aa_incoterms ORDER BY id_incoterms";
	private String select = "SELECT * FROM aa_incoterms WHERE id_incoterms=?";
	private String insert = "INSERT INTO aa_incoterms VALUES (?,?)";
	private String update = "UPDATE aa_incoterms SET id_incoterms=?, nom_incoterms=? "+
							"WHERE id_incoterms=?";
	private String delete = "DELETE aa_incoterms WHERE id_incoterms=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_IncotermsDTO> list() {
		List<AA_IncotermsDTO> listAA_IncotermsDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_IncotermsDTO.class));
		return listAA_IncotermsDTO;
	}
	@Override
	public AA_IncotermsDTO get(String id_incoterms) {
	    Object[] args = {id_incoterms};
	    AA_IncotermsDTO aa_incotermsDTO;
	    
	    try {
	    	aa_incotermsDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_IncotermsDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_incotermsDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_incotermsDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_incotermsDTO;
	}
	@Override
	public int insert(AA_IncotermsDTO aa_incotermsDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_incotermsDTO.getId_incoterms(),
	    		aa_incotermsDTO.getNom_incoterms()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_IncotermsDTO aa_incotermsDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_incotermsDTO.getId_incoterms(),
	    		aa_incotermsDTO.getNom_incoterms()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_incoterms) {
		int rows = 0;
	    Object[] args = {id_incoterms};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
