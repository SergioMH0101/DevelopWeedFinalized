package dev.sys.model.dao;

import java.util.List;

import dev.sys.model.dto.AA_ConsignanteDTO;

public interface AA_ConsignanteDAO {
	public List<AA_ConsignanteDTO> list();
	public AA_ConsignanteDTO get(String id_consignante);
	public int insert(AA_ConsignanteDTO aa_consignanteDTO);
	public int update(AA_ConsignanteDTO aa_consignanteDTO);
	public int delete(String id_consignante);

}
