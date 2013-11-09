package despacho.backend.utils;

import java.util.*;

public class Configuracion {
	
	public static Map<String, String> get() {
		// TODO: manipular toda la informacion de configuracion desde una pagina web
		Map<String, String> configuracion = new HashMap<String, String>();
		
		// Configuracion de DepositoA
		configuracion.put("DepositoA-Nombre", "UNO");
		configuracion.put("Deposito-" + configuracion.get("DepositoA-Nombre") + "-Queue-Url", "remote://localhost:4447");
		configuracion.put("Deposito-" + configuracion.get("DepositoA-Nombre") + "-Queue-Nombre", "jms/queue/test");
		configuracion.put("Deposito-" + configuracion.get("DepositoA-Nombre") + "-Queue-Usuario", "test");
		configuracion.put("Deposito-" + configuracion.get("DepositoA-Nombre") + "-Queue-Password", "test123");
		
		configuracion.put("DepositoB-Nombre", "DOS");
		configuracion.put("Deposito-" + configuracion.get("DepositoB-Nombre") + "-Queue-Url", "remote://localhost:4447");
		configuracion.put("Deposito-" + configuracion.get("DepositoB-Nombre") + "-Queue-Nombre", "jms/queue/test");
		configuracion.put("Deposito-" + configuracion.get("DepositoB-Nombre") + "-Queue-Usuario", "test");
		configuracion.put("Deposito-" + configuracion.get("DepositoB-Nombre") + "-Queue-Password", "test123");
				
		return configuracion;
	}
}
