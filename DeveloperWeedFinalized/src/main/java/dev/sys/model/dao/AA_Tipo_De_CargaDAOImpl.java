package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_Tipo_De_CargaDTO;

@Repository
@Transactional
public class AA_Tipo_De_CargaDAOImpl implements AA_Tipo_De_CargaDAO{
	
	private String list = "SELECT * FROM aa_tipo_de_carga ORDER BY id_ticarga";
	private String select = "SELECT * FROM aa_tipo_de_carga WHERE id_ticarga=?";
	private String insert = "INSERT INTO aa_tipo_de_carga VALUES (?,?)";
	private String update = "UPDATE aa_tipo_de_carga SET id_ticarga=?, nom_ticargae=? "+
							"WHERE id_ticarga=?";
	private String delete = "DELETE aa_tipo_de_carga WHERE id_ticarga=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_Tipo_De_CargaDTO> list() {
		List<AA_Tipo_De_CargaDTO> listAA_Tipo_De_CargaDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_Tipo_De_CargaDTO.class));
		return listAA_Tipo_De_CargaDTO;
	}
	@Override
	public AA_Tipo_De_CargaDTO get(String id_ticarga) {
	    Object[] args = {id_ticarga};
	    AA_Tipo_De_CargaDTO aa_tipo_de_cargaDTO;
	    
	    try {
	    	aa_tipo_de_cargaDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_Tipo_De_CargaDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_tipo_de_cargaDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_tipo_de_cargaDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_tipo_de_cargaDTO;
	}
	@Override
	public int insert(AA_Tipo_De_CargaDTO aa_tipo_de_cargaDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_cargaDTO.getId_ticarga(),
	    		aa_tipo_de_cargaDTO.getNom_ticarga()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_Tipo_De_CargaDTO aa_tipo_de_cargaDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_cargaDTO.getId_ticarga(),
	    		aa_tipo_de_cargaDTO.getNom_ticarga()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_ticarga) {
		int rows = 0;
	    Object[] args = {id_ticarga};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
