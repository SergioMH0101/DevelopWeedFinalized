package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_ConsignatarioDAO;
import dev.sys.model.dto.AA_ConsignatarioDTO;
@Service
public class AA_ConsignatarioServiceImpl implements AA_ConsignatarioService{
	@Autowired
	AA_ConsignatarioDAO aa_consignatarioDAO;

	@Override
	public List<AA_ConsignatarioDTO> list() {
		return aa_consignatarioDAO.list();
	}

	@Override
	public AA_ConsignatarioDTO get(String id_consignatario) {
		return aa_consignatarioDAO.get(id_consignatario);
	}

	@Override
	public int insert(AA_ConsignatarioDTO aa_consignatarioDTO) {
		return aa_consignatarioDAO.insert(aa_consignatarioDTO);
	}

	@Override
	public int update(AA_ConsignatarioDTO aa_consignatarioDTO) {
		return aa_consignatarioDAO.update(aa_consignatarioDTO);
	}

	@Override
	public int delete(String id_consignatario) {
		return aa_consignatarioDAO.delete(id_consignatario);
	}

}
