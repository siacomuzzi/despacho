package despacho.backend.utils;

import java.util.*;

public class Configuracion {
	// TODO: manipular toda la informacion de configuracion desde una pagina web
	private static Map<String, String> configuracion = new HashMap<String, String>();
	private static Configuracion instance = null;
	
	public static final String IngresoOrdenDespachoServiceName = "ServicioOrdenesDespacho";
	public static final String IngresoArticuloQueueName = "queue/NuevoArticulo";
	
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
		configuracion.put("Portales", "PortalA;PortalB");
		configuracion.put("PortalA-OrdenDespachoListaWS-Url", "https://192.168.X.XXX/ordenDespachoLista?wsdl");
		configuracion.put("PortalB-OrdenDespachoListaWS-Url", "https://192.168.Y.YYY/ordenDespachoLista?wsdl");
		
		// Configuracion de Despacho
		configuracion.put("NombreDespacho", "DespachoA");
		configuracion.put("CodigoModuloParaLog", "999");
		
		// Configuracion de Auditoria
		configuracion.put("logAsincrono", "true");
		configuracion.put("Auditoria-LoguearEventoWS-Url", "https://192.168.X.XXX/loguearEvento?wsdl");
		configuracion.put("Auditoria-LoguearEventoQueue-Url", "ConnectionFactoryAuditoriaA");
		configuracion.put("Auditoria-LoguearEventoQueue-Nombre", "loguearEventosQueue");
		configuracion.put("Auditoria-LoguearEventoQueue-Usuario", "jms");
		configuracion.put("Auditoria-LoguearEventoQueue-Password", "jms2013");
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
