package dev.sys.model.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_ComunaDTO;

@Repository
@Transactional
public class AA_ComunaDAOImpl implements AA_ComunaDAO{
	private String list = "SELECT * FROM aa_comuna ORDER BY id_comuna";
	private String select = "SELECT * FROM aa_comuna WHERE id_comuna=?";
	private String insert = "INSERT INTO aa_comuna VALUES (?,?,?)";
	private String update = "UPDATE aa_comuna SET id_comuna=?, nombre_comuna=?, id_region=? "+
							"WHERE id_comuna=?";
	private String delete = "DELETE aa_comuna WHERE id_comuna=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_ComunaDTO> list() {
		List<AA_ComunaDTO> listAA_ComunaDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_ComunaDTO.class));
		return listAA_ComunaDTO;
	}
	@Override
	public AA_ComunaDTO get(String id_comuna) {
	    Object[] args = {id_comuna};
	    AA_ComunaDTO aa_comunaDTO;
	    
	    try {
	    	aa_comunaDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_ComunaDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_comunaDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_comunaDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_comunaDTO;
	}
	@Override
	public int insert(AA_ComunaDTO aa_comunaDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_comunaDTO.getId_comuna(),
	    		aa_comunaDTO.getNombre_comuna(),
	    		aa_comunaDTO.getId_region()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_ComunaDTO aa_comunaDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_comunaDTO.getId_comuna(),
	    		aa_comunaDTO.getNombre_comuna(),
	    		aa_comunaDTO.getId_region()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_comuna) {
		int rows = 0;
	    Object[] args = {id_comuna};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
