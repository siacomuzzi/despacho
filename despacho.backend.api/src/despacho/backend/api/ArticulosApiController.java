package despacho.backend.api;

import javax.naming.NamingException; 
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/articulos")
public class ArticulosApiController {
	
	@POST 
	@Path("/paraDespachar") 
	@Consumes(MediaType.APPLICATION_JSON)
	// DCH03.Recepción y Procesamiento de Artículos a Despachar
	public Response recepcionArticulosParaDespachar() throws NamingException {

		return Response.status(200).entity("Recepcion lista!").build(); 
	}
}
