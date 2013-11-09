package despacho.backend.entities;

import javax.persistence.*;

@Entity
@Table(name = "DEPOSITO")
public class Deposito {
	
	private String nombre;
	
	public Deposito() {
		this.nombre = "";
	}
	
	public Deposito(String nombre) {
		this.nombre = nombre;
	}
	
	@Id
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
