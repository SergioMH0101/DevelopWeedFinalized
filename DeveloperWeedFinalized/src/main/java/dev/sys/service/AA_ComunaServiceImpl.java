package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_ComunaDAO;
import dev.sys.model.dto.AA_ComunaDTO;

@Service
public class AA_ComunaServiceImpl implements AA_ComunaService{
	@Autowired
	AA_ComunaDAO aa_comunaDAO;
	
	@Override
	public List<AA_ComunaDTO> list() {
		return aa_comunaDAO.list();
	}

	@Override
	public AA_ComunaDTO get(String id_comuna) {
		return aa_comunaDAO.get(id_comuna);
	}

	@Override
	public int insert(AA_ComunaDTO aa_comunaDTO) {
		return aa_comunaDAO.insert(aa_comunaDTO);
	}

	@Override
	public int update(AA_ComunaDTO aa_comunaDTO) {
		return aa_comunaDAO.update(aa_comunaDTO);
	}

	@Override
	public int delete(String id_comuna) {
		return aa_comunaDAO.delete(id_comuna);
	}

}
