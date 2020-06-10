package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_Tipo_De_TransporteDTO;

@Repository
@Transactional
public class AA_Tipo_De_TransporteDAOImpl implements AA_Tipo_De_TransporteDAO{
	
	private String list = "SELECT * FROM aa_tipo_de_transporte ORDER BY id_transporte";
	private String select = "SELECT * FROM aa_tipo_de_transporte WHERE id_transporte=?";
	private String insert = "INSERT INTO aa_tipo_de_transporte VALUES (?,?,?,?)";
	private String update = "UPDATE aa_tipo_de_transporte SET id_transporte=?, nombre_transporte=? "+
							"WHERE id_transporte=?";
	private String delete = "DELETE aa_tipo_de_transporte WHERE id_transporte=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_Tipo_De_TransporteDTO> list() {
		List<AA_Tipo_De_TransporteDTO> listAA_Tipo_De_TransporteDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_Tipo_De_TransporteDTO.class));
		return listAA_Tipo_De_TransporteDTO;
	}
	@Override
	public AA_Tipo_De_TransporteDTO get(String id_transporte) {
	    Object[] args = {id_transporte};
	    AA_Tipo_De_TransporteDTO aa_tipo_de_transporteDTO;
	    
	    try {
	    	aa_tipo_de_transporteDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_Tipo_De_TransporteDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_tipo_de_transporteDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_tipo_de_transporteDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_tipo_de_transporteDTO;
	}
	@Override
	public int insert(AA_Tipo_De_TransporteDTO aa_tipo_de_transporteDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_transporteDTO.getId_transporte(),
	    		aa_tipo_de_transporteDTO.getNombre_transporte()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_Tipo_De_TransporteDTO aa_tipo_de_transporteDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_transporteDTO.getId_transporte(),
	    		aa_tipo_de_transporteDTO.getNombre_transporte()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_transporte) {
		int rows = 0;
	    Object[] args = {id_transporte};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
