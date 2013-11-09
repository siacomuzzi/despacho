package despacho.backend.administradores;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.*;

import despacho.backend.entities.*;

@Stateless
public class AdministradorUsuariosBean implements AdministradorUsuarios {
	
	@PersistenceContext(unitName="portalweb.despacho")
	private EntityManager em;

	public void agregarUsuario(Usuario usuario) {	
		this.em.persist(usuario);
	}
	
	public List<Usuario> obtenerUsuarios() {
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = this.em.createQuery("FROM USUARIOS").getResultList();
		return usuarios;
	}
	
	public void actualizarUsuario(Usuario usuario) {
		this.em.merge(usuario);
	}
}
