package despacho.backend.administradores;

import java.util.List;

import javax.ejb.*;

import despacho.backend.entities.Usuario;

@Local
public interface AdministradorUsuarios {
	public void agregarUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public void actualizarUsuario(Usuario usuario);
}
