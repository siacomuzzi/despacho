package despacho.backend.servicios;

import javax.ejb.*;

import ar.edu.uade.integracion.VO.OrdenDespachoVO;

@Remote
public interface ServicioOrdenesDespacho {
	void ingresarOrdenDespacho(OrdenDespachoVO ordenDespacho);
	
	void completarOrdenDespacho(int codigo);
}
