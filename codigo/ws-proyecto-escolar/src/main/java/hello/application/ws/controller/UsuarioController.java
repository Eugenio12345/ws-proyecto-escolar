package hello.application.ws.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.application.ws.model.Producto;
import hello.application.ws.service.UsuarioService;

@Controller
public class UsuarioController {
	

	public static final String VISTA_LISTA = "index";
	public static final String VISTA_FORMULARIO = "formulario";
	
	
	private UsuarioService usuarioService;

	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	
	@Autowired
	public UsuarioController (UsuarioService usuarioService){
		this.usuarioService = usuarioService;
	}
	
	@GetMapping(value = "/listaModelMap")
	public String listarModelMap(ModelMap model) {
		model.addAttribute("titulo", nombreAplicacion);
		return VISTA_LISTA;
	}
	
	@GetMapping("/listaModelAndView")
	public ModelAndView listarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", nombreAplicacion);
		mav.setViewName(VISTA_LISTA);
		return mav;
	}
	

	@GetMapping("/")
	public String crear(Map<String, Object> model) {
		Producto producto = new Producto();
		model.put("producto", producto);
		model.put("titulo", nombreAplicacion);
		return VISTA_FORMULARIO;
	}

}
