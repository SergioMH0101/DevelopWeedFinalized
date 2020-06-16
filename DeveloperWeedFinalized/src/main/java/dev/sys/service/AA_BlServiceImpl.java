package dev.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_BlDAO;
import dev.sys.model.dto.AA_BlDTO;

@Service
public class AA_BlServiceImpl implements AA_BlService{
	@Autowired
	AA_BlDAO aa_blDAO;
	@Override
	public List<AA_BlDTO>list(){
		return aa_blDAO.list();
	}
	@Override
	public AA_BlDTO get(int id_bl) {
		return aa_blDAO.get(id_bl);
	}
	@Override
	public int delete(int id_bl) {
		return aa_blDAO.delete(id_bl);
	}
	@Override
	public int insert(AA_BlDTO aa_blDTO) {
		return aa_blDAO.insert(aa_blDTO);
	} 
	@Override
	public int update(AA_BlDTO aa_blDTO) {
		return aa_blDAO.update(aa_blDTO);
	}

}
