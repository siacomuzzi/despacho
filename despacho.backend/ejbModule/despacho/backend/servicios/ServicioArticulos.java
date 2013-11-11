package despacho.backend.servicios;

import javax.ejb.*;

import despacho.backend.entities.*;

@Remote
public interface ServicioArticulos {
	void ingresarArticulo(Articulo articulo);
}
