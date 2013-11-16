package despacho.backend.utils;

import java.util.Date;

import vo.MensajeLogVO;

public class Logger {
	public static void error(String evento, String message) {
		logMessage(evento, "[ERROR] " + message, true);
	}
	
	public static void info(String evento, String message) {
		logMessage(evento, "[INFO] " + message, false);
	}
	
	public static void warning(String evento, String message) {
		logMessage(evento, "[WARNING] " + message, true);
	}
	
	private static void logMessage(String evento, String message, Boolean error) {
		System.out.println(message);
		
		try {
			String logCodigoModulo = Configuracion.getInstancia().get().get("CodigoModuloParaLog");
			String modulo = Configuracion.getInstancia().get().get("NombreDespacho");
			String logAsincrono = Configuracion.getInstancia().get().get("logAsincrono");
			
			MensajeLogVO mensajeLog = new MensajeLogVO();
			mensajeLog.setCodModulo(Integer.parseInt(logCodigoModulo));
			mensajeLog.setModulo(modulo);
			mensajeLog.setEvento(evento);
			mensajeLog.setFecha(new Date());
			mensajeLog.setTipo(error ? 1 : 0);
			
			if (logAsincrono == "true") {
				// Log por queue
				MensajeAsincronico.enviarObjeto(
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Url"),
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Nombre"), 
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Usuario"),
						Configuracion.getInstancia().get().get("Auditoria-LoguearEventoQueue-Password"), 
						mensajeLog);
			}
			else if (logAsincrono == "false") {
				// Log por web service
				MensajeSincronicoWS.loguearEvento(mensajeLog);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
