package despacho.backend.administradores;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import despacho.backend.entities.*;

@Stateless
public class AdministradorOrdenesDespachoBean implements AdministradorOrdenesDespacho {
	
	@PersistenceContext(unitName="portalweb.despacho")
	private EntityManager em;

	public void agregar(OrdenDespacho ordenDespacho) {	
		this.em.persist(ordenDespacho);
	}
	
	public List<OrdenDespacho> listar() {
		@SuppressWarnings("unchecked")
		List<OrdenDespacho> ordenesDespacho = this.em.createQuery("FROM ORDENES_DESPACHO").getResultList();
		return ordenesDespacho;
	}
	
	public void actualizar(OrdenDespacho ordenDespacho) {
		this.em.merge(ordenDespacho);
	}
}