package org.ssirbu.notasClase2022.controller;

import javax.servlet.http.HttpSession;





import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.ssirbu.notasClase2022.exception.DangerException;
import org.ssirbu.notasClase2022.exception.InfoException;
import org.ssirbu.notasClase2022.exception.PRG;
import org.ssirbu.notasClase2022.helper.H;


@Controller
public class HomeController {
	
	@GetMapping("/info")
	public String info(HttpSession s, ModelMap m) {
		String mensaje = s.getAttribute("_mensaje") != null ? (String) s.getAttribute("_mensaje"): "Pulsa para volver a home";
		String severity = s.getAttribute("_severity") != null ? (String) s.getAttribute("_severity") : "info";
		String link = s.getAttribute("_link") != null ? (String) s.getAttribute("_link") : "/";

		s.removeAttribute("_mensaje");
		s.removeAttribute("_severity");
		s.removeAttribute("_link");

		m.put("mensaje", mensaje);
		m.put("severity", severity);
		m.put("link", link);

		m.put("view", "/_t/info");
		return "/_t/frame";
	}

	
	@GetMapping("/login")
	public String login(
			ModelMap m,
			HttpSession s
			) throws DangerException {
		H.isRolOK("anon", s);
		m.put("view","home/login");
		return "_t/frame";
	}
	
	@PostMapping("/login")
	public void loginPost(
			@RequestParam("dni")String dni,
			@RequestParam("pass")String password,
			HttpSession s //Le pasamso esta variable que es la sesion  , para ver si hay una creada o no  
			) throws DangerException, InfoException {
		
		try {
	
		}
		catch(Exception e) {
			PRG.error("Login incorrecto" ,"/login");
		}
		PRG.info("Login correcto" ,"/");
	}
	
	@GetMapping("/logout")
	public String logout(
			HttpSession sesion
			) {
		//Borramos la variable de sesion
		sesion.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/")
	public String index(ModelMap m) {
		m.put("view","home/index");
		return "_t/frame";
	}
}
