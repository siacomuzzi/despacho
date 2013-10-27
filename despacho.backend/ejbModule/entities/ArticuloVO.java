package entities;

import java.io.Serializable;
import java.util.List;


public class ArticuloVO implements Serializable{


	private static final long serialVersionUID = 1L;

		private String idarticulo;
		
		private String nombre;
		
		private String descripcion;
		
		private String marca;
		
		private String foto;
		
		private String origen;
		
		private float precio;
		
		private String categoria;
		
		private int stock;

		private List<AtributoVO> atributos;
		
		private String idDeposito;
		
		public ArticuloVO(){}

		
		public String getIdarticulo() {
			return idarticulo;
		}



		public void setIdarticulo(String idarticulo) {
			this.idarticulo = idarticulo;
		}



		public String getNombre() {
			return nombre;
		}



		public void setNombre(String nombre) {
			this.nombre = nombre;
		}



		public String getDescripcion() {
			return descripcion;
		}



		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}



		public String getMarca() {
			return marca;
		}



		public void setMarca(String marca) {
			this.marca = marca;
		}



		public String getFoto() {
			return foto;
		}



		public void setFoto(String foto) {
			this.foto = foto;
		}



		public String getOrigen() {
			return origen;
		}



		public void setOrigen(String origen) {
			this.origen = origen;
		}



		public float getPrecio() {
			return precio;
		}



		public void setPrecio(float precio) {
			this.precio = precio;
		}



		public String getCategoria() {
			return categoria;
		}



		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}



		public int getStock() {
			return stock;
		}



		public void setStock(int stock) {
			this.stock = stock;
		}



		public List<AtributoVO> getAtributos() {
			return atributos;
		}



		public void setAtributos(List<AtributoVO> atributos) {
			this.atributos = atributos;
		}



		public String getIdDeposito() {
			return idDeposito;
		}



		public void setIdDeposito(String idDeposito) {
			this.idDeposito = idDeposito;
		}



		public String toString() {
			return "ArticuloVO [idarticulo=" + idarticulo + ", nombre="
					+ nombre + ", descripcion=" + descripcion + ", marca="
					+ marca + ", foto=" + foto + ", origen=" + origen
					+ ", precio=" + precio + ", categoria=" + categoria
					+ ", stock=" + stock + ", atributos=" + atributos + ", idDeposito=" + idDeposito
					+ "]";
		}

		

}
