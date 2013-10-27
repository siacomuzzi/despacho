package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SolicitudArticuloVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idSolicitudArticulo;

	private Date fecha;

	private String idDespacho;

	private List<ItemSolicitudArticuloVO> articulos;
	
	private String estado;
	
	
	public SolicitudArticuloVO(){}


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


	public String getIdDespacho() {
		return idDespacho;
	}


	public void setIdDespacho(String idDespacho) {
		this.idDespacho = idDespacho;
	}


	public List<ItemSolicitudArticuloVO> getArticulos() {
		return articulos;
	}


	public void setArticulos(List<ItemSolicitudArticuloVO> articulos) {
		this.articulos = articulos;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
