package despacho.backend.api;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import despacho.backend.administradores.AdministradorArticulos;
import despacho.backend.entities.Articulo;
import despacho.backend.entities.SolicitudArticulo;

public class ArticulosAdminBusinessDelegate implements AdministradorArticulos {
	
	static ArticulosAdminBusinessDelegate instancia = null;
	AdministradorArticulos administradorArticulos;
	
	public static ArticulosAdminBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new ArticulosAdminBusinessDelegate();
		}
		
		return instancia;
	}
	
	private ArticulosAdminBusinessDelegate() throws NamingException {

		try {
			final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProperties.put("remote.connectionprovider.create.options.org.xnio.Options.SSL_ENABLED", "false");
			jndiProperties.put("remote.connections", "default");
			jndiProperties.put("remote.connection.default.host", "localhost");
			jndiProperties.put("remote.connection.default.port", "4447");
			jndiProperties.put("remote.connection.default.connect.options.org.xnio.Options.SASL_POLICY_NOANONYMOUS", "false");

			final Context context = new InitialContext(jndiProperties);

			final String earAppName = "despacho.backendEAR";
			final String ejbModuleName = "despacho.backend";
			final String distinctName = "";
			final String beanName = "AdministradorArticulosBean";
			final String viewClassName = AdministradorArticulos.class.getName();
			String url = 
					"ejb:" + earAppName + "/" + ejbModuleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

			System.out.println("Looking EJB via JNDI");
			System.out.println(url);

			administradorArticulos = (AdministradorArticulos) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
		}
	}

	@Override
	public void agregar(Articulo articulo) {
		
	}

	@Override
	public void guardarSolicitud(SolicitudArticulo solicitud) {
	}

	@Override
	public Articulo get(String id) {
		return null;
	}

	@Override
	public List<Articulo> listar() {
		return this.administradorArticulos.listar();
	}
	
}

