package despacho.web.controllers;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import despacho.backend.entities.Usuario;

@Controller
@RequestMapping("api/usuarios")
public class UsuarioApiController {
	
	@RequestMapping("")
	@ResponseBody
	public List<Usuario> getUsuarios() {
		// TODO
		Usuario u1 = new Usuario();
		u1.setUsername("pedro");
		u1.setActivo(true);
		Usuario u2 = new Usuario();
		u2.setUsername("santiago");
		u2.setActivo(false);
		
		List<Usuario> resultado = new ArrayList<Usuario>();
		resultado.add(u1);
		resultado.add(u2);
		
		return resultado;
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
