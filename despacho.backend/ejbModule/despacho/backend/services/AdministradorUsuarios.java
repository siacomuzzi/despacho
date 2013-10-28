package despacho.backend.services;

import java.util.List;

import javax.ejb.Remote;

import despacho.backend.entities.Usuario;

@Remote
public interface AdministradorUsuarios {
	public void crearUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public void actualizarUsuario(Usuario usuario);
}
