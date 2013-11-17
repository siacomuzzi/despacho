package despacho.backend.administradores;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.*;

import despacho.backend.entities.*;

@Stateless
public class AdministradorUsuariosBean implements AdministradorUsuarios {
	
	@PersistenceContext(unitName="portalweb.despacho")
	private EntityManager em;

	@Override
	public void agregar(Usuario usuario) {	
		this.em.persist(usuario);
	}
	
	@Override
	public List<Usuario> listar() {
		@SuppressWarnings("unchecked")
		List<Usuario> usuarios = this.em.createQuery(" FROM Usuario").getResultList();
		return usuarios;
	}
	
	@Override
	public void actualizar(Usuario usuario) {
		this.em.merge(usuario);
	}
	
	@Override
	public Usuario get(String username) {
		return this.em.find(Usuario.class, username);
	}
	
	@Override
	public void eliminar(String username) {
		Usuario usuario = this.get(username);
		if (usuario != null) {
			this.em.remove(usuario);
		}
	}
}
