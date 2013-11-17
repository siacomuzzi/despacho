package despacho.web.controllers;

import java.util.*;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import despacho.backend.entities.Usuario;
import despacho.web.infrastructure.BusinessDelegate;

@Controller
@RequestMapping("api/usuarios")
public class UsuarioApiController {
	
	@RequestMapping("")
	@ResponseBody
	public List<Usuario> getUsuarios() throws NamingException {
		return BusinessDelegate.getInstance().listar();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void crearUsuario(Usuario usuario) throws NamingException {
		BusinessDelegate.getInstance().agregar(usuario);
	}
	
	@RequestMapping(value="{username}", method=RequestMethod.PUT)
	@ResponseBody
	public void actualizarUsuario(@PathVariable String username, Usuario usuario) throws NamingException {
		usuario.setUsername(username);
		BusinessDelegate.getInstance().actualizar(usuario);
	}
	
	@RequestMapping(value="{username}", method=RequestMethod.DELETE)
	public void eliminarUsuario(@PathVariable String username) {
		// TODO
	}
}
