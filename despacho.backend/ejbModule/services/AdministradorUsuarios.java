package services;

import java.util.List;
import entities.Usuario;

public interface AdministradorUsuarios {
	public void crearUsuario(Usuario usuario);
	
	public List<Usuario> obtenerUsuarios();
	
	public void actualizarUsuario(Usuario usuario);
}
