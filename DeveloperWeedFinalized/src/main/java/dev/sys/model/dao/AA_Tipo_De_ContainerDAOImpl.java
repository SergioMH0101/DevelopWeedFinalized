package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_Tipo_De_ContainerDTO;

@Repository
@Transactional
public class AA_Tipo_De_ContainerDAOImpl implements AA_Tipo_De_ContainerDAO{
	
	private String list = "SELECT * FROM aa_tipo_de_container ORDER BY id_ticontainer";
	private String select = "SELECT * FROM aa_tipo_de_container WHERE id_ticontainer=?";
	private String insert = "INSERT INTO aa_tipo_de_container VALUES (?,?)";
	private String update = "UPDATE aa_tipo_de_container SET id_ticontainer=?, nom_ticontainer=? "+
							"WHERE id_ticontainer=?";
	private String delete = "DELETE aa_tipo_de_container WHERE id_ticontainer=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_Tipo_De_ContainerDTO> list() {
		List<AA_Tipo_De_ContainerDTO> listAA_Tipo_De_ContainerDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_Tipo_De_ContainerDTO.class));
		return listAA_Tipo_De_ContainerDTO;
	}
	@Override
	public AA_Tipo_De_ContainerDTO get(String id_ticontainer) {
	    Object[] args = {id_ticontainer};
	    AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO;
	    
	    try {
	    	aa_tipo_de_containerDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_Tipo_De_ContainerDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_tipo_de_containerDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_tipo_de_containerDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_tipo_de_containerDTO;
	}
	@Override
	public int insert(AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_containerDTO.getId_ticontainer(),
	    		aa_tipo_de_containerDTO.getNom_ticontainer()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_containerDTO.getId_ticontainer(),
	    		aa_tipo_de_containerDTO.getNom_ticontainer()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_ticontainer) {
		int rows = 0;
	    Object[] args = {id_ticontainer};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
