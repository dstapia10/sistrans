
package vos;

import org.codehaus.jackson.annotate.*;


public class Actor {

	//// Atributos

	@JsonProperty(value="CEDULA")
	private int cedula;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	@JsonProperty(value="ID_COMPA�IA")
	private int idcompa�ia;

	@JsonProperty(value="NACIONALIDAD")
	private String nacionalidad;


	
	public Actor(@JsonProperty(value="CEDULA")int cedula,@JsonProperty(value="ID_COMPA�IA")int idcompa�ia, @JsonProperty(value="NOMBRE")String nombre,@JsonProperty(value="NACIONALIDAD") String nacionalidad) 
	{
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.idcompa�ia = idcompa�ia;
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
		return idcompa�ia;
	}

	
	public void setName(int name) {
		this.idcompa�ia = name;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	
	public void setNacionalidad(String name) {
		this.nacionalidad = name;
	}


}
