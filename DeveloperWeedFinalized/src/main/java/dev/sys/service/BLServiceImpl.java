package dev.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.BLDAO;
import dev.sys.model.dto.BLDTO;



@Service
public class BLServiceImpl implements BLService {

	@Autowired
	BLDAO blDAO; 
	
	public BLServiceImpl() {
		 
	}

	public List<BLDTO> list(){
		return blDAO.list();
	}

	@Override
	public int insert(BLDTO blDTO) {
		return blDAO.insert(blDTO);
	}

	@Override
	public BLDTO get(int Id_bl) {
	return blDAO.get(Id_bl);
	
	}

	@Override
	public int update(BLDTO blDTO) {
	return blDAO.update(blDTO);
	}

	@Override
	public int delete(int Id_bl) {
		return blDAO.delete(Id_bl);
	}
	
}
