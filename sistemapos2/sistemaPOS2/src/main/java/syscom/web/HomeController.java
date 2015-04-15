package syscom.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStreamImpl;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.xml.ws.transport.tcp.io.OutputWriter;

import syscom.dao.PersonasDAO;
import syscom.domain.Par;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
	
	@Autowired
	PersonasDAO dao;

	@RequestMapping(method=RequestMethod.GET)
	public String menuPrincipal(HashMap model) {	
		System.out.println("ok");
		return "home";
	} 	
	
	@RequestMapping("/municipios")
	public @ResponseBody List<Par> obtenerLocalidades(Model model, @RequestParam("estado") int estado) {
		List<Par> l = dao.obtenerMunicipios(estado);
		return l;		
	}
	
	@RequestMapping("/imagenes")
	public @ResponseBody void obtenerImagen(Model model, @RequestParam("imagen") String imagen, HttpServletResponse response) throws IOException {
		if(imagen.equals("")) return;
		File file = new File("c://imagenes/"+imagen);		
		BufferedImage image = ImageIO.read(file);
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}
	
	@RequestMapping("/imagenesProductos")
	public @ResponseBody void obtenerImagenProducto(Model model, @RequestParam("imagen") String imagen, HttpServletResponse response) throws IOException {
		File file = new File("c://imagenes/productos/"+imagen);		
		BufferedImage image = ImageIO.read(file);
		OutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
	}
}
