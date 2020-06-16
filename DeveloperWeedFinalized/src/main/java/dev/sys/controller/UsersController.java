/*package cl.icap.cursofullstack.Developerweed.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import cl.icap.cursofullstack.developerweed.model.dto.BLDTO;
import cl.icap.cursofullstack.developerweed.model.dto.UsersDTO;

import cl.icap.cursofullstack.developerweed.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	UsersService usersService;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping("/createUser")
	public  String Insert(HttpServletRequest req){
	 int rows=0;
	 int rowsrol=0;
	 try {

		
	UsersDTO usersDTO = new UsersDTO();
	
	String password = req.getParameter("password");
	usersDTO.setPassword(bCryptPasswordEncoder.encode(password));
	usersDTO.setUsername(req.getParameter("username"));
	usersDTO.setEnabled(1);
	usersDTO.setRol("User");
	
	rows=usersService.insertUsers(usersDTO);
	rowsrol=usersService.insertRol(usersDTO);

	
	 } catch (Exception e) {
			e.printStackTrace(); 
		 
		}
	 
		return "insert";
	}
	
	  @RequestMapping(value = "/userdetails", method = RequestMethod.GET)
	  @ResponseBody
	  public String currentUserName(Authentication authentication) {
		  System.out.println("username: " + authentication.getName()+" authority: "+ authentication.getAuthorities());
	     return authentication.getName() + " Authentication: " + authentication.getAuthorities();
	     
	  }
	  
	  @RequestMapping(value="/listUsers")
		public @ResponseBody List<UsersDTO> ajaxList(HttpServletRequest req,HttpServletResponse res){
			return usersService.listUsers();
		}
	  }
	
	*/

