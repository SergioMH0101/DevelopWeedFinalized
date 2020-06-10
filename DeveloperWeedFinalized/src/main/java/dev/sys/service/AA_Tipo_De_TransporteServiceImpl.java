package dev.sys.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.sys.model.dao.AA_Tipo_De_TransporteDAO;
import dev.sys.model.dto.AA_Tipo_De_TransporteDTO;

@Service
public class AA_Tipo_De_TransporteServiceImpl implements AA_Tipo_De_TransporteService{
	@Autowired 
	AA_Tipo_De_TransporteDAO aa_tipo_de_transporteDAO;

	@Override
	public List<AA_Tipo_De_TransporteDTO> list() {
		return aa_tipo_de_transporteDAO.list();
	}

	@Override
	public AA_Tipo_De_TransporteDTO get(String id_transporte) {
		return aa_tipo_de_transporteDAO.get(id_transporte);
	}

	@Override
	public int insert(AA_Tipo_De_TransporteDTO aa_tipo_de_transporteDTO) {
		return aa_tipo_de_transporteDAO.insert(aa_tipo_de_transporteDTO);
	}

	@Override
	public int update(AA_Tipo_De_TransporteDTO aa_tipo_de_transporteDTO) {
		return aa_tipo_de_transporteDAO.update(aa_tipo_de_transporteDTO);
	}

	@Override
	public int delete(String id_transporte) {
		return aa_tipo_de_transporteDAO.delete(id_transporte);
	}
	
}
