package co.edu.unbosque.miprimerspring.dto;

/**
 * DTO (Data Transfer Object) que representa la información de un estudiante.
 * Contiene los campos necesarios para almacenar los datos de un estudiante en el sistema.
 * 
 * <p>La clase incluye los atributos de un estudiante como el nombre, documento,
 * programa académico y semestre, junto con sus respectivos métodos getters y setters
 * para acceder y modificar estos valores.</p>
 * 
 * <p>El identificador único (ID) del estudiante también se maneja a través de este DTO.</p>
 * 
 * @author Nicolas Zambrano
 */
public class EstudianteDTO {

    /**
     * Identificador único del estudiante.
     */
    private Integer id;

    /**
     * Nombre completo del estudiante.
     */
    private String nombre;

    /**
     * Documento de identificación del estudiante.
     */
    private int documento;

    /**
     * Programa académico en el que está inscrito el estudiante.
     */
    private String programa;

    /**
     * Semestre actual en el que se encuentra el estudiante.
     */
    private int semestre;

    /**
     * Constructor por defecto de la clase EstudianteDTO.
     * <p>Este constructor es utilizado para crear una instancia vacía de EstudianteDTO, sin parámetros.</p>
     */
    public EstudianteDTO() {

    }

    /**
     * Constructor de la clase EstudianteDTO con parámetros.
     * <p>Este constructor permite inicializar todos los atributos de un estudiante al crear una nueva instancia.</p>
     * 
     * @param nombre El nombre completo del estudiante.
     * @param documento El número de documento de identificación del estudiante.
     * @param programa El programa académico en el que está inscrito el estudiante.
     * @param semestre El semestre en el que se encuentra el estudiante.
     */
    public EstudianteDTO(String nombre, int documento, String programa, int semestre) {
        super();
        this.nombre = nombre;
        this.documento = documento;
        this.programa = programa;
        this.semestre = semestre;
    }

    /**
     * Obtiene el nombre completo del estudiante.
     * 
     * @return El nombre completo del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre completo del estudiante.
     * 
     * @param nombre El nombre completo del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el documento de identificación del estudiante.
     * 
     * @return El número de documento del estudiante.
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * Establece el documento de identificación del estudiante.
     * 
     * @param documento El número de documento de identificación del estudiante.
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el programa académico en el que está inscrito el estudiante.
     * 
     * @return El programa académico del estudiante.
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Establece el programa académico en el que está inscrito el estudiante.
     * 
     * @param programa El programa académico del estudiante.
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * Obtiene el semestre en el que se encuentra el estudiante.
     * 
     * @return El semestre del estudiante.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre en el que se encuentra el estudiante.
     * 
     * @param semestre El semestre del estudiante.
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * Obtiene el identificador único del estudiante.
     * 
     * @return El ID del estudiante.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Establece el identificador único del estudiante.
     * 
     * @param id El ID del estudiante.
     */
    public void setId(Integer id) {
        this.id = id;
    }

}
