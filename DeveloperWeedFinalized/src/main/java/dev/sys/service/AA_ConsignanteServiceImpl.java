package dev.sys.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_ConsignanteDAO;
import dev.sys.model.dto.AA_ConsignanteDTO;
@Service
public class AA_ConsignanteServiceImpl implements AA_ConsignanteService{
	@Autowired
	AA_ConsignanteDAO aa_consignanteDAO;

	@Override
	public List<AA_ConsignanteDTO> list() {
		return aa_consignanteDAO.list();
	}

	@Override
	public AA_ConsignanteDTO get(String id_consignante) {
		return aa_consignanteDAO.get(id_consignante);
	}

	@Override
	public int insert(AA_ConsignanteDTO aa_consignanteDTO) {
		return aa_consignanteDAO.insert(aa_consignanteDTO);
	}

	@Override
	public int update(AA_ConsignanteDTO aa_consignanteDTO) {
		return aa_consignanteDAO.update(aa_consignanteDTO);
	}

	@Override
	public int delete(String id_consignante) {
		return aa_consignanteDAO.delete(id_consignante);
	}
	
}
