package dev.sys.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import dev.sys.model.dto.AA_ProveedorDTO;
import dev.sys.service.AA_ProveedorService;



@Controller
@RequestMapping(value="/AA_PROVEEDOR")
public class ProveedorController {
	@Autowired
	AA_ProveedorService aa_proveedorService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<AA_ProveedorDTO> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		List<AA_ProveedorDTO> list = aa_proveedorService.list();
		return list;
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody AA_ProveedorDTO ajaxGet(HttpServletRequest req, HttpServletResponse res) {
		AA_ProveedorDTO p = aa_proveedorService.get(req.getParameter("id_proveedor"));
		return p;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows = aa_proveedorService.delete(req.getParameter("id_proveedor"));
		return rows;
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			AA_ProveedorDTO p = new Gson().fromJson(requestData, AA_ProveedorDTO.class);
			rows = aa_proveedorService.insert(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		try {
			String requestData = req.getReader().lines().collect(Collectors.joining());
			AA_ProveedorDTO p = new Gson().fromJson(requestData, AA_ProveedorDTO.class);
			rows = aa_proveedorService.update(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return rows;
	}

}
