package dev.sys.model.dao;
import java.util.List;

import dev.sys.model.dto.AA_ComunaDTO;

public interface AA_ComunaDAO {
	
	public List<AA_ComunaDTO> list();
	public AA_ComunaDTO get(String id_comuna);
	public int insert(AA_ComunaDTO aa_comunaDTO);
	public int update(AA_ComunaDTO aa_comunaDTO);
	public int delete(String id_comuna);

}
