package dev.sys.service;

import java.util.List;

import dev.sys.model.dto.AA_Tipo_De_CargaDTO;

public interface AA_Tipo_De_CargaService {

	public List<AA_Tipo_De_CargaDTO> list();
	public AA_Tipo_De_CargaDTO get(String id_agente);
	public int insert(AA_Tipo_De_CargaDTO aa_tipo_de_cargaDTO);
	public int update(AA_Tipo_De_CargaDTO aa_tipo_de_cargaDTO);
	public int delete(String id_agente);
}
