package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente 
{

	@JsonProperty(value="CEDULA")
	private int cedula;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	@JsonProperty(value="APELLIDO")
	private String apellido;

	@JsonProperty(value="EDAD")
	private int edad;
	


	
	public Cliente(@JsonProperty(value="CEDULA")int cedula,@JsonProperty(value="NOMBRE")String nombre,
			@JsonProperty(value="APELLIDO")String apellido,@JsonProperty(value="EDAD") int edad) 
	{
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;

	
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

	
	public String getApellido() {
		return apellido;
	}

	
	public void setApellido(String name) {
		this.apellido = name;
	}

	public int getEdad() {
		return edad;
	}

	
	public void setEdad(int name) {
		this.edad = name;
	}
	
	

	

	
}
