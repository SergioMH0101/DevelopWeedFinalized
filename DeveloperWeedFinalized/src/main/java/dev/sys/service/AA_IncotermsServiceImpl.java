package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_IncotermsDAO;
import dev.sys.model.dto.AA_IncotermsDTO;

@Service
public class AA_IncotermsServiceImpl implements AA_IncotermsService{
	@Autowired
	AA_IncotermsDAO aa_incotermsDAO;

	@Override
	public List<AA_IncotermsDTO> list() {
		return aa_incotermsDAO.list();
	}

	@Override
	public AA_IncotermsDTO get(String id_incoterms) {
		return aa_incotermsDAO.get(id_incoterms);
	}

	@Override
	public int insert(AA_IncotermsDTO aa_incotermsDTO) {
		return aa_incotermsDAO.insert(aa_incotermsDTO);
	}

	@Override
	public int update(AA_IncotermsDTO aa_incotermsDTO) {
		return aa_incotermsDAO.update(aa_incotermsDTO);
	}

	@Override
	public int delete(String id_incoterms) {
		return aa_incotermsDAO.delete(id_incoterms);
	}
	
}
