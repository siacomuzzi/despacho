package despacho.backend.servicios;

import java.util.List;

import javax.ejb.*;

import despacho.backend.entities.Usuario;

@Remote
public interface ServicioUsuarios {
	void crearUsuario(Usuario usuario);
	
	List<Usuario> listarUsuarios();
	
	void actualizarUsuario(Usuario usuario);
}
