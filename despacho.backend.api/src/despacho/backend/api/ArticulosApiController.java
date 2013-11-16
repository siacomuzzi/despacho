package despacho.backend.api;

import javax.ejb.EJB;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import despacho.backend.servicios.*;

@Path("/articulos")
public class ArticulosApiController {
	
	@EJB
	private ServicioArticulos servicioArticulos;
	
	@POST
	@Path("/paraDespachar") 
	@Consumes(MediaType.APPLICATION_JSON)
	// DCH03.Recepción y Procesamiento de Artículos a Despachar
	public Response recepcionArticulosParaDespachar() throws NamingException {
		
		// TODO: definir que parametros recibe
		servicioArticulos.recepcionArticulosParaDespachar();
		
		return Response.status(200).entity("Recepcion procesada exitosamente!").build();
	}
}
