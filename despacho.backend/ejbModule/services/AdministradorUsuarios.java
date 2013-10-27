package services;

import java.util.List;

import javax.ejb.Local;

import entities.Usuario;

@Local
public interface AdministradorUsuarios {
	public void crearUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public void actualizarUsuario(Usuario usuario);
}
