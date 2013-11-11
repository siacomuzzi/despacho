package despacho.backend.servicios;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.ejb.*;
import javax.jws.*;

import despacho.backend.administradores.*;
import despacho.backend.entities.*;
import despacho.backend.utils.Configuracion;
import despacho.backend.utils.Logger;
import despacho.backend.utils.MensajeAsincronico;
import despacho.backend.utils.MensajeSincronicoRest;
import despacho.backend.utils.MensajeSincronicoWS;

@Stateless
@WebService
public class ServicioOrdenesDespachoBean implements ServicioOrdenesDespacho {
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private AdministradorDepositos administradorDepositos;
	
	@EJB
	private AdministradorArticulos administradorArticulos;

	@Override
	@WebMethod
	// DCH02. Logistica ingresa nuevas ordenes de despacho
	public void ingresarOrdenDespacho(OrdenDespacho ordenDespacho) {
		Logger.info("Nueva Orden de despacho: " + ordenDespacho.getCodigo());
		
		// Se deben registrar como pendientes de entrega
		ordenDespacho.setEstado(EstadoOrdenDespacho.PENDIENTE_ENTREGA);
		this.administradorOrdenesDespacho.agregar(ordenDespacho);
		
		// Por cada articulo de la orden, se debe obtener el Deposito que lo administra y solicitarlo asincronicamente
		List<ArticuloOrdenDespacho> articulosOrden = ordenDespacho.getArticulos();
		
		if (articulosOrden != null) {
			for (ArticuloOrdenDespacho articuloOrden : articulosOrden) {
				String codigoArticulo = articuloOrden.getCodigo();
				Articulo articulo = this.administradorArticulos.get(codigoArticulo);
				
				if (articulo == null) {
					Logger.error("El articulo con codigo " + codigoArticulo + " no existe.");
					break;
				}
				
				// Obtengo el deposito asociado al articulo
				String nombreDeposito = articulo.getDeposito().getNombre();
				
				try {
					// TODO: ver el error al enviar el mensaje a la queue
					/*Logger.info("Solicitando articulo " + articulo.getCodigo() + " al deposito " + nombreDeposito + "...");
					
					// Solicitar articulo al deposito
					MensajeAsincronico.enviarObjeto(
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Url"),
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Nombre"), 
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Usuario"),
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Password"), 
							articuloOrden);*/
				} catch (Exception e) {
					e.printStackTrace();
					Logger.error(e.getMessage());
				}
				
				// Registrar la solicitud por Deposito
				SolicitudArticulo solicitud = new SolicitudArticulo();
				solicitud.setArticuloOrdenDespacho(articuloOrden);
				solicitud.setDeposito(nombreDeposito);
				solicitud.setEstado(EstadoSolicitudArticulo.SOLICITADO);
				this.administradorArticulos.guardarSolicitud(solicitud);
			}
		}
		
		Logger.info("Listo (DCH02)!");
	}
	
	@Override
	// DCH04. Envío Cambio de Estado de Despacho (Entrega)
	public void completarOrdenDespacho(String codigo) {
		// TODO: Quien llama a este metodo?
		Logger.info("Completar Orden de Despacho: " + codigo);
		
		OrdenDespacho orden = this.administradorOrdenesDespacho.get(codigo);
		if (orden == null) {
			Logger.error("La orden de despacho con codigo " + codigo + " no existe.");
			return;
		}
		
		// Informar a los portales que todos los articulos de una Orden de Despacho estén listos para Entrega
		for (String nombrePortal: Configuracion.getInstancia().getPortales()) {
			Logger.info("Informando al portal " + nombrePortal + " que la orden de despacho fue completada...");
			
			MensajeSincronicoWS.informarOrdenListaEntrega(null, nombrePortal); // TODO: ver que objeto enviar
		}
		
		// Informar en comunicación sincrónica (REST) al módulo Logística
		Logger.info("Informando a Logistica que la orden de despacho fue completada...");
		
		try {
			MensajeSincronicoRest.post(
					Configuracion.getInstancia().get().get("Logistica-OrdenDespachoListaRest-Url"), 
					null); // TODO: ver que objeto enviar
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage());
		}
		
		// El sistema debe registrar y cambiar de estado a la Orden de Despacho y marcarla como entregada
		orden.setEstado(EstadoOrdenDespacho.ENTREGADA);
		this.administradorOrdenesDespacho.actualizar(orden);
		
		Logger.info("Listo (DCH04)!");
	}
	
	@PostConstruct
	public void inicializacion () {
		// Inicializar Depositos
		String[] depositos = Configuracion.getInstancia().getDepositos();
		Deposito depositoA = new Deposito(depositos[0]);
		Deposito depositoB = new Deposito(depositos[1]);
		this.administradorDepositos.agregar(depositoA);
		this.administradorDepositos.agregar(depositoB);
		
		// Inicializar articulos (esto se va a hacer en DCH01)
		Articulo articulo1 = new Articulo("articulo01", depositoA);
		Articulo articulo2 = new Articulo("articulo02", depositoA);
		Articulo articulo3 = new Articulo("articulo03", depositoB);
		this.administradorArticulos.agregar(articulo1);
		this.administradorArticulos.agregar(articulo2);
		this.administradorArticulos.agregar(articulo3);
	}
}
