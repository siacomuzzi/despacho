package despacho.backend.utils;

public class Logger {
	public static void error(String message) {
		logMessage("[ERROR] " + message);
	}
	
	public static void info(String message) {
		logMessage("[INFO] " + message);
	}
	
	public static void warning(String message) {
		logMessage("[WARNING] " + message);
	}
	
	private static void logMessage(String message) {
		// TODO: loguear en otro lado
		System.out.println(message);
	}
}
