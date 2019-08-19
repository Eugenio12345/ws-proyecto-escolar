package hello.application.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hello.application.ws.service.ProductoService;

@RestController
@RequestMapping("clientes")
public class ClienteController {

	private ProductoService productoService;

	public static final String MAIN = "main";
	public static final String VISTA_HISTORIA_PUEBLO = "historiaPueblo";

	@Autowired
	public ClienteController(ProductoService productoService) {
		this.productoService = productoService;
	}

	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	@GetMapping(value = "/listaModelMap")
	public String listarModelMap(ModelMap model) {
		model.addAttribute("titulo", nombreAplicacion);
		return "historiaPueblo";
	}

	@GetMapping("/listaModelAndView")
	public ModelAndView listarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", nombreAplicacion);
		mav.setViewName("historiaPueblo");
		return mav;
	}

	@GetMapping("/historiaPueblo")
	public String historiaPueblo(Model model) {
		model.addAttribute("nombreAplicacion", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		return VISTA_HISTORIA_PUEBLO;
	}

}
