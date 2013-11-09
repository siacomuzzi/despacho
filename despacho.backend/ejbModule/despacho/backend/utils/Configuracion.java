package despacho.backend.utils;

import java.util.*;

public class Configuracion {
	
	private static Map<String, String> configuracion;
	
	public Configuracion() {
		// TODO: manipular toda la informacion de configuracion desde una pagina web
		configuracion = new HashMap<String, String>();
		
		// Configuracion de la queue de Deposito "UNO"
		configuracion.put("Deposito-UNO-Queue-Url", "remote://localhost:4447");
		configuracion.put("Deposito-UNO-Queue-Nombre", "jms/queue/test");
		configuracion.put("Deposito-UNO-Queue-Usuario", "test");
		configuracion.put("Deposito-UNO-Queue-Password", "password");
	}
	
	public static Map<String, String> get() {
		return configuracion;
	}
}
