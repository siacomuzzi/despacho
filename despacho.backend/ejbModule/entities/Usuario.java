package entities;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

@Entity
@Table(name = "USUARIO")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private Boolean activo;
	
	@Id
	@XmlElement
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	@XmlElement
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlElement
	@Column(name="activo", columnDefinition="bit")
	public Boolean getActivo() {
		return activo;
	}
	
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
}
