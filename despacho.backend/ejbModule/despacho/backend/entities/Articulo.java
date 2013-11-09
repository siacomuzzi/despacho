package despacho.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ARTICULO")
public class Articulo {
	
	private String codigo;
	private Deposito deposito;
	
	public Articulo() {
	}
	
	public Articulo(String codigo, Deposito deposito) {
		this.codigo = codigo;
		this.deposito = deposito;
	}
	
	@Id
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@ManyToOne
	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}
}
