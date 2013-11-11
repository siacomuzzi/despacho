package despacho.backend.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOLICITUD_ARTICULO")
public class SolicitudArticulo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private ArticuloOrdenDespacho articuloOrdenDespacho;
	private String estado;
	private String deposito;
	
	public SolicitudArticulo() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArticuloOrdenDespacho getArticuloOrdenDespacho() {
		return articuloOrdenDespacho;
	}

	public void setArticuloOrdenDespacho(ArticuloOrdenDespacho articuloOrdenDespacho) {
		this.articuloOrdenDespacho = articuloOrdenDespacho;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDeposito() {
		return deposito;
	}

	public void setDeposito(String deposito) {
		this.deposito = deposito;
	}
}
