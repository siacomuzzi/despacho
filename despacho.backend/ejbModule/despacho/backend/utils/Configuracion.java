package despacho.backend.utils;

import java.util.*;

public class Configuracion {
	private static Map<String, String> configuracion = new HashMap<String, String>();
	private static Configuracion instance = null;
	
	public static final String IngresoOrdenDespachoServiceName = "ServicioOrdenesDespacho";
	public static final String IngresoArticuloQueueName = "queue/recepcionDepositoArticulos";
	
	private Configuracion() {
		// Configuracion de Depositos
		configuracion.put("Depositos", "DepositoA;DepositoB;DepositoC");
		
		// Configuracion de DepositoA
		configuracion.put("DepositoA-SolicitarArticuloQueue-Url", "ConnectionFactoryDepositoA");
		configuracion.put("DepositoA-SolicitarArticuloQueue-Nombre", "RecibirSolicitudArticulo");
		configuracion.put("DepositoA-SolicitarArticuloQueue-Usuario", "msg");
		configuracion.put("DepositoA-SolicitarArticuloQueue-Password", "msg2013");
		
		// Configuracion de DepositoB
		configuracion.put("DepositoB-SolicitarArticuloQueue-Url", "ConnectionFactoryDepositoB");
		configuracion.put("DepositoB-SolicitarArticuloQueue-Nombre", "recepcionDespachoQueue");
		configuracion.put("DepositoB-SolicitarArticuloQueue-Usuario", "jms");
		configuracion.put("DepositoB-SolicitarArticuloQueue-Password", "jms2013");
		
		// Configuracion de DepositoC
		configuracion.put("DepositoC-SolicitarArticuloQueue-Url", "ConnectionFactoryDepositoC");
		configuracion.put("DepositoC-SolicitarArticuloQueue-Nombre", "recepcionDespachoQueue");
		configuracion.put("DepositoC-SolicitarArticuloQueue-Usuario", "jms");
		configuracion.put("DepositoC-SolicitarArticuloQueue-Password", "jms2013");
		
		// Configuracion de Portales
		configuracion.put("Portales", "PortalA;PortalB;PortalC");
		configuracion.put("PortalA-OrdenDespachoListaWS-Url", "http://192.168.1.112/Portal/ObtenerEstado");
		configuracion.put("PortalB-OrdenDespachoListaWS-Url", "http://192.168.Y.YYY/Portal/ObtenerEstado");
		configuracion.put("PortalC-OrdenDespachoListaWS-Url", "http://192.168.1.108/Portal/ObtenerEstado");
		
		// Configuracion de Despacho
		configuracion.put("NombreDespacho", "DespachoA");
		configuracion.put("CodigoModuloParaLog", "12");
		
		// Configuracion de Auditoria
		configuracion.put("logAsincrono", "");
		configuracion.put("Auditoria-LoguearEventoWS-Url", "http://192.168.1.124:8080/IntegracionAplicaciones/AdminAuditoriaBean");
		configuracion.put("Auditoria-LoguearEventoQueue-Url", "ConnectionFactoryAuditoriaA");
		configuracion.put("Auditoria-LoguearEventoQueue-Nombre", "recibirInformeAuditoria");
		configuracion.put("Auditoria-LoguearEventoQueue-Usuario", "test");
		configuracion.put("Auditoria-LoguearEventoQueue-Password", "test123");
		configuracion.put("Auditoria-OrdenDespachoListaRest-Url", "http://192.168.1.124:8080/IntegracionAplicaciones");
	}
	
	public static Configuracion getInstancia() {
		if (instance == null) {
			instance = new Configuracion();
		}
		
		return instance;
	}
	
	public String[] getDepositos() {
		return configuracion.get("Depositos").split(";");
	}
	
	public String[] getPortales() {
		return configuracion.get("Portales").split(";");
	}
	
	public Map<String, String> get() {
		return configuracion;
	}
}
