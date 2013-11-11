package despacho.backend.servicios;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import despacho.backend.administradores.AdministradorArticulos;
import despacho.backend.administradores.AdministradorDepositos;
import despacho.backend.entities.Articulo;
import despacho.backend.entities.Deposito;
import despacho.backend.utils.Logger;

@Stateless
public class ServicioArticulosBean implements ServicioArticulos {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	@EJB
	private AdministradorDepositos administradorDepositos;
	
	@Override
	// DCH01.Recibir nuevo Artículo
	public void ingresarArticulo(Articulo articulo) {
		if (articulo == null) {
			return;
		}
		
		Deposito deposito = articulo.getDeposito();
		
		Logger.info("Nuevo articulo ingresado: " + articulo.getCodigo() + " - Deposito: " + deposito.getNombre());
		
		// Asegurarse que el deposito se persista
		this.administradorDepositos.agregar(deposito);
		
		// Persistir el articulo
		this.administradorArticulos.agregar(articulo);
		
		Logger.info("Listo (DCH01)!");
	}
}
