package despacho.backend.administradores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import despacho.backend.entities.Articulo;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {

	@PersistenceContext(unitName="portalweb.despacho")
	private EntityManager em;
	
	@Override
	public void agregar(Articulo articulo) {
		if (this.get(articulo.getCodigo()) == null) {
			this.em.persist(articulo);
		}
	}
	
	@Override
	public Articulo get(String id) {
		return this.em.find(Articulo.class, id);
	}
}
