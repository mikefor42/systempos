package syscom.web;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public String menuPrincipal(HashMap model) {	
		System.out.println("ok");
		return "home";
	} 	
}
