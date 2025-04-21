package co.edu.unbosque.miprimerspring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // jakarta
@Table(name = "estudiante") // jakarta
public class Estudiante {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	private String nombre;
	@Column(name = "documentoestudiante", unique = true)
	private int documento;
	private String programa;
	private int semestre;

	public Estudiante() {// entidad

	}

	public Estudiante( String nombre, int documento, String programa, int semestre) {
		super();
	
		this.nombre = nombre;
		this.documento = documento;
		this.programa = programa;
		this.semestre = semestre;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getPrograma() {
		return programa;
	}

	public void setPrograma(String programa) {
		this.programa = programa;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
}
