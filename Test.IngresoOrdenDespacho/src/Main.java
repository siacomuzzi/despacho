import despacho.backend.servicios.*;

public class Main {

	public static void main(String[] args) {
		try {
			// DCH01.Recibir nuevo Artículo
			ServicioArticulosBean articulosPort = new ServicioArticulosBeanServiceLocator().getServicioArticulosBeanPort();
			
			AtributoVO atributo11 = new AtributoVO();
			atributo11.setNombre("Peso");
			atributo11.setValor("85 kg");
			
			AtributoVO atributo12 = new AtributoVO();
			atributo12.setNombre("Capacidad");
			atributo12.setValor("500 lts");
			
			ArticuloVO articulo1 = new ArticuloVO();
			articulo1.setAtributos(new AtributoVO[] { atributo11, atributo12 });;
			articulo1.setCategoria("Electrodomesticos");
			articulo1.setDescripcion("Que heladera!");
			articulo1.setFoto("http://lalala.com/helader.png");
			articulo1.setIdarticulo("DEPOC1");
			articulo1.setIdDeposito("DepositoC");
			articulo1.setMarca("Whirlpool");
			articulo1.setNombre("Heladera");
			articulo1.setOrigen("Brasil");
			articulo1.setPrecio(9999);
			articulo1.setStock(10);
			
			//articulosPort.ingresarArticulo(articulo1);
			
			// DCH02.Recepción y Procesamiento de Orden de Despacho
			ServicioOrdenesDespacho ordenesDespachoPort = new ServicioOrdenesDespachoBeanServiceLocator().getServicioOrdenesDespachoPort();
			
			ItemSolicitudArticuloVO solicitudArticulo1 = new ItemSolicitudArticuloVO();
			solicitudArticulo1.setIdArticulo("DEPOC1");
			solicitudArticulo1.setCantSolicitada(2);
			
			OrdenDespachoVO ordenDespacho = new OrdenDespachoVO();
			ordenDespacho.setArticulos(new ItemSolicitudArticuloVO[] { solicitudArticulo1 });
			ordenDespacho.setCodOrden(1);
			ordenDespacho.setCodPortal(11);
			ordenDespacho.setCodVenta(111);
			ordenDespacho.setNombreUsuario("jperez");
			
			ordenesDespachoPort.ingresarOrdenDespacho(ordenDespacho);
			
			System.out.println("LISTO!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
