package dev.sys.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_ConsignanteDTO;

@Repository
@Transactional
public class AA_ConsignanteDAOImpl implements AA_ConsignanteDAO{
	
	private String list = "SELECT * FROM aa_consignante ORDER BY id_consignante";
	private String select = "SELECT * FROM aa_consignante WHERE id_consignante=?";
	private String insert = "INSERT INTO aa_consignante VALUES (?,?,?,?,?,?,?)";
	private String update = "UPDATE aa_consignante SET id_consignante=?, nom_consignante=?, id_giro=?, direccion=?, "+
							"id_comuna=?, telefono=?, contacto=? WHERE id_consignante=?";
	private String delete = "DELETE aa_consignante WHERE id_consignante=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_ConsignanteDTO> list() {
		List<AA_ConsignanteDTO> listAA_ConsignanteDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_ConsignanteDTO.class));
		return listAA_ConsignanteDTO;
	}
	@Override
	public AA_ConsignanteDTO get(String id_consignante) {
	    Object[] args = {id_consignante};
	    AA_ConsignanteDTO aa_consignanteDTO;
	    
	    try {
	    	aa_consignanteDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_ConsignanteDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_consignanteDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_consignanteDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_consignanteDTO;
	}
	@Override
	public int insert(AA_ConsignanteDTO aa_consignanteDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_consignanteDTO.getId_consignante(),
	    		aa_consignanteDTO.getNom_consignante(),
	    		aa_consignanteDTO.getId_giro(),
	    		aa_consignanteDTO.getDireccion(),
	    		aa_consignanteDTO.getId_comuna(),
	    		aa_consignanteDTO.getTelefono(),
	    		aa_consignanteDTO.getContacto()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_ConsignanteDTO aa_consignanteDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_consignanteDTO.getId_consignante(),
	    		aa_consignanteDTO.getNom_consignante(),
	    		aa_consignanteDTO.getId_giro(),
	    		aa_consignanteDTO.getDireccion(),
	    		aa_consignanteDTO.getId_comuna(),
	    		aa_consignanteDTO.getTelefono(),
	    		aa_consignanteDTO.getContacto()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_consignante) {
		int rows = 0;
	    Object[] args = {id_consignante};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
