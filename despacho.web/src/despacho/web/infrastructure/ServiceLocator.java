package despacho.web.infrastructure;

import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
	IService service;
	   
	public IService getServiceBusinessObject(String url) throws NamingException {
		if (service == null) {
			Properties properties = new Properties();
			properties.put("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
			properties.put("java.naming.factory.url.pkgs", "org.jboss.namingrg.jnp.interfaces");
			properties.put("java.naming.provider.url", "127.0.0.1:1099"); // TODO: Obtener url de un archivo de configuracion
			
			InitialContext ctx = new InitialContext(properties);
			service = (IService)ctx.lookup(url);
		}
		
		return service;
   }
}