package despacho.backend.utils;

import java.util.*;

public class Configuracion {
	// TODO: manipular toda la informacion de configuracion desde una pagina web
	private static Map<String, String> configuracion = new HashMap<String, String>();
	private static Configuracion instance = null;
	
	private Configuracion() {
		// Configuracion de Depositos
		configuracion.put("Depositos", "DepositoA;DepositoB;DepositoC");
		
		// Configuracion de DepositoA
		configuracion.put("DepositoA-SolicitarArticuloQueue-Url", "remote://localhost:4447");
		configuracion.put("DepositoA-SolicitarArticuloQueue-Nombre", "jms/recepcionDespachoQueue");
		configuracion.put("DepositoA-SolicitarArticuloQueue-Usuario", "test");
		configuracion.put("DepositoA-SolicitarArticuloQueue-Password", "test123");
		
		// Configuracion de DepositoB
		configuracion.put("DepositoB-SolicitarArticuloQueue-Url", "remote://172.16.176.33:5445");
		configuracion.put("DepositoB-SolicitarArticuloQueue-Nombre", "jms/recepcionDespachoQueue");
		configuracion.put("DepositoB-SolicitarArticuloQueue-Usuario", "jms");
		configuracion.put("DepositoB-SolicitarArticuloQueue-Password", "jms2013");
		
		// Configuracion de DepositoC
		configuracion.put("DepositoC-SolicitarArticuloQueue-Url", "remote://172.16.176.32:5445");
		configuracion.put("DepositoC-SolicitarArticuloQueue-Nombre", "jms/recepcionDespachoQueue");
		configuracion.put("DepositoC-SolicitarArticuloQueue-Usuario", "jms");
		configuracion.put("DepositoC-SolicitarArticuloQueue-Password", "jms2013");
		
		// Configuracion de Portales
		configuracion.put("Portales", "PortalA;PortalB");
		configuracion.put("PortalA-OrdenDespachoListaWS-Url", "https://192.168.X.XXX/ordenDespachoLista?wsdl");
		configuracion.put("PortalB-OrdenDespachoListaWS-Url", "https://192.168.Y.YYY/ordenDespachoLista?wsdl");
		
		// Configuracion de Despacho
		configuracion.put("NombreDespacho", "DespachoA");
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
