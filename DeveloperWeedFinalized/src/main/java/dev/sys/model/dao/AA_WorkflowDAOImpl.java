package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_WorkflowDTO;

@Repository
@Transactional
public class AA_WorkflowDAOImpl implements AA_WorkflowDAO{
	
	private String list = "SELECT * FROM aa_workflow ORDER BY id_flujo";
	private String select = "SELECT * FROM aa_workflow WHERE id_flujo=?";
	private String insert = "INSERT INTO aa_workflow VALUES (?,?,?)";
	private String update = "UPDATE aa_workflow SET id_flujo=?, nombre_flujo=?, precedente=? "+
							"WHERE id_flujo=?";
	private String delete = "DELETE aa_workflow WHERE id_flujo=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_WorkflowDTO> list() {
		List<AA_WorkflowDTO> listAA_WorkflowDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_WorkflowDTO.class));
		return listAA_WorkflowDTO;
	}
	@Override
	public AA_WorkflowDTO get(String id_flujo) {
	    Object[] args = {id_flujo};
	    AA_WorkflowDTO aa_workflowDTO;
	    
	    try {
	    	aa_workflowDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_WorkflowDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_workflowDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_workflowDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_workflowDTO;
	}
	@Override
	public int insert(AA_WorkflowDTO aa_workflowDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_workflowDTO.getId_flujo(),
	    		aa_workflowDTO.getNombre_flujo(),
	    		aa_workflowDTO.getPrecedente()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_WorkflowDTO aa_workflowDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_workflowDTO.getId_flujo(),
	    		aa_workflowDTO.getNombre_flujo(),
	    		aa_workflowDTO.getPrecedente()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_flujo) {
		int rows = 0;
	    Object[] args = {id_flujo};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
