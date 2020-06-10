package dev.sys.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dev.sys.model.dto.AA_BlDTO;

@Repository
@Transactional
public class AA_BlDAOImpl implements AA_BlDAO {
	private String list = "SELECT * FROM aa_bl ORDER BY id_bl";
	private String select = "SELECT * FROM aa_bl WHERE id_bl=?";
	private String insert = "INSERT INTO aa_bl VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String update = "UPDATE aa_bl SET id_bl=?, nombre_nave=?, num_sello=?, consignatario=?,"+
			"consignante=?, peso=?, vol_cubico=?, mercaderia=?, tipo_carga=?, fecha_salida=?, fecha_arribo=?,"+
			"unidades=?, carga=?, incoterms=?, pais=?, documentacion=? WHERE id_bl=?";
	private String delete = "DELETE aa_bl WHERE id_bl=?";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<AA_BlDTO> list(){
		List<AA_BlDTO> listAA_BlDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_BlDTO.class));
		return listAA_BlDTO;
	}
	@Override
	public AA_BlDTO get(String id_bl) {
	    Object[] args = {id_bl};
	    AA_BlDTO aa_blDTO;
	    
	    try {
	    	aa_blDTO = jdbcTemplate.queryForObject(select,args,
	    		BeanPropertyRowMapper.newInstance(AA_BlDTO.class));
	    } catch (EmptyResultDataAccessException e) {
	    	aa_blDTO=null;
	    	e.printStackTrace();
	    } catch (Exception e) {
	    	aa_blDTO=null;
	    	e.printStackTrace();
	    }
	    return aa_blDTO;
	}
	@Override
	public int insert(AA_BlDTO aa_blDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_blDTO.getId_bl(),
	    		aa_blDTO.getNombre_nave(),
	    		aa_blDTO.getNum_sello(),
	    		aa_blDTO.getConsignatario(),
	    		aa_blDTO.getConsignante(),
	    		aa_blDTO.getPeso(),
	    		aa_blDTO.getVol_cubico(),
	    		aa_blDTO.getMercaderia(),
	    		aa_blDTO.getTipo_carga(),
	    		aa_blDTO.getFecha_salida(),
	    		aa_blDTO.getFecha_arribo(),
	    		aa_blDTO.getUnidades(),
	    		aa_blDTO.getCarga(),
	    		aa_blDTO.getIncoterms(),
	    		aa_blDTO.getPais(),
	    		aa_blDTO.getDocumentacion()
	    		};
	    try {
			rows = jdbcTemplate.update(insert, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int update(AA_BlDTO aa_blDTO) {
		int rows = 0;
	    Object[] args = {
	    		aa_blDTO.getId_bl(),
	    		aa_blDTO.getNombre_nave(),
	    		aa_blDTO.getNum_sello(),
	    		aa_blDTO.getConsignatario(),
	    		aa_blDTO.getConsignante(),
	    		aa_blDTO.getPeso(),
	    		aa_blDTO.getVol_cubico(),
	    		aa_blDTO.getMercaderia(),
	    		aa_blDTO.getTipo_carga(),
	    		aa_blDTO.getFecha_salida(),
	    		aa_blDTO.getFecha_arribo(),
	    		aa_blDTO.getUnidades(),
	    		aa_blDTO.getCarga(),
	    		aa_blDTO.getIncoterms(),
	    		aa_blDTO.getPais(),
	    		aa_blDTO.getDocumentacion()
	    		};
	    try {
			rows = jdbcTemplate.update(update, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}
	@Override
	public int delete(String id_bl) {
		int rows = 0;
	    Object[] args = {id_bl};
	    try {
			rows = jdbcTemplate.update(delete, args);	
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return rows;
	}

}
