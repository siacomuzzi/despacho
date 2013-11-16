package despacho.backend.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "ORDEN_DESPACHO")
public class OrdenDespacho {
	
	private int codOrden;
	private String nombreUsuario;
	private int codVenta;
	private int codPortal;
	private List<SolicitudArticulo> articulos;
	private String estado;
	private Date fecha;
	
	public OrdenDespacho() {
		this.fecha = new Date();
	}

	@Id
	public int getCodOrden() {
		return codOrden;
	}

	public void setCodOrden(int codOrden) {
		this.codOrden = codOrden;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public int getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}

	public int getCodPortal() {
		return codPortal;
	}

	public void setCodPortal(int codPortal) {
		this.codPortal = codPortal;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "codigoOrden")
	public List<SolicitudArticulo> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<SolicitudArticulo> articulos) {
		this.articulos = articulos;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
