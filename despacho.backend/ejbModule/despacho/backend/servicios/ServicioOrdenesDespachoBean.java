package despacho.backend.servicios;

import java.util.*;

import javax.ejb.*;
import javax.jws.*;

import despacho.backend.administradores.*;
import despacho.backend.entities.*;
import despacho.backend.utils.Configuracion;
import despacho.backend.utils.MensajeAsincronico;

@Stateless
@WebService
public class ServicioOrdenesDespachoBean implements ServicioOrdenesDespacho {
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private AdministradorDepositos administradorDepositos;

	@Override
	@WebMethod
	// DCH02. Logistica ingresa nuevas ordenes de despacho
	public void ingresarOrdenDespacho(OrdenDespacho ordenDespacho) {
		System.out.println("Nueva Orden de despacho: " + ordenDespacho.getCodigo());
		
		// TODO: inicializar todos los datos desde otro lado
		this.administradorDepositos.agregar(new Deposito("UNO"));
		
		// Se deben registrar como pendientes de entrega
		ordenDespacho.setEstado(EstadoOrdenDespacho.PENDIENTE_ENTREGA);
		
		// Por cada articulo de la orden, se debe obtener el Deposito que lo administra y solicitarlo asincronicamente
		List<ArticuloOrdenDespacho> articulos = ordenDespacho.getArticulos();
		
		if (articulos != null) {
			for (ArticuloOrdenDespacho articulo : articulos) {
				String nombreDeposito = articulo.getDeposito().getNombre();
				Deposito deposito = this.administradorDepositos.get(nombreDeposito);
				articulo.setDeposito(deposito);
				
				if (deposito != null) {
					try {
						// TODO: ver el error al enviar el mensaje a la queue
						/*System.out.println("Enviando articulo " + articulo.getCodigo() + " al deposito " + nombreDeposito);
						
						MensajeAsincronico.EnviarObjeto(
								Configuracion.get().get("Deposito-" + nombreDeposito + "-Queue-Url"),
								Configuracion.get().get("Deposito-" + nombreDeposito + "-Queue-Nombre"), 
								Configuracion.get().get("Deposito-" + nombreDeposito + "-Queue-Usuario"),
								Configuracion.get().get("Deposito-" + nombreDeposito + "-Queue-Password"), 
								articulo);*/
					} catch (Exception e) {
						// TODO: loguear errores
						e.printStackTrace();
					}
					
					// TODO: Se debe registrar la solicitud por Deposito
				}
				else {
					// TODO: Devolver una exception
					System.out.println("ERROR: El deposito " + nombreDeposito + " no existe.");
				}
			}
		}
		
		this.administradorOrdenesDespacho.agregar(ordenDespacho);
	}
}
