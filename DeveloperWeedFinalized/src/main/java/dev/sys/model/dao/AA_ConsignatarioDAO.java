package dev.sys.model.dao;

import java.util.List;

import dev.sys.model.dto.AA_ConsignatarioDTO;

public interface AA_ConsignatarioDAO {
	public List<AA_ConsignatarioDTO> list();
	public AA_ConsignatarioDTO get(String id_consignatario);
	public int insert(AA_ConsignatarioDTO aa_consignatarioDTO);
	public int update(AA_ConsignatarioDTO aa_consignatarioDTO);
	public int delete(String id_consignatario);

}
