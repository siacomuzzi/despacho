package despacho.backend.servicios;

import java.util.*;

import javax.ejb.*;
import javax.jws.*;

import ar.edu.uade.integracion.VO.ItemSolicitudArticuloVO;
import ar.edu.uade.integracion.VO.OrdenDespachoVO;
import ar.edu.uade.integracion.VO.SolicitudArticuloVO;
import despacho.backend.administradores.*;
import despacho.backend.entities.*;
import despacho.backend.utils.Configuracion;
import despacho.backend.utils.Logger;
import despacho.backend.utils.MensajeAsincronico;
import despacho.backend.utils.MensajeSincronicoRest;
import despacho.backend.utils.MensajeSincronicoWS;

@Stateless
@WebService(name = Configuracion.IngresoOrdenDespachoServiceName)
public class ServicioOrdenesDespachoBean implements ServicioOrdenesDespacho {
	
	@EJB
	private AdministradorOrdenesDespacho administradorOrdenesDespacho;
	
	@EJB
	private AdministradorArticulos administradorArticulos;

	@Override
	@WebMethod
	// DCH02. Logistica ingresa nuevas ordenes de despacho
	public void ingresarOrdenDespacho(OrdenDespachoVO ordenDespacho) {
		try {
			if (ordenDespacho == null) {
				return;
			}
			
			Logger.info("DCH02", "Nueva Orden de despacho con codigo: " + ordenDespacho.getCodOrden());
			
			List<SolicitudArticulo> articulos = new ArrayList<SolicitudArticulo>();
			
			// Por cada articulo de la orden, se debe obtener el Deposito que lo administra y solicitarlo asincronicamente
			List<ItemSolicitudArticuloVO> articulosOrden = ordenDespacho.getArticulos();
			
			if (articulosOrden != null) {
				for (ItemSolicitudArticuloVO articuloOrden : articulosOrden) {
					String codigoArticulo = articuloOrden.getIdArticulo();
					Articulo articulo = this.administradorArticulos.get(codigoArticulo);
					
					if (articulo == null) {
						Logger.error("DCH02", "El articulo con codigo " + codigoArticulo + " no existe.");
						break;
					}
					
					// Obtengo el deposito asociado al articulo
					String nombreDeposito = articulo.getIdDeposito();
					
					// Solicitar articulo
					Logger.info("DCH02", "Solicitando articulo " + articulo.getIdArticulo() + " al deposito " + nombreDeposito + "...");
				
					// El id de la solicitud es "{CodigoOrden}-{IdArticulo}"
					String idSolicitudArticulo = ordenDespacho.getCodOrden() + "-" + articuloOrden.getIdArticulo();
					
					List<ItemSolicitudArticuloVO> articulosSolicitud = new ArrayList<ItemSolicitudArticuloVO>();
					articulosSolicitud.add(articuloOrden);
					
					SolicitudArticuloVO solicitudDeposito = new SolicitudArticuloVO();
					solicitudDeposito.setEstado(EstadoSolicitudArticulo.SOLICITADO);
					solicitudDeposito.setFecha(new Date());
					solicitudDeposito.setIdDespacho(Configuracion.getInstancia().get().get("NombreDespacho"));
					solicitudDeposito.setIdSolicitudArticulo(idSolicitudArticulo);
					solicitudDeposito.setArticulos(articulosSolicitud);
					
					// Solicitar articulo al deposito
					MensajeAsincronico.enviarObjeto(
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Url"),
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Nombre"), 
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Usuario"),
							Configuracion.getInstancia().get().get(nombreDeposito + "-SolicitarArticuloQueue-Password"), 
							solicitudDeposito);
					
					// Guardar la solicitud por Deposito
					SolicitudArticulo solicitud = new SolicitudArticulo();
					solicitud.setId(idSolicitudArticulo);
					solicitud.setEstado(EstadoSolicitudArticulo.SOLICITADO);
					solicitud.setCantidad(articuloOrden.getCantSolicitada());
					solicitud.setArticulo(articulo);
					solicitud.setFecha(solicitudDeposito.getFecha());
					solicitud.setCodigoOrden(ordenDespacho.getCodOrden());
					solicitud.setIdDeposito(nombreDeposito);
					
					articulos.add(solicitud);
				}
			}
			
			// Guardar la orden. Se deben registrar como pendientes de entrega
			OrdenDespacho nuevaOrdenDespacho = new OrdenDespacho();
			nuevaOrdenDespacho.setEstado(EstadoOrdenDespacho.PENDIENTE_ENTREGA);
			nuevaOrdenDespacho.setCodOrden(ordenDespacho.getCodOrden());
			nuevaOrdenDespacho.setCodPortal(ordenDespacho.getCodPortal());
			nuevaOrdenDespacho.setCodVenta(ordenDespacho.getCodVenta());
			nuevaOrdenDespacho.setFecha(new Date());
			nuevaOrdenDespacho.setNombreUsuario(ordenDespacho.getNombreUsuario());
			nuevaOrdenDespacho.setArticulos(articulos);
			this.administradorOrdenesDespacho.agregar(nuevaOrdenDespacho);
			
			Logger.info("DCH02", "Listo (DCH02 - Logistica ingresa nuevas ordenes de despacho)");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH02", e.getMessage());
		}
	}
	
	@Override
	// DCH04. Env�o Cambio de Estado de Despacho (Entrega)
	public void completarOrdenDespacho(String codigo) {
		try {
			// TODO: Quien llama a este metodo?
			Logger.info("DCH04", "Completar Orden de Despacho: " + codigo);
			
			OrdenDespacho orden = this.administradorOrdenesDespacho.get(codigo);
			if (orden == null) {
				Logger.error("DCH04", "La orden de despacho con codigo " + codigo + " no existe.");
				return;
			}
			
			// Informar a los portales que todos los articulos de una Orden de Despacho est�n listos para Entrega
			for (String nombrePortal: Configuracion.getInstancia().getPortales()) {
				Logger.info("DCH04", "Informando al portal " + nombrePortal + " que la orden de despacho fue completada...");
				
				MensajeSincronicoWS.informarOrdenListaEntrega(null, nombrePortal); // TODO: ver que objeto enviar
			}
			
			// Informar en comunicaci�n sincr�nica (REST) al m�dulo Log�stica
			Logger.info("DCH04", "Informando a Logistica que la orden de despacho fue completada...");
			
			MensajeSincronicoRest.post(
					Configuracion.getInstancia().get().get("Logistica-OrdenDespachoListaRest-Url"), 
					null); // TODO: ver que objeto enviar
			
			// El sistema debe registrar y cambiar de estado a la Orden de Despacho y marcarla como entregada
			orden.setEstado(EstadoOrdenDespacho.ENTREGADA);
			this.administradorOrdenesDespacho.actualizar(orden);
			
			Logger.info("DCH04", "Listo (DCH04 - Env�o Cambio de Estado de Despacho (Entrega))");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH04", e.getMessage());
		}
	}
}
