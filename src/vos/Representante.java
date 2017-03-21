
package vos;

import org.codehaus.jackson.annotate.*;


public class Representante {

	//// Atributos

	@JsonProperty(value="CEDULA")
	private int cedula;


	@JsonProperty(value="NOMBRE")
	private String nombre;
	
	
	public Representante(@JsonProperty(value="CEDULA")int cedula, @JsonProperty(value="NOMBRE")String nombre) 
	{
		super();
		this.cedula = cedula;
		this.nombre = nombre;

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

	
}
