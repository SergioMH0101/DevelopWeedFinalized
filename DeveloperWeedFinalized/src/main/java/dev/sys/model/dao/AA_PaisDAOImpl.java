package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_PaisDTO;

@Repository
@Transactional
public class AA_PaisDAOImpl implements AA_PaisDAO{
	
	private String list = "SELECT * FROM aa_pais ORDER BY paiscodigo";
	private String select = "SELECT * FROM aa_pais WHERE paiscodigo=?";
	private String insert = "INSERT INTO aa_pais VALUES (?,?,?,?)";
	private String update = "UPDATE aa_pais SET paiscodigo=?, paisnombre=?, paiscontinente=?, paisregion=? "+
							"WHERE paiscodigo=?";
	private String delete = "DELETE aa_pais WHERE paiscodigo=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_PaisDTO> list() {
		List<AA_PaisDTO> listAA_PaisDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_PaisDTO.class));
		return listAA_PaisDTO;
	}
	@Override
	public AA_PaisDTO get(String paiscodigo) {
	    Object[] args = {paiscodigo};
	    AA_PaisDTO aa_paisDTO;
	    
	    try {
	    	aa_paisDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_PaisDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_paisDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_paisDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_paisDTO;
	}
	@Override
	public int insert(AA_PaisDTO aa_paisDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_paisDTO.getPaiscodigo(),
	    		aa_paisDTO.getPaisnombre(),
	    		aa_paisDTO.getPaiscontinente(),
	    		aa_paisDTO.getPaisregion()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_PaisDTO aa_paisDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_paisDTO.getPaiscodigo(),
	    		aa_paisDTO.getPaisnombre(),
	    		aa_paisDTO.getPaiscontinente(),
	    		aa_paisDTO.getPaisregion()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String paiscodigo) {
		int rows = 0;
	    Object[] args = {paiscodigo};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
