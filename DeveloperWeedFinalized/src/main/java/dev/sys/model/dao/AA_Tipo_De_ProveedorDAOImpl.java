package dev.sys.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_Tipo_De_ProveedorDTO;

@Repository
@Transactional
public class AA_Tipo_De_ProveedorDAOImpl implements AA_Tipo_De_ProveedorDAO{
	
	private String list = "SELECT * FROM aa_tipo_de_proveedor ORDER BY id_tproveedor";
	private String select = "SELECT * FROM aa_tipo_de_proveedor WHERE id_tproveedor=?";
	private String insert = "INSERT INTO aa_tipo_de_proveedor VALUES (?,?)";
	private String update = "UPDATE aa_tipo_de_proveedor SET id_tproveedor=?, nom_tiproveedor=? "+
							"WHERE id_tproveedor=?";
	private String delete = "DELETE aa_tipo_de_proveedor WHERE id_tproveedor=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_Tipo_De_ProveedorDTO> list() {
		List<AA_Tipo_De_ProveedorDTO> listAA_Tipo_De_ProveedorDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_Tipo_De_ProveedorDTO.class));
		return listAA_Tipo_De_ProveedorDTO;
	}
	@Override
	public AA_Tipo_De_ProveedorDTO get(String id_tproveedor) {
	    Object[] args = {id_tproveedor};
	    AA_Tipo_De_ProveedorDTO aa_tipo_de_proveedorDTO;
	    
	    try {
	    	aa_tipo_de_proveedorDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_Tipo_De_ProveedorDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_tipo_de_proveedorDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_tipo_de_proveedorDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_tipo_de_proveedorDTO;
	}
	@Override
	public int insert(AA_Tipo_De_ProveedorDTO aa_tipo_de_proveedorDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_proveedorDTO.getId_tproveedor(),
	    		aa_tipo_de_proveedorDTO.getNom_tiproveedor()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_Tipo_De_ProveedorDTO aa_tipo_de_proveedorDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_tipo_de_proveedorDTO.getId_tproveedor(),
	    		aa_tipo_de_proveedorDTO.getNom_tiproveedor()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_tproveedor) {
		int rows = 0;
	    Object[] args = {id_tproveedor};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
