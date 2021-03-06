package despacho.backend.api;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ar.edu.uade.integracion.VO.ArticuloVO;
import ar.edu.uade.integracion.VO.SolicitudArticuloVO;
import despacho.backend.servicios.ServicioArticulos;

public class ArticulosBusinessDelegate implements ServicioArticulos {

	static ArticulosBusinessDelegate instancia = null;
	ServicioArticulos servicioArticulos;
	
	public static ArticulosBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new ArticulosBusinessDelegate();
		}
		
		return instancia;
	}
	
	private ArticulosBusinessDelegate() throws NamingException {

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
			final String beanName = "ServicioArticulosBean";
			final String viewClassName = ServicioArticulos.class.getName();
			String url = 
					"ejb:" + earAppName + "/" + ejbModuleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

			System.out.println("Looking EJB via JNDI");
			System.out.println(url);

			servicioArticulos = (ServicioArticulos) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
			System.out.println("Entro en exception");
		}
	}
	
	@Override
	public void ingresarArticulo(ArticuloVO articulo) {
		servicioArticulos.ingresarArticulo(articulo);
	}

	@Override
	public Boolean recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo) {
		return servicioArticulos.recepcionArticulosParaDespachar(solicitudArticulo);
	}

}
