package despacho.backend.administradores;

import java.util.List;

import javax.ejb.*;

import despacho.backend.entities.*;

@Local
public interface AdministradorOrdenesDespacho {
	void agregar(OrdenDespacho ordenDespacho);
	
	List<OrdenDespacho> listar();
	
	List<OrdenDespacho> listarPorEstado(String estado);
	
	void actualizar(OrdenDespacho ordenDespacho);
	
	OrdenDespacho get(int id);
}
