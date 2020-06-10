package dev.sys.model.dao;

import java.util.List;
import dev.sys.model.dto.AA_EstadosDTO;

public interface AA_EstadosDAO {
	
	public List<AA_EstadosDTO> list();
	public AA_EstadosDTO get(String id_flujo);
	public int insert(AA_EstadosDTO aa_estadosDTO);
	public int update(AA_EstadosDTO aa_estadosDTO);
	public int delete(String id_flujo);

}
