package co.edu.unbosque.miprimerspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa un producto en el sistema.
 * Esta clase está mapeada a una tabla en la base de datos llamada "producto".
 * 
 * <p>Contiene los atributos necesarios para almacenar el nombre, marca, costo y cantidad de un producto.</p>
 * 
 * @author Nicolas Zambrano
 */
@Entity // jakarta
@Table(name = "producto") // jakarta
public class Producto {

    /**
     * Identificador único del producto.
     * Este atributo es la clave primaria de la entidad y es autogenerado.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;

    /**
     * Nombre del producto.
     */
    private String nombre;

    /**
     * Marca del producto.
     */
    private String marca;

    /**
     * Costo del producto.
     */
    private int costo;

    /**
     * Cantidad disponible del producto.
     */
    private int cantidad;

    /**
     * Constructor por defecto de la clase Producto.
     * <p>Este constructor es utilizado por JPA para crear una nueva instancia de Producto cuando se carga desde la base de datos.</p>
     */
    public Producto() {
        // Constructor vacío utilizado por JPA
    }

    /**
     * Constructor parametrizado para crear una nueva instancia de Producto.
     * 
     * @param nombre Nombre del producto.
     * @param marca Marca del producto.
     * @param costo Costo del producto.
     * @param cantidad Cantidad disponible del producto.
     */
    public Producto(String nombre, String marca, int costo, int cantidad) {
        super();
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el identificador único del producto.
     * 
     * @return El ID del producto.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único del producto.
     * 
     * @param id El ID del producto.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     * 
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param nombre El nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la marca del producto.
     * 
     * @return La marca del producto.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del producto.
     * 
     * @param marca La marca del producto.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el costo del producto.
     * 
     * @return El costo del producto.
     */
    public int getCosto() {
        return costo;
    }

    /**
     * Establece el costo del producto.
     * 
     * @param costo El costo del producto.
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la cantidad disponible del producto.
     * 
     * @return La cantidad disponible del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     * 
     * @param cantidad La cantidad disponible del producto.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Representa el producto como una cadena de texto.
     * 
     * @return Una representación en formato de cadena del producto, incluyendo todos sus atributos.
     */
    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", cantidad="
                + cantidad + "]";
    }
}
