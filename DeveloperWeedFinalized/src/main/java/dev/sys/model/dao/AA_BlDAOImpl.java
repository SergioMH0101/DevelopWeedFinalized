package dev.sys.model.dao;

import java.sql.Types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
	
	@Autowired 
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	public List<AA_BlDTO> list(){
		List<AA_BlDTO> listAA_BlDTO = jdbcTemplate.query(list,
				BeanPropertyRowMapper.newInstance(AA_BlDTO.class));
		return listAA_BlDTO;
	}
	@Override
	public AA_BlDTO get(int id_bl) {
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
		try {	
			MapSqlParameterSource params =new MapSqlParameterSource();
		
			params.addValue("Nombre_nave", aa_blDTO.getNombre_nave(), Types.VARCHAR);
			params.addValue("Num_sello", aa_blDTO.getNum_sello(), Types.INTEGER);
			
			if (aa_blDTO.getConsignatario() !=null) {
				params.addValue("Consignatario", aa_blDTO.getConsignatario(), Types.VARCHAR);
			}else {
			params.addValue("Consignatario", aa_blDTO.getConsignatario(), Types.NULL);
			}

			if (aa_blDTO.getConsignante() !=null) {
				params.addValue("Consignante", aa_blDTO.getConsignante(),Types.VARCHAR);
			}else {
				params.addValue("Consignante", aa_blDTO.getConsignante(), Types.NULL);
			}
			
			if(aa_blDTO.getPeso() != 0) {
				params.addValue("Peso", aa_blDTO.getPeso(), Types.INTEGER);
			}else {
				params.addValue("Peso", aa_blDTO.getPeso(), Types.NULL);
			}
			
			if(aa_blDTO.getVol_cubico() != 0) {
				params.addValue("Vol_cubico", aa_blDTO.getVol_cubico(), Types.INTEGER);
			}else {
				params.addValue("Vol_cubico", aa_blDTO.getVol_cubico(), Types.NULL);
			}
			
			if(aa_blDTO.getMercaderia() !=null) {
				params.addValue("Mercaderia", aa_blDTO.getMercaderia(), Types.VARCHAR);
			}else {
				params.addValue("Mercaderia", aa_blDTO.getMercaderia(), Types.NULL);
			}
			
			 if(aa_blDTO.getTipo_carga() !=null) {
				 params.addValue("Tipo_carga", aa_blDTO.getTipo_carga(), Types.VARCHAR);
			 }else {
				 params.addValue("Tipo_carga", aa_blDTO.getTipo_carga(), Types.NULL);
			 }
			if(aa_blDTO.getFecha_salida() !=null) {
				params.addValue("Fecha_salida", aa_blDTO.getFecha_salida(), Types.VARCHAR);
			}else {
				params.addValue("Fecha_salida", aa_blDTO.getFecha_salida(), Types.NULL);
			}
			
			if(aa_blDTO.getFecha_arribo() !=null) {
				params.addValue("Fecha_arribo", aa_blDTO.getFecha_arribo(),Types.VARCHAR);
			}else {
				params.addValue("Fecha_arribo", aa_blDTO.getFecha_arribo(), Types.NULL);
			}
			
			if(aa_blDTO.getUnidades() != 0) {
				params.addValue("Unidades", aa_blDTO.getUnidades(), Types.VARCHAR);
			}else {
				params.addValue("Unidades",aa_blDTO.getUnidades(), Types.NULL);
			}
			
			if(aa_blDTO.getCarga() !=null) {
				params.addValue("Carga", aa_blDTO.getCarga(), Types.VARCHAR);
			}else {
				params.addValue("Carga", aa_blDTO.getCarga(), Types.NULL);
			} 
			 
			if(aa_blDTO.getIncoterms() !=null) {
				 params.addValue("Incoterms", aa_blDTO.getIncoterms(), Types.VARCHAR);
			}else {
				 params.addValue("Incoterms", aa_blDTO.getIncoterms(), Types.NULL);
			}
			 
			if(aa_blDTO.getPais() !=null) {
				 params.addValue("Pais", aa_blDTO.getPais(), Types.VARCHAR);
			}else {
				 params.addValue("Pais", aa_blDTO.getPais(), Types.NULL);
			}
			
			if(aa_blDTO.getDocumentacion() !=null) {
				 params.addValue("Documentacion", aa_blDTO.getDocumentacion(), Types.VARCHAR);
			}else {
				 params.addValue("Documentacion", aa_blDTO.getDocumentacion(), Types.NULL);
			}
			rows = namedParameterJdbcTemplate.update(insert, params);
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return rows;
	}
	@Override
	public int update(AA_BlDTO aa_blDTO) {
		int rows = 0;
try {
			
			
			MapSqlParameterSource params =new MapSqlParameterSource();
		
			params.addValue("Nombre_nave", aa_blDTO.getNombre_nave(), Types.VARCHAR);
			params.addValue("Num_sello", aa_blDTO.getNum_sello(), Types.INTEGER);
			
			if (aa_blDTO.getConsignatario() !=null) {
				params.addValue("Consignatario", aa_blDTO.getConsignatario(), Types.VARCHAR);
			}else {
			params.addValue("Consignatario", aa_blDTO.getConsignatario(), Types.NULL);
			}

			if (aa_blDTO.getConsignante() !=null) {
				params.addValue("Consignante", aa_blDTO.getConsignante(),Types.VARCHAR);
			}else {
				params.addValue("Consignante", aa_blDTO.getConsignante(), Types.NULL);
			}
			
			if(aa_blDTO.getPeso() != 0) {
				params.addValue("Peso", aa_blDTO.getPeso(), Types.INTEGER);
			}else {
				params.addValue("Peso", aa_blDTO.getPeso(), Types.NULL);
			}
			
			if(aa_blDTO.getVol_cubico() != 0) {
				params.addValue("Vol_cubico", aa_blDTO.getVol_cubico(), Types.INTEGER);
			}else {
				params.addValue("Vol_cubico", aa_blDTO.getVol_cubico(), Types.NULL);
			}
			
			if(aa_blDTO.getMercaderia() !=null) {
				params.addValue("Mercaderia", aa_blDTO.getMercaderia(), Types.VARCHAR);
			}else {
				params.addValue("Mercaderia", aa_blDTO.getMercaderia(), Types.NULL);
			}
			
			 if(aa_blDTO.getTipo_carga() !=null) {
				 params.addValue("Tipo_carga", aa_blDTO.getTipo_carga(), Types.VARCHAR);
			 }else {
				 params.addValue("Tipo_carga", aa_blDTO.getTipo_carga(), Types.NULL);
			 }
			if(aa_blDTO.getFecha_salida() !=null) {
				params.addValue("Fecha_salida", aa_blDTO.getFecha_salida(), Types.VARCHAR);
			}else {
				params.addValue("Fecha_salida", aa_blDTO.getFecha_salida(), Types.NULL);
			}
			
			if(aa_blDTO.getFecha_arribo() !=null) {
				params.addValue("Fecha_arribo", aa_blDTO.getFecha_arribo(),Types.VARCHAR);
			}else {
				params.addValue("Fecha_arribo", aa_blDTO.getFecha_arribo(), Types.NULL);
			}
			
			if(aa_blDTO.getUnidades() != 0) {
				params.addValue("Unidades", aa_blDTO.getUnidades(), Types.VARCHAR);
			}else {
				params.addValue("Unidades",aa_blDTO.getUnidades(), Types.NULL);
			}
			
			if(aa_blDTO.getCarga() !=null) {
				params.addValue("Carga", aa_blDTO.getCarga(), Types.VARCHAR);
			}else {
				params.addValue("Carga", aa_blDTO.getCarga(), Types.NULL);
			} 
			 
			if(aa_blDTO.getIncoterms() !=null) {
				 params.addValue("Incoterms", aa_blDTO.getIncoterms(), Types.VARCHAR);
			}else {
				 params.addValue("Incoterms", aa_blDTO.getIncoterms(), Types.NULL);
			}
			 
			if(aa_blDTO.getPais() !=null) {
				 params.addValue("Pais", aa_blDTO.getPais(), Types.VARCHAR);
			}else {
				 params.addValue("Pais", aa_blDTO.getPais(), Types.NULL);
			}
			
			if(aa_blDTO.getDocumentacion() !=null) {
				 params.addValue("Documentacion", aa_blDTO.getDocumentacion(), Types.VARCHAR);
			}else {
				 params.addValue("Documentacion", aa_blDTO.getDocumentacion(), Types.NULL);
			}
			rows = namedParameterJdbcTemplate.update(update, params);
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return rows;
	}
	@Override
	public int delete(int id_bl) {
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
