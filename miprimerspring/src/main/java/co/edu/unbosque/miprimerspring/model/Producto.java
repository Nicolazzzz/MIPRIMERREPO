package co.edu.unbosque.miprimerspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // jakarta
@Table(name = "producto") // jakarta
public class Producto {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;	
	private String nombre;
	private String marca;
	private int costo;
	private int cantidad;
	
	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Producto(String nombre, String marca, int costo, int cantidad) {
		super();
		this.nombre = nombre;
		this.marca = marca;
		this.costo = costo;
		this.cantidad = cantidad;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", cantidad="
				+ cantidad + "]";
	}
	
	
}
