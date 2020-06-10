package dev.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_CargaDAO;
import dev.sys.model.dto.AA_CargaDTO;

@Service
public class AA_CargaServiceImpl implements AA_CargaService{

	@Autowired
	AA_CargaDAO aa_cargaDAO;

	@Override
	public List<AA_CargaDTO> list() {
		return aa_cargaDAO.list();
	}

	@Override
	public AA_CargaDTO get(String id_carga) {
		return aa_cargaDAO.get(id_carga);
	}

	@Override
	public int insert(AA_CargaDTO aa_cargaDTO) {
		return aa_cargaDAO.insert(aa_cargaDTO);
	}

	@Override
	public int update(AA_CargaDTO aa_cargaDTO) {
		return aa_cargaDAO.update(aa_cargaDTO);
	}

	@Override
	public int delete(String id_carga) {
		return aa_cargaDAO.delete(id_carga);
	}
}
