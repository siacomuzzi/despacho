package services;

import javax.ejb.Stateless;

@Stateless
public class AdministradorOrdenesDespachoBean implements AdministradorOrdenesDespacho {
	
	public void guardarOrden(Object ordenDespacho) {
		// - Las �rdenes de Despacho deben ser registradas en el sistema como pendientes de Entrega.
		// - Por cada art�culo, se debe obtener el Deposito que lo administra y solicitarlo asincr�nicamente
		// - Se debe registrar la solicitud de articulo por Deposito
	}
	
	public void cambiarEstado() {
		// Si el nuevo estado de la orden de despacho es "lista para entregar", se deber�:
		//	- Informar en comunicaci�n sincr�nica a los Portales.
		//  - Informar en comunicaci�n sincr�nica utilizando tecnolog�a REST y JSON al m�dulo Log�stica
		// El sistema debe registrar y cambiar de estado a la Orden de Despacho y marcarla como entregada
	}
}
