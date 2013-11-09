package despacho.backend.servicios;

import java.util.List;

import javax.ejb.*;

import despacho.backend.entities.Usuario;

@Remote
public interface ServicioUsuarios {
	public void crearUsuario(Usuario usuario);
	
	public List<Usuario> listarUsuarios();
	
	public void actualizarUsuario(Usuario usuario);
}
