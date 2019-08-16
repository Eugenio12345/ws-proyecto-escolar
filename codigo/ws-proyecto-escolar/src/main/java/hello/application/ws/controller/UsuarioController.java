package hello.application.ws.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.application.ws.model.Producto;
import hello.application.ws.model.Usuario;
import hello.application.ws.service.ProductoService;
import hello.application.ws.service.UsuarioService;

@Controller
public class UsuarioController {
	

	public static final String INDEX = "index";
	public static final String VISTA_LISTA = "lista";
	
	
	private UsuarioService usuarioService;

	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;
	
	@Value("${aplicacion.mensaje.error}")
	private String mensajeError;
	
	private ProductoService productoService;
	
	@Autowired
	public UsuarioController (UsuarioService usuarioService, ProductoService productoService){
		this.usuarioService = usuarioService;
		this.productoService = productoService;
	}
	
	@GetMapping(value = "/listaModelMap")
	public String listarModelMap(ModelMap model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("mensajeError",mensajeError);
		return INDEX;
	}
	
	@GetMapping("/listaModelAndView")
	public ModelAndView listarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", nombreAplicacion);
		mav.addObject("productos", productoService.getAll());
		mav.setViewName(INDEX);
		return mav;
	}
	

	@GetMapping("/")
	public String crear(Map<String, Object> model) {
		Usuario  usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", nombreAplicacion);
		
		return INDEX;
	}
	
	@GetMapping("/validar")
	public String validar(Usuario usuario) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", nombreAplicacion);
		mav.addObject("productos", productoService.getAll());
		System.out.println("EL USUARIO EXISTE::::"+ usuarioService.validarUsuario(usuario));
		return usuarioService.validarUsuario(usuario) ? VISTA_LISTA : INDEX;
	}

	@GetMapping("/registraCuenta")
	public String registraCuenta(Map<String, Object> model) {
		Usuario producto = new Usuario();
		model.put("usuario", producto);
		model.put("titulo", nombreAplicacion);
		return "createAccount";
	}
	
	@PostMapping("/crearCuenta")
	public String crearCuenta(Usuario usuario){
		System.out.println("GUARDANDO DATOS::::");
		if(!usuario.getContrasena().equals(usuario.getConfirmPassword())){
			return "redirect:";
		}
		usuarioService.crearUsuario(usuario);
		System.out.println("ACTUALIZANDO LISTA DE USUARIOS");
		this.usuarioService.cargarUsuarios().stream().forEach(s->{
			System.out.println("USUARIO: "+ s.getNombreUsuario()+"  PASSWORD "+ s.getContrasena());
		});
		return "redirect:";
	}
}
