package despacho.backend.api;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ar.edu.uade.integracion.VO.SolicitudArticuloVO;

@Path("/articulos")
public class ArticulosApiController {
	
	@POST
	@Path("/paraDespachar")
	@Consumes(MediaType.APPLICATION_JSON)
	// DCH03.Recepción y Procesamiento de Artículos a Despachar
	public Response recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo) throws NamingException {
		
		Boolean success = BusinessDelegate.getInstance().recepcionArticulosParaDespachar(solicitudArticulo);
		return Response.status(success ? 201 : 500).build();
	}
}
