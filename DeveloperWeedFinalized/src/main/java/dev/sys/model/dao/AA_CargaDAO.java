package dev.sys.model.dao;
import java.util.List;
import dev.sys.model.dto.AA_CargaDTO;

public interface AA_CargaDAO {	
	public List<AA_CargaDTO> list();
	public AA_CargaDTO get(String id_carga);
	public int insert(AA_CargaDTO aa_cargaDTO);
	public int update(AA_CargaDTO aa_cargaDTO);
	public int delete(String id_carga);
}
