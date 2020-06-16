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

import dev.sys.model.dto.AA_BlDTO;
import dev.sys.service.AA_BlService;

@Controller
@RequestMapping(value="/Bl") //todo lo que tenga sales --direcciona a esta clase.
public class AA_BlController {
	
	@Autowired
	AA_BlService aa_blService;

	@RequestMapping(value="/list")
	public @ResponseBody List<AA_BlDTO> ajaxList(HttpServletRequest req,HttpServletResponse res){
		return aa_blService.list();
	}	
	@RequestMapping(value="/get")
	public @ResponseBody AA_BlDTO ajaxGet(HttpServletRequest req,HttpServletResponse res){
		return aa_blService.get(Integer.parseInt(req.getParameter("id_bl")));
	}
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req,HttpServletResponse res){
	
		int rows=0;
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson=new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().create();
			AA_BlDTO bl =gson.fromJson(requestData, AA_BlDTO.class);	
			rows= aa_blService.insert(bl);
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
			AA_BlDTO bl =gson.fromJson(requestData, AA_BlDTO.class);
			rows= aa_blService.update(bl);
		} catch (IOException e) {
			e.printStackTrace();	
		}	
		return rows;
	}
	
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req,HttpServletResponse res){
		int rows=0;
		try {
			rows= aa_blService.delete(Integer.parseInt(req.getParameter("id_bl")));
			System.out.println(req.getParameter("id_bl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;	
		}
}
