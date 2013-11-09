package despacho.backend.servicios;

import javax.ejb.*;

import despacho.backend.entities.*;

@Remote
public interface ServicioOrdenesDespacho {
	void ingresarOrdenDespacho(OrdenDespacho ordenDespacho);
	
	void completarOrdenDespacho(String codigo);
}
