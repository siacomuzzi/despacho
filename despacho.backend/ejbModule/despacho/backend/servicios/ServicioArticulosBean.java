package despacho.backend.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ar.edu.uade.integracion.VO.ArticuloVO;
import ar.edu.uade.integracion.VO.AtributoVO;
import despacho.backend.administradores.AdministradorArticulos;
import despacho.backend.entities.Articulo;
import despacho.backend.entities.ArticuloAtributo;
import despacho.backend.utils.Logger;

@Stateless
public class ServicioArticulosBean implements ServicioArticulos {

	@EJB
	private AdministradorArticulos administradorArticulos;
	
	@Override
	// DCH01.Recibir nuevo Artículo
	public void ingresarArticulo(ArticuloVO articulo) {
		try {
			if (articulo == null) {
				return;
			}
			
			Logger.info("Nuevo articulo ingresado: " + articulo.getIdarticulo() + " - Deposito: " + articulo.getIdDeposito());
			
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
			
			Logger.info("Listo (DCH01 - Recibir nuevo Artículo)");
		}
		catch (Exception e) {
			e.printStackTrace();
			Logger.error(e.getMessage());
		}
	}
}
