package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_GirosDTO;

@Repository
@Transactional
public class AA_GirosDAOImpl implements AA_GirosDAO{
	private String list = "SELECT * FROM aa_giros ORDER BY id_giro";
	private String select = "SELECT * FROM aa_giros WHERE id_giro=?";
	private String insert = "INSERT INTO aa_giros VALUES (?,?)";
	private String update = "UPDATE aa_giros SET id_giro=?, nom_giro=? "+
							"WHERE id_giro=?";
	private String delete = "DELETE aa_giros WHERE id_giro=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_GirosDTO> list() {
		List<AA_GirosDTO> listAA_GirosDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_GirosDTO.class));
		return listAA_GirosDTO;
	}
	@Override
	public AA_GirosDTO get(String id_giro) {
	    Object[] args = {id_giro};
	    AA_GirosDTO aa_girosDTO;
	    
	    try {
	    	aa_girosDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_GirosDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_girosDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_girosDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_girosDTO;
	}
	@Override
	public int insert(AA_GirosDTO aa_girosDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_girosDTO.getId_giro(),
	    		aa_girosDTO.getNom_giro()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_GirosDTO aa_girosDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_girosDTO.getId_giro(),
	    		aa_girosDTO.getNom_giro()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_giro) {
		int rows = 0;
	    Object[] args = {id_giro};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	

}
