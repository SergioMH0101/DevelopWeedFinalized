package dev.sys.service;

import java.util.List;

import dev.sys.model.dto.AA_RegionDTO;

public interface AA_RegionService {

	public List<AA_RegionDTO> list();
	public AA_RegionDTO get(String id_region);
	public int insert(AA_RegionDTO aa_regionDTO);
	public int update(AA_RegionDTO aa_regionDTO);
	public int delete(String id_region);
}
