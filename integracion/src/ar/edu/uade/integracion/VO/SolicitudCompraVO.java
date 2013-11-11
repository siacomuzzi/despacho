package ar.edu.uade.integracion.VO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SolicitudCompraVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idSolicitudCompra;
	
	private String idSolicitudArticulo;

	private Date fecha;

	private String idDeposito;

	private String estado;

	private List<ItemSolicitudCompraVO> articulos;
	
	public SolicitudCompraVO(){}

	public String getIdSolicitudCompra() {
		return idSolicitudCompra;
	}

	public void setIdSolicitudCompra(String idSolicitudCompra) {
		this.idSolicitudCompra = idSolicitudCompra;
	}

	public String getIdSolicitudArticulo() {
		return idSolicitudArticulo;
	}

	public void setIdSolicitudArticulo(String idSolicitudArticulo) {
		this.idSolicitudArticulo = idSolicitudArticulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getIdDeposito() {
		return idDeposito;
	}

	public void setIdDeposito(String idDeposito) {
		this.idDeposito = idDeposito;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ItemSolicitudCompraVO> getArticulos() {
		return articulos;
	}

	public void setArticulos(List<ItemSolicitudCompraVO> articulos) {
		this.articulos = articulos;
	}



}
