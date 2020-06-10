package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_WorkflowDAO;
import dev.sys.model.dto.AA_WorkflowDTO;

@Service
public class AA_WorkflowServiceImpl implements AA_WorkflowService{
	@Autowired
	AA_WorkflowDAO aa_workflowDAO;

	@Override
	public List<AA_WorkflowDTO> list() {
		return aa_workflowDAO.list();
	}

	@Override
	public AA_WorkflowDTO get(String id_flujo) {
		return aa_workflowDAO.get(id_flujo);
	}

	@Override
	public int insert(AA_WorkflowDTO aa_workflowDTO) {
		return aa_workflowDAO.insert(aa_workflowDTO);
	}

	@Override
	public int update(AA_WorkflowDTO aa_workflowDTO) {
		return aa_workflowDAO.update(aa_workflowDTO);
	}

	@Override
	public int delete(String id_flujo) {
		return aa_workflowDAO.delete(id_flujo);
	}
	

}
