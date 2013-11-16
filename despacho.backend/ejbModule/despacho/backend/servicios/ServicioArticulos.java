package despacho.backend.servicios;

import javax.ejb.*;

import ar.edu.uade.integracion.VO.ArticuloVO;

@Remote
public interface ServicioArticulos {
	void ingresarArticulo(ArticuloVO articulo);
}
