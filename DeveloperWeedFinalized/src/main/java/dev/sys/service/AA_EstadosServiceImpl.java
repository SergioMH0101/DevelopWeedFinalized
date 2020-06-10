package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_EstadosDAO;
import dev.sys.model.dto.AA_EstadosDTO;

@Service
public class AA_EstadosServiceImpl implements AA_EstadosService{
	@Autowired
	AA_EstadosDAO aa_estadosDAO;

	@Override
	public List<AA_EstadosDTO> list() {
		return aa_estadosDAO.list();
	}

	@Override
	public AA_EstadosDTO get(String id_flujo) {
		return aa_estadosDAO.get(id_flujo);
	}

	@Override
	public int insert(AA_EstadosDTO aa_estadosDTO) {
		return aa_estadosDAO.insert(aa_estadosDTO);
	}

	@Override
	public int update(AA_EstadosDTO aa_estadosDTO) {
		return aa_estadosDAO.update(aa_estadosDTO);
	}

	@Override
	public int delete(String id_flujo) {
		return aa_estadosDAO.delete(id_flujo);
	}
}
