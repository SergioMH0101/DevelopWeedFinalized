package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_RegionDTO;

@Repository
@Transactional
public class AA_RegionDAOImpl implements AA_RegionDAO{

	private String list = "SELECT * FROM aa_region ORDER BY id_region";
	private String select = "SELECT * FROM aa_region WHERE id_region=?";
	private String insert = "INSERT INTO aa_region VALUES (?,?,?)";
	private String update = "UPDATE aa_region SET id_region=?, reg_nombre=?, id_pais=? "+
							"WHERE id_region=?";
	private String delete = "DELETE aa_region WHERE id_region=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_RegionDTO> list() {
		List<AA_RegionDTO> listAA_RegionDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_RegionDTO.class));
		return listAA_RegionDTO;
	}
	@Override
	public AA_RegionDTO get(String id_region) {
	    Object[] args = {id_region};
	    AA_RegionDTO aa_regionDTO;
	    
	    try {
	    	aa_regionDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_RegionDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_regionDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_regionDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_regionDTO;
	}
	@Override
	public int insert(AA_RegionDTO aa_regionDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_regionDTO.getId_region(),
	    		aa_regionDTO.getReg_nombre(),
	    		aa_regionDTO.getId_pais()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_RegionDTO aa_regionDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_regionDTO.getId_region(),
	    		aa_regionDTO.getReg_nombre(),
	    		aa_regionDTO.getId_pais()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_region) {
		int rows = 0;
	    Object[] args = {id_region};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
