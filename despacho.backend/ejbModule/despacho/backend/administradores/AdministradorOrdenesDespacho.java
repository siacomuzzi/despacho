package despacho.backend.administradores;

import java.util.List;

import javax.ejb.*;

import despacho.backend.entities.*;

@Local
public interface AdministradorOrdenesDespacho {
	void agregar(OrdenDespacho ordenDespacho);
	
	List<OrdenDespacho> listar();
	
	void actualizar(OrdenDespacho ordenDespacho);
	
	OrdenDespacho get(String id);
}
