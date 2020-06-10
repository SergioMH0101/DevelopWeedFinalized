package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_NavieraDTO;

@Repository
@Transactional
public class AA_NavieraDAOImpl implements AA_NavieraDAO{
	private String list = "SELECT * FROM aa_naviera ORDER BY id_naviera";
	private String select = "SELECT * FROM aa_naviera WHERE id_naviera=?";
	private String insert = "INSERT INTO aa_naviera VALUES (?,?)";
	private String update = "UPDATE aa_naviera SET id_naviera=?, nombre_naviera=? "+
							"WHERE id_naviera=?";
	private String delete = "DELETE aa_naviera WHERE id_naviera=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_NavieraDTO> list() {
		List<AA_NavieraDTO> listAA_NavieraDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_NavieraDTO.class));
		return listAA_NavieraDTO;
	}
	@Override
	public AA_NavieraDTO get(String id_naviera) {
	    Object[] args = {id_naviera};
	    AA_NavieraDTO aa_navieraDTO;
	    
	    try {
	    	aa_navieraDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_NavieraDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_navieraDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_navieraDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_navieraDTO;
	}
	@Override
	public int insert(AA_NavieraDTO aa_navieraDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_navieraDTO.getId_naviera(),
	    		aa_navieraDTO.getNombre_naviera()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_NavieraDTO aa_navieraDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_navieraDTO.getId_naviera(),
	    		aa_navieraDTO.getNombre_naviera()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_naviera) {
		int rows = 0;
	    Object[] args = {id_naviera};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
