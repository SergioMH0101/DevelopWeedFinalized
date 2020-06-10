package dev.sys.model.dao;
import java.util.List;

import dev.sys.model.dto.AA_BlDTO;
public interface AA_BlDAO {
	public List<AA_BlDTO> list();
	public AA_BlDTO get(String id_bl);
	public int insert(AA_BlDTO aa_blDTO);
	public int update(AA_BlDTO aa_blDTO);
	public int delete(String id_bl);
}
