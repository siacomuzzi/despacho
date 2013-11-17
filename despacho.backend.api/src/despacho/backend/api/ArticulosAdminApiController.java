package despacho.backend.api;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import despacho.backend.entities.Articulo;

@Path("/articulos")
public class ArticulosAdminApiController {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<Articulo> getArticulos() throws NamingException {
		return ArticulosAdminBusinessDelegate.getInstance().listar();
	}
}
