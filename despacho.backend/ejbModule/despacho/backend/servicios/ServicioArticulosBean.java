package despacho.backend.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ar.edu.uade.integracion.VO.ArticuloVO;
import ar.edu.uade.integracion.VO.AtributoVO;
import despacho.backend.administradores.AdministradorArticulos;
import despacho.backend.entities.Articulo;
import despacho.backend.entities.ArticuloAtributo;
import despacho.backend.utils.Logger;

@Stateless
@WebService
public class ServicioArticulosBean implements ServicioArticulos {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	@Override
	@WebMethod
	// DCH01.Recibir nuevo Artículo
	public void ingresarArticulo(ArticuloVO articulo) {
		try {
			if (articulo == null) {
				return;
			}
			
			Logger.info("DCH01", "Nuevo articulo ingresado: " + articulo.getIdarticulo() + " - Deposito: " + articulo.getIdDeposito());
			
			// Persistir el articulo
			List<ArticuloAtributo> nuevoArticuloAtributos = new ArrayList<ArticuloAtributo>();
			
			for (AtributoVO atributo: articulo.getAtributos()) {
				ArticuloAtributo nuevoArticuloAtributo = new ArticuloAtributo();
				nuevoArticuloAtributo.setNombre(atributo.getNombre());
				nuevoArticuloAtributo.setValor(atributo.getValor());
				nuevoArticuloAtributos.add(nuevoArticuloAtributo);
			}
			
			Articulo nuevoArticulo = new Articulo();
			nuevoArticulo.setCategoria(articulo.getCategoria());
			nuevoArticulo.setDescripcion(articulo.getDescripcion());
			nuevoArticulo.setFoto(articulo.getFoto());
			nuevoArticulo.setIdArticulo(articulo.getIdarticulo());
			nuevoArticulo.setIdDeposito(articulo.getIdDeposito());
			nuevoArticulo.setMarca(articulo.getMarca());
			nuevoArticulo.setNombre(articulo.getNombre());
			nuevoArticulo.setOrigen(articulo.getOrigen());
			nuevoArticulo.setPrecio(articulo.getPrecio());
			nuevoArticulo.setStock(articulo.getStock());
			nuevoArticulo.setAtributos(nuevoArticuloAtributos);
			
			this.administradorArticulos.agregar(nuevoArticulo);
			
			Logger.info("DCH01", "Listo (DCH01 - Recibir nuevo Artículo)");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH01", e.getMessage());
		}
	}
	
	@Override
	// DCH03.Recepción y Procesamiento de Artículos a Despachar
	public void recepcionArticulosParaDespachar() {
		try {
			Logger.info("DCH03", "");
			
			// TODO
			
			Logger.info("DCH03", "Listo (DCH03 - Recepción y Procesamiento de Artículos a Despachar)");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error("DCH31", e.getMessage());
		}
	}
}
