package despacho.backend.api;

import java.util.List;

import javax.naming.NamingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import despacho.backend.entities.SolicitudArticulo;

@Path("/solicitudes")
public class SolicitudesAdminApiController {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public List<SolicitudArticulo> getSolicitudes() throws NamingException {
		return ArticulosAdminBusinessDelegate.getInstance().listarSolicitudes();
	}
}
