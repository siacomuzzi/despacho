package services;

import javax.ejb.Stateless;

@Stateless
public class AdministradorOrdenesDespachoBean implements AdministradorOrdenesDespacho {
	
	public void guardarOrden(Object ordenDespacho) {
		// - Las órdenes de Despacho deben ser registradas en el sistema como pendientes de Entrega.
		// - Por cada artículo, se debe obtener el Deposito que lo administra y solicitarlo asincrónicamente
		// - Se debe registrar la solicitud de articulo por Deposito
	}
	
	public void cambiarEstado() {
		// Si el nuevo estado de la orden de despacho es "lista para entregar", se deberá:
		//	- Informar en comunicación sincrónica a los Portales.
		//  - Informar en comunicación sincrónica utilizando tecnología REST y JSON al módulo Logística
		// El sistema debe registrar y cambiar de estado a la Orden de Despacho y marcarla como entregada
	}
}
