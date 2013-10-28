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
		u1.setUsername("pedro.garcia");
		u1.setApellido("Garcia");
		u1.setNombre("Pedro");
		u1.setActivo(true);
		
		Usuario u2 = new Usuario();
		u2.setUsername("santiago.perez");
		u2.setApellido("Perez");
		u2.setNombre("Santiago");
		u2.setActivo(false);
		
		Usuario u3 = new Usuario();
		u3.setUsername("maria.gonzales");
		u3.setApellido("Gonzales");
		u3.setNombre("Maria");
		u3.setActivo(true);
		
		Usuario u4 = new Usuario();
		u4.setUsername("juana.vazques");
		u4.setApellido("Vazques");
		u4.setNombre("Juana");
		u4.setActivo(true);
		
		Usuario u5 = new Usuario();
		u5.setUsername("esteban.zarate");
		u5.setApellido("Zarate");
		u5.setNombre("Esteban");
		u5.setActivo(true);
		
		List<Usuario> resultado = new ArrayList<Usuario>();
		resultado.add(u1);
		resultado.add(u2);
		resultado.add(u3);
		resultado.add(u4);
		resultado.add(u5);
		
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
