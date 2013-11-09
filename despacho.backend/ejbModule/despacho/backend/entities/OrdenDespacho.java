package despacho.backend.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ORDEN_DESPACHO")
public class OrdenDespacho {
	
	private String codigo;
	private String estado;
	private List<ArticuloOrdenDespacho> articulos;
	
	public OrdenDespacho() {
	}
	
	public OrdenDespacho(String codigo) {
		this.codigo = codigo;
		this.estado = "";
		this.articulos = new ArrayList<ArticuloOrdenDespacho>();
	}

	@Id
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="ordenDespacho")
	public List<ArticuloOrdenDespacho> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ArticuloOrdenDespacho> articulos) {
		this.articulos = articulos;
	}
	
	public void setArticulo(ArticuloOrdenDespacho articulo) {
		if (articulo == null) {
			return;
		}
		
		this.articulos.add(articulo);
	}
}
