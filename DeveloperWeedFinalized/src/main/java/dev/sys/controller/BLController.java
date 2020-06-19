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
import com.google.gson.GsonBuilder;

import dev.sys.model.dto.BLDTO;
import dev.sys.service.BLService;

@Controller
@RequestMapping(value="/BL") //todo lo que tenga sales --direcciona a esta clase.
public class BLController {
	
	@Autowired
	BLService blService;

	@RequestMapping(value="/list")
	public @ResponseBody List<BLDTO> ajaxList(HttpServletRequest req,HttpServletResponse res){
		return blService.list();
	}
	
	@RequestMapping(value="/get")
	public @ResponseBody BLDTO ajaxGet(HttpServletRequest req,HttpServletResponse res){
		return blService.get(Integer.parseInt(req.getParameter("Id_bl")));
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req,HttpServletResponse res){
	
		int rows=0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			
			//cuando mandamos fecha desde web a controller, nos manda la fecha de cómo está en el cliente, por lo tanto lo dejamos como formato de java.sql
			
			
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();
				
			//transforma la estructura de datos que viene del javascript para enviarla a DTO. viende de requestData y lo manda a SalesDTO.class
			BLDTO bl =gson.fromJson(requestData, BLDTO.class);
		
			rows= blService.insert(bl);
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return rows;
		
		
	}
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req,HttpServletResponse res){
		
		int rows=0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();
			BLDTO bl =gson.fromJson(requestData, BLDTO.class);
			rows= blService.update(bl);
		} catch (IOException e) {
			e.printStackTrace();	
		}
		
		return rows;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req,HttpServletResponse res){
		int rows=0;
		try {
			rows= blService.delete(Integer.parseInt(req.getParameter("Id_bl")));
			System.out.println(req.getParameter("Id_bl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;	
		}
}
