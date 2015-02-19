package syscom.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import syscom.dao.PersonasDAO;
import syscom.domain.Par;

@Controller
public class HomeController {
	
	@Autowired
	PersonasDAO dao;

	@RequestMapping({"/","/home"})
	public String menuPrincipal(HashMap model) {	
		System.out.println("ok");
		return "home";
	} 	
	
	@RequestMapping(value="/municipios")
	public @ResponseBody List<Par> obtenerLocalidades(Model model, @RequestParam("estado") int estado) {
		List<Par> l = dao.obtenerMunicipios(estado);
		return l;		
	}
}
