package despacho.backend.services;

import javax.ejb.Stateless;

@Stateless
public class AdministradorArticulosBean implements AdministradorArticulos {
	
	public void guardarArticuloNuevo(Object articulo) {
		// Se debe registrar dicho artículo junto con la información del Módulo Depósito.
	}
	
	public void guardarArticuloADespachar() {
		// Registra la Recepción de Stock y se debe procesar las Ordenes de Despacho Pendientes de Entrega. 
		// Se deberá procesar primero las Órdenes de Despacho más antiguas.
	}
}
