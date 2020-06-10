package dev.sys.model.dao;

import java.util.List;

import dev.sys.model.dto.AA_IncotermsDTO;

public interface AA_IncotermsDAO {
	public List<AA_IncotermsDTO> list();
	public AA_IncotermsDTO get(String id_incoterms);
	public int insert(AA_IncotermsDTO aa_incotermsDTO);
	public int update(AA_IncotermsDTO aa_incotermsDTO);
	public int delete(String id_incoterms);

}
