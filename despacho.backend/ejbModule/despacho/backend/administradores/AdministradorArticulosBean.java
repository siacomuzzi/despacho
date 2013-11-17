package despacho.backend.administradores;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import despacho.backend.entities.Articulo;
import despacho.backend.entities.SolicitudArticulo;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {

	@PersistenceContext(unitName="portalweb.despacho")
	private EntityManager em;
	
	@Override
	public List<Articulo> listar() {
		@SuppressWarnings("unchecked")
		List<Articulo> articulos = this.em.createQuery(" FROM Articulo").getResultList();
		return articulos;
	}
	
	@Override
	public List<SolicitudArticulo> listarSolicitudes() {
		@SuppressWarnings("unchecked")
		List<SolicitudArticulo> solicitudes = this.em.createQuery(" FROM SolicitudArticulo").getResultList();
		return solicitudes;
	}
	
	@Override
	public void agregar(Articulo articulo) {
		if (this.get(articulo.getIdArticulo()) == null) {
			this.em.persist(articulo);
		}
	}
	
	@Override
	public void guardarSolicitud(SolicitudArticulo solicitud) {
		this.em.persist(solicitud);
	}
	
	@Override
	public Articulo get(String id) {
		return this.em.find(Articulo.class, id);
	}
}
