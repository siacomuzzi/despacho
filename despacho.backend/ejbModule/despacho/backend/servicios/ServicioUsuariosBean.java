package despacho.backend.servicios;

import java.util.List;

import javax.ejb.*;

import despacho.backend.administradores.AdministradorUsuarios;
import despacho.backend.entities.Usuario;

@Stateless
public class ServicioUsuariosBean implements ServicioUsuarios {

	@EJB
	private AdministradorUsuarios administradorUsuarios;
	
	@Override
	public void crearUsuario(Usuario usuario) {
		this.administradorUsuarios.agregar(usuario);
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return this.administradorUsuarios.listar();
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		this.administradorUsuarios.actualizar(usuario);
	}
}
