package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_PaisDAO;
import dev.sys.model.dto.AA_PaisDTO;

@Service
public class AA_PaisServiceImpl implements AA_PaisService{
	@Autowired
	AA_PaisDAO aa_paisDAO;

	@Override
	public List<AA_PaisDTO> list() {
		return aa_paisDAO.list();
	}

	@Override
	public AA_PaisDTO get(String paiscodigo) {
		return aa_paisDAO.get(paiscodigo);
	}

	@Override
	public int insert(AA_PaisDTO aa_paisDTO) {
		return aa_paisDAO.insert(aa_paisDTO);
	}

	@Override
	public int update(AA_PaisDTO aa_paisDTO) {
		return aa_paisDAO.update(aa_paisDTO);
	}

	@Override
	public int delete(String paiscodigo) {
		return aa_paisDAO.delete(paiscodigo);
	}
	

}
