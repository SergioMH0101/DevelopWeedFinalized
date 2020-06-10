package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_Tipo_De_ContainerDAO;
import dev.sys.model.dto.AA_Tipo_De_ContainerDTO;

@Service
public class AA_Tipo_De_ContainerServiceImpl implements AA_Tipo_De_ContainerService{

	@Autowired
	AA_Tipo_De_ContainerDAO aa_tipo_de_containerDAO;

	@Override
	public List<AA_Tipo_De_ContainerDTO> list() {
		return aa_tipo_de_containerDAO.list();
	}

	@Override
	public AA_Tipo_De_ContainerDTO get(String id_agente) {
		return aa_tipo_de_containerDAO.get(id_agente);
	}

	@Override
	public int insert(AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO) {
		return aa_tipo_de_containerDAO.insert(aa_tipo_de_containerDTO);
	}

	@Override
	public int update(AA_Tipo_De_ContainerDTO aa_tipo_de_containerDTO) {
		return aa_tipo_de_containerDAO.update(aa_tipo_de_containerDTO);
	}

	@Override
	public int delete(String id_agente) {
		return aa_tipo_de_containerDAO.delete(id_agente);
	}
}
