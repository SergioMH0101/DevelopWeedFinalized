package dev.sys.service;

import java.util.List;

import dev.sys.model.dto.AA_BlDTO;

public interface AA_BlService {
	public List<AA_BlDTO> list();
	public AA_BlDTO get(int id_bl);
	public int insert(AA_BlDTO aa_blDTO);
	public int update(AA_BlDTO aa_blDTO);
	public int delete(int id_bl);

}
