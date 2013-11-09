package despacho.backend.servicios;

import java.util.*;

import javax.ejb.*;
import javax.jws.*;

import despacho.backend.administradores.*;
import despacho.backend.entities.*;
import despacho.backend.utils.*;

@Stateless
@WebService
public class ServicioOrdenesDespachoBean implements ServicioOrdenesDespacho {
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;

	@Override
	@WebMethod
	// DCH02. Logistica ingresa nuevas ordenes de despacho
	public void ingresarOrdenDespacho(OrdenDespacho ordenDespacho) {
		if (ordenDespacho == null) {
			return;
		}
		
		System.out.println("Nueva Orden de despacho: " + ordenDespacho.getCodigo());
		
		// Se deben registrar como pendientes de entrega
		ordenDespacho.setEstado(EstadoOrdenDespacho.PENDIENTE_ENTREGA);
		
		// Por cada articulo de la orden, se debe obtener el Deposito que lo administra y solicitarlo asincronicamente
		List<ArticuloOrdenDespacho> articulos = ordenDespacho.getArticulos();
		
		if (articulos != null) {
			for (ArticuloOrdenDespacho articulo : articulos) {
				Deposito deposito = articulo.getDeposito();
				
				if (deposito != null) {
					try {
						System.out.println("Enviando articulo " + articulo.getCodigo() + " al deposito " + deposito.getNombre());
						
						MensajeAsincronico.EnviarObjeto(
								Configuracion.get().get("Deposito-" + deposito.getNombre() + "-Queue-Url"),
								Configuracion.get().get("Deposito-" + deposito.getNombre() + "-Queue-Nombre"), 
								Configuracion.get().get("Deposito-" + deposito.getNombre() + "-Queue-Usuario"),
								Configuracion.get().get("Deposito-" + deposito.getNombre() + "-Queue-Password"), 
								articulo);
					} catch (Exception e) {
						// TODO: loguear errores
						e.printStackTrace();
					}
				}
			}
		}
		
		// TODO: Se debe registrar la solicitud por Deposito
		this.administradorOrdenesDespacho.agregar(ordenDespacho);
	}
}
