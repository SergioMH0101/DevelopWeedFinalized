package dev.sys.model.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_ContainerDTO;

@Repository
@Transactional
public class AA_ContainerDAOImpl implements AA_ContainerDAO{
	private String list = "SELECT * FROM aa_container ORDER BY n_container";
	private String select = "SELECT * FROM aa_container WHERE n_container=?";
	private String insert = "INSERT INTO aa_container VALUES (?,?,?,?)";
	private String update = "UPDATE aa_container SET n_container=?, tipo_container=?, medida_container=?, naviera=? "+
							"WHERE n_container=?";
	private String delete = "DELETE aa_container WHERE n_container=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_ContainerDTO> list() {
		List<AA_ContainerDTO> listAA_ContainerDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_ContainerDTO.class));
		return listAA_ContainerDTO;
	}
	@Override
	public AA_ContainerDTO get(String n_container) {
	    Object[] args = {n_container};
	    AA_ContainerDTO aa_containerDTO;
	    
	    try {
	    	aa_containerDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_ContainerDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_containerDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_containerDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_containerDTO;
	}
	@Override
	public int insert(AA_ContainerDTO aa_containerDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_containerDTO.getN_container(),
	    		aa_containerDTO.getTipo_container(),
	    		aa_containerDTO.getMedida_container(),
	    		aa_containerDTO.getNaviera()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_ContainerDTO aa_containerDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_containerDTO.getN_container(),
	    		aa_containerDTO.getTipo_container(),
	    		aa_containerDTO.getMedida_container(),
	    		aa_containerDTO.getNaviera()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String n_container) {
		int rows = 0;
	    Object[] args = {n_container};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
