package despacho.backend.administradores;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import despacho.backend.entities.Deposito;

@Stateless
public class AdministradorDepositosBean implements AdministradorDepositos {

	@PersistenceContext(unitName="portalweb.despacho")
	private EntityManager em;
	
	@Override
	public void agregar(Deposito deposito) {
		if (this.get(deposito.getNombre()) == null) {
			this.em.persist(deposito);
		}
	}
	
	@Override
	public Deposito get(String id) {
		return this.em.find(Deposito.class, id);
	}
}
