package despacho.backend.api;

import java.util.Map.Entry;
import java.util.Set;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import despacho.backend.utils.Configuracion;

@Path("/configuracion")
public class ConfiguracionApiController {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Set<Entry<String, String>> getUsuarios() throws NamingException {
		return Configuracion.getInstancia().get().entrySet();
	}
}
