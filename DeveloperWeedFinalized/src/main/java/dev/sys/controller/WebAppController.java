package dev.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebAppController {
    @RequestMapping("/")
    public String getHome() {
        return "index";
    }
   
    @RequestMapping("/agenteaduana_page")
    public String getAgente_De_Aduana() {
        return "agenteaduana";
    }
    
    @RequestMapping("/BL")
    public String getBL() {
        return "IngresoBL";
    }
    @RequestMapping("/carga_page")
    public String getCarga(){
    	return"carga";
    }
}
