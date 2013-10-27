package services;

import javax.ejb.Local;


@Local
public interface AdministradorOrdenesDespacho {
	public void guardarOrden(Object ordenDespacho);
	
	public void cambiarEstado();
}
