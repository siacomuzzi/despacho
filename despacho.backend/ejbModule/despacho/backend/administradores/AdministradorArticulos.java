package despacho.backend.administradores;

import java.util.List;

import javax.ejb.Local;

import despacho.backend.entities.Articulo;
import despacho.backend.entities.OrdenDespacho;
import despacho.backend.entities.SolicitudArticulo;

@Local
public interface AdministradorArticulos {
	List<Articulo> listar();
	
	void agregar(Articulo articulo);
	
	void guardarSolicitud(SolicitudArticulo solicitud);
	
	Articulo get(String id);
}
