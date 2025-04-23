package co.edu.unbosque.miprimerspring.dto;

/**
 * DTO (Data Transfer Object) que representa la información de un producto.
 * Contiene los campos necesarios para almacenar los datos de un producto en el sistema.
 * 
 * <p>La clase incluye atributos como el ID del producto, su nombre, marca, costo y cantidad disponible.</p>
 * <p>También proporciona los métodos getters y setters para acceder y modificar estos valores, 
 * así como un método {@code toString()} para representar la información del producto como una cadena.</p>
 * 
 * @author Nicolas Zambrano
 */
public class ProductoDTO {

    /**
     * Identificador único del producto.
     */
    private int id;

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
     * Constructor de la clase ProductoDTO con parámetros.
     * 
     * <p>Este constructor permite inicializar todos los atributos del producto al crear una nueva instancia.</p>
     * 
     * @param nombre El nombre del producto.
     * @param marca La marca del producto.
     * @param costo El costo del producto.
     * @param cantidad La cantidad disponible del producto.
     */
    public ProductoDTO(String nombre, String marca, int costo, int cantidad) {
        super();
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    /**
     * Constructor por defecto de la clase ProductoDTO.
     * <p>Este constructor es utilizado para crear una instancia vacía de ProductoDTO, sin parámetros.</p>
     */
    public ProductoDTO() {
        // Constructor vacío generado automáticamente
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
     * @return La cantidad del producto disponible.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad disponible del producto.
     * 
     * @param cantidad La cantidad del producto disponible.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Devuelve una representación en cadena de la información del producto.
     * 
     * @return Una cadena que representa el producto en formato de texto.
     */
    @Override
    public String toString() {
        return "ProductoDTO [id=" + id + ", nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", cantidad="
                + cantidad + "]";
    }

}
