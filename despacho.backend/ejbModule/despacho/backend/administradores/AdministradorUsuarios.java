package despacho.backend.administradores;

import java.util.List;

import javax.ejb.*;

import despacho.backend.entities.*;

@Local
public interface AdministradorUsuarios {
	void agregar(Usuario usuario);
	
	List<Usuario> listar();
	
	void actualizar(Usuario usuario);
	
	Usuario get(String username);
	
	void eliminar(String username);
}
