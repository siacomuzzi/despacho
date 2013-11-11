package despacho.backend.administradores;

import javax.ejb.Local;

import despacho.backend.entities.Articulo;
import despacho.backend.entities.SolicitudArticulo;

@Local
public interface AdministradorArticulos {
	void agregar(Articulo articulo);
	
	void guardarSolicitud(SolicitudArticulo solicitud);
	
	Articulo get(String id);
}
