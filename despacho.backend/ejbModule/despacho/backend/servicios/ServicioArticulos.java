package despacho.backend.servicios;

import javax.ejb.*;

import ar.edu.uade.integracion.VO.ArticuloVO;
import ar.edu.uade.integracion.VO.SolicitudArticuloVO;

@Remote
public interface ServicioArticulos {
	void ingresarArticulo(ArticuloVO articulo);
	
	Boolean recepcionArticulosParaDespachar(SolicitudArticuloVO solicitudArticulo);
}
