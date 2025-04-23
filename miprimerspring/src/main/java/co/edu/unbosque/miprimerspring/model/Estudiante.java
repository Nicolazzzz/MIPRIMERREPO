package co.edu.unbosque.miprimerspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa la información de un estudiante en el sistema.
 * Esta clase está mapeada a una tabla en la base de datos llamada "estudiante".
 * 
 * <p>Contiene los atributos necesarios para almacenar el nombre, documento, programa académico y semestre del estudiante.</p>
 * 
 * @author Nicolas Zambrano
 */
@Entity // jakarta
@Table(name = "estudiante") // jakarta
public class Estudiante {

    /**
     * Identificador único del estudiante.
     * Este atributo es la clave primaria de la entidad y es autogenerado.
     */
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;

    /**
     * Nombre completo del estudiante.
     */
    private String nombre;

    /**
     * Documento de identificación del estudiante.
     * Este campo es único en la base de datos.
     */
    @Column(name = "documentoestudiante", unique = true)
    private int documento;

    /**
     * Programa académico al que pertenece el estudiante.
     */
    private String programa;

    /**
     * Semestre actual en el que se encuentra el estudiante.
     */
    private int semestre;

    /**
     * Constructor por defecto de la clase Estudiante.
     * <p>Este constructor es utilizado por JPA para crear una nueva instancia de Estudiante cuando se carga desde la base de datos.</p>
     */
    public Estudiante() {
        // Constructor vacío utilizado por JPA
    }

    /**
     * Constructor parametrizado para crear una nueva instancia de Estudiante.
     * 
     * @param nombre Nombre completo del estudiante.
     * @param documento Documento de identificación del estudiante.
     * @param programa Programa académico del estudiante.
     * @param semestre Semestre actual del estudiante.
     */
    public Estudiante(String nombre, int documento, String programa, int semestre) {
        super();
        this.nombre = nombre;
        this.documento = documento;
        this.programa = programa;
        this.semestre = semestre;
    }

    /**
     * Obtiene el nombre del estudiante.
     * 
     * @return El nombre del estudiante.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del estudiante.
     * 
     * @param nombre El nombre del estudiante.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el documento de identificación del estudiante.
     * 
     * @return El documento de identificación del estudiante.
     */
    public int getDocumento() {
        return documento;
    }

    /**
     * Establece el documento de identificación del estudiante.
     * 
     * @param documento El documento de identificación del estudiante.
     */
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    /**
     * Obtiene el programa académico del estudiante.
     * 
     * @return El programa académico del estudiante.
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * Establece el programa académico del estudiante.
     * 
     * @param programa El programa académico del estudiante.
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    /**
     * Obtiene el semestre actual del estudiante.
     * 
     * @return El semestre actual del estudiante.
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * Establece el semestre actual del estudiante.
     * 
     * @param semestre El semestre actual del estudiante.
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
