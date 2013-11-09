package despacho.backend.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "ARTICULO_ORDEN_DESPACHO")
public class ArticuloOrdenDespacho implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String codigo;
	private String ordenDespacho;
	private Deposito deposito;
	
	public ArticuloOrdenDespacho() {
	}
	
	public ArticuloOrdenDespacho(String codigo) {
		this.codigo = codigo;
		this.deposito = new Deposito();
	}
	
	@Id
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getOrdenDespacho() {
		return ordenDespacho;
	}

	public void setOrdenDespacho(String ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}

	@ManyToOne
	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}	
}
