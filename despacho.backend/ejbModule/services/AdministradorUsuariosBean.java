package services;

import java.util.*;

import javax.ejb.Stateless;
import javax.persistence.*;

import entities.*;

@Stateless
public class AdministradorUsuariosBean implements AdministradorUsuarios {
	@PersistenceContext
    private EntityManager em;

	public void crearUsuario(Usuario usuario) {	
		this.em.persist(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> obtenerUsuarios() {
		return this.em.createQuery("FROM USUARIOS").getResultList();
	}
	
	public void actualizarUsuario(Usuario usuario) {
		this.em.merge(usuario);
	}
}
