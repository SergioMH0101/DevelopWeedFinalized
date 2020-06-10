package dev.sys.model.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_ConsignatarioDTO;

@Repository
@Transactional
public class AA_ConsignatarioDAOImpl implements AA_ConsignatarioDAO{
	
	private String list = "SELECT * FROM aa_consignatario ORDER BY id_consignatario";
	private String select = "SELECT * FROM aa_consignatario WHERE id_consignatario=?";
	private String insert = "INSERT INTO aa_consignatario VALUES (?,?,?,?,?,?,?,?)";
	private String update = "UPDATE aa_consignatario SET id_consignatario=?, nom_consignatario=?, id_giro=?, num_contacto=?, "+
							"direccion=?, id_comuna=?, id_region=?, id_pais=? WHERE id_consignatario=?";
	private String delete = "DELETE aa_consignatario WHERE id_consignatario=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_ConsignatarioDTO> list() {
		List<AA_ConsignatarioDTO> listAA_ConsignatarioDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_ConsignatarioDTO.class));
		return listAA_ConsignatarioDTO;
	}
	@Override
	public AA_ConsignatarioDTO get(String id_consignatario) {
	    Object[] args = {id_consignatario};
	    AA_ConsignatarioDTO aa_consignatarioDTO;
	    
	    try {
	    	aa_consignatarioDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_ConsignatarioDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_consignatarioDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_consignatarioDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_consignatarioDTO;
	}
	@Override
	public int insert(AA_ConsignatarioDTO aa_consignatarioDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_consignatarioDTO.getId_consignatario(),
	    		aa_consignatarioDTO.getNom_consignatario(),
	    		aa_consignatarioDTO.getId_giro(),
	    		aa_consignatarioDTO.getNum_contacto(),
	    		aa_consignatarioDTO.getDireccion(),
	    		aa_consignatarioDTO.getId_comuna(),
	    		aa_consignatarioDTO.getId_region(),
	    		aa_consignatarioDTO.getId_pais()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_ConsignatarioDTO aa_consignatarioDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_consignatarioDTO.getId_consignatario(),
	    		aa_consignatarioDTO.getNom_consignatario(),
	    		aa_consignatarioDTO.getId_giro(),
	    		aa_consignatarioDTO.getNum_contacto(),
	    		aa_consignatarioDTO.getDireccion(),
	    		aa_consignatarioDTO.getId_comuna(),
	    		aa_consignatarioDTO.getId_region(),
	    		aa_consignatarioDTO.getId_pais()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_consignatario) {
		int rows = 0;
	    Object[] args = {id_consignatario};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
}
