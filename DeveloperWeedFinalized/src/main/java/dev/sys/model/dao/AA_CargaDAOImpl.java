package dev.sys.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_CargaDTO;
@Repository
@Transactional
public class AA_CargaDAOImpl implements AA_CargaDAO {
	private String list = "SELECT * FROM aa_carga ORDER BY id_carga";
	private String select = "SELECT * FROM aa_carga WHERE id_carga=?";
	private String insert = "INSERT INTO aa_carga VALUES (?,?,?,?)";
	private String update = "UPDATE aa_carga SET id_carga=?, nombre_carga=? WHERE id_carga=?";
	private String delete = "DELETE aa_carga WHERE id_carga=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_CargaDTO> list() {
		List<AA_CargaDTO> listAA_CargaDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_CargaDTO.class));
		return listAA_CargaDTO;
	}
	@Override
	public AA_CargaDTO get(String id_carga) {
	    Object[] args = {id_carga};
	    AA_CargaDTO aa_cargaDTO;
	    
	    try {
	    	aa_cargaDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_CargaDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_cargaDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_cargaDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_cargaDTO;
	}
	@Override
	public int insert(AA_CargaDTO aa_cargaDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_cargaDTO.getId_carga(),
	    		aa_cargaDTO.getNombre_carga(),
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_CargaDTO aa_cargaDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_cargaDTO.getId_carga(),
	    		aa_cargaDTO.getNombre_carga(),
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_carga) {
		int rows = 0;
	    Object[] args = {id_carga};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

	

}
