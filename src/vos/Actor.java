
package vos;

import org.codehaus.jackson.annotate.*;


public class Actor {

	//// Atributos

	@JsonProperty(value="CEDULA")
	private int cedula;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	@JsonProperty(value="ID_COMPAÑIA")
	private int idcompañia;

	@JsonProperty(value="NACIONALIDAD")
	private String nacionalidad;


	
	public Actor(@JsonProperty(value="CEDULA")int cedula,@JsonProperty(value="ID_COMPAÑIA")int idcompañia, @JsonProperty(value="NOMBRE")String nombre,@JsonProperty(value="NACIONALIDAD") String nacionalidad) 
	{
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.idcompañia = idcompañia;
		this.nacionalidad = nacionalidad;
	}
	

	public int getCedula() {
		return cedula;
	}


	public void setCedula(int duration) {
		this.cedula = duration;
	}


	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String id) {
		this.nombre = id;
	}

	
	public int getIdCompania() {
		return idcompañia;
	}

	
	public void setName(int name) {
		this.idcompañia = name;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	
	public void setNacionalidad(String name) {
		this.nacionalidad = name;
	}


}
