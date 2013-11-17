package despacho.backend.api;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import despacho.backend.administradores.AdministradorUsuarios;
import despacho.backend.entities.Usuario;

public class UsuariosBusinessDelegate implements AdministradorUsuarios {
	
	static UsuariosBusinessDelegate instancia = null;
	AdministradorUsuarios administradorUsuarios;
	
	public static UsuariosBusinessDelegate getInstance() throws NamingException {
		if (instancia == null) {
			instancia= new UsuariosBusinessDelegate();
		}
		
		return instancia;
	}
	
	private UsuariosBusinessDelegate() throws NamingException {

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
			final String beanName = "AdministradorUsuariosBean";
			final String viewClassName = AdministradorUsuarios.class.getName();
			String url = 
					"ejb:" + earAppName + "/" + ejbModuleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

			System.out.println("Looking EJB via JNDI");
			System.out.println(url);

			administradorUsuarios = (AdministradorUsuarios) context.lookup(url);

		} catch (Exception e) {
			e.getCause();
		}
	}

	@Override
	public void agregar(Usuario usuario) {
		this.administradorUsuarios.agregar(usuario);
	}

	@Override
	public List<Usuario> listar() {
		return this.administradorUsuarios.listar();
	}

	@Override
	public void actualizar(Usuario usuario) {
		this.administradorUsuarios.actualizar(usuario);
	}

	@Override
	public Usuario get(String username) {
		return this.administradorUsuarios.get(username);
	}

	@Override
	public void eliminar(String username) {
		this.administradorUsuarios.eliminar(username);
	}
}

