package dev.sys.service;

import java.util.List;

import dev.sys.model.dto.AA_WorkflowDTO;

public interface AA_WorkflowService {
	
	public List<AA_WorkflowDTO> list();
	public AA_WorkflowDTO get(String id_flujo);
	public int insert(AA_WorkflowDTO aa_workflowDTO);
	public int update(AA_WorkflowDTO aa_workflowDTO);
	public int delete(String id_flujo);

}
