import despacho.backend.servicios.*;


public class Main {

	public static void main(String[] args) {
		try {
			// DCH02.Recepción y Procesamiento de Orden de Despacho (desde LOGISTICA)
			ServicioOrdenesDespachoBean port = new ServicioOrdenesDespachoBeanServiceLocator().getServicioOrdenesDespachoBeanPort();
			
			ArticuloOrdenDespacho articulo1 = new ArticuloOrdenDespacho();
			articulo1.setCodigo("articulo01"); // articulo01 esta asociado al depositoA
			
			ArticuloOrdenDespacho articulo2 = new ArticuloOrdenDespacho();
			articulo2.setCodigo("articulo02"); // articulo02 esta asoaciado al depositoA
			
			OrdenDespacho orden = new OrdenDespacho();
			orden.setCodigo("orden-despacho-01");
			orden.setArticulos(new ArticuloOrdenDespacho[] { articulo1, articulo2 });
			
			port.ingresarOrdenDespacho(orden);
			
			// ASSERTS:
			//	- Cada articulo de la orden se envio a la queue del DEPOSITO correspondiente
			//	- La orden se guardo en la DB con el estado "pendientes de entrega"
			//	- Se debe registrar la solicitud por Deposito
			
			System.out.println("LISTO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
