package despacho.backend.administradores;

import javax.ejb.Local;

import despacho.backend.entities.Articulo;

@Local
public interface AdministradorArticulos {
	void agregar(Articulo articulo);
	
	Articulo get(String id);
}
