package dev.sys.model.dao;

import java.util.List;

import dev.sys.model.dto.AA_Tipo_De_ContainerDTO;

public interface AA_Tipo_De_ContainerDAO {

	public List<AA_Tipo_De_ContainerDTO> list();
	public AA_Tipo_De_ContainerDTO get(String id_agente);
	public int insert(AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO);
	public int update(AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO);
	public int delete(String id_agente);
}
