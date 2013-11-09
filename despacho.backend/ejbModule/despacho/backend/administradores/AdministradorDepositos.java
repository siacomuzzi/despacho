package despacho.backend.administradores;

import javax.ejb.Local;

import despacho.backend.entities.Deposito;

@Local
public interface AdministradorDepositos {
	void agregar(Deposito deposito);
	
	Deposito get(String id);
}
