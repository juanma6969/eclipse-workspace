package com.openwebinars.spring.controladores;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
/*	
	@GetMapping("/")
	public String welcome() {
		return "index";
	
}*/
	//Con spring 
//	@GetMapping("/")
//
//	public String welcome(@RequestParam( name="name",required=false,defaultValue="Mundo") String name,Model model) {
//		//model.addAttribute("mensaje",  "Mi primer mensaje con spring boot en un proyecto web,");
//		model.addAttribute("nombre", name);
//		return "index";
//	}
	//Con java 8 Clase optional
	@GetMapping("/")
	public String welcome(@RequestParam("name")Optional<String> name,@RequestParam("lastname")Optional<String> lname,Model model) {
		model.addAttribute("nombre",name.orElse("Mundo"));
		model.addAttribute("lastname", lname.orElse("Mundo"));
		return "index";
	}
	
	@GetMapping("/saludo/{name}/{lastname}")
	public String saludo(@PathVariable String name,@PathVariable String lastname,Model model) {
		///model.addAttribute("saludo",  "Mi primer mensaje de un pagina distinta al index");
		model.addAttribute("saludo","Hola" + name +" de apellidos " + lastname );
		return "saludo";
	}
	
	

}
