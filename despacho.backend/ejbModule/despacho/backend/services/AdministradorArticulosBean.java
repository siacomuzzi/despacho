package despacho.backend.services;

import javax.ejb.Stateless;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	public void guardarArticuloNuevo(Object articulo) {
		// Se debe registrar dicho art�culo junto con la informaci�n del M�dulo Dep�sito.
	}
	
	public void guardarArticuloADespachar() {
		// Registra la Recepci�n de Stock y se debe procesar las Ordenes de Despacho Pendientes de Entrega. 
		// Se deber� procesar primero las �rdenes de Despacho m�s antiguas.
	}
}
