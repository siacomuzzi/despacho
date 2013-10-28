package despacho.web.controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/usuarios")
public class UsuarioApiController {
	
	@RequestMapping("")
	@ResponseBody
	public List<Usuario> getUsuarios() {
		// TODO
		return new ArrayList<Usuario>();
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public void crearUsuario(Usuario usuario) {
		// TODO
	}
	
	@RequestMapping(value="{username}", method=RequestMethod.PUT)
	@ResponseBody
	public void actualizarUsuario(@PathVariable String username, Usuario usuario) {
		// TODO
	}
	
	@RequestMapping(value="{username}", method=RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable String username) {
		// TODO
	}
}
