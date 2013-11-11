package despacho.backend.utils;

import java.net.URL;



import ws.ObtenerEstado;
import ws.ObtenerEstadoServiceLocator;
//import ws.ObtenerEstado;
//import ws.ObtenerEstadoServiceLocator;
import despacho.backend.entities.OrdenDespacho;

public class MensajeSincronicoWS {
	
	public static void informarOrdenListaEntrega(OrdenDespacho orden, String nombrePortal) {
		String url = Configuracion.getInstancia().get().get(nombrePortal + "-OrdenDespachoListaWS-Url");
		
		try {
			// TODO: ObtenerEstado port = new ObtenerEstadoServiceLocator().getObtenerEstadoPort(new URL(url));
			//port.cambioEstadoEntrega(0, "");
		} catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage());
		}
	}
}
