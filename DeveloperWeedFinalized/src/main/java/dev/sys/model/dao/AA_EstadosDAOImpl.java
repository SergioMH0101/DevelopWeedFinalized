package dev.sys.model.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_EstadosDTO;

@Repository
@Transactional
public class AA_EstadosDAOImpl implements AA_EstadosDAO{
	
	private String list = "SELECT * FROM aa_estados ORDER BY id_flujo";
	private String select = "SELECT * FROM aa_estados WHERE id_flujo=?";
	private String insert = "INSERT INTO aa_estados VALUES (?,?,?)";
	private String update = "UPDATE aa_estados SET id_flujo=?, id_estado=?, estado=? "+
							"WHERE id_flujo=?";
	private String delete = "DELETE aa_estados WHERE id_flujo=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_EstadosDTO> list() {
		List<AA_EstadosDTO> listAA_EstadosDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_EstadosDTO.class));
		return listAA_EstadosDTO;
	}
	@Override
	public AA_EstadosDTO get(String id_flujo) {
	    Object[] args = {id_flujo};
	    AA_EstadosDTO aa_estadosDTO;
	    
	    try {
	    	aa_estadosDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_EstadosDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_estadosDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_estadosDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_estadosDTO;
	}
	@Override
	public int insert(AA_EstadosDTO aa_estadosDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_estadosDTO.getId_flujo(),
	    		aa_estadosDTO.getId_estado(),
	    		aa_estadosDTO.getEstado()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_EstadosDTO aa_estadosDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_estadosDTO.getId_flujo(),
	    		aa_estadosDTO.getId_estado(),
	    		aa_estadosDTO.getEstado()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_agente) {
		int rows = 0;
	    Object[] args = {id_agente};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
