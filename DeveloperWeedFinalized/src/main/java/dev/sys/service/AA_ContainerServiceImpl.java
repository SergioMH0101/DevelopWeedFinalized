package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_ContainerDAO;
import dev.sys.model.dto.AA_ContainerDTO;

@Service
public class AA_ContainerServiceImpl implements AA_ContainerService{
	@Autowired
	AA_ContainerDAO aa_containerDAO;

	@Override
	public List<AA_ContainerDTO> list() {
		return aa_containerDAO.list();
	}

	@Override
	public AA_ContainerDTO get(String n_container) {
		return aa_containerDAO.get(n_container);
	}

	@Override
	public int insert(AA_ContainerDTO aa_containerDTO) {
		return aa_containerDAO.insert(aa_containerDTO);
	}

	@Override
	public int update(AA_ContainerDTO aa_containerDTO) {
		return aa_containerDAO.update(aa_containerDTO);
	}

	@Override
	public int delete(String n_container) {
		return aa_containerDAO.delete(n_container);
	}
}
