package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_GirosDAO;
import dev.sys.model.dto.AA_GirosDTO;

@Service
public class AA_GirosServiceImpl implements AA_GirosService{
	@Autowired
	AA_GirosDAO aa_girosDAO;

	@Override
	public List<AA_GirosDTO> list() {
		return aa_girosDAO.list();
	}

	@Override
	public AA_GirosDTO get(String id_giro) {
		return aa_girosDAO.get(id_giro);
	}

	@Override
	public int insert(AA_GirosDTO aa_girosDTO) {
		return aa_girosDAO.insert(aa_girosDTO);
	}

	@Override
	public int update(AA_GirosDTO aa_girosDTO) {
		return aa_girosDAO.update(aa_girosDTO);
	}

	@Override
	public int delete(String id_giro) {
		return aa_girosDAO.delete(id_giro);
	}
}
