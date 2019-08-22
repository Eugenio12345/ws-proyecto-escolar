package hello.application.ws.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import hello.application.ws.model.Usuario;
import hello.application.ws.service.ProductoService;
import hello.application.ws.service.UsuarioService;

@Controller
public class UsuarioController {

	public static final String INDEX = "index";
	public static final String VISTA_LISTA = "lista";
	public static final String VISTA_LISTA_USUARIOS = "listaUsuarios";
	public static final String CREATE_ACCOUNT = "createAccount";
	public static final String VISTA_PRINCIPAL = "main";
	public static final String VISTA_ACTUALIZAR_USUARIOS = "updateUser";

	private UsuarioService usuarioService;

	private ProductoService productoService;
	
	@Value("${aplicacion.nombre}")
	private String nombreAplicacion;

	@Value("${aplicacion.mensaje.error}")
	private String mensajeError;

	@Autowired
	public UsuarioController(UsuarioService usuarioService, ProductoService productoService) {
		this.usuarioService = usuarioService;
		this.productoService = productoService;
	}

	@GetMapping("/usuarios/lista")
	public String listar(Model model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("usuarios", usuarioService.cargarUsuarios());
		return VISTA_LISTA_USUARIOS;
	}

	@GetMapping(value = "/listaModelMap")
	public String listarModelMap(ModelMap model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		model.addAttribute("mensajeError", mensajeError);
		return INDEX;
	}

	@GetMapping("/listaModelAndView")
	public ModelAndView listarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("titulo", nombreAplicacion);
		mav.addObject("productos", productoService.getAll());
		mav.addObject("mensajeError", mensajeError);
		mav.setViewName(INDEX);
		return mav;
	}

	@GetMapping("/")
	public String crear(Map<String, Object> model) {
		Usuario usuario = new Usuario();
		model.put("usuario", usuario);
		model.put("titulo", nombreAplicacion);
		return INDEX;
	}

	@GetMapping("/validar")
	public String validar(Usuario usuario, Model model) {
		model.addAttribute("titulo", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		Usuario user = usuarioService.obtenerPorNombreYPass(usuario);
		if (user!=null) {
			if (user.getRol().equals("administrador")) {
			   return VISTA_LISTA;
			}
			return VISTA_PRINCIPAL;
		} else {
			return INDEX;
		}

	}

	@GetMapping("/registraCuenta")
	public String registraCuenta(Map<String, Object> model) {
		Usuario producto = new Usuario();
		model.put("usuario", producto);
		model.put("titulo", nombreAplicacion);
		return CREATE_ACCOUNT;
	}

	@PostMapping("/crearCuenta")
	public String crearCuenta(Usuario usuario, Map<String, Object>  model) {
		
		System.out.println("GUARDANDO DATOS::::");
		usuario.setRol(usuario.getRol() != null ? usuario.getRol() : "usuario");
		if(usuario.getIdUsuario()!=null){
			usuarioService.crearActualizarUsuario(usuario);
			model.put("usuarios", usuarioService.cargarUsuarios());
			return VISTA_LISTA_USUARIOS;
		}
		if (!usuario.getContrasena().equals(usuario.getConfirmPassword())) {
			model.put("mensajeError", mensajeError);
			return CREATE_ACCOUNT;
		}
		usuarioService.crearActualizarUsuario(usuario);
		return "redirect:";
	}

	@GetMapping("/usuarios/actualizar/{id}")
	public String actualizar(@PathVariable(value = "id") Integer idUsuario,  Map<String, Object> model) {
		Usuario usuario = usuarioService.obtenerPorId(idUsuario);
	    System.out.println("NOMBRE "+usuario.getNombreUsuario());
		model.put("usuario", usuario);
		return VISTA_ACTUALIZAR_USUARIOS;
	}
	
	@GetMapping("/usuarios/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer idProducto) {
		usuarioService.eliminarUsuario(idProducto);
		return "redirect:../" + VISTA_LISTA;
	}
	
	@GetMapping("/clientes/historiaPueblo")
	public String historiaPueblo(Model model) {
		model.addAttribute("nombreAplicacion", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		return "historiaPueblo";
	}
	
	@GetMapping("/clientes/productos")
	public String productos(Model model) {
		model.addAttribute("nombreAplicacion", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		return "productosMezcal";
	}
	
	@GetMapping("/clientes/ubicacionMapa")
	public String ubicacionMapa(Model model) {
		model.addAttribute("nombreAplicacion", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		return "ubicacionMapa";
	}
	
	@GetMapping("/clientes/ubicacionFrame")
	public String ubicacionFrame(Model model) {
		model.addAttribute("nombreAplicacion", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		return "ubicacionFrame";
	}
    
	@GetMapping("/clientes/main")
	public String main(Model model) {
		model.addAttribute("nombreAplicacion", nombreAplicacion);
		model.addAttribute("productos", productoService.getAll());
		return "main";
	}
}