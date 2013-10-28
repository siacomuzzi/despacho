package despacho.backend.services;

import javax.ejb.Local;

@Local
public interface AdministradorArticulos {
	void guardarArticuloNuevo(Object articulo);
	
	void guardarArticuloADespachar();
}
