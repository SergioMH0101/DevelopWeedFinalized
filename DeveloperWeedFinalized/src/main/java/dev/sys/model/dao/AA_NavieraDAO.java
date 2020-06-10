package dev.sys.model.dao;

import java.util.List;

import dev.sys.model.dto.AA_NavieraDTO;

public interface AA_NavieraDAO {

	public List<AA_NavieraDTO> list();
	public AA_NavieraDTO get(String id_naviera);
	public int insert(AA_NavieraDTO aa_navieraDTO);
	public int update(AA_NavieraDTO aa_navieraDTO);
	public int delete(String id_naviera);
}
